package computerpartsstoremanagement;

class ThongKe {
    private String ngay, maHD, tenKH, tenSP, dvt;
    private int soLuong, donGia, thanhTien;
    
    public ThongKe(String ngay, String maHD, String tenKH, String tenSP, int donGia, int soLuong, String dvt, int thanhTien){
        this.ngay=ngay;
        this.maHD=maHD;
        this.tenKH=tenKH;
        this.tenSP=tenSP;
        this.donGia=donGia;
        this.soLuong=soLuong;
        this.dvt=dvt;
        this.thanhTien=thanhTien;
    }
    
    public String getNgay() {
        return ngay;
    }
    public String getMaHD() {
        return maHD;
    }
    public String getTenKH() {
        return tenKH;
    }
    public String getTenSP() {
        return tenSP;
    }
    public int getDonGia() {
        return donGia;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public String getDVT() {
        return dvt;
    }
    public int getThanhTien() {
        return thanhTien;
    }
}
