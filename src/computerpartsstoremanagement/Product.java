package computerpartsstoremanagement;

class Product {
    private String maSP, tenSP, dvt;
    private int giaTien, thoiGianBH;
    
    public Product(String maSP, String tenSP, int giaTien, String dvt, int thoiGianBH){
        this.maSP=maSP;
        this.tenSP=tenSP;
        this.giaTien=giaTien;
        this.dvt=dvt;
        this.thoiGianBH=thoiGianBH;
    }
    
    public String getMaSP() {
        return maSP;
    }
    public String getTenSP() {
        return tenSP;
    }
    public int getGiaTien() {
        return giaTien;
    }
    public String getDVT() {
        return dvt;
    }
    public int getThoiGianBH() {
        return thoiGianBH;
    }
}
