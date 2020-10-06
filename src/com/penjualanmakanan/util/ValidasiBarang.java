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
            isRequiredValid(this.namaLabel, this.namaValue)
                ? actionType == "insert" 
                    ? !isNamaAlreadySet() 
                    : true
                : false;
    }
    
    private boolean isNamaAlreadySet() {
        boolean isSet = false;
        
        for (int i = 0; i < listBarang.size(); i++) {
            if (this.namaValue.equalsIgnoreCase(listBarang.get(i).toString())) {
                isSet = true;
            }
        }
        
        return isSet;
    }
    
    private boolean isStokValid() {
        return 
            isRequiredValid(this.stokLabel, this.stokValue)
                ? isNumberValid(this.stokLabel, this.stokValue)
                : false;
    }
    
    private boolean isHargaValid() {
        return
            isRequiredValid(this.hargaLabel, this.hargaValue)
                ? isNumberValid(this.hargaLabel, this.hargaValue)
                : false;
    }
    
    public boolean isValid() {
        for(int i = 0; i < Array.getLength(this.target); i++) {
            if(this.target[i][0] == "nama") {
                this.namaLabel = (String) this.target[i][1];
                this.namaValue = (String) this.target[i][2];
                
                if(isNamaValid()) {
                    continue;
                } else {
                    showMessageDialog();
                    return false;
                }
            }
            
            if(this.target[i][0] == "stok") {
                this.stokLabel = (String) this.target[i][1];
                this.stokValue = (String) this.target[i][2];
                
                if(isStokValid()) {
                   continue;
                } else {
                    showMessageDialog();
                    return false;
                }
            }
            
            if(this.target[i][0] == "harga") {
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
