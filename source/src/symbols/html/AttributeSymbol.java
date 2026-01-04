package symbols.html;

public class AttributeSymbol extends HtmlSymbol {

    private String value;

    public AttributeSymbol(String name, String value, int line) {
        super(name, line);
        this.value = value;
    }

    @Override
    public String getKind() {
        return "ATTRIBUTE";
    }

    @Override
    public String toString() {
        return "AttributeSymbol{name='" + name + "', value=" + value + ", line=" + line + "}";
    }
}
