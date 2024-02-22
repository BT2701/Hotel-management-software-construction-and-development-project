package GUI.GUI_KHACHHANG;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableKhachHang extends JTable {

    public TableKhachHang() {
        super();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void renderTB() {

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("CMND");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Số điện thoại");
        dtm.addColumn("Quê quán");
        dtm.addColumn("Quốc tịch");
        dtm.addColumn("Ngày sinh");
        int pos = 1;
        for (KhachHangDTO x : KhachHangBUS.getListKH()) {
            Object data[] = {pos++, x.getMaKH(), x.getTenKH(), x.getCMND(), x.getGioiTinh(), x.getSDT(), x.getQueQuan(), x.getQuocTich(), x.getNgaySinhString()};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableKhachHangCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(150);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(150);
        getColumnModel().getColumn(4).setPreferredWidth(80);
        getColumnModel().getColumn(5).setPreferredWidth(200);
        getColumnModel().getColumn(6).setPreferredWidth(200);
        getColumnModel().getColumn(7).setPreferredWidth(200);
        getColumnModel().getColumn(8).setPreferredWidth(100);
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
    }
    
    public void renderTB(ArrayList<KhachHangDTO> list) {

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("CMND");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Số điện thoại");
        dtm.addColumn("Quê quán");
        dtm.addColumn("Quốc tịch");
        dtm.addColumn("Ngày sinh");
        int pos = 1;
        for (KhachHangDTO x : list) {
            Object data[] = {pos++, x.getMaKH(), x.getTenKH(), x.getCMND(), x.getGioiTinh(), x.getSDT(), x.getQueQuan(), x.getQuocTich(), x.getNgaySinhString()};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableKhachHangCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(150);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(150);
        getColumnModel().getColumn(4).setPreferredWidth(80);
        getColumnModel().getColumn(5).setPreferredWidth(200);
        getColumnModel().getColumn(6).setPreferredWidth(200);
        getColumnModel().getColumn(7).setPreferredWidth(200);
        getColumnModel().getColumn(8).setPreferredWidth(100);
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
    }

    public void renderTB(String CMND) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("CMND");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Số điện thoại");
        dtm.addColumn("Quê quán");
        dtm.addColumn("Quốc tịch");
        dtm.addColumn("Ngày sinh");
        ArrayList<KhachHangDTO> list = KhachHangBUS.getListKH();
        int pos = 1;
        for (KhachHangDTO x : list) {
            if (x.getCMND().trim().equals(CMND)) {
                Object data[] = {pos++, x.getMaKH(), x.getTenKH(), x.getCMND(), x.getGioiTinh(), x.getSDT(), x.getQueQuan(), x.getQuocTich(), x.getNgaySinhString()};
                dtm.addRow(data);
            }
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableKhachHangCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(150);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(150);
        getColumnModel().getColumn(4).setPreferredWidth(80);
        getColumnModel().getColumn(5).setPreferredWidth(200);
        getColumnModel().getColumn(6).setPreferredWidth(200);
        getColumnModel().getColumn(7).setPreferredWidth(200);
        getColumnModel().getColumn(8).setPreferredWidth(100);
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
    }
}
