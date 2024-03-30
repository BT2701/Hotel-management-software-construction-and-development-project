package DTO;

public class KhuyenMaiDTO {

    private String maKM;
    private String ngayBD;
    private String ngayKT;
    private String noiDung;
    private int xuLy;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String maKM, String ngayBD, String ngayKT, String noiDung, int xuLy) {
        this.maKM = maKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.noiDung = noiDung;
        this.xuLy = xuLy;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
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

    public int getXuLy() {
        return xuLy;
    }

    public void setXuLy(int xuLy) {
        this.xuLy = xuLy;
    }

}
