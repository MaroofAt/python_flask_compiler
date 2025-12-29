package classes.python;

public class Typed_Assignment extends Assignment{
    private Identifier identifier1;
    private Identifier identifier2;
    private Expr expr; //nullable

    public Typed_Assignment() {
        this.identifier1 = new Identifier();
        this.identifier2 = new Identifier();
        this.expr = null;
    }

    public Identifier getIdentifier1() {
        return identifier1;
    }
    public void setIdentifier1(Identifier identifier1) {
        this.identifier1 = identifier1;
    }
    public Identifier getIdentifier2() {
        return identifier2;
    }
    public void setIdentifier2(Identifier identifier2) {
        this.identifier2 = identifier2;
    }
    public Expr getExpr() {
        if(expr == null){
            this.expr = new Expr();
        }
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        String result = "\nTyped_Assignment{" +
                "\nidentifier1=" + identifier1 +
                "\n, identifier2=" + identifier2;
        if(expr != null) {
            result += "\n, expr=" + expr;
        }
        result += "\n}";
        return  result;
    }
}
