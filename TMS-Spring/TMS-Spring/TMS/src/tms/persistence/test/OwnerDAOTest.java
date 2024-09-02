package tms.persistence.test;

import java.sql.Date;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OwnerDAOImpl;
import tms.persistence.entities.OwnerEO;


public class OwnerDAOTest {

	private DAO<OwnerEO, String> ownerRef = new OwnerDAOImpl();
	
	@Test
	public void addOwnerTest(){
		OwnerEO addOwnerRef=new OwnerEO("1001","Adhar","abc","xyz",Date.valueOf("2002-01-12"),"male","98765678","SVRoad",565456,"abz");
		String owner=ownerRef.add(addOwnerRef);
		Assert.assertEquals("1001", owner);
	}
	
	@Test
	public void deleteOwnerTest(){
		ownerRef.delete("1001");
		OwnerEO owner=ownerRef.findByID("1001");
		Assert.assertNull(owner);
	}
	
	@Test
	public void updateOwnerTest(){
		OwnerEO OwnerRef=new OwnerEO("1001","Adhar","klm","xyz",Date.valueOf("2002-01-12"),"male","98765678","SVRoad",565456,"abz");
		ownerRef.update(OwnerRef);
		OwnerEO owner=ownerRef.findByID("1001");
		Assert.assertEquals("klm",owner.getFirstName());
	}
	
	@Test
	public void findByName(){
		OwnerEO owner=ownerRef.findByID("1001");
		Assert.assertNotNull(owner);
	}
	
	@Test
	public void findAll(){
		List<OwnerEO> owners=ownerRef.findAll();
		Assert.assertNotNull(owners);
		for (Iterator iterator = owners.iterator(); iterator.hasNext();) {
			OwnerEO ownerEO = (OwnerEO) iterator.next();
			
		}
	}
	
	

}
