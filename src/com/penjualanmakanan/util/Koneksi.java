/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Koneksi {
<<<<<<< HEAD
    // JDBC driver name and database URL
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private final String DB_URL = "jdbc:mysql://localhost:3306/penjualan_makanan";

    //  Database credentials
    private final String USER = "root";
    private final String PASS = "";
=======
    private static final String DB_URL = "jdbc:mysql://localhost/penjualan_makanan";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
>>>>>>> 3bca736ede88feab31e63b7be10ba06bf74351ad
    
    private static Connection conn;
    
    public static Connection Koneksi() {
        if(conn == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();

                dataSource.setUser(DB_USER);
                dataSource.setPassword(DB_PASS);
                dataSource.setUrl(DB_URL);
                
                conn = dataSource.getConnection();
            } catch(SQLException se){
                // Handle errors for JDBC
                se.printStackTrace();
            } catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }
        }
        
        return conn;
    }
}
