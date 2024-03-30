package GUI.GUI_NHANVIEN;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableNhanVien extends JTable {
    
    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
    //Duy
    private ArrayList<NhanVienDTO> listNV= NhanVienBUS.getListNV();
    private   DefaultTableModel dtm = new DefaultTableModel();
    //Duy
    public TableNhanVien() {
        super();
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    
    public void renderTB() {
        dtm.addColumn("STT");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Tên nhân viên");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Ngày vào làm");
        dtm.addColumn("Chức vụ");
        dtm.addColumn("Số ngày phép");
        dtm.addColumn("Lương 1 ngày");
        dtm.addColumn("Email");
        
        for (int i = 0; i < listNV.size(); i++) {
            //Duy
            Object data[]={i+1,listNV.get(i).getMaNV().trim(),listNV.get(i).getTenNV().trim(),listNV.get(i).getGioiTinh().trim(),listNV.get(i).getNgaySinh(),listNV.get(i).getNgayVaoLam(),listNV.get(i).getChucVu().trim(),listNV.get(i).getSoNgayPhep(),listNV.get(i).getLuong1Ngay(),listNV.get(i).getEmail().trim()};
            //Duy
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableNhanVienCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(40);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(180);
        getColumnModel().getColumn(3).setPreferredWidth(50);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(5).setPreferredWidth(100);
        getColumnModel().getColumn(6).setPreferredWidth(80);
        getColumnModel().getColumn(7).setPreferredWidth(80);
        getColumnModel().getColumn(8).setPreferredWidth(100);
        getColumnModel().getColumn(9).setPreferredWidth(150);
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
    
    public void setData(ArrayList<NhanVienDTO> list){
        removeAll();
        int j=1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getXuLy()==0){
                Object data[]={j++,list.get(i).getMaNV().trim(),list.get(i).getTenNV().trim(),list.get(i).getGioiTinh().trim(),list.get(i).getNgaySinh(),list.get(i).getNgayVaoLam(),list.get(i).getChucVu().trim(),list.get(i).getSoNgayPhep(),list.get(i).getLuong1Ngay(),list.get(i).getEmail().trim()};
                dtm.addRow(data);
            }
        }
    }
    
    //Duy
}
