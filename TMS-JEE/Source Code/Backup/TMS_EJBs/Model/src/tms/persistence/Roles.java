package tms.persistence;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
  @NamedQuery(name = "Roles.findAll", query = "select o from Roles o")
})
public class Roles implements Serializable {
    @Id
    @Column(nullable = false, length = 20)
    private String rolename;
    @Column(name="ROLE_DESCRIPTION", nullable = false, length = 30)
    private String roleDescription;
    //@OneToMany(mappedBy = "roles")
    //private List<Users> usersList;

    public Roles() {
    }

    public Roles(String rolename ,String roleDescription) {
        this.roleDescription = roleDescription;
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /*public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Users addUsers(Users users) {
        getUsersList().add(users);
        users.setRoles(this);
        return users;
    }

    public Users removeUsers(Users users) {
        getUsersList().remove(users);
        users.setRoles(null);
        return users;
    }*/
    
    @Override
    public String toString() {
        return "Roles [rolename=" + rolename + ", roleDescription=" + roleDescription + "]";
    }
    
}
