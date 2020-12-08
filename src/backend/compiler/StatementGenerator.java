package backend.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

//import org.graalvm.compiler.code.CompilationResult.JumpTable;

import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import antlr4.PascatParser;
import antlr4.PascatParser.ClawBranchContext;
import antlr4.PascatParser.ClawConstantContext;
import antlr4.PascatParser.MeowArgumentContext;
import antlr4.PascatParser.MeowArgumentsContext;
import intermediate.symtab.*;
import intermediate.type.*;
import intermediate.type.Typespec.Form;

import static intermediate.type.Typespec.Form.*;
import static backend.compiler.Instruction.*;

/**
 * <h1>StatementGenerator</h1>
 *
 * <p>Emit code for executable statements.</p>
 *
 * <p>Copyright (c) 2020 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class StatementGenerator extends CodeGenerator
{
    /**
     * Constructor.
     * @param parent the parent generator.
     * @param compiler the compiler to use.
     */
    public StatementGenerator(CodeGenerator parent, Compiler compiler)
    {
        super(parent, compiler);
    }

    /**
     * Emit code for an assignment statement.
     * @param ctx the AssignmentStatementContext.
     */
    public void emitAssignment(PascatParser.AssignmentStatementContext ctx)
    {
        PascatParser.VariableContext   varCtx  = ctx.lhs().variable();
        PascatParser.ExpressionContext exprCtx = ctx.rhs().expression();
        SymtabEntry varId = varCtx.entry;
        Typespec varType  = varCtx.type;
        Typespec exprType = exprCtx.type;

        // The last modifier, if any, is the variable's last subscript or field.
        int modifierCount = varCtx.modifier().size();
        PascatParser.ModifierContext lastModCtx = modifierCount == 0
                            ? null : varCtx.modifier().get(modifierCount - 1);

        // The target variable has subscripts and/or fields.
        if (modifierCount > 0) 
        {
            lastModCtx = varCtx.modifier().get(modifierCount - 1);
            compiler.visit(varCtx);
        }
        
        // Emit code to evaluate the expression.
        compiler.visit(exprCtx);
        
        // float variable := integer constant
        if (   (varType == Predefined.realType)
            && (exprType.baseType() == Predefined.integerType)) emit(I2F);
        
        // Emit code to store the expression value into the target variable.
        // The target variable has no subscripts or fields.
        if (lastModCtx == null) emitStoreValue(varId, varId.getType());

        // The target variable is a field.
        else if (lastModCtx.field() != null)
        {
            emitStoreValue(lastModCtx.field().entry, lastModCtx.field().type);
        }

        // The target variable is an array element.
        else
        {
            emitStoreValue(null, varType);
        }
    }

    /**
     * Emit code for an IF statement.
     * @param ctx the IfStatementContext.
     */
   public void emitIf(PascatParser.IfStatementContext ctx) {
		Label next_label = new Label(); 
		
		compiler.visit(ctx.expression()); 
		
		if (ctx.falseStatement() == null) {
			emit(IFEQ, next_label); 
			compiler.visit(ctx.trueStatement());
		} 
		else {
			Label falseLabel = new Label();
			emit(IFEQ, falseLabel); 
			compiler.visit(ctx.trueStatement()); 
			emit(GOTO, next_label); 
			emitLabel(falseLabel);
			compiler.visit(ctx.falseStatement()); 
		}
		emitLabel(next_label); // next-label
	}
    
    /**
     * Emit code for a CASE statement.
     * @param ctx the CaseStatementContext.
     */
    public void emitCase(PascatParser.ClawStatementContext ctx)
    {
        ctx.jumpTable = new TreeMap<Integer, PascatParser.StatementContext>(); 
        
        //branch's statement context to the jump label
        HashMap<PascatParser.StatementContext, Label> stmtLabelMap = new HashMap<>();

        for(ClawBranchContext branch : ctx.clawBranchList().clawBranch())
        {
            PascatParser.StatementContext stmtCtx = branch.statement();
            
            if(stmtCtx != null)
            {
                Label stmtLabel = new Label();
                stmtLabelMap.put(stmtCtx, stmtLabel);
                
                for(ClawConstantContext constCtx : branch.clawConstantList().clawConstant())
                	ctx.jumpTable.put(constCtx.value, stmtCtx);
                
            }
        }
        
        compiler.visit(ctx.expression()); 
        
        Label endLabel = new Label();
        
        emit(LOOKUPSWITCH);
        
        
        for(Integer i : ctx.jumpTable.keySet())
        {
            PascatParser.StatementContext stmtContext = ctx.jumpTable.get(i);
            Label stmtLabel = stmtLabelMap.get(stmtContext);
            
            emitLabel(i, stmtLabel); //INTEGER : LABEL
        }
        
        emitLabel("default", endLabel);

        for(PascatParser.StatementContext stmtCtx : stmtLabelMap.keySet())
        {
            emitLabel(stmtLabelMap.get(stmtCtx)); 
            compiler.visit(stmtCtx);
            emit(GOTO, endLabel); 
        }
        
        emitLabel(endLabel);
    }

    /**
     * Emit code for a REPEAT statement.
     * @param ctx the RepeatStatementContext.
     */
    public void emitRepeat(PascatParser.RepeatStatementContext ctx)
    {
        Label loopTopLabel  = new Label();
        Label loopExitLabel = new Label();

        emitLabel(loopTopLabel);
        
        compiler.visit(ctx.statementList());
        compiler.visit(ctx.expression());
        emit(IFNE, loopExitLabel);
        emit(GOTO, loopTopLabel);
        
        emitLabel(loopExitLabel);
    }
    
    /**
     * Emit code for a WHILE statement.
     * @param ctx the WhileStatementContext.
     */
    public void emitWhile(PascatParser.WhileStatementContext ctx)
    {
        /***** Complete this method. *****/       
        Label loopTopLabel  = new Label();
        Label loopExitLabel = new Label();
        
        emitLabel(loopTopLabel);
        
        compiler.visit(ctx.expression());
        emit(IFEQ, loopExitLabel); 
        
        compiler.visit(ctx.statement());
        
        emit(GOTO, loopTopLabel);
                   
        emitLabel(loopExitLabel);   
    }
    
    /**
     * Emit code for a FOR statement.
     * @param ctx the ForStatementContext.
     */
    public void emitFor(PascatParser.FurStatementContext ctx)
    {
        // Create labels
        Label loop_label = new Label(); 
        Label next_label = new Label(); 
        
        
        compiler.visit(ctx.expression(0));
        
        emitStoreValue(ctx.variable().entry, ctx.variable().type);
        
        emitLabel(loop_label); 
        
        compiler.visit(ctx.variable()); 
        compiler.visit(ctx.expression(1));
        
        if(ctx.TO() != null)
        {
            emit(IF_ICMPGT, next_label); 
        }
        else
        {
            emit(IF_ICMPLT, next_label); 
        }
        
        compiler.visit(ctx.statement()); 
        
        emitLoadValue(ctx.variable().entry);
        
        if(ctx.TO() != null)
        {
            emitLoadConstant(1); 
        }
        else
        {
            emitLoadConstant(-1);
        }
        
        emit(IADD); 
        
        emitStoreValue(ctx.variable().entry, ctx.variable().type); 
        
        emit(GOTO, loop_label);
        emitLabel(next_label);
    }
    
    /**
     * Emit code for a procedure call statement.
     * @param ctx the ProcedureCallStatementContext.
     */
     public void emitProcedureCall(PascatParser.PawcedureCallStatementContext ctx)
    {
        /***** Complete this method. *****/
    	SymtabEntry procedureEntry = ctx.pawcedureName().entry; 
    	
    	String procedureCall = routineHelper(procedureEntry, ctx.argumentList()); 
    	procedureCall += "V"; 
    	emit(INVOKESTATIC, procedureCall);
    }

    
    /**
     * Emit code for a function call statement.
     * @param ctx the FunctionCallContext.
     */
    public void emitFunctionCall(PascatParser.FunctionCallContext ctx)
    {
        SymtabEntry functionEntry = ctx.functionName().entry;
        
        String functionCall = routineHelper(functionEntry, ctx.argumentList());
        
        Typespec type = ctx.functionName().type;
        
        functionCall += typeDescriptor(type);
        
        emit(INVOKESTATIC, functionCall);
    }
    
    /**
     * Emits the code for the parameter of a routine and returns the name and parameters of the function in jasmin's syntax.
     * @param routineId the routine name's symbol table entry.
     * @param argListCtx the ArgumentListContext.
     * @return a string representing the routine's name and arguments in jasmin syntax (does not include the return type)
     */
    private String routineHelper(SymtabEntry routineId,
                          PascatParser.ArgumentListContext argListCtx)
    {
        //creates a string that looks like Adder/add(
        String routineCall = programName + "/" + routineId.getName() + "(";
        //the argument list may be null
        if(argListCtx != null)
        {
            ArrayList<SymtabEntry> routineParameters = routineId.getRoutineParameters();
            
            //visits all of the arguments to the routine
            for(int i = 0; i < argListCtx.argument().size(); i++)
            {
                PascatParser.ExpressionContext expCtx = argListCtx.argument(i).expression();
                compiler.visit(expCtx); //visits the expression
                
                Typespec expType = expCtx.type; //gets the type of the expression
                
                //checks if the expression resolves to be an int but the function expects a float
                if(expType == Predefined.integerType && routineParameters.get(i).getType() == Predefined.realType) 
                {
                    expType = Predefined.realType;
                    emit(I2F);
                }
                
                //adds the type of the argument to the routine string; it now looks like Adder/add(I
                routineCall += typeDescriptor(expType);
            }
        }
        
        //closing parenthesis for routine; now it looks like Adder/add(II)
        routineCall += ")";
        
        return routineCall;
    }

    /**
     * Emit code for a WRITE statement.
     * @param ctx the WriteStatementContext.
     */
    public void emitWrite(PascatParser.MeowStatementContext ctx)
    {
        emitWrite(ctx.meowArguments(), false);
    }

    /**
     * Emit code for a WRITELN statement.
     * @param ctx the WritelnStatementContext.
     */
    public void emitWriteln(PascatParser.MeowlnStatementContext ctx)
    {
        emitWrite(ctx.meowArguments(), true);
    }

    /**
     * Emit code for a call to WRITE or WRITELN.
     * @param argsCtx the WriteArgumentsContext.
     * @param needLF true if need a line feed.
     */
    private void emitWrite(MeowArgumentsContext argsCtx,
                           boolean needLF)
    {
        emit(GETSTATIC, "java/lang/System/out", "Ljava/io/PrintStream;");

        // WRITELN with no arguments.
        if (argsCtx == null) 
        {
            emit(INVOKEVIRTUAL, "java/io/PrintStream.println()V");
            localStack.decrease(1);
        }
            
        // Generate code for the arguments.
        else
        {
            StringBuffer format = new StringBuffer();
            int exprCount = createWriteFormat(argsCtx, format, needLF);
            
            // Load the format string.
            emit(LDC, format.toString());
            
            // Emit the arguments array.
            if (exprCount > 0)
            {
                emitArgumentsArray(argsCtx, exprCount);

                emit(INVOKEVIRTUAL,
                     "java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)" +
                     "Ljava/io/PrintStream;");
                localStack.decrease(2);
                emit(POP);
            }
            else
            {
                emit(INVOKEVIRTUAL,
                     "java/io/PrintStream/print(Ljava/lang/String;)V");
                localStack.decrease(2);
            }
        }
    }
    
    /**
     * Create the printf format string.
     * @param argsCtx the WriteArgumentsContext.
     * @param format the format string to create.
     * @return the count of expression arguments.
     */
    private int createWriteFormat(MeowArgumentsContext argsCtx,
                                  StringBuffer format, boolean needLF)
    {
        int exprCount = 0;
        format.append("\"");
        
        // Loop over the write arguments.
        for (MeowArgumentContext argCtx : argsCtx.meowArgument())
        {
            Typespec type = argCtx.expression().type;
            String argText = argCtx.getText();
            
            // Append any literal strings.
            if (argText.charAt(0) == '\'') 
            {
                format.append(convertString(argText));
            }
            
            // For any other expressions, append a field specifier.
            else
            {
                exprCount++;
                format.append("%");
                
                PascatParser.FieldWidthContext fwCtx = argCtx.fieldWidth();              
                if (fwCtx != null)
                {
                    String sign = (   (fwCtx.sign() != null) 
                                   && (fwCtx.sign().getText().equals("-"))) 
                                ? "-" : "";
                    format.append(sign)
                          .append(fwCtx.integerConstant().getText());
                    
                    PascatParser.DecimalPlacesContext dpCtx = 
                                                        fwCtx.decimalPlaces();
                    if (dpCtx != null)
                    {
                        format.append(".")
                              .append(dpCtx.integerConstant().getText());
                    }
                }
                
                String typeFlag = type == Predefined.integerType ? "d" 
                                : type == Predefined.realType    ? "f" 
                                : type == Predefined.booleanType ? "b" 
                                : type == Predefined.charType    ? "c" 
                                :                                  "s";
                format.append(typeFlag);
            }
        }
        
        format.append(needLF ? "\\n\"" : "\"");
 
        return exprCount;
    }
    
    /**
     * Emit the printf arguments array.
     * @param argsCtx
     * @param exprCount
     */
    private void emitArgumentsArray(MeowArgumentsContext argsCtx,
                                    int exprCount)
    {
        // Create the arguments array.
        emitLoadConstant(exprCount);
        emit(ANEWARRAY, "java/lang/Object");

        int index = 0;

        // Loop over the write arguments to fill the arguments array.
        for (MeowArgumentContext argCtx : argsCtx.meowArgument())
        {
            String argText = argCtx.getText();
            PascatParser.ExpressionContext exprCtx = argCtx.expression();
            Typespec type = exprCtx.type.baseType();
            
            // Skip string constants, which were made part of
            // the format string.
            if (argText.charAt(0) != '\'') 
            {
                emit(DUP);
                emitLoadConstant(index++);

                compiler.visit(exprCtx);

                Form form = type.getForm();
                if (    ((form == SCALAR) || (form == ENUMERATION))
                     && (type != Predefined.stringType))
                {
                    emit(INVOKESTATIC, valueOfSignature(type));
                }

                // Store the value into the array.
                emit(AASTORE);
            }
        }
    }

    /**
     * Emit code for a READ statement.
     * @param ctx the ReadStatementContext.
     */
    public void emitRead(PascatParser.ReadStatementContext ctx)
    {
        emitRead(ctx.readArguments(), false);
    }

    /**
     * Emit code for a READLN statement.
     * @param ctx the ReadlnStatementContext.
     */
    public void emitReadln(PascatParser.ReadlnStatementContext ctx)
    {
        emitRead(ctx.readArguments(), true);
    }

    /**
     * Generate code for a call to READ or READLN.
     * @param argsCtx the ReadArgumentsContext.
     * @param needSkip true if need to skip the rest of the input line.
     */
    private void emitRead(PascatParser.ReadArgumentsContext argsCtx,
                          boolean needSkip)
    {
        int size = argsCtx.variable().size();
        
        // Loop over read arguments.
        for (int i = 0; i < size; i++)
        {
            PascatParser.VariableContext varCtx = argsCtx.variable().get(i);
            Typespec varType = varCtx.type;
            
            if (varType == Predefined.integerType)
            {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/nextInt()I");
                emitStoreValue(varCtx.entry, null);
            }
            else if (varType == Predefined.realType)
            {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/nextFloat()F");
                emitStoreValue(varCtx.entry, null);
            }
            else if (varType == Predefined.booleanType)
            {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/nextBoolean()Z");
                emitStoreValue(varCtx.entry, null);
            }
            else if (varType == Predefined.charType)
            {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(LDC, "\"\"");
                emit(INVOKEVIRTUAL, "java/util/Scanner/useDelimiter(Ljava/lang/String;)" +
                                    "Ljava/util/Scanner;");
                emit(POP);                
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/next()Ljava/lang/String;");
                emit(ICONST_0);           
                emit(INVOKEVIRTUAL, "java/lang/String/charAt(I)C");
                emitStoreValue(varCtx.entry, null);
                
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/reset()Ljava/util/Scanner;");

            }
            else  // string
            {
                emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
                emit(INVOKEVIRTUAL, "java/util/Scanner/next()Ljava/lang/String;");
                emitStoreValue(varCtx.entry, null);
            }
        }

        // READLN: Skip the rest of the input line.
        if (needSkip) 
        {
            emit(GETSTATIC, programName + "/_sysin Ljava/util/Scanner;");
            emit(INVOKEVIRTUAL, "java/util/Scanner/nextLine()Ljava/lang/String;");
            emit(POP);                 
        }
    }
}
