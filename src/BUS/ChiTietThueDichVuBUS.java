package BUS;

import DAO.ChiTietThueDichVuDAO;
import DTO.ChiTietThueDichVuDTO;
import java.util.ArrayList;

public class ChiTietThueDichVuBUS {

    public static int insertCTT(ChiTietThueDichVuDTO x) {
        int check = 0;
        if (ChiTietThueDichVuDAO.checkCTTDV(x.getMaCTT(), x.getMaDV(), x.getNgaySuDung())) {
            if (ChiTietThueDichVuDAO.updateCTTDV(x.getMaCTT(), x.getMaDV(), x.getNgaySuDung(), x.getSoLuong())) {
                check = 1;
            }
        } else {
            if (ChiTietThueDichVuDAO.insertCTTDV(x)) {
                check = 1;
            }
        }
        return check;
    }
    
    public static boolean UpdateCTTDV(String maCTT, String maDV, String ngaySuDung, int sl) {
        return ChiTietThueDichVuDAO.updateCTTDV2(maCTT, maDV, ngaySuDung, sl);
    }

    public static ArrayList<ChiTietThueDichVuDTO> getListTDVofCTT(String maCTT) {
        return ChiTietThueDichVuDAO.getListTDVofCTT(maCTT);
    }
    
    public static boolean deleteCTTDV(String maCTT, String maDV, String dateTimeSuDung) {
        return ChiTietThueDichVuDAO.deleteCTTDV(maCTT, maDV, dateTimeSuDung);
    }
}
