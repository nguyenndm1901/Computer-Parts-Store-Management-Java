package computerpartsstoremanagement;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.*;
import javax.swing.*;

public class formLapHoaDon extends javax.swing.JFrame {
    public formLapHoaDon() {
        initComponents();
        initTable();
        loadCBTenSP();
        loadCBTenNV();
        setNull();
    }
    
    private String randomMaHD(){
        int r1 = (int)(Math.random() * 999 + 1);
        String rand1 = Integer.toString(r1);
        int r2 = (int)(Math.random() * 99 + 1);
        String rand2 = Integer.toString(r2);
        String maHD = rand1 + '-' + rand2;
        return maHD;      
    }
    
    private boolean check(String maHD){
        boolean existed = false;
        try{
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT COUNT(maHD) AS MaHD FROM HoaDon WHERE maHD = ?";
            PreparedStatement pst = connection.prepareStatement(sql); 
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if(rs.getInt("MaHD")>0){
                    existed =true;
                }
            }
            
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        
        
        return existed;
    }
    
    public ArrayList<Payment> paymentList(){
        ArrayList<Payment> paymentsList = new ArrayList<>();
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM GioHang");

            while(resultSet.next()){
                Payment payment = new Payment(resultSet.getString("tenSP"), 
                        resultSet.getInt("giaTien"), resultSet.getInt("soLuong"), resultSet.getString("dvt"), 
                        resultSet.getInt("thoiGianBH"), resultSet.getInt("thanhTien"));
                paymentsList.add(payment);
            }
        }
        catch(Exception sqlex){
            sqlex.printStackTrace();
        }        
        return paymentsList;
    }
    
    public void initTable(){
        ArrayList<Payment> list = paymentList();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getTenSP();
            row[2] = list.get(i).getGiaTien();
            row[1] = list.get(i).getSoLuong();
            row[3] = list.get(i).getDVT();
            row[4] = list.get(i).getThoiGianBH();
            row[5] = list.get(i).getThanhTien();
            model.addRow(row);
        }
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMaHD = new javax.swing.JLabel();
        lblNgayMua = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblDonGia = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        lblBH = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtNgayMua = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        cbTenNV = new javax.swing.JComboBox<>();
        cbTenSP = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        lblDong = new javax.swing.JTextField();
        txtDVT = new javax.swing.JTextField();
        txtBH = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblThang = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        system = new javax.swing.JMenu();
        back = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lập Hóa Đơn");

        lblMaHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaHD.setText("Mã Hóa Đơn:");
        lblMaHD.setEnabled(false);

        lblNgayMua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayMua.setText("Ngày Tạo:");
        lblNgayMua.setEnabled(false);

        lblTenKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenKH.setText("Khách Hàng:");
        lblTenKH.setEnabled(false);

        lblSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSDT.setText("Số Điện Thoại:");
        lblSDT.setEnabled(false);

        lblTenNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenNV.setText("Tên Nhân Viên:");
        lblTenNV.setEnabled(false);

        lblTenSP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenSP.setText("Tên Sản Phẩm:");
        lblTenSP.setEnabled(false);

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoLuong.setText("Số Lượng:");
        lblSoLuong.setEnabled(false);

        lblDonGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDonGia.setText("Đơn Giá:");
        lblDonGia.setEnabled(false);

        lblDVT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDVT.setText("Đơn Vị Tính:");
        lblDVT.setEnabled(false);

        lblBH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBH.setText("Thời Gian Bảo Hành");
        lblBH.setEnabled(false);

        txtMaHD.setEditable(false);
        txtMaHD.setBorder(null);
        txtMaHD.setEnabled(false);

        txtNgayMua.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayMua.setEnabled(false);

        txtTenKH.setEnabled(false);

        txtSDT.setEnabled(false);

        cbTenNV.setEnabled(false);

        cbTenSP.setEnabled(false);
        cbTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenSPActionPerformed(evt);
            }
        });

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setEnabled(false);

        txtDonGia.setEditable(false);
        txtDonGia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDonGia.setEnabled(false);

        lblDong.setEditable(false);
        lblDong.setText("vnđ");
        lblDong.setBorder(null);
        lblDong.setEnabled(false);

        txtDVT.setEditable(false);
        txtDVT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDVT.setEnabled(false);

        txtBH.setEditable(false);
        txtBH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBH.setEnabled(false);

        btnNew.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnNew.setText("Tạo Hóa Đơn");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm Vào Giỏ");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCheckOut.setText("Thanh Toán");
        btnCheckOut.setEnabled(false);
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản Phẩm", "Số Lượng", "Đơn Giá", "Đơn Vị Tính", "Thời Gian Bào Hành", "Thành Tiền"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        lblThang.setEditable(false);
        lblThang.setText("tháng");
        lblThang.setBorder(null);
        lblThang.setEnabled(false);

        btnDelete.setText("Xóa Sản Phẩm");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setText("Tổng Hóa Đơn:");

        jLabel2.setText("vnđ");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTenSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTenNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTenKH)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenKH))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNgayMua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(lblBH)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(lblThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(btnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaHD)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayMua)
                            .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenKH)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSDT)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenNV)
                            .addComponent(cbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenSP)
                            .addComponent(cbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoLuong)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDonGia)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDVT)
                            .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBH)
                            .addComponent(txtBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lblMaHD.setEnabled(true);
        lblNgayMua.setEnabled(true);
        lblTenKH.setEnabled(true);
        lblSDT.setEnabled(true);
        lblTenNV.setEnabled(true);
        lblTenSP.setEnabled(true);
        lblSoLuong.setEnabled(true);
        lblDonGia.setEnabled(true);
        lblDVT.setEnabled(true);
        lblBH.setEnabled(true);
        lblDong.setEnabled(true);
        lblThang.setEnabled(true);
        
        txtMaHD.setEnabled(true);
        txtNgayMua.setEnabled(true);
        txtTenKH.setEnabled(true);
        txtSDT.setEnabled(true);
        cbTenNV.setEnabled(true);
        cbTenSP.setEnabled(true);
        txtSoLuong.setEnabled(true);
        txtDonGia.setEnabled(true);
        txtDVT.setEnabled(true);
        txtBH.setEnabled(true);
        
        btnAdd.setEnabled(true);
        btnCheckOut.setEnabled(false);
        btnNew.setEnabled(false);
        Date_HD();
        
        String maHD;
        boolean isExisted = true;
        while(isExisted){
            maHD = randomMaHD();
            isExisted = check(maHD);
            txtMaHD.setText(maHD);
        }
    }//GEN-LAST:event_btnNewActionPerformed

    public void Date_HD(){
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  
        txtNgayMua.setText(strDate);
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtNgayMua.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Yêu cầu ngày mua");
        }
        else if(txtTenKH.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Yêu cầu tên khách hàng");
        }
        else if(txtSDT.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Yêu cầu số điện thoại khách hàng");
        }
        else if(cbTenNV.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null, "Yêu cầu tên nhân viên");
        }
        else if(cbTenSP.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null, "Yêu cầu tên sản phẩm");
        }
        else if(txtSoLuong.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Yêu cầu số lượng sản phẩm");
        }
        else {
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "INSERT INTO GioHang (ngay,maHD,tenSP,giaTien,soLuong,dvt,thoiGianBH,thanhTien) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, txtNgayMua.getText());
            pst.setString(2, txtMaHD.getText());
            pst.setString(3, (String) cbTenSP.getSelectedItem());
            pst.setInt(4, Integer.parseInt(txtDonGia.getText()));
            pst.setInt(5, Integer.parseInt(txtSoLuong.getText()));
            pst.setString(6, txtDVT.getText());
            pst.setInt(7, Integer.parseInt(txtBH.getText()));  
            int donGia = Integer.parseInt(txtDonGia.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            int thanhTien = soLuong*donGia;
            pst.setInt(8, thanhTien);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            initTable();
            cbTenSP.setSelectedIndex(-1);
            txtSoLuong.setText("");
            txtDonGia.setText("");
            txtBH.setText("");
            txtDVT.setText("");
            btnCheckOut.setEnabled(true);
            SumTotal();
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        lblMaHD.setEnabled(false);
        lblNgayMua.setEnabled(false);
        lblTenKH.setEnabled(false);
        lblSDT.setEnabled(false);
        lblTenNV.setEnabled(false);
        
        txtMaHD.setEnabled(false);
        txtNgayMua.setEnabled(false);
        txtTenKH.setEnabled(false);
        txtSDT.setEnabled(false);
        cbTenNV.setEnabled(false);
        
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public void setNull(){
        txtDonGia.setText("");
        txtBH.setText("");
        txtDVT.setText("");
    }
    
    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        lblMaHD.setEnabled(false);
        lblNgayMua.setEnabled(false);
        lblTenKH.setEnabled(false);
        lblSDT.setEnabled(false);
        lblTenNV.setEnabled(false);
        lblTenSP.setEnabled(false);
        lblSoLuong.setEnabled(false);
        lblDonGia.setEnabled(false);
        lblDVT.setEnabled(false);
        lblBH.setEnabled(false);
        lblDong.setEnabled(false);
        lblThang.setEnabled(false);
        
        txtMaHD.setEnabled(false);
        txtNgayMua.setEnabled(false);
        txtTenKH.setEnabled(false);
        txtSDT.setEnabled(false);
        cbTenNV.setEnabled(false);
        cbTenSP.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtDonGia.setEnabled(false);
        txtDVT.setEnabled(false);
        txtBH.setEnabled(false);
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtBH.setText("");
        txtDVT.setText("");
        txtNgayMua.setText("");
        
        btnAdd.setEnabled(false);
        btnCheckOut.setEnabled(false);
        btnNew.setEnabled(true);
        
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "INSERT INTO HoaDon (maHD,ngayXuatHD,tongTien,tenKH,tenNV) VALUES(?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, txtMaHD.getText());
            pst.setString(2, txtNgayMua.getText());
            pst.setInt(3, Integer.parseInt(txtTotal.getText()));
            pst.setString(4, txtTenKH.getText());
            pst.setString(5, cbTenNV.getSelectedItem().toString());           
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thanh toán thành công!");            
        }
        catch(HeadlessException | NumberFormatException | SQLException sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "INSERT INTO KhachHang (ngayMua,maHD,tenKH,sdt) VALUES(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, txtNgayMua.getText());
            pst.setString(2, txtMaHD.getText());
            pst.setString(3, txtTenKH.getText());
            pst.setString(4, txtSDT.getText());           
            pst.executeUpdate();
        }
        catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            int doanhThu = 0;
            int tongCong = Integer.parseInt(txtTotal.getText());
            doanhThu += tongCong;
            String query = "UPDATE NhanVien SET doanhThu = " + doanhThu + " WHERE tenNV = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, cbTenNV.getSelectedItem().toString());         
            pst.executeUpdate();
        }
        catch(NumberFormatException | SQLException sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }  
        
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "INSERT INTO ThongKe(ngay,maHD,tenSP,donGia,soLuong,dvt,thanhTien) SELECT ngay,maHD,tenSP,giaTien,soLuong,dvt,thanhTien FROM GioHang";
            String query2 = "UPDATE ThongKe SET tenKH = ? WHERE maHD = ?";
            PreparedStatement pst = connection.prepareStatement(query);  
            PreparedStatement pst2 = connection.prepareStatement(query2); 
            pst2.setString(1, txtTenKH.getText()); 
            pst2.setString(2, txtMaHD.getText()); 
            pst.executeUpdate();
            pst2.executeUpdate();
        }
        catch(NumberFormatException | SQLException sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
        
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "DELETE FROM GioHang";
            PreparedStatement pst = connection.prepareStatement(query);      
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            initTable();
            txtTenKH.setText("");
            txtSDT.setText("");
            cbTenNV.setSelectedIndex(-1);
            cbTenSP.setSelectedIndex(-1);
        }
        catch(NumberFormatException | SQLException sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

    public void loadCBTenNV(){
        try{
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM NhanVien";
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();           
            while(rs.next()){
                cbTenNV.addItem(rs.getString("tenNV"));

            }
            cbTenNV.setSelectedIndex(-1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadCBTenSP(){
        try{
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM SanPham";
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();           
            while(rs.next()){
                cbTenSP.addItem(rs.getString("tenSP"));

            }
            cbTenSP.setSelectedIndex(-1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void cbTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenSPActionPerformed
        try{
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM SanPham WHERE tenSP = ?";
            PreparedStatement pst = connection.prepareStatement(sql); 
            pst.setString(1, (String) cbTenSP.getSelectedItem());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){               
                txtDonGia.setText(rs.getString("giaTien"));
                txtDVT.setText(rs.getString("dvt"));
                txtBH.setText(rs.getString("thoiGianBH"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cbTenSPActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();
        TableModel model = table.getModel();
        cbTenSP.setSelectedItem(model.getValueAt(i,0).toString());
        txtSoLuong.setText(model.getValueAt(i,2).toString());
        txtDonGia.setText(model.getValueAt(i,1).toString());
        txtDVT.setText(model.getValueAt(i,3).toString());
        txtBH.setText(model.getValueAt(i,4).toString());  
    }//GEN-LAST:event_tableMouseClicked

    public void SumTotal(){
        try{       
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT SUM(thanhTien) AS ThanhTien FROM GioHang";
            PreparedStatement pst = connection.prepareStatement(sql); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int ThanhTien = rs.getInt("ThanhTien");
                txtTotal.setText(Integer.toString(ThanhTien));
            }
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }    
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {            
            String url = "jdbc:sqlserver://localhost;databaseName=DBQLCH;integratedSecurity=true;";
            Connection connection = DriverManager.getConnection(url);
            String query = "DELETE FROM GioHang WHERE tenSP=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, cbTenSP.getSelectedItem().toString());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            initTable();
            cbTenSP.setSelectedIndex(-1);
            txtSoLuong.setText("");
            txtDonGia.setText("");
            txtBH.setText("");
            txtDVT.setText("");
            SumTotal();
        }
        catch(Exception sqlex){
            JOptionPane.showMessageDialog(null, sqlex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(formLapHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLapHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLapHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLapHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formLapHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem back;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cbTenNV;
    private javax.swing.JComboBox<String> cbTenSP;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBH;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JTextField lblDong;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblNgayMua;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JTextField lblThang;
    private javax.swing.JMenu system;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBH;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayMua;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
