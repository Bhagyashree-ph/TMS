package model;

import java.util.Hashtable;
import java.util.List;

import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.naming.NamingException;

import tms.business.AdminEJB;

import tms.persistence.Roles;
import tms.persistence.Users;

public class AdminEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            AdminEJB adminEJB = (AdminEJB)context.lookup("TMS_EJBs-Model-AdminEJB#tms.business.AdminEJB");
            for (Users users : (List<Users>)adminEJB.getUsersFindAll()) {
                System.out.println(users);
            }
            for (Roles roles : (List<Roles>)adminEJB.getRolesFindAll()) {
                System.out.println(roles);
            }
            
            Roles roles = new Roles("Clerk","Raises, clears and generate reports for offense");
            //adminEJB.persistRoles(roles);
            
            //roles.setRoleDescription("Generates Offense reports");
            //Roles mergeRoles = adminEJB.mergeRoles(roles);

            System.out.println(adminEJB.findRoleById("RTO"));
            
            //adminEJB.removeRoles(roles);
            
            System.out.println(adminEJB.findUserById("01"));
            
            //roles.setRolename("RTO");
            Users user = new Users("dhivyaa@gmail.com","Dhivy@28",roles,"02","Dhivyaa");
            
            //adminEJB.persistUsers(user);
            adminEJB.mergeUsers(user);
            adminEJB.removeUsers(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext( env );
    }
}
