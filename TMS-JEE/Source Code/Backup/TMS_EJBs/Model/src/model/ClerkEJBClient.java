package training.iqgateway;

import java.sql.Timestamp;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.naming.NamingException;

import tms.business.ClerkEJB;

import tms.persistence.OffenseDetails;
import tms.persistence.OffenseTypes;
import tms.persistence.Registrations;
import tms.persistence.Users;

public class ClerkEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            ClerkEJB clerkEJB = (ClerkEJB)context.lookup("TMSEjb-Model-ClerkEJB#tms.business.ClerkEJB");
            for (OffenseDetails offencedetails : (List<OffenseDetails>)clerkEJB.getOffenceDetailsFindAll()) {
                printOffenceDetails(offencedetails);
            }
            OffenseTypes offtype = clerkEJB.findOffenceType("OF2024051");
            System.out.println(offtype);
            
            Registrations reg = clerkEJB.findRegistration("AP37BG4381");
            System.out.println(reg);
            
            Users user = clerkEJB.findUser("1234");
            System.out.println(user);
            
            OffenseDetails offd = new OffenseDetails(new Timestamp(new java.util.Date().getTime()), "OFD2028", offtype, "Unpaid","Hyderabad",user, reg);
           System.out.println (clerkEJB.persistOffenceDetails(offd));
            
            offd.setPenaltyStatus("Paid");
            OffenseDetails offd1 = clerkEJB.mergeOffenceDetails(offd);
            System.out.println(offd1);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printOffenceDetails(OffenseDetails offencedetails) {
        System.out.println( "image = " + offencedetails.getImage() );
        System.out.println( "offenseDateTime = " + offencedetails.getOffenseDateTime() );
        System.out.println( "offenseDetailId = " + offencedetails.getOffenseDetailId() );
        System.out.println( "penaltyStatus = " + offencedetails.getPenaltyStatus() );
        System.out.println( "place = " + offencedetails.getPlace() );
        System.out.println( "registrations = " + offencedetails.getRegistrations() );
        System.out.println( "offenceTypes = " + offencedetails.getOffenseTypes() );
        System.out.println( "users = " + offencedetails.getUsers() );
    }
    
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext( env );
    }
}
