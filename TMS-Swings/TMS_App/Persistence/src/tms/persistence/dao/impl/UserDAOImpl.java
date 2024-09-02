package tms.persistence.dao.impl;

import java.sql.*;

import java.util.ArrayList;

import tms.persistence.dao.DAO;
import tms.persistence.entity.RoleEO;
import tms.persistence.entity.UserEO;
import tms.persistence.utility.ResourceManager;

public class UserDAOImpl implements DAO<UserEO> {

    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + " VALUES(USERS_SEQ.nextval, ?, ?, ?, ?, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET PASSWORD=? WHERE USER_NAME=? OR EMAIL=? OR PHONE_NUMBER=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE USER_ID=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE USER_ID=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;

    /**
     *This is a constructor
     */
    public UserDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTableName() {
        return "Users";
    }

    /**
     *
     * @param userEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(UserEO userEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, userEO.getUserName());
            ps.setString(2, userEO.getPassword());
            ps.setString(3, userEO.getEmail());
            ps.setString(4, userEO.getPhoneNumber());
            ps.setInt(5, userEO.getRole().getRoleID());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return result;
    }

    /**
     *
     * @param userEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(UserEO userEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, userEO.getPassword());
            ps.setString(2, userEO.getUserName());
            ps.setString(3, userEO.getEmail());
            ps.setString(4, userEO.getPhoneNumber());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }/*
           finally {
            new ResourceManager().close();
        }
        */
        return result;
    }

    /**
     *
     * @param ID
     * @return
     * @throws Exception
     */
    @Override
    public Integer delete(Object ID) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_DELETE);

            ps.setString(1, (String)ID);

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return result;
    }

    /**
     *
     * @param ID
     * @return
     * @throws Exception
     */
    @Override
    public UserEO findByID(Object ID) throws Exception {
        ResultSet rs = null;
        UserEO userEO = null;
        
        try {
            ps = con.prepareStatement(SQL_SELECT_BY_PK);
            ps.setString(1, (String)ID);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
               // RoleEO role = new RoleEO();
                userEO = new UserEO();
                userEO.setUserID(rs.getString(1));
                userEO.setUserName(rs.getString(2));
                userEO.setPassword(rs.getString(3));
                userEO.setEmail(rs.getString(4));
                userEO.setPhoneNumber(rs.getString(5));
               // role.setRoleID(rs.getInt(6));
                
                // Invoking Role Details
                RoleDAOImpl roleDAOImplRef = new RoleDAOImpl();
                RoleEO roleEORef = roleDAOImplRef.findByID(rs.getInt(6));
                userEO.setRole(roleEORef);
                
                System.out.println("Role Details : " + roleEORef);
                //userEO.setRole(role);
                
                System.out.println(userEO  + "Test");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/*
           finally {
            new ResourceManager().close();
        }
        */
        return userEO;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<UserEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<UserEO> users = new ArrayList<UserEO>();
        
        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                UserEO userEO = new UserEO();
                userEO.setUserID(rs.getString(1));
                userEO.setUserName(rs.getString(2));
                userEO.setPassword(rs.getString(3));
                userEO.setEmail(rs.getString(4));
                userEO.setPhoneNumber(rs.getString(5));
                RoleDAOImpl roleDAOImplRef = new RoleDAOImpl();
                RoleEO roleEORef = roleDAOImplRef.findByID(rs.getInt(6));
                userEO.setRole(roleEORef);

                users.add(userEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return users;
    }
}
