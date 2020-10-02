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
    private String id;
    private int jmlBarang;
    private int idTransaksi;
    private String idBarang;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getjml_Barang() {
        return jmlBarang;
    }

    public void setjml_Barang(int jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

    public int getidTransaksi() {
        return idTransaksi;
    }

    public void setidTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getidBarang() {
        return idBarang;
    }

    public void setidBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
}
