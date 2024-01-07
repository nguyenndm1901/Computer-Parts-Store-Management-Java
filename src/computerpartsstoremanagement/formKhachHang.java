package computerpartsstoremanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.*;
import javax.swing.*;

public class formKhachHang extends JFrame {
    public formKhachHang() {
        initComponents();
        initTable();
        Date_KH();
    }
    
    public ArrayList<Customer> customerList(){
        ArrayList<Customer> customersList = new ArrayList<>();
        try {
            String url = ConnectionString.getUrl();
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM KhachHang");

            while(resultSet.next()){
                Customer customer = new Customer(resultSet.getString("ngayMua"), 
                        resultSet.getString("maHD"), resultSet.getString("tenKH"), 
                        resultSet.getString("sdt"));
                customersList.add(customer);
            }
        }
        catch(Exception sqlex){
            sqlex.printStackTrace();
        }        
        return customersList;
    }
    
    public void initTable(){
        ArrayList<Customer> list = customerList();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNgayMua();
            row[1] = list.get(i).getMaHD();
            row[2] = list.get(i).getTenKH();
            row[3] = list.get(i).getSDT();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        table = new JTable();
        lblTimKiem = new JLabel();
        txtSearch = new JTextField();
        btnSearch = new JButton();
        btnClear = new JButton();
        lblDate = new JLabel();
        txtSearchDate = new JTextField();
        btnSearchDate = new JButton();
        btnClearDate = new JButton();
        jMenuBar1 = new JMenuBar();
        system = new JMenu();
        back = new JMenuItem();
        about = new JMenuItem();
        exit = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khách Hàng");

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày Mua", "Mã Hóa Đơn", "Tên Khách Hàng", "Số Điện Thoại"
            }
        ));
        jScrollPane1.setViewportView(table);

        lblTimKiem.setText("Tìm Kiếm Theo Từ Khóa:");

        txtSearch.setHorizontalAlignment(JTextField.CENTER);

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

        lblDate.setText("Tìm Kiếm Theo Ngày:");

        txtSearchDate.setHorizontalAlignment(JTextField.CENTER);

        btnSearchDate.setText("Tìm Kiếm");
        btnSearchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDateActionPerformed(evt);
            }
        });

        btnClearDate.setText("Xóa Tìm Kiếm");
        btnClearDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearDateActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate)
                            .addComponent(lblTimKiem))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchDate, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearchDate)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearDate)))
                        .addGap(0, 219, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem)
                    .addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnClear))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchDate)
                        .addComponent(btnClearDate)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        table.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        String text = txtSearch.getText();
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
        txtSearch.setText("");
        sorter.setRowFilter(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        formMain main = new formMain();
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(null, "Phiên bản 1.0.0.0");
    }//GEN-LAST:event_aboutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void btnSearchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDateActionPerformed
        table.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        String text = txtSearchDate.getText();
        if(text.length()==0){
            sorter.setRowFilter(null);
        }
        else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_btnSearchDateActionPerformed

    private void btnClearDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearDateActionPerformed
        table.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        txtSearchDate.setText("");
        sorter.setRowFilter(null);
        Date_KH();
    }//GEN-LAST:event_btnClearDateActionPerformed

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
            java.util.logging.Logger.getLogger(formKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuItem about;
    private JMenuItem back;
    private JButton btnClear;
    private JButton btnClearDate;
    private JButton btnSearch;
    private JButton btnSearchDate;
    private JMenuItem exit;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane1;
    private JLabel lblDate;
    private JLabel lblTimKiem;
    private JMenu system;
    private JTable table;
    private JTextField txtSearch;
    private JTextField txtSearchDate;
    // End of variables declaration//GEN-END:variables

    public void Date_KH(){
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  
        txtSearchDate.setText(strDate);
        
    }

}
