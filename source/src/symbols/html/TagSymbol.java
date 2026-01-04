package symbols.html;

public class TagSymbol extends HtmlSymbol {

    public TagSymbol(String name, int line) {
        super(name, line);
    }

    @Override
    public String getKind() {
        return "TAG";
    }

    @Override
    public String toString() {
        return "TagSymbol{name='" + name + "', line=" + line + "}";
    }
}
