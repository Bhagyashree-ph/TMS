package tms.business;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Users;
import tms.persistence.Vehicles;

@Stateless(name = "CopEJB", mappedName = "TMSEjb-Model-CopEJB")
public class CopEJBBean implements CopEJB, CopEJBLocal {
    @PersistenceContext(unitName="Model")
    private EntityManager em;

    public CopEJBBean() {
    }

    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    /** <code>select o from Vehicles o</code> */
    public List<Vehicles> getVehiclesFindAll() {
        return em.createNamedQuery("Vehicles.findAll").getResultList();
    }


    public OffenseDetails persistOffenceDetails(OffenseDetails offenceDetails) {
        em.persist(offenceDetails);
        return offenceDetails;
    }

    public OffenseDetails mergeOffenceDetails(OffenseDetails offenceDetails) {
        return em.merge(offenceDetails);
    }

    public void removeOffenceDetails(OffenseDetails offenceDetails) {
        offenceDetails = em.find(OffenseDetails.class, offenceDetails.getOffenseDetailId());
        em.remove(offenceDetails);
    }

    /** <code>select o from OffenceDetails o</code> */
    public List<OffenseDetails> getOffenceDetailsFindAll() {
        return (List<OffenseDetails>)em.createNamedQuery("OffenseDetails.findAll").getResultList();
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
       
    public Owners findOwner(String registrationId) {
            return em.find(Registrations.class,registrationId).getOwners();
        }
        public Vehicles findVehicle(String registrationId) {
            return em.find(Registrations.class,registrationId).getVehicles();
        }


    /** <code>select o from Owners o</code> */
    public List<Owners> getOwnersFindAll() {
        return em.createNamedQuery("Owners.findAll").getResultList();
    }
}
