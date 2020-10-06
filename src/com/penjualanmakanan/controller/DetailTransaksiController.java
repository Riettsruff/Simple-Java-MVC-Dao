/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.controller;
import com.penjualanmakanan.dao.DetailTransaksiDao;
import com.penjualanmakanan.dao.ImplementDetailTransaksi;
import java.util.List;
import com.penjualanmakanan.model.DetailTransaksi;

/**
 *
 * @author Riett
 */
public class DetailTransaksiController {
    private ImplementDetailTransaksi implementDetailTransaksi;
    
    public DetailTransaksiController() {
        implementDetailTransaksi = new DetailTransaksiDao();
    }
    
    public List<DetailTransaksi> getAllDetailTransaksi() {
       return implementDetailTransaksi.getAll();
   }
   
   public boolean insertDetailTransaksi(DetailTransaksi detailTransaksi) {
       return implementDetailTransaksi.insert(detailTransaksi);
   }
}
