package BUS;

import DAO.ChiTietNhapDAO;
import DTO.ChiTietNhapDTO;
import java.util.ArrayList;

public class ChiTietNhapBUS {

    public static ChiTietNhapBUS getInstance() {
        return new ChiTietNhapBUS();
    }

    public long layTongChi() {
        return ChiTietNhapDAO.getInstance().layTongChi();
    }

    public double layTongChiTheoNgay(int ngay, int thang, int nam) {
        return ChiTietNhapDAO.getInstance().layTongChiTheoNgay(ngay, thang, nam);
    }

    public static int insertCTN(ChiTietNhapDTO x) {
        if (ChiTietNhapDAO.insertCTPN(x)) {
            return 1;
        }
        return 0;
    }

    public static ArrayList<ChiTietNhapDTO> getList(String maPN) {
        return ChiTietNhapDAO.getListCTN(maPN);
    }

    public static String deleteCTN(String maPN, String maDV) {
        if (ChiTietNhapDAO.deleteCTN(maPN, maDV)) {
            return "Xóa dịch vụ thành công";
        }
        return "Xóa dịch vụ không thành công";
    }

    public static String updateCTN(ChiTietNhapDTO x) {
        if (ChiTietNhapDAO.updateCTN(x)) {
            return "Sửa dịch vụ thành công";
        }
        return "Sửa dịch vụ không thành công";
    }

}
