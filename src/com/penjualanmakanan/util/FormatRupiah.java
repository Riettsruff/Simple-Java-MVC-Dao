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
    public void Kurensi(long uang) {
        NumberFormat kurensiIndonesia = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        System.out.printf("Total: %s %n", kurensiIndonesia.format(uang));
    }
}
