package tms.business.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tms.business.CopOperations;
import tms.persistence.entities.OffenseDetailEO;
import tms.persistence.entities.OffenseTypeEO;
import tms.persistence.entities.RegistrationEO;
import tms.persistence.entities.UsersEO;

public class CopTestApp {
	
	private static CopOperations cop;

	public static void main(String[] args) {

		ApplicationContext appctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		cop = (CopOperations) appctx.getBean("copoperBean");

//		 testRaise();
//		getAllOffense();
//		getUnpaid();
//		getOffensesByReg();
//		testClear();
//		fetchOffense();
//		fetchOwner();
//		fetchVehicle();
//		fetchRegistration();

	}

//	public static void testRaise() {
//
//		RegistrationEO re = new RegistrationEO(); // (RegistrationEO)(regRef.findByID("KA
//													// 32 AB 9221"));
//		re.setRegistrationID("KA 32 9876");
//		OffenseTypeEO oft = new OffenseTypeEO("Hit", "Bike", 800.00); // (OffenseTypeEO)(oftRef.findByID("OF002"));
//		UsersEO usr = new UsersEO(); // (UsersEO)(usrRef.findByID("U008"));
//		usr.setUserId("U002");
//		OffenseDetailEO ofd = new OffenseDetailEO(new java.sql.Timestamp(new java.util.Date().getTime()), "Banaglore",
//				null, oft, re, usr, "Unpaid");
//		ofd.setImg("C:\\Users\\bhagya.shree\\OneDrive - iqgateway pvt ltd\\Pictures\\Screenshots\\header.jpg");
//		ofd.setOffenseDetailId("OFD012");
//		String offdetId = null;
//		try {
//			offdetId = cop.raiseOffense(ofd);
//			if (offdetId != null)
//				System.out.println(1 + " rows inserted.");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static void testClear() {
//
//		RegistrationEO re = new RegistrationEO(); // (RegistrationEO)(regRef.findByID("KA
//													// 32 AB 9221"));
//		re.setRegistrationID("KA 32 9876");
//		OffenseTypeEO oft = new OffenseTypeEO("Hit", "Bike", 800.00); // (OffenseTypeEO)(oftRef.findByID("OF002"));
//		UsersEO usr = new UsersEO(); // (UsersEO)(usrRef.findByID("U008"));
//		usr.setUserId("U002");
//		OffenseDetailEO ofd = new OffenseDetailEO(new java.sql.Timestamp(new java.util.Date().getTime()), "Banaglore",
//				null, oft, re, usr, "Paid");
//		ofd.setOffenseDetailId("OFD012");
//		ofd.setImg("C:\\Users\\bhagya.shree\\OneDrive - iqgateway pvt ltd\\Pictures\\Screenshots\\header.jpg");
//
//		try {
//			cop.clearOffense(ofd);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static void getOffensesByReg() {
//		try {
//			List<OffenseDetailEO> offdetails = cop.fetchAllOffensesCommitedByREgNo("KA 32 9876", "Unpaid");
//			for (OffenseDetailEO offenseDetailEO : offdetails) {
//				System.out.println(offenseDetailEO);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private static void getAllOffense() {
//		// TODO Auto-generated method stub
//		try {
//			List<OffenseDetailEO> offdetails = cop.fetchAllOffensesCommited();
//			for (OffenseDetailEO offenseDetailEO : offdetails) {
//				System.out.println(offenseDetailEO);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	private static void fetchOwner() {
//		// TODO Auto-generated method stub
//		try {
//			System.out.println("-------------------------------------");
//			System.out.println(cop.fetchOwnerDetails("TN 03 AB 1234"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	private static void fetchVehicle() {
//		// TODO Auto-generated method stub
//		System.out.println("-----------------------");
//		try {
//			System.out.println(cop.fetchVehicleDetails("TN 03 AB 1234"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private static void fetchRegistration() {
//		// TODO Auto-generated method stub
//		System.out.println("------------------------------");
//		try {
//			System.out.println(cop.fetchRegistrationDetails("TN 03 AB 1234"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	private static void fetchOffense() {
//		// TODO Auto-generated method stub
//		System.out.println("--------------------------------------");
//		try {
//			System.out.println(cop.fetchOffenseByID("OF001"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
