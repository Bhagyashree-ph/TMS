package tms.persistence.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.RoleDAOImpl;
import tms.persistence.dao.impl.UsersDAOImpl;
import tms.persistence.entities.RoleEO;
import tms.persistence.entities.UsersEO;


public class UsersEOTest {
	
	private DAO<UsersEO, String> userDAORef = new UsersDAOImpl();
	private DAO<RoleEO, String> roleDAORef = new RoleDAOImpl();
	
	@Test
	public void createUserTest() {
		RoleEO role = roleDAORef.findByID("RTO");
		UsersEO userEORef = new UsersEO("Nick","rock123","rock123@gmail.com",role);
		String returnedKey =(String) userDAORef.add(userEORef);
		System.out.println(returnedKey);
		Assert.assertNotNull(returnedKey);
	}
	
	@Test
	public void updateUserTest() {
		RoleEO role = roleDAORef.findByID("RTO");
		UsersEO userEORef = new UsersEO("Rock","Rock@123","rock@gmail.com",role);
		
		userDAORef.update(userEORef);
		
		UsersEO userEO = userDAORef.findByID(userEORef.getUserId());
		Assert.assertEquals("Rock@123", userEO.getPassword());
	}
	
	@Test
	public void deleteUserTest() {
		userDAORef.delete("U007");
		UsersEO userEO = userDAORef.findByID("U001");
		Assert.assertNull(userEO);
	}
	
	@Test
	public void findByIdTest() {
		UsersEO userEO = userDAORef.findByID("U001");
		System.out.println(userEO);
		Assert.assertNotNull(userEO);
	}
	
	@Test
	public void findAllTest() {
		List<UsersEO> users = userDAORef.findAll();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			UsersEO usersEO = (UsersEO) iterator.next();
			System.out.println(usersEO);
		}
	}
}
