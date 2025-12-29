package classes.python;

public class Target_Postfix_Subscription extends Target_Postfix{
    private Subscription subscription;

    public Target_Postfix_Subscription() {
        this.subscription = new Subscription();
    }

    public Subscription getSubscription() {
        return subscription;
    }
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "\nTarget_Postfix_Subscription{" +
                "\nsubscription=" + subscription +
                "\n}";
    }
}
