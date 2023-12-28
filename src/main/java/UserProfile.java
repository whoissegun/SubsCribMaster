
public class UserProfile {
    private String email;
    private String password;
    private String phone; //phone number might not be provided by user it can be null
    

    public UserProfile(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserProfile(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String newPhone){
        this.phone = newPhone;
    }
}
