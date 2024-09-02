package tms.persistence.dao;

import java.util.ArrayList;

/**
 * @param <E>
 * E is an entity object
 */
public interface DAO<E> {

    /**
     * @return
     * @throws java.lang.Exception
     */
    public String getTableName() throws Exception;

    /**
     * @param entity
     * @return
     * @throws java.lang.Exception
     */
    public Integer add(E entity) throws Exception;

    /**
     * @param entity
     * @return
     * @throws java.lang.Exception
     */
    public Integer update(E entity) throws Exception;

    /**
     * @param ID
     * @return
     * @throws java.lang.Exception
     */
    public Integer delete(Object ID) throws Exception;

    /**
     * @param ID
     * @return
     * @throws java.lang.Exception
     */
    public E findByID(Object ID) throws Exception;

    /**
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<E> findAll() throws Exception;
    
}

