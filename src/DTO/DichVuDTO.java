package DTO;

public class DichVuDTO {

    private String maDV;
    private String tenDV;
    private String loaiDV;
    private String hinhAnh;
    private int soLuong;
    private int giaDV;
    private int xuLy;

    public DichVuDTO() {
    }

    public DichVuDTO(String maDV, String tenDV, String loaiDV, String hinhAnh, int soLuong, int giaDV, int xuLy) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.loaiDV = loaiDV;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.giaDV = giaDV;
        this.xuLy = xuLy;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
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

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
