/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.controller;

import com.penjualanmakanan.dao.BarangDao;
import com.penjualanmakanan.dao.ImplementBarang;
import java.util.List;
import com.penjualanmakanan.model.Barang;

/**
 *
 * @author Riett
 */
public class BarangController {
    private ImplementBarang implementBarang;

    public BarangController() {
        implementBarang = new BarangDao();
    }
    
    /**
     * Function untuk mendapatkan semua barang yang ada pada database. Logika ada di class Dao
     * @return implemenBarang.getAll() yang merupakan method pada class dao barang
     */
    public List<Barang> getAllBarang() {
        return implementBarang.getAll();
    }
    
    /**
     * Function untuk mendapatkan id barang yang terakhir kali ditambahkan
     * @return implementBarang.getMaxId() yang merupakan method pada class dao barang
     */
    public String getMaxIdBarang() {
        return implementBarang.getMaxId();
    }
    
    /**
     * Function untuk memperoleh stok berdasarkan id barang
     * @param idBarang ini merupakan parameter idBarang yang akan dilihat stoknya
     * @return implementBarang.getStokById(idBarang) yang merupakan method pada class dao barang
     */
    
    public int getStokByIdBarang(String idBarang) {
        return implementBarang.getStokById(idBarang);
    }
    
    /**
     * Function untuk insert atau menambahkan barang
     * @param barang Ini parameter objek barang
     * @return implementBarang.insert(barang) yang merupakan method pada class dao barang
     */
    public boolean insertBarang(Barang barang){
        return implementBarang.insert(barang);
    }
    
     /**
     * Function untuk update barang
     * @param barang Ini parameter objek barang
     * @return implementBarang.update(barang) yang merupakan method pada class dao barang
     */
    
    public boolean updateBarang(Barang barang){
        return implementBarang.update(barang);
    }
    
     /**
     * Function untuk delete atau menghapus barang
     * @param idBarang Ini parameter idBarang yang akan dihapus
     * @return implementBarang.delete(idVarang) yang merupakan method pada class dao barang
     */
    public boolean deleteBarang(String idBarang){
        return implementBarang.delete(idBarang);
    }
}
