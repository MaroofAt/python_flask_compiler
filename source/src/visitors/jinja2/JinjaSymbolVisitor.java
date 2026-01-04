package visitors.jinja2;

import classes.jinja.*;
import symbols.jinja.LoopVariableSymbol;
import symbols.jinja.SymbolTable;
import symbols.jinja.VariableSymbol;

public class JinjaSymbolVisitor {

    private SymbolTable table = new SymbolTable();

    public SymbolTable getTable() {
        return table;
    }

    public void visit(JinjaNode node) {
        if (node instanceof JinjaTemplate t) {
            for (var c : t.children) visit(c);
        }

        else if (node instanceof IfStmt i) {
            visit(i.condition);

            table.enterScope();
            visit(i.body);
            table.exitScope();
        }

        else if (node instanceof ForStmt f) {
            table.enterScope();
            table.define(new LoopVariableSymbol(
                    f.variable,
                    f.getLine()
            ));
            visit(f.iterable);
            visit(f.body);
            table.exitScope();
        }

        else if (node instanceof SetStmt s) {
            table.define(new VariableSymbol(
                    s.name,
                    s.getLine()
            ));
            visit(s.value);
        }

        else if (node instanceof NameExpr n) {
            if (table.resolve(n.name) == null) {
                table.define(new VariableSymbol(
                        n.name,
                        n.getLine()
                ));
            }
        }

        else if (node instanceof JinjaBody b) {
            for (var e : b.elements) visit(e);
        }
    }
}
