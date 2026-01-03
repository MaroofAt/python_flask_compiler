package visitors;

import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;

import classes.python.*;
import classes.python.Number;
import classes.python.symbols.SymbolTable;


public class PythonBaseVisitor extends PythonParserBaseVisitor {

    public static SymbolTable symbolTable = new SymbolTable();
    private String current_scope = "global";
    private int if_num = 0;
    private int for_num = 0;
    private int while_num = 0;
    private int try_num = 0;
    private int except_num = 0;
    private int with_num = 0;
    private int func_num = 0;
    private int class_num = 0;
    private String current_symbol_kind;

    @Override
    public Application visitApplication(PythonParser.ApplicationContext ctx) {
//        return super.visitApplication(ctx);
        Application application = new Application();

        application.setStatements(
                visitStatements( ctx.statements() )
        );

        return application;
    }

    @Override
    public Statements visitStatements(PythonParser.StatementsContext ctx) {
//        return super.visitStatements(ctx);
        Statements statements = new Statements();
        for(int i = 0 ; i < ctx.statement().size() ; i++){
            statements.add_to_statement_arraylist(
                    visitStatement(ctx.statement().get(i))
            );
        }
//        if(ctx.NEWLINE() == null) return statements;
//
//        for (int i = 0 ; i < ctx.NEWLINE().size() ; i++) {
//            statements.add_to_newlines_arraylist(
//                    ctx.NEWLINE().get(i).getText()
//            );
//        }

        return statements;
    }

    @Override
    public Statement visitStatement(PythonParser.StatementContext ctx) {
//        return super.visitStatement(ctx);
        Statement statement;
        if(ctx.simple_stmt() != null){
            statement = visitSimple_stmt(ctx.simple_stmt());
        }else if(ctx.compound_stmt() != null){
            statement = visitCompound_stmt(ctx.compound_stmt());
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitStatement: the statement provided is not a simple_stmt and not a compound_stmt as well !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }
        return statement;
    }

    @Override
    public Simple_Stmt visitSimple_stmt(PythonParser.Simple_stmtContext ctx) {
//        return super.visitSimple_stmt(ctx);
        Simple_Stmt simple_stmt = new Simple_Stmt();
        if(ctx.small_stmt() != null) {
            for (PythonParser.Small_stmtContext small_stmt_ctx : ctx.small_stmt()) {
                simple_stmt.add_to_small_stmt_arraylist(
                        visitSmall_stmt(small_stmt_ctx)
                );
            }
        }else if(ctx.NEWLINE() != null){
            simple_stmt.setNewline(ctx.NEWLINE().getText());
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitSimple_stmt: the simple_stmt provided is not valid !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }
        return simple_stmt;
    }

    @Override
    public Small_Stmt visitSmall_stmt(PythonParser.Small_stmtContext ctx) {
//        return super.visitSmall_stmt(ctx);
        Small_Stmt small_stmt;
        if(ctx.assignment() != null){
            small_stmt = (Small_Stmt) visit(ctx.assignment());
        }else if(ctx.augmented_assignment() != null){
            small_stmt = visitAugmented_assignment(ctx.augmented_assignment());
        }else if(ctx.expr() != null){
            small_stmt = visitExpr(ctx.expr());
        }else if(ctx.return_stmt() != null){
            small_stmt = visitReturn_stmt(ctx.return_stmt());
        }else if(ctx.raise_stmt() != null){
            small_stmt = visitRaise_stmt(ctx.raise_stmt());
        }else if(ctx.import_stmt() != null){
            small_stmt = (Small_Stmt) visit(ctx.import_stmt());
        }else if(ctx.global_stmt() != null){
            small_stmt = visitGlobal_stmt(ctx.global_stmt());
        }else if(ctx.break_stmt() != null){
            small_stmt = visitBreak_stmt(ctx.break_stmt());
        }else if(ctx.pass_stmt() != null){
            small_stmt = visitPass_stmt(ctx.pass_stmt());
        }else if(ctx.continue_stmt() != null){
            small_stmt = visitContinue_stmt(ctx.continue_stmt());
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitSmall_stmt: the small_stmt provided is not valid !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }

        return  small_stmt;

    }

    @Override
    public Compound_Stmt visitCompound_stmt(PythonParser.Compound_stmtContext ctx) {
//        return super.visitCompound_stmt(ctx);
        Compound_Stmt compound_stmt;
        if(ctx.if_stmt() != null){
            compound_stmt = visitIf_stmt(ctx.if_stmt());
        }else if(ctx.for_stmt() != null){
            compound_stmt = visitFor_stmt(ctx.for_stmt());
        }else if(ctx.while_stmt() != null){
            compound_stmt = visitWhile_stmt(ctx.while_stmt());
        }else if(ctx.with_stmt() != null){
            compound_stmt = visitWith_stmt(ctx.with_stmt());
        }else if(ctx.try_stmt() != null){
            compound_stmt = (Compound_Stmt) visit(ctx.try_stmt());
        }else if(ctx.func_def() != null){
            compound_stmt = visitFunc_def(ctx.func_def());
        }else if(ctx.class_def() != null){
            compound_stmt = visitClass_def(ctx.class_def());
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitCompound_stmt: the compound_stmt provided is not valid !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }
        return compound_stmt;
    }

    @Override
    public Regular_Assignment visitRegularAssignment(PythonParser.RegularAssignmentContext ctx) {
//        return super.visitRegular_Assignment(ctx);
        Regular_Assignment regular_assignment = new Regular_Assignment();
        for(PythonParser.Target_listContext tl_ctx: ctx.target_list()){
            regular_assignment.add_to_target_list_arraylist(
                    visitTarget_list(tl_ctx)
            );
        }
        regular_assignment.setExpr(
                visitExpr(ctx.expr())
        );

        return regular_assignment;
    }

