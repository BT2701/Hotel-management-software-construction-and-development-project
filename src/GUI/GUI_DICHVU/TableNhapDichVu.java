package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import DTO.DichVuDTO;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableNhapDichVu extends JTable {

    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
    ButtonEditorDV editor = new ButtonEditorDV(new JCheckBox());

    public TableNhapDichVu() {
        super();
        renderTB();
    }

    public ButtonEditorDV getColumnEdit() {
        return editor;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 6) {
            return true;
        }
        return false;
    }

    public void renderTB() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return Boolean.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }
        };
        dtm.addColumn("STT");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Đơn giá bán");
        dtm.addColumn("Tồn kho");
        dtm.addColumn("Đang nhập");
        dtm.addColumn("Chức năng");
        ArrayList<DichVuDTO> list = new ArrayList<>();
        list = DichVuBUS.getListDV();
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLoaiDV().equals("Thức ăn đồ uống")) {
                Object data[] = {++k, list.get(i).getMaDV(), list.get(i).getTenDV(), dcf.format(list.get(i).getGiaDV()), list.get(i).getSoLuong(), DichVuBUS.getSL(list.get(i).getMaDV()), "Thêm"};
                dtm.addRow(data);
            }
        }
        setModel(dtm);
        // Sử dụng một renderer riêng cho cột 
        getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        getColumnModel().getColumn(6).setCellEditor(editor);
        // Sử dụng một renderer chung cho tất cả các cột
        setDefaultRenderer(Object.class, new TableDichVuNhapTableCellRenderer());
        setRowHeight(30);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(100);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(5).setPreferredWidth(100);
        getColumnModel().getColumn(6).setPreferredWidth(100);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#EEEEEE")));
    }
    public void renderTB(ArrayList<DichVuDTO> list) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return Boolean.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }
        };
        dtm.addColumn("STT");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Đơn giá bán");
        dtm.addColumn("Tồn kho");
        dtm.addColumn("Đang nhập");
        dtm.addColumn("Chức năng");
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLoaiDV().equals("Thức ăn đồ uống")) {
                Object data[] = {++k, list.get(i).getMaDV(), list.get(i).getTenDV(), dcf.format(list.get(i).getGiaDV()), list.get(i).getSoLuong(), DichVuBUS.getSL(list.get(i).getMaDV()), "Thêm"};
                dtm.addRow(data);
            }
        }
        setModel(dtm);
        // Sử dụng một renderer riêng cho cột 
        getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        getColumnModel().getColumn(6).setCellEditor(editor);
        // Sử dụng một renderer chung cho tất cả các cột
        setDefaultRenderer(Object.class, new TableDichVuNhapTableCellRenderer());
        setRowHeight(30);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(100);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(5).setPreferredWidth(100);
        getColumnModel().getColumn(6).setPreferredWidth(100);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#EEEEEE")));
    }
}
