/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerpartsstoremanagement;

import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class formSanPham extends javax.swing.JFrame {
    public formSanPham() {
        initComponents();
        initTable();
    }
    public ArrayList<Product> productList(){
        ArrayList<Product> productsList = new ArrayList<>();
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SanPham");

            while(resultSet.next()){
                Product product = new Product(resultSet.getString("maSP"), resultSet.getString("tenSP"), 
                        resultSet.getInt("giaTien"), resultSet.getString("dvt"), 
                        resultSet.getInt("thoiGianBH"));
                productsList.add(product);
            }
        }
        catch(Exception sqlex){
            sqlex.printStackTrace();
        }        
        return productsList;
    }
    
    public void initTable(){
        ArrayList<Product> list = productList();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getMaSP();
            row[1] = list.get(i).getTenSP();
            row[2] = list.get(i).getGiaTien();
            row[3] = list.get(i).getDVT();
            row[4] = list.get(i).getThoiGianBH();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        txtBaoHanh = new javax.swing.JTextField();
        lblMaSP = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        lblBaoHanh = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtDVT = new javax.swing.JTextField();
        txtGiaTien = new javax.swing.JTextField();
        btnOKAdd = new javax.swing.JButton();
        btnOKEdit = new javax.swing.JButton();
        btnOKDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        ScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        system = new javax.swing.JMenu();
        back = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sản Phẩm");

        lblTimKiem.setText("Tìm Kiếm:");

        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setText("Xóa Tìm Kiếm");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        panel.setEnabled(false);

        txtBaoHanh.setEnabled(false);

        lblMaSP.setText("Mã Sản Phẩm:");
        lblMaSP.setEnabled(false);

        lblTenSP.setText("Tên Sản Phẩm:");
        lblTenSP.setEnabled(false);

        lblGiaTien.setText("Giá Tiền:");
        lblGiaTien.setEnabled(false);

        lblDVT.setText("Đơn Vị Tính:");
        lblDVT.setEnabled(false);

        txtMaSP.setEnabled(false);

        lblBaoHanh.setText("Thời Gian Bảo Hành");
        lblBaoHanh.setEnabled(false);

        txtTenSP.setEnabled(false);

        txtDVT.setEnabled(false);

        txtGiaTien.setEnabled(false);

        btnOKAdd.setText("OK");
        btnOKAdd.setEnabled(false);
        btnOKAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKAddActionPerformed(evt);
            }
        });

        btnOKEdit.setText("OK");
        btnOKEdit.setEnabled(false);
        btnOKEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKEditActionPerformed(evt);
            }
        });

        btnOKDelete.setText("OK");
        btnOKDelete.setEnabled(false);
        btnOKDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBaoHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP)
                    .addComponent(txtTenSP)
                    .addComponent(txtDVT)
                    .addComponent(txtBaoHanh)
                    .addComponent(txtGiaTien)))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOKAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOKEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOKDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSP)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenSP)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaTien)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDVT)
                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBaoHanh)
                    .addComponent(txtBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOKDelete)
                    .addComponent(btnOKEdit)
                    .addComponent(btnOKAdd))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Tiền", "Đơn Vị Tính", "Thời Gian Bảo Hành"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        ScrollPane1.setViewportView(table);

        system.setText("Hệ Thống");

        back.setText("Trở Về");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        system.add(back);

        about.setText("Phiên Bản");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        system.add(about);

        exit.setText("Đóng Ứng Dụng");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        system.add(exit);

        jMenuBar1.add(system);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnClear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiem)
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTimKiem)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(btnClear))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        table.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        String text = txtTimKiem.getText();
        if(text.length()==0){
            sorter.setRowFilter(null);
        }
        else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        table.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        txtTimKiem.setText("");
        sorter.setRowFilter(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnOKAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKAddActionPerformed
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "INSERT INTO SanPham (maSP,tenSP,giaTien,dvt,thoiGianBH) VALUES(?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, txtMaSP.getText());
            pst.setString(2, txtTenSP.getText());
            pst.setInt(3, Integer.parseInt(txtGiaTien.getText()));
            pst.setString(4, txtDVT.getText());
            pst.setInt(5, Integer.parseInt(txtBaoHanh.getText()));            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            initTable();
            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!");
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }

        panel.setEnabled(true);
        lblMaSP.setEnabled(false);
        lblTenSP.setEnabled(false);
        lblGiaTien.setEnabled(false);
        lblDVT.setEnabled(false);
        lblBaoHanh.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtMaSP.setText("");
        txtTenSP.setEnabled(false);
        txtTenSP.setText("");
        txtGiaTien.setEnabled(false);
        txtGiaTien.setText("");
        txtDVT.setEnabled(false);
        txtDVT.setText("");
        txtBaoHanh.setEnabled(false);
        txtBaoHanh.setText("");
        btnOKAdd.setEnabled(false);
        btnOKEdit.setEnabled(false);
        btnOKDelete.setEnabled(false);
    }//GEN-LAST:event_btnOKAddActionPerformed

    private void btnOKEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKEditActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "UPDATE SanPham SET tenSP=?,giaTien=?,dvt=?,thoiGianBH=? WHERE maSP=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, txtTenSP.getText());
            pst.setInt(2, Integer.parseInt(txtGiaTien.getText()));
            pst.setString(3, txtDVT.getText());
            pst.setInt(4, Integer.parseInt(txtBaoHanh.getText()));            
            pst.setString(5, txtMaSP.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            initTable();
            JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công!");
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }

        panel.setEnabled(true);
        lblMaSP.setEnabled(false);
        lblTenSP.setEnabled(false);
        lblGiaTien.setEnabled(false);
        lblDVT.setEnabled(false);
        lblBaoHanh.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtMaSP.setText("");
        txtTenSP.setEnabled(false);
        txtTenSP.setText("");
        txtGiaTien.setEnabled(false);
        txtGiaTien.setText("");
        txtDVT.setEnabled(false);
        txtDVT.setText("");
        txtBaoHanh.setEnabled(false);
        txtBaoHanh.setText("");
        btnOKAdd.setEnabled(false);
        btnOKEdit.setEnabled(false);
        btnOKDelete.setEnabled(false);
    }//GEN-LAST:event_btnOKEditActionPerformed

    private void btnOKDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKDeleteActionPerformed
        try {            
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "DELETE FROM SanPham WHERE maSP=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, txtMaSP.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            initTable();
            JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công!");
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }

        panel.setEnabled(true);
        lblMaSP.setEnabled(false);
        lblTenSP.setEnabled(false);
        lblGiaTien.setEnabled(false);
        lblDVT.setEnabled(false);
        lblBaoHanh.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtMaSP.setText("");
        txtTenSP.setEnabled(false);
        txtTenSP.setText("");
        txtGiaTien.setEnabled(false);
        txtGiaTien.setText("");
        txtDVT.setEnabled(false);
        txtDVT.setText("");
        txtBaoHanh.setEnabled(false);
        txtBaoHanh.setText("");
        btnOKAdd.setEnabled(false);
        btnOKEdit.setEnabled(false);
        btnOKDelete.setEnabled(false);
    }//GEN-LAST:event_btnOKDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        panel.setEnabled(true);
        lblMaSP.setEnabled(true);
        lblTenSP.setEnabled(true);
        lblGiaTien.setEnabled(true);
        lblDVT.setEnabled(true);
        lblBaoHanh.setEnabled(true);
        txtMaSP.setEnabled(true);
        txtTenSP.setEnabled(true);
        txtGiaTien.setEnabled(true);
        txtDVT.setEnabled(true);
        txtBaoHanh.setEnabled(true);
        btnOKAdd.setEnabled(true);
        btnOKEdit.setEnabled(false);
        btnOKDelete.setEnabled(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        panel.setEnabled(true);
        lblMaSP.setEnabled(true);
        lblTenSP.setEnabled(true);
        lblGiaTien.setEnabled(true);
        lblDVT.setEnabled(true);
        lblBaoHanh.setEnabled(true);
        txtMaSP.setEnabled(true);
        txtTenSP.setEnabled(true);
        txtGiaTien.setEnabled(true);
        txtDVT.setEnabled(true);
        txtBaoHanh.setEnabled(true);
        btnOKAdd.setEnabled(false);
        btnOKEdit.setEnabled(true);
        btnOKDelete.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        panel.setEnabled(true);
        lblMaSP.setEnabled(true);
        lblTenSP.setEnabled(false);
        lblGiaTien.setEnabled(false);
        lblDVT.setEnabled(false);
        lblBaoHanh.setEnabled(false);
        txtMaSP.setEnabled(true);
        txtTenSP.setEnabled(false);
        txtGiaTien.setEnabled(false);
        txtDVT.setEnabled(false);
        txtBaoHanh.setEnabled(false);
        btnOKAdd.setEnabled(false);
        btnOKEdit.setEnabled(false);
        btnOKDelete.setEnabled(true);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();
        TableModel model = table.getModel();
        txtMaSP.setText(model.getValueAt(i,0).toString());
        txtTenSP.setText(model.getValueAt(i,1).toString());
        txtGiaTien.setText(model.getValueAt(i,2).toString());
        txtDVT.setText(model.getValueAt(i,3).toString());
        txtBaoHanh.setText(model.getValueAt(i,4).toString());        
    }//GEN-LAST:event_tableMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        formMain main = new formMain();
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(null, "Phiên Bản 1.0.0.0");
    }//GEN-LAST:event_aboutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem back;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOKAdd;
    private javax.swing.JButton btnOKDelete;
    private javax.swing.JButton btnOKEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblBaoHanh;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel panel;
    private javax.swing.JMenu system;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBaoHanh;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
