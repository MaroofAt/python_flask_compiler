package classes.python;

public class Try_Finally_Stmt {
    private Suite suite1;
    private Suite suite2;

    public Try_Finally_Stmt() {
        this.suite1 = new Suite();
        this.suite2 = new Suite();
    }

    public Suite getSuite1() {
        return suite1;
    }
    public void setSuite1(Suite suite1) {
        this.suite1 = suite1;
    }

    public Suite getSuite2() {
        return suite2;
    }
    public void setSuite2(Suite suite2) {
        this.suite2 = suite2;
    }

    @Override
    public String toString() {
        return "\nTry_Finally_Stmt{" +
                "\nsuite1=" + suite1 +
                "\n, suite2=" + suite2 +
                "\n}";
    }
}
