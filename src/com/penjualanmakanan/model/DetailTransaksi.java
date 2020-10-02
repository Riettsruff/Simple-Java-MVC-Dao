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
    private String Id;
    private int Jml_Barang;
    private int Id_Transaksi;
    private String Id_Barang;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getJml_Barang() {
        return Jml_Barang;
    }

    public void setJml_Barang(int Jml_Barang) {
        this.Jml_Barang = Jml_Barang;
    }

    public int getId_Transaksi() {
        return Id_Transaksi;
    }

    public void setId_Transaksi(int Id_Transaksi) {
        this.Id_Transaksi = Id_Transaksi;
    }

    public String getId_Barang() {
        return Id_Barang;
    }

    public void setId_Barang(String Id_Barang) {
        this.Id_Barang = Id_Barang;
    }
    
}
