/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.util;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Riett
 */
public class ValidasiForm {
    private String dialogTitle = "";
    private String dialogMessage = "";
    private boolean isValid = false;
    
    protected void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }
    
    protected String getDialogTitle() {
        return dialogTitle;
    }
    
    protected void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }
    
    protected String getDialogMessage() {
        return dialogMessage;
    }
    
    protected void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    protected boolean getIsValid() {
        return isValid;
    }
    
    protected boolean isRequiredValid(String label, String value) {
        setIsValid(!value.equals(""));
        
        setDialogTitle(isValid ? "Sukses" : "Error");
        setDialogMessage(isValid ? "" : label + " wajib diisi.");
        
        return isValid;
    }
    
    protected boolean isNumberValid(String label, String value) {
        Pattern pattern = Pattern.compile("[0-9]+");
        
        setIsValid(pattern.matcher(value).matches());
        
        setDialogTitle(isValid ? "Sukses" : "Error");
        setDialogMessage(isValid ? "" : label + " wajib berupa angka.");
        
        return isValid;
    }
    
    protected void showMessageDialog() {
        JOptionPane.showMessageDialog(
            null,
            dialogMessage, 
            dialogTitle, 
            isValid ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
        );
    }
}
