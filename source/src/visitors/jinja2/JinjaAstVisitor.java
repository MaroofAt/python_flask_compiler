package visitors.jinja2;

import classes.jinja.*;
import gen.Jinja2Parser;
import gen.Jinja2ParserBaseVisitor;

public class JinjaAstVisitor extends Jinja2ParserBaseVisitor<JinjaNode> {


    @Override
    public JinjaNode visitTemplate(Jinja2Parser.TemplateContext ctx) {

        JinjaTemplate template =
                new JinjaTemplate(ctx.getStart().getLine());

        for (var child : ctx.children) {
            JinjaNode node = visit(child);
            if (node != null) {
                template.add(node);
            }
        }

        return template;
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

    @Override
    public JinjaNode visitTrueAtom(Jinja2Parser.TrueAtomContext ctx) {
        return new LiteralExpr(
                ctx.getStart().getLine(),
                "true"
        );
    }

    @Override
    public JinjaNode visitFalseAtom(Jinja2Parser.FalseAtomContext ctx) {
        return new LiteralExpr(
                ctx.getStart().getLine(),
                "false"
        );
    }

    @Override
    public JinjaNode visitNoneAtom(Jinja2Parser.NoneAtomContext ctx) {
        return new LiteralExpr(
                ctx.getStart().getLine(),
                "None"
        );
    }


    @Override
    public JinjaNode visitArithExprNode(Jinja2Parser.ArithExprNodeContext ctx) {

        JinjaExpression left =
                (JinjaExpression) visit(ctx.term(0));

        for (int i = 1; i < ctx.term().size(); i++) {
            String op = ctx.add_op(i - 1).getText();
            JinjaExpression right =
                    (JinjaExpression) visit(ctx.term(i));

            left = new BinaryExpr(
                    ctx.getStart().getLine(),
                    left,
                    op,
                    right
            );
        }

        return left;
    }

    @Override
    public JinjaNode visitUnaryFactorNode(Jinja2Parser.UnaryFactorNodeContext ctx) {

        return new UnaryExpr(
                ctx.getStart().getLine(),
                ctx.getChild(0).getText(),
                (JinjaExpression) visit(ctx.factor())
        );
    }

    @Override
    public JinjaNode visitIfStmtNode(Jinja2Parser.IfStmtNodeContext ctx) {

        // if condition
        JinjaExpression condition =
                (JinjaExpression) visit(ctx.test_stmt(0));

        JinjaBody ifBody =
                (JinjaBody) visit(ctx.body(0));

        IfStmt stmt =
                new IfStmt(ctx.getStart().getLine(), condition, ifBody);

        // elif blocks
        for (int i = 1; i < ctx.test_stmt().size(); i++) {

            JinjaExpression elifCond =
                    (JinjaExpression) visit(ctx.test_stmt(i));

            JinjaBody elifBody =
                    (JinjaBody) visit(ctx.body(i));

            stmt.elifs.add(
                    new IfStmt(ctx.getStart().getLine(), elifCond, elifBody)
            );
        }

        // else block
        if (ctx.body().size() > ctx.test_stmt().size()) {
            stmt.elseBody =
                    (JinjaBody) visit(ctx.body(ctx.body().size() - 1));
        }

        return stmt;
    }


    @Override
    public JinjaNode visitForStmtNode(Jinja2Parser.ForStmtNodeContext ctx) {

        return new ForStmt(
                ctx.getStart().getLine(),
                ctx.name(0).getText(),
                (JinjaExpression) visit(ctx.expr_stmt2()),
                (JinjaBody) visit(ctx.body())
        );
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
    public JinjaNode visitBodyNode(Jinja2Parser.BodyNodeContext ctx) {

        JinjaBody body =
                new JinjaBody(ctx.getStart().getLine());

        for (var child : ctx.children) {
            JinjaNode node = visit(child);
            if (node != null) {
                body.add(node);
            }
        }

        return body;
    }
}
