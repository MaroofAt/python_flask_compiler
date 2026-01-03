package classes.jinja;

import java.util.ArrayList;

public class JinjaTemplate extends JinjaNode {

    public ArrayList<JinjaNode> children = new ArrayList<>();

    public JinjaTemplate(int line) {
        super(line, "Template");
    }

    public void add(JinjaNode node) {
        children.add(node);
    }
    @Override
    protected void printChildren(String indent) {
        for (JinjaNode n : children)
            n.print(indent);
    }

    @Override
    public String toString() {
        return "\nJinjaTemplate{" +
                "\nchildren=" + children +
                "\n}";
    }
}
