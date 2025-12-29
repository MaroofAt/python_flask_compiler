package classes.python;

public class Exception_Instance {
    private Exception_Type exception_type;
    private Arguments_List arguments_list; //nullable

    public Exception_Instance() {
        this.exception_type = new Exception_Type();
        this.arguments_list = null;
    }

    public Exception_Type getException_type() {
        return exception_type;
    }
    public void setException_type(Exception_Type exception_type) {
        this.exception_type = exception_type;
    }

    public Arguments_List getArguments_list() {
        if(arguments_list == null){
            this.arguments_list = new Arguments_List();
        }
        return arguments_list;
    }
    public void setArguments_list(Arguments_List arguments_list) {
        this.arguments_list = arguments_list;
    }

    @Override
    public String toString() {
        String result = "\nException_Instance{" +
                "\nexception_type=" + exception_type;
        if(arguments_list != null) {
            result += "\n, arguments_list=" + arguments_list;
        }
        result += "\n}";
        return result;
    }
}
