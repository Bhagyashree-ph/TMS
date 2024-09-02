package tms.persistence.dao;

import java.util.List;

/**
 * This interface provides declaration methods for the Database operations on given entity E and whose primary key of type U
 * @param <E> Entity object which is related to the table in the database. 
 * @param <U> Primary of that table.
 */
public interface DAO<E, U> {

    /**
     * Inserts a new row of entity in the database.
     * @param entity Entity object related to a table in the database
     * @return Primary key of the table.
     */
    public U add(E entity);

    /**
     * 
     * Updates the existing record in the related table.
     * @param entity
     */
    public void update(E entity);

    /**
     * 
     * Deletes the existing record in the related table based on the given ID.
     * @param ID Primary key of the table.
     */
    public void delete(U ID);

    /**
     * 
     * Fetches the details of a E in the related table based on the given ID.
     * @param ID Primary key of the table.
     * @return Entity object of the requested table.
     */
    public E findByID(U ID);

    /**
     * Fetches all the records in the particular table.
     * @return List of entity object.
     */
    public List<E> findAll();

}

