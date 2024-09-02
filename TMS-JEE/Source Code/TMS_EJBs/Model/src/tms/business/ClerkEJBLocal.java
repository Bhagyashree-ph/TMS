package tms.business;

import java.util.List;

import javax.ejb.Local;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Registrations;
import tms.persistence.Users;

@Local
public interface ClerkEJBLocal {
    OffenseDetails persistOffenceDetails(OffenseDetails offenceDetails);

    OffenseDetails mergeOffenceDetails(OffenseDetails offenceDetails);

    List<OffenseDetails> getOffenceDetailsFindAll();
    
    public Registrations findRegistration(String registrationId);
    
       public OffenseTypes findOffenceType(String offenseId);
       
       public Users findUser(String userId);
}
