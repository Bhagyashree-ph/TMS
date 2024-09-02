package tms.business;

import java.util.List;

import javax.ejb.Remote;

import tms.persistence.Roles;
import tms.persistence.Users;

@Remote
public interface AdminEJB {
    Users persistUsers(Users users);

    Users mergeUsers(Users users);

    void removeUsers(Users users);

    List<Users> getUsersFindAll();
    
    Users findUserById(String UserId);

    Roles persistRoles(Roles roles);

    Roles mergeRoles(Roles roles);

    void removeRoles(Roles roles);

    List<Roles> getRolesFindAll();
    
    Roles findRoleById(String roleName);
    
}
