/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.DetailTransaksi;
import static com.penjualanmakanan.util.Koneksi.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riett
 */
public class DetailTransaksiDao implements ImplementDetailTransaksi {
    
    /**
     * Ini adalah function untuk getAll detail transaksi
     * Saat hasil query sudah masuk ke ResultSet maka akan di masukkan ke model
     * DetailTransaksi yang kemudian ditambahkan ke array list
     * @return array list yang sudah berisi detailtransaksi
     */
    @Override
    public List<DetailTransaksi> getAll() {
       List<DetailTransaksi> listDetailTransaksi = new ArrayList<>();

       try {
           String query = "\"SELECT id, jml_barang, id_barang, id_transaksi FROM `detail_transaksi` \"";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
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
   
    
    /**
     * Ini function untuk insert detail transaksi
     * Value didapat dari get pada class model detailtransaksi
     * @param detailTransaksi Ini objek detailTransaksi
     * @return boolean
     */
   @Override
   public boolean insert(DetailTransaksi detailTransaksi) {
       try {
           String query = "INSERT INTO detail_transaksi (id, jml_barang, id_barang, id_transaksi) VALUES (?, ?, ?, ?)";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
           ps.setInt(1, Types.NULL);
           ps.setInt(2, detailTransaksi.getJmlBarang());
           ps.setString(3, detailTransaksi.getIdBarang());
           ps.setString(4, detailTransaksi.getIdTransaksi());
            
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
