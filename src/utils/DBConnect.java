/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBConnect {
    private static DBConnect instance;
    private static Connection conn;
    private String DRIVER = "";
    private String URL = "";
    private String USER = "";
    private String PASSWORD = "";
    
    
    
    private DBConnect (){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static DBConnect getInstance() throws SQLException{
        if (instance == null) {
            instance = new DBConnect();
        }else if(instance.getConnection().isClosed()){
            instance = new DBConnect();
        }
        return instance;
    }
}
