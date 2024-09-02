package training.iqgateway;

import java.sql.Timestamp;

import java.util.Date;
import java.util.Hashtable;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityManager;

import tms.business.CopEJB;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Owners;
import tms.persistence.Registrations;
import tms.persistence.Users;
import tms.persistence.Vehicles;

public class CopEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            CopEJB copEJB = (CopEJB)context.lookup("TMSEjb-Model-CopEJB#tms.business.CopEJB");
            
          Owners own =  copEJB.findOwner("AP37BG4381");
            System.out.println(" Owner"+ own.getOwnerId());
            
           Vehicles veh =  copEJB.findVehicle("AP37BG4381");
             System.out.println(veh);
            
            OffenseTypes offtype = copEJB.findOffenceType("OF2024051");
            System.out.println(offtype);
            
            Registrations reg = copEJB.findRegistration("AP37BG4381");
            System.out.println("Reg"+reg.getRegistrationId());
            
            Users user = copEJB.findUser("1234");
            System.out.println(user);
            
            OffenseDetails offd = new OffenseDetails(new Timestamp(new java.util.Date().getTime()), "OFD2024", offtype, "Unpaid","Hyderabad",user, reg);
           //System.out.println (copEJB.persistOffenceDetails(offd));
            offd.setPenaltyStatus("Paid");
            OffenseDetails offd1 = copEJB.mergeOffenceDetails(offd);
            System.out.println(offd1);
            
            List<OffenseDetails> offd2 = copEJB.getOffenceDetailsFindAll();
            System.out.println(offd2);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext( env );
    }
}
