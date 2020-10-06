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
public class Barang {
    private String id;
    private String nama;
    private int stok;
    private int harga;

    
    /**
     * Ini method untuk mendapatkan id Barang
     * @return id bertipe String 
     */
    public String getId() {
        return id;
    }

    /**
     * Ini method untuk set id barang
     * @param id Ini parameter id barang 
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Ini method untuk mendapatkan nama barang
     * @return nama bertipe String 
     */
    public String getNama() {
        return nama;
    }
    
    /**
     * Ini method untuk mengatur nama barang
     * @param nama Ini parameter nama barang 
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Ini method untuk mendapatkan stok barang
     * @return stok bertipe int 
     */
    
    public int getStok() {
        return stok;
    }

    /**
     * Ini method untuk mengatur stok barang
     * @param stok Ini parameter stok barang
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * Ini method untuk mendapatkan harga barang
     * @return harga bertipe int
     */
    public int getHarga() {
        return harga;
    }

    /**
     * Ini method untuk mengatur harga barang
     * @param harga Ini parameter harga barang 
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    /**
     * Ini merupakan method untuk mengubah atribut barang 
     * menjadi string saat tabel di klik agar ditampilkan di input text
     * @return nama bertipe String 
     */
    @Override
    public String toString() {
        return nama;
    }
}
