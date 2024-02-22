package BUS;

import java.util.ArrayList;

import DAO.ChiTietThueDAO;
import DTO.ChiTietThueDTO;

public class ChiTietThueBUS implements BusInterface<ChiTietThueDTO> {

    public static ChiTietThueBUS getInstance() {
        return new ChiTietThueBUS();
    }

    public static int soLanKhachThue(String maKH) {
        return ChiTietThueDAO.soLanKhachThue(maKH);
    }
    
    public static int capNhatTinhTrangXL(String maCTT,int tinhTrangXL,int xl) {
    	return ChiTietThueDAO.capNhatTinhTrangXL(maCTT, tinhTrangXL, xl);
    }

    @Override
    public ArrayList<ChiTietThueDTO> getList() {
        // TODO Auto-generated method stub
        return ChiTietThueDAO.getInstance().selectAll();
    }

    @Override
    public void saveData(ChiTietThueDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public ChiTietThueDTO getByID(ChiTietThueDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    public ChiTietThueDTO selectById(String maCTT) {
        return ChiTietThueDAO.getInstance().selectById(maCTT);
    }

    @Override
    public void inSert(ChiTietThueDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void upDate(ChiTietThueDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(ChiTietThueDTO t) {
        // TODO Auto-generated method stub

    }

    public static String insertCTT(ChiTietThueDTO x) {
        if (!ChiTietThueDAO.checkID(x.getMaCTT())) {
            if (ChiTietThueDAO.insertCTT(x)) {
                return "Thêm phiếu thuê mới thành công";
            }
            return "Thêm phiếu thuê mới không thành công";
        }
        return "Mã chi tiết thuê đã tồn tại";
    }

    public static int countCTT() {
        return ChiTietThueDAO.countCTT();
    }

    public static ChiTietThueDTO getCTT(String maCTT) {
        return ChiTietThueDAO.getCTT(maCTT);
    }
}
