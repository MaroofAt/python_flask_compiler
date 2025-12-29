package classes.python;

public class Decorator {
    private Decorator_Expression decorator_expression;

    public Decorator() {
        this.decorator_expression = new Decorator_Expression();
    }

    public Decorator_Expression getDecorator_expression() {
        return decorator_expression;
    }
    public void setDecorator_expression(Decorator_Expression decorator_expression) {
        this.decorator_expression = decorator_expression;
    }

    @Override
    public String toString() {
        return "\nDecorator{" +
                "\ndecorator_expression=" + decorator_expression +
                "\n}";
    }
}
