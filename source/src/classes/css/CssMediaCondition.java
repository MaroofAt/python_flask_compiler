package classes.css;

public class CssMediaCondition extends CssNode {

    public String property;
    public CssValue value;

    public CssMediaCondition(int line, String property, CssValue value) {
        super(line, "MediaCondition");
        this.property = property;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + property + ":" + value + ")";
    }
}
