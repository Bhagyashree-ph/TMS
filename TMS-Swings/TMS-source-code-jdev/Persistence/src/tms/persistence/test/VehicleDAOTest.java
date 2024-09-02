package tms.persistence.test;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Scanner;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.VehicleDAOImpl;
import tms.persistence.entity.VehicleEO;
import tms.persistence.factory.DAOFactory;

public class VehicleDAOTest {

    DAO<VehicleEO> vehicleDAO = DAOFactory.createDAO(new VehicleDAOImpl());

    private static final Scanner scan = new Scanner(System.in);

    public void testCreateVehicle() throws Exception {
        //should change the below code to set values one by one
        VehicleEO vehicleEO =
            new VehicleEO(scan.nextInt(), scan.next(), scan.next(),
                          scan.next(), scan.next(), scan.next(), scan.next(),
                          (Date.valueOf(scan.next())), scan.next(),
                          scan.next());
        Integer res = vehicleDAO.add(vehicleEO);
        if (res > 0)
            System.out.println(res + " rows inserted.");
    }

    public void testReadVehicleByPK(int vehicleID) throws Exception {
        VehicleEO vehicleEO = vehicleDAO.findByID(vehicleID);
        System.out.println(vehicleEO);
    }

    public void testReadAllVehicles() throws Exception {
        ArrayList<VehicleEO> vehicleEO = vehicleDAO.findAll();
        for (VehicleEO d : vehicleEO) {
            System.out.println(d);
        }
    }

    public void testUpdateVehicles()  throws Exception{
        VehicleEO vehicleEO = new VehicleEO();
        System.out.println("Enter vehicle id who's color must be updated :");
        vehicleEO.setVehicleID(scan.nextInt());
        vehicleEO.setVehicleColor(scan.next());
        Integer res = vehicleDAO.update(vehicleEO);
        if (res > 0)
            System.out.println(res + " rows updated.");
    }

    public void testDeleteVehicles(int vehicleID) throws Exception {
        Integer res = vehicleDAO.delete(vehicleID);
        if (res > 0)
            System.out.println(res + " rows deleted.");

    }

    public static void main(String[] args) {
        VehicleDAOTest vehTest = new VehicleDAOTest();
//        System.out.println("Enter VEHICLE_ID , " +
//                "ENGINE_NUMBER , " +
//                "CHASSIS_NUMBER , " +
//                "VEHICLE_TYPE , " +
//                "VEH_BRAND , " +
//                "VEH_COLOR , " +
//                "FUEL_USED ,\n " +
//                "MANUFACTURE_DATE , " +
//                "MANUFACTURER_NAME , " +
//                "MODEL_NO");
//        vehTest.testCreateVehicle();
        
//        System.out.println("Enter vehicle number :");
//        vehTest.testReadVehicleByPK(scan.nextInt());
        
//        vehTest.testReadAllVehicles();
        
//        vehTest.testUpdateVehicles();
//        vehTest.testDeleteVehicles(scan.nextInt());
    }
}
