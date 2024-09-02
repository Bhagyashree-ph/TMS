package tms.persistence.dao.impl;

import java.sql.*;

import java.util.*;

import tms.persistence.dao.DAO;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.utility.ResourceManager;

public class OffenceTypeDAOImpl implements DAO<OffenceTypeEO> {

    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + " VALUES(offense_types_seq.NEXTVAL, ?, ?, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET penalty=? WHERE offense_id=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE offense_id=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE offense_id=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;

    public OffenceTypeDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTableName() {
        return "offense_types";
    }

    /**
     *
     * @param offEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(OffenceTypeEO offEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, offEO.getOffenseName());
            ps.setString(2, offEO.getVehicleType());
            ps.setInt(3, offEO.getPenalty());

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
     * @param offEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(OffenceTypeEO offEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setInt(1, offEO.getPenalty());
            ps.setString(2, offEO.getOffenseID());

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
    public OffenceTypeEO findByID(Object ID) throws Exception {
        ResultSet rs = null;
        OffenceTypeEO offEO = null;
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
                offEO = new OffenceTypeEO();
                offEO.setOffenseID(rs.getString(1));
                offEO.setOffenseName(rs.getString(2));
                offEO.setVehicleType(rs.getString(3));
                offEO.setPenalty(rs.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return offEO;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<OffenceTypeEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<OffenceTypeEO> offenses = new ArrayList<>();

        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                OffenceTypeEO offEO = new OffenceTypeEO();
                offEO.setOffenseID(rs.getString(1));
                offEO.setOffenseName(rs.getString(2));
                offEO.setVehicleType(rs.getString(3));
                offEO.setPenalty(rs.getInt(4));
                offenses.add(offEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return offenses;
    }
}
