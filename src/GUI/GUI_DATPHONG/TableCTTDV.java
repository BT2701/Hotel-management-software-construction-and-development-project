package GUI.GUI_DATPHONG;

import BUS.DichVuBUS;
import DTO.ChiTietThueDichVuDTO;
import DTO.DichVuDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableCTTDV extends JTable {

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public TableCTTDV() {
        super();
    }

    public void renderTB(ArrayList<ChiTietThueDichVuDTO> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
        dtm.addColumn(" ");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Ngày sử dụng");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Giá dịch vụ");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Thành tiền");
        int k = 0;
        for (ChiTietThueDichVuDTO x : list) {
            DichVuDTO dv = DichVuBUS.searchDV(x.getMaDV().trim());
            Object data[] = {++k, x.getMaDV(), dv.getTenDV(), x.getNgaySuDung(), x.getSoLuong(), dcf.format(dv.getGiaDV()), dcf.format(x.getGiaDV()), dcf.format(x.getSoLuong() * x.getGiaDV())};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TableCTTDVCellRenderer());
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
        getColumnModel().getColumn(2).setPreferredWidth(200);
        getColumnModel().getColumn(3).setPreferredWidth(110);
        getColumnModel().getColumn(4).setPreferredWidth(80);
        getColumnModel().getColumn(5).setPreferredWidth(120);
        getColumnModel().getColumn(6).setPreferredWidth(120);
        getColumnModel().getColumn(7).setPreferredWidth(120);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#eeeeee")));
    }
}
