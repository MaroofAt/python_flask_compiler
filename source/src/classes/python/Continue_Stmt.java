package classes.python;

public class Continue_Stmt extends Small_Stmt{
    private String continue_str;

    public Continue_Stmt() {
        this.continue_str = "continue";
    }

    public String getContinue_str() {
        return continue_str;
    }
    public void setContinue_str(String continue_str) {
        this.continue_str = continue_str;
    }

    @Override
    public String toString() {
        return "\nContinue_Stmt{" +
                "\ncontinue_str='" + continue_str + '\'' +
                "\n}";
    }
}
