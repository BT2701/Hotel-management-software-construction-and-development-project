package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import DTO.DichVuDTO;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableDichVu extends JTable {

    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");

    public TableDichVu() {
        super();
        renderTB();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void renderTB() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Trả về kiểu Icon cho cột số 3
                if (columnIndex == 3) {
                    return Icon.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }
        };
        dtm.addColumn("STT");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Hình dịch vụ");
        dtm.addColumn("Loại dịch vụ");
        dtm.addColumn("Giá dịch vụ");
        ArrayList<DichVuDTO> list = new ArrayList<>();
        list = DichVuBUS.getListDV();
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            ImageIcon icon = new ImageIcon(new ImageIcon(list.get(i).getHinhAnh()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            Object data[] = {++k, list.get(i).getMaDV(), list.get(i).getTenDV(), icon, list.get(i).getLoaiDV(), dcf.format(list.get(i).getGiaDV())};
            dtm.addRow(data);
        }
        setModel(dtm);
        // Sử dụng một renderer riêng cho cột 
        getColumnModel().getColumn(3).setCellRenderer(new IconDichVuRenderer());
        // Sử dụng một renderer chung cho tất cả các cột
        setDefaultRenderer(Object.class, new TableDichVuCellRenderer());
        setRowHeight(60);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(120);
        getColumnModel().getColumn(2).setPreferredWidth(250);
        getColumnModel().getColumn(3).setPreferredWidth(150);
        getColumnModel().getColumn(4).setPreferredWidth(200);
        getColumnModel().getColumn(5).setPreferredWidth(100);
    }
    
    public void renderTB(ArrayList<DichVuDTO> list) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Trả về kiểu Icon cho cột số 3
                if (columnIndex == 3) {
                    return Icon.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }
        };
        dtm.addColumn("STT");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Hình dịch vụ");
        dtm.addColumn("Loại dịch vụ");
        dtm.addColumn("Giá dịch vụ");
        for (int i = 0; i < list.size(); i++) {
            ImageIcon icon = new ImageIcon(new ImageIcon(list.get(i).getHinhAnh()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            if (list.get(i).getGiaDV() == 0) {
                continue;
            }
            Object data[] = {i + 1, list.get(i).getMaDV(), list.get(i).getTenDV(), icon, list.get(i).getLoaiDV(), dcf.format(list.get(i).getGiaDV())};
            dtm.addRow(data);
        }
        setModel(dtm);
        // Sử dụng một renderer riêng cho cột 
        getColumnModel().getColumn(3).setCellRenderer(new IconDichVuRenderer());
        // Sử dụng một renderer chung cho tất cả các cột
        setDefaultRenderer(Object.class, new TableDichVuCellRenderer());
        setRowHeight(60);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(120);
        getColumnModel().getColumn(2).setPreferredWidth(250);
        getColumnModel().getColumn(3).setPreferredWidth(150);
        getColumnModel().getColumn(4).setPreferredWidth(200);
        getColumnModel().getColumn(5).setPreferredWidth(100);
    }
}
