package classes.python;

public class Pass_Stmt extends Small_Stmt{
    private String pass_str;

    public Pass_Stmt() {
        this.pass_str = "pass";
    }

    public String getPass_str() {
        return pass_str;
    }
    public void setPass_str(String pass_str) {
        this.pass_str = pass_str;
    }

    @Override
    public String toString() {
        return "\nPass_Stmt{" +
                "\npass_str='" + pass_str + '\'' +
                "\n}";
    }
}
