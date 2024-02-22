package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {

    public static int getCountImportToday() {
        return PhieuNhapDAO.getCountImportToDay() + 1;
    }

    public static ArrayList<PhieuNhapDTO> getListPN() {
        ArrayList<PhieuNhapDTO> list = new ArrayList<>();
        for (PhieuNhapDTO x : PhieuNhapDAO.getListPN()) {
            if (x.getXuLy() == 0) {
                list.add(x);
            }
        }
        return list;
    }
    
    public static ArrayList<PhieuNhapDTO> getListPN(int tinhTrang) {
        ArrayList<PhieuNhapDTO> list = new ArrayList<>();
        for (PhieuNhapDTO x : PhieuNhapDAO.getListPN(tinhTrang)) {
            if (x.getXuLy() == 0) {
                list.add(x);
            }
        }
        return list;
    }
    
    public static ArrayList<PhieuNhapDTO> getListPN(String[] fields) {
        ArrayList<PhieuNhapDTO> list = new ArrayList<>();
        for (PhieuNhapDTO x : PhieuNhapDAO.getListPN(fields)) {
            if (x.getXuLy() == 0) {
                list.add(x);
            }
        }
        return list;
    }

    public static PhieuNhapDTO searchPN(String maPN) {
        return PhieuNhapDAO.searchPN(maPN);
    }

    public static ArrayList<Integer> listCount() {
        ArrayList<Integer> listInt = new ArrayList<>();
        int all = 0;
        int yes = 0;
        int no = 0;
        for (PhieuNhapDTO x : getListPN()) {
            if (x.getTinhTrangXuLy() == 0) {
                no += 1;
            } else {
                yes += 1;
            }
            all += 1;
        }
        listInt.add(all);
        listInt.add(yes);
        listInt.add(no);
        return listInt;
    }

    public static String updateXuLy(String maPN) {
        if (PhieuNhapDAO.checkID(maPN)) {
            if (PhieuNhapDAO.updateXuLy(maPN)) {
                return "Phiếu nhập đã xử lý thành công";
            }
            return "Phiếu nhập đã xử lý không thành công";
        }
        return "Mã phiếu nhập không tồn tại";
    }

    public static String deletePN(String maPN) {
        if (PhieuNhapDAO.checkID(maPN)) {
            if (PhieuNhapDAO.deletePN(maPN)) {
                return "Xóa phiếu nhập thành công";
            }
            return "Xóa phiếu nhập không thành công";
        }
        return "Mã phiếu nhập không tồn tại";
    }

    public static String insertPN(PhieuNhapDTO x) {
        if (!PhieuNhapDAO.checkID(x.getMaPN())) {
            if (PhieuNhapDAO.insertPN(x)) {
                return "Thêm phiếu nhập mới thành công";
            }
            return "Thêm phiếu nhập mới không thành công";
        }
        return "Mã phiếu nhập đã tồn tại";
    }

}
