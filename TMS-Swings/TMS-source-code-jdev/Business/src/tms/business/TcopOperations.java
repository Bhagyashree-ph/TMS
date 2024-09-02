package tms.business;

import java.util.ArrayList;

import tms.persistence.entity.OffenceDetailEO;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.entity.OwnerEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.UserEO;
import tms.persistence.entity.VehicleEO;


public interface TcopOperations {

    /**
     * @param offDetail
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer raiseOffence(OffenceDetailEO offDetail) throws Exception;

    /**
     * @param offDetail
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer clearOffense(OffenceDetailEO offDetail) throws Exception;

    /**
     * @param registrationNo
     * @return VehicleEO
     * @throws java.lang.Exception
     */
    public VehicleEO fetchVehicleDetails(String registrationNo) throws Exception;

    /**
     * @param registrationNo
     * @return OwnerEO
     * @throws java.lang.Exception
     */
    public OwnerEO fetchOwnerDetails(String registrationNo) throws Exception;
    
    /**
     *
     * @return OffenceTypeEO
     * @throws java.lang.Exception
     */
    public ArrayList<OffenceTypeEO> fetchAllOffenceTypes() throws Exception;
    
    /**
     * @param registrationNo
     * @return ArrayList of OffenceDetailEO
     * @throws java.lang.Exception
     */
    public ArrayList<OffenceDetailEO> fetchAllOffencesCommited(String registrationNo) throws Exception;
    
    /**
     *
     * @param OffenceID
     * @return OffenceTypeEO
     * @throws java.lang.Exception
     */
    public OffenceTypeEO fetchOffenceByID(String OffenceID) throws Exception;
    
    /**
     *
     * @param registrationNo
     * @return RegistrationEO
     * @throws java.lang.Exception
     */
    public RegistrationEO fetchRegistrationDetails(String registrationNo) throws Exception;
    
    /**
     *
     * @param userName
     * @return UserEO
     * @throws java.lang.Exception
     */
    public UserEO fetchUserByID(String userName) throws Exception;
}
