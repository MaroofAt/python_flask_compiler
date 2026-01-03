package visitors.html;

import classes.html.*;
import gen.ParserHtml;
import gen.ParserHtmlBaseVisitor;

public class HtmlAstVisitor extends ParserHtmlBaseVisitor<HtmlNode> {

    // =========================
    // document
    // =========================
    @Override
    public HtmlNode visitDocument(ParserHtml.DocumentContext ctx) {
        DocumentNode document =
                new DocumentNode(ctx.getStart().getLine());

        for (ParserHtml.ElementContext el : ctx.element()) {
            document.addElement(visit(el));
        }

        return document;
    }

    // =========================
    // element types
    // =========================
    @Override
    public HtmlNode visitNormalElementNode(ParserHtml.NormalElementNodeContext ctx) {

        // open tag
        String tagName = ctx.openTag().TAG_NAME().getText();
        OpenTagNode openTag =
                new OpenTagNode(ctx.getStart().getLine(), tagName);

        for (ParserHtml.AttributeContext attrCtx : ctx.openTag().attribute()) {
            openTag.addAttribute((AttributeNode) visit(attrCtx));
        }

        // close tag
        CloseTagNode closeTag =
                new CloseTagNode(
                        ctx.getStart().getLine(),
                        ctx.closeTag().TAG_NAME().getText()
                );

        // element
        NormalElementNode element =
                new NormalElementNode(
                        ctx.getStart().getLine(),
                        openTag,
                        closeTag
                );

        // content
        for (ParserHtml.ElementContext child : ctx.content().element()) {
            element.addContent(visit(child));
        }

        return element;
    }

    @Override
    public HtmlNode visitSelfClosingElementNode(
            ParserHtml.SelfClosingElementNodeContext ctx) {

        String tagName = ctx.selfClosingTag().TAG_NAME().getText();
        SelfClosingElementNode node =
                new SelfClosingElementNode(ctx.getStart().getLine(), tagName);

        for (ParserHtml.AttributeContext attrCtx :
                ctx.selfClosingTag().attribute()) {
            node.addAttribute((AttributeNode) visit(attrCtx));
        }

        return node;
    }

    @Override
    public HtmlNode visitVoidElementNode(
            ParserHtml.VoidElementNodeContext ctx) {

        String tagName = ctx.voidElement().VOID_TAG().getText();
        VoidElementNode node =
                new VoidElementNode(ctx.getStart().getLine(), tagName);

        for (ParserHtml.AttributeContext attrCtx :
                ctx.voidElement().attribute()) {
            node.addAttribute((AttributeNode) visit(attrCtx));
        }

        return node;
    }

    @Override
    public HtmlNode visitTextNode(ParserHtml.TextNodeContext ctx) {
        return new TextNode(
                ctx.getStart().getLine(),
                ctx.TEXT().getText()
        );
    }

    // =========================
    // attributes
    // =========================
    @Override
    public HtmlNode visitNormalAttributeNode(
            ParserHtml.NormalAttributeNodeContext ctx) {

        return new NormalAttributeNode(
                ctx.getStart().getLine(),
                ctx.TAG_NAME().getText(),
                ctx.STRING().getText()
        );
    }

    @Override
    public HtmlNode visitBooleanAttributeNode(
            ParserHtml.BooleanAttributeNodeContext ctx) {

        return new BooleanAttributeNode(
                ctx.getStart().getLine(),
                ctx.TAG_NAME().getText()
        );
    }
}
