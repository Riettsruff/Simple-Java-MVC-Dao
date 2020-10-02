/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.penjualanmakanan.util.Koneksi;
import com.penjualanmakanan.model.Barang;
/**
 *
 * @author Riett
 */
public class BarangController {
    Connection conn;
    
    public BarangController() {
        conn = (Connection) new Koneksi().getKoneksi();
    }
    
    public List<Barang> getAllBarang() {
        List<Barang> listBarang = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id, nama, stok, harga FROM `barang`");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Barang barang = new Barang();
                
                barang.setId(rs.getString("id"));
                barang.setNama(rs.getString("nama"));
                barang.setStok(rs.getInt("stok"));
                barang.setHarga(rs.getInt("harga"));
                
                listBarang.add(barang);
            }
            
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listBarang;
        
    }
    
    public boolean insertBarang(Barang barang) {
       try {
           PreparedStatement ps = conn.prepareStatement("INSERT INTO barang (id, nama, stok, harga) VALUES (?, ?, ?, ?)");
           ps.setString(1, barang.getId());
           ps.setString(2, barang.getNama());
           ps.setInt(3, barang.getStok());
           ps.setInt(4, barang.getHarga());
           
           if (ps.executeUpdate() > 0){
               return true;
           }
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return false;
   }
 
}
