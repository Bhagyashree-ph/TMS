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
import tms.persistence.Roles;
import tms.persistence.Users;
import tms.persistence.Vehicles;

@Stateless(name = "RTOEJB", mappedName = "APP-TMS-Model-RTOEJB")
public class RTOEJBBean implements RTOEJB, RTOEJBLocal {
    @PersistenceContext(unitName="Model")
    private EntityManager em;

    public RTOEJBBean() {
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

    public Registrations persistRegistrations(Registrations registrations) {
        em.persist(registrations);
        return registrations;
    }

    public Registrations mergeRegistrations(Registrations registrations) {
        return em.merge(registrations);
    }

    public void removeRegistrations(Registrations registrations) {
        registrations = em.find(Registrations.class, registrations.getRegistrationId());
        em.remove(registrations);
    }

    /** <code>select o from Registrations o</code> */
    public List<Registrations> getRegistrationsFindAll() {
        return em.createNamedQuery("Registrations.findAll").getResultList();
    }

    public Roles persistRoles(Roles roles) {
        em.persist(roles);
        return roles;
    }

    public Roles mergeRoles(Roles roles) {
        return em.merge(roles);
    }

    public void removeRoles(Roles roles) {
        roles = em.find(Roles.class, roles.getRolename());
        em.remove(roles);
    }

    /** <code>select o from Roles o</code> */
    public List<Roles> getRolesFindAll() {
        return em.createNamedQuery("Roles.findAll").getResultList();
    }

    public Users persistUsers(Users users) {
        em.persist(users);
        return users;
    }

    public Users mergeUsers(Users users) {
        return em.merge(users);
    }

    public void removeUsers(Users users) {
        users = em.find(Users.class, users.getUserId());
        em.remove(users);
    }

    /** <code>select o from Users o</code> */
    public List<Users> getUsersFindAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    public OffenseTypes persistOffenseTypes(OffenseTypes offenseTypes) {
        em.persist(offenseTypes);
        return offenseTypes;
    }

    public OffenseTypes mergeOffenseTypes(OffenseTypes offenseTypes) {
        return em.merge(offenseTypes);
    }

    public void removeOffenseTypes(OffenseTypes offenseTypes) {
        offenseTypes = em.find(OffenseTypes.class, offenseTypes.getOffenseId());
        em.remove(offenseTypes);
    }

    /** <code>select o from OffenseTypes o</code> */
    public List<OffenseTypes> getOffenseTypesFindAll() {
        return em.createNamedQuery("OffenseTypes.findAll").getResultList();
    }

    public OffenseDetails persistOffenseDetails(OffenseDetails offenseDetails) {
        em.persist(offenseDetails);
        return offenseDetails;
    }

    public OffenseDetails mergeOffenseDetails(OffenseDetails offenseDetails) {
        return em.merge(offenseDetails);
    }

    public void removeOffenseDetails(OffenseDetails offenseDetails) {
        offenseDetails = em.find(OffenseDetails.class, offenseDetails.getOffenseDetailId());
        em.remove(offenseDetails);
    }

    /** <code>select o from OffenseDetails o</code> */
    public List<OffenseDetails> getOffenseDetailsFindAll() {
        return em.createNamedQuery("OffenseDetails.findAll").getResultList();
    }

    public Owners persistOwners(Owners owners) {
        em.persist(owners);
        return owners;
    }

    public Owners mergeOwners(Owners owners) {
        return em.merge(owners);
    }

    public void removeOwners(Owners owners) {
        owners = em.find(Owners.class, owners.getOwnerId());
        em.remove(owners);
    }

    /** <code>select o from Owners o</code> */
    public List<Owners> getOwnersFindAll() {
        return em.createNamedQuery("Owners.findAll").getResultList();
    }

    public Vehicles persistVehicles(Vehicles vehicles) {
        em.persist(vehicles);
        return vehicles;
    }

    public Vehicles mergeVehicles(Vehicles vehicles) {
        return em.merge(vehicles);
    }

    public void removeVehicles(Vehicles vehicles) {
        vehicles = em.find(Vehicles.class, vehicles.getVehicleId());
        em.remove(vehicles);
    }

    /** <code>select o from Vehicles o</code> */
    public List<Vehicles> getVehiclesFindAll() {
        return em.createNamedQuery("Vehicles.findAll").getResultList();
    }


    public Vehicles findVehiclesById(Long vehicleId) {
        return em.find(Vehicles.class, vehicleId);
    }

    public Owners findOwnerByPK(String ownerId) {
        return em.find(Owners.class, ownerId);
    }

    public Registrations findRegistrationsById(String registrationId) {
        return em.find(Registrations.class, registrationId);
    }

    public OffenseTypes findOffenceTypesById(String offenseId) {
        return em.find(OffenseTypes.class, offenseId);
    }
}
