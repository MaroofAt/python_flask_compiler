package classes.css;

public class CssIdSelector extends CssSimpleSelector {
    public String name;
    public CssIdSelector(int line, String name) {
        super(line, "IdSelector");
        this.name = name;
    }
    public String toString() { return "#" + name; }
}
