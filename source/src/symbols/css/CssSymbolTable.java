package symbols.css;

import java.util.ArrayList;
import java.util.List;

public class CssSymbolTable {

    private final List<CssSymbol> symbols = new ArrayList<>();

    public void define(CssSymbol symbol) {
        symbols.add(symbol);
    }

    public void print() {
        if (symbols.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (CssSymbol s : symbols) {
            s.print();

        }
    }
}
