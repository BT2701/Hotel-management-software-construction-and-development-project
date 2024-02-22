package DTO;

import java.util.Date;

public class ChiTietThuePhongDTO {

    private String maCTT;
    private String maP;
    private String ngayThue;
    private String ngayTra;
    private String ngayCheckOut;
    private int loaiHinhThue;
    private int giaThue;
    private int tinhTrang;
    private Date ngayThue1;
    private Date ngayTra1;
    private Date ngayCheckOut1;
    private java.sql.Date dateThue, dateTra, dateCheckOut;

    public ChiTietThuePhongDTO() {
    }

    public ChiTietThuePhongDTO(String maCTT, String maP, String ngayThue, String ngayTra, String ngayCheckOut,
            int loaiHinhThue, int giaThue, int tinhTrang) {
        this.maCTT = maCTT;
        this.maP = maP;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.ngayCheckOut = ngayCheckOut;
        this.loaiHinhThue = loaiHinhThue;
        this.giaThue = giaThue;
        this.tinhTrang = tinhTrang;
    }

    public String getMaCTT() {
        return maCTT;
    }

    public void setMaCTT(String maCTT) {
        this.maCTT = maCTT;
    }

    public String getMaP() {
        return maP;
    }

    public void setMaP(String maP) {
        this.maP = maP;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getNgayCheckOut() {
        return ngayCheckOut;
    }

    public void setNgayCheckOut(String ngayCheckOut) {
        this.ngayCheckOut = ngayCheckOut;
    }

    public int getLoaiHinhThue() {
        return loaiHinhThue;
    }

    public void setLoaiHinhThue(int loaiHinhThue) {
        this.loaiHinhThue = loaiHinhThue;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Date getNgayThue1() {
        return ngayThue1;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue1 = ngayThue;
    }

    public Date getNgayTra1() {
        return ngayTra1;
    }

    public void setNgayTra1(Date ngayTra) {
        this.ngayTra1 = ngayTra;
    }

    public Date getNgayCheckOut1() {
        return ngayCheckOut1;
    }

    public void setNgayCheckOut1(Date ngayCheckOut) {
        this.ngayCheckOut1 = ngayCheckOut;
    }

    public java.sql.Date getDateThue() {
        return dateThue;
    }

    public void setDateThue(Date dateThue) {
        this.dateThue = new java.sql.Date(dateThue.getTime());
    }

    public java.sql.Date getDateTra() {
        return dateTra;
    }

    public void setDateTra(Date dateTra) {
        this.dateTra = new java.sql.Date(dateTra.getTime());
    }

    public java.sql.Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = new java.sql.Date(dateCheckOut.getTime());
    }

}
