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
public class DetailTransaksi {
    private int id;
    private int jmlBarang;
    private String idTransaksi;
    private String idBarang;

    /**
     * Ini method untuk mendapatkan id 
     * @return id bertipe int
     */
    
    public int getId() {
        return id;
    }

    /**
     * @param id Untuk mengatur id detailTransaksi 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Ini method untuk mendapatkan jumlahBarang
     * @return jmlBarang bertipe int
     */
    public int getJmlBarang() {
        return jmlBarang;
    }

    /**
     * @param jmlBarang Untuk mengatur jumlah Barang
     */
    public void setJmlBarang(int jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

    /**
     * Ini method untuk mendapatkan idTransaksi
     * @return idTransaksi bertipe String 
     */
    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    /**
     * @param idTransaksi Untuk mengatur idTransaksi
     */
    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    /**
     * Ini method untuk mendapatkan idBarang
     * @return idBarang bertipe String 
     */
    public String getIdBarang() {
        return idBarang;
    }

    /**
     * @param idBarang Untuk mengatur idBarang
     */
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
}
