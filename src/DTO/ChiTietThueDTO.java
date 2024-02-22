package DTO;

import java.util.Date;

public class ChiTietThueDTO {

    private String maCTT;
    private String maKH;
    private String maNV;
    private String ngayLapPhieu;
    private int tienDatCoc;
    private int tinhTrangXuLy;
    private int xuLy;
    private Date ngayLapPhieu1;
    private java.sql.Date date;

    public ChiTietThueDTO() {
    }

    public ChiTietThueDTO(String maCTT, String maKH, String maNV, String ngayLapPhieu, int tienDatCoc,
            int tinhTrangXuLy, int xuLy) {
        this.maCTT = maCTT;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLapPhieu = ngayLapPhieu;
        this.tienDatCoc = tienDatCoc;
        this.tinhTrangXuLy = tinhTrangXuLy;
        this.xuLy = xuLy;
    }

    public String getMaCTT() {
        return maCTT;
    }

    public void setMaCTT(String maCTT) {
        this.maCTT = maCTT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(String ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public int getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(int tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public int getTinhTrangXuLy() {
        return tinhTrangXuLy;
    }

    public void setTinhTrangXuLy(int tinhTrangXuLy) {
        this.tinhTrangXuLy = tinhTrangXuLy;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = new java.sql.Date(date.getTime());
    }

    public Date getNgayLapPhieu1() {
        return ngayLapPhieu1;
    }

    public void setNgayLapPhieu1(Date ngayLapPhieu) {
        this.ngayLapPhieu1 = ngayLapPhieu;
    }
}
