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
public interface PenjualanDao {
    public boolean insertBarang(Barang barang);
    public boolean deleteBarang(Barang barang);
    public boolean updateBarang(Barang barang);
    public List<Barang> getAllBarang();
    public String getMaxIdBarang();
    public int getStokByIdBarang(String idBarang);
}
