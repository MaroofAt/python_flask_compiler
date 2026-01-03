
package classes.css;

public class CssTypeSelector extends CssSimpleSelector {
    public String name;
    public CssTypeSelector(int line, String name) {
        super(line, "TypeSelector");
        this.name = name;
    }
    @Override
    protected void printChildren(String indent) {
    }
    public String toString() { return name; }
}
