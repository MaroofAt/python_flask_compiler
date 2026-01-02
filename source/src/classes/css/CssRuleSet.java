package classes.css;

import java.util.ArrayList;

public class CssRuleSet extends CssNode {

    public ArrayList<CssSelector> selectors = new ArrayList<>();
    public ArrayList<CssDeclaration> declarations = new ArrayList<>();

    public CssRuleSet(int line) {
        super(line, "RuleSet");
    }

    @Override
    public String toString() {
        return "\nCssRuleSet{" +
                "\nselectors=" + selectors +
                "\ndeclarations=" + declarations +
                "\n}";
    }
}
