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
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/penjualan_makanan";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    static Koneksi conn;
    
    public Koneksi() {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            
            // Open a connection
            conn = (Koneksi) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch(SQLException se){
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public static Koneksi getKoneksi() {
        return conn;
    }
}
