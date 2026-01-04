package symbols.html;

import java.util.ArrayList;
import java.util.List;

public class HtmlSymbolTable {

    private HtmlSymbolTable parent;
    private List<HtmlSymbolTable> children = new ArrayList<>();
    private List<HtmlSymbol> symbols = new ArrayList<>();

    public HtmlSymbolTable(HtmlSymbolTable parent) {
        this.parent = parent;
        if (parent != null) {
            parent.children.add(this);
        }
    }

    public void define(HtmlSymbol symbol) {
        symbols.add(symbol);
    }

    public HtmlSymbolTable getParent() {
        return parent;
    }

    public List<HtmlSymbolTable> getChildren() {
        return children;
    }

    public List<HtmlSymbol> getSymbols() {
        return symbols;
    }

    public void print(String indent) {
        System.out.println(indent + "Scope {");
        for (HtmlSymbol s : symbols) {
            System.out.println(indent + "  " + s);
        }
        for (HtmlSymbolTable child : children) {
            child.print(indent + "  ");
        }
        System.out.println(indent + "}");
    }
}