    @Override
    public Typed_Assignment visitTypedAssignment(PythonParser.TypedAssignmentContext ctx) {
//        return super.visitTyped_Assignment(ctx);
        Typed_Assignment typed_assignment = new Typed_Assignment();
        typed_assignment.setIdentifier1(
                visitIdentifier(ctx.typed_assignment().identifier().get(0))
        );
        typed_assignment.setIdentifier2(
                visitIdentifier(ctx.typed_assignment().identifier().get(1))
        );

        if(ctx.typed_assignment().expr() != null){
            typed_assignment.setExpr(
                    visitExpr(ctx.typed_assignment().expr())
            );
        }

        return typed_assignment;
    }

    @Override
    public Augmented_Assignment visitAugmented_assignment(PythonParser.Augmented_assignmentContext ctx) {
//        return super.visitAugmented_assignment(ctx);
        Augmented_Assignment augmented_assignment = new Augmented_Assignment();
        augmented_assignment.setTarget(
                visitTarget(ctx.target())
        );
        augmented_assignment.setAugmented_assignment_operator(
                visitAugmented_assignment_operator(ctx.augmented_assignment_operator())
        );
        augmented_assignment.setExpr(
                visitExpr(ctx.expr())
        );

        return augmented_assignment;
    }

    @Override
    public Augmented_Assignment_Operator visitAugmented_assignment_operator(PythonParser.Augmented_assignment_operatorContext ctx) {
//        return super.visitAugmented_assignment_operator(ctx);
        Augmented_Assignment_Operator augmented_assignment_operator = new Augmented_Assignment_Operator();
        augmented_assignment_operator.setOperator_str(ctx.getText());
        return augmented_assignment_operator;
    }

    @Override
    public Target visitTarget(PythonParser.TargetContext ctx) {
//        return super.visitTarget(ctx);
        Target target = new Target();
        target.setTarget_atom(
                visitTarget_atom(ctx.target_atom())
        );

        if(ctx.target_postfix() == null){
            this.current_symbol_kind = "variable";
            return target;
        }

        for(PythonParser.Target_postfixContext tp_ctx: ctx.target_postfix()){
            target.add_to_target_postfix_arraylist(
                    (Target_Postfix) visit(tp_ctx)
            );
        }

        return target;
    }

    @Override
    public Target_Atom visitTarget_atom(PythonParser.Target_atomContext ctx) {
//        return super.visitTarget_atom(ctx);
        Target_Atom target_atom = new Target_Atom();
        if(ctx.identifier() != null){
            target_atom.setIdentifier(
                    visitIdentifier(ctx.identifier())
            );
        }
        if(ctx.target_list() != null){
            target_atom.setTarget_list(
                    visitTarget_list(ctx.target_list())
            );
        }

        return target_atom;
    }

    @Override
    public Target_Postfix_Attribute_Ref visitTargetPostfixAttributeRef(PythonParser.TargetPostfixAttributeRefContext ctx) {
//        return super.visitTarget_Postfix_Attribute_Ref(ctx);
        Target_Postfix_Attribute_Ref target_postfix_attribute_ref = new Target_Postfix_Attribute_Ref();
        this.current_symbol_kind = "entity";
        target_postfix_attribute_ref.setAttribute_ref(
                visitAttribute_ref(ctx.attribute_ref())
        );
        return target_postfix_attribute_ref;
    }

    @Override
    public Target_Postfix_Subscription visitTargetPostfixSubscription(PythonParser.TargetPostfixSubscriptionContext ctx) {
//        return super.visitTarget_Postfix_Subscription(ctx);
        Target_Postfix_Subscription target_postfix_subscription = new Target_Postfix_Subscription();
        this.current_symbol_kind = "array";
        target_postfix_subscription.setSubscription(
                visitSubscription(ctx.subscription())
        );
        return target_postfix_subscription;
    }

    @Override
    public Target_List visitTarget_list(PythonParser.Target_listContext ctx) {
//        return super.visitTarget_list(ctx);
        Target_List target_list = new Target_List();
        for(PythonParser.TargetContext t_ctx: ctx.target()){
            target_list.add_to_target_arraylist(
                    visitTarget(t_ctx)
            );
        }
        return target_list;
    }
    @Override
    public Expr visitExpr(PythonParser.ExprContext ctx) {
//        return super.visitExpr(ctx);
        Expr expr = visitTuple_expr(ctx.tuple_expr());
        return expr;
    }

    @Override
    public Tuple_Expr visitTuple_expr(PythonParser.Tuple_exprContext ctx) {
//        return super.visitTuple_expr(ctx);
        Tuple_Expr tuple_expr = new Tuple_Expr();
        for(PythonParser.Conditional_exprContext ce_ctx: ctx.conditional_expr()){
            tuple_expr.add_to_conditional_expr_arraylist(
                    (Conditional_Expr) visit(ce_ctx)
            );
        }
        return tuple_expr;
    }

    @Override
    public Or_Expr visitOrExpr(PythonParser.OrExprContext ctx) {
//        return super.visitOr_Expr(ctx);
        Or_Expr or_expr = visitOr_expr(ctx.or_expr());
        return or_expr;
    }

    @Override
    public Or_Expr_Short_If visitOrExprShortIf(PythonParser.OrExprShortIfContext ctx) {
//        return super.visitOr_Expr_Short_If(ctx);
        Or_Expr_Short_If or_expr_short_if = new Or_Expr_Short_If();
        or_expr_short_if.setOr_expr1(
                (Or_Expr) visit(ctx.or_expr().get(0))
        );
        or_expr_short_if.setOr_expr2(
                (Or_Expr) visit(ctx.or_expr().get(1))
        );
        or_expr_short_if.setConditional_expr(
                (Conditional_Expr) visit(ctx.conditional_expr())
        );

        return or_expr_short_if;
    }

    @Override
    public Or_Expr visitOr_expr(PythonParser.Or_exprContext ctx) {
//        return super.visitOr_expr(ctx);
        Or_Expr or_expr = new Or_Expr();
        for(PythonParser.And_exprContext and_ctx: ctx.and_expr()){
            or_expr.add_to_and_expr_arraylist(
                    visitAnd_expr(and_ctx)
            );
        }
        return or_expr;
    }

