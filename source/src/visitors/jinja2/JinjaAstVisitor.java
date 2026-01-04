

package visitors.jinja2;

import classes.jinja.*;
import antlr.Jinja2Parser;
import antlr.Jinja2ParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class JinjaAstVisitor extends Jinja2ParserBaseVisitor<JinjaNode> {

    @Override
    public JinjaNode visitTemplate(Jinja2Parser.TemplateContext ctx) {
        JinjaTemplate template = new JinjaTemplate(ctx.getStart().getLine());

        for (var t : ctx.text()) {
            template.add(visit(t));
        }
        for (var s : ctx.statement()) {
            template.add(visit(s));
        }
        for (var e : ctx.expression()) {
            template.add(visit(e));
        }
        for (var c : ctx.comment()) {
            template.add(visit(c));
        }
        for (var r : ctx.raw_stmt()) {
            template.add(visit(r));
        }
        for (var d : ctx.document()) {
            template.add(visit(d));
        }
        return template;
    }

    @Override
    public JinjaNode visitStatementNode(Jinja2Parser.StatementNodeContext ctx) {
        return visit(ctx.stmt());
    }

    @Override
    public JinjaNode visitTextContent(Jinja2Parser.TextContentContext ctx) {
        return new JinjaText(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }

    @Override
    public JinjaNode visitCommentNode(Jinja2Parser.CommentNodeContext ctx) {
        return new JinjaComment(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }

    @Override
    public JinjaNode visitRawStmtNode(Jinja2Parser.RawStmtNodeContext ctx) {
        return new JinjaRaw(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }

    /* ========= EXPRESSIONS ========= */

    @Override
    public JinjaNode visitExprName(Jinja2Parser.ExprNameContext ctx) {
        return new NameExpr(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }

    @Override
    public JinjaNode visitStringAtom(Jinja2Parser.StringAtomContext ctx) {
        return new LiteralExpr(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }

    @Override
    public JinjaNode visitNumberAtom(Jinja2Parser.NumberAtomContext ctx) {
        return new LiteralExpr(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }

    /* ========= BODY ========= */

    @Override
    public JinjaNode visitBodyNode(Jinja2Parser.BodyNodeContext ctx) {
        JinjaBody body = new JinjaBody(ctx.getStart().getLine());

        for (var s : ctx.statement()) body.add(visit(s));
        for (var t : ctx.text()) body.add(visit(t));
        for (var e : ctx.expression()) body.add(visit(e));
        for (var c : ctx.comment()) body.add(visit(c));
        for (var d : ctx.document()) body.add(visit(d));

        return body;
    }


    /* ========= IF ========= */

    @Override
    public JinjaNode visitIfStmtNode(Jinja2Parser.IfStmtNodeContext ctx) {

        // if condition
        JinjaExpression condition =
                (JinjaExpression) visit(ctx.test_stmt(0));

        JinjaBody ifBody =
                (JinjaBody) visit(ctx.body(0));

        IfStmt stmt = new IfStmt(ctx.getStart().getLine(), condition, ifBody);

        // elif blocks
        for (int i = 1; i < ctx.test_stmt().size(); i++) {
            JinjaExpression elifCond =
                    (JinjaExpression) visit(ctx.test_stmt(i));
            JinjaBody elifBody =
                    (JinjaBody) visit(ctx.body(i));

            stmt.elifs.add(new IfStmt(
                    ctx.getStart().getLine(),
                    elifCond,
                    elifBody
            ));
        }

        // else block
        if (ctx.JINJA2_ELSE() != null) {
            stmt.elseBody =
                    (JinjaBody) visit(ctx.body(ctx.body().size() - 1));
        }

        return stmt;
    }

    @Override
    public JinjaNode visitExpressionNode(Jinja2Parser.ExpressionNodeContext ctx) {
        return visit(ctx.expr());
    }
    @Override
    public JinjaNode visitTestStmtNode(Jinja2Parser.TestStmtNodeContext ctx) {
        return visit(ctx.or_test_stmt());
    }
    @Override
    public JinjaNode visitSetStmtNode(Jinja2Parser.SetStmtNodeContext ctx) {
        return new SetStmt(
                ctx.getStart().getLine(),
                ctx.name().getText(),
                (JinjaExpression) visit(ctx.expr_stmt2())
        );
    }


    @Override
    public JinjaNode visitOrTestStmtNode(Jinja2Parser.OrTestStmtNodeContext ctx) {
        JinjaExpression left =
                (JinjaExpression) visit(ctx.and_test_stmt(0));

        for (int i = 1; i < ctx.and_test_stmt().size(); i++) {
            JinjaExpression right =
                    (JinjaExpression) visit(ctx.and_test_stmt(i));
            left = new BinaryExpr(
                    ctx.getStart().getLine(),
                    left,
                    "or",
                    right
            );
        }
        return left;
    }
    @Override
    public JinjaNode visitAndTestStmtNode(Jinja2Parser.AndTestStmtNodeContext ctx) {
        JinjaExpression left =
                (JinjaExpression) visit(ctx.not_test_stmt(0));

        for (int i = 1; i < ctx.not_test_stmt().size(); i++) {
            JinjaExpression right =
                    (JinjaExpression) visit(ctx.not_test_stmt(i));
            left = new BinaryExpr(
                    ctx.getStart().getLine(),
                    left,
                    "and",
                    right
            );
        }
        return left;
    }



    @Override
    public JinjaNode visitComparisonStmtNode(Jinja2Parser.ComparisonStmtNodeContext ctx) {
        return visit(ctx.arith_stmt(0));
    }@Override
    public JinjaNode visitArithStmtNode(Jinja2Parser.ArithStmtNodeContext ctx) {
        return visit(ctx.term_stmt(0));
    }

    @Override
    public JinjaNode visitTermStmtNode(Jinja2Parser.TermStmtNodeContext ctx) {
        return visit(ctx.factor_stmt(0));
    }

    @Override
    public JinjaNode visitPowerFactorStmtNode(Jinja2Parser.PowerFactorStmtNodeContext ctx) {
        return visit(ctx.power_stmt());
    }
    @Override
    public JinjaNode visitStmtNameAtom(Jinja2Parser.StmtNameAtomContext ctx) {
        return new NameExpr(
                ctx.getStart().getLine(),
                ctx.getText()
        );
    }


}
