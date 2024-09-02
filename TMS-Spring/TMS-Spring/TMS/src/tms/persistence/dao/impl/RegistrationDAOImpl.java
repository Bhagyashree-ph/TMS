/*
 * 
 */
package tms.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tms.persistence.dao.DAO;
import tms.persistence.entities.RegistrationEO;

/**
 * Provides data access and data manipulation methods on RegistrationEO entity object.
 * @author bhagya.shree
 *
 */
public class RegistrationDAOImpl implements DAO<RegistrationEO, String> {
	
	private SessionFactory sessionFactoryRef;
	private Session session = null;
    private Transaction txn = null;
    
    public RegistrationDAOImpl() {
		super();
	}

    public RegistrationDAOImpl(SessionFactory sessionFactoryRef) {
		super();
		this.sessionFactoryRef = sessionFactoryRef;
	}

	public SessionFactory getSessionFactoryRef() {
		return sessionFactoryRef;
	}

	public void setSessionFactoryRef(SessionFactory sessionFactoryRef) {
		this.sessionFactoryRef = sessionFactoryRef;
	}

	/**Inserts a new record into TM.REGISTRATIONS table based on the values of registrationEO object.
     * @param registrationEO The RegstrationEO enitty object.
     * @return The primary key, registrationID.
     */
    public String add(RegistrationEO registrationEO) {
        session = sessionFactoryRef.openSession();
        txn = session.getTransaction();
        txn.begin();
        String returnedRegID = (String)session.save(registrationEO);
        if(returnedRegID != null) {
            txn.commit();
            session.close();
        }
        else
            txn.rollback();
        return returnedRegID;
    }

    /**
     * Updates the existing record in the TM.REGISTRATIONS tbale.
     * @param registrationEO The RegstrationEO entity object with some new values.
     */
    public void update(RegistrationEO registrationEO) {
        session = sessionFactoryRef.openSession();
        txn = session.getTransaction();
        txn.begin();
        session.update(registrationEO);
        txn.commit();
        session.clear();
    }

    /**
     * Delete the existing record from the TM.REGISTRATIONS table.
     * @param ID The primary key, registrationID
     */
    public void delete(String ID) {
        session = sessionFactoryRef.openSession();
        txn = session.getTransaction();
        RegistrationEO regEO = session.get(RegistrationEO.class, ID);
        if(regEO != null) {
            txn.begin();
            session.delete(regEO);
            txn.commit();
        }
        session.close();
    }

    /**
     * Fetch single record from TM.REGISTRATIONS table whose primary key matches with ID.
     * @param ID The primary key, registrationID.
     * @return The RegstrationEO object.
     */
    public RegistrationEO findByID(String ID) {
        session = sessionFactoryRef.openSession();
        RegistrationEO regEO = session.get(RegistrationEO.class, ID);
        session.close();
        return regEO;
    }

    /**Fetches all the records from TM.REGISTRATIONS table.
     * @return List of RegstrationEO objects.
     */
    public List<RegistrationEO> findAll() {
        session = sessionFactoryRef.openSession();
        List<RegistrationEO> registrations = session.getNamedQuery("Registrations.findAll").list();
        session.close();
        return registrations;
    }
}