    @Override
    public And_Expr visitAnd_expr(PythonParser.And_exprContext ctx) {
//        return super.visitAnd_expr(ctx);
        And_Expr and_expr = new And_Expr();
        for(PythonParser.Not_exprContext not_ctx: ctx.not_expr()){
            and_expr.add_to_not_expr_arraylist(
                    visitNot_expr(not_ctx)
            );
        }
        return and_expr;
    }

    @Override
    public Not_Expr visitNot_expr(PythonParser.Not_exprContext ctx) {
//        return super.visitNot_expr(ctx);
        Not_Expr not_expr = new Not_Expr();
        if(ctx.not_expr() != null){
            not_expr.setNot_expr(
                    visitNot_expr(ctx.not_expr())
            );
        }
        if(ctx.comparison() != null){
            not_expr.setComparison(
                    visitComparison(ctx.comparison())
            );
        }

        return not_expr;
    }

    @Override
    public Comparison visitComparison(PythonParser.ComparisonContext ctx) {
//        return super.visitComparison(ctx);
        Comparison comparison = new Comparison();
        for(PythonParser.Arithmetic_exprContext a_ctx: ctx.arithmetic_expr()){
            comparison.add_to_arithmetic_expr_arraylist(
                    visitArithmetic_expr(a_ctx)
            );
        }

        if(ctx.comparision_operator() == null) return comparison;

        for(PythonParser.Comparision_operatorContext co_ctx: ctx.comparision_operator()) {
            comparison.add_to_comparision_operator_arraylist(
                    visitComparision_operator(co_ctx)
            );
        }
        return comparison;
    }

    @Override
    public Arithmetic_Expr visitArithmetic_expr(PythonParser.Arithmetic_exprContext ctx) {
//        return super.visitArithmetic_expr(ctx);
        Arithmetic_Expr arithmetic_expr = visitXor_expr(ctx.xor_expr());
        return arithmetic_expr;
    }

    @Override
    public Xor_Expr visitXor_expr(PythonParser.Xor_exprContext ctx) {
//        return super.visitXor_expr(ctx);
        Xor_Expr xor_expr = new Xor_Expr();
        for(PythonParser.Addition_exprContext ae_ctx: ctx.addition_expr()) {
            xor_expr.add_to_addition_expr_arraylist(
                    visitAddition_expr(ae_ctx)
            );
        }
        return xor_expr;
    }

    @Override
    public Addition_Expr visitAddition_expr(PythonParser.Addition_exprContext ctx) {
//        return super.visitAddition_expr(ctx);
        Addition_Expr addition_expr = new Addition_Expr();
        for(PythonParser.Multiplication_exprContext m_ctx: ctx.multiplication_expr()) {
            addition_expr.add_to_multiplication_expr_arraylist(
                    visitMultiplication_expr(m_ctx)
            );
        }
        return addition_expr;
    }

    @Override
    public Multiplication_Expr visitMultiplication_expr(PythonParser.Multiplication_exprContext ctx) {
//        return super.visitMultiplication_expr(ctx);
        Multiplication_Expr multiplication_expr = new Multiplication_Expr();
        for(PythonParser.Unary_exprContext ue_ctx: ctx.unary_expr()){
            multiplication_expr.add_to_unary_expr_arraylist(
                    visitUnary_expr(ue_ctx)
            );
        }
        return multiplication_expr;
    }

    @Override
    public Unary_Expr visitUnary_expr(PythonParser.Unary_exprContext ctx) {
//        return super.visitUnary_expr(ctx);
        Unary_Expr unary_expr = new Unary_Expr();
        unary_expr.setPower_expr(
                visitPower_expr(ctx.power_expr())
        );
        if(ctx.unary_op() == null) return unary_expr;

        for(PythonParser.Unary_opContext uo_ctx: ctx.unary_op()){
            unary_expr.add_to_unary_op_arraylist(
                    visitUnary_op(uo_ctx)
            );
        }
        return unary_expr;
    }

    @Override
    public Power_Expr visitPower_expr(PythonParser.Power_exprContext ctx) {
//        return super.visitPower_expr(ctx);
        Power_Expr power_expr = new Power_Expr();
        power_expr.setPrimary(
                visitPrimary(ctx.primary())
        );
        if(ctx.power_expr() == null) return power_expr;

        power_expr.setPower_expr(
                visitPower_expr(ctx.power_expr())
        );
        return power_expr;
    }

    @Override
    public Primary visitPrimary(PythonParser.PrimaryContext ctx) {
//        return super.visitPrimary(ctx);
        Primary primary = new Primary();
        primary.setAtom(
                (Atom) visit(ctx.atom())
        );
        if(ctx.postfix() == null) return primary;

        for(PythonParser.PostfixContext p_ctx: ctx.postfix()) {
            primary.add_to_postfix_arraylist(
                    visitPostfix(p_ctx)
            );
        }
        return primary;
    }

    @Override
    public Unary_Op visitUnary_op(PythonParser.Unary_opContext ctx) {
//        return super.visitUnary_op(ctx);
        Unary_Op unary_op = new Unary_Op();
        unary_op.setOperator_str(ctx.getText());
        return unary_op;
    }

    @Override
    public Postfix visitPostfix(PythonParser.PostfixContext ctx) {
//        return super.visitPostfix(ctx);
        Postfix postfix;
        if(ctx.call() != null){
            postfix = visitCall(ctx.call());
        }else if(ctx.attribute_ref() != null){
            postfix = visitAttribute_ref(ctx.attribute_ref());
        }else if(ctx.subscription() != null){
            postfix = visitSubscription(ctx.subscription());
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitPostfix: the postfix provided is not valid !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }
        return postfix;
    }

