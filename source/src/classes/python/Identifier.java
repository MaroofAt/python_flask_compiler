package classes.python;

public class Identifier {
    private String name;

    public Identifier() {
        this.name = new String();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nIdentifier{" +
                "\nname='" + name + '\'' +
                "\n}";
    }
}
