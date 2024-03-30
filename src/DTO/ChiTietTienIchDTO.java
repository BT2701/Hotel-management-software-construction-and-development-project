package DTO;

public class ChiTietTienIchDTO {

    private String maP;
    private String maTI;
    private int soLuong;

    public ChiTietTienIchDTO() {
    }

    public ChiTietTienIchDTO(String maP, String maTI, int soLuong) {
        this.maP = maP;
        this.maTI = maTI;
        this.soLuong = soLuong;
    }

    public String getMaP() {
        return maP;
    }

    public void setMaP(String maP) {
        this.maP = maP;
    }

    public String getMaTI() {
        return maTI;
    }

    public void setMaTI(String maTI) {
        this.maTI = maTI;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
