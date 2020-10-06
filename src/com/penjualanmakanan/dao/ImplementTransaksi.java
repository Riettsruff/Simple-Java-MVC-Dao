/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.Transaksi;
import java.util.List;

/**
 *
 * @author Riett
 */
public interface ImplementTransaksi {
    public boolean insert(Transaksi transaksi);
    public boolean delete(String idTransaksi);
    public boolean update(Transaksi transaksi);
    public List<Transaksi> getAll();
    public long getTotalHargaById(String idTransaksi);
    public int getTotalBarangById(String idTransaksi);
}
