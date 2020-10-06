/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.view;

import com.penjualanmakanan.controller.BarangController;
import com.penjualanmakanan.controller.DetailTransaksiController;
import java.util.ArrayList;
import java.util.List;
import com.penjualanmakanan.controller.TransaksiController;
import com.penjualanmakanan.model.Barang;
import com.penjualanmakanan.model.DetailTransaksi;
import com.penjualanmakanan.model.KeranjangBelanja;
import com.penjualanmakanan.model.Transaksi;
import com.penjualanmakanan.util.FormatRupiah;
import com.penjualanmakanan.util.FormatTanggal;
import com.penjualanmakanan.util.ValidasiTransaksi;
import java.lang.reflect.Array;
import java.util.Date;
import javax.swing.JOptionPane;

public class revisiTransaksiView extends javax.swing.JFrame {
    List<Transaksi> listTransaksi = new ArrayList<>();
    List<Barang> listBarang = new ArrayList<>();
    List<Barang> tempCustomBarang = new ArrayList<>();

    BarangController barangController = new BarangController();
    TransaksiController transaksiController = new TransaksiController();
    DetailTransaksiController detailTransaksiController = new DetailTransaksiController();
    ValidasiTransaksi validasiTransaksi = new ValidasiTransaksi();

    FormatRupiah formatRupiah = new FormatRupiah();
    
    public revisiTransaksiView() {
        initComponents();
        initData();
    }

    /**
     * Creates new form revisiTransaksiView
     */
    
    public void initFormValue() {
        if (Pilihan_Barang.getItemCount() == 0) {
            Pilihan_Barang.addItem("-Pilih Barang-");
            listBarang = barangController.getAllBarang();

            for (int i = 0; i < listBarang.size(); i++) {
                Pilihan_Barang.addItem(listBarang.get(i));
            }
        }

        Pilihan_Barang.setSelectedIndex(0);

        Id_Transaksi.setText("TRX" + new FormatTanggal(new Date(), "yyyyMMddHHmmssSS").toString());

//        Tanggal_Transaksi.setText(new FormatTanggal(new Date(), "dd-MM-yyyy").toString());
        Jumlah_Barang.setText("");

//        listBarangBelanjaan.clear();

        Daftar_Barang_Belanjaan.setText("");
    }

    
    public void tampilBarang(List<Barang> customBarang) {
        listBarang = new BarangController().getAllBarang();

        Object[][] obj = new Object[listBarang.size()][5];

        for (int i = 0; i < listBarang.size(); i++) {
            obj[i][0] = (i + 1) + ".";
            obj[i][1] = listBarang.get(i).getId();
            obj[i][2] = listBarang.get(i).getNama();
            obj[i][3] = listBarang.get(i).getStok();
            obj[i][4] = formatRupiah.kurensi(listBarang.get(i).getHarga());

            for (int j = 0; j < customBarang.size(); j++) {
                if (listBarang.get(i).getId().equals(customBarang.get(j).getId())) {
                    obj[i][2] = customBarang.get(j).getNama();
                    obj[i][3] = customBarang.get(j).getStok();
                    obj[i][4] = formatRupiah.kurensi(customBarang.get(j).getHarga());

                    break;
                }
            }
        }

        tabelBarang.setModel(
                new javax.swing.table.DefaultTableModel(
                        obj,
                        new String[]{
                            "No.", "ID Barang", "Nama Barang", "Stok Barang", "Harga Barang"
                        }
                ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        }
        );
    }
    
