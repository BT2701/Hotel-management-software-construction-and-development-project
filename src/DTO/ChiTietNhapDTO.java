package DTO;

public class ChiTietNhapDTO {

    private String maPN;
    private String maDV;
    private int soLuong;
    private int giaDVNhap;

    public ChiTietNhapDTO() {
    }

    public ChiTietNhapDTO(String maPN, String maDV, int soLuong, int giaDVNhap) {
        this.maPN = maPN;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.giaDVNhap = giaDVNhap;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaDVNhap() {
        return giaDVNhap;
    }

    public void setGiaDVNhap(int giaDVNhap) {
        this.giaDVNhap = giaDVNhap;
    }

}
