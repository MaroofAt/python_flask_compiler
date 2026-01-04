package symbols.css;

public abstract class CssSymbol {

    protected String name;
    protected int line;
    protected String kind;

    public CssSymbol(String name, int line, String kind) {
        this.name = name;
        this.line = line;
        this.kind = kind;
    }

    public void print() {
        System.out.println(kind + " : " + name + " (line " + line + ")");
    }
}
