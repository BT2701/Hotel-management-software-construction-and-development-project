package DTO;

public class GiamGiaDTO {

    private String maGG;
    private String ngayBD;
    private String ngayKT;
    private String noiDung;
    private int phanTramGiam;
    private int xuLy;

    public GiamGiaDTO() {
    }

    public GiamGiaDTO(String maGG, String ngayBD, String ngayKT, String noiDung, int phanTramGiam, int xuLy) {
        this.maGG = maGG;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.noiDung = noiDung;
        this.phanTramGiam = phanTramGiam;
        this.xuLy = xuLy;
    }

    public String getMaGG() {
        return maGG;
    }

    public void setMaGG(String maGG) {
        this.maGG = maGG;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
