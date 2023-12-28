
import enums.SubscriptionType;
public class User extends UserProfile {
    
    private int userId;
    private SubscriptionPlan plan;
    private static int nextUserId = 1001;

    public User(String email, String password, SubscriptionPlan plan){
        super(email, password);
        this.userId = getNextUserId();
        this.plan = plan;
    }


    public User(String email, String password, SubscriptionPlan plan, String phone){
        super(email, password, phone);
        this.userId = getNextUserId();
        this.plan = plan;
    }

    private static synchronized int getNextUserId() { //synchronized is used to ensure thread safety when incrementing the ids
        return nextUserId++;
    }

    public int getUserId(){
        return this.userId;
    }

    public SubscriptionPlan getPlan(){
        return this.plan;
    }

    public void setPlan(SubscriptionType newType){
        this.plan.setType(newType);
    }

    public double getAmountToPay(){
        return this.plan.getPrice();
    }

    public double getAmountToPay(double discount){
        return this.plan.getPrice() * (1 - discount);
    }
}
