package computerpartsstoremanagement;

class Staff {
    private String maNV, tenNV;
    private int doanhThu;
    
    public Staff(String maNV, String tenNV, int doanhThu){
        this.maNV=maNV;
        this.tenNV=tenNV;
        this.doanhThu=doanhThu;
    }
    
    public String getMaNV() {
        return maNV;
    }
    public String getTenNV() {
        return tenNV;
    }
    public int getDoanhThu() {
        return doanhThu;
    }
}
