package DTO;

public class ItemHoaDon {

    private String tenP;
    private int loaiHinhThue;
    private String ngayThue;
    private String ngayTra;
    private String giaThue;

    public ItemHoaDon() {
    }

    public ItemHoaDon(String tenP, int loaiHinhThue, String ngayThue, String ngayTra, String giaThue) {
        this.tenP = tenP;
        this.loaiHinhThue = loaiHinhThue;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.giaThue = giaThue;
    }

    public String getTenP() {
        return tenP;
    }

    public void setTenP(String tenP) {
        this.tenP = tenP;
    }

    public int getLoaiHinhThue() {
        return loaiHinhThue;
    }

    public void setLoaiHinhThue(int loaiHinhThue) {
        this.loaiHinhThue = loaiHinhThue;
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

    public String getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(String giaThue) {
        this.giaThue = giaThue;
    }

    @Override
    public String toString() {
        return "ItemHoaDon [tenP=" + tenP + ", loaiHinhThue=" + loaiHinhThue + ", ngayThue=" + ngayThue + ", ngayTra="
                + ngayTra + ", giaThue=" + giaThue + "]";
    }

}
