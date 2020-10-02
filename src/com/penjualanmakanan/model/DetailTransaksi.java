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

    public int getJmlBarang() {
        return jmlBarang;
    }

    public void setJmlBarang(int jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    
}
