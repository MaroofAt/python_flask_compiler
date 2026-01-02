public class SetStmt extends JinjaStatement {

    public String name;
    public JinjaExpression value;

    public SetStmt(int line, String name, JinjaExpression value) {
        super(line, "SetStmt");
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return "{% set " + name + " = " + value + " %}";
    }
}
