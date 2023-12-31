/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daftar_barang;

import login.appLogin;
import transaksi.menuTransaksi;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksiDatabase.koneksi;
import registrasi.menu_registrasi;


/**
 *
 * @author maeepp
 */
public class masukan_produk extends javax.swing.JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost/app_kasir";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static final String INSERT_QUERY = "INSERT INTO input_produk (kd_barang, nama_produk, harga_satuan, jumlah_stok) VALUES (?, ?, ?, ?)";
    private Object DatabaseHelper;

    public masukan_produk() {
        initComponents();
        refreshTable();
        

        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnInputActionPerformed(e);
            }
        });
        txtKdBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Panggil metode untuk menampilkan informasi produk
                displayProductInformation(txtKdBarang.getText());
            }
        });

    }
   private void displayProductInformation(String kdBarang) {
    try (com.mysql.jdbc.Connection connection = (com.mysql.jdbc.Connection) koneksi.getConnection()){
        String query = "SELECT id_produk, kd_barang, nama_produk, harga_satuan, jumlah_stok FROM input_produk WHERE kd_barang = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, kdBarang); 
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int idProduk = resultSet.getInt("id_produk");
                    String kodeBarang = resultSet.getString("kd_barang");
                    String namaProduk = resultSet.getString("nama_produk");
                    int hargaSatuan = resultSet.getInt("harga_satuan");
                    int jumlahStok = resultSet.getInt("jumlah_stok");

                    // Tampilkan informasi di JTextField sesuai kebutuhan
                    txtIdProduk.setText(String.valueOf(idProduk));
                    txtKdBarang.setText(kodeBarang);
                    txtNamaProduk.setText(namaProduk);
                    txtHargasatuan.setText(String.valueOf(hargaSatuan));
                    txtJumlahStok.setText(String.valueOf(jumlahStok));
                } else {
                    // Barang tidak ditemukan, atur JTextField menjadi kosong
                    txtIdProduk.setText("");
                    txtKdBarang.setText("");
                    txtNamaProduk.setText("");
                    txtHargasatuan.setText("");
                    txtJumlahStok.setText("");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle SQLException sesuai kebutuhan Anda
    }
}


    public void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Produk");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Satuan");
        model.addColumn("Jumlah Stok");
        try {
            // Establish a connection to the database
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // Execute a query to get data from the database
                String selectQuery = "SELECT * FROM input_produk";
                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            Object[] rowData = {
                                resultSet.getInt("id_produk"),
                                resultSet.getString("kd_barang"),
                                resultSet.getString("nama_produk"),
                                resultSet.getInt("harga_satuan"),
                                resultSet.getInt("jumlah_stok")
                            };
                            model.addRow(rowData);
                        }
                    }
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        tblProduk.setModel(model);
    }

    /**
     * Creates new form daftar_produk
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIdProduk = new javax.swing.JTextField();
        txtNamaProduk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHargasatuan = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnInput = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRegistrasi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtJumlahStok = new javax.swing.JTextField();
        txtKdBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT PRODUK");

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(16, 16, 16))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1626, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnLogout)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 18)); // NOI18N
        jLabel2.setText("ID Produk");

        txtIdProduk.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdProduk.setEnabled(false);
        txtIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdukActionPerformed(evt);
            }
        });

        txtNamaProduk.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 18)); // NOI18N
        jLabel3.setText("Nama Produk");

        jLabel4.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 18)); // NOI18N
        jLabel4.setText("Harga");

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInput.setText("INPUT");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRegistrasi.setText("MENU REGISTRASI");
        btnRegistrasi.setEnabled(false);
        btnRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrasiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 18)); // NOI18N
        jLabel6.setText("Jumlah Stok");

        txtKdBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtKdBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKdBarangActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 18)); // NOI18N
        jLabel5.setText("Kode Barang");

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduk);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHargasatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtJumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(90, 90, 90)
                                .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnInput)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHargasatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrasi, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1643, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        appLogin l = new appLogin();
        l.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtIdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdukActionPerformed

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        // TODO add your handling code here:
        try {
            String kdBarang = txtKdBarang.getText();
            String namaProduk = txtNamaProduk.getText();
            int hargaSatuan = Integer.parseInt(txtHargasatuan.getText());
            int jumlahStok = Integer.parseInt(txtJumlahStok.getText());

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

                try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

                    preparedStatement.setString(1, kdBarang);
                    preparedStatement.setString(2, namaProduk);
                    preparedStatement.setInt(3, hargaSatuan);
                    preparedStatement.setInt(4, jumlahStok);

                    preparedStatement.executeUpdate();

                    System.out.println("Data Sukses Di Input!");
                    txtIdProduk.setText("");
                    txtKdBarang.setText("");
                    txtNamaProduk.setText("");
                    txtHargasatuan.setText("");
                    txtJumlahStok.setText("");
                    connection.setAutoCommit(true);
                    refreshTable();
                }
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnInputActionPerformed

    private void txtKdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKdBarangActionPerformed
        // TODO add your handling code here:
         displayProductInformation(txtKdBarang.getText());
        
    }//GEN-LAST:event_txtKdBarangActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblProduk.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblProduk.getModel();

        if (selectedRow != -1) {

            String id_produk = model.getValueAt(selectedRow, 0).toString();
            String kd_barang = model.getValueAt(selectedRow, 1).toString();
            String nama_barang = model.getValueAt(selectedRow, 2).toString();
            String harga_satuan = model.getValueAt(selectedRow, 3).toString();
            String jumlah_stok = model.getValueAt(selectedRow, 4).toString();

            txtIdProduk.setText(id_produk);
            txtKdBarang.setText(kd_barang);
            txtNamaProduk.setText(nama_barang);
            txtHargasatuan.setText(harga_satuan);
            txtJumlahStok.setText(jumlah_stok);
        }

    }//GEN-LAST:event_tblProdukMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String kdBarang = txtKdBarang.getText();
            String namaProduk = txtNamaProduk.getText();
            int hargaSatuan = Integer.parseInt(txtHargasatuan.getText());
            int jumlahStok = Integer.parseInt(txtJumlahStok.getText());

            int selectedRow = tblProduk.getSelectedRow();
            if (selectedRow == -1) {

                return;
            }

            int idProduk = (int) tblProduk.getValueAt(selectedRow, 0);

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

                String updateQuery = "UPDATE input_produk SET kd_barang=?, nama_produk=?, harga_satuan=?, jumlah_stok=? WHERE id_produk=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, kdBarang);
                    preparedStatement.setString(2, namaProduk);
                    preparedStatement.setInt(3, hargaSatuan);
                    preparedStatement.setInt(4, jumlahStok);
                    preparedStatement.setInt(5, idProduk);

                    preparedStatement.executeUpdate();

                    System.out.println("Data Sukses Di Update!");
                    txtIdProduk.setText("");
                    txtKdBarang.setText("");
                    txtNamaProduk.setText("");
                    txtHargasatuan.setText("");
                    txtJumlahStok.setText("");
                    connection.setAutoCommit(true);
                    refreshTable();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            
            int selectedRow = tblProduk.getSelectedRow();
            if (selectedRow == -1) {
                
                return;
            }

         
            int idProduk = (int) tblProduk.getValueAt(selectedRow, 0);

            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                
                String deleteQuery = "DELETE FROM input_produk WHERE id_produk=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, idProduk);

                    preparedStatement.executeUpdate();

                    System.out.println("Data Berhasil Di Hapus!");
                    
                    txtIdProduk.setText("");
                    txtKdBarang.setText("");
                    txtNamaProduk.setText("");
                    txtHargasatuan.setText("");
                    txtJumlahStok.setText("");

                    refreshTable();
                }
            }
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., show an error message)
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrasiActionPerformed
        // TODO add your handling code here:
        menu_registrasi reg = new menu_registrasi();
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrasiActionPerformed

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
            java.util.logging.Logger.getLogger(masukan_produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masukan_produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masukan_produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masukan_produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masukan_produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnInput;
    public javax.swing.JButton btnLogout;
    public javax.swing.JButton btnRegistrasi;
    public javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtHargasatuan;
    private javax.swing.JTextField txtIdProduk;
    private javax.swing.JTextField txtJumlahStok;
    private javax.swing.JTextField txtKdBarang;
    private javax.swing.JTextField txtNamaProduk;
    // End of variables declaration//GEN-END:variables

    private void setupBarcodeListener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
