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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getjml_Barang() {
        return jmlBarang;
    }

    public void setjml_Barang(int jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

    public String getidTransaksi() {
        return idTransaksi;
    }

    public void setidTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getidBarang() {
        return idBarang;
    }

    public void setidBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
}
