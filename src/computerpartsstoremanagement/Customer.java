package computerpartsstoremanagement;

class Customer {
    private String ngayMua, maHD, tenKH, sdt;
    
    public Customer(String ngayMua, String maHD, String tenKH, String sdt){
        this.ngayMua=ngayMua;
        this.maHD=maHD;
        this.tenKH=tenKH;
        this.sdt=sdt;
    }
    
    public String getNgayMua() {
        return ngayMua;
    }
    public String getMaHD() {
        return maHD;
    }
    public String getTenKH() {
        return tenKH;
    }
    public String getSDT() {
        return sdt;
    }
}
