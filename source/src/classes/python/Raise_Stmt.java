package classes.python;

public class Raise_Stmt extends Small_Stmt{
    private Raise_Expression raise_expression;

    public Raise_Stmt() {
        this.raise_expression = new Raise_Expression();
    }

    public Raise_Expression getRaise_expression() {
        return raise_expression;
    }
    public void setRaise_expression(Raise_Expression raise_expression) {
        this.raise_expression = raise_expression;
    }

    @Override
    public String toString() {
        return "\nRaise_Stmt{" +
                "\nraise_expression=" + raise_expression +
                "\n}";
    }
}
