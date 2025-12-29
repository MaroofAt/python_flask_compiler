package classes.python;

import classes.with_arr_ex;

import java.util.ArrayList;

public class Primary {
    private Atom atom;
    private ArrayList<Postfix> postfix_arraylist; //nullable

    public Primary() {
        this.atom = new Atom();
        this.postfix_arraylist = null;
    }

    public Atom getAtom() {
        return atom;
    }
    public void setAtom(Atom atom) {
        this.atom = atom;
    }

    public ArrayList<Postfix> getPostfix_arraylist() {
        if(postfix_arraylist == null){
            this.postfix_arraylist = new ArrayList<>();
        }
        return postfix_arraylist;
    }
    public void setPostfix_arraylist(ArrayList<Postfix> postfix_arraylist) {
        this.postfix_arraylist = postfix_arraylist;
    }
    public void add_to_postfix_arraylist(Postfix ex){
        if(postfix_arraylist == null){
            this.postfix_arraylist = new ArrayList<>();
        }
        this.postfix_arraylist.add(ex);
    }

    @Override
    public String toString() {
        String result = "\nPrimary{"
                + "\natom=" + atom;
        if(postfix_arraylist != null) {
            result += "\n, postfix_arraylist=" + postfix_arraylist;
        }
        result += "\n}";
        return result;
    }

}
