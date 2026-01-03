package classes.python.symbols;

import java.util.HashMap;
import java.util.Map;

public class Scope {
    public String name;
    public Map<String, Symbol> symbols = new HashMap<>();

    public Scope(String name) {
        this.name = name;
    }

    public void define(Symbol symbol) {
        symbols.putIfAbsent(symbol.name, symbol);
    }
}
