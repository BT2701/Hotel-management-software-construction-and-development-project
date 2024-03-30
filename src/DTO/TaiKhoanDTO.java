package DTO;

public class TaiKhoanDTO {

    private String taiKhoan;
    private String maNV;
    private String matKhau;
    private int tinhTrang;
    private String vaiTro;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String taiKhoan, String maNV, String matKhau, int tinhTrang, String vaiTro) {
        this.taiKhoan = taiKhoan;
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
        this.vaiTro = vaiTro;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

}
