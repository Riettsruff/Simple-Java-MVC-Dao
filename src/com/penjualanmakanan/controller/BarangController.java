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
import static com.penjualanmakanan.util.Koneksi.Koneksi;

/**
 *
 * @author Riett
 */
public class BarangController {

    Connection conn;

    public BarangController() {
        conn = Koneksi();
    }

    public List<Barang> getAllBarang() {
        List<Barang> listBarang = new ArrayList<>();
        
        try {
            String query = "SELECT id, nama, stok, harga FROM `barang`";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

    public boolean deleteBarang(Barang barang) {
        try {
            String query = "DELETE From barang WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barang.getId());

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

    public boolean insertBarang(Barang barang) {
        try {
            String query = "INSERT INTO barang (id, nama, stok, harga) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barang.getId());
            ps.setString(2, barang.getNama());
            ps.setInt(3, barang.getStok());
            ps.setInt(4, barang.getHarga());

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

    public int getStokByIdBarang(String idBarang) {
        int stok = 0;

        try {
            String query = "SELECT stok FROM barang WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idBarang);
                    
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                stok = rs.getInt(1);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stok;
    }
    
    public String getMaxIdBarang() {
        String maxIdBarang = "001";

        try {
            String query = "SELECT RIGHT((SElECT MAX(id) AS max_id FROM barang), 3) AS \"max_id\"";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("max_id") != null) {
                    maxIdBarang = rs.getString("max_id");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return maxIdBarang;
    }

    public boolean updateBarang(Barang barang) {
        try {
            String query = "UPDATE barang SET nama = ?, stok = ?, harga = ? WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barang.getNama());
            ps.setInt(2, barang.getStok());
            ps.setInt(3, barang.getHarga());
            ps.setString(4, barang.getId());
            
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
