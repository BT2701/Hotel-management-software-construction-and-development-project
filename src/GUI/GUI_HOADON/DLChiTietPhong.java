package GUI.GUI_HOADON;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BUS.ChiTietThueBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import DTO.HoaDonDTO;

public class DLChiTietPhong extends JDialog {
    //mã phongf, tên phòng, loại phòng,giá phòng, chi tiết loại phòng,tình trạng, hiện trạng

    private JTable tbThongTinP;
    private JScrollPane scrThongTinphong;
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private JPanel pnTable;

    public DLChiTietPhong() {
        initComponents();
    }

    public void initComponents() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setSize(600, 900);
//		this.setLayout(null);
//		this.setPreferredSize(new Dimension(900,600));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        tbThongTinP = new JTable();
        scrThongTinphong = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrThongTinphong.setBorder(BorderFactory.createEmptyBorder());
        scrThongTinphong.setViewportView(tbThongTinP);
        renderTB(tbThongTinP);
        getDSHDALL();
        scrThongTinphong.setViewportBorder(null);

        tbThongTinP.setShowGrid(false);
        tbThongTinP.setIntercellSpacing(new Dimension(0, 0));
        TableCellRenderer renderer = new CustomTableDialog();
        for (int i = 0; i < tbThongTinP.getColumnCount(); i++) {
            tbThongTinP.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        tbThongTinP.setRowHeight(35);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(20);
//		tbThongTinP.getTableHeader().setPreferredSize(new Dimension(1, 25));
        tbThongTinP.getTableHeader().setFont(fontTable);
        tbThongTinP.getTableHeader().setBorder(null);
        tbThongTinP.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        pnTable.add(scrThongTinphong, BorderLayout.CENTER);

        this.add(pnTable);

        this.setVisible(true);
    }

    public void getDSHDALL() {
//		"Mã hóa đơn", "Tên nhân viên", "Mã CTT", "Tiền phòng", "Tiền dịch vụ", "Giảm giá(%)",
//		"Phụ thu", "Tổng tiền", "Ngày lập", "Phương thức TT", "Tên khách hàng"
        DefaultTableModel model = (DefaultTableModel) tbThongTinP.getModel();
        for (HoaDonDTO hoaDon : HoaDonBUS.getIntance().getList()) {
            Vector<String> vec = new Vector<>();
            vec.add(hoaDon.getMaHD());
            vec.add(NhanVienBUS.getIntance()
                    .layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaNV()));
            vec.add(hoaDon.getMaCTT());
            vec.add(dcf.format(hoaDon.getTienP()) + "VND");
            vec.add(dcf.format(hoaDon.getTienDV()) + "VND");
            vec.add(hoaDon.getGiamGia() + "%");
            vec.add(dcf.format(hoaDon.getPhuThu()) + "VND");
//			vec.add(dcf.format(hoaDon.getTongTien()) + "VND");
//			vec.add(sdf.format(hoaDon.getDate()));
//			vec.add(hoaDon.getPhuongThucThanhToan());
//			vec.add(KhachHangBUS.getIntance()
//					.layTenBangMa(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaKH()));
            model.addRow(vec);

        }
    }

    public void renderTB(JTable tbP) {
        //mã phongf, tên phòng, loại phòng,giá phòng, chi tiết loại phòng,tình trạng, hiện trạng
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Loại phòng");
        dtm.addColumn("Giá phòng");
        dtm.addColumn("CT loại phòng");
        dtm.addColumn("Tình trạng");
        dtm.addColumn("Hiện trạng");
//		dtm.addColumn("Tổng tiền");
//		dtm.addColumn("Ngày lập");
//		dtm.addColumn("Phương thức TT");
//		dtm.addColumn("Tên KH");

        tbP.setModel(dtm);
//		for (int i = 0; i < 20; i++) {
//			Object data[] = { "HD001", "Trưởng DT", "CTT001", "1,500,000VND", "10,000VND", "0%", "0VND", "1,500,000VND",
//					"27/01/2003", "Creditcard", "Nguyễn Văn A" };
//			dtm.addRow(data);
//		}
        tbP.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
    }
}
