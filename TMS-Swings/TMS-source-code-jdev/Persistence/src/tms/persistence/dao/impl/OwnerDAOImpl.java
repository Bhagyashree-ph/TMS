package tms.persistence.dao.impl;

import java.sql.*;

import java.util.ArrayList;

import tms.persistence.dao.DAO;
import tms.persistence.entity.OwnerEO;
import tms.persistence.utility.ResourceManager;

public class OwnerDAOImpl implements DAO<OwnerEO>{
    
    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET ADDRESS=?, PINCODE=? WHERE OWNER_ID=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE OWNER_ID=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE OWNER_ID=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;
    
    public OwnerDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTableName() {
        return "owners";
    }

    /**
     *
     * @param ownEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(OwnerEO ownEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, ownEO.getOwnerID());
            ps.setString(2, ownEO.getIdType());
            ps.setString(3, ownEO.getFName());
            ps.setString(4, ownEO.getLName());
            ps.setDate(5, ownEO.getDob());
            ps.setString(6, ownEO.getGender());
            ps.setString(7, ownEO.getPhoneNumber());
            ps.setString(8, ownEO.getAddress());
            ps.setInt(9, ownEO.getPincode());
            ps.setString(10, ownEO.getOccupation());

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
     * @param ownEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(OwnerEO ownEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, ownEO.getAddress());
            ps.setInt(2, ownEO.getPincode());
            ps.setString(3, ownEO.getOwnerID());
            
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            new ResourceManager().close();
        }
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

            ps.setObject(1, ID);

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
    public OwnerEO findByID(Object ID) throws Exception {
        ResultSet rs = null;
        OwnerEO ownEO = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_BY_PK);
            ps.setObject(1, ID);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            int count = rsMeta.getColumnCount();
            for (int i = 1; i <= count; i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                ownEO = new OwnerEO();
                ownEO.setOwnerID(rs.getString(1));
                ownEO.setIdType(rs.getString(2));
                ownEO.setFName(rs.getString(3));
                ownEO.setLName(rs.getString(4));
                ownEO.setDob(rs.getDate(5));
                ownEO.setGender(rs.getString(6));
                ownEO.setPhoneNumber(rs.getString(7));
                ownEO.setAddress(rs.getString(8));
                ownEO.setPincode(rs.getInt(9));
                ownEO.setOccupation(rs.getString(10));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/*
           finally {
            new ResourceManager().close();
        }
        */
        return ownEO;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<OwnerEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<OwnerEO> owners = new ArrayList<>();

        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                OwnerEO ownEO = new OwnerEO();
                ownEO.setOwnerID(rs.getString(1));
                ownEO.setIdType(rs.getString(2));
                ownEO.setFName(rs.getString(3));
                ownEO.setLName(rs.getString(4));
                ownEO.setDob(rs.getDate(5));
                ownEO.setGender(rs.getString(6));
                ownEO.setPhoneNumber(rs.getString(7));
                ownEO.setAddress(rs.getString(8));
                ownEO.setPincode(rs.getInt(9));
                ownEO.setOccupation(rs.getString(10));
                owners.add(ownEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/*
           finally {
            new ResourceManager().close();
        }
        */
        return owners;
    }
}
