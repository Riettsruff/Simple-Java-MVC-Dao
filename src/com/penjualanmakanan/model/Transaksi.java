/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.model;

/**
 *
 * @author Riett
 */

public class Transaksi {
    private String id;
    private String tglTransaksi;
    
    /**
     * Ini merupakan method untuk mendapatkan id  
     * @return id bertipe String 
     */
    public String getId() {
        return id;
    }

    /**
     * @param id Untuk mengatur idTransaksi
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Ini merupakan method untuk memperoleh tglTransaksi 
     * @return tglTransaksi bertipe String 
     */
    public String getTglTransaksi() {
        return tglTransaksi;
    }

    /**
     * @param tglTransaksi Untuk mengatur tglTransaksi 
     */
    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }
    
}
