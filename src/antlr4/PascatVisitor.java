// Generated from Pascat.g4 by ANTLR 4.8

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PascatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PascatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawgram(PascatParser.PawgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawgramHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawgramHeader(PascatParser.PawgramHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawgramParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawgramParameters(PascatParser.PawgramParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawgramIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawgramIdentifier(PascatParser.PawgramIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PascatParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(PascatParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#constantsPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantsPart(PascatParser.ConstantsPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#constantDefinitionsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinitionsList(PascatParser.ConstantDefinitionsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#constantDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinition(PascatParser.ConstantDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#constantIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantIdentifier(PascatParser.ConstantIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PascatParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(PascatParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#typesPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypesPart(PascatParser.TypesPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#typeDefinitionsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinitionsList(PascatParser.TypeDefinitionsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(PascatParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(PascatParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleTypespec}
	 * labeled alternative in {@link PascatParser#typeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypespec(PascatParser.SimpleTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypespec}
	 * labeled alternative in {@link PascatParser#typeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypespec(PascatParser.ArrayTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code recordTypespec}
	 * labeled alternative in {@link PascatParser#typeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordTypespec(PascatParser.RecordTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeIdentifierTypespec}
	 * labeled alternative in {@link PascatParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifierTypespec(PascatParser.TypeIdentifierTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumerationTypespec}
	 * labeled alternative in {@link PascatParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationTypespec(PascatParser.EnumerationTypespecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subrangeTypespec}
	 * labeled alternative in {@link PascatParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrangeTypespec(PascatParser.SubrangeTypespecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#enumerationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationType(PascatParser.EnumerationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#enumerationConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationConstant(PascatParser.EnumerationConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#subrangeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrangeType(PascatParser.SubrangeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(PascatParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#arrayDimensionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDimensionList(PascatParser.ArrayDimensionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#recordType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(PascatParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#recordFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordFields(PascatParser.RecordFieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#variablesPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesPart(PascatParser.VariablesPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#variableDeclarationsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationsList(PascatParser.VariableDeclarationsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#variableDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarations(PascatParser.VariableDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#variableIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableIdentifierList(PascatParser.VariableIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#variableIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableIdentifier(PascatParser.VariableIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#routinesPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutinesPart(PascatParser.RoutinesPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#routineDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineDefinition(PascatParser.RoutineDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawcedureHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawcedureHead(PascatParser.PawcedureHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#functionHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionHead(PascatParser.FunctionHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#routineIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineIdentifier(PascatParser.RoutineIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PascatParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#parameterDeclarationsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclarationsList(PascatParser.ParameterDeclarationsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#parameterDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclarations(PascatParser.ParameterDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#parameterIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterIdentifierList(PascatParser.ParameterIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#parameterIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterIdentifier(PascatParser.ParameterIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PascatParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(PascatParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(PascatParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(PascatParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(PascatParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(PascatParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhs(PascatParser.RhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PascatParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#trueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueStatement(PascatParser.TrueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#falseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseStatement(PascatParser.FalseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#clawStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClawStatement(PascatParser.ClawStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#clawBranchList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClawBranchList(PascatParser.ClawBranchListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#clawBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClawBranch(PascatParser.ClawBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#clawConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClawConstantList(PascatParser.ClawConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#clawConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClawConstant(PascatParser.ClawConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(PascatParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PascatParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#furStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFurStatement(PascatParser.FurStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawcedureCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawcedureCallStatement(PascatParser.PawcedureCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#pawcedureName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPawcedureName(PascatParser.PawcedureNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(PascatParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(PascatParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#meowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeowStatement(PascatParser.MeowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#meowlnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeowlnStatement(PascatParser.MeowlnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#meowArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeowArguments(PascatParser.MeowArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#meowArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeowArgument(PascatParser.MeowArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#fieldWidth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldWidth(PascatParser.FieldWidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#decimalPlaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalPlaces(PascatParser.DecimalPlacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(PascatParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#readlnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadlnStatement(PascatParser.ReadlnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#readArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadArguments(PascatParser.ReadArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PascatParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(PascatParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PascatParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableFactor(PascatParser.VariableFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberFactor(PascatParser.NumberFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterFactor(PascatParser.CharacterFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFactor(PascatParser.StringFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallFactor(PascatParser.FunctionCallFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFactor(PascatParser.NotFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedFactor}
	 * labeled alternative in {@link PascatParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedFactor(PascatParser.ParenthesizedFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PascatParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(PascatParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#indexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexList(PascatParser.IndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(PascatParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(PascatParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(PascatParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(PascatParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PascatParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#unsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(PascatParser.UnsignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#integerConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConstant(PascatParser.IntegerConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#realConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealConstant(PascatParser.RealConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#characterConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterConstant(PascatParser.CharacterConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(PascatParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(PascatParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(PascatParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascatParser#mulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOp(PascatParser.MulOpContext ctx);
}