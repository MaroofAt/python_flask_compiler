package classes.css;

import java.util.ArrayList;

public class CssSelector extends CssNode {

    public ArrayList<CssSimpleSelector> parts = new ArrayList<>();

    public CssSelector(int line) {
        super(line, "Selector");
    }

    @Override
    public String toString() {
        return parts.toString();
    }
}
