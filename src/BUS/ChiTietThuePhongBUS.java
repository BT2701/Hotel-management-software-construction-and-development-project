package BUS;

import java.util.ArrayList;

import DAO.ChiTietThuePhongDAO;
import DTO.ChiTietThuePhongDTO;

public class ChiTietThuePhongBUS implements BusInterface<ChiTietThuePhongDTO> {

    public static ChiTietThuePhongBUS getInstance() {
        return new ChiTietThuePhongBUS();
    }
    
    public static int capNhatTinhTrang(String maCTT,int tinhTrang) {
    	return ChiTietThuePhongDAO.capNhatTinhTrang(maCTT, tinhTrang);
    }

    @Override
    public ArrayList<ChiTietThuePhongDTO> getList() {
        // TODO Auto-generated method stub
        return ChiTietThuePhongDAO.getInstance().selectAll();
    }

    @Override
    public void saveData(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public ChiTietThuePhongDTO getByID(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inSert(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void upDate(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(ChiTietThuePhongDTO t) {
        // TODO Auto-generated method stub

    }

    public static String insertCTT(ChiTietThuePhongDTO x) {
        if (ChiTietThuePhongDAO.insertCTTP(x)) {
            return "Thêm chi tiết thuê phòng mới thành công";
        }
        return "Thêm chi tiết thuê phòng mới không thành công";
    }

    public static ArrayList<ChiTietThuePhongDTO> getListTPofCTT(String maCTT) {
        return ChiTietThuePhongDAO.getListTPofCTT(maCTT);
    }

    public static int count(String maCTT) {
        return ChiTietThuePhongDAO.count(maCTT);
    }

    public static boolean deleteCTTPhong(String maCTT, String maP, String dateTimeThue) {
        return ChiTietThuePhongDAO.deleteCTTPhong(maCTT, maP, dateTimeThue);
    }

    public static boolean updateTT(String maCTT, String maP, String dateTimeThue, int tt) {
        return ChiTietThuePhongDAO.updateTT(maCTT, maP, dateTimeThue, tt);
    }

    public static boolean updateCK(String maCTT, String maP, String dateTimeThue, String dateCheckOut) {
        return ChiTietThuePhongDAO.updateCK(maCTT, maP, dateTimeThue, dateCheckOut);
    }

    public static boolean updateT(String maCTT, String maP, String dateTimeThue, String dateNgayTra) {
        return ChiTietThuePhongDAO.updateT(maCTT, maP, dateTimeThue, dateNgayTra);
    }

    public ChiTietThuePhongDTO selectByMaPhong(String maP) {
        return ChiTietThuePhongDAO.getInstance().selectByMaPhong(maP);
    }
}
