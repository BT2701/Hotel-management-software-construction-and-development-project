/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author SYN
 */
public class TaiKhoanBUS {
    
    //FUNCTION FROM TRƯỞNG
    //BEGIN
    public static NhanVienBUS getIntance() {
        return new NhanVienBUS();
    }

    public ArrayList<TaiKhoanDTO> getList() {
//      listNV = dataListNV.selectAll();
        return TaiKhoanDAO.getInstance().getListNV();
    }

    //END

    public static ArrayList<TaiKhoanDTO> getListNV() {
        ArrayList<TaiKhoanDTO> list = new ArrayList<>();
        for (TaiKhoanDTO x : TaiKhoanDAO.getListNV()) { //k can loc tinh trang
                list.add(x);
        }
        return list;
    }

    public static String insertTK(TaiKhoanDTO x) {
        if (!TaiKhoanDAO.checkID(x.getTaiKhoan())) {
            if (TaiKhoanDAO.insertTK(x)) {
                return "Thêm tài khoản mới thành công";
            }
            return "Thêm tài khoản mới không thành công";
        }
        return "Tài khoản đã tồn tại";
    }

    public static String lockTK(String taiKhoan) {
        if (TaiKhoanDAO.checkID(taiKhoan)) {
            if (TaiKhoanDAO.lockTK(taiKhoan)) {
                return "Khóa tài khoản có Tài khoản: " + taiKhoan + " thành công!";
            }
            return "Khóa tài khoản có Tài khoản: " + taiKhoan + " thất bại!";
        }
        return "Tài khoản không tồn tại";
    }

    public static String updateTK(TaiKhoanDTO x) {
        if (TaiKhoanDAO.checkID(x.getTaiKhoan())) {
            if (TaiKhoanDAO.updateTK(x)) {
                return "Cập nhật tài khoản thành công";
            }
            return "Cập nhật tài khoản thất bại";
        }
        return "Tài khoản không tồn tại";
    }
    //Duy
    public static ArrayList<TaiKhoanDTO> searchTK(boolean[] attri,String[] values, String top, String order){
        ArrayList<TaiKhoanDTO> list= new ArrayList<>();
        
        for (TaiKhoanDTO x : TaiKhoanDAO.searchTK(attri, values, top, order)) {
               list.add(x);
       }
       return list;
    }
    //Duy
    
    public static ArrayList<TaiKhoanDTO> getAllList() {
        return TaiKhoanDAO.getAllTaiKhoan();
    }
    
    public static boolean changePassword(String tk, String mk) {
        return TaiKhoanDAO.changePassword(tk, mk);
    }
}
