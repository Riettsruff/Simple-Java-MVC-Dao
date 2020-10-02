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
import com.penjualanmakanan.model.DetailTransaksi;
/**
 *
 * @author Riett
 */
public class DetailTransaksiController {
    Connection conn;
    
    public DetailTransaksiController() {
        conn = (Connection) new Koneksi().getKoneksi();
    }
    
    public List<DetailTransaksi> getAllDetailTransaksi() {
       List<DetailTransaksi> listDetailTransaksi = new ArrayList<>();

       try {
           PreparedStatement ps = conn.prepareStatement("SELECT id, jml_barang, id_barang, id_transaksi FROM `detail_transaksi` ");
           ResultSet rs = ps.executeQuery();

           while(rs.next()) {
               DetailTransaksi detailtransaksi = new DetailTransaksi();

               detailtransaksi.setId(rs.getInt("id"));
               detailtransaksi.setJmlBarang(rs.getInt("jml_barang"));
               detailtransaksi.setIdBarang(rs.getString("id_barang"));
               detailtransaksi.setIdTransaksi(rs.getString("id_transaksi"));

               listDetailTransaksi.add(detailtransaksi);
           }
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }

       return listDetailTransaksi;
   }
    
   public long getTotalHargaByIdTransaksi(String idTransaksi) {
       long totalHarga = 0;
       
       try {
           String query = "SELECT SUM(b.jml_barang * c.harga) AS \"Total Harga\" FROM transaksi a INNER JOIN detail_transaksi b ON a.id = b.id_transaksi LEFT JOIN barang c ON b.id_barang = c.id";
           query += " WHERE a.id = \"" + idTransaksi + "\"";
           
           PreparedStatement ps = conn.prepareStatement(query);
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
   
   public int getTotalBarangByIdTransaksi(String idTransaksi) {
       int totalBarang = 0;
       
       try {
           String query = "SELECT SUM(b.jml_barang) AS \"total_barang\" FROM transaksi a INNER JOIN detail_transaksi b ON a.id = b.id_transaksi";
           query += " WHERE a.id = \"" + idTransaksi + "\"";
           
           PreparedStatement ps = conn.prepareStatement(query);
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
}
