package classes.jinja;

public class JinjaRaw extends JinjaNode {

    public String content;

    public JinjaRaw(int line, String content) {
        super(line, "Raw");
        this.content = content;
    }

    @Override
    public String toString() {
        return "{% raw %}" + content + "{% endraw %}";
    }
}
