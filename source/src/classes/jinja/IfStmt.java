package classes.jinja;

import java.util.ArrayList;

public class IfStmt extends JinjaStatement {

    public JinjaExpression condition;
    public JinjaBody body;
    public ArrayList<IfStmt> elifs = new ArrayList<>();
    public JinjaBody elseBody;

    public IfStmt(int line, JinjaExpression condition, JinjaBody body) {
        super(line, "IfStmt");
        this.condition = condition;
        this.body = body;
    }

    @Override
    public String toString() {
        return "\nIf(" + condition + ")" + body;
    }
}
