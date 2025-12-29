package classes.python;

public class Finally_Clause {
    private Suite suite;

    public Finally_Clause() {
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
        return "\nFinally_Clause{" +
                "\nsuite=" + suite +
                "\n}";
    }
}
