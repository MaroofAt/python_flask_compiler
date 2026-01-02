// Generated from c:/Users/DELL/python_flask_compiler/source/src/antlr/PythonParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#application}.
	 * @param ctx the parse tree
	 */
	void enterApplication(PythonParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#application}.
	 * @param ctx the parse tree
	 */
	void exitApplication(PythonParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PythonParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PythonParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PythonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PythonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(PythonParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(PythonParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSmall_stmt(PythonParser.Small_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSmall_stmt(PythonParser.Small_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(PythonParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(PythonParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Regular_Assignment}
	 * labeled alternative in {@link PythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterRegular_Assignment(PythonParser.Regular_AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Regular_Assignment}
	 * labeled alternative in {@link PythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitRegular_Assignment(PythonParser.Regular_AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Typed_Assignment}
	 * labeled alternative in {@link PythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterTyped_Assignment(PythonParser.Typed_AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Typed_Assignment}
	 * labeled alternative in {@link PythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitTyped_Assignment(PythonParser.Typed_AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#augmented_assignment}.
	 * @param ctx the parse tree
	 */
	void enterAugmented_assignment(PythonParser.Augmented_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#augmented_assignment}.
	 * @param ctx the parse tree
	 */
	void exitAugmented_assignment(PythonParser.Augmented_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#augmented_assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAugmented_assignment_operator(PythonParser.Augmented_assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#augmented_assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAugmented_assignment_operator(PythonParser.Augmented_assignment_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(PythonParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(PythonParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#target_atom}.
	 * @param ctx the parse tree
	 */
	void enterTarget_atom(PythonParser.Target_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#target_atom}.
	 * @param ctx the parse tree
	 */
	void exitTarget_atom(PythonParser.Target_atomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Target_Postfix_Attribute_Ref}
	 * labeled alternative in {@link PythonParser#target_postfix}.
	 * @param ctx the parse tree
	 */
	void enterTarget_Postfix_Attribute_Ref(PythonParser.Target_Postfix_Attribute_RefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Target_Postfix_Attribute_Ref}
	 * labeled alternative in {@link PythonParser#target_postfix}.
	 * @param ctx the parse tree
	 */
	void exitTarget_Postfix_Attribute_Ref(PythonParser.Target_Postfix_Attribute_RefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Target_Postfix_Subscription}
	 * labeled alternative in {@link PythonParser#target_postfix}.
	 * @param ctx the parse tree
	 */
	void enterTarget_Postfix_Subscription(PythonParser.Target_Postfix_SubscriptionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Target_Postfix_Subscription}
	 * labeled alternative in {@link PythonParser#target_postfix}.
	 * @param ctx the parse tree
	 */
	void exitTarget_Postfix_Subscription(PythonParser.Target_Postfix_SubscriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#target_list}.
	 * @param ctx the parse tree
	 */
	void enterTarget_list(PythonParser.Target_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#target_list}.
	 * @param ctx the parse tree
	 */
	void exitTarget_list(PythonParser.Target_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#typed_assignment}.
	 * @param ctx the parse tree
	 */
	void enterTyped_assignment(PythonParser.Typed_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#typed_assignment}.
	 * @param ctx the parse tree
	 */
	void exitTyped_assignment(PythonParser.Typed_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PythonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PythonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#tuple_expr}.
	 * @param ctx the parse tree
	 */
	void enterTuple_expr(PythonParser.Tuple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#tuple_expr}.
	 * @param ctx the parse tree
	 */
	void exitTuple_expr(PythonParser.Tuple_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or_Expr}
	 * labeled alternative in {@link PythonParser#conditional_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_Expr(PythonParser.Or_ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or_Expr}
	 * labeled alternative in {@link PythonParser#conditional_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_Expr(PythonParser.Or_ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or_Expr_Short_If}
	 * labeled alternative in {@link PythonParser#conditional_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_Expr_Short_If(PythonParser.Or_Expr_Short_IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or_Expr_Short_If}
	 * labeled alternative in {@link PythonParser#conditional_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_Expr_Short_If(PythonParser.Or_Expr_Short_IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(PythonParser.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(PythonParser.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(PythonParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(PythonParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#not_expr}.
	 * @param ctx the parse tree
	 */
	void enterNot_expr(PythonParser.Not_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#not_expr}.
	 * @param ctx the parse tree
	 */
	void exitNot_expr(PythonParser.Not_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expr(PythonParser.Arithmetic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expr(PythonParser.Arithmetic_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#xor_expr}.
	 * @param ctx the parse tree
	 */
	void enterXor_expr(PythonParser.Xor_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#xor_expr}.
	 * @param ctx the parse tree
	 */
	void exitXor_expr(PythonParser.Xor_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#addition_expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition_expr(PythonParser.Addition_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#addition_expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition_expr(PythonParser.Addition_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#multiplication_expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication_expr(PythonParser.Multiplication_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#multiplication_expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication_expr(PythonParser.Multiplication_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(PythonParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(PythonParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#power_expr}.
	 * @param ctx the parse tree
	 */
	void enterPower_expr(PythonParser.Power_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#power_expr}.
	 * @param ctx the parse tree
	 */
	void exitPower_expr(PythonParser.Power_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(PythonParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(PythonParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op(PythonParser.Unary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op(PythonParser.Unary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(PythonParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(PythonParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(PythonParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(PythonParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#subscription}.
	 * @param ctx the parse tree
	 */
	void enterSubscription(PythonParser.SubscriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#subscription}.
	 * @param ctx the parse tree
	 */
	void exitSubscription(PythonParser.SubscriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#attribute_ref}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_ref(PythonParser.Attribute_refContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#attribute_ref}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_ref(PythonParser.Attribute_refContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom_Identifier}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom_Identifier(PythonParser.Atom_IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom_Identifier}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom_Identifier(PythonParser.Atom_IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom_Literal}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom_Literal(PythonParser.Atom_LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom_Literal}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom_Literal(PythonParser.Atom_LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom_Enclosure}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom_Enclosure(PythonParser.Atom_EnclosureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom_Enclosure}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom_Enclosure(PythonParser.Atom_EnclosureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom_Expr}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom_Expr(PythonParser.Atom_ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom_Expr}
	 * labeled alternative in {@link PythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom_Expr(PythonParser.Atom_ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal_Number}
	 * labeled alternative in {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_Number(PythonParser.Literal_NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal_Number}
	 * labeled alternative in {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_Number(PythonParser.Literal_NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal_String}
	 * labeled alternative in {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_String(PythonParser.Literal_StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal_String}
	 * labeled alternative in {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_String(PythonParser.Literal_StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal_Bool_None}
	 * labeled alternative in {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_Bool_None(PythonParser.Literal_Bool_NoneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal_Bool_None}
	 * labeled alternative in {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_Bool_None(PythonParser.Literal_Bool_NoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#strings}.
	 * @param ctx the parse tree
	 */
	void enterStrings(PythonParser.StringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#strings}.
	 * @param ctx the parse tree
	 */
	void exitStrings(PythonParser.StringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#enclosure}.
	 * @param ctx the parse tree
	 */
	void enterEnclosure(PythonParser.EnclosureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#enclosure}.
	 * @param ctx the parse tree
	 */
	void exitEnclosure(PythonParser.EnclosureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void enterList_literal(PythonParser.List_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void exitList_literal(PythonParser.List_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_literal}.
	 * @param ctx the parse tree
	 */
	void enterDict_literal(PythonParser.Dict_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_literal}.
	 * @param ctx the parse tree
	 */
	void exitDict_literal(PythonParser.Dict_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_items}.
	 * @param ctx the parse tree
	 */
	void enterDict_items(PythonParser.Dict_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_items}.
	 * @param ctx the parse tree
	 */
	void exitDict_items(PythonParser.Dict_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_item}.
	 * @param ctx the parse tree
	 */
	void enterDict_item(PythonParser.Dict_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_item}.
	 * @param ctx the parse tree
	 */
	void exitDict_item(PythonParser.Dict_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#set_literal}.
	 * @param ctx the parse tree
	 */
	void enterSet_literal(PythonParser.Set_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#set_literal}.
	 * @param ctx the parse tree
	 */
	void exitSet_literal(PythonParser.Set_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#set_items}.
	 * @param ctx the parse tree
	 */
	void enterSet_items(PythonParser.Set_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#set_items}.
	 * @param ctx the parse tree
	 */
	void exitSet_items(PythonParser.Set_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArguments_list(PythonParser.Arguments_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArguments_list(PythonParser.Arguments_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#args_argument}.
	 * @param ctx the parse tree
	 */
	void enterArgs_argument(PythonParser.Args_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#args_argument}.
	 * @param ctx the parse tree
	 */
	void exitArgs_argument(PythonParser.Args_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#kwargs_argument}.
	 * @param ctx the parse tree
	 */
	void enterKwargs_argument(PythonParser.Kwargs_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#kwargs_argument}.
	 * @param ctx the parse tree
	 */
	void exitKwargs_argument(PythonParser.Kwargs_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#identifier_equal_expr_argument}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_equal_expr_argument(PythonParser.Identifier_equal_expr_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#identifier_equal_expr_argument}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_equal_expr_argument(PythonParser.Identifier_equal_expr_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#comparision_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparision_operator(PythonParser.Comparision_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#comparision_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparision_operator(PythonParser.Comparision_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(PythonParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(PythonParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(PythonParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(PythonParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#parameters_list}.
	 * @param ctx the parse tree
	 */
	void enterParameters_list(PythonParser.Parameters_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#parameters_list}.
	 * @param ctx the parse tree
	 */
	void exitParameters_list(PythonParser.Parameters_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#args_kwargs_parameters_list}.
	 * @param ctx the parse tree
	 */
	void enterArgs_kwargs_parameters_list(PythonParser.Args_kwargs_parameters_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#args_kwargs_parameters_list}.
	 * @param ctx the parse tree
	 */
	void exitArgs_kwargs_parameters_list(PythonParser.Args_kwargs_parameters_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#args_parameter}.
	 * @param ctx the parse tree
	 */
	void enterArgs_parameter(PythonParser.Args_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#args_parameter}.
	 * @param ctx the parse tree
	 */
	void exitArgs_parameter(PythonParser.Args_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#kwargs_parameter}.
	 * @param ctx the parse tree
	 */
	void enterKwargs_parameter(PythonParser.Kwargs_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#kwargs_parameter}.
	 * @param ctx the parse tree
	 */
	void exitKwargs_parameter(PythonParser.Kwargs_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#default_parameter}.
	 * @param ctx the parse tree
	 */
	void enterDefault_parameter(PythonParser.Default_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#default_parameter}.
	 * @param ctx the parse tree
	 */
	void exitDefault_parameter(PythonParser.Default_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#non_default_parameter}.
	 * @param ctx the parse tree
	 */
	void enterNon_default_parameter(PythonParser.Non_default_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#non_default_parameter}.
	 * @param ctx the parse tree
	 */
	void exitNon_default_parameter(PythonParser.Non_default_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorators}.
	 * @param ctx the parse tree
	 */
	void enterDecorators(PythonParser.DecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorators}.
	 * @param ctx the parse tree
	 */
	void exitDecorators(PythonParser.DecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorator_expression}.
	 * @param ctx the parse tree
	 */
	void enterDecorator_expression(PythonParser.Decorator_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorator_expression}.
	 * @param ctx the parse tree
	 */
	void exitDecorator_expression(PythonParser.Decorator_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void enterDotted_name(PythonParser.Dotted_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dotted_name}.
	 * @param ctx the parse tree
	 */
	void exitDotted_name(PythonParser.Dotted_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(PythonParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(PythonParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void enterInheritance(PythonParser.InheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void exitInheritance(PythonParser.InheritanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Try_Stmt}
	 * labeled alternative in {@link PythonParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void enterTry_Stmt(PythonParser.Try_StmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Try_Stmt}
	 * labeled alternative in {@link PythonParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void exitTry_Stmt(PythonParser.Try_StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Try_Finally_Stmt}
	 * labeled alternative in {@link PythonParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void enterTry_Finally_Stmt(PythonParser.Try_Finally_StmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Try_Finally_Stmt}
	 * labeled alternative in {@link PythonParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void exitTry_Finally_Stmt(PythonParser.Try_Finally_StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void enterElse_clause(PythonParser.Else_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void exitElse_clause(PythonParser.Else_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#finally_clause}.
	 * @param ctx the parse tree
	 */
	void enterFinally_clause(PythonParser.Finally_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#finally_clause}.
	 * @param ctx the parse tree
	 */
	void exitFinally_clause(PythonParser.Finally_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#except_clause}.
	 * @param ctx the parse tree
	 */
	void enterExcept_clause(PythonParser.Except_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#except_clause}.
	 * @param ctx the parse tree
	 */
	void exitExcept_clause(PythonParser.Except_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#except_expression}.
	 * @param ctx the parse tree
	 */
	void enterExcept_expression(PythonParser.Except_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#except_expression}.
	 * @param ctx the parse tree
	 */
	void exitExcept_expression(PythonParser.Except_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#exception_type}.
	 * @param ctx the parse tree
	 */
	void enterException_type(PythonParser.Exception_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#exception_type}.
	 * @param ctx the parse tree
	 */
	void exitException_type(PythonParser.Exception_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWith_stmt(PythonParser.With_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWith_stmt(PythonParser.With_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#with_item}.
	 * @param ctx the parse tree
	 */
	void enterWith_item(PythonParser.With_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#with_item}.
	 * @param ctx the parse tree
	 */
	void exitWith_item(PythonParser.With_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(PythonParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(PythonParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import_Stmt}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_Stmt(PythonParser.Import_StmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import_Stmt}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_Stmt(PythonParser.Import_StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import_From_Stmt}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_From_Stmt(PythonParser.Import_From_StmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import_From_Stmt}
	 * labeled alternative in {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_From_Stmt(PythonParser.Import_From_StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#import_targets}.
	 * @param ctx the parse tree
	 */
	void enterImport_targets(PythonParser.Import_targetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#import_targets}.
	 * @param ctx the parse tree
	 */
	void exitImport_targets(PythonParser.Import_targetsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import_Target}
	 * labeled alternative in {@link PythonParser#import_target}.
	 * @param ctx the parse tree
	 */
	void enterImport_Target(PythonParser.Import_TargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import_Target}
	 * labeled alternative in {@link PythonParser#import_target}.
	 * @param ctx the parse tree
	 */
	void exitImport_Target(PythonParser.Import_TargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import_Star}
	 * labeled alternative in {@link PythonParser#import_target}.
	 * @param ctx the parse tree
	 */
	void enterImport_Star(PythonParser.Import_StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import_Star}
	 * labeled alternative in {@link PythonParser#import_target}.
	 * @param ctx the parse tree
	 */
	void exitImport_Star(PythonParser.Import_StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import_From_Target}
	 * labeled alternative in {@link PythonParser#import_from_target}.
	 * @param ctx the parse tree
	 */
	void enterImport_From_Target(PythonParser.Import_From_TargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import_From_Target}
	 * labeled alternative in {@link PythonParser#import_from_target}.
	 * @param ctx the parse tree
	 */
	void exitImport_From_Target(PythonParser.Import_From_TargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Import_From_Target_Dots}
	 * labeled alternative in {@link PythonParser#import_from_target}.
	 * @param ctx the parse tree
	 */
	void enterImport_From_Target_Dots(PythonParser.Import_From_Target_DotsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Import_From_Target_Dots}
	 * labeled alternative in {@link PythonParser#import_from_target}.
	 * @param ctx the parse tree
	 */
	void exitImport_From_Target_Dots(PythonParser.Import_From_Target_DotsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#raise_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRaise_stmt(PythonParser.Raise_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#raise_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRaise_stmt(PythonParser.Raise_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#raise_expression}.
	 * @param ctx the parse tree
	 */
	void enterRaise_expression(PythonParser.Raise_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#raise_expression}.
	 * @param ctx the parse tree
	 */
	void exitRaise_expression(PythonParser.Raise_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#exception_instance}.
	 * @param ctx the parse tree
	 */
	void enterException_instance(PythonParser.Exception_instanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#exception_instance}.
	 * @param ctx the parse tree
	 */
	void exitException_instance(PythonParser.Exception_instanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#global_stmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_stmt(PythonParser.Global_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#global_stmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_stmt(PythonParser.Global_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(PythonParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(PythonParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#pass_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPass_stmt(PythonParser.Pass_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#pass_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPass_stmt(PythonParser.Pass_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stmt(PythonParser.Continue_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stmt(PythonParser.Continue_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PythonParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PythonParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PythonParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PythonParser.IdentifierContext ctx);
}