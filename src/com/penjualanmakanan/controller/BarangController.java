/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.controller;

import com.penjualanmakanan.dao.BarangDao;
import com.penjualanmakanan.dao.ImplBarangDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.penjualanmakanan.model.Barang;
import com.penjualanmakanan.model.TabelBarangModel;
import static com.penjualanmakanan.util.Koneksi.Koneksi;
import com.penjualanmakanan.view.revisiBarangView;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Riett
 */
public class BarangController{
    private final revisiBarangView barangView;
    private List<Barang> list;
    private final ImplBarangDao implBarang;

//    Connection conn;

    public BarangController(revisiBarangView barangView) {
//        conn = Koneksi();
        this.barangView = barangView;
        implBarang = new BarangDao();
        list = implBarang.getAllBarang();
    }
    
    public void isiTabel(){
        list = implBarang.getAllBarang();
        barangView.getTabelBarang().setModel(new TabelBarangModel(list));
    }
    
    public void insertBarang(){
        Barang barang = new Barang();
        BarangDao bd = new BarangDao();
        int maxIdBarang = Integer.parseInt(bd.getMaxIdBarang());
        barangView.getInputId().setText("BRG" + String.format("%03d", ++maxIdBarang));
        barang.setNama(barangView.getInputNama().getText());
        barang.setStok(Integer.parseInt(barangView.getInputStok().getText()));
        barang.setHarga(Integer.parseInt(barangView.getInputHarga().getText()));
        
        implBarang.insertBarang(barang);
    }
    
    public void updateBarang(){
        Barang barang = new Barang();
        barang.setNama(barangView.getInputNama().getText());
        barang.setStok(Integer.parseInt(barangView.getInputStok().getText()));
        barang.setHarga(Integer.parseInt(barangView.getInputHarga().getText()));
    }
    
    public void deleteBarang(){
        int row = Integer.parseInt(barangView.getInputId().getText());
        
        implBarang.deleteBarang(row);
    }
    
    public void refreshBarang(){
        BarangDao bd = new BarangDao();
        int maxIdBarang = Integer.parseInt(bd.getMaxIdBarang());
        barangView.getInputId().setText("BRG" + String.format("%03d", ++maxIdBarang));
        barangView.getInputNama().setText("");
        barangView.getInputStok().setText("");
        barangView.getInputHarga().setText("");
        barangView.getTabelBarang().clearSelection();
    }
    
    
    
    
    


//
//    /**
//     *
//     * @param barang
//     * @return
//     */
//    @Override
//    public boolean deleteBarang(Barang barang) {
//        try {
//            String query = "DELETE From barang WHERE id=?";
//            
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, barang.getId());
//
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return false;
//    }
//
//    
//
//    /**
//     *
//     * @param idBarang
//     * @return
//     */
//    @Override
//    public int getStokByIdBarang(String idBarang) {
//        int stok = 0;
//
//        try {
//            String query = "SELECT stok FROM barang WHERE id = ?";
//
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, idBarang);
//                    
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                stok = rs.getInt(1);
//            }
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return stok;
//    }
//    
//    /**
//     *
//     * @return
//     */
//    @Override
//    public String getMaxIdBarang() {
//        String maxIdBarang = "001";
//
//        try {
//            String query = "SELECT RIGHT((SElECT MAX(id) AS max_id FROM barang), 3) AS \"max_id\"";
//
//            PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                if (rs.getString("max_id") != null) {
//                    maxIdBarang = rs.getString("max_id");
//                }
//            }
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return maxIdBarang;
//    }
//
//    /**
//     *
//     * @param barang
//     * @return
//     */
//    @Override
//    public boolean updateBarang(Barang barang) {
//        
//    }
}
