package tms.persistence.dao.impl;

import java.sql.*;

import java.util.ArrayList;

import tms.persistence.dao.DAO;
import tms.persistence.entity.VehicleEO;
import tms.persistence.utility.ResourceManager;

public class VehicleDAOImpl implements DAO<VehicleEO>{
    
    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + " VALUES( VEHICLES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET VEH_COLOR=? WHERE VEHICLE_ID=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE VEHICLE_ID=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE VEHICLE_ID=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;
    
    /**
     *This is a constructor
     */
    public VehicleDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTableName() {
        return "vehicles";
    }

    /**
     *
     * @param vehEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(VehicleEO vehEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, vehEO.getEngineNumber());
            ps.setString(2, vehEO.getChassisNumber());
            ps.setString(3, vehEO.getVehicleType());
            ps.setString(4, vehEO.getVehicleBrand());
            ps.setString(5, vehEO.getVehicleColor());
            ps.setString(6, vehEO.getFuelUsed());
            ps.setDate(7, vehEO.getManufacturDate());
            ps.setString(8, vehEO.getManufacturerName());
            ps.setString(9, vehEO.getModelNo());

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
     * @param vehEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(VehicleEO vehEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, vehEO.getVehicleColor());
            ps.setInt(2, vehEO.getVehicleID());

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

            ps.setObject(1, ID);

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
    public VehicleEO findByID(Object ID) throws Exception {
        ResultSet rs = null;
        VehicleEO vehEO = null;
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
                vehEO = new VehicleEO();
                vehEO.setVehicleID(rs.getInt(1));
                vehEO.setEngineNumber(rs.getString(2));
                vehEO.setChassisNumber(rs.getString(3));
                vehEO.setVehicleType(rs.getString(4));
                vehEO.setVehicleBrand(rs.getString(5));
                vehEO.setVehicleColor(rs.getString(6));
                vehEO.setFuelUsed(rs.getString(7));
                vehEO.setManufacturDate(rs.getDate(8));
                vehEO.setManufacturerName(rs.getString(9));
                vehEO.setModelNo(rs.getString(10));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return vehEO;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<VehicleEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<VehicleEO> vehicles = new ArrayList<VehicleEO>();

        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                VehicleEO vehEO = new VehicleEO();
                vehEO.setVehicleID(rs.getInt(1));
                vehEO.setEngineNumber(rs.getString(2));
                vehEO.setChassisNumber(rs.getString(3));
                vehEO.setVehicleType(rs.getString(4));
                vehEO.setVehicleBrand(rs.getString(5));
                vehEO.setVehicleColor(rs.getString(6));
                vehEO.setFuelUsed(rs.getString(7));
                vehEO.setManufacturDate(rs.getDate(8));
                vehEO.setManufacturerName(rs.getString(9));
                vehEO.setModelNo(rs.getString(10));
                vehicles.add(vehEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return vehicles;
    }
}