    @Override
    public Call visitCall(PythonParser.CallContext ctx) {
//        return super.visitCall(ctx);
        Call call = new Call();
        this.current_symbol_kind = "function_call";
        if(ctx.arguments_list() == null) return call;
        call.setArguments_list(
                visitArguments_list(ctx.arguments_list())
        );
        return call;
    }

    @Override
    public Subscription visitSubscription(PythonParser.SubscriptionContext ctx) {
//        return super.visitSubscription(ctx);
        Subscription subscription = new Subscription();
        this.current_symbol_kind = "array";
        subscription.setExpr(
                visitExpr(ctx.expr())
        );
        return subscription;
    }

    @Override
    public Attribute_Ref visitAttribute_ref(PythonParser.Attribute_refContext ctx) {
//        return super.visitAttribute_ref(ctx);
        Attribute_Ref attribute_ref = new Attribute_Ref();
        this.current_symbol_kind = "attribute";
        attribute_ref.setIdentifier(
                visitIdentifier(ctx.identifier())
        );
        return attribute_ref;
    }

    @Override
    public Atom_Identifier visitAtomIdentifier(PythonParser.AtomIdentifierContext ctx) {
//        return super.visitAtom_Identifier(ctx);
        Atom_Identifier atom_identifier = new Atom_Identifier();
        atom_identifier.setIdentifier(
                visitIdentifier(ctx.identifier())
        );
        return atom_identifier;
    }

    @Override
    public Atom_Literal visitAtomLiteral(PythonParser.AtomLiteralContext ctx) {
//        return super.visitAtom_Literal(ctx);
        Atom_Literal atom_literal = (Atom_Literal) visit(ctx.literal());
        return atom_literal;
    }

    @Override
    public Atom_Enclosure visitAtomEnclosure(PythonParser.AtomEnclosureContext ctx) {
//        return super.visitAtom_Enclosure(ctx);
//        Atom_Enclosure atom_enclosure = (Atom_Enclosure) visit(ctx.enclosure());
//        return atom_enclosure;
        return visitEnclosure(ctx.enclosure());
    }

    @Override
    public Atom_Expr visitAtomExpr(PythonParser.AtomExprContext ctx) {
//        return super.visitAtom_Expr(ctx);
        Atom_Expr atom_expr = new Atom_Expr();
        atom_expr.setExpr(
                visitExpr(ctx.expr())
        );
        return atom_expr;
    }

    @Override
    public Literal_Number visitLiteralNumber(PythonParser.LiteralNumberContext ctx) {
//        return super.visitLiteral_Number(ctx);
        Literal_Number literal_number = new Literal_Number();
        literal_number.setNumber(
                visitNumber(ctx.number())
        );
        return literal_number;
    }

    @Override
    public Literal_String visitLiteralString(PythonParser.LiteralStringContext ctx) {
//        return super.visitLiteral_String(ctx);

//        Literal_String literal_string = new Literal_String();
//        literal_string.setString(ctx.getText());

            return visitStrings(ctx.strings());
    }

    @Override
    public Literal_Bool_None visitLiteralBoolNone(PythonParser.LiteralBoolNoneContext ctx) {
//        return super.visitLiteral_Bool_None(ctx);
        Literal_Bool_None literal_bool_none = new Literal_Bool_None();
        literal_bool_none.setString(ctx.getText());
        return literal_bool_none;
    }

    @Override
    public Literal_String visitStrings(PythonParser.StringsContext ctx) {
//        return super.visitStrings(ctx);

        Literal_String literal_string = new Literal_String();
        literal_string.setString(ctx.getText());
        return literal_string;
    }

    @Override
    public Atom_Enclosure visitEnclosure(PythonParser.EnclosureContext ctx) {
//        return super.visitEnclosure(ctx);
        Atom_Enclosure atom_enclosure;
        if(ctx.dict_literal() != null){
            atom_enclosure = visitDict_literal(ctx.dict_literal());
        }else if(ctx.set_literal() != null){
            atom_enclosure = visitSet_literal(ctx.set_literal());
        }else if(ctx.list_literal() != null){
            atom_enclosure = visitList_literal(ctx.list_literal());
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitEnclosure: the enclosure provided is not valid !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }
        return atom_enclosure;
    }

    @Override
    public List_Literal visitList_literal(PythonParser.List_literalContext ctx) {
//        return super.visitList_literal(ctx);
        List_Literal list_literal = new List_Literal();
        if(ctx.expr() == null) return list_literal;

        list_literal.setExpr(
                visitExpr(ctx.expr())
        );
        return list_literal;
    }

    @Override
    public Dict_Literal visitDict_literal(PythonParser.Dict_literalContext ctx) {
//        return super.visitDict_literal(ctx);
        Dict_Literal dict_literal = new Dict_Literal();
        dict_literal.setDict_items(
                visitDict_items(ctx.dict_items())
        );
        return dict_literal;
    }

    @Override
    public Dict_Items visitDict_items(PythonParser.Dict_itemsContext ctx) {
//        return super.visitDict_items(ctx);
        Dict_Items dict_items = new Dict_Items();
        for(PythonParser.Dict_itemContext i_ctx: ctx.dict_item()){
            dict_items.add_to_dict_item_arraylist(
                    visitDict_item(i_ctx)
            );
        }
        return dict_items;
    }

    @Override
    public Dict_Item visitDict_item(PythonParser.Dict_itemContext ctx) {
//        return super.visitDict_item(ctx);
        Dict_Item dict_item = new Dict_Item();
        dict_item.setExpr1(
                visitExpr(ctx.expr().get(0))
        );
        dict_item.setExpr2(
                visitExpr(ctx.expr().get(1))
        );
        return dict_item;
    }

    @Override
    public Set_Literal visitSet_literal(PythonParser.Set_literalContext ctx) {
//        return super.visitSet_literal(ctx);
        Set_Literal set_literal = new Set_Literal();
        set_literal.setSet_items(
                visitSet_items(ctx.set_items())
        );
        return set_literal;
    }

