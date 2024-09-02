package tms.persistence.dao.impl;

import java.util.ArrayList;

import java.sql.*;

import tms.persistence.dao.DAO;
import tms.persistence.entity.OwnerEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.VehicleEO;
import tms.persistence.utility.ResourceManager;

public class RegistrationDAOImpl implements DAO<RegistrationEO> {

    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + " VALUES(?, ?, ?, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET OWNER_ID=? WHERE REGISTRATION_ID=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE REGISTRATION_ID=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE REGISTRATION_ID=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;

    public RegistrationDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTableName() {
        return "Registrations";
    }

    /**
     *
     * @param regEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(RegistrationEO regEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, regEO.getRegistrationID());
            ps.setInt(2, regEO.getVehicle().getVehicleID());
            ps.setString(3, regEO.getOwner().getOwnerID());
            ps.setDate(4, regEO.getRegistrationDate());

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
     * @param regEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(RegistrationEO regEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, regEO.getOwner().getOwnerID());
            ps.setString(2, regEO.getRegistrationID());

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
    public Integer delete(Object ID) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_DELETE);

            ps.setString(1, (String)ID);

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
    public RegistrationEO findByID(Object ID) throws Exception {
        ResultSet rs = null;
        RegistrationEO regEO = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_BY_PK);
            ps.setString(1, (String)ID);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            int count = rsMeta.getColumnCount();
            for (int i = 1; i <= count; i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                regEO = new RegistrationEO();
                regEO.setRegistrationID(rs.getString(1));
                
                DAO<VehicleEO> vehicleDAO = new VehicleDAOImpl();
                VehicleEO vehicle = vehicleDAO.findByID(rs.getInt(2));
                regEO.setVehicle(vehicle);
                
                DAO<OwnerEO> ownerDAO = new OwnerDAOImpl();
                OwnerEO owner = ownerDAO.findByID(rs.getString(3));
                regEO.setOwner(owner);
                
                regEO.setRegistrationDate(rs.getDate(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return regEO;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<RegistrationEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<RegistrationEO> registrations = new ArrayList<>();

        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            
            System.out.println();
            while (rs.next()) {
                VehicleEO vehicle = new VehicleEO();
                OwnerEO owner = new OwnerEO();
                RegistrationEO regEO = new RegistrationEO();
                regEO.setRegistrationID(rs.getString(1));
                vehicle.setVehicleID(rs.getInt(2));
                regEO.setVehicle(vehicle);
                owner.setOwnerID(rs.getString(3));
                regEO.setOwner(owner);
                regEO.setRegistrationDate(rs.getDate(4));
                registrations.add(regEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/*
           finally {
            new ResourceManager().close();
        }
        */
        return registrations;
    }
}
