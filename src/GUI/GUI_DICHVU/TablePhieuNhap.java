package GUI.GUI_DICHVU;

import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.PhieuNhapDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TablePhieuNhap extends JTable {

    public TablePhieuNhap() {
        super();
        renderTB();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 5) {
            return true;
        }
        return false;
    }

    public void renderTB() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phiếu nhập");
        dtm.addColumn("Tên nhân viên");
        dtm.addColumn("Ngày lập phiếu");
        dtm.addColumn("Tình trạng");
        ArrayList<PhieuNhapDTO> list = PhieuNhapBUS.getListPN();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTinhTrangXuLy() != 0) {
                Object data[] = {i + 1, list.get(i).getMaPN(), NhanVienBUS.getTenNV(list.get(i).getMaNV()), list.get(i).getNgayLapPhieu(), "Đã xử lý"};
                dtm.addRow(data);
            } else {
                Object data[] = {i + 1, list.get(i).getMaPN(), NhanVienBUS.getTenNV(list.get(i).getMaNV()), list.get(i).getNgayLapPhieu(), "Chưa xử lý"};
                dtm.addRow(data);
            }
        }
        setModel(dtm);
        // Sử dụng một renderer chung cho tất cả các cột
        setDefaultRenderer(Object.class, new TablePhieuNhapTableCellRenderer());
        setRowHeight(30);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(200);
        getColumnModel().getColumn(4).setPreferredWidth(150);
        setBorder(new MatteBorder(0,1,0,1,Color.decode("#eeeeee")));
    }
    public void renderTB(ArrayList<PhieuNhapDTO> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phiếu nhập");
        dtm.addColumn("Tên nhân viên");
        dtm.addColumn("Ngày lập phiếu");
        dtm.addColumn("Tình trạng");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTinhTrangXuLy() != 0) {
                Object data[] = {i + 1, list.get(i).getMaPN(), NhanVienBUS.getTenNV(list.get(i).getMaNV()), list.get(i).getNgayLapPhieu(), "Đã xử lý"};
                dtm.addRow(data);
            } else {
                Object data[] = {i + 1, list.get(i).getMaPN(), NhanVienBUS.getTenNV(list.get(i).getMaNV()), list.get(i).getNgayLapPhieu(), "Chưa xử lý"};
                dtm.addRow(data);
            }
        }
        setModel(dtm);
        // Sử dụng một renderer chung cho tất cả các cột
        setDefaultRenderer(Object.class, new TablePhieuNhapTableCellRenderer());
        setRowHeight(30);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(200);
        getColumnModel().getColumn(4).setPreferredWidth(150);
        setBorder(new MatteBorder(0,1,0,1,Color.decode("#eeeeee")));
    }
}
