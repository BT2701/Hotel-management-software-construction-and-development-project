package DTO;

public class ChiTietThueDichVuDTO {

    private String maCTT;
    private String maDV;
    private String ngaySuDung;
    private int soLuong;
    private int giaDV;

    public ChiTietThueDichVuDTO() {
    }

    public ChiTietThueDichVuDTO(String maCTT, String maDV, String ngaySuDung, int soLuong, int giaDV) {
        this.maCTT = maCTT;
        this.maDV = maDV;
        this.ngaySuDung = ngaySuDung;
        this.soLuong = soLuong;
        this.giaDV = giaDV;
    }

    public String getMaCTT() {
        return maCTT;
    }

    public void setMaCTT(String maCTT) {
        this.maCTT = maCTT;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(String ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(int giaDV) {
        this.giaDV = giaDV;
    }

}
