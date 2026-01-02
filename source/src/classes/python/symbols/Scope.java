package classes.python.symbols;
mport java.util.*;

public class Scope {
    public String name;
    public Map<String, Symbol> symbols = new HashMap<>();

    public Scope(String name) {
        this.name = name;
    }

    public void define(Symbol symbol) {
        symbols.put(symbol.name, symbol);
    }
}