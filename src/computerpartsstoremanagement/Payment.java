package computerpartsstoremanagement;

class Payment {
    private String tenSP, dvt;
    private int soLuong, giaTien, thoiGianBH, thanhTien;
    
    public Payment(String tenSP,int giaTien, int soLuong, String dvt, int thoiGianBH, int thanhTien){
        this.tenSP=tenSP;
        this.giaTien=giaTien;
        this.soLuong=soLuong;
        this.dvt=dvt;
        this.thoiGianBH=thoiGianBH;
        this.thanhTien=thanhTien;
    }
    
    public String getTenSP() {
        return tenSP;
    }
    public int getGiaTien() {
        return giaTien;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public String getDVT() {
        return dvt;
    }
    public int getThoiGianBH() {
        return thoiGianBH;
    }
    public int getThanhTien() {
        return thanhTien;
    }
}
