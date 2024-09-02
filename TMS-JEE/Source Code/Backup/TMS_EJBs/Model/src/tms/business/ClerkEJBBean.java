package tms.business;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Registrations;
import tms.persistence.Users;

@Stateless(name = "ClerkEJB", mappedName = "TMSEjb-Model-ClerkEJB")
public class ClerkEJBBean implements ClerkEJB, ClerkEJBLocal {
    @PersistenceContext(unitName="Model")
    private EntityManager em;

    public ClerkEJBBean() {
    }

    public OffenseDetails persistOffenceDetails(OffenseDetails offenceDetails) {
        em.persist(offenceDetails);
        return offenceDetails;
    }

    public OffenseDetails mergeOffenceDetails(OffenseDetails offenceDetails) {
        return em.merge(offenceDetails);
    }

    /** <code>select o from OffenceDetails o</code> */
    public List<OffenseDetails> getOffenceDetailsFindAll() {
        return em.createNamedQuery("OffenseDetails.findAll").getResultList();
    }
    
    public Registrations findRegistration(String registrationId) {
           return em.find(Registrations.class,registrationId);
       }
       public OffenseTypes findOffenceType(String offenseId) {
           return em.find(OffenseTypes.class,offenseId);
       }
       public Users findUser(String userId) {
           return em.find(Users.class,userId);
       }
}
