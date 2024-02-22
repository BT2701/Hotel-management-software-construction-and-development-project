package GUI.GUI_DATPHONG;

import BUS.PhongBUS;
import DTO.ChiTietThuePhongDTO;
import DTO.PhongDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TablePhongThue extends JTable {

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public TablePhongThue() {
        super();
    }

    public void renderTB(ArrayList<Object[]> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn(" ");
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Tình trạng");
        dtm.addColumn("Loại hình thuê");
        dtm.addColumn("Ngày thuê");
        dtm.addColumn("Ngày trả");
        dtm.addColumn("Giá phòng");
        dtm.addColumn("Giá thực");
        setModel(dtm);
        int k = 0;
        for (Object[] data : list) {
            Object dt[] = {++k, data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]};
            dtm.addRow(dt);
        }
        setDefaultRenderer(Object.class, new TablePhongThueCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(10);
        getColumnModel().getColumn(1).setPreferredWidth(85);
        getColumnModel().getColumn(2).setPreferredWidth(120);
        getColumnModel().getColumn(3).setPreferredWidth(80);
        getColumnModel().getColumn(4).setPreferredWidth(80);
        getColumnModel().getColumn(5).setPreferredWidth(110);
        getColumnModel().getColumn(6).setPreferredWidth(110);
        getColumnModel().getColumn(7).setPreferredWidth(80);
        getColumnModel().getColumn(8).setPreferredWidth(80);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#eeeeee")));
    }
}
