package classes.python;

public class Unary_Op {
    private String operator_str;

    public Unary_Op() {
        this.operator_str = new String();
    }

    public String getOperator_str() {
        return operator_str;
    }
    public void setOperator_str(String operator_str) {
        this.operator_str = operator_str;
    }

    @Override
    public String toString() {
        return "\nUnary_Op{" +
                "\noperator_str='" + operator_str + '\'' +
                "\n}";
    }
}