    @Override
    public Set_Items visitSet_items(PythonParser.Set_itemsContext ctx) {
//        return super.visitSet_items(ctx);
        Set_Items set_items = new Set_Items();
        for(PythonParser.ExprContext e_ctx: ctx.expr()){
            set_items.add_to_expr_arraylist(
                    visitExpr(e_ctx)
            );
        }
        return set_items;
    }

    @Override
    public Arguments_List visitArguments_list(PythonParser.Arguments_listContext ctx) {
//        return super.visitArguments_list(ctx);
        Arguments_List arguments_list = new Arguments_List();

        if(ctx.expr() != null) {
            for (PythonParser.ExprContext e_ctx : ctx.expr()) {
                arguments_list.add_to_expr_arraylist(
                        visitExpr(e_ctx)
                );
            }
        }
        if(ctx.identifier_equal_expr_argument() != null) {
            for (PythonParser.Identifier_equal_expr_argumentContext e_ctx : ctx.identifier_equal_expr_argument()) {
                arguments_list.add_to_identifier_equal_expr_argument_arraylist(
                        visitIdentifier_equal_expr_argument(e_ctx)
                );
            }
        }
        if(ctx.args_argument() != null) {
            for (PythonParser.Args_argumentContext e_ctx : ctx.args_argument()) {
                arguments_list.add_to_args_argument_arraylist(
                        visitArgs_argument(e_ctx)
                );
            }
        }
        if(ctx.kwargs_argument() != null) {
            for (PythonParser.Kwargs_argumentContext e_ctx : ctx.kwargs_argument()) {
                arguments_list.add_to_kwargs_argument_arraylist(
                        visitKwargs_argument(e_ctx)
                );
            }
        }

        return arguments_list;
    }

    @Override
    public Args_Argument visitArgs_argument(PythonParser.Args_argumentContext ctx) {
//        return super.visitArgs_argument(ctx);
        Args_Argument args_argument = new Args_Argument();
        args_argument.setExpr(
                visitExpr(ctx.expr())
        );
        return args_argument;
    }

    @Override
    public Kwargs_Argument visitKwargs_argument(PythonParser.Kwargs_argumentContext ctx) {
//        return super.visitKwargs_argument(ctx);
        Kwargs_Argument kwargs_argument = new Kwargs_Argument();
        kwargs_argument.setExpr(
                visitExpr(ctx.expr())
        );
        return kwargs_argument;
    }

    @Override
    public Identifier_Equal_Expr_Argument visitIdentifier_equal_expr_argument(PythonParser.Identifier_equal_expr_argumentContext ctx) {
//        return super.visitIdentifier_equal_expr_argument(ctx);
        Identifier_Equal_Expr_Argument identifier_equal_expr_argument = new Identifier_Equal_Expr_Argument();
        identifier_equal_expr_argument.setExpr(
                visitExpr(ctx.expr())
        );
        identifier_equal_expr_argument.setIdentifier(
                visitIdentifier(ctx.identifier())
        );
        return identifier_equal_expr_argument;
    }

    @Override
    public If_Stmt visitIf_stmt(PythonParser.If_stmtContext ctx) {
//        return super.visitIf_stmt(ctx);
        If_Stmt if_stmt = new If_Stmt();
        this.if_num++;
        this.current_scope = "if" + Integer.toString(this.if_num);
        for(PythonParser.ExprContext e_ctx: ctx.expr()){
            if_stmt.add_to_expr_arraylist(
                    visitExpr(e_ctx)
            );
        }
        for(PythonParser.SuiteContext s_ctx: ctx.suite()){
            if_stmt.add_to_suite_arraylist(
                    visitSuite(s_ctx)
            );
        }

        return if_stmt;
    }

    @Override
    public Comparision_Operator visitComparision_operator(PythonParser.Comparision_operatorContext ctx) {
//        return super.visitComparision_operator(ctx);
        Comparision_Operator comparision_operator = new Comparision_Operator();
        comparision_operator.setString(ctx.getText());
        return comparision_operator;
    }

    @Override
    public For_Stmt visitFor_stmt(PythonParser.For_stmtContext ctx) {
//        return super.visitFor_stmt(ctx);
        For_Stmt for_stmt = new For_Stmt();
        this.for_num++;
        this.current_scope = "for" + Integer.toString(for_num);
        for_stmt.setTarget_list(
                visitTarget_list(ctx.target_list())
        );
        for_stmt.setExpr(
                visitExpr(ctx.expr())
        );
        for_stmt.setSuite(
                visitSuite(ctx.suite())
        );
        return for_stmt;
    }

    @Override
    public While_Stmt visitWhile_stmt(PythonParser.While_stmtContext ctx) {
//        return super.visitWhile_stmt(ctx);
        While_Stmt while_stmt = new While_Stmt();
        this.while_num++;
        this.current_scope = "while" + Integer.toString(while_num);
        while_stmt.setExpr(
                visitExpr(ctx.expr())
        );
        while_stmt.setSuite(
                visitSuite(ctx.suite())
        );
        return while_stmt;
    }

    @Override
    public Func_Stmt visitFunc_def(PythonParser.Func_defContext ctx) {
//        return super.visitFunc_def(ctx);
        Func_Stmt func_stmt = new Func_Stmt();
        this.current_symbol_kind = "function";
        this.func_num++;
        this.current_scope = "func" + Integer.toString(func_num);
        if(ctx.decorators() != null){
            func_stmt.setDecorators(
                    visitDecorators(ctx.decorators())
            );
        }
        if(ctx.parameters_list() != null){
            func_stmt.setParameters_list(
                    visitParameters_list(ctx.parameters_list())
            );
        }
        if(ctx.identifier() != null){
            func_stmt.setIdentifier(
                    visitIdentifier(ctx.identifier())
            );
        }

        func_stmt.setSuite(
                visitSuite(ctx.suite())
        );

        return func_stmt;
    }

