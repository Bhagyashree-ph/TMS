package tms.business.impl;


import tms.business.AdminOperations;
import tms.business.LoginOperation;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.RoleDAOImpl;
import tms.persistence.entity.RoleEO;
import tms.persistence.entity.UserEO;

public class LoginOperationsImpl implements LoginOperation{
    
    //private DAO<UserEO> userDAO = new UserDAOImpl();
    private DAO<RoleEO> roleDAO = new RoleDAOImpl();
    
    public LoginOperationsImpl() {
        super();
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean loginUser(UserEO user) throws Exception {
        if (user == null) {
            return false; 
        }
        String userName = user.getUserName();
        String roleName = user.getRole().getRoleName();
        
        AdminOperations admin = new AdminOperationsImpl();
        if (admin == null) {
            return false; 
        }
        UserEO userEO = admin.findByUserID(userName);
        if(userEO == null)
            return false;
        System.out.println("Username " + userName);
        System.out.println(userEO);
        String userUserName= userEO.getUserName();
        String userRoleName = userEO.getRole().getRoleName(); 

        if (userEO != null && userEO.getRole() != null &&
            userRoleName != null) {
            if (userRoleName.equals(roleName)) {
                System.out.println(userEO);
                return true; 
            }
        }
        System.out.println("userEo, getrole, rolename null");

        return false; // Either user is null, role is null, roleName doesn't match, or userEO is null
    }
    
    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean resetPassword(UserEO user) throws Exception {
        AdminOperations admin = new AdminOperationsImpl();
        Integer userEO = admin.updateUser(user);
        if (userEO > 0) 
            return true;
        return false;
    }
    
    public static void main(String[] args) {
//        LoginOperationsImpl login = new LoginOperationsImpl();
//        UserEO user = new UserEO();
//        user.setUserName("U003");
//        user.setPassword("Abcd@12");
//        RoleEO role = new RoleEO();
//        role.setRoleName("Admin");
//        user.setRole(role);
//        System.out.println(login.loginUser(user));
    }
}
