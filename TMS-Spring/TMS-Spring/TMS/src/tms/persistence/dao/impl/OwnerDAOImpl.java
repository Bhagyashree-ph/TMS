/*
 * 
 */
package tms.persistence.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tms.persistence.dao.DAO;
import tms.persistence.entities.OwnerEO;


public class OwnerDAOImpl implements DAO<OwnerEO, String> {
	
	private SessionFactory sessionFactoryRef;

    public OwnerDAOImpl() {
		super();
	}

	public OwnerDAOImpl(SessionFactory sessionFactoryRef) {
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
     * @param ownerRef
     * @return
     */
    @Override
	public String add(OwnerEO ownerRef) {
		// TODO Auto-generated method stub
		Session sessionRef = sessionFactoryRef.openSession();
		Transaction transcation=sessionRef.getTransaction();
		transcation.begin();
			String result=(String)sessionRef.save(ownerRef);
		transcation.commit();
		sessionRef.close();
		return result;
	}

    /**
     * @param owner_id
     */
    @Override
	public void delete(String owner_id) {
		Session sessionRef=sessionFactoryRef.openSession();
		Transaction transcation=sessionRef.getTransaction();
		OwnerEO findOwner=sessionRef.get(OwnerEO.class, owner_id);
		if(findOwner!=null){
			transcation.begin();
				sessionRef.delete(findOwner);
			transcation.commit();
		}
		sessionRef.close();
		
	}

    /**
     * @param ownerRef
     */
    @Override
	public void update(OwnerEO ownerRef) {
		// TODO Auto-generated method stub
		Session sessionRef=sessionFactoryRef.openSession();
		Transaction transcation=sessionRef.getTransaction();
			transcation.begin();
				sessionRef.update(ownerRef);
			transcation.commit();
		sessionRef.close();
		
	}

    /**
     * @param owner_id
     * @return
     */
    @Override
	public OwnerEO findByID(String owner_id) {
		// TODO Auto-generated method stub
		Session sessionRef=sessionFactoryRef.openSession();
		   OwnerEO owner= sessionRef.get(OwnerEO.class,owner_id);
		 sessionRef.close();
		return owner;
	}

    /**
     * @return
     */
    @Override
	public List<OwnerEO> findAll() {
		// TODO Auto-generated method stub
		Session sessionRef=sessionFactoryRef.openSession();
	   Query query=sessionRef.getNamedQuery("Owners.findAll");
	   List<OwnerEO> owners=query.list();
		return owners;
	}



}
