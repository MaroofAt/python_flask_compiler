package exec;

import antlr.PythonLexer;
import antlr.PythonParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        try {
            test_python_lexer_and_parser();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    static void test_python_lexer_and_parser(){
        try{
            // 1. Read source file
            String source = Files.readString(Path.of("D:\\Projects\\Compiler\\python_flask_compiler\\source\\src\\exec\\test.py"));

            // 2. Create lexer
            CharStream input = CharStreams.fromString(source);
            PythonLexer lexer = new PythonLexer(input);

            // 3. Token stream
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // DEBUG: print tokens
            tokens.fill();
            for (Token t : tokens.getTokens()) {
                System.out.printf(
                        "%-15s '%s'%n",
                        PythonLexer.VOCABULARY.getSymbolicName(t.getType()),
                        t.getText().replace("\n", "\\n")
                );
            }

            // 4. Parse
            PythonParser parser = new PythonParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new DiagnosticErrorListener());

            ParseTree tree = parser.application();

            // 5. Print parse tree
            System.out.println("\n\nParse Tree:\n");
            printTree(tree, parser, 0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void printTree(ParseTree tree, Parser parser, int indent) {
        String prefix = "  ".repeat(indent);
        String nodeText = Trees.getNodeText(tree, parser);
        System.out.println(prefix + nodeText);

        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), parser, indent + 1);
        }
    }

}
