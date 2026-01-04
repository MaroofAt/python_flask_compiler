package exec;

import antlr.*;
import classes.css.CssStylesheet;
import symbols.css.CssSymbolTable;
import visitors.css.CssAstVisitor;
import classes.css.CssNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import visitors.css.CssSymbolTableVisitor;

public class MainCss {

    public static void main(String[] args) {

        String input = """
            body {
                color: red;
                margin: 10px;
            }
        """;

        CharStream cs = CharStreams.fromString(input);
        LexerCss lexer = new LexerCss(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserCss parser = new ParserCss(tokens);

        ParseTree tree = parser.stylesheet();
        CssAstVisitor astVisitor = new CssAstVisitor();
        CssNode ast = astVisitor.visit(tree);

        System.out.println("==== CSS AST ====");
        ast.print("");

        CssSymbolTableVisitor symbolVisitor = new CssSymbolTableVisitor();
        CssSymbolTable table = symbolVisitor.build((CssStylesheet) ast);

        System.out.println("==== CSS SYMBOL TABLE ====");
        table.print();


    }
}
