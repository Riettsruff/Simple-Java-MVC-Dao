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
import java.util.Date;
public class Transaksi {
    private int Id;
    private Date Tgl_Transaksi;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getTgl_Transaksi() {
        return Tgl_Transaksi;
    }

    public void setTgl_Transaksi(Date Tgl_Transaksi) {
        this.Tgl_Transaksi = Tgl_Transaksi;
    }
    
}
