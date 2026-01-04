package exec;

import antlr.*;
import gen.Jinja2Lexer;
import gen.Jinja2Parser;
import visitors.jinja2.JinjaAstVisitor;
import classes.jinja.JinjaNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import visitors.jinja2.JinjaSymbolVisitor;

public class MainJinja {

    public static void main(String[] args) {

        String input = """
            {% if user %}
                Hello {{ user }}
            {% endif %}
        """;

        CharStream cs = CharStreams.fromString(input);
        Jinja2Lexer lexer = new Jinja2Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Jinja2Parser parser = new Jinja2Parser(tokens);

        ParseTree tree = parser.template();

        JinjaAstVisitor visitor = new JinjaAstVisitor();
        JinjaNode ast = visitor.visit(tree);

        System.out.println("==== JINJA AST ====");
        ast.print("");

        JinjaSymbolVisitor symVisitor = new JinjaSymbolVisitor();
        symVisitor.visit(ast);
        symVisitor.getTable().print();

    }
}
