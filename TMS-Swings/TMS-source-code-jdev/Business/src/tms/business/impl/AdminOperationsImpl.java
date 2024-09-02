package tms.business.impl;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.Scanner;

import tms.business.AdminOperations;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.RoleDAOImpl;
import tms.persistence.dao.impl.UserDAOImpl;
import tms.persistence.entity.RoleEO;
import tms.persistence.entity.UserEO;

public class AdminOperationsImpl implements AdminOperations {

    private final DAO<UserEO> userRef = new UserDAOImpl();
    private final DAO<RoleEO> roleRef = new RoleDAOImpl();

    public AdminOperationsImpl() {
        super();
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Integer addNewUser(UserEO user) throws Exception {
        Integer count = userRef.add(user);
        return count;
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateUser(UserEO user) throws Exception {
        Integer count = userRef.update(user);
        return count;
    }

    /**
     *
     * @param userID
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteUser(String userID) throws Exception {
        Integer count = userRef.delete(userID);
        return count;
    }

    /**
     *
     * @param userID
     * @return
     * @throws Exception
     */
    @Override
    public UserEO findByUserID(String userID) throws Exception {
        UserEO user = userRef.findByID(userID);
        return user;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<UserEO> findAllUsers() throws Exception {
        ArrayList<UserEO> users = userRef.findAll();
        return users;
    }

    /**
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public Integer addNewRole(RoleEO role) throws Exception {
        int count = roleRef.add(role);
        return count;
    }

    /**
     *
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public Integer UpdateRole(RoleEO role) throws Exception {
        int count = roleRef.update(role);
        return count;
    }

    /**
     *
     * @param roleName
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteRole(String roleName) throws Exception {        
        int count = roleRef.delete(roleName);
        return count;
    }

    /**
     *
     * @param roleName
     * @return
     * @throws Exception
     */
    @Override
    public RoleEO findRoleByID(String roleName) throws Exception {
        ArrayList<RoleEO> roles = roleRef.findAll();
        Iterator<RoleEO> iter = roles.iterator();
        RoleEO roleEO = null;
        RoleEO returnedRole = null;
        while (iter.hasNext()) {
            roleEO = iter.next();
            if (roleName.equals(roleEO.getRoleName()))
                returnedRole = roleRef.findByID(roleEO.getRoleID());
        }
        return returnedRole;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<RoleEO> findAllRoles() throws Exception {
        ArrayList<RoleEO> roles = roleRef.findAll();
        return roles;
    }

    public static void main(String[] args) {
        AdminOperationsImpl admin = new AdminOperationsImpl();

//        int count = admin.deleteRole("RTO");
//        System.out.println(count);
        
//        RoleEO role = new RoleEO();
//        role.setRoleID(456);
//        role.setRoleName("RTO");
//        int count = admin.addNewRole(role);
//        System.out.println(count);
        
//        Scanner sc = new Scanner(System.in);
//        
//        UserEO role = admin.findByUserID(sc.next());
//        System.out.println(role);
//        
//        ArrayList<UserEO> users = admin.findAllUsers();
//        for (UserEO userEO : users) {
//            System.out.println(userEO);
//        }


    }
}
