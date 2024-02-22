package GUI.GUI_NHANVIEN;

import BUS.TaiKhoanBUS;
import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import DTO.TaiKhoanDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableTaiKhoan extends JTable {
    
    //Duy
    private ArrayList<TaiKhoanDTO> listNV= TaiKhoanBUS.getListNV();
    private   DefaultTableModel dtm = new DefaultTableModel();
    //Duy
    public TableTaiKhoan() {
        super();
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    
    public void renderTB() {
        dtm.addColumn("STT");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Tài khoản");
        dtm.addColumn("Vai trò");
        dtm.addColumn("Tình trạng");
        String tinhTrangTmp = null;
        for (int i = 0; i < listNV.size(); i++) {
            switch(listNV.get(i).getTinhTrang()){
                case 1: tinhTrangTmp="Khóa";
                    break;
                case 0: tinhTrangTmp="Mở";
                    break;
                case -1: tinhTrangTmp="Chưa mở";
                default: 
                    break;
            }
            //Duy
            Object data[]={i+1,listNV.get(i).getMaNV().trim(),listNV.get(i).getTaiKhoan().trim(),listNV.get(i).getVaiTro().trim(),tinhTrangTmp};
            //Duy
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableTaiKhoanCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(40);
        getColumnModel().getColumn(1).setPreferredWidth(150);
        getColumnModel().getColumn(2).setPreferredWidth(100);
        getColumnModel().getColumn(3).setPreferredWidth(100);
        getColumnModel().getColumn(4).setPreferredWidth(150);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#EEEEEE")));
    }
    //Duy
    public  void removeAll(){
        int rowCount = dtm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }
    
    public void setData(ArrayList<TaiKhoanDTO> list){
        removeAll();
        int j=1;
        String tinhTrangTmp = null;
        for (int i = 0; i < list.size(); i++) {
           switch(list.get(i).getTinhTrang()){
                case 1: tinhTrangTmp="Khóa";
                    break;
                case 0: tinhTrangTmp="Mở";
                    break;
                case -1: tinhTrangTmp="Chưa mở";
                default: 
                    break;
            }
            Object data[]={i+1,list.get(i).getMaNV().trim(),list.get(i).getTaiKhoan().trim(),list.get(i).getVaiTro().trim(),tinhTrangTmp};
            dtm.addRow(data);
        }
    }
    
    //Duy
}
