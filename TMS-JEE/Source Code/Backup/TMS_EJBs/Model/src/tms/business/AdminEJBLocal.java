package tms.business;

import java.util.List;

import javax.ejb.Local;

import tms.persistence.Roles;
import tms.persistence.Users;

@Local
public interface AdminEJBLocal {
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
