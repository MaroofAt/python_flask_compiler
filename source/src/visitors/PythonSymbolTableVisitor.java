package visitors;

import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;
import classes.python.symbols.*;

public class PythonSymbolTableVisitor extends PythonParserBaseVisitor<Void> {

    public SymbolTable symbolTable = new SymbolTable();
    private String currentScope = "global";

    @Override
    public Void visitFunc_def(PythonParser.Func_defContext ctx) {
        String funcName = ctx.identifier().getText();

        symbolTable.addSymbol(funcName, "function", "global");

        currentScope = funcName;
        visitChildren(ctx);
        currentScope = "global";

        return null;
    }

    @Override
    public Void visitRegular_Assignment(
            PythonParser.Regular_AssignmentContext ctx) {

        String varName = ctx.target_list(0).getText();
        symbolTable.addSymbol(varName, "variable", currentScope);

        return null;
    }
}