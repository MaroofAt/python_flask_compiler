package symbols.jinja;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {

    private Map<String, Symbol> symbols = new LinkedHashMap<>();
    private Scope parent;

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public void define(Symbol symbol) {
        symbols.put(symbol.name, symbol);
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name))
            return symbols.get(name);
        if (parent != null)
            return parent.resolve(name);
        return null;
    }

    public Scope getParent() {
        return parent;
    }

    public void print(String indent) {
        for (Symbol s : symbols.values()) {
            System.out.println(indent + s);
        }
    }
}
