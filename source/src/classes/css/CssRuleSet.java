package classes.css;

import java.util.ArrayList;

public class CssRuleSet extends CssNode {

    public ArrayList<CssSelector> selectors = new ArrayList<>();
    public ArrayList<CssDeclaration> declarations = new ArrayList<>();

    public CssRuleSet(int line) {
        super(line, "RuleSet");
    }

    @Override
    protected void printChildren(String indent) {
        for (CssSelector s : selectors) {
            s.print(indent);
        }
        for (CssDeclaration d : declarations) {
            d.print(indent);
        }
    }

    @Override
    public String toString() {
        return "\nCssRuleSet{" +
                "\nselectors=" + selectors +
                "\ndeclarations=" + declarations +
                "\n}";
    }
}
