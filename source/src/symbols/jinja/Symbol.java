package symbols.jinja;

public abstract class Symbol {
    public String name;
    public int line;

    public Symbol(String name, int line) {
        this.name = name;
        this.line = line;
    }

    @Override
    public String toString() {
        return name + " (line " + line + ")";
    }
}
