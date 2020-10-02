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
import com.penjualanmakanan.model.Transaksi;
/**
 *
 * @author Riett
 */
public class TransaksiController {
    Connection conn;
    
    public TransaksiController() {
        conn = (Connection) new Koneksi().getKoneksi();
    }
    
    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> listTransaksi = new ArrayList<>();
        
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id, date_format(tgl_transaksi, '%d-%m-%Y') AS tgl_transaksi FROM transaksi");
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
    
    public String getMaxIdTransaksi() {
        String maxIdTransaksi = "001";
        
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT RIGHT((SElECT MAX(id) AS max_id FROM transaksi), 3) AS \"max_id\"");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                if(rs.getString("max_id")!=null) {
                    maxIdTransaksi = rs.getString("max_id");
                }
            }  
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return maxIdTransaksi;
    }
    
    public boolean insertTransaksi(Transaksi transaksi) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO transaksi (id, tgl_transaksi) VALUES (?, ?)");
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
}
