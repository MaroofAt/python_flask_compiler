package classes.python;

public class Number {
    private String number;

    public Number() {
        this.number = new String();
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nNumber{" +
                "\nnumber='" + number + '\'' +
                "\n}";
    }
}
