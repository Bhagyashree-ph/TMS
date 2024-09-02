package tms.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import tms.persistence.entities.OffenseDetailEO;
import tms.persistence.entities.OffenseTypeEO;
import tms.persistence.entities.OwnerEO;
import tms.persistence.entities.RegistrationEO;
import tms.persistence.entities.VehicleEO;

public interface CopOperations {

    /**
     * @param offDetail
     * @return String
     * @throws java.lang.Exception
     */
    public ResponseEntity<String> raiseOffense(OffenseDetailEO offDetail) ;

    /**
     * @param offDetail
     * @return Integer
     * @throws java.lang.Exception
     */
    public ResponseEntity<String> clearOffense(OffenseDetailEO offDetail) ;
    
    /**
     * @return ArrayList of OffenseDetailEO
     * @throws java.lang.Exception
     */
    public ResponseEntity<List<OffenseDetailEO>> fetchAllOffensesCommited() ;

    /**
     * @param registrationNo
     * @return ArrayList of OffenseDetailEO
     * @throws java.lang.Exception
     */
    public ResponseEntity<List<OffenseDetailEO>> fetchAllOffensesCommitedByREgNo(String registrationNo) ;

    /**
     *
     * @param OffenseID
     * @return OffenseTypeEO
     * @throws java.lang.Exception
     */
    public ResponseEntity<List<OffenseTypeEO>> fetchAllOffenses() ;
    
    /**
     *
     * @param registrationNo
     * @return RegistrationEO
     * @throws java.lang.Exception
     */
    public ResponseEntity<RegistrationEO> fetchRegistrationDetails(String registrationNo) ;

}

