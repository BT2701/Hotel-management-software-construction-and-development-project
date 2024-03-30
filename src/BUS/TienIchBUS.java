package BUS;

import DAO.TienIchDAO;
import DTO.TienIchDTO;
import java.util.ArrayList;

public class TienIchBUS {

    public static ArrayList<TienIchDTO> getListTI() {
        ArrayList<TienIchDTO> listTI = new ArrayList<>();
        for (TienIchDTO x : TienIchDAO.getList()) {
            if (x.getXuLy() == 0) {
                listTI.add(x);
            }
        }
        return listTI;
    }

    public static int getCountTI() {
        return TienIchDAO.getList().size();
    }

    public static String insertTI(TienIchDTO x) {
        if (!TienIchDAO.checkID(x.getMaTI())) {
            if (TienIchDAO.insertTI(x)) {
                return "Thêm tiện ích mới thành công";
            }
            return "Thêm tiện ích mới không thành công";
        }
        return "Mã tiện ích đã tồn tại";
    }

    public static String updateTI(TienIchDTO x) {
        if (TienIchDAO.checkID(x.getMaTI())) {
            if (TienIchDAO.updateTI(x)) {
                return "Sửa tiện ích thành công";
            }
            return "Sửa tiện ích không thành công";
        }
        return "Mã tiện ích không tồn tại";
    }

    public static String deleteTI(String maTI) {
        if (TienIchDAO.checkID(maTI)) {
            if (TienIchDAO.deleteTI(maTI)) {
                return "Xóa tiện ích thành công";
            }
            return "Xóa tiện ích không thành công";
        }
        return "Mã tiện ích không tồn tại";
    }

    public static int updateSL(String maTI, int SL) {
        if (TienIchDAO.updateSL(maTI, SL)) {
            return 1;
        }
        return 0;
    }

    public static boolean capNhatSL(String maTI, int soLuong) {
        return TienIchDAO.capNhatSL(maTI, soLuong);
    }

    public static int getSL(String maTI) {
        return TienIchDAO.getSL(maTI);
    }
    
    public static boolean checkID(String maTI) {
        return TienIchDAO.checkID(maTI);
    }
}
