/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // JDBC driver name and database URL
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private final String DB_URL = "jdbc:mysql://localhost/penjualan_makanan";

    //  Database credentials
    private final String USER = "root";
    private final String PASS = "";
    
    private Connection conn = null;
    
    public Koneksi() {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch(SQLException se){
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public Connection getKoneksi() {
        return conn;
    }
}
