package BUS;

import DAO.PhongDAO;
import DTO.PhongDTO;
import java.util.ArrayList;

public class PhongBUS {

    public static PhongBUS getInstance() {
        return new PhongBUS();
    }

    //hàm thêm mới ngày 7/11/2023
    public ArrayList<Integer> layDuLieuSoLuongPhongTheoLoai(int nam, int options) {
        return PhongDAO.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, options);
    }

    public static ArrayList<PhongDTO> getListP() {
        ArrayList<PhongDTO> list = new ArrayList<>();
        ArrayList<PhongDTO> listtmp = PhongDAO.getListP();
        for (PhongDTO x : listtmp) {
            if (x.getXuLy() == 0) {
                list.add(x);
            }
        }
        return list;
    }

    public static String insertP(PhongDTO x) {
        if (!PhongDAO.checkID(x.getMaP())) {
            if (PhongDAO.insertP(x)) {
                return "Thêm phòng mới thành công";
            }
            return "Thêm phòng mới không thành công";
        }
        return "Mã phòng đã tồn tại";
    }

    public static int getCountPhong() {
        return PhongDAO.getListP().size() + 1;
    }

    public static boolean updateTT(String maP, int tinhTrang) {
        return PhongDAO.updateTT(maP, tinhTrang);
    }

    public static boolean checkID(String maP) {
        return PhongDAO.checkID(maP);
    }

    public static PhongDTO getP(String maP) {
        if (checkID(maP)) {
            return PhongDAO.getP(maP);
        }
        return new PhongDTO();
    }

    public static ArrayList<PhongDTO> getListP(String datetimeThue, String datetimeTra, boolean check) {
        return PhongDAO.getListPhong(datetimeThue, datetimeTra, check);
    }

    public static boolean delete(String maP, int xuLy) {
        return PhongDAO.getInstance().delete(maP, xuLy);
    }

    public int capNhap(PhongDTO t) {
        return PhongDAO.getInstance().capNhap(t);
    }
}
