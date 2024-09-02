package tms.persistence.test;

import java.util.ArrayList;
import java.util.Scanner;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.UserDAOImpl;
import tms.persistence.entity.RoleEO;
import tms.persistence.entity.UserEO;
import tms.persistence.factory.DAOFactory;

public class UserDAOTest {
    
    DAO<UserEO> userDAO = DAOFactory.createDAO(new UserDAOImpl());
    
    private static final Scanner scan = new Scanner(System.in);
    
    public void testCreateUser() throws Exception {
        RoleEO role = new RoleEO();
        System.out.println("Enter the role id");
        role.setRoleID(scan.nextInt());
        System.out.println("Enter userName, password, email, phoneNumber :");
        UserEO userEO = new UserEO();
        userEO.setUserName(scan.next());
        userEO.setPassword(scan.next());
        userEO.setEmail(scan.next()); 
        userEO.setPhoneNumber(scan.next());
        userEO.setRole( role);
        Integer res = userDAO.add(userEO);
        if (res > 0)
            System.out.println(res + " rows inserted.");
        else
            System.out.println("No rows inserted..");
    }

    public void testReadUserByPK(String userID) throws Exception {
        UserEO userEO = userDAO.findByID(userID);
        if(userEO != null)
            System.out.println(userEO);
        else
            System.out.println("No users found.");
    }

    public void testReadAllUsers() throws Exception {
        ArrayList<UserEO> userEO = userDAO.findAll();
        for (UserEO d : userEO) {
            System.out.println(d);
        }
    }

    public void testUpdateUsers() throws Exception {
        System.out.println("Enter Phone number and new password :");
        UserEO userEO = new UserEO();
        userEO.setPhoneNumber(scan.next());
        userEO.setPassword(scan.next());
        Integer res = userDAO.update(userEO);
        if (res > 0)
            System.out.println(res + " rows updated.");
    }
    
    public void testDeleteUsers(String userID) throws Exception {
        Integer res = userDAO.delete(userID);
        if (res > 0)
            System.out.println(res + " rows deleted.");
    }
    
    public static void main(String[] args) {
        UserDAOTest userDAOTest = new UserDAOTest();
//        userDAOTest.testCreateUser();
        
//        System.out.println("Enter userID to be searched :");
//        userDAOTest.testReadUserByPK(scan.next());
//      userDAOTest.testReadAllUsers();
//        
//        userDAOTest.testUpdateUsers();
//
//        userDAOTest.testReadAllUsers();
//        System.out.println("Enter userID to be deleted : ");
//        userDAOTest.testDeleteUsers(scan.next());
       
    }
}
