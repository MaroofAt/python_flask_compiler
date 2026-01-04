package visitors.html;

import classes.html.*;
import symbols.html.*;

public class HtmlSymbolTableVisitor {

    private HtmlSymbolTable currentScope;

    public HtmlSymbolTable build(DocumentNode document) {
        currentScope = new HtmlSymbolTable(null);
        visit(document);
        return currentScope;
    }

    private void visit(HtmlNode node) {

        if (node instanceof DocumentNode doc) {
            for (HtmlNode el : doc.getElements()) {
                visit(el);
            }
        }

        else if (node instanceof NormalElementNode el) {

            currentScope.define(
                    new TagSymbol(
                            el.getOpenTag().getTagName(),
                            el.getLine()
                    )
            );

            HtmlSymbolTable previous = currentScope;
            currentScope = new HtmlSymbolTable(previous);

            for (AttributeNode attr : el.getOpenTag().getAttributes()) {
                visit(attr);
            }

            for (HtmlNode child : el.getContent()) {
                visit(child);
            }

            currentScope = previous;
        }

        else if (node instanceof SelfClosingElementNode el) {

            currentScope.define(
                    new TagSymbol(el.getTagName(), el.getLine())
            );

            HtmlSymbolTable previous = currentScope;
            currentScope = new HtmlSymbolTable(previous);

            for (AttributeNode attr : el.getAttributes()) {
                visit(attr);
            }

            currentScope = previous;
        }

        else if (node instanceof VoidElementNode el) {

            currentScope.define(
                    new TagSymbol(el.getTagName(), el.getLine())
            );

            HtmlSymbolTable previous = currentScope;
            currentScope = new HtmlSymbolTable(previous);

            for (AttributeNode attr : el.getAttributes()) {
                visit(attr);
            }

            currentScope = previous;
        }

        else if (node instanceof NormalAttributeNode attr) {

            currentScope.define(
                    new AttributeSymbol(
                            attr.getname(),
                            attr.getValue(),
                            attr.getLine()
                    )
            );
        }

        else if (node instanceof BooleanAttributeNode attr) {

            currentScope.define(
                    new AttributeSymbol(
                            attr.getname(),
                            null,
                            attr.getLine()
                    )
            );
        }
    }
}
