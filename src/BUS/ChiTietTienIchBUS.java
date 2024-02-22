package BUS;

import DAO.ChiTietTienIchDAO;
import DTO.ChiTietTienIchDTO;
import DTO.TienIchDTO;
import java.util.ArrayList;

public class ChiTietTienIchBUS {

    public static int insertCTTI(ChiTietTienIchDTO x) {
        if (ChiTietTienIchDAO.insertCTTI(x)) {
            return 1;
        }
        return 0;
    }

    public static int laySoLuongTienIchHienTai(String maP, String maTI) {
        return ChiTietTienIchDAO.laySoLuongTienIchHienTai(maP, maTI);
    }

    public static boolean capNhatSL(String maP, String maTI, int soLuong) {
        return ChiTietTienIchDAO.capNhatSL(maP, maTI, soLuong);
    }

    public static ChiTietTienIchBUS getInstance() {
        return new ChiTietTienIchBUS();
    }

    public ArrayList<TienIchDTO> layDStienIchBangMaPhong(String maP) {
        return ChiTietTienIchDAO.getInstance().layDStienIchBangMaPhong(maP);
    }

    public ArrayList<ChiTietTienIchDTO> selectAll() {
        return ChiTietTienIchDAO.getInstance().selectAll();
    }
}
