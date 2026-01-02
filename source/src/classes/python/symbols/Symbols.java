package classes.python.symbols;
public class Symbol{
    public String name;
    public String kind;
    public String scope;

    public Symbol(String name , String kind, String scope )
    {
        this.name= name;
        this.kind=kind;
        this.scope=scope;
    }
}