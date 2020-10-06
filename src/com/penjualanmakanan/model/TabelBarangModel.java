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
    
    /**
     * Ini merupakan method untuk melihat jumlah barang yang ada di database
     * @return list.size() ukuran array list barang 
     */
    @Override
    public int getRowCount() {
        return list.size();
    }

    /**
     * Ini merupakan method untuk melihat jumlah kolom 
     * @return 4 karena tabel hanya terdiri dari 4 kolom
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     * Ini merupakan method untuk memunculkan isi tabel pada baris dan kolom tertentu
     * @param rowIndex Ini parameter baris di tabel
     * @param columnIndex Ini parameter kolom di tabel
     * @return anggota array list pada baris dan kolom tertentu
     */
    
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
    
    /**
     * Ini method untuk mengembalikan berupa string kolom apa yang dipilih
     * @param column Ini parameter kolom yang terdiri dari Id, nama, stok, dan harga
     * @return kolom yang dipilih berupa String
     */
    
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
