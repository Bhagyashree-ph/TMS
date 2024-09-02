package tms.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class representing a USERS table in the TM schema.
 */
@Entity
@Table(name = "USERS")
public class UsersEO {
    
    @Id
    @Column(name = "USER_ID")
    private String userId;
   
   @Column(name = "USER_NAME")
   private String userName;
   
   @Column(name = "PASSWORD")
   private String password;
   
   @Column(name = "EMAIL")
   private String email;
   
   @ManyToOne
    @JoinColumn(name="ROLENAME", referencedColumnName="ROLENAME")
   private RoleEO role;
   
    /**
         * Default constructor.
         */
   public UsersEO() {}


    /**
     * Parameterized constructor.
     * @param userName The name of the user.
     * @param password The password of the user.
     * @param email The email address of the user.
     * @param role The role of the user.
     * @param userId The ID of the user.
     */
    public UsersEO(String userName, String password, String email, RoleEO role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
    }

    /**
         * Set the user ID.
         * @param userId The ID of the user.
         */
	public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
        * Get the user ID.
        * @return The ID of the user.
        */
    public String getUserId() {
        return userId;
    }

    /**
         * Set the user name.
         * @param userName The name of the user.
         */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
         * Get the user name.
         * @return The name of the user.
         */
    public String getUserName() {
        return userName;
    }

    /**
         * Set the user password.
         * @param password The password of the user.
         */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
         * Get the user password.
         * @return The password of the user.
         */
    public String getPassword() {
        return password;
    }
    
    /**
         * Set the user email.
         * @param email The email address of the user.
         */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
        * Get the user email.
        * @return The email address of the user.
        */
    public String getEmail() {
        return email;
    }
    
    /**
        * Gets the role of the user.
        * @return The role of the user.
        */
	public RoleEO getRole() {
		return role;
	}
        
    /**
         * Sets the role of the user.
         * @param role The role of the user.
         */
	public void setRole(RoleEO role) {
		this.role = role;
	}
        
    /**
         * Get a string representation of the UsersEO object.
         * @return A string representation of the UsersEO object.
         */
	@Override
	public String toString() {
		return "UsersEO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}

}