    @Override
    public Parameters_List visitParameters_list(PythonParser.Parameters_listContext ctx) {
//        return super.visitParameters_list(ctx);
        Parameters_List parameters_list = new Parameters_List();
        if(ctx.non_default_parameter() != null){
            for(PythonParser.Non_default_parameterContext n_ctx: ctx.non_default_parameter()){
                parameters_list.add_to_non_default_parameter_arraylist(
                        visitNon_default_parameter(n_ctx)
                );
            }
        }
        if(ctx.default_parameter() != null){
            for(PythonParser.Default_parameterContext d_ctx: ctx.default_parameter()){
                parameters_list.add_to_default_parameter_arraylist(
                        visitDefault_parameter(d_ctx)
                );
            }
        }
        if(ctx.args_kwargs_parameters_list() != null){
            parameters_list.setArgs_kwargs_parameters_list(
                    visitArgs_kwargs_parameters_list(ctx.args_kwargs_parameters_list())
            );
        }

        return parameters_list;
    }

    @Override
    public Args_Kwargs_Parameters_List visitArgs_kwargs_parameters_list(PythonParser.Args_kwargs_parameters_listContext ctx) {
//        return super.visitArgs_kwargs_parameters_list(ctx);
        Args_Kwargs_Parameters_List args_kwargs_parameters_list = new Args_Kwargs_Parameters_List();
        if(ctx.args_parameter() != null){
            args_kwargs_parameters_list.setArgs_parameter(
                    visitArgs_parameter(ctx.args_parameter())
            );
        }
        if(ctx.kwargs_parameter() != null){
            args_kwargs_parameters_list.setKwargs_parameter(
                    visitKwargs_parameter(ctx.kwargs_parameter())
            );
        }

        return args_kwargs_parameters_list;
    }

    @Override
    public Args_Parameter visitArgs_parameter(PythonParser.Args_parameterContext ctx) {
//        return super.visitArgs_parameter(ctx);
            Args_Parameter args_parameter = new Args_Parameter();
            args_parameter.setNon_default_parameter(
                    visitNon_default_parameter(ctx.non_default_parameter())
            );
            return args_parameter;
    }

    @Override
    public Kwargs_Parameter visitKwargs_parameter(PythonParser.Kwargs_parameterContext ctx) {
//        return super.visitKwargs_parameter(ctx);
        Kwargs_Parameter kwargs_parameter = new Kwargs_Parameter();
        kwargs_parameter.setNon_default_parameter(
                visitNon_default_parameter(ctx.non_default_parameter())
        );
        return kwargs_parameter;
    }

    @Override
    public Default_Parameter visitDefault_parameter(PythonParser.Default_parameterContext ctx) {
//        return super.visitDefault_parameter(ctx);
        Default_Parameter default_parameter = new Default_Parameter();
        default_parameter.setNon_default_parameter(
                visitNon_default_parameter(ctx.non_default_parameter())
        );
        default_parameter.setExpr(
                visitExpr(ctx.expr())
        );
        return default_parameter;
    }

    @Override
    public Non_Default_Parameter visitNon_default_parameter(PythonParser.Non_default_parameterContext ctx) {
//        return super.visitNon_default_parameter(ctx);
        Non_Default_Parameter non_default_parameter = new Non_Default_Parameter();
        non_default_parameter.setIdentifier1(
                visitIdentifier(ctx.identifier().get(0))
        );

        if(ctx.identifier().size() < 2) return non_default_parameter;

        non_default_parameter.setIdentifier2(
                visitIdentifier(ctx.identifier().get(1))
        );
        return non_default_parameter;
    }

    @Override
    public Decorators visitDecorators(PythonParser.DecoratorsContext ctx) {
//        return super.visitDecorators(ctx);
        Decorators decorators = new Decorators();
        for(PythonParser.DecoratorContext d_ctx: ctx.decorator()){
            decorators.add_to_decorator_arraylist(
                    visitDecorator(d_ctx)
            );
        }
        return decorators;
    }

    @Override
    public Decorator visitDecorator(PythonParser.DecoratorContext ctx) {
//        return super.visitDecorator(ctx);
        Decorator decorator = new Decorator();
        decorator.setDecorator_expression(
                visitDecorator_expression(ctx.decorator_expression())
        );
        return decorator;
    }

    @Override
    public Decorator_Expression visitDecorator_expression(PythonParser.Decorator_expressionContext ctx) {
//        return super.visitDecorator_expression(ctx);
        Decorator_Expression decorator_expression = new Decorator_Expression();
        decorator_expression.setDotted_name(
                visitDotted_name(ctx.dotted_name())
        );
        if(ctx.call() == null) return decorator_expression;

        decorator_expression.setCall(
                visitCall(ctx.call())
        );
        return decorator_expression;
    }

    @Override
    public Dotted_Name visitDotted_name(PythonParser.Dotted_nameContext ctx) {
//        return super.visitDotted_name(ctx);
        Dotted_Name dotted_name = new Dotted_Name();
        for(PythonParser.IdentifierContext i_ctx: ctx.identifier()){
            dotted_name.add_to_identifier_arraylist(
                    visitIdentifier(i_ctx)
            );
        }
        return dotted_name;
    }

    @Override
    public Class_Def visitClass_def(PythonParser.Class_defContext ctx) {
//        return super.visitClass_def(ctx);
        Class_Def class_def = new Class_Def();
        this.current_symbol_kind = "class";
        this.class_num++;
        this.current_scope = "class" + Integer.toString(class_num);
        class_def.setIdentifier(
                visitIdentifier(ctx.identifier())
        );
        class_def.setSuite(
                visitSuite(ctx.suite())
        );

        if(ctx.decorators() != null){
            class_def.setDecorators(
                    visitDecorators(ctx.decorators())
            );
        }
        if(ctx.inheritance() != null){
            class_def.setInheritance(
                    visitInheritance(ctx.inheritance())
            );
        }
        return class_def;
    }

    @Override
    public Inheritance visitInheritance(PythonParser.InheritanceContext ctx) {
//        return super.visitInheritance(ctx);
        Inheritance inheritance = new Inheritance();
        for(PythonParser.IdentifierContext i_ctx: ctx.identifier()){
            inheritance.add_to_identifier_arraylist(
                    visitIdentifier(i_ctx)
            );
        }
        return inheritance;
    }

