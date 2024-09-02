package tms.business.impl;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;

import tms.business.RTOOperations;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenceDetailDAOImpl;
import tms.persistence.dao.impl.OffenceTypeDAOImpl;
import tms.persistence.dao.impl.OwnerDAOImpl;
import tms.persistence.dao.impl.RegistrationDAOImpl;
import tms.persistence.dao.impl.VehicleDAOImpl;
import tms.persistence.entity.OffenceDetailEO;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.entity.OwnerEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.VehicleEO;

public class RTOOperationsImpl implements RTOOperations {
    
    private DAO<OffenceDetailEO> offDetailRef = new OffenceDetailDAOImpl();
    private DAO<OffenceTypeEO> offTypeRef = new OffenceTypeDAOImpl();
    private DAO<RegistrationEO> regRef = new RegistrationDAOImpl();
    private DAO<VehicleEO> vehicleRef = new VehicleDAOImpl();
    private DAO<OwnerEO> ownerRef = new OwnerDAOImpl();

    public RTOOperationsImpl() {
        super();
    }

    /**
     * @param vehicle
     * @return
     */
    public Integer addNewVehicle(VehicleEO vehicle) throws Exception {
        int count = vehicleRef.add(vehicle);
        return count;
    }

    /**
     * @param vehicle
     * @return
     */
    public Integer updateVehicleDetails(VehicleEO vehicle) throws Exception {
        int count = vehicleRef.update(vehicle);
        return count;
    }

    /**
     * @param vehicleID
     * @return
     */
    @Override
    public Integer removeVehicle(int vehicleID) throws Exception {
        int count =
            vehicleRef.delete(vehicleID);
        return count;
    }
    
    public VehicleEO fetchVehicleByVehicleID(int vehicleID) throws Exception {
        VehicleEO vehicle = vehicleRef.findByID(vehicleID);
        return vehicle;
    }
    
    /**
     * @param registrationNo
     * @return
     */
    @Override
    public VehicleEO fetchVehicleByID(String registrationNo) throws Exception {
        RegistrationEO registration = regRef.findByID(registrationNo);
        System.out.println(registration);
        System.out.println(registration.getVehicle());
        VehicleEO vehicle =
            vehicleRef.findByID(registration.getVehicle().getVehicleID());
        System.out.println(vehicle);
        return vehicle;
    }
//    public static void main(String[] args) {
//        RTOOperationsImpl rto = new RTOOperationsImpl();
//        rto.fetchVehicleByID("KA 32 AB 9221");
//    }

    /**
     * @return
     */
    public ArrayList<VehicleEO> fetchAllVehicles() throws Exception {
        ArrayList<VehicleEO> vehicles = vehicleRef.findAll();
        return vehicles;
    }

    /**
     * @param owner
     * @return
     */
    public Integer addNewOwner(OwnerEO owner) throws Exception {
        int count = ownerRef.add(owner);
        return count;
    }

    /**
     * @param owner
     * @return
     */
    public Integer updateOwnerDetails(OwnerEO owner) throws Exception {
        int count = ownerRef.update(owner);
        return count;
    }

    /**
     * @param ownerID
     * @return
     */
    public Integer removeOwner(String ownerID) throws Exception {
        int count = ownerRef.delete(ownerID);
        return count;
    }
    
    /**
     *
     * @param ownerID
     * @return
     */
    public OwnerEO fetchOwnerByOwnerID(String ownerID) throws Exception {
        OwnerEO owner = ownerRef.findByID(ownerID);
        return owner;
    }
    
    /**
     * @param registrationNo
     * @return
     */
    public OwnerEO fetchOwnerByID(String registrationNo) throws Exception {
        RegistrationEO regEO = regRef.findByID(registrationNo);
        OwnerEO owner = ownerRef.findByID(regEO.getOwner().getOwnerID());
        return owner;
    }

    /**
     * @return
     */
    public ArrayList<OwnerEO> fetchAllOwners() throws Exception {
        ArrayList<OwnerEO> owners = ownerRef.findAll();
        return owners;
    }

    /**
     * @param offence
     * @return
     */
    public Integer addNewOffence(OffenceTypeEO offence) throws Exception {
        int count = offTypeRef.add(offence);
        return count;
    }

    /**
     * @param offence
     * @return
     */
    public Integer updateOffence(OffenceTypeEO offence) throws Exception {
        int count = offTypeRef.update(offence);
        return count;
    }

    /**
     * @param offenceType
     * @return
     */
    public Integer deleteOffence(String offenceID) throws Exception {
            int count = offTypeRef.delete(offenceID);
        return count;
    }

    /**
     * @param offenceID
     * @return
     * @throws java.lang.Exception
     */
    public OffenceTypeEO fetchOffencetypeByID(String offenceID) throws Exception {

        OffenceTypeEO offType = offTypeRef.findByID(offenceID);
        
        return offType;
    }

    /**
     * @return
     */
    public ArrayList<OffenceTypeEO> fetchAllOffences() throws Exception {
        ArrayList<OffenceTypeEO> offenceTypes = offTypeRef.findAll();
        return offenceTypes;
    }

    /**
     * @param registration
     * @return
     */
    public Integer registerVehicle(RegistrationEO registration) throws Exception {
        int count = regRef.add(registration);
        return count;
    }

    /**
     * @param registration
     * @return
     */
    public Integer transferVehicle(RegistrationEO registration) throws Exception {
        int count = regRef.update(registration);
        return count;
    }


    /**
     * @param registrationNo
     * @return
     */
    public File generateReport(String registrationNo) throws Exception {
        FileWriter fw = null;
        File report = null;
        RTOOperationsImpl rtoImpl = new RTOOperationsImpl();

        try {
            report =
                    new File("C:\\Users\\bhagya.shree\\OneDrive - iqgateway pvt ltd\\Training\\TMS\\Source Code\\TMS_App\\Reports\\RTO\\" +
                             registrationNo);
            report.createNewFile();
            fw = new FileWriter(report);

            OwnerEO ownerEO = rtoImpl.fetchOwnerByID(registrationNo);
            String owner = ownerEO.toString();

            VehicleEO vehicleEO = rtoImpl.fetchVehicleByID(registrationNo);
            String vehicle = vehicleEO.toString();

            String details = owner + "\n" + vehicle;

            fw.write(details);

            fw.flush();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return report;
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
    
    /**
     * @param offDetail
     * @return
     */
    public Integer clearOffense(OffenceDetailEO offDetail) throws Exception {
        Integer count = offDetailRef.update(offDetail);
        return count;
    }

    public static void main(String[] args) {
        RTOOperationsImpl rto = new RTOOperationsImpl();
//        File report = rto.generateReport("R001");
//        System.out.println(report);
    }

    @Override
    public RegistrationEO fetchRegisteredVehicle(String registrationNo) throws Exception {
        RegistrationEO registration = regRef.findByID(registrationNo);
        return registration;
    }

}
