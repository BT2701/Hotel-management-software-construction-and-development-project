package DTO;

public class ItemDV {

    private String tenDV;
    private String loaiDV;
    private String ngaySD;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public ItemDV() {
    }

    public ItemDV(String tenDV, String loaiDV, String ngaySD, int soLuong, int donGia, int thanhTien) {
        this.tenDV = tenDV;
        this.loaiDV = loaiDV;
        this.ngaySD = ngaySD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(String loaiDV) {
        this.loaiDV = loaiDV;
    }

    public String getNgaySD() {
        return ngaySD;
    }

    public void setNgaySD(String ngaySD) {
        this.ngaySD = ngaySD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ItemDV [tenDV=" + tenDV + ", loaiDV=" + loaiDV + ", ngaySD=" + ngaySD + ", soLuong=" + soLuong
                + ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
    }

}
