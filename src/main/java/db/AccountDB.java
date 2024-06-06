/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author datld7
 */
public class AccountDB {
    public int checkLogin(String username, String password) {
        Connection conn = ConnectDB.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            String query = "SELECT * FROM Account WHERE UserName = '" + username + "' AND Password = '" + password + "'";
            System.out.println(query);
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            int rowCount = 0;
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("id");
                rowCount++;
            }
            if (rowCount == 1) {
                return id;
            }
        } catch(SQLException ex) {
            System.out.println("An error occurred while check login:");
            ex.printStackTrace();
        }
        
        return 0;
    }
}
