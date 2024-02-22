package GUI;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import GUI.GUI_FUNCTION_ACCOUNT.FormLoading;
import GUI.GUI_FUNCTION_ACCOUNT.FormLogin;

public class mainGUI {

    public static NhanVienDTO nv = new NhanVienDTO();
    public static void main(String[] args) {
    	FormLoading frm = new FormLoading();
    	frm.run();
    }
}
