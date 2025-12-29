package classes.python;

public class Raise_Expression {
    private Exception_Instance exception_instance1;
    private Exception_Instance exception_instance2; //nullable

    public Raise_Expression() {
        this.exception_instance1 = new Exception_Instance();
        this.exception_instance2 = null;
    }

    public Exception_Instance getException_instance1() {
        return exception_instance1;
    }
    public void setException_instance1(Exception_Instance exception_instance1) {
        this.exception_instance1 = exception_instance1;
    }

    public Exception_Instance getException_instance2() {
        if(exception_instance2 == null){
            this.exception_instance2 = new Exception_Instance();
        }
        return exception_instance2;
    }
    public void setException_instance2(Exception_Instance exception_instance2) {
        this.exception_instance2 = exception_instance2;
    }

    @Override
    public String toString() {
        String result = "Raise_Expression{" +
                "exception_instance1=" + exception_instance1;
        if(exception_instance2 != null) {
            result += ", exception_instance2=" + exception_instance2;
        }
        result += '}';
        return result;
    }
}
