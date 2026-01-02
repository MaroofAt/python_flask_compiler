package classes.css;
public class CssClassSelector extends CssSimpleSelector {
    public String name;
    public CssClassSelector(int line, String name) {
        super(line, "ClassSelector");
        this.name = name;
    }
    public String toString() { return "." + name; }
}
