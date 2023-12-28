
import java.util.HashMap;
import java.util.Map;

import enums.SubscriptionType;

public class Main {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String email, String password, SubscriptionPlan plan){
        if(users.containsKey(email)){
            System.out.println("User already exists");
            throw new IllegalArgumentException("User already exists");
        }
        
        User user = new User(email, password, plan);
        users.put(email, user);
    }

    public void registerUser(String email, String password, SubscriptionPlan plan, String phone){
        if(users.containsKey(email)){
            System.out.println("User already exists");
            throw new IllegalArgumentException("User already exists");
        }
        
        User user = new User(email, password, plan, phone);
        users.put(email, user);
    }

    public void changeSubscriptionPlan(String email, SubscriptionType newType){
        if(!users.containsKey(email)){
            System.out.println("User does not exist");
            throw new IllegalArgumentException("User does not exist");
        }
        User user = users.get(email);
        user.setPlan(newType);
    }

    public void changeEmail(String email, String newEmail){
        if(!users.containsKey(email)){
            System.out.println("User does not exist");
            throw new IllegalArgumentException("User does not exist");
        }
        User user = users.get(email);
        user.setEmail(newEmail);
        users.remove(email);
        users.put(newEmail, user);
    }

    public void changePassword(String email, String newPassword){
        if(!users.containsKey(email)){
            System.out.println("User does not exist");
            throw new IllegalArgumentException("User does not exist");
        }
        User user = users.get(email);
        user.setPassword(newPassword);
    }

    public void changePhone(String email, String newPhone){
        if(!users.containsKey(email)){
            System.out.println("User does not exist");
            throw new IllegalArgumentException("User does not exist");
        }
        User user = users.get(email);
        user.setPhone(newPhone);
    }

    public void printUser(String email){
        if(!users.containsKey(email)){
            System.out.println("User does not exist");
            throw new IllegalArgumentException("User does not exist");
        }
        User user = users.get(email);
        System.out.println("User Id: " + user.getUserId());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("Subscription Plan: " + user.getPlan().getType());
        System.out.println("Subscription Price: " + user.getPlan().getPrice());
    }

    public Map<String, User> getUsers(){
        return this.users;
    }

    
}
