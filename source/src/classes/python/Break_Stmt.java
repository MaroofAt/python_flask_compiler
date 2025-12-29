package classes.python;

public class Break_Stmt extends Small_Stmt{
    private String break_str;

    public Break_Stmt() {
        this.break_str = "break";
    }

    public String getBreak_str() {
        return break_str;
    }
    public void setBreak_str(String break_str) {
        this.break_str = break_str;
    }

    @Override
    public String toString() {
        return "\nBreak_Stmt{" +
                "\nbreak_str='" + break_str + '\'' +
                "\n}";
    }
}
