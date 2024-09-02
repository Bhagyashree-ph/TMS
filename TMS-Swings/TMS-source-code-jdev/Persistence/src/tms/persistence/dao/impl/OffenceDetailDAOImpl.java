package tms.persistence.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import tms.persistence.dao.DAO;
import tms.persistence.entity.OffenceDetailEO;
import tms.persistence.entity.OffenceTypeEO;
import tms.persistence.entity.RegistrationEO;
import tms.persistence.entity.UserEO;
import tms.persistence.utility.ResourceManager;

public class OffenceDetailDAOImpl implements DAO<OffenceDetailEO> {
    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + " VALUES(offense_details_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET penalty_status=? WHERE offense_detail_id=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE offense_detail_id=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE offense_detail_id=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;

    public OffenceDetailDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTableName() {
        return "offense_details";
    }

    /**
     *
     * @param offEO
     * @return
     */
    @Override
    public Integer add(OffenceDetailEO offEO)  throws Exception{
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);
            
            ps.setTimestamp(1, offEO.getOffenseDateTime());
            ps.setString(2, offEO.getPlace());
            ps.setBytes(3, offEO.getImage());
            ps.setString(4, offEO.getRegistration().getRegistrationID());
            ps.setString(5, offEO.getOffense().getOffenseID());
            ps.setString(6, offEO.getUser().getUserID());
            ps.setString(7, offEO.getPenaltyStatus());

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
     */
    @Override
    public Integer update(OffenceDetailEO offEO)  throws Exception{
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, offEO.getPenaltyStatus());
            ps.setString(2, offEO.getOffenseDetailID());

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
    public OffenceDetailEO findByID(Object ID) throws Exception {
        ResultSet rs = null;
        OffenceDetailEO offEO = null;
        
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
                
                offEO = new OffenceDetailEO();
                offEO.setOffenseDetailID(rs.getString(1));
                offEO.setOffenseDateTime(rs.getTimestamp(2));
                offEO.setPlace(rs.getString(3));
                offEO.setImage(rs.getBytes(4));
                
                DAO<RegistrationEO> regDAO = new RegistrationDAOImpl();
                RegistrationEO registration = regDAO.findByID(rs.getString(5));
                offEO.setRegistration(registration);
                
                DAO<OffenceTypeEO> offDAO = new OffenceTypeDAOImpl();
                OffenceTypeEO offense = offDAO.findByID(rs.getString(6));
                offEO.setOffense(offense);
                
                DAO<UserEO> userDAO = new UserDAOImpl();
                UserEO user = userDAO.findByID(rs.getString(7));
                offEO.setUser(user);
                
                offEO.setPenaltyStatus(rs.getString(8));

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
    public ArrayList<OffenceDetailEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<OffenceDetailEO> offenseDetails = new ArrayList<>();

        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                RegistrationEO registration = new RegistrationEO();
                OffenceTypeEO offense = new OffenceTypeEO();
                UserEO user = new UserEO();
                
                OffenceDetailEO offEO = new OffenceDetailEO();
                
                offEO.setOffenseDetailID(rs.getString(1));
                offEO.setOffenseDateTime(rs.getTimestamp(2));
                offEO.setPlace(rs.getString(3));
                offEO.setImage(rs.getBytes(4));
                
                registration.setRegistrationID(rs.getString(5));
                offEO.setRegistration(registration);
                
                offense.setOffenseID(rs.getString(6));
                offEO.setOffense(offense);
                
                user.setUserID(rs.getString(7));
                offEO.setUser(user);
                offEO.setPenaltyStatus(rs.getString(8));
                
                offenseDetails.add(offEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return offenseDetails;
    }
}
