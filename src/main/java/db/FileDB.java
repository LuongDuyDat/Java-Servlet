/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.FileUpload;

/**
 *
 * @author datld7
 */
public class FileDB {
    public ArrayList<FileUpload> getFileByAccount(int account_id) {
        ArrayList<FileUpload> files = new ArrayList();
        
        Connection conn = ConnectDB.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            String query = "SELECT * FROM FileUpload WHERE account_id = " + String.valueOf(account_id);
            System.out.println(query);
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                System.out.println(rs.getString("file_name"));
                files.add(new FileUpload(rs.getString("file_path"), rs.getString("file_name")));
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while get files:");
            ex.printStackTrace();
        }
        
        return files;
    }
    
    public void FileUpload(String file_name, String file_path, int account_id) {
        Connection conn = ConnectDB.getConnection();
        Statement st;
        
        try {
            String query = "INSERT INTO FileUpload (file_path, account_id, file_name) VALUES ('" + file_path + "', " 
                    + String.valueOf(account_id) +", '" + file_name + "')";
            st = conn.createStatement();
            System.out.println(query);
            st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("An error occurred while upload file:");
            ex.printStackTrace();
        }
    }
}
