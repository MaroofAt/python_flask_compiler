package symbols.jinja;

import java.util.Stack;

public class SymbolTable {

    private Stack<Scope> scopes = new Stack<>();

    public SymbolTable() {
        enterScope(); // global
    }

    public void enterScope() {
        Scope parent = scopes.isEmpty() ? null : scopes.peek();
        scopes.push(new Scope(parent));
    }

    public void exitScope() {
        scopes.pop();
    }

    public void define(Symbol symbol) {
        scopes.peek().define(symbol);
    }

    public Symbol resolve(String name) {
        return scopes.peek().resolve(name);
    }

    public void print() {
        System.out.println("=== JINJA SYMBOL TABLE ===");
        int i = 0;
        for (Scope s : scopes) {
            System.out.println("Scope " + i++);
            s.print("  ");
        }
    }
}
