package computerpartsstoremanagement;

class Invoice {
    private String ngayMua, maHD, tenKH, tenNV;
    private int tongCong;
    
    public Invoice(String maHD, String ngayMua, int tongCong, String tenKH, String tenNV){
        this.ngayMua=ngayMua;
        this.maHD=maHD;
        this.tongCong=tongCong;
        this.tenKH=tenKH;
        this.tenNV=tenNV;
    }
    
    public String getNgayMua() {
        return ngayMua;
    }
    public int getTongCong(){
        return tongCong;
    }
    public String getMaHD() {
        return maHD;
    }
    public String getTenKH() {
        return tenKH;
    }
    public String getTenNV() {
        return tenNV;
    }
}
