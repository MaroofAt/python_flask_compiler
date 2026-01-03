package exec;

import antlr.*;
import visitors.jinja2.JinjaAstVisitor;
import classes.jinja.JinjaNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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
     //   ast.print("");
    }
}