    public void submitTransaksi(String actionType) {
        Object[][] targetValidasi = new Object[2][3];
        
        targetValidasi[0][0] = "barang";
        targetValidasi[0][1] = "Barang";
        targetValidasi[0][2] = 
            Pilihan_Barang.getSelectedItem().toString().equals("-Pilih Barang-")
                ? null
                : Pilihan_Barang;
        
        targetValidasi[1][0] = "jumlah";
        targetValidasi[1][1] = "Jumlah Barang";
        targetValidasi[1][2] = Jumlah_Barang.getText();
        
        if(validasiTransaksi.isValid(targetValidasi, actionType)) {
            List<KeranjangBelanja> keranjangBelanja = validasiTransaksi.getKeranjangBelanja();
            
            switch(actionType) {
                case "ADD_ITEM_KERANJANG_BELANJA":
                    Barang barangPilihan = validasiTransaksi.getBarangValue();
                    int stokBarangTersedia = validasiTransaksi.getStokBarangTersedia();
                    int jumlahBarangBeli = validasiTransaksi.getJumlahBarangBeli();
                    
                    String daftarBarangBelanjaanText = "";
                    
                    for(int i = 0; i < keranjangBelanja.size(); i++) {
                        daftarBarangBelanjaanText += keranjangBelanja.get(i).toString();
                        
                        if(i < keranjangBelanja.size() - 1) {
                            daftarBarangBelanjaanText += ", ";
                        }
                    }
                    
                    Daftar_Barang_Belanjaan.setText(daftarBarangBelanjaanText);
                    
                    Barang customBarang = new Barang();
                    int indexOfCustomBarang = -1;
                    
                    customBarang = barangPilihan;
                    customBarang.setStok(stokBarangTersedia - jumlahBarangBeli);
                    
                    for(int i = 0; i < tempCustomBarang.size(); i++) {
                        if(tempCustomBarang.get(i).getId().equals(customBarang.getId())) {
                            indexOfCustomBarang = i;
                            tempCustomBarang.get(i).setStok(customBarang.getStok());
                            
                            break;
                        }
                    }
                    
                    if(indexOfCustomBarang == -1) tempCustomBarang.add(customBarang);
                    
                    tampilBarang(tempCustomBarang);
                break;
                case "CHECKOUT_TRANSAKSI":
                    Transaksi transaksi = new Transaksi();
                    transaksi.setId(Id_Transaksi.getText());
                    transaksi.setTglTransaksi(new FormatTanggal(new Date(), "yyyy-MM-dd").toString());
                    
                    boolean insertTransaksi = transaksiController.insertTransaksi(transaksi);
                    
                    if(insertTransaksi) {
                        for (int i = 0; i < keranjangBelanja.size(); i++) {
                            DetailTransaksi detailTransaksi = new DetailTransaksi();
                            detailTransaksi.setJmlBarang(keranjangBelanja.get(i).getJumlahBarang());
                            detailTransaksi.setIdBarang(keranjangBelanja.get(i).getIdBarang());
                            detailTransaksi.setIdTransaksi(transaksi.getId());

                            boolean insertDetailTransaksi = detailTransaksiController.insertDetailTransaksi(detailTransaksi);

                            if (!insertDetailTransaksi) {
                                JOptionPane.showMessageDialog(this, "Transaksi gagal", "Oops", JOptionPane.ERROR_MESSAGE);
                                transaksiController.deleteTransaksiByIdTransaksi(transaksi.getId());
                                
                                return;
                            }
                        }

                        JOptionPane.showMessageDialog(this, "Transaksi berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        
                        initData();
                        tempCustomBarang.clear();
                    } else {
                        JOptionPane.showMessageDialog(this, "Transaksi gagal", "Oops", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }
    }
    
    public void initData() {
        initFormValue();
        tampilBarang(tempCustomBarang);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Checkout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        Pilihan_Barang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Jumlah_Barang = new javax.swing.JTextField();
        Button_Tambah = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        Button_Simpan = new javax.swing.JButton();
        Button_Back4 = new javax.swing.JButton();
        Id_Transaksi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Daftar_Barang_Belanjaan = new javax.swing.JTextArea();

        Button_Checkout.setText("Checkout");
        Button_Checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CheckoutActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi");

        jInternalFrame5.setVisible(true);

        jLabel9.setText("Nama");

        jLabel10.setText("Jumlah");

        Button_Tambah.setText("Add");
        Button_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TambahActionPerformed(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Id", "Nama", "Stok", "Harga"
            }
        ));
        jScrollPane5.setViewportView(tabelBarang);

        Button_Simpan.setText("Checkout");
        Button_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Button_Back4.setText("Back");
        Button_Back4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        Id_Transaksi.setEditable(false);
        Id_Transaksi.setBackground(new java.awt.Color(230, 230, 230));
        Id_Transaksi.setEnabled(false);

        jLabel11.setText("Id");

        Daftar_Barang_Belanjaan.setColumns(20);
        Daftar_Barang_Belanjaan.setRows(5);
        jScrollPane1.setViewportView(Daftar_Barang_Belanjaan);

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(Pilihan_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jumlah_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Button_Tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Back4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Id_Transaksi)))
                .addGap(26, 26, 26)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Id_Transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Pilihan_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Jumlah_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(Button_Tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_Simpan))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_Back4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Pilihan_Barang.getAccessibleContext().setAccessibleDescription("");
        Pilihan_Barang.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CheckoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_CheckoutActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        revisiBerandaView berandaView = new revisiBerandaView();
        berandaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        submitTransaksi("CHECKOUT_TRANSAKSI");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Button_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TambahActionPerformed
        submitTransaksi("ADD_ITEM_KERANJANG_BELANJA");
    }//GEN-LAST:event_Button_TambahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(revisiTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(revisiTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(revisiTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(revisiTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new revisiTransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back4;
    private javax.swing.JButton Button_Checkout;
    private javax.swing.JButton Button_Simpan;
    private javax.swing.JButton Button_Tambah;
    private javax.swing.JTextArea Daftar_Barang_Belanjaan;
    private javax.swing.JTextField Id_Transaksi;
    private javax.swing.JTextField Jumlah_Barang;
    private javax.swing.JComboBox<Object> Pilihan_Barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
