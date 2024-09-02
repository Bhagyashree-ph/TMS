package tms.business;

import java.util.ArrayList;

import tms.persistence.entity.RoleEO;
import tms.persistence.entity.UserEO;

public interface AdminOperations {
    
    //manage users

    /**
     * @param user
     * @return
     * @throws java.lang.Exception
     */
    public Integer addNewUser(UserEO user) throws Exception;

    /**
     * @param user
     * @return
     * @throws java.lang.Exception
     */
    public Integer updateUser(UserEO user) throws Exception;

    /**
     * @param userID
     * @return
     * @throws java.lang.Exception
     */
    public Integer deleteUser(String userID) throws Exception;

    /**
     * @param userID
     * @return
     * @throws java.lang.Exception
     */
    public UserEO findByUserID(String userID) throws Exception;

    /**
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<UserEO> findAllUsers() throws Exception;
    
    //manage roles

    /**
     * @param role
     * @return
     * @throws java.lang.Exception
     */
    public Integer addNewRole(RoleEO role) throws Exception;

    /**
     * @param role
     * @return
     * @throws java.lang.Exception
     */
    public Integer UpdateRole(RoleEO role) throws Exception;

    /**
     * @param roleName
     * @return
     * @throws java.lang.Exception
     */
    public Integer deleteRole(String roleName) throws Exception;

    /**
     * @param roleName
     * @return
     * @throws java.lang.Exception
     */
    public RoleEO findRoleByID(String roleName) throws Exception;

    /**
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<RoleEO> findAllRoles() throws Exception;
}
