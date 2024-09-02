package model;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.naming.NamingException;

import tms.business.RTOEJB;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Roles;
import tms.persistence.Users;
import tms.persistence.Vehicles;

public class RTOEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            RTOEJB rTOEJB = (RTOEJB)context.lookup("APP-TMS-Model-RTOEJB#tms.business.RTOEJB");
            for (Users users : (List<Users>)rTOEJB.getUsersFindAll()) {
                printUsers(users);
            }
            for (OffenseTypes offensetypes : (List<OffenseTypes>)rTOEJB.getOffenseTypesFindAll()) {
                printOffenseTypes(offensetypes);
            }
            for (Owners owners : (List<Owners>)rTOEJB.getOwnersFindAll()) {
                printOwners(owners);
            }
            for (Registrations registrations : (List<Registrations>)rTOEJB.getRegistrationsFindAll()) {
                printRegistrations(registrations);
            }
            for (Vehicles vehicles : (List<Vehicles>)rTOEJB.getVehiclesFindAll()) {
                printVehicles(vehicles);
            }
            for (Roles roles : (List<Roles>)rTOEJB.getRolesFindAll()) {
                printRoles(roles);
            }
            for (OffenseDetails offensedetails : (List<OffenseDetails>)rTOEJB.getOffenseDetailsFindAll()) {
                printOffenseDetails(offensedetails);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printUsers(Users users) {
        System.out.println( "email = " + users.getEmail() );
        System.out.println( "password = " + users.getPassword() );
        System.out.println( "userId = " + users.getUserId() );
        System.out.println( "userName = " + users.getUserName() );
        System.out.println( "roles = " + users.getRoles() );
    }

    private static void printOffenseTypes(OffenseTypes offensetypes) {
        System.out.println( "offenseId = " + offensetypes.getOffenseId() );
        System.out.println( "offenseName = " + offensetypes.getOffenseName() );
        System.out.println( "penalty = " + offensetypes.getPenalty() );
        System.out.println( "vehicleType = " + offensetypes.getVehicleType() );
    }

    private static void printOwners(Owners owners) {
        System.out.println( "address = " + owners.getAddress() );
        System.out.println( "dateofbirth = " + owners.getDateofbirth() );
        System.out.println( "firstName = " + owners.getFirstName() );
        System.out.println( "gender = " + owners.getGender() );
        System.out.println( "idType = " + owners.getIdType() );
        System.out.println( "lastName = " + owners.getLastName() );
        System.out.println( "occupation = " + owners.getOccupation() );
        System.out.println( "ownerId = " + owners.getOwnerId() );
        System.out.println( "phoneNumber = " + owners.getPhoneNumber() );
        System.out.println( "pincode = " + owners.getPincode() );
    }

    private static void printRegistrations(Registrations registrations) {
        System.out.println( "registrationDate = " + registrations.getRegistrationDate() );
        System.out.println( "registrationId = " + registrations.getRegistrationId() );
        System.out.println( "owners = " + registrations.getOwners() );
        System.out.println( "vehicles = " + registrations.getVehicles() );
    }

    private static void printVehicles(Vehicles vehicles) {
        System.out.println( "chassisNumber = " + vehicles.getChassisNumber() );
        System.out.println( "engineNumber = " + vehicles.getEngineNumber() );
        System.out.println( "fuelUsed = " + vehicles.getFuelUsed() );
        System.out.println( "manufacturerName = " + vehicles.getManufacturerName() );
        System.out.println( "manufactureDate = " + vehicles.getManufactureDate() );
        System.out.println( "model = " + vehicles.getModel() );
        System.out.println( "variant = " + vehicles.getVariant() );
        System.out.println( "vehicleId = " + vehicles.getVehicleId() );
        System.out.println( "vehicleType = " + vehicles.getVehicleType() );
        System.out.println( "vehColor = " + vehicles.getVehColor() );
    }

    private static void printRoles(Roles roles) {
        System.out.println( "rolename = " + roles.getRolename() );
        System.out.println( "roleDescription = " + roles.getRoleDescription() );
    }

    private static void printOffenseDetails(OffenseDetails offensedetails) {
        System.out.println( "image = " + offensedetails.getImage() );
        System.out.println( "offenseDateTime = " + offensedetails.getOffenseDateTime() );
        System.out.println( "offenseDetailId = " + offensedetails.getOffenseDetailId() );
        System.out.println( "penaltyStatus = " + offensedetails.getPenaltyStatus() );
        System.out.println( "place = " + offensedetails.getPlace() );
        System.out.println( "offenseTypes = " + offensedetails.getOffenseTypes() );
        System.out.println( "registrations = " + offensedetails.getRegistrations() );
        System.out.println( "users = " + offensedetails.getUsers() );
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext( env );
    }
}
