package classes.python;

import java.util.ArrayList;

public class Application {
    Statements statements;

    public Application() {
        this.statements = new Statements();
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "\nApplication{" +
                "\nstatements=" + statements +
                "\n}";
    }
}
