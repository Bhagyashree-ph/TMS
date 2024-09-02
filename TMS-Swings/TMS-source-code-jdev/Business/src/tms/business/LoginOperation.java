package tms.business;

import tms.persistence.entity.UserEO;

public interface LoginOperation {

    /**
     * @param user
     * @return
     * @throws java.lang.Exception
     */
    public boolean loginUser(UserEO user) throws Exception;

    /**
     * @param user
     * @return
     * @throws java.lang.Exception
     */
    public boolean resetPassword(UserEO user) throws Exception;
}
