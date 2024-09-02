/*
 * 
 */
package tms.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tms.persistence.dao.DAO;
import tms.persistence.entities.VehicleEO;

/**
 * Provides data access and data manipulation methods on VehicleEO entity object.
 * @author bhagya.shree
 *
 */
public class VehicleDAOImpl implements DAO<VehicleEO,Integer>{
	
	private SessionFactory sessionFactoryRef;

	public VehicleDAOImpl() {
		super();
	}

	public VehicleDAOImpl(SessionFactory sessionFactoryRef) {
		super();
		this.sessionFactoryRef = sessionFactoryRef;
	}

	public SessionFactory getSessionFactoryRef() {
		return sessionFactoryRef;
	}

	public void setSessionFactoryRef(SessionFactory sessionFactoryRef) {
		this.sessionFactoryRef = sessionFactoryRef;
	}

	/**Inserts a new record into TM.VEHICLES table based on the values of vehicleEO object.
     * @param registrationEO The VehicleEO enitty object.
     * @return The primary key, vehicleID.
     */
    public Integer add(VehicleEO vehicleEO) {
        Session sessionRef = sessionFactoryRef.openSession();
        Transaction tnx = sessionRef.getTransaction();
        tnx.begin();
        Integer returnedKey = (Integer) sessionRef.save(vehicleEO);
        tnx.commit();
        sessionRef.close();
        return returnedKey;
    }

    /**
     * Updates the existing record in the TM.VEHICLES tbale.
     * @param registrationEO The VehicleEO entity object with some new values.
     */
    public void update(VehicleEO vehicleEO) {
        Session sessionRef = sessionFactoryRef.openSession();
        Transaction tnx = sessionRef.getTransaction();
        tnx.begin();
        sessionRef.update(vehicleEO);
        tnx.commit();
        sessionRef.close();
    }

    /**
     * Delete the existing record from the TM.VEHICLES table.
     * @param ID The primary key, vehicleID
     */
    public void delete(Integer ID) {
        Session sessionRef = sessionFactoryRef.openSession();
        Transaction tnx = sessionRef.getTransaction();
        VehicleEO vehicle = sessionRef.get(VehicleEO.class, ID);
        if(vehicle != null) {
            tnx.begin();
            sessionRef.delete(vehicle);
            tnx.commit();
        }
        sessionRef.close();
    }

    /**
     * Fetch single record from TM.VEHICLES table whose primary key matches with ID.
     * @param ID The primary key, vehicleID.
     * @return The VehicleEO object.
     */
    public VehicleEO findByID(Integer ID) {
        Session sessionRef = sessionFactoryRef.openSession();
        VehicleEO vehicle = sessionRef.get(VehicleEO.class, ID);
        sessionRef.close();
        return vehicle;
    }


    /**Fetches all the records from TM.VEHICLES table.
     * @return List of VehicleEO objects.
     */
    public List<VehicleEO> findAll() {
        Session sessionRef = sessionFactoryRef.openSession();
        List vehicles = sessionRef.createCriteria(VehicleEO.class).list();
        sessionRef.close();
        return vehicles;
    }
}

