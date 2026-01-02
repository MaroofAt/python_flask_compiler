package classes.css;


public class CssUniversalSelector extends CssSimpleSelector {
    public CssUniversalSelector(int line) {
        super(line, "UniversalSelector");
    }
    public String toString() { return "*"; }
}
