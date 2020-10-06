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
public class KeranjangBelanja {
    private String idBarang;
    private String namaBarang;
    private int jumlahBarang;
    
    /**
     * Ini method untuk mendapatkan idBarang yang akan dibeli
     * @return idBarang 
     */
    
    public String getIdBarang() {
        return idBarang;
    }
    
    /**
     * @param idBarang Untuk mengatur idBarang yang akan 
     */
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
    /**
     * Ini method untuk mendapatkan namaBarang yang akan dibeli
     * @return namaBarang bertipe String 
     */
    
    public String getNamaBarang() {
        return namaBarang;
    }
    
    /**
     * @param namaBarang Untuk mengatur namaBarang yang akan dibeli
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    
    /**
     * Ini method untuk mendapatkan jumlahBarang yang akan dibeli
     * @return jumlahBarang bertipe int 
     */
    public int getJumlahBarang() {
        return jumlahBarang;
    }
    
    /**
     * @param jumlahBarang Untuk mengatur jumlahBarang yang akan dibeli
     */
    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    
    
    /**
     * Ini method untuk menjadikan ke String saat elemen dari array list 
     * keranjang belanja di get
     * @return kembalian berupa String  
     */
    @Override
    public String toString() {
        return namaBarang + " (" + String.valueOf(jumlahBarang) + ")";
    }
}
