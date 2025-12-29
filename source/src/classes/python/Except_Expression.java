package classes.python;


import java.util.ArrayList;

public class Except_Expression {
    private ArrayList<Exception_Type> exception_type_arraylist;

    public Except_Expression() {
        this.exception_type_arraylist = new ArrayList<>();
    }

    public ArrayList<Exception_Type> getException_type_arraylist() {
        return exception_type_arraylist;
    }
    public void setException_type_arraylist(ArrayList<Exception_Type> exception_type_arraylist) {
        this.exception_type_arraylist = exception_type_arraylist;
    }

    public void add_to_exception_type_arraylist(Exception_Type ex){
        this.exception_type_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nExcept_Expression{" +
                "\nexception_type_arraylist=" + exception_type_arraylist +
                "\n}";
    }

}
