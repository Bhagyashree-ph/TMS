package tms.persistence.test;

import java.sql.Date;

import java.time.LocalDate;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.VehicleDAOImpl;
import tms.persistence.entities.VehicleEO;


public class VehicleDAOTest {
    private DAO<VehicleEO, Integer> vehicleDAORef = new VehicleDAOImpl();
    
    @Test 
    public void addVehicle() {
        //1, "52WVC10338"," 7004AN", "Car","Red", "Diesel", Date.valueOf(LocalDate.of(2024, 3, 15)),"Maruti","Tata","SUV"
        VehicleEO vehicle = new VehicleEO("52WVC10338","7004AN","Car","Red","Diesel", "Maruti",Date.valueOf(LocalDate.of(2024, 3, 15)),"Tata","SUV","SUV123");
        Integer returnedKey = (Integer) vehicleDAORef.add(vehicle);
        Assert.assertNotNull(returnedKey);
    }
    
    @Test
    public void updateVehicle() {
    	VehicleEO vehicleRef = new VehicleEO("52WVC10338","7004AN","Car","Black","Diesel", "Maruti",Date.valueOf(LocalDate.of(2024, 3, 15)),"Tata","SUV", "SUV123");
         vehicleDAORef.update(vehicleRef);
         VehicleEO vehicle = vehicleDAORef.findByID(1);
        Assert.assertEquals("Black",vehicle.getVehicleColor());
    }
    
    @Test
    public void deleteVehicle() {
    	vehicleDAORef.delete(new Integer(1));
    	VehicleEO vehicle = vehicleDAORef.findByID(1);
    	Assert.assertNull(vehicle);
    }
    
    @Test
    public void findByVehicleIdTest() {
    	 VehicleEO vehicle = vehicleDAORef.findByID(1);
    	 Assert.assertNotNull(vehicle);
    	 System.out.println(vehicle);
    }
    
    @Test
    public void findVehiclesTest() {
    	List<VehicleEO> vehicles = vehicleDAORef.findAll();
    	Assert.assertNotNull(vehicles);
    	for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
			VehicleEO vehicleEO = (VehicleEO) iterator.next();
			System.out.println(vehicleEO);
		}
    }
}
