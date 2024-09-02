package tms.persistence.test;

import java.util.*;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.RoleDAOImpl;
import tms.persistence.entity.RoleEO;
import tms.persistence.factory.DAOFactory;

public class RoleDAOTest {

    DAO<RoleEO> roleDAO = DAOFactory.createDAO(new RoleDAOImpl());

    private static final Scanner scan = new Scanner(System.in);

    /**
     * testCreateRole() adds new Role into the Roles table
     */

    public void testCreateRole() throws Exception {
        RoleEO roleEO = new RoleEO();
        roleEO.setRoleName(scan.next());
        Integer res = roleDAO.add(roleEO);
        if (res > 0)
            System.out.println(res + " rows inserted.");
    }

    /**
         * testReadRoleByPK(int roleID) takes Role_id as an integer parameter
         * and prints the Role record of the Role_id specified.
         */

    public void testReadRoleByPK(String roleName) throws Exception {
        RoleEO roleEO = roleDAO.findByID(roleName);
        System.out.println(roleEO);
    }

    /**
         *testReadAllRoles() prints all the Roles from the Roles table.
         */

    public void testReadAllRoles() throws Exception {
        ArrayList<RoleEO> roleEO = roleDAO.findAll();
        for (RoleEO d : roleEO) {
            System.out.println(d);
        }
    }

    /**
         * testUpdateRoles() updates the Role record for the Role_id specified.
         */

    public void testUpdateRoles() throws Exception {
        RoleEO roleEO = new RoleEO(scan.nextInt(), scan.next());
        Integer res = roleDAO.update(roleEO);
        if (res > 0)
            System.out.println(res + " rows updated.");
    }

    /**
         * testDeleteRoles(int roleID) deletes the record for Role_id specified.
         */

    public void testDeleteRoles(String roleName) throws Exception {
        Integer res = roleDAO.delete(roleName);
        if (res > 0)
            System.out.println(res + " rows deleted.");

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        RoleDAOTest roleDAOTest = new RoleDAOTest();
//        roleDAOTest.testCreateRole();
        //roleDAOTest.testReadRoleByPK(scan.next());
        //roleDAOTest.testReadAllRoles();
        //roleDAOTest.testUpdateRoles();
        //roleDAOTest.testDeleteRoles(scan.next());

    }
}
