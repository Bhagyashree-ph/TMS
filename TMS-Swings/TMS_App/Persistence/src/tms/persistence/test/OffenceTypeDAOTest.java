package tms.persistence.test;

import java.util.ArrayList;
import java.util.Scanner;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenceTypeDAOImpl;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.factory.DAOFactory;

public class OffenceTypeDAOTest {

    DAO<OffenceTypeEO> OffTypeDAO = DAOFactory.createDAO(new OffenceTypeDAOImpl());

    private static final Scanner sc = new Scanner(System.in);

    private void testCreateOffenseType() throws Exception {
        String off = sc.nextLine();
        String veh = sc.nextLine();
        int pen = sc.nextInt();
        OffenceTypeEO offType = new OffenceTypeEO();
        offType.setOffenseName(off);
        offType.setVehicleType(veh);
        offType.setPenalty(pen);
        Integer res = OffTypeDAO.add(offType);
        if (res > 0)
            System.out.println(res + " rows inserted..");
        else
            System.out.println("0 rows inserted");
    }

    private void testReadOffenseTypeByPK(String id) throws Exception {
        OffenceTypeEO offType = OffTypeDAO.findByID(id);
        System.out.println(offType);
    }

    private void testReadALlOffenseTypes() throws Exception {
        ArrayList<OffenceTypeEO> offenses = OffTypeDAO.findAll();
        for (OffenceTypeEO offenseTypeEO : offenses) {
            System.out.println(offenseTypeEO);
        }
    }

    private void testUpdateOffenseTypes() throws Exception {
        OffenceTypeEO offenseTypeEO = new OffenceTypeEO();
        System.out.println("Enter ownerID who's address must be updated :");
        offenseTypeEO.setOffenseID(sc.next());
        offenseTypeEO.setPenalty(sc.nextInt());
        Integer res = OffTypeDAO.update(offenseTypeEO);
        System.out.println(res + " rows updated");
    }

    private void testDeleteOffenseType(String id) throws Exception {
        Integer res = OffTypeDAO.delete(id);
        System.out.println(res + " rows deleted.");
    }

    public static void main(String[] args) {
        OffenceTypeDAOTest offenseTypeDAOTest = new OffenceTypeDAOTest();
//        System.out.println("Enter values for :\n" +
//                "OFFENSE_NAME\n" +
//                "VEHICLE_TYPE\n" +
//                "PENALTY");
//        offenseTypeDAOTest.testCreateOffenseType();
//        
       // System.out.println("Enter the id :");
//        offenseTypeDAOTest.testReadOffenseTypeByPK(sc.next());
        
//        offenseTypeDAOTest.testUpdateOffenseTypes();
        
//            offenseTypeDAOTest.testReadALlOffenseTypes();
        //offenseTypeDAOTest.testDeleteOffenseType(sc.next());
    }


}
