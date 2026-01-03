package exec;

import gen.*;
import visitors.css.CssAstVisitor;
import classes.css.CssNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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

        CssAstVisitor visitor = new CssAstVisitor();
        CssNode ast = visitor.visit(tree);

        System.out.println("==== CSS AST ====");
       // ast.print("");
    }
}
