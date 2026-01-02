package classes.css;

import java.util.ArrayList;

public class CssMediaRule extends CssNode {

    public CssMediaCondition condition;
    public ArrayList<CssRuleSet> ruleSets = new ArrayList<>();

    public CssMediaRule(int line, CssMediaCondition condition) {
        super(line, "MediaRule");
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "\nCssMediaRule{" +
                "\ncondition=" + condition +
                "\nruleSets=" + ruleSets +
                "\n}";
    }
}
