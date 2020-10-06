/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Boona
 */
public class TabelBarangModel extends AbstractTableModel{

    List<Barang> list;

    public TabelBarangModel(List<Barang> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getStok();
            case 3 : return list.get(rowIndex).getHarga();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "STOK";
            case 3 : return "HARGA";
            default:return null;
        }
    }
}