    @Override
    public Try_Stmt visitTryStmt(PythonParser.TryStmtContext ctx) {
//        return super.visitTry_Stmt(ctx);
        Try_Stmt try_stmt = new Try_Stmt();
        this.try_num++;
        this.current_scope = "try" + Integer.toString(try_num);
        try_stmt.setSuite(
                visitSuite(ctx.suite())
        );
        for(PythonParser.Except_clauseContext ec_ctx: ctx.except_clause()){
            this.except_num++;
            this.current_scope = "except" + Integer.toString(except_num);
            try_stmt.add_to_except_clause_arraylist(
                    visitExcept_clause(ec_ctx)
            );
        }

        if(ctx.else_clause() != null){
            this.current_scope = "try_else_clause" + Integer.toString(try_num);
            try_stmt.setElse_clause(
                    visitElse_clause(ctx.else_clause())
            );
        }
        if(ctx.finally_clause() != null){
            this.current_scope = "finally" + Integer.toString(try_num);
            try_stmt.setFinally_clause(
                    visitFinally_clause(ctx.finally_clause())
            );
        }
        return try_stmt;
    }

    @Override
    public Try_Finally_Stmt visitTryFinallyStmt(PythonParser.TryFinallyStmtContext ctx) {
//        return super.visitTry_Finally_Stmt(ctx);
        Try_Finally_Stmt try_finally_stmt = new Try_Finally_Stmt();
        this.try_num++;
        this.current_scope = "try" + Integer.toString(try_num);
        try_finally_stmt.setSuite1(
                visitSuite(ctx.suite().get(0))
        );
        this.current_scope = "finally" + Integer.toString(try_num);
        try_finally_stmt.setSuite2(
                visitSuite(ctx.suite().get(1))
        );
        return try_finally_stmt;
    }

    @Override
    public Else_Clause visitElse_clause(PythonParser.Else_clauseContext ctx) {
//        return super.visitElse_clause(ctx);
        Else_Clause else_clause = new Else_Clause();
        else_clause.setSuite(
                visitSuite(ctx.suite())
        );
        return else_clause;
    }

    @Override
    public Finally_Clause visitFinally_clause(PythonParser.Finally_clauseContext ctx) {
//        return super.visitFinally_clause(ctx);
        Finally_Clause finally_clause = new Finally_Clause();
        finally_clause.setSuite(
                visitSuite(ctx.suite())
        );
        return finally_clause;
    }

    @Override
    public Except_Clause visitExcept_clause(PythonParser.Except_clauseContext ctx) {
//        return super.visitExcept_clause(ctx);
        Except_Clause except_clause = new Except_Clause();
        except_clause.setExcept_expression(
                visitExcept_expression(ctx.except_expression())
        );
        except_clause.setSuite(
                visitSuite(ctx.suite())
        );
        if(ctx.identifier() == null) return except_clause;

        except_clause.setIdentifier(
                visitIdentifier(ctx.identifier())
        );
        return except_clause;
    }

    @Override
    public Except_Expression visitExcept_expression(PythonParser.Except_expressionContext ctx) {
//        return super.visitExcept_expression(ctx);
        Except_Expression except_expression = new Except_Expression();
        for(PythonParser.Exception_typeContext et_ctx: ctx.exception_type()){
            except_expression.add_to_exception_type_arraylist(
                    visitException_type(et_ctx)
            );
        }
        return except_expression;
    }

    @Override
    public Exception_Type visitException_type(PythonParser.Exception_typeContext ctx) {
//        return super.visitException_type(ctx);
        Exception_Type exception_type = new Exception_Type();
        for(PythonParser.IdentifierContext i_ctx: ctx.identifier()){
            exception_type.add_to_identifier_arraylist(
                    visitIdentifier(i_ctx)
            );
        }
        return exception_type;
    }

    @Override
    public With_Stmt visitWith_stmt(PythonParser.With_stmtContext ctx) {
//        return super.visitWith_stmt(ctx);
        With_Stmt with_stmt = new With_Stmt();
        this.with_num++;
        this.current_scope = "with" + Integer.toString(with_num);
        for(PythonParser.With_itemContext wi_ctx: ctx.with_item()){
            with_stmt.add_to_with_item_arraylist(
                    visitWith_item(wi_ctx)
            );
        }
        with_stmt.setSuite(
                visitSuite(ctx.suite())
        );
        return with_stmt;
    }

    @Override
    public With_Item visitWith_item(PythonParser.With_itemContext ctx) {
//        return super.visitWith_item(ctx);
        With_Item with_item = new With_Item();
        with_item.setExpr(
                visitExpr(ctx.expr())
        );
        if(ctx.target() == null) return with_item;

        with_item.setTarget(
                visitTarget(ctx.target())
        );
        return with_item;
    }

    @Override
    public Suite visitSuite(PythonParser.SuiteContext ctx) {
//        return super.visitSuite(ctx);
        Suite suite = new Suite();
        if(ctx.simple_stmt() != null){
            suite.setSimple_stmt(
                    visitSimple_stmt(ctx.simple_stmt())
            );
        }else if(ctx.statements() != null){
            suite.setStatements(
                    visitStatements(ctx.statements())
            );
        }else{
            try {
                throw new Exception("PythonBaseVisitor: visitSuite: the suite provided is not valid !!");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                return null;
            }
        }
        return suite;
    }


    @Override
    public Import_Stmt visitImportStmt(PythonParser.ImportStmtContext ctx) {
//        return super.visitImport_Stmt(ctx);
        Import_Stmt import_stmt = new Import_Stmt();
        import_stmt.setImport_targets(
                visitImport_targets(ctx.import_targets())
        );
        return import_stmt;
    }

