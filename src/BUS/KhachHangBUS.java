package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class KhachHangBUS {

    //FUNCTION FROM TRƯỞNG
    //BEGIN
    private ArrayList<KhachHangDTO> listkh = KhachHangDAO.getIntance().selectAll();

    public static KhachHangBUS getIntance() {
        return new KhachHangBUS();
    }

    public int getMaKHmoiNhat() {
        int maKHmoiNhat = 0;
        for (KhachHangDTO khachHang : KhachHangDAO.getIntance().selectAll()) {
            String txtmaKH = khachHang.getMaKH();
            int maKH = Integer.parseInt(txtmaKH);
            if (maKH > maKHmoiNhat) {
                maKHmoiNhat = maKH;
            }
        }
        return maKHmoiNhat;
    }

    public void inSert(KhachHangDTO t) {
        KhachHangDAO.getIntance().them(t);
    }

    public ArrayList<KhachHangDTO> getList() {
        return listkh;
//        return KhachHangDAO.getIntance().selectAll();
    }
    
    public static ArrayList<KhachHangDTO> GetAllList(String search) {
        return KhachHangDAO.selectAll(search);
    }

    public KhachHangDTO selectById(String makh) {
        return KhachHangDAO.getIntance().selectById(makh);
    }

    //END
    public void capNhat(KhachHangDTO kh) { //-----------------sửa
        KhachHangDAO.getIntance().capNhap(kh);
    }

    public boolean delete(KhachHangDTO kh) { //------------xóa
        if (kh.getMaKH().equals("")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng để xóa", "ERROR_MESSAGE", 1);
            return false;
        }
        if (KhachHangDAO.getIntance().xoa(kh) == 1) {
            JOptionPane.showMessageDialog(null, "Xóa thành công", "INFORMATION_MESSAGE", 2);
            return true;
        }

        JOptionPane.showMessageDialog(null, "Xóa thất bại", "ERROR_MESSAGE", 1);
        return false;
    }

    public ArrayList<String> getDsMaKh() { // lấy makh cho vào 1 danh sách
        ArrayList<String> listMaKH = new ArrayList<>();
        for (KhachHangDTO kh : getList()) {
            listMaKH.add(kh.getMaKH());
        }
        return listMaKH;
    }

    public ArrayList<String> getDsDiaChi() { //Lấy địa chỉ kh ra cho vào 1 ds
        ArrayList<String> listDiaChi = new ArrayList<>();
        for (KhachHangDTO kh : getList()) {
            listDiaChi.add(kh.getQueQuan());
        }
        return listDiaChi;
    }

    public KhachHangDTO getMaKH(String maKH) { // tìm kiếm theo mã khách hàng
        KhachHangDTO khachHang = null;
        for (KhachHangDTO kh : getList()) {
            if (kh.getMaKH().equalsIgnoreCase(maKH)) {
                khachHang = kh;
            }
        }
        return khachHang;
    }

    public ArrayList<KhachHangDTO> getDiaChiKH(String diaChi) {
        ArrayList<KhachHangDTO> listKhachHang = new ArrayList<>();
        for (KhachHangDTO kh : getList()) {
            if (kh.getQueQuan().equalsIgnoreCase(diaChi)) {
                listKhachHang.add(kh);
            }
        }
        return listKhachHang;
    }

    ////FUNCTION FROM TRƯỞNG
    public String layTenBangMa(String makh) {
        String ten = null;
        for (KhachHangDTO dto_KhachHang : getList()) {
            if (makh.equalsIgnoreCase(dto_KhachHang.getMaKH())) {
                ten = dto_KhachHang.getTenKH();
            }
        }
        return ten;
    }

    public static ArrayList<KhachHangDTO> getListKH() {
        ArrayList<KhachHangDTO> listKH = new ArrayList<>();
        for (KhachHangDTO x : KhachHangDAO.getListKH()) {
            if (x.getXuLy() == 0) {
                listKH.add(x);
            }
        }
        return listKH;
    }

    public static int getCountKH() {
        return KhachHangDAO.getListKH().size();
    }

    public static String insertKH(KhachHangDTO x) {
        if (!KhachHangDAO.checkID(x.getMaKH())) {
            if (KhachHangDAO.insertKH(x)) {
                return "Thêm khách hàng mới thành công";
            }
            return "Thêm khách hàng mới không thành công";
        }
        return "Mã khách hàng đã tồn tại";
    }

    public static int countKH() {
        return KhachHangDAO.countKH();
    }

    public static String updateKH(KhachHangDTO x) {
        if (KhachHangDAO.checkID(x.getMaKH())) {
            if (KhachHangDAO.updateKH(x)) {
                return "Sửa khách hàng thành công";
            }
            return "Sửa khách hàng không thành công";
        }
        return "Mã khách hàng không tồn tại";
    }

    public static String deleteKH(String maKH) {
        if (KhachHangDAO.checkID(maKH)) {
            if (KhachHangDAO.deleteKH(maKH)) {
                return "Xóa khách hàng thành công";
            }
            return "Xóa khách hàng không thành công";
        }
        return "Mã khách hàng không tồn tại";
    }

    public static KhachHangDTO getKH(String maKH) {
        if (checkID(maKH)) {
            return KhachHangDAO.getKH(maKH);
        }
        return new KhachHangDTO();
    }

    public static boolean checkID(String maKH) {
        return KhachHangDAO.checkID(maKH);
    }

    //hàm thêm mới 5/11/2023
    public int laySoLuongKH() {
        return KhachHangDAO.getIntance().laySoLuongKH();
    }

}
