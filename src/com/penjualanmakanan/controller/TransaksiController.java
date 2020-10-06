/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.controller;

import com.penjualanmakanan.dao.ImplementTransaksi;
import com.penjualanmakanan.dao.TransaksiDao;
import java.util.List;
import com.penjualanmakanan.model.Transaksi;

/**
 *
 * @author Riett
 */
public class TransaksiController {
    private ImplementTransaksi implementTransaksi;
    
    public TransaksiController() {
        implementTransaksi = new TransaksiDao();
    }
    
    /**
     * Ini merupakan method untuk return method getAll pada class dao
     * @return method pada class dao Transaksi
     */
    public List<Transaksi> getAllTransaksi() {
        return implementTransaksi.getAll();
    }
    
    /**
     * Ini merupakan method untuk return method getTotalHargaById pada class dao
     * @param idTransaksi Ini parameter idTransaksi untuk mencari totalharga
     * @return method pada class dao Transaksi
     */
    public long getTotalHargaByIdTransaksi(String idTransaksi) {
       return implementTransaksi.getTotalHargaById(idTransaksi);
   }
   
    /**
     * Ini merupakan method untuk return method getTotalBarangById pada class dao
     * @param idTransaksi Ini parameter idTransaksi untuk mencari totalbarang
     * @return method pada class dao Transaksi
     */
   public int getTotalBarangByIdTransaksi(String idTransaksi) {
       return implementTransaksi.getTotalBarangById(idTransaksi);
   }
    
   /**
     * Ini merupakan method untuk return method insert pada class dao
     * @param transaksi Ini parameter objek transaksi
     * @return method pada class dao Transaksi
     */
    public boolean insertTransaksi(Transaksi transaksi) {
        return implementTransaksi.insert(transaksi);
    }
    
    /**
     * Ini merupakan method untuk return method update pada class dao
     * @param transaksi Ini parameter objek transaksi
     * @return method pada class dao Transaksi
     */
    public boolean updateTransaksi(Transaksi transaksi) {
        return implementTransaksi.update(transaksi);
    }
    
    /**
     * Ini merupakan method untuk return method delete pada class dao
     * @param idTransaksi Ini parameter idTransaksi untuk menghapus berdasar idTransaksi
     * @return method pada class dao Transaksi
     */
    public boolean deleteTransaksiByIdTransaksi(String idTransaksi) {
        return implementTransaksi.delete(idTransaksi);
    }
}
