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
                detailtransaksi.setjml_Barang(rs.getInt("jml_barang"));
                detailtransaksi.setidBarang(rs.getString("id_barang"));
                detailtransaksi.setidTransaksi(rs.getString("id_transaksi"));
                                               
                listDetailTransaksi.add(detailtransaksi);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listDetailTransaksi;
    }
}
