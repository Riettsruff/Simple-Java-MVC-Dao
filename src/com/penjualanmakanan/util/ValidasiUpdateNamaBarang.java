package com.penjualanmakanan.util;

import com.penjualanmakanan.controller.BarangController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.penjualanmakanan.util.Koneksi;
import com.penjualanmakanan.model.Barang;
import static com.penjualanmakanan.util.Koneksi.Koneksi;

public class ValidasiUpdateNamaBarang {

    List<Barang> listBarang = new ArrayList<>();

    public boolean cekNamaBarang(String namaBarang) {
//        listBarang = new BarangController().getAllBarang();
        boolean cek;
        cek = false;
        for (int i = 0; i < listBarang.size(); i++) {
            if (namaBarang.equalsIgnoreCase(listBarang.get(i).toString())) {
                cek = true;
            }
        }

        return cek;
    }

}
