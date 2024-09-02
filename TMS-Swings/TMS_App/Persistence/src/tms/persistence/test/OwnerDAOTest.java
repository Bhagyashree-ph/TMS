package tms.persistence.test;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Scanner;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OwnerDAOImpl;
import tms.persistence.entity.OwnerEO;
import tms.persistence.factory.DAOFactory;

public class OwnerDAOTest {
    DAO<OwnerEO> ownDAO = DAOFactory.createDAO(new OwnerDAOImpl());
    
    private static final Scanner sc = new Scanner(System.in);
    
    private void testCreateOwner() throws Exception {
        OwnerEO own = new OwnerEO(sc.next(), sc.next(), sc.next(), sc.next(), (Date.valueOf(sc.next())), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next());
        Integer res = ownDAO.add(own);
        if(res>0)
            System.out.println(res+" rows inserted..");
        else
            System.out.println("0 rows inserted");
    }
    
    private void testReadOwnerByPK(String id) throws Exception {
        OwnerEO own = ownDAO.findByID(id);
        System.out.println(own);
    }
    
    private void testReadALlOwners() throws Exception {
        ArrayList<OwnerEO> owners = ownDAO.findAll();
        for (OwnerEO ownerEO : owners) {
            System.out.println(ownerEO);
        }
    }
    
    private void testUpdateOwners() throws Exception {
        OwnerEO owner = new OwnerEO();
        System.out.println("Enter ownerID who's address must be updated :");
        owner.setOwnerID(sc.next());
        owner.setAddress(sc.next());
        Integer res = ownDAO.update(owner);
        System.out.println(res + " rows updated");
    }

    private void testDeleteOwner(String id)  throws Exception{
        Integer res = ownDAO.delete(id);
        System.out.println(res + " rows deleted.");
    }
    
    public static void main(String[] args) {
        OwnerDAOTest ownerDAOTest = new OwnerDAOTest();
//        System.out.println("Enter owner details : \nOWNER_ID\n" +
//                "ID_TYPE\n" +
//                "FIRST_NAME\n" +
//                "LAST_NAME\n" +
//                "DATEOFBIRTH\n" +
//                "GENDER\n" +
//                "PHONE_NUMBER\n" +
//                "ADDRESS\n" +
//                "PINCODE\n" +
//                "OCCUPATION");
//        ownerDAOTest.testCreateOwner();
//        System.out.println("Enter the id :");
//        ownerDAOTest.testReadOwnerByPK(sc.next());
//        ownerDAOTest.testReadALlOwners();
//        ownerDAOTest.testUpdateOwners();
//        ownerDAOTest.testDeleteOwner(sc.next());
    }

}
