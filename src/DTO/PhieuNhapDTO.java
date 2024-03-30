package DTO;

public class PhieuNhapDTO {

    private String maPN;
    private String maNV;
    private String ngayLapPhieu;
    private int tinhTrangXuLy;
    private int xuLy;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String maPN, String maNV, String ngayLapPhieu, int tinhTrangXuLy, int xuLy) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.ngayLapPhieu = ngayLapPhieu;
        this.tinhTrangXuLy = tinhTrangXuLy;
        this.xuLy = xuLy;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
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

}
