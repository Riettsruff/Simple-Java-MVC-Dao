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
    
    public List<Barang> getAllBarang() {
        return implementBarang.getAll();
    }
    
    public String getMaxIdBarang() {
        return implementBarang.getMaxId();
    }
    
    public int getStokByIdBarang(String idBarang) {
        return implementBarang.getStokById(idBarang);
    }
    
    public boolean insertBarang(Barang barang){
        return implementBarang.insert(barang);
    }
    
    public boolean updateBarang(Barang barang){
        return implementBarang.update(barang);
    }
    
    public boolean deleteBarang(String idBarang){
        return implementBarang.delete(idBarang);
    }
}
