package classes.python;

import java.util.ArrayList;

public class Power_Expr {
    private Primary primary;
    private Power_Expr power_expr; //nullable

    public Power_Expr() {
        this.primary = new Primary();
        this.power_expr = null;
    }

    public Primary getPrimary() {
        return primary;
    }
    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public Power_Expr getPower_expr() {
        if(power_expr == null){
            this.power_expr = new Power_Expr();
        }
        return power_expr;
    }
    public void setPower_expr(Power_Expr power_expr) {
        this.power_expr = power_expr;
    }

    @Override
    public String toString() {
        String result = "\nPower_Expr{" +
                "\nprimary=" + primary;
        if(power_expr != null) {
            result += "\n, power_expr=" + power_expr;
        }
        result += "\n}";
        return result;
    }
}
