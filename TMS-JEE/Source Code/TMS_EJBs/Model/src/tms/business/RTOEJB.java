package tms.business;

import java.util.List;

import javax.ejb.Remote;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Roles;
import tms.persistence.Users;
import tms.persistence.Vehicles;

@Remote
public interface RTOEJB {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    Registrations persistRegistrations(Registrations registrations);

    Registrations mergeRegistrations(Registrations registrations);

    void removeRegistrations(Registrations registrations);

    List<Registrations> getRegistrationsFindAll();

    Roles persistRoles(Roles roles);

    Roles mergeRoles(Roles roles);

    void removeRoles(Roles roles);

    List<Roles> getRolesFindAll();

    Users persistUsers(Users users);

    Users mergeUsers(Users users);

    void removeUsers(Users users);

    List<Users> getUsersFindAll();

    OffenseTypes persistOffenseTypes(OffenseTypes offenseTypes);

    OffenseTypes mergeOffenseTypes(OffenseTypes offenseTypes);

    void removeOffenseTypes(OffenseTypes offenseTypes);

    List<OffenseTypes> getOffenseTypesFindAll();

    OffenseDetails persistOffenseDetails(OffenseDetails offenseDetails);

    OffenseDetails mergeOffenseDetails(OffenseDetails offenseDetails);

    void removeOffenseDetails(OffenseDetails offenseDetails);

    List<OffenseDetails> getOffenseDetailsFindAll();

    Owners persistOwners(Owners owners);

    Owners mergeOwners(Owners owners);

    void removeOwners(Owners owners);

    List<Owners> getOwnersFindAll();

    Vehicles persistVehicles(Vehicles vehicles);

    Vehicles mergeVehicles(Vehicles vehicles);

    void removeVehicles(Vehicles vehicles);

    List<Vehicles> getVehiclesFindAll();

    public Vehicles findVehiclesById(Long vehicleId);

    public Owners findOwnerByPK(String ownerId);

    public Registrations findRegistrationsById(String registrationId);

    public OffenseTypes findOffenceTypesById(String offenseId);
}
