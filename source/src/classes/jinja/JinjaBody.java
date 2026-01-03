package classes.jinja;

import java.util.ArrayList;

public class JinjaBody extends JinjaNode {

    public ArrayList<JinjaNode> elements = new ArrayList<>();

    public JinjaBody(int line) {
        super(line, "Body");
    }

    public void add(JinjaNode node) {
        elements.add(node);
    }


    @Override
    protected void printChildren(String indent) {
        for (JinjaNode n : elements)
            n.print(indent);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
