package classes.css;

public class CssDeclaration extends CssNode {

    public String property;
    public CssValue value;

    public CssDeclaration(int line, String property, CssValue value) {
        super(line, "Declaration");
        this.property = property;
        this.value = value;
    }

    @Override
    public String toString() {
        return property + ":" + value;
    }
}
