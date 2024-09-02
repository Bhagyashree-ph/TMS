/*
 * ResourceManager class helps to get the connection and close the resources
 */

package tms.persistence.utility;

import java.sql.*;

public class ResourceManager implements AutoCloseable {

    private static Connection conn;
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String connnection = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "TMS";
    private static String password = "TMS";
    ResultSet resultSet;
    PreparedStatement ps;

    public static Connection obtainConnection() {
        try {
            Class.forName(driverName);
            System.out.println("Driver Ready..");
            //if (conn == null) {
                conn =
DriverManager.getConnection(connnection, username, password);
                System.out.println("Connection established...");
            //}

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close() {
        try {
            if(resultSet != null) {
                resultSet.close();
                System.out.println("Resultset closed.......");
            }
            if(ps != null) {
                ps.close();
                System.out.println("Resultset closed.......");
            }
            if(conn != null)  {
                conn.close();
                System.out.println("Resultset closed.......");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

