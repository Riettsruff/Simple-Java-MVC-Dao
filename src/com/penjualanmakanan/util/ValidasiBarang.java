/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

import com.penjualanmakanan.controller.BarangController;
import com.penjualanmakanan.model.Barang;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riett
 */
public class ValidasiBarang extends ValidasiForm {
    private final List<Barang> listBarang = new BarangController().getAllBarang();
    
    private Object[][] target;
    private String actionType;
    
    private String namaLabel;
    private String namaValue;
    
    private String stokLabel;
    private String stokValue;
    
    private String hargaLabel;
    private String hargaValue;
    
    public ValidasiBarang(Object[][] target, String actionType) {
        this.target = target;
        this.actionType = actionType;
    }
    
    private boolean isNamaValid() {
        return 
            isRequiredValid(namaLabel, namaValue)
                ? actionType == "INSERT_BARANG" 
                    ? !isNamaAlreadySet() 
                    : true
                : false;
    }
    
    private boolean isNamaAlreadySet() {
        boolean isSet = false;
        
        for (int i = 0; i < listBarang.size(); i++) {
            if (namaValue.equalsIgnoreCase(listBarang.get(i).toString())) {
                isSet = true;
            }
        }
        
        return isSet;
    }
    
    private boolean isStokValid() {
        return 
            isRequiredValid(stokLabel, stokValue)
                ? isNumberValid(stokLabel, stokValue)
                : false;
    }
    
    private boolean isHargaValid() {
        return
            isRequiredValid(hargaLabel, hargaValue)
                ? isNumberValid(hargaLabel, hargaValue)
                : false;
    }
    
    public boolean isValid() {
        for(int i = 0; i < Array.getLength(target); i++) {
            switch((String) target[i][0]) {
                case "nama":
                    this.namaLabel = (String) target[i][1];
                    this.namaValue = (String) target[i][2];

                    if(isNamaValid()) {
                        continue;
                    } else {
                        showMessageDialog();
                        return false;
                    }
                case "stok":
                    this.stokLabel = (String) target[i][1];
                    this.stokValue = (String) target[i][2];

                    if(isStokValid()) {
                       continue;
                    } else {
                        showMessageDialog();
                        return false;
                    }
                case "harga":
                    this.hargaLabel = (String) this.target[i][1];
                    this.hargaValue = (String) this.target[i][2];

                    if(isHargaValid()) {
                        continue;
                    } else {
                        showMessageDialog();
                        return false;
                    }
            }
        }
        
        return true;
    }
}
