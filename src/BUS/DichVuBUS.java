package BUS;

import DAO.DichVuDAO;
import DTO.DichVuDTO;
import java.util.ArrayList;

public class DichVuBUS implements BusInterface<DichVuDTO> {

    public static ArrayList<DichVuDTO> getListDV() {
        ArrayList<DichVuDTO> listDV = new ArrayList<>();
        for (DichVuDTO x : DichVuDAO.getListDV()) {
            if (x.getXuLy() == 0) {
                listDV.add(x);
            }
        }
        return listDV;
    }

    public static String getTenDV(String maDV) {
        String tenDV = "";
        for (DichVuDTO x : DichVuDAO.getListDV()) {
            if (x.getMaDV().equals(maDV)) {
                tenDV += x.getTenDV();
                break;
            }
        }
        return tenDV;
    }

    public static int getSL(String maDV) {
        return DichVuDAO.getSLNhap(maDV);
    }

    public static int getCountTI() {
        return DichVuDAO.getListDV().size();
    }

    public static DichVuDTO searchDV(String maDV) {
        return DichVuDAO.searchDV(maDV);
    }

    public static String insertDV(DichVuDTO x) {
        if (!DichVuDAO.checkID(x.getMaDV())) {
            if (DichVuDAO.insertDV(x)) {
                return "Thêm dịch vụ mới thành công";
            }
            return "Thêm dịch vụ mới không thành công";
        }
        return "Mã dịch vụ đã tồn tại";
    }

    public static String updateDV(DichVuDTO x) {
        if (DichVuDAO.checkID(x.getMaDV())) {
            if (DichVuDAO.updateDV(x)) {
                return "Sửa dịch vụ thành công";
            }
            return "Sửa dịch vụ không thành công";
        }
        return "Mã dịch vụ không tồn tại";
    }

    public static String deleteDV(String maDV) {
        if (DichVuDAO.checkID(maDV)) {
            if (DichVuDAO.deleteDV(maDV)) {
                return "Xóa dịch vụ thành công";
            }
            return "Xóa dịch vụ không thành công";
        }
        return "Mã dịch vụ không tồn tại";
    }

    public static int updateSL(String maDV, int SL) {
        if (DichVuDAO.updateSL(maDV, SL)) {
            return 1;
        }
        return 0;
    }

    public static DichVuBUS getInstance() {
        return new DichVuBUS();
    }

    @Override
    public ArrayList<DichVuDTO> getList() {
        // TODO Auto-generated method stub
        return DichVuDAO.getInstance().selectAll();
    }

    @Override
    public void saveData(DichVuDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public DichVuDTO getByID(DichVuDTO t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inSert(DichVuDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void upDate(DichVuDTO t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(DichVuDTO t) {
        // TODO Auto-generated method stub

    }
}
