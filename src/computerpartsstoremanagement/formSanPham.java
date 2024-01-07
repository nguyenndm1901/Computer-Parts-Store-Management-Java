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

public class formSanPham extends JFrame {
    public formSanPham() {
        initComponents();
        initTable();
    }
    public ArrayList<Product> productList(){
        ArrayList<Product> productsList = new ArrayList<>();
        try {
            String url = ConnectionString.getUrl();
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

        lblTimKiem = new JLabel();
        txtTimKiem = new JTextField();
        btnSearch = new JButton();
        btnClear = new JButton();
        panel = new JPanel();
        txtBaoHanh = new JTextField();
        lblMaSP = new JLabel();
        lblTenSP = new JLabel();
        lblGiaTien = new JLabel();
        lblDVT = new JLabel();
        txtMaSP = new JTextField();
        lblBaoHanh = new JLabel();
        txtTenSP = new JTextField();
        txtDVT = new JTextField();
        txtGiaTien = new JTextField();
        btnOKAdd = new JButton();
        btnOKEdit = new JButton();
        btnOKDelete = new JButton();
        btnAdd = new JButton();
        btnEdit = new JButton();
        btnDelete = new JButton();
        ScrollPane1 = new JScrollPane();
        table = new JTable();
        jMenuBar1 = new JMenuBar();
        system = new JMenu();
        back = new JMenuItem();
        about = new JMenuItem();
        exit = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGiaTien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDVT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBaoHanh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP)
                    .addComponent(txtTenSP)
                    .addComponent(txtDVT)
                    .addComponent(txtBaoHanh)
                    .addComponent(txtGiaTien)))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOKAdd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOKEdit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOKDelete, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSP)
                    .addComponent(txtMaSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenSP)
                    .addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaTien)
                    .addComponent(txtGiaTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDVT)
                    .addComponent(txtDVT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBaoHanh)
                    .addComponent(txtBaoHanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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

        table.setModel(new DefaultTableModel(
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnClear)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiem)
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(ScrollPane1, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane1, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTimKiem)
                            .addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(btnClear))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            String url = ConnectionString.getUrl();
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
            String url = ConnectionString.getUrl();
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
            String url = ConnectionString.getUrl();
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
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
    private JScrollPane ScrollPane1;
    private JMenuItem about;
    private JMenuItem back;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnDelete;
    private JButton btnEdit;
    private JButton btnOKAdd;
    private JButton btnOKDelete;
    private JButton btnOKEdit;
    private JButton btnSearch;
    private JMenuItem exit;
    private JMenuBar jMenuBar1;
    private JLabel lblBaoHanh;
    private JLabel lblDVT;
    private JLabel lblGiaTien;
    private JLabel lblMaSP;
    private JLabel lblTenSP;
    private JLabel lblTimKiem;
    private JPanel panel;
    private JMenu system;
    private JTable table;
    private JTextField txtBaoHanh;
    private JTextField txtDVT;
    private JTextField txtGiaTien;
    private JTextField txtMaSP;
    private JTextField txtTenSP;
    private JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