    @Override
    public Import_From_Stmt visitImportFromStmt(PythonParser.ImportFromStmtContext ctx) {
//        return super.visitImport_From_Stmt(ctx);
        Import_From_Stmt import_from_stmt = new Import_From_Stmt();
        import_from_stmt.setImport_from_target(
                (Import_From_Target) visit(ctx.import_from_target())
        );
        import_from_stmt.setImport_targets(
                visitImport_targets(ctx.import_targets())
        );
        return import_from_stmt;
    }

    @Override
    public Import_Targets visitImport_targets(PythonParser.Import_targetsContext ctx) {
//        return super.visitImport_targets(ctx);
        Import_Targets import_targets = new Import_Targets();
        for(PythonParser.Import_targetContext it_ctx: ctx.import_target()){
            import_targets.add_to_import_target_arraylist(
                    (Import_Target) visit(it_ctx)
            );
        }
        return import_targets;
    }

    @Override
    public Import_Target visitImportTarget(PythonParser.ImportTargetContext ctx) {
//        return super.visitImport_Target(ctx);
        Import_Target import_target = new Import_Target();
        for(PythonParser.IdentifierContext i_ctx: ctx.identifier()){
            import_target.add_to_identifier_arraylist(
                    visitIdentifier(i_ctx)
            );
        }
        return import_target;

    }

    @Override
    public Import_Star visitImportStar(PythonParser.ImportStarContext ctx) {
//        return super.visitImport_Star(ctx);
        Import_Star import_star = new Import_Star();
        import_star.setStar(ctx.getText());
        return import_star;
    }

    @Override
    public Import_From_Target visitImportFromTarget(PythonParser.ImportFromTargetContext ctx) {
//        return super.visitImport_From_Target(ctx);
        Import_From_Target import_from_target = new Import_From_Target();
        for(PythonParser.IdentifierContext i_ctx: ctx.identifier()){
            import_from_target.add_to_identifier_arraylist(
                    visitIdentifier(i_ctx)
            );
        }
        return import_from_target;
    }


    @Override
    public Import_From_Target_Dots visitImportFromTargetDots(PythonParser.ImportFromTargetDotsContext ctx) {
//        return super.visitImport_From_Target_Dots(ctx);
        Import_From_Target_Dots import_from_target_dots = new Import_From_Target_Dots();
        import_from_target_dots.setDots(ctx.getText());
        return import_from_target_dots;
    }

    @Override
    public Return_Stmt visitReturn_stmt(PythonParser.Return_stmtContext ctx) {
//        return super.visitReturn_stmt(ctx);
        Return_Stmt returnStmt = new Return_Stmt();
        returnStmt.setExpr(
                visitExpr(ctx.expr())
        );
        return returnStmt;
    }

    @Override
    public Raise_Stmt visitRaise_stmt(PythonParser.Raise_stmtContext ctx) {
//        return super.visitRaise_stmt(ctx);
        Raise_Stmt raise_stmt = new Raise_Stmt();
        raise_stmt.setRaise_expression(
                visitRaise_expression(ctx.raise_expression())
        );
        return raise_stmt;
    }

    @Override
    public Raise_Expression visitRaise_expression(PythonParser.Raise_expressionContext ctx) {
//        return super.visitRaise_expression(ctx);
        Raise_Expression raise_expression = new Raise_Expression();
        raise_expression.setException_instance1(
                visitException_instance(ctx.exception_instance().get(0))
        );
        if(ctx.exception_instance().size() < 2) return raise_expression;
        raise_expression.setException_instance2(
                visitException_instance(ctx.exception_instance().get(1))
        );
        return raise_expression;
    }

    @Override
    public Exception_Instance visitException_instance(PythonParser.Exception_instanceContext ctx) {
//        return super.visitException_instance(ctx);
        Exception_Instance exception_instance = new Exception_Instance();
        exception_instance.setException_type(
                visitException_type(ctx.exception_type())
        );
        if(ctx.arguments_list() == null) return exception_instance;

        exception_instance.setArguments_list(
                visitArguments_list(ctx.arguments_list())
        );
        return exception_instance;
    }

    @Override
    public Global_Stmt visitGlobal_stmt(PythonParser.Global_stmtContext ctx) {
//        return super.visitGlobal_stmt(ctx);
        Global_Stmt global_stmt = new Global_Stmt();
        for(PythonParser.IdentifierContext i_ctx: ctx.identifier()){
            global_stmt.add_to_identifier_arraylist(
                    visitIdentifier(i_ctx)
            );
        }
        return global_stmt;
    }

    @Override
    public Break_Stmt visitBreak_stmt(PythonParser.Break_stmtContext ctx) {
//        return super.visitBreak_stmt(ctx);
        Break_Stmt break_stmt = new Break_Stmt();
        break_stmt.setBreak_str(ctx.getText());
        return break_stmt;
    }

    @Override
    public Pass_Stmt visitPass_stmt(PythonParser.Pass_stmtContext ctx) {
//        return super.visitPass_stmt(ctx);
        Pass_Stmt pass_stmt = new Pass_Stmt();
        pass_stmt.setPass_str(ctx.getText());
        return pass_stmt;
    }

    @Override
    public Continue_Stmt visitContinue_stmt(PythonParser.Continue_stmtContext ctx) {
//        return super.visitContinue_stmt(ctx);
        Continue_Stmt continue_stmt = new Continue_Stmt();
        continue_stmt.setContinue_str(ctx.getText());
        return continue_stmt;
    }

    @Override
    public classes.python.Number visitNumber(PythonParser.NumberContext ctx) {
//        return super.visitNumber(ctx);
        classes.python.Number number = new Number();
        number.setNumber(ctx.getText());
        return number;
    }

    @Override
    public Identifier visitIdentifier(PythonParser.IdentifierContext ctx) {
//        return super.visitIdentifier(ctx);
        Identifier identifier = new Identifier();
        identifier.setName(ctx.getText());

        this.symbolTable.addSymbol(ctx.getText(), this.current_symbol_kind , this.current_scope);
        return identifier;
    }
}
