/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.Barang;
import static com.penjualanmakanan.util.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boona
 */
public class BarangDao implements ImplementBarang {
    Connection conn;

    public BarangDao() {
        conn = Koneksi();
    }
 
    @Override
    public boolean insert(Barang barang) {
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

    @Override
    public boolean delete(String idBarang) {
        try {
            String query = "DELETE FROM barang WHERE id=?";
            
            PreparedStatement ps = conn.prepareStatement(query);       
            ps.setString(1, idBarang);
            
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
    public boolean update(Barang barang) {
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

    @Override
    public List<Barang> getAll() {
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

    @Override
    public String getMaxId() {
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

    @Override
    public int getStokById(String idBarang) {
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
}
