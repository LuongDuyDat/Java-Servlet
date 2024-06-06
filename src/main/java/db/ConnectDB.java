/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author datld7
 */
public class ConnectDB {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            try {

                String dbURL = "jdbc:sqlserver://DESKTOP-3EFFQ58\\JUN5:1433;encrypt=true;trustServerCertificate=true;databaseName=MemoryShellDb";
                String user = "sa";
                String pass = "123456";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(dbURL, user, pass);

            } catch (Exception ex) {
                System.out.println("An error occurred while establishing the connection:");
                ex.printStackTrace();
            }

            return conn;
        } else {
            return conn;
        }
    }
}
