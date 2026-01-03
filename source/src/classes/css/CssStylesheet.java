package classes.css;

import java.util.ArrayList;

public class CssStylesheet extends CssNode {

    public ArrayList<CssRuleSet> ruleSets = new ArrayList<>();
    public ArrayList<CssMediaRule> mediaRules = new ArrayList<>();

    public CssStylesheet(int line) {
        super(line, "Stylesheet");
    }

    @Override
    protected void printChildren(String indent) {
        for (CssRuleSet r : ruleSets) {
            r.print(indent);
        }
        for (CssMediaRule m : mediaRules) {
            m.print(indent);
        }
    }

    @Override
    public String toString() {
        return "\nCssStylesheet{" +
                "\nruleSets=" + ruleSets +
                "\nmediaRules=" + mediaRules +
                "\n}";
    }
}
