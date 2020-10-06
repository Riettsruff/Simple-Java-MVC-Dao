/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.controller;

import com.penjualanmakanan.dao.ImplementTransaksi;
import com.penjualanmakanan.dao.TransaksiDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.penjualanmakanan.model.Transaksi;
import static com.penjualanmakanan.util.Koneksi.Koneksi;
/**
 *
 * @author Riett
 */
public class TransaksiController {
    private ImplementTransaksi implementTransaksi;
    
    public TransaksiController() {
        implementTransaksi = new TransaksiDao();
    }
    
    public List<Transaksi> getAllTransaksi() {
        return implementTransaksi.getAll();
    }
    
    public long getTotalHargaByIdTransaksi(String idTransaksi) {
       return implementTransaksi.getTotalHargaById(idTransaksi);
   }
   
   public int getTotalBarangByIdTransaksi(String idTransaksi) {
       return implementTransaksi.getTotalBarangById(idTransaksi);
   }
    
    public boolean insertTransaksi(Transaksi transaksi) {
        return implementTransaksi.insert(transaksi);
    }
    
    public boolean updateTransaksi(Transaksi transaksi) {
        return implementTransaksi.update(transaksi);
    }
    
    public boolean deleteTransaksiByIdTransaksi(String idTransaksi) {
        return implementTransaksi.delete(idTransaksi);
    }
}
