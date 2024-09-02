package tms.persistence.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.RoleDAOImpl;
import tms.persistence.entities.RoleEO;


public class RoleEOTest {
	
	private DAO<RoleEO, String> roleDAORef = new RoleDAOImpl();
	
	@Test
	public void createRoleTest() {
		RoleEO roleEORef = new RoleEO("RTO", "Manage Owners and Vehicles");
		String returnedKey =(String) roleDAORef.add(roleEORef);
		Assert.assertEquals("RTO", returnedKey);
	}
	
	@Test
	public void updateRoleTest() {
		RoleEO roleEORef = new RoleEO("Software", "Build software");
		roleDAORef.update(roleEORef);
		
		RoleEO roleEO = roleDAORef.findByID(roleEORef.getRoleName());
		Assert.assertEquals("Build software", roleEO.getRoleDesc());
	}
	
	
	@Test
	public void deleteTest() {
		roleDAORef.delete("Software");
		RoleEO roleEO = roleDAORef.findByID("Software");
		Assert.assertNull(roleEO);	
	}
	
	@Test
	public void findByRoleNameTest() {
		RoleEO roleEO = roleDAORef.findByID("Software");
		Assert.assertEquals("Software", roleEO.getRoleName());
	}
	
	@Test
	public void findAllTest() {
		List<RoleEO> role = roleDAORef.findAll();
		Assert.assertNotNull(role);
		for (Iterator iterator = role.iterator(); iterator.hasNext();) {
			RoleEO roleEO = (RoleEO) iterator.next();
			System.out.println(roleEO);
		}
	}
	
	
}
