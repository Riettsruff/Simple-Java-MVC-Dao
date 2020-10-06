/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.DetailTransaksi;
import java.util.List;

/**
 *
 * @author Riett
 */
public interface ImplementDetailTransaksi {
    public boolean insert(DetailTransaksi detailTransaksi);
    public List<DetailTransaksi> getAll();
}
