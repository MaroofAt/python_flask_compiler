package exec;

import antlr.*;
import classes.html.DocumentNode;
import symbols.html.HtmlSymbolTable;
import visitors.html.HtmlAstVisitor;
import classes.html.HtmlNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import visitors.html.HtmlSymbolTableVisitor;

public class MainHtml {

    public static void main(String[] args) throws Exception {

        String input = """
            <div>
                <span>Hello</span>
                <img/>
            </div>
        """;

        CharStream cs = CharStreams.fromString(input);
        LexerHtml lexer = new LexerHtml(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserHtml parser = new ParserHtml(tokens);

        ParseTree tree = parser.document();

        HtmlAstVisitor visitor = new HtmlAstVisitor();
        HtmlNode ast = visitor.visit(tree);

        System.out.println("==== HTML AST ====");
        ast.print("");

        System.out.println("\n==== SYMBOL TABLE ====");
        HtmlSymbolTableVisitor stVisitor = new HtmlSymbolTableVisitor();
        HtmlSymbolTable table = stVisitor.build((DocumentNode) ast);
        table.print("");
    }
}
