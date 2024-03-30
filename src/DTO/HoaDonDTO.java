package DTO;

import java.util.Date;

public class HoaDonDTO {

    private String maHD;
    private String maCTT;
    private int tienP;
    private int tienDV;
    private int giamGia;
    private int phuThu;
    private int tongTien;
    private String ngayThanhToan;
    private String phuongThucThanhToan;
    private int xuLy;
//    private java.sql.Date date;

    public HoaDonDTO() {

    }

    public HoaDonDTO(String maHD, String maCTT, int tienP, int tienDV, int giamGia, int phuThu, int tongTien, String ngayThanhToan, String phuongThucThanhToan, int xuLy) {
        this.maHD = maHD;
        this.maCTT = maCTT;
        this.tienP = tienP;
        this.tienDV = tienDV;
        this.giamGia = giamGia;
        this.phuThu = phuThu;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.xuLy = xuLy;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaCTT() {
        return maCTT;
    }

    public void setMaCTT(String maCTT) {
        this.maCTT = maCTT;
    }

    public int getTienP() {
        return tienP;
    }

    public void setTienP(int tienP) {
        this.tienP = tienP;
    }

    public int getTienDV() {
        return tienDV;
    }

    public void setTienDV(int tienDV) {
        this.tienDV = tienDV;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(int phuThu) {
        this.phuThu = phuThu;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
