package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class
User {

    public User( String name, String phoneNumber, String email, String adress, String password, String role ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = adress;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String password; // Should be hashed and secured
    private String role;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email ) {
        this.email = email;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }


}
