package classes.css;

public class CssLiteralValue extends CssValue {

    public String value;

    public CssLiteralValue(int line, String value) {
        super(line, "LiteralValue");
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
