
import enums.SubscriptionType;

public class SubscriptionPlan {
    private SubscriptionType type;
    
    public SubscriptionPlan(SubscriptionType subType){
        this.type = subType;
    }

    public SubscriptionType getType(){ 
        return this.type;
    }

    public void setType(SubscriptionType newType){ //for changing subscription plans
        this.type = newType;
    }

    public double getPrice(){
        return type.getPrice();
    }
}
