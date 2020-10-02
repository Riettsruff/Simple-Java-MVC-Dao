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
    
    public String getIdBarang() {
        return idBarang;
    }
    
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
    public String getNamaBarang() {
        return namaBarang;
    }
    
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    
    public int getJumlahBarang() {
        return jumlahBarang;
    }
    
    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    
    @Override
    public String toString() {
        return namaBarang + " (" + String.valueOf(jumlahBarang) + ")";
    }
}
