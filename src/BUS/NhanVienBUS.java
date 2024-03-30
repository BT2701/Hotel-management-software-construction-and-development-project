package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {

    //FUNCTION FROM TRƯỞNG
    //BEGIN
    public static NhanVienBUS getIntance() {
        return new NhanVienBUS();
    }

    public ArrayList<NhanVienDTO> getList() {
//      listNV = dataListNV.selectAll();

        return NhanVienDAO.getInstance().getListNV();

    }

    public String layTenNVtheoMA(String maNV) {
        String tenNV = "";
        for (NhanVienDTO tnv : getList()) {
            if (tnv.getMaNV().equalsIgnoreCase(maNV)) {
                tenNV = tnv.getTenNV();
            }
        }
        return tenNV;
    }
    //END

    public static ArrayList<NhanVienDTO> getListNV() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        for (NhanVienDTO x : NhanVienDAO.getListNV()) {
            if (x.getXuLy() == 0) {
                //check nhan vien chua xoa
                list.add(x);
            }
        }
        return list;
    }

    public static String getTenNV(String maNV) {
        String tenNV = "";
        for (NhanVienDTO x : NhanVienDAO.getListNV()) {
            if (x.getMaNV().trim().equals(maNV.trim())) {
                tenNV += x.getTenNV();
                break;
            }
        }
        return tenNV;
    }

    public static String insertNV(NhanVienDTO x) {
        if (!NhanVienDAO.checkID(x.getMaNV())) {
            if (NhanVienDAO.insertNV(x)) {
                return "Thêm nhân viên mới thành công";
            }
            return "Thêm nhân viên mới không thành công";
        }
        return "Mã nhân viên đã tồn tại";
    }

    public static boolean checkID(String maNV) {
        return NhanVienDAO.checkID(maNV);
    }

    public static String deletNV(String maNV) {
        if (NhanVienDAO.checkID(maNV)) {
            if (NhanVienDAO.deleteNV(maNV)) {
                return "Xóa nhân viên có mã nhân viên: " + maNV + " thành công!";
            }
            return "Xóa nhân viên có mã nhân viên: " + maNV + " thất bại!";
        }
        return "Mã nhân viên không tồn tại";
    }

    public static String updateNV(NhanVienDTO x) {
        if (NhanVienDAO.checkID(x.getMaNV())) {
            if (NhanVienDAO.updateNV(x)) {
                return "Cập nhật nhân viên thành công";
            }
            return "Cập nhật nhân viên thất bại";
        }
        return "Mã nhân viên không tồn tại";
    }

    public static NhanVienDTO getNV(String maNV) {
        if (checkID(maNV)) {
            return NhanVienDAO.getNV(maNV);
        }
        return new NhanVienDTO();
    }

    //Duy
    public static ArrayList<NhanVienDTO> searchNV(boolean[] attri, String[] values, String top, String order) {
        ArrayList<NhanVienDTO> list = new ArrayList<>();

        for (NhanVienDTO x : NhanVienDAO.searchNV(attri, values, top, order)) {
            //if (x.getXuLy() == 0) {
            //check nhan vien chua xoa
            list.add(x);
            //}
        }
        return list;
    }
    //Duy
}
