package classes.python;

public class Else_Clause {
    private Suite suite;

    public Else_Clause() {
        this.suite = new Suite();
    }

    public Suite getSuite() {
        return suite;
    }
    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        return "\nElse_Clause{" +
                "\nsuite=" + suite +
                "\n}";
    }
}
