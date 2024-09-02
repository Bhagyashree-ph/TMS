package tms.persistence.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.OffenseTypeDAOImpl;
import tms.persistence.entities.OffenseTypeEO;


public class OffenseTypeDAOTest {

	private static DAO<OffenseTypeEO, String> daoRef = new OffenseTypeDAOImpl();

	@Test
	public void addTest() {
		OffenseTypeEO oft = new OffenseTypeEO("No License", "Two Wheeler", new Double(200));
		boolean returnedPK = daoRef.add(oft).isEmpty();
		Assert.assertEquals(false, returnedPK);
	}

	@Test
	public void updateTest() {

		OffenseTypeEO oft = new OffenseTypeEO("No License", "Two Wheeler", new Double(400));
		daoRef.update(oft);
		OffenseTypeEO result = daoRef.findByID("OF001");
		System.out.println(oft.equals(result));
		Assert.assertEquals(new Double(400), result.getPenalty());
	}

	@Test
	public void findByIDTest() {
		OffenseTypeEO result = daoRef.findByID("OF001");
		Assert.assertNotNull(result);
		System.out.println(result);
	}

	@Test
	public void deleteTest() {
		daoRef.delete("OF001");
		OffenseTypeEO oft = daoRef.findByID("OF001");
		Assert.assertNull(oft);
	}

	@Test
	public void findAllTest() {
		List<OffenseTypeEO> oftlist = daoRef.findAll();
		for (OffenseTypeEO of : oftlist)
			System.out.println(of);
		Assert.assertNotNull(oftlist);
	}
}
