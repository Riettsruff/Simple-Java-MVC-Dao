/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.Transaksi;
import static com.penjualanmakanan.util.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riett
 */
public class TransaksiDao implements ImplementTransaksi {
    Connection conn;
    
    public TransaksiDao() {
        conn = Koneksi();
    }

    @Override
    public List<Transaksi> getAll() {
        List<Transaksi> listTransaksi = new ArrayList<>();
        
        try {
            String query = "SELECT id, date_format(tgl_transaksi, '%d-%m-%Y') AS tgl_transaksi FROM transaksi";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Transaksi transaksi = new Transaksi();
                
                transaksi.setId(rs.getString("id"));
                transaksi.setTglTransaksi(rs.getString("tgl_transaksi"));
                
                listTransaksi.add(transaksi);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listTransaksi;
    }
    
    @Override
    public long getTotalHargaById(String idTransaksi) {
       long totalHarga = 0;
       
       try {
           String query = "SELECT SUM(b.jml_barang * c.harga) AS \"Total Harga\" FROM transaksi a INNER JOIN detail_transaksi b ON a.id = b.id_transaksi LEFT JOIN barang c ON b.id_barang = c.id";
           query += " WHERE a.id = ?";
           
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1, idTransaksi);
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()) {
               totalHarga = rs.getInt(1);
           } 
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return totalHarga;
   }
   
    @Override
   public int getTotalBarangById(String idTransaksi) {
       int totalBarang = 0;
       
       try {
           String query = "SELECT SUM(b.jml_barang) AS \"total_barang\" FROM transaksi a INNER JOIN detail_transaksi b ON a.id = b.id_transaksi";
           query += " WHERE a.id = ?";
           
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1, idTransaksi);
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()) {
               totalBarang = rs.getInt(1);
           } 
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return totalBarang;
    }
    
    @Override
    public boolean insert(Transaksi transaksi) {
        try {
            String query = "INSERT INTO transaksi (id, tgl_transaksi) VALUES (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, transaksi.getId());
            ps.setString(2, transaksi.getTglTransaksi());
            
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
   
    @Override
    public boolean delete(String idTransaksi) {
        try {
            String query = "DELETE FROM transaksi WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idTransaksi);
                    
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public boolean update(Transaksi transaksi) {
        try {
            String query = "UPDATE transaksi SET tgl_transaksi=? WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, transaksi.getTglTransaksi());
            ps.setString(2, transaksi.getId());
                     
            if (ps.executeUpdate() > 0) {
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
