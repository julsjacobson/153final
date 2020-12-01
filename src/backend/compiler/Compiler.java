package backend.compiler;

import antlr4.*;
import antlr4.PascatParser.PawcedureCallStatementContext;
import antlr4.PascatParser.PawgramContext;
import intermediate.symtab.*;
import intermediate.symtab.Predefined;

/**
 * Compile Pascal to Jasmin assembly language.
 */
public class Compiler extends PascatBaseVisitor<Object>
{
    private SymtabEntry programId;  // symbol table entry of the program name
    private String programName;     // the program name
    
    private CodeGenerator       code;            // base code generator
    private ProgramGenerator    programCode;     // program code generator
    private StatementGenerator  statementCode;   // statement code generator
    private ExpressionGenerator expressionCode;  // expression code generator
    
    /**
     * Constructor for the base compiler.
     * @param programId the symtab entry for the program name.
     */
    public Compiler(SymtabEntry programId)
    {
        this.programId = programId;        
        programName = programId.getName();
        
        code = new CodeGenerator(programName, "j", this);
    }
    
    /**
     * Constructor for child compilers of procedures and functions.
     * @param parent the parent compiler.
     */
    public Compiler(Compiler parent)
    {
        this.code        = parent.code;
        this.programCode = parent.programCode;
        this.programId   = parent.programId;
        this.programName = parent.programName;
    }
    
    /**
     * Constructor for child compilers of records.
     * @param parent the parent compiler.
     * @param recordId the symbol table entry of the name of the record to compile.
     */
    public Compiler(Compiler parent, SymtabEntry recordId)
    {        
        String recordTypePath = recordId.getType().getRecordTypePath();
        code = new CodeGenerator(recordTypePath, "j", this);
        createNewGenerators(code);
        
        programCode.emitRecord(recordId, recordTypePath);
    }
    
    /**
     * Create new child code generators.
     * @param parentGenerator the parent code generator.
     */
    private void createNewGenerators(CodeGenerator parentGenerator)
    {
        programCode    = new ProgramGenerator(parentGenerator, this);
        statementCode  = new StatementGenerator(programCode, this);
        expressionCode = new ExpressionGenerator(programCode, this);
    }

    /**
     * Get the name of the object (Jasmin) file.
     * @return the name.
     */
    public String getObjectFileName() { return code.getObjectFileName(); }
    
    @Override 
    public Object visitPawgram(PascatParser.PawgramContext ctx) 
    { 
        createNewGenerators(code);
        programCode.emitProgram(ctx);
        return null;
    }

    @Override 
    public Object visitRoutineDefinition(
                                    PascatParser.RoutineDefinitionContext ctx) 
    {
        createNewGenerators(programCode);
        programCode.emitRoutine(ctx);
        return null;
    }
    
    @Override 
    public Object visitStatement(PascatParser.StatementContext ctx) 
    {
        if (   (ctx.compoundStatement() == null) 
            && (ctx.emptyStatement() == null))
        {
            statementCode.emitComment(ctx);
        }
        
        return visitChildren(ctx);
    }

    @Override 
    public Object visitAssignmentStatement(
                                    PascatParser.AssignmentStatementContext ctx) 
    {
        statementCode.emitAssignment(ctx);
        return null;
    }

    @Override 
    public Object visitIfStatement(PascatParser.IfStatementContext ctx) 
    {
        statementCode.emitIf(ctx);
        return null;
    }

    @Override 
    public Object visitClawStatement(PascatParser.ClawStatementContext ctx) 
    {
        statementCode.emitCase(ctx);
        return null;
    }

    @Override 
    public Object visitRepeatStatement(PascatParser.RepeatStatementContext ctx) 
    {
        statementCode.emitRepeat(ctx);
        return null;
    }

    @Override 
    public Object visitWhileStatement(PascatParser.WhileStatementContext ctx) 
    {
        statementCode.emitWhile(ctx);
        return null;
    }

    @Override 
    public Object visitFurStatement(PascatParser.FurStatementContext ctx) 
    {
        statementCode.emitFor(ctx);
        return null;
    }

    @Override 
    public Object visitPawcedureCallStatement(
                                PawcedureCallStatementContext ctx) 
    {
        statementCode.emitProcedureCall(ctx);
        return null;
    }

    @Override 
    public Object visitExpression(PascatParser.ExpressionContext ctx) 
    {
        expressionCode.emitExpression(ctx);
        return null;
    }

    @Override 
    public Object visitVariableFactor(PascatParser.VariableFactorContext ctx) 
    {
        expressionCode.emitLoadValue(ctx.variable());
        return null;
    }

    @Override 
    public Object visitVariable(PascatParser.VariableContext ctx) 
    {
        expressionCode.emitLoadVariable(ctx);        
        return null;
    }

    @Override 
    public Object visitNumberFactor(PascatParser.NumberFactorContext ctx) 
    {
        if (ctx.type == Predefined.integerType) 
        {
            expressionCode.emitLoadIntegerConstant(ctx.number());
        }
        else
        {
            expressionCode.emitLoadRealConstant(ctx.number());
        }
        
        return null;
    }

    @Override 
    public Object visitCharacterFactor(PascatParser.CharacterFactorContext ctx) 
    {
        char ch = ctx.getText().charAt(1);
        expressionCode.emitLoadConstant(ch);

        return null;
    }

    @Override 
    public Object visitStringFactor(PascatParser.StringFactorContext ctx) 
    {
        String jasminString = convertString(ctx.getText());
        expressionCode.emitLoadConstant(jasminString);
        
        return null;
    }
    
    /**
     * Convert a Pascal string to a Java string.
     * @param pascalString the Pascal string.
     * @return the Java string.
     */
    String convertString(String pascalString)
    {
        String unquoted = pascalString.substring(1, pascalString.length()-1);
        return unquoted.replace("''", "'").replace("\"", "\\\"");
    }

    @Override 
    public Object visitFunctionCallFactor(
                                    PascatParser.FunctionCallFactorContext ctx) 
    {
        statementCode.emitFunctionCall(ctx.functionCall());
        return null;
    }

    @Override 
    public Object visitNotFactor(PascatParser.NotFactorContext ctx) 
    {
        expressionCode.emitNotFactor(ctx);
        return null;
    }

    @Override 
    public Object visitParenthesizedFactor(
                                    PascatParser.ParenthesizedFactorContext ctx) 
    {
        return visit(ctx.expression());
    }

    @Override 
    public Object visitMeowStatement(PascatParser.MeowStatementContext ctx) 
    {
        statementCode.emitWrite(ctx);
        return null;
    }

    @Override 
    public Object visitMeowlnStatement(PascatParser.MeowlnStatementContext ctx) 
    {
        statementCode.emitWriteln(ctx);
        return null;
    }

    @Override 
    public Object visitReadStatement(PascatParser.ReadStatementContext ctx) 
    {
        statementCode.emitRead(ctx);
        return null;
    }

    @Override 
    public Object visitReadlnStatement(PascatParser.ReadlnStatementContext ctx) 
    {
        statementCode.emitReadln(ctx);
        return null;
    }
}
