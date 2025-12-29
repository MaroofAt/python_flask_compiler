package classes.python;

public class Args_Parameter {
    private Non_Default_Parameter non_default_parameter;

    public Args_Parameter() {
        this.non_default_parameter = new Non_Default_Parameter();
    }

    public Non_Default_Parameter getNon_default_parameter() {
        return non_default_parameter;
    }
    public void setNon_default_parameter(Non_Default_Parameter non_default_parameter) {
        this.non_default_parameter = non_default_parameter;
    }

    @Override
    public String toString() {
        return "\nArgs_Parameter{" +
                "\nnon_default_parameter=" + non_default_parameter +
                "\n}";
    }
}
