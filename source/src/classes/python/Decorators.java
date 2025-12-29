package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class Decorators {
    private ArrayList<Decorator> decorator_arraylist;

    public Decorators() {
        this.decorator_arraylist = new ArrayList<>();
    }

    public ArrayList<Decorator> getDecorator_arraylist() {
        return decorator_arraylist;
    }
    public void setDecorator_arraylist(ArrayList<Decorator> decorator_arraylist) {
        this.decorator_arraylist = decorator_arraylist;
    }
    public void add_to_decorator_arraylist(Decorator ex){
        this.decorator_arraylist.add(ex);
    }

    @Override
    public String toString() {
        return "\nDecorators{" +
                "\ndecorator_arraylist=" + decorator_arraylist +
                "\n}";
    }
}
