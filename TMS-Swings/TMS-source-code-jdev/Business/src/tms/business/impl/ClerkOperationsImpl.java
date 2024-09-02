package tms.business.impl;

import java.sql.Date;

import java.util.ArrayList;

import java.util.Iterator;

import tms.business.ClerkOperations;

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

public class ClerkOperationsImpl implements ClerkOperations {

    private DAO<OffenceDetailEO> offDetailRef = new OffenceDetailDAOImpl();
    private DAO<RegistrationEO> regRef = new RegistrationDAOImpl();
    private DAO<VehicleEO> vehicleRef = new VehicleDAOImpl();
    private DAO<OwnerEO> ownerRef = new OwnerDAOImpl();

    public ClerkOperationsImpl() {
        super();
    }

    /**
     *
     * @param offDetail
     * @return
     * @throws Exception
     */
    @Override
    public Integer raiseOffence(OffenceDetailEO offDetail) throws Exception {
        Integer count = offDetailRef.add(offDetail);
        return count;
    }

    
    public Integer clearOffense(OffenceDetailEO offDetail) throws Exception {
        Integer count = offDetailRef.update(offDetail);
        return count;
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
            String regNo
                    = offenceDetailEO.getRegistration().getRegistrationID();

            if (!registrationNo.equals(regNo)) {
                iterator.remove();
            }
        }

        return offDetails;
    }

    /**
     * @param registrationNo
     */
    public void generateReportByVehicle(String registrationNo) throws Exception {
    }

    /**
     * @param offenceType
     * @return
     */
    public ArrayList<OffenceDetailEO> generateReportByOffenceType(String offenceType) throws Exception {
        return null;
    }

    /**
     * @param startDate
     * @param endDate
     * @param vehicle
     * @return
     */
    public ArrayList<OffenceDetailEO> generateReportByDateRange(Date startDate,
            Date endDate,
            VehicleEO vehicle) throws Exception {
        return null;
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
}
