package symbols.html;

public abstract class HtmlSymbol {

    protected String name;
    protected int line;

    public HtmlSymbol(String name, int line) {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public abstract String getKind();
}
