/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.Barang;
import java.util.List;

/**
 *
 * @author Boona
 */
public interface ImplBarangDao {

    /**
     *
     * @param barang
     */
    public void insertBarang(Barang barang);
    public void deleteBarang(int id);
    public void updateBarang(Barang barang);
    public List<Barang> getAllBarang();
    public String getMaxIdBarang();
    public int getStokByIdBarang(String idBarang);
}
