package tms.business;

import java.io.File;

import java.util.ArrayList;
import tms.persistence.entity.OffenceDetailEO;

import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.entity.OwnerEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.VehicleEO;


public interface RTOOperations {
    
    //Manage vehicle detail

    /**
     * @param vehicle
     * @return
     * @throws java.lang.Exception
     */
    public Integer addNewVehicle(VehicleEO vehicle) throws Exception;

    /**
     * @param vehicle
     * @return
     * @throws java.lang.Exception
     */
    public Integer updateVehicleDetails(VehicleEO vehicle) throws Exception;

    /**
     * @param vehicleID
     * @return
     * @throws java.lang.Exception
     */
    public Integer removeVehicle(int vehicleID) throws Exception;
    
    /**
     *
     * @param vehicleID
     * @return
     * @throws java.lang.Exception
     */
    public VehicleEO fetchVehicleByVehicleID(int vehicleID) throws Exception;
    
    /**
     * @param registrationNo
     * @return
     * @throws java.lang.Exception
     */
    public VehicleEO fetchVehicleByID(String registrationNo) throws Exception;

    /**
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<VehicleEO> fetchAllVehicles() throws Exception;
    
    //Manage ownerDetail

    /**
     * @param owner
     * @return
     * @throws java.lang.Exception
     */
    public Integer addNewOwner(OwnerEO owner) throws Exception;

    /**
     * @param owner
     * @return
     * @throws java.lang.Exception
     */
    public Integer updateOwnerDetails(OwnerEO owner) throws Exception;

    /**
     * @param registrationNo
     * @return
     * @throws java.lang.Exception
     */
    public Integer removeOwner(String registrationNo) throws Exception;
    
    /**
     *
     * @param ownerID
     * @return
     * @throws java.lang.Exception
     */
    public OwnerEO fetchOwnerByOwnerID(String ownerID) throws Exception;
    
    /**
     * @param registrationNo
     * @return
     * @throws java.lang.Exception
     */
    public OwnerEO fetchOwnerByID(String registrationNo) throws Exception;

    /**
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<OwnerEO> fetchAllOwners() throws Exception;
    
    //Manage Offence types

    /**
     * @param offence
     * @return
     * @throws java.lang.Exception
     */
    public Integer addNewOffence(OffenceTypeEO offence) throws Exception;

    /**
     * @param offence
     * @return
     * @throws java.lang.Exception
     */
    public Integer updateOffence(OffenceTypeEO offence) throws Exception;

    /**
     * @param offenceID
     * @return
     * @throws java.lang.Exception
     */
    public Integer deleteOffence(String offenceID) throws Exception;

    /**
     * @param offenceID
     * @return
     * @throws java.lang.Exception
     */
    public OffenceTypeEO fetchOffencetypeByID(String offenceID) throws Exception;

    /**
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<OffenceTypeEO> fetchAllOffences() throws Exception;
    
    //Register a vehicle

    /**
     * @param registration
     * @return
     * @throws java.lang.Exception
     */
    public Integer registerVehicle(RegistrationEO registration) throws Exception;
    
    //Transfer vehicle

    /**
     * @param registration
     * @return
     * @throws java.lang.Exception
     */
    public Integer transferVehicle(RegistrationEO registration) throws Exception;
    
    /**
     *
     * @param registrationNo
     * @return
     * @throws java.lang.Exception
     */
    public RegistrationEO fetchRegisteredVehicle(String registrationNo) throws Exception;
    
    //Report generation
    
    /**
     * @param registrationNo
     * @return
     * @throws java.lang.Exception
     */
    public File generateReport(String registrationNo) throws Exception;

    /**
     * @param registrationNo
     * @return ArrayList of OffenceDetailEO
     * @throws java.lang.Exception
     */
    public ArrayList<OffenceDetailEO> fetchAllOffencesCommited(String registrationNo) throws Exception;
    
    /**
     * @param offDetail
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer clearOffense(OffenceDetailEO offDetail) throws Exception;

}
