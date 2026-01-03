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
    protected void printChildren(String indent) {
        condition.print(indent);
        body.print(indent);
        for (IfStmt e : elifs)
            e.print(indent);
        if (elseBody != null)
            elseBody.print(indent);
    }


    @Override
    public String toString() {
        return "\nIf(" + condition + ")" + body;
    }
}
