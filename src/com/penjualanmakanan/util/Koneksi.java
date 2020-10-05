/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Koneksi {
    
    private static final String DB_URL = "jdbc:mysql://localhost/penjualan_makanan";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
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