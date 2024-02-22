package DTO;

public class NhanVienDTO {

    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private int soNgayPhep;
    private String chucVu;
    private String ngaySinh;
    private String ngayVaoLam;
    private String email;
    private int luong1Ngay;
    private int xuLy;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String tenNV, String gioiTinh, int soNgayPhep, String chucVu, String ngaySinh, String ngayVaoLam, String email, int luong1Ngay, int xuLy) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.soNgayPhep = soNgayPhep;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.email = email;
        this.luong1Ngay = luong1Ngay;
        this.xuLy = xuLy;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoNgayPhep() {
        return soNgayPhep;
    }

    public void setSoNgayPhep(int soNgayPhep) {
        this.soNgayPhep = soNgayPhep;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(int luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
