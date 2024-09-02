package tms.persistence.entity;

public class UserEO {

    private String userID;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private RoleEO role;

    public UserEO() {

    }

    public UserEO(String userID, String userName, String password,
                  String email, String phoneNumber, RoleEO role) {
        super();
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setRole(RoleEO role) {
        this.role = role;
    }

    public RoleEO getRole() {
        return role;
    }
    
    public String toString() {
        return "UserEO contains: [userID: " + this.userID + " userName: " +
            this.userName + " password: " + this.password + " email: " +
            this.email + " phoneNumber: " + this.phoneNumber + " role: " +
            this.role.getRoleID() + "]";
    }

}
