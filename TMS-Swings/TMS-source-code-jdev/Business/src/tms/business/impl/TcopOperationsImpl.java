package tms.business.impl;

import java.sql.Array;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

import tms.business.TcopOperations;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenceDetailDAOImpl;
import tms.persistence.dao.impl.OffenceTypeDAOImpl;
import tms.persistence.dao.impl.OwnerDAOImpl;
import tms.persistence.dao.impl.RegistrationDAOImpl;
import tms.persistence.dao.impl.UserDAOImpl;
import tms.persistence.dao.impl.VehicleDAOImpl;
import tms.persistence.entity.OffenceDetailEO;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.entity.OwnerEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.UserEO;
import tms.persistence.entity.VehicleEO;

public class TcopOperationsImpl implements TcopOperations{
    
    private DAO<OffenceDetailEO> offDetailRef = new OffenceDetailDAOImpl();
    private DAO<RegistrationEO> regRef = new RegistrationDAOImpl();
    private DAO<VehicleEO> vehicleRef = new VehicleDAOImpl();
    private DAO<OwnerEO> ownerRef = new OwnerDAOImpl();
    
    public TcopOperationsImpl() {
        super();
    }

    /**
     * @param offDetail
     * @return
     */
    public Integer raiseOffence(OffenceDetailEO offDetail) throws Exception {
        Integer count = offDetailRef.add(offDetail);        
        return count;
    }

    /**
     * @param offDetail
     * @return
     */
    public Integer clearOffense(OffenceDetailEO offDetail) throws Exception {
        Integer count = offDetailRef.update(offDetail);
        return count;
    }

    /**
     * @param registrationNo
     * @return
     */
    public VehicleEO fetchVehicleDetails(String registrationNo) throws Exception {
        RegistrationEO regEO = regRef.findByID(registrationNo);
        VehicleEO vehicleEO = vehicleRef.findByID(regEO.getVehicle().getVehicleID());
        return vehicleEO;
    }

    /**
     * @param registrationNo
     * @return
     */
    public OwnerEO fetchOwnerDetails(String registrationNo) throws Exception {
        RegistrationEO regEO = regRef.findByID(registrationNo);
        OwnerEO ownerEO = ownerRef.findByID(regEO.getOwner().getOwnerID());
        return ownerEO;
    }

    /**
     * @param registrationNo
     * @return
     */
    public ArrayList<OffenceDetailEO> fetchAllOffencesCommited(String registrationNo) throws Exception {
       
        ArrayList<OffenceDetailEO> offDetails = offDetailRef.findAll();
        Iterator<OffenceDetailEO> iterator = offDetails.iterator();

        while (iterator.hasNext()) {
            OffenceDetailEO offenceDetailEO = iterator.next();
            String regNo = offenceDetailEO.getRegistration().getRegistrationID();
           
            if(!registrationNo.equals(regNo))
            iterator.remove();
        }
        
        return offDetails;
    }
    
    @Override
    public ArrayList<OffenceTypeEO> fetchAllOffenceTypes() throws Exception {
        DAO<OffenceTypeEO> offenceDAO = new OffenceTypeDAOImpl();
        ArrayList<OffenceTypeEO> offenceTypes = offenceDAO.findAll();
        return offenceTypes;
    }

    @Override
    public RegistrationEO fetchRegistrationDetails(String registrationNo) throws Exception {
        DAO<RegistrationEO> regRef = new RegistrationDAOImpl();
        RegistrationEO registration = regRef.findByID(registrationNo);
        return registration;
    }

    @Override
    public OffenceTypeEO fetchOffenceByID(String OffenceID) throws Exception {
        DAO<OffenceTypeEO> offence = new OffenceTypeDAOImpl();
        OffenceTypeEO offenceEO = offence.findByID(OffenceID);
        return offenceEO;
    }
    
    @Override
    public UserEO fetchUserByID(String userName) throws Exception {
        DAO<UserEO> userRef = new UserDAOImpl();
        ArrayList<UserEO> users = userRef.findAll();
        Iterator<UserEO> iter = users.iterator();
        UserEO userEO = null;
        UserEO returnedUser = null;
        while (iter.hasNext()) {
            userEO = iter.next();
            if (userName.equals(userEO.getUserName()))
                returnedUser = userRef.findByID(userEO.getUserID());
        }
        return returnedUser;
    }
    
    
//    public static void main(String[] args) {
//        TcopOperationsImpl tCop = new TcopOperationsImpl();
//        Scanner scan = new Scanner(System.in);
//        ArrayList<OffenceDetailEO> details = tCop.fetchAllOffencesCommited("R001");
//        for (OffenceDetailEO offenceDetailEO : details) {
//            System.out.println(offenceDetailEO);
//        }
//       VehicleEO vehicle = tCop.fetchVehicleDetails("R001");
//       System.out.println(vehicle);

//        OwnerEO owner = tCop.fetchOwnerDetails("R001");
//        System.out.println(owner);
        
//        int r = tCop.clearOffence(offDetail);
//        System.out.println(r);
//    }
}
