package classes.python;

public class Decorator_Expression {
    private Dotted_Name dotted_name;
    private Call call; //nullable

    public Decorator_Expression() {
        this.dotted_name = new Dotted_Name();
        this.call = null;
    }

    public Dotted_Name getDotted_name() {
        return dotted_name;
    }
    public void setDotted_name(Dotted_Name dotted_name) {
        this.dotted_name = dotted_name;
    }

    public Call getCall() {
        if(call == null){
            this.call = new Call();
        }
        return call;
    }
    public void setCall(Call call) {
        this.call = call;
    }

    @Override
    public String toString() {
        String result = "\nDecorator_Expression{" +
                "\ndotted_name=" + dotted_name;
        if(call != null) {
            result += "\n, call=" + call;
        }
        result += "\n}";
        return result;
    }
}
