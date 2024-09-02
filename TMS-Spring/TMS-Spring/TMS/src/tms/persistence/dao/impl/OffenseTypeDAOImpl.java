package tms.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tms.persistence.dao.DAO;
import tms.persistence.entities.OffenseTypeEO;


/**
 * Provides data access and data manipulation methods on OffenseTypeEO entity object.
 * @author bhagya.shree
 *
 */
public class OffenseTypeDAOImpl implements DAO<OffenseTypeEO, String> {
	
	private SessionFactory sessionFactoryRef;

    public OffenseTypeDAOImpl() {
		super();
	}

	public OffenseTypeDAOImpl(SessionFactory sessionFactoryRef) {
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
     * Inserts a new record into TM.OFFENCE_TYPES table based on the values of offenceTypeEO object.
     * @param offenceTypeEO The OffenseTypeEO enitty object.
     * @return The primary key, offenceID.
     */
    @Override
    public String add(OffenseTypeEO offenceTypeEO) {
        // TODO Auto-generated method stub
        Session sessionRef = sessionFactoryRef.openSession();
        Transaction txn = sessionRef.getTransaction();
        txn.begin();
        String returnedPK = (String)sessionRef.save(offenceTypeEO);
        txn.commit();
        sessionRef.close();
        return returnedPK;
    }

    /**
     * Updates the existing record in the TM.OFFENCE_TYPES tbale.
     * @param offenceTypeEO The OffenseTypeEO entity object with some new values.
     */
    @Override
    public void update(OffenseTypeEO offenceTypeEO) {
        // TODO Auto-generated method stub
        Session sessionRef = sessionFactoryRef.openSession();
        Transaction txn = sessionRef.getTransaction();
        txn.begin();
        sessionRef.update(offenceTypeEO);
        txn.commit();
        sessionRef.close();
    }

    /**
     * Delete the existing record from the TM.OFFENCE_TYPES table.
     * @param ID The primary key, offenceID
     */
    @Override
    public void delete(String ID) {
        // TODO Auto-generated method stub
        Session sessionRef = sessionFactoryRef.openSession();
        Transaction txn = sessionRef.getTransaction();
        OffenseTypeEO oft = sessionRef.get(OffenseTypeEO.class, ID);
        if (oft != null) {
            txn.begin();
            sessionRef.delete(oft);
            txn.commit();
        }
        sessionRef.close();
    }

    /**
     * Fetch single record from TM.OFFENCE_TYPES table whose primary key matches with ID.
     * @param ID The primary key, offenceID.
     * @return The OffenseTypeEO object.
     */
    @Override
    public OffenseTypeEO findByID(String ID) {
        // TODO Auto-generated method stub
        Session sessionRef = sessionFactoryRef.openSession();
        OffenseTypeEO oft = sessionRef.get(OffenseTypeEO.class, ID);
        sessionRef.close();
        return oft;
    }

    /**Fetches all the records from TM.OFFENCE_TYPES table.
     * @return List of OffenseTypeEO objects.
     */
    @Override
    public List<OffenseTypeEO> findAll() {
        // TODO Auto-generated method stub
        Session sessionRef = sessionFactoryRef.openSession();
        List<OffenseTypeEO> oftlist =
            sessionRef.createCriteria(OffenseTypeEO.class).list();
        sessionRef.close();
        return oftlist;
    }

}
