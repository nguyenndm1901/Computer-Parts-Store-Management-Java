package computerpartsstoremanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class formThongKe extends javax.swing.JFrame {

    public formThongKe() {
        initComponents();
        initTable();
        ThongKe();
    }

    public ArrayList<ThongKe> thongkeList(){
        ArrayList<ThongKe> thongkesList = new ArrayList<>();
        try {
            String url = ConnectionString.getUrl();
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ThongKe");

            while(resultSet.next()){
                ThongKe thongke = new ThongKe(resultSet.getString("ngay"), resultSet.getString("maHD"), 
                        resultSet.getString("tenKH"), resultSet.getString("tenSP"), 
                        resultSet.getInt("donGia"), resultSet.getInt("soLuong"), 
                        resultSet.getString("dvt"), resultSet.getInt("thanhTien"));
                thongkesList.add(thongke);
            }
        }
        catch(Exception sqlex){
            sqlex.printStackTrace();
        }        
        return thongkesList;
    }
    
    public void initTable(){
        ArrayList<ThongKe> list = thongkeList();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[8];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNgay();
            row[1] = list.get(i).getMaHD();
            row[2] = list.get(i).getTenKH();
            row[3] = list.get(i).getTenSP();
            row[4] = list.get(i).getDonGia();
            row[5] = list.get(i).getSoLuong();
            row[6] = list.get(i).getDVT();
            row[7] = list.get(i).getThanhTien();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotalSold = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotalCreated = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalRevenue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalCustomer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaxCustomer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMinCusTomer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaxProduct = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMinProduct = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaxPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMinPrice = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        system = new javax.swing.JMenu();
        back = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống Kê");

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Mã Hóa Đơn", "Tên Khách Hàng", "Tên Sản Phẩm", "Đơn Giá", "Số Lượng", "Đơn Vị Tính", "Thành Tiền"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tổng Sản Phẩm Đã Bán:");

        txtTotalSold.setEditable(false);
        txtTotalSold.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tổng Hóa Đơn Đã Tạo:");

        txtTotalCreated.setEditable(false);
        txtTotalCreated.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tổng Doanh Thu:");

        txtTotalRevenue.setEditable(false);
        txtTotalRevenue.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng Số Khách Mua Hàng:");

        txtTotalCustomer.setEditable(false);
        txtTotalCustomer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Khách Hàng Mua Nhiều Nhất:");

        txtMaxCustomer.setEditable(false);
        txtMaxCustomer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Khách Hàng Mua Ít Nhất:");

        txtMinCusTomer.setEditable(false);
        txtMinCusTomer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sản Phẩm Được Mua Nhiều Nhất:");

        txtMaxProduct.setEditable(false);
        txtMaxProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sản Phẩm Được Mua Ít Nhất:");

        txtMinProduct.setEditable(false);
        txtMinProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sản Phẩm Có Giá Cao Nhất:");

        txtMaxPrice.setEditable(false);
        txtMaxPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sản Phẩm Có Giá Thấp Nhất:");

        txtMinPrice.setEditable(false);
        txtMinPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTotalCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTotalRevenue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTotalCreated, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTotalSold, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMinPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtMaxPrice)
                            .addComponent(txtMinProduct)
                            .addComponent(txtMaxProduct)
                            .addComponent(txtMinCusTomer))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTotalSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMinCusTomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMinProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(null, "Phiên bản 1.0.0.0");
    }//GEN-LAST:event_aboutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    public void ThongKe(){
        try{
            String url = ConnectionString.getUrl();
            Connection connection = DriverManager.getConnection(url);
            String sql1 = "SELECT COUNT(soLuong) AS SoLuong FROM ThongKe";
            String sql2 = "SELECT COUNT(DISTINCT maHD) AS HoaDon FROM ThongKe";
            String sql3 = "SELECT SUM(thanhTien) AS TongCong FROM ThongKe";
            String sql4 = "SELECT COUNT(DISTINCT tenKH) AS KhachHang FROM ThongKe";
            String sql5 = "SELECT tenKH AS Max FROM ThongKe WHERE tenKH = (SELECT TOP 1 tenKH FROM ThongKe GROUP BY tenKH ORDER BY COUNT(DISTINCT tenKH) DESC)";
            String sql6 = "SELECT tenKH AS Min FROM ThongKe WHERE tenKH = (SELECT TOP 1 tenKH FROM ThongKe GROUP BY tenKH ORDER BY COUNT(DISTINCT tenKH) ASC)";
            String sql7 = "SELECT tenSP AS MaxSP FROM ThongKe WHERE tenSP = (SELECT TOP 1 tenSP FROM ThongKe GROUP BY tenSP ORDER BY COUNT(DISTINCT tenSP) DESC)";
            String sql8 = "SELECT tenKH AS MinSP FROM ThongKe WHERE tenSP = (SELECT TOP 1 tenSP FROM ThongKe GROUP BY tenSP ORDER BY COUNT(DISTINCT tenSP) ASC)";
            PreparedStatement pst1 = connection.prepareStatement(sql1); 
            PreparedStatement pst2 = connection.prepareStatement(sql2); 
            PreparedStatement pst3 = connection.prepareStatement(sql3); 
            PreparedStatement pst4 = connection.prepareStatement(sql4); 
            PreparedStatement pst5 = connection.prepareStatement(sql5); 
            PreparedStatement pst6 = connection.prepareStatement(sql6); 
            PreparedStatement pst7 = connection.prepareStatement(sql7); 
            PreparedStatement pst8 = connection.prepareStatement(sql8); 
            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();
            if(rs1.next()){
                if(rs2.next()){
                    if(rs3.next()){
                        if(rs4.next()){         
                            String sold = rs1.getString("SoLuong");
                            txtTotalSold.setText(sold);
                            String hoadon = rs2.getString("HoaDon");
                            txtTotalCreated.setText(hoadon);
                            String tongcong = rs3.getString("TongCong"); 
                            txtTotalRevenue.setText(tongcong);                                               
                            String khachhang = rs4.getString("KhachHang");
                            txtTotalCustomer.setText(khachhang);                                                                                                                 
                        }
                    }
                }
            }
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        try{
            String url = ConnectionString.getUrl();
            Connection connection = DriverManager.getConnection(url);
            String sql1 = "SELECT tenKH AS Max FROM ThongKe WHERE tenKH = (SELECT TOP 1 tenKH FROM ThongKe GROUP BY tenKH ORDER BY COUNT(DISTINCT soLuong) DESC)";
            String sql2 = "SELECT tenKH AS Min FROM ThongKe WHERE tenKH = (SELECT TOP 1 tenKH FROM ThongKe GROUP BY tenKH ORDER BY COUNT(DISTINCT soLuong) ASC)";
            String sql3 = "SELECT tenSP AS MaxSP FROM ThongKe WHERE soLuong = (SELECT MAX(soLuong) FROM ThongKe)";
            String sql4 = "SELECT tenSP AS MinSP FROM ThongKe WHERE soLuong = (SELECT MIN(soLuong) FROM ThongKe)";
            PreparedStatement pst1 = connection.prepareStatement(sql1); 
            PreparedStatement pst2 = connection.prepareStatement(sql2); 
            PreparedStatement pst3 = connection.prepareStatement(sql3); 
            PreparedStatement pst4 = connection.prepareStatement(sql4); 
            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();
            if(rs1.next()){
                if(rs2.next()){
                    if(rs3.next()){
                        if(rs4.next()){
                            String max = rs1.getString("Max");
                            txtMaxCustomer.setText(max);
                            String min = rs2.getString("Min");
                            txtMinCusTomer.setText(min);
                            String maxsp = rs3.getString("MaxSP");
                            txtMaxProduct.setText(maxsp);
                            String minsp = rs4.getString("MinSP");
                            txtMinProduct.setText(minsp); 
                        }
                    }
                }
            }
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        try{
            String url = ConnectionString.getUrl();
            Connection connection = DriverManager.getConnection(url);
            String sql1 = "SELECT tenSP AS MaxPrice FROM SanPham WHERE giaTien = (SELECT MAX(giaTien) FROM SanPham)";
            String sql2 = "SELECT tenSP AS MinPrice FROM SanPham WHERE giaTien = (SELECT MIN(giaTien) FROM SanPham)";
            PreparedStatement pst1 = connection.prepareStatement(sql1); 
            PreparedStatement pst2 = connection.prepareStatement(sql2); 
            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            if(rs1.next()){
                if(rs2.next()){
                    String maxprice = rs1.getString("MaxPrice");
                    txtMaxPrice.setText(maxprice);
                    String minprice = rs2.getString("MinPrice");
                    txtMinPrice.setText(minprice);
                }
            }
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        formMain main = new formMain();
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem back;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu system;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMaxCustomer;
    private javax.swing.JTextField txtMaxPrice;
    private javax.swing.JTextField txtMaxProduct;
    private javax.swing.JTextField txtMinCusTomer;
    private javax.swing.JTextField txtMinPrice;
    private javax.swing.JTextField txtMinProduct;
    private javax.swing.JTextField txtTotalCreated;
    private javax.swing.JTextField txtTotalCustomer;
    private javax.swing.JTextField txtTotalRevenue;
    private javax.swing.JTextField txtTotalSold;
    // End of variables declaration//GEN-END:variables
}
