/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Riett
 */
public class FormatTanggal {
    public String getValue(Date tanggal, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(tanggal);
    }
}
