package GUI.GUI_DATPHONG;

import BUS.PhongBUS;
import DTO.PhongDTO;
import GUI.GUI_PHONG.TablePhongCellRenderer;
import GUI.GUI_PHONG.TablePhongCellRendererDatPhong;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class TableRoomDatPhong extends JTable {

    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");

    public TableRoomDatPhong() {
        super();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void renderTB(String dateTimeThue, String dateTimeTra, boolean check) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Loại phòng");
        dtm.addColumn("Chi tiết phòng");
        dtm.addColumn("Giá phòng");
        dtm.addColumn("Hiện trạng");
        ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThue, dateTimeTra, check);
        for (int i = 0; i < listP.size(); i++) {
            String hienTrang = "";
            if (listP.get(i).getHienTrang() == 0) {
                hienTrang = "Mới";
            } else {
                hienTrang = "Cũ";
            }
            Object data[] = {i + 1, listP.get(i).getMaP(), listP.get(i).getTenP(), listP.get(i).getLoaiP(), listP.get(i).getChiTietLoaiP(), dcf.format(listP.get(i).getGiaP()), hienTrang};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TablePhongCellRendererDatPhong());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(135);
        getColumnModel().getColumn(2).setPreferredWidth(150);
        getColumnModel().getColumn(3).setPreferredWidth(100);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(5).setPreferredWidth(100);
        getColumnModel().getColumn(6).setPreferredWidth(80);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#eeeeee")));
    }
    public void renderTB(ArrayList<PhongDTO> listP) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Loại phòng");
        dtm.addColumn("Chi tiết phòng");
        dtm.addColumn("Giá phòng");
        dtm.addColumn("Hiện trạng");
        for (int i = 0; i < listP.size(); i++) {
            String hienTrang = "";
            if (listP.get(i).getHienTrang() == 0) {
                hienTrang = "Mới";
            } else {
                hienTrang = "Cũ";
            }
            Object data[] = {i + 1, listP.get(i).getMaP(), listP.get(i).getTenP(), listP.get(i).getLoaiP(), listP.get(i).getChiTietLoaiP(), dcf.format(listP.get(i).getGiaP()), hienTrang};
            dtm.addRow(data);
        }
        setModel(dtm);
        setDefaultRenderer(Object.class, new TablePhongCellRendererDatPhong());
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(135);
        getColumnModel().getColumn(2).setPreferredWidth(150);
        getColumnModel().getColumn(3).setPreferredWidth(100);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(5).setPreferredWidth(100);
        getColumnModel().getColumn(6).setPreferredWidth(80);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#eeeeee")));
    }
    public void renderTB() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Loại phòng");
        dtm.addColumn("Chi tiết phòng");
        dtm.addColumn("Giá phòng");
        dtm.addColumn("Hiện trạng");
        setModel(dtm);
        setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setPreferredSize(new Dimension(1, 30));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        setRowHeight(35);
        getTableHeader().setBorder(null);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(135);
        getColumnModel().getColumn(2).setPreferredWidth(150);
        getColumnModel().getColumn(3).setPreferredWidth(100);
        getColumnModel().getColumn(4).setPreferredWidth(100);
        getColumnModel().getColumn(5).setPreferredWidth(100);
        getColumnModel().getColumn(6).setPreferredWidth(80);
        setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#eeeeee")));
    }
}
