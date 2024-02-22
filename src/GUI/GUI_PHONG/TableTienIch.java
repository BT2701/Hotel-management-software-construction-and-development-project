package GUI.GUI_PHONG;

import BUS.TienIchBUS;
import DTO.TienIchDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableTienIch extends JTable {

    ArrayList<TienIchDTO> listTI;

    public TableTienIch() {
        super();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void renderTB() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã tiện ích");
        dtm.addColumn("Tên tiện ích");
        dtm.addColumn("Số lượng");
        listTI = new ArrayList<>();
        for (TienIchDTO x : TienIchBUS.getListTI()) {
            listTI.add(x);
        }
        for (int i = 0; i < listTI.size(); i++) {
            Object data[] = {i + 1, listTI.get(i).getMaTI() + "", listTI.get(i).getTenTI() + "", listTI.get(i).getSoLuong() + ""};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableTienIchCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(50);
    }
    
    public void renderTB(ArrayList<TienIchDTO> listTI) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã tiện ích");
        dtm.addColumn("Tên tiện ích");
        dtm.addColumn("Số lượng");
        for (int i = 0; i < listTI.size(); i++) {
            Object data[] = {i + 1, listTI.get(i).getMaTI() + "", listTI.get(i).getTenTI() + "", listTI.get(i).getSoLuong() + ""};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableTienIchCellRenderer());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(50);
    }
}
