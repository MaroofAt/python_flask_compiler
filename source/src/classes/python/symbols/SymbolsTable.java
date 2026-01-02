package classes.python.symbols;

import java.util.*;

public class SymbolTable {
    public Map<String, Scope> scopes = new HashMap<>();

    public void addSymbol(String name, String kind, String scopeName) {
        scopes.putIfAbsent(scopeName, new Scope(scopeName));
        Scope scope = scopes.get(scopeName);
        scope.define(new Symbol(name, kind, scopeName));
    }

    public void print() {
        for (Scope scope : scopes.values()) {
            System.out.println("Scope: " + scope.name);
            for (Symbol s : scope.symbols.values()) {
                System.out.println("  " + s.name + " -> " + s.kind);
            }
        }
    }
}