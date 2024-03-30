package DTO;

public class KhachHangDTO {

    private String maKH;
    private String tenKH;
    private String CMND;
    private String gioiTinh;
    private String SDT;
    private String queQuan;
    private String quocTich;
    private String ngaySinhString;
    private int xuLy;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String tenKH, String CMND, String gioiTinh, String SDT, String queQuan, String quocTich, String ngaySinhString, int xuLy) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.CMND = CMND;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.queQuan = queQuan;
        this.quocTich = quocTich;
        this.ngaySinhString = ngaySinhString;
        this.xuLy = xuLy;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNgaySinhString() {
        return ngaySinhString;
    }

    public void setNgaySinhString(String ngaySinhString) {
        this.ngaySinhString = ngaySinhString;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
