package tms.persistence.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenseDetailDAOImpl;
import tms.persistence.dao.impl.OffenseTypeDAOImpl;
import tms.persistence.dao.impl.RegistrationDAOImpl;
import tms.persistence.dao.impl.UsersDAOImpl;
import tms.persistence.entities.OffenseDetailEO;
import tms.persistence.entities.OffenseTypeEO;
import tms.persistence.entities.RegistrationEO;
import tms.persistence.entities.UsersEO;


public class OffenseDetailDAOTest {
	
    private DAO<OffenseDetailEO, String> ofdRef = new OffenseDetailDAOImpl();
    private DAO<OffenseTypeEO, String> oftRef = new OffenseTypeDAOImpl();
    private DAO<RegistrationEO, String> regRef = new RegistrationDAOImpl();
    private DAO<UsersEO, String> usrRef = new UsersDAOImpl();

    @Test
    public void addTest() {
        RegistrationEO re = new RegistrationEO(); //(RegistrationEO)(regRef.findByID("KA 32 AB 9221"));
        re.setRegistrationID("KA 32 AB 9221");
        OffenseTypeEO oft = new OffenseTypeEO("Hit", "Bike", 800.00); //(OffenseTypeEO)(oftRef.findByID("OF002"));
        UsersEO usr = new UsersEO(); //(UsersEO)(usrRef.findByID("U008"));
        usr.setUserId("U002");
        OffenseDetailEO ofd =
            new OffenseDetailEO( new java.sql.Timestamp(new java.util.Date().getTime()),
                                 "Banaglore", null, oft, re, usr, "Unpaid");
        ofd.setImg("C:\\Users\\bhagya.shree\\OneDrive - iqgateway pvt ltd\\Pictures\\Screenshots\\header.jpg");
        String returnedPK = ofdRef.add(ofd);
        Assert.assertNotNull(returnedPK);
    }

    @Test
    public void updateTest() {
        OffenseDetailEO ofd = ofdRef.findByID("OFD003");
        ofd.setPenaltyStatus("Paid");
        ofdRef.update(ofd);
        OffenseDetailEO result = ofdRef.findByID("OFD003");
        Assert.assertEquals("Paid", result.getPenaltyStatus());
    }

    @Test
    public void deleteTest() {
        ofdRef.delete("OFD003");
        Assert.assertNull(ofdRef.findByID("OFD03"));
    }

    @Test
    public void selectByIdTest() {
        OffenseDetailEO ofd = ofdRef.findByID("OFD003");
        System.out.println(ofd);
        Assert.assertNotNull(ofd);
    }

    @Test
    public void selectAllTest() {
        List<OffenseDetailEO> oftList = ofdRef.findAll();
        for (Iterator iterator = oftList.iterator(); iterator.hasNext(); ) {
            OffenseDetailEO OffenseDetailEO =
                (OffenseDetailEO)iterator.next();
            System.out.println(OffenseDetailEO);
        }
        Assert.assertNotNull(oftList);
    }
}
