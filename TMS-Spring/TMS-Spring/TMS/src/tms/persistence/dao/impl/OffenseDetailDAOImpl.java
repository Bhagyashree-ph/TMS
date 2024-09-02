/**
 * Provides implementation to tms.persistence.dao
 */
package tms.persistence.dao.impl;

import java.util.List;
import tms.persistence.util.Util;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import tms.persistence.dao.DAO;
import tms.persistence.entities.OffenseDetailEO;
import tms.persistence.entities.RegistrationEO;

/**
 * Provides data access and data manipulation methods for OffenceDetailsEO
 * offenceDetailEO.
 * 
 * @author bhagya.shree
 *
 */
//@Service
public class OffenseDetailDAOImpl implements DAO<OffenseDetailEO, String> {

	private SessionFactory sessionFactoryRef;

	public OffenseDetailDAOImpl() {
		super();
	}

	public OffenseDetailDAOImpl(SessionFactory sessionFactoryRef) {
		super();
		this.sessionFactoryRef = sessionFactoryRef;
	}

	public SessionFactory getSessionFactoryRef() {
		return sessionFactoryRef;
	}

	public void setSessionFactoryRef(SessionFactory sessionFactoryRef) {
		this.sessionFactoryRef = sessionFactoryRef;
	}

	/**
	 * Inserts the details of offenceDetailEO to TM.OFFENCE_DETAILS table in the
	 * database.
	 * 
	 * @param offenseDetailEO
	 *            the OffenseDetailEO entity object
	 * @return Tthe offenceDetailID.
	 * @see tms.persistence.dao.DAO#add(java.lang.Object)
	 */
	@Override
	public String add(OffenseDetailEO offenseDetailEO) {
		// TODO Auto-generated method stub
		// SessionFactory sess = Util.getSessionFactory();
		Session sessionRef = sessionFactoryRef.openSession();
		Transaction txn = sessionRef.getTransaction();
		txn.begin();
		offenseDetailEO.setOffenseDetailId("OFD012");
		String returnedPK = (String) sessionRef.save(offenseDetailEO);
		txn.commit();
		sessionRef.close();
		return returnedPK;
	}

	/**
	 * Updates the existing record in TM.OFFENCE_DETAILS table in the database.
	 * 
	 * @param offenceDetailEO
	 *            the OffenseDetailEO entity object
	 * @see tms.persistence.dao.DAO#update(java.lang.Object)
	 */
	@Override
	public void update(OffenseDetailEO offenceDetailEO) {
		// TODO Auto-generated method stub
		Session sessionRef = sessionFactoryRef.openSession();
		Transaction txn = sessionRef.getTransaction();
		txn.begin();
		sessionRef.update(offenceDetailEO);
		txn.commit();
		sessionRef.close();
	}

	/**
	 * Delete the existing record in TM.OFFENCE_DETAILS table in the database.
	 * 
	 * @param ID
	 *            the primary key of TM.OFFENCE_DETAILS
	 * @see tms.persistence.dao.DAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		Session sessionRef = sessionFactoryRef.openSession();
		Transaction txn = sessionRef.getTransaction();
		OffenseDetailEO ofd = sessionRef.get(OffenseDetailEO.class, ID);
		if (ofd != null) {
			txn.begin();
			sessionRef.delete(ofd);
			txn.commit();
		}
		sessionRef.close();
	}

	/**
	 * Fetch single record that matches with given ID.
	 * 
	 * @param ID
	 *            primary of offenceDetailEO OffenseDetailEO
	 * @return The OffenseDetailEO object
	 * @see tms.persistence.dao.DAO#findByID(java.lang.Object)
	 */
	@Override
	public OffenseDetailEO findByID(String ID) {
		// TODO Auto-generated method stub
		Session sessionRef = sessionFactoryRef.openSession();
		OffenseDetailEO ofd = sessionRef.get(OffenseDetailEO.class, ID);
		sessionRef.close();
		return ofd;
	}

	/**
	 * Fetches all the records from TM.OFFENCE_DETAILS table in the database.
	 * 
	 * @return The list OffenseDetailEO objects.
	 * @see tms.persistence.dao.DAO#findAll()
	 */
	@Override
	public List<OffenseDetailEO> findAll() {
		// TODO Auto-generated method stub
		Session sessionRef = sessionFactoryRef.openSession();
		List<OffenseDetailEO> ofdlist = sessionRef.getNamedQuery("OffenseDetails.findAll").list();
		sessionRef.close();
		return ofdlist;
	}

	public List<OffenseDetailEO> findByReg(String registrationNo, String penaltyStatus) {
    	Session sessionRef = sessionFactoryRef.openSession();
		Criteria criteria = sessionRef.createCriteria(OffenseDetailEO.class);
		if(registrationNo != null) {
			criteria = criteria.add(Restrictions.eq("registration.registrationID", registrationNo));
			 if(penaltyStatus != null){
				 String givenPenaltyStatus = penaltyStatus.toLowerCase();
				 System.out.println(givenPenaltyStatus);
				 if(penaltyStatus.equalsIgnoreCase(givenPenaltyStatus)) {
					 criteria = criteria.add(Restrictions.eq("penaltyStatus", givenPenaltyStatus));
					 System.out.println("True");
				 }
			}
			 return criteria.list();
		}
		return null;
		
    }

}
