package tms.business;

import java.util.List;

import javax.ejb.Remote;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Users;
import tms.persistence.Vehicles;

@Remote
public interface CopEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    List<Vehicles> getVehiclesFindAll();


    OffenseDetails persistOffenceDetails(OffenseDetails offenceDetails);

    OffenseDetails mergeOffenceDetails(OffenseDetails offenceDetails);

    void removeOffenceDetails(OffenseDetails offenceDetails);

    List<OffenseDetails> getOffenceDetailsFindAll();
    
    Registrations findRegistration(String registrationId);
    
    OffenseTypes findOffenceType(String offenseId);
    
    Users findUser(String userId);
    
    public Owners findOwner(String registrationId) ;
        public Vehicles findVehicle(String registrationId) ;
        

}
