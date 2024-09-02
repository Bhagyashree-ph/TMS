package tms.persistence.factory;

import tms.persistence.dao.DAO;

public class DAOFactory<E> {

    private  DAO<E> dao;

    private DAOFactory(DAO<E> dao) {
        this.dao = dao;
    }

    /**
     * @param <E>
     * @param daoImpl
     * @return deo
     */
    public static <E> DAO<E> createDAO(DAO<E> daoImpl) {
        return new DAOFactory<>(daoImpl).dao;
    }
        
}
