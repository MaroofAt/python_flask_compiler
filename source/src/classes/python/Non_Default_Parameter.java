package classes.python;

public class Non_Default_Parameter {
    private Identifier identifier1;
    private Identifier identifier2; //nullable

    public Non_Default_Parameter() {
        this.identifier1 = new Identifier();
        this.identifier2 = null;
    }

    public Identifier getIdentifier1() {
        return identifier1;
    }
    public void setIdentifier1(Identifier identifier1) {
        this.identifier1 = identifier1;
    }

    public Identifier getIdentifier2() {
        if(identifier2 == null){
            this.identifier2 = new Identifier();
        }
        return identifier2;
    }
    public void setIdentifier2(Identifier identifier2) {
        this.identifier2 = identifier2;
    }

    @Override
    public String toString() {
        String result = "\nNon_Default_Parameter{" +
                "\nidentifier1=" + identifier1;
        if(identifier2 != null) {
            result += "\n, identifier2=" + identifier2;
        }
        result += "\n}";
        return result;
    }
}
