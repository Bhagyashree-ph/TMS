package tms.persistence.test;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Scanner;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.RegistrationDAOImpl;
import tms.persistence.entity.OwnerEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.VehicleEO;
import tms.persistence.factory.DAOFactory;

public class RegistrationDAOTest {

    DAO<RegistrationEO> regDAO = DAOFactory.createDAO(new RegistrationDAOImpl());

    private static final Scanner sc = new Scanner(System.in);
    
    private void testCreateRegistration()  throws Exception{
        VehicleEO vehicle = new VehicleEO();
        OwnerEO owner = new OwnerEO();
        System.out.println("Enter Reg id in String :");
        String id = sc.next();
        System.out.println("Enter vehicle id in int :");
        vehicle.setVehicleID(sc.nextInt());
        System.out.println("Enter owner id in String :");
        owner.setOwnerID(sc.next());
        sc.nextLine();
        System.out.println("Enter registration date in yyyy-mm-dd format :");
        Date regDate = Date.valueOf(sc.nextLine());
        RegistrationEO regEO = new RegistrationEO(id, vehicle, owner, regDate);
        Integer res = regDAO.add(regEO);
        if (res > 0)
            System.out.println(res + " rows inserted..");
        else
            System.out.println("0 rows inserted");
    }

    private void testReadRegistrationByPK(String id) throws Exception {
        RegistrationEO regEO = regDAO.findByID(id);
        System.out.println(regEO);
    }

    private void testReadALlRegistrations() throws Exception {
        ArrayList<RegistrationEO> registrations = regDAO.findAll();
        for (RegistrationEO regEO : registrations) {
            System.out.println(regEO);
        }
    }

    private void testUpdateRegistrations() throws Exception {
        RegistrationEO regEO = new RegistrationEO();
        OwnerEO owner = new OwnerEO();
        System.out.println("Enter registration number :");
        regEO.setRegistrationID(sc.next());
        System.out.println("Enter owner id in String :");
        owner.setOwnerID(sc.next());
        regEO.setOwner(owner);
        Integer res = regDAO.update(regEO);
        if(res>0) 
            System.out.println(res + " rows updated");
    }

    private void testDeleteRegistration(String id) throws Exception {
        Integer res = regDAO.delete(id);
        System.out.println(res + " rows deleted.");
    }

    public static void main(String[] args) {
        RegistrationDAOTest registrationDAOTest = new RegistrationDAOTest();
        //registrationDAOTest.testCreateRegistration();
        //registrationDAOTest.testReadRegistrationByPK(sc.next());
        //registrationDAOTest.testReadALlRegistrations();
//        registrationDAOTest.testUpdateRegistrations();
        //registrationDAOTest.testDeleteRegistration(sc.next());
    }
}
