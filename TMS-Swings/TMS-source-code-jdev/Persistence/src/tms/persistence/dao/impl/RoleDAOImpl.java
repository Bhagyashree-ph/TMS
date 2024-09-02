package tms.persistence.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import tms.persistence.dao.DAO;
import tms.persistence.entity.RoleEO;
import tms.persistence.utility.ResourceManager;

public class RoleDAOImpl implements DAO<RoleEO> {

    private final String SQL_SELECT = "SELECT * FROM " + getTableName();

    private final String SQL_INSERT =
        "INSERT INTO " + getTableName() + "(role_id, role_name) VALUES(roles_seq.NEXTVAL, ?)";

    private final String SQL_UPDATE =
        "UPDATE " + getTableName() + " SET ROLE_NAME=? WHERE ROLE_ID=?";

    private final String SQL_DELETE =
        "DELETE FROM " + getTableName() + " WHERE ROLE_NAME=?";

    private final String SQL_SELECT_BY_PK =
        "SELECT * FROM " + getTableName() + " WHERE ROLE_ID=?";

    private final Connection con = ResourceManager.obtainConnection();

    private PreparedStatement ps = null;

    public RoleDAOImpl() {
        super();
    }

    /**
     *
     * @return
     */
    @Override

    public String getTableName() {
        return "Roles";
    }

    /**
     *
     * @param roleEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer add(RoleEO roleEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, roleEO.getRoleName());

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
     * @param roleEO
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(RoleEO roleEO) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_UPDATE);

            ps.setString(1, roleEO.getRoleName());
            ps.setInt(2, roleEO.getRoleID());

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
     * @param roleName
     * @return
     * @throws Exception
     */
    @Override
    public Integer delete(Object roleName) throws Exception {
        int result = 0;
        try {
            ps = con.prepareStatement(SQL_DELETE);

            ps.setString(1, (String)roleName);

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
     * @param roleID
     * @return
     * @throws Exception
     */
    @Override
    public RoleEO findByID(Object roleID) throws Exception {
        ResultSet rs = null;
        RoleEO roleEO = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_BY_PK);
           ps.setInt(1, (Integer)roleID);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            int count = rsMeta.getColumnCount();
            for (int i = 1; i <= count; i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                roleEO = new RoleEO();
                roleEO.setRoleID(rs.getInt(1));
                roleEO.setRoleName(rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return roleEO;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<RoleEO> findAll() throws Exception {
        ResultSet rs = null;
        ArrayList<RoleEO> roles = new ArrayList<RoleEO>();

        try {
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++)
                System.out.print(rsMeta.getColumnLabel(i) + "\t");
            System.out.println();
            while (rs.next()) {
                RoleEO roleEO = new RoleEO();
                roleEO.setRoleID(rs.getInt(1));
                roleEO.setRoleName(rs.getString(2));
                roles.add(roleEO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } /*
           finally {
            new ResourceManager().close();
        }
        */
        return roles;
    }
}
