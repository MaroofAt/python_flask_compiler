package classes.python;

public class Augmented_Assignment_Operator {
    private String operator_str;

    public Augmented_Assignment_Operator() {
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
        return "\nAugmented_Assignment_Operator{" +
                "\noperator_str='" + operator_str + '\'' +
                "\n}";
    }
}
