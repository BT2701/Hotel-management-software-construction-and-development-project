package DTO;

public class ChiTietKhuyenMaiDTO {

    private String maKH;
    private String maDV;

    public ChiTietKhuyenMaiDTO() {
    }

    public ChiTietKhuyenMaiDTO(String maKH, String maDV) {
        this.maKH = maKH;
        this.maDV = maDV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

}
