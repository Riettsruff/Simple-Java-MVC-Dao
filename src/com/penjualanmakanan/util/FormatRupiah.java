/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

/**
 *
 * @author User
 */
import java.text.NumberFormat;
import java.util.Locale;

public class FormatRupiah {
    /**
    * Untuk memformat uang dalam long menjadi kurensi rupiah.
    * @param uang adalah value yang akan diformat 
    * @return kurensiIndonesia.format(uang) yang merupakan fungsi dari library NumberFormat
    */
    public String kurensi(long uang) {
        NumberFormat kurensiIndonesia = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        return kurensiIndonesia.format(uang);
    }
}
