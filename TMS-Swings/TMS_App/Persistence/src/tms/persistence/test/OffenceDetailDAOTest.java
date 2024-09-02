package tms.persistence.test;

import java.io.*;

import java.sql.Timestamp;

import java.util.*;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenceDetailDAOImpl;
import tms.persistence.entity.OffenceDetailEO;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.UserEO;
import tms.persistence.factory.DAOFactory;

public class OffenceDetailDAOTest {

    DAO<OffenceDetailEO> offdetailDAO =
        DAOFactory.createDAO(new OffenceDetailDAOImpl());

    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        OffenceDetailDAOTest offenseDetailDAOTest = new OffenceDetailDAOTest();

        //offenseDetailDAOTest.testCreateOffenseDetail();
        //        offenseDetailDAOTest.testReadOffenseDetailByPK();
//        offenseDetailDAOTest.testReadAllOffenseDetails();
        //        offenseDetailDAOTest.testUpdateOffenseDetail();
        //        offenseDetailDAOTest.testDeleteOffenseDetail();

    }

    public void testCreateOffenseDetail() throws Exception {

        RegistrationEO registration = new RegistrationEO();
        OffenceTypeEO offense = new OffenceTypeEO();
        UserEO user = new UserEO();

        OffenceDetailEO offDet = new OffenceDetailEO();
        
        System.out.println("Enter OFFENSE_DATE_TIME in the format yyyy-[m]m-[d]d hh:mm:ss[.f...]");
        Timestamp dateTime = Timestamp.valueOf(sc.nextLine());
        offDet.setOffenseDateTime(dateTime);
        
        System.out.println("Enter PLACE");
        String place = sc.nextLine();
        offDet.setPlace(place);

        System.out.println("Enter Image path");
        String path = sc.nextLine();
        byte[] data = null;
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            data = new byte[fis.available()];
            fis.read(data);
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        offDet.setImage(data);
        
        System.out.println("Enter REGISTRATION_ID");
        registration.setRegistrationID(sc.next());
        offDet.setRegistration(registration);
        
        System.out.println("Enter OFFENSE_ID");
        offense.setOffenseID(sc.next());
        offDet.setOffense(offense);
        
        System.out.println("Enter RECORDED_BY [user id] ");
        user.setUserID((sc.next()));
        offDet.setUser(user);
        
        System.out.println("Enter PENALTY_STATUS");
        String status = sc.next();
        offDet.setPenaltyStatus(status);

        Integer rows = offdetailDAO.add(offDet);
        if (rows >= 0)
            System.out.println(rows + " rows inserted.");

    }

    public void testReadOffenseDetailByPK() throws Exception {
        System.out.println("Enter the offense detail id you are looking for:");
        String id = sc.next();
        OffenceDetailEO offDet = offdetailDAO.findByID(id);
        System.out.println(offDet);
    }

    public void testReadAllOffenseDetails() throws Exception {
        ArrayList<OffenceDetailEO> details = offdetailDAO.findAll();
        for (OffenceDetailEO offenseDetailEO : details) {
            System.out.println(offenseDetailEO);
        }
    }

    public void testUpdateOffenseDetail() throws Exception {
        OffenceDetailEO offDetailEO = new OffenceDetailEO();
        RegistrationEO reg = new RegistrationEO();
        System.out.println("Enter registration id :");
        reg.setRegistrationID(sc.next());
        offDetailEO.setRegistration(reg);
        System.out.println("Enter new penalty status :");
        offDetailEO.setPenaltyStatus(sc.next());
        Integer rows = offdetailDAO.update(offDetailEO);
        if (rows >= 0)
            System.out.println(rows + " rows updated.");
    }

    public void testDeleteOffenseDetail() throws Exception {
        System.out.println("Enter the offense detail id you want to delete :");
        String id = sc.next();
        Integer rows = offdetailDAO.delete(id);
        if (rows >= 0)
            System.out.println(rows + " rows deleted.");

    }
}
