package classes.jinja;


public class SetStmt extends JinjaStatement {

    public String name;
    public JinjaExpression value;

    public SetStmt(int line, String name, JinjaExpression value) {
        super(line, "SetStmt");
        this.name = name;
        this.value = value;
    }
    @Override
    protected void printChildren(String indent) {
        value.print(indent);
    }


    public String toString() {
        return "{% set " + name + " = " + value + " %}";
    }
}
