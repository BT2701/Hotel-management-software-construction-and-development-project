package GUI.GUI_HOADON;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;

//import BUS.CTHoaDonBUS;
import BUS.ChiTietThueBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
//import BUS.MatHangBUS;
import BUS.NhanVienBUS;
//import DTO.CTHoaDon;
//import DTO.DonViDTO;
import DTO.HoaDonDTO;
import GUI.ThongBaoDialog;
import GUI.GUI_NHANVIEN.jdialog;
//import DTO.MatHangDTO;

public class HoaDonGUI extends JPanel {

    private JLabel lbTittle, lbMaHD, lbMaKH, lbNV, lbNgLap, lbTongTien, lbDiemThuong, lbChonNgay, lbChonGia, lbDenNgay,
            lbDenGia;
//	public static JLabel lbTimTheoTime, lbTimTheoPrince;
    private JTextField tfmahd, tfmakh, tfnv, tfnglap, tftongtien, tfDiemThuong, tfGiaTu, tfDenGia;
    private JLabel btnRefresh;
//	private String[] tbHeader = { "Mã hóa đơn", "Tên nhân viên", "Mã CTT", "Tiền phòng", "Tiền dịch vụ", "Giảm giá(%)",
//			"Phụ thu", "Tổng tiền", "Ngày lập", "Phương thức TT", "Tên khách hàng" };
//	private String[][] tbElements = null;
    private DefaultTableModel modelHD;
    private JTable tbHoaDon;
    private JButton btnSearch;
    private JScrollPane scrHoaDon;
    private String[] TTHD = new String[0];
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
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    LineBorder lineCB = new LineBorder(Color.white);
//	private JDateChooser dateChooer;
    private SpinnerDateModel dateModel;
    private SpinnerDateModel dateModel1;
    private JSpinner spnDate;
    private JSpinner spnDate1;
    public static JButton btnTimkiem, btnTimkiem1;
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor = new Color(45, 52, 54);

    public static String maHDselected = "";
    public static JLabel btndelete, btnInHoaDon;
    private JEditorPane txtHoaDon;
    private JPanel pnHoaDonTop, pnHoaDonBot, pnThanhPhanBot, pnTopCenter, pnTopTop, pnTopBot, pnTopBotTop,
            pnTopBotBotTime, pnTopBotBotPrince;
    private JComboBox<String> cbbKhoangGia;
    private String colorTableCode = "#dee9fc";
    private String colorLabel = "#ebf2fc";
    JTextField maHD, maCTT, NV;
    JSpinner tienDV, tongCong;
    ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/searchIcon.png")).getImage()
            .getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    ImageIcon iconRefresh = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/Refresh-icon.png")).getImage()
            .getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    int LightDark;

    public HoaDonGUI() {
        initCoponent();
    }

    public void initCoponent() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        lbTittle = new JLabel("Thông tin hóa đơn", JLabel.CENTER);
        lbTittle.setSize(300, 50);
        lbTittle.setFont(fontTittle);
        lbTittle.setOpaque(true);
        lbTittle.setBackground(Color.WHITE);

        btnRefresh = new JLabel();
        btnRefresh.setSize(30, 30);
        btnRefresh.setIcon(iconRefresh);
        btnRefresh.setFont(sgUI13);
        btnRefresh.setOpaque(true);
        btnRefresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLySuKienNutRefresh();
            }
        });

        // tìm kiếm hóa đơn theo ngày
        lbChonNgay = new JLabel("Ngày từ: ");
        lbChonNgay.setBounds(160, 240, 120, 30);
        lbChonNgay.setFont(sgUI13);

        lbDenNgay = new JLabel("đến ngày", JLabel.CENTER);
        lbDenNgay.setBounds(500, 240, 100, 30);
        lbDenNgay.setFont(sgUI13);

        dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        spnDate = new JSpinner(dateModel);
        spnDate.setFont(sgUI13);
        spnDate.setBounds(290, 240, 200, 30);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnDate, "dd/MM/yyyy");
        spnDate.setEditor(editor);

        dateModel1 = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        spnDate1 = new JSpinner(dateModel1);
        spnDate1.setFont(sgUI13);
        spnDate1.setBounds(610, 240, 200, 30);
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spnDate1, "dd/MM/yyyy");
        spnDate1.setEditor(editor1);

        btnTimkiem = new JButton("Tìm kiếm");
//		btnTimkiem.setBounds(820, 240, 120, 30);
        btnTimkiem.setFont(sgUI13b);
        btnTimkiem.setIcon(iconSearch);
        eventTimKiem();

        // tìm kiếm hóa đơn theo khoảng giá
        cbbKhoangGia = new JComboBox<String>();
        cbbKhoangGia.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbKhoangGia.setBackground(Color.white);
        cbbKhoangGia.setFont(sgUI13);
        cbbKhoangGia.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbKhoangGia.setBorder(matteBorderCB);
        layDsKhoangGia();

        // table hóa đơn
        tbHoaDon = new JTable();
        scrHoaDon = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrHoaDon.setBorder(BorderFactory.createEmptyBorder());
        scrHoaDon.setViewportView(tbHoaDon);
        renderTB(tbHoaDon);
        getDSHDALL();
        scrHoaDon.setViewportBorder(null);

        tbHoaDon.setShowGrid(false);
        tbHoaDon.setIntercellSpacing(new Dimension(0, 0));
        TableCellRenderer renderer = new CustomTableCellRenderer();
        for (int i = 0; i < tbHoaDon.getColumnCount(); i++) {
            tbHoaDon.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        tbHoaDon.setRowHeight(35);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(20);
        tbHoaDon.getTableHeader().setPreferredSize(new Dimension(1, 25));
        tbHoaDon.getTableHeader().setFont(fontTable);
        tbHoaDon.getTableHeader().setBorder(null);
        tbHoaDon.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // edit table
        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
        btndelete.setBounds(325, 610, 200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyXoaHoaDon();
            }
        });
        txtHoaDon = new JEditorPane();
        btnInHoaDon = new JLabel();
        btnInHoaDon.setIcon(new ImageIcon(getClass().getResource("/GUI/assets/in.jpg")));
        btnInHoaDon.setBounds(575, 610, 200, 50);
        btnInHoaDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInHoaDon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbHoaDon.getSelectedRow();
                if (row < 0) {
                    new ThongBaoDialog("Chọn hóa đơn", ThongBaoDialog.ERROR_DIALOG);
                    return;
                }
                String maHd = tbHoaDon.getValueAt(row, 0).toString();
                String tenNV = tbHoaDon.getValueAt(row, 1).toString();
                String maCTT = tbHoaDon.getValueAt(row, 2).toString();
                String tienPhong = tbHoaDon.getValueAt(row, 3).toString();
                int tienPhongValue = Integer.parseInt(tienPhong.replace(" VNĐ", "").replace(",", ""));
                String tienDV = tbHoaDon.getValueAt(row, 4).toString();
                int tienDVValue = Integer.parseInt(tienDV.replace(" VNĐ", "").replace(",", ""));
                String giamGia = tbHoaDon.getValueAt(row, 5).toString();
                int giamGiaValue = Integer.parseInt(giamGia.replace(" %", ""));
                String phuThu = tbHoaDon.getValueAt(row, 6).toString();
                int phuThuValue = Integer.parseInt(phuThu.replace(" %", ""));
                String tongTien = tbHoaDon.getValueAt(row, 7).toString();
                int tongTienValue = Integer.parseInt(tongTien.replaceAll(" VNĐ", "").replace(",", ""));
                String ngayLap = tbHoaDon.getValueAt(row, 8).toString();
                String pttt = tbHoaDon.getValueAt(row, 9).toString();
                String tenKH = tbHoaDon.getValueAt(row, 10).toString();
//				xuLyHienThiHoaDon(maHd, tenNV, maCTT, tienPhong, tienDV, giamGia, phuThu, tongTien,ngayLap,pttt,tenKH);
//				btnInHoaDonActionPerformed();
//				new ThongBaoDialog("In hóa đơn thành công!", ThongBaoDialog.SUCCESS_DIALOG);
                HoaDonDTO hdto = new HoaDonDTO(maHd, maCTT, tienPhongValue, tienDVValue, giamGiaValue, phuThuValue, tongTienValue, ngayLap, pttt, 0);
                new FormHoaDon(hdto);
//				new form
            }
        });
        // 1.1thành phần giao diện bên dưới
        pnThanhPhanBot = new JPanel();
        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 100, 10);
        pnThanhPhanBot.setLayout(layout1);
        pnThanhPhanBot.add(btnInHoaDon);
        pnThanhPhanBot.add(btndelete);
        // 1.khu vực thành phần giao diện bên dưới
        pnHoaDonBot = new JPanel();
        pnHoaDonBot.setLayout(new BorderLayout(10, 10));
        pnHoaDonBot.add(scrHoaDon, BorderLayout.CENTER);
        pnHoaDonBot.add(pnThanhPhanBot, BorderLayout.SOUTH);

        // 2.1thành phần giao diện bên trên
        // 2.1.1giữa
        pnTopCenter = new JPanel();
        pnTopCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnSearch = new JButton("Tìm kiếm");
        btnSearch.setPreferredSize(new Dimension(120, 30));
        btnSearch.setFont(sgUI13b);
        btnSearch.setIcon(iconSearch);
        eventBtnSearch();
        maHD = new JTextField();
        maHD.setFont(sgUI13);
        maHD.setPreferredSize(new Dimension(200, 30));

        maCTT = new JTextField();
        maCTT.setFont(sgUI13);
        maCTT.setPreferredSize(new Dimension(200, 30));
        NV = new JTextField();
        NV.setFont(sgUI13);
        NV.setPreferredSize(new Dimension(200, 30));
        tienDV = new JSpinner();

        tienDV.setPreferredSize(new Dimension(200, 30));
        tongCong = new JSpinner();
        tongCong.setPreferredSize(new Dimension(200, 30));
        setPlaceholderTF();

        pnTopCenter.add(maHD);
        pnTopCenter.add(maCTT);
        pnTopCenter.add(NV);
        pnTopCenter.add(tienDV);
        pnTopCenter.add(tongCong);
        pnTopCenter.add(btnSearch);
        // 2.1.2trên
        pnTopTop = new JPanel();
        pnTopTop.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnTopTop.add(lbTittle);
        pnTopTop.add(btnRefresh);
        // 2.1.3dưới

        // 2.1.3.2 dưới
        FlowLayout layoutSearch = new FlowLayout(FlowLayout.CENTER, 10, 10);
        pnTopBot = new JPanel();
        pnTopBot.setLayout(layoutSearch);
        pnTopBot.add(lbChonNgay);
        pnTopBot.add(spnDate);
        pnTopBot.add(lbDenNgay);
        pnTopBot.add(spnDate1);
        pnTopBot.add(cbbKhoangGia);
        pnTopBot.add(btnTimkiem);

        // 2.khu vực thành phần giao diện bên trên
        pnHoaDonTop = new JPanel();
        pnHoaDonTop.setLayout(new BorderLayout(10, 10));
        pnHoaDonTop.add(pnTopCenter, BorderLayout.CENTER);
        pnHoaDonTop.add(pnTopTop, BorderLayout.NORTH);
        pnHoaDonTop.add(pnTopBot, BorderLayout.SOUTH);

        this.add(pnHoaDonBot, BorderLayout.CENTER);
        this.add(pnHoaDonTop, BorderLayout.NORTH);

//		this.setVisible(false);
    }

    public void setPlaceholderTF() {
        setPlaceholder(maHD, "Mã hóa đơn");
        setPlaceholder(maCTT, "Mã chi tiết thuế");
        setPlaceholder(NV, "Tên nhân viên");
        setPlaceholder(tienDV, "Tiền dịch vụ");
        setPlaceholder(tongCong, "Tổng cộng");
    }

    public void layDsKhoangGia() {
        Vector<String> listKhoangGia = new Vector<>();
        listKhoangGia.add("Lựa chọn mức giá");
        listKhoangGia.add("0 - 1.000.000 VNĐ");
        listKhoangGia.add("1.000.000 - 3.000.000 VNĐ");
        listKhoangGia.add("3.000.000 - 5.000.000 VNĐ");
        listKhoangGia.add("5.000.000 VNĐ - ...");
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listKhoangGia);
        cbbKhoangGia.setModel(cbmodel);
    }

    public void themPhanTuVaoMangTTHD(String s) {
        int l = TTHD.length;
        TTHD = Arrays.copyOf(TTHD, l + 1);
        TTHD[l] = s;
    }

    public void getDSHDALL() {
//		"Mã hóa đơn", "Tên nhân viên", "Mã CTT", "Tiền phòng", "Tiền dịch vụ", "Giảm giá(%)",
//		"Phụ thu", "Tổng tiền", "Ngày lập", "Phương thức TT", "Tên khách hàng"
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        for (HoaDonDTO hoaDon : HoaDonBUS.getIntance().getList()) {
            Vector<String> vec = new Vector<>();
            vec.add(hoaDon.getMaHD());
            vec.add(NhanVienBUS.getIntance()
                    .layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaNV()));
            vec.add(hoaDon.getMaCTT());
            vec.add(dcf.format(hoaDon.getTienP()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTienDV()) + " VNĐ");
            vec.add(hoaDon.getGiamGia() + " %");
            vec.add(dcf.format(hoaDon.getPhuThu()) + " %");
            vec.add(dcf.format(hoaDon.getTongTien()) + " VNĐ");
            vec.add(hoaDon.getNgayThanhToan());
            vec.add(hoaDon.getPhuongThucThanhToan());
            vec.add(KhachHangBUS.getIntance()
                    .layTenBangMa(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaKH()));
            model.addRow(vec);

        }
    }

    public void truyenData(ArrayList<HoaDonDTO> listhoaDon) {
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        for (HoaDonDTO hoaDon : listhoaDon) {
            Vector<String> vec = new Vector<>();
            vec.add(hoaDon.getMaHD());
            vec.add(NhanVienBUS.getIntance()
                    .layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaNV()));
            vec.add(hoaDon.getMaCTT());
            vec.add(dcf.format(hoaDon.getTienP()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTienDV()) + " VNĐ");
            vec.add(hoaDon.getGiamGia() + "%");
            vec.add(dcf.format(hoaDon.getPhuThu()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTongTien()) + " VNĐ");
            vec.add(hoaDon.getNgayThanhToan());
            vec.add(hoaDon.getPhuongThucThanhToan());
            vec.add(KhachHangBUS.getIntance()
                    .layTenBangMa(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaKH()));
            model.addRow(vec);
        }
    }

    public void lightDark(int option) {
        if (option == 0) {
            this.LightDark = option;
            tbHoaDon.getTableHeader().setBackground(Color.decode(colorTableCode));
            btnTimkiem.setBackground(Color.decode(colorTableCode));
            scrHoaDon.getViewport().setBackground(Color.white);
            btnSearch.setBackground(Color.decode(colorTableCode));
            pnThanhPhanBot.setBackground(Color.WHITE);
            pnHoaDonTop.setBackground(Color.WHITE);
            pnHoaDonBot.setBackground(Color.WHITE);
            pnTopBot.setBackground(Color.WHITE);
//			pnTopBotBotPrince.setBackground(Color.WHITE);
//			pnTopBotBotTime.setBackground(Color.WHITE);
//			pnTopBotTop.setBackground(Color.WHITE);
            pnTopCenter.setBackground(Color.WHITE);
            pnTopTop.setBackground(Color.WHITE);
            btnRefresh.setBackground(Color.white);
            this.setBackground(Color.white);
            lbTittle.setBackground(Color.WHITE);
            cbbKhoangGia.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
            cbbKhoangGia.setBackground(Color.white);
            lbChonNgay.setForeground(Color.black);
            lbDenNgay.setForeground(Color.black);
            scrHoaDon.setBackground(Color.white);
            scrHoaDon.getViewport().setBackground(Color.white);
            lbTittle.setForeground(Color.black);
            tbHoaDon.getTableHeader().setForeground(Color.black);
        } else {
            Color black = Color.decode("#333333");
            this.LightDark = option;
            btnTimkiem.setBackground(Color.decode(colorTableCode));
            scrHoaDon.getViewport().setBackground(Color.white);
            btnSearch.setBackground(Color.decode(colorTableCode));
            pnThanhPhanBot.setBackground(black);
            pnHoaDonTop.setBackground(black);
            pnHoaDonBot.setBackground(black);
            pnTopBot.setBackground(black);
//			pnTopBotBotPrince.setBackground(black);
//			pnTopBotBotTime.setBackground(black);
//			pnTopBotTop.setBackground(black);
            pnTopCenter.setBackground(black);
            pnTopTop.setBackground(black);
            btnRefresh.setBackground(black);
            this.setBackground(black);
            lbTittle.setBackground(black);
            lbTittle.setForeground(Color.white);
            cbbKhoangGia.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#919191")));
            cbbKhoangGia.setBackground(Color.decode("#474747"));
            lbChonNgay.setForeground(Color.white);
            lbDenNgay.setForeground(Color.white);
            scrHoaDon.setBackground(black);
            scrHoaDon.getViewport().setBackground(black);
            tbHoaDon.getTableHeader().setBackground(Color.decode("#202020"));
            tbHoaDon.getTableHeader().setForeground(Color.white);
        }
    }

    public void delTableHoaDon() {
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        model.setRowCount(0);
    }

    public void renderTB(JTable tbP) {
//		"Mã hóa đơn", "Tên nhân viên", "Mã CTT", "Tiền phòng", "Tiền dịch vụ", "Giảm giá(%)",
//		"Phụ thu", "Tổng tiền", "Ngày lập", "Phương thức TT", "Tên khách hàng"
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã HD");
        dtm.addColumn("Tên NV");
        dtm.addColumn("Mã CTT");
        dtm.addColumn("Tiền phòng");
        dtm.addColumn("Tiền DV");
        dtm.addColumn("Giảm giá");
        dtm.addColumn("Phụ thu");
        dtm.addColumn("Tổng tiền");
        dtm.addColumn("Ngày lập");
        dtm.addColumn("Phương thức TT");
        dtm.addColumn("Tên KH");

        tbP.setModel(dtm);
//		for (int i = 0; i < 20; i++) {
//			Object data[] = { "HD001", "Trưởng DT", "CTT001", "1,500,000VND", "10,000VND", "0%", "0VND", "1,500,000VND",
//					"27/01/2003", "Creditcard", "Nguyễn Văn A" };
//			dtm.addRow(data);
//		}
        tbP.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
    }

    public void xuLySuKienTableHoaDon() {
        int row = tbHoaDon.getSelectedRow();
        maHDselected = tbHoaDon.getValueAt(row, 0) + "";
        tfmahd.setText(maHDselected);
        tfnv.setText(tbHoaDon.getValueAt(row, 1) + "");
        tfnglap.setText(tbHoaDon.getValueAt(row, 2) + "");
        tfDiemThuong.setText(tbHoaDon.getValueAt(row, 3) + "");
        tfmakh.setText(tbHoaDon.getValueAt(row, 4) + "");
        tftongtien.setText(tbHoaDon.getValueAt(row, 5) + " VNĐ");

    }

    public void xuLyXoaHoaDon() {
        int row = tbHoaDon.getSelectedRow();
        if (row < 0) {
            new ThongBaoDialog("Chọn hóa đơn", ThongBaoDialog.ERROR_DIALOG);
            return;
        }
        String maHD = tbHoaDon.getValueAt(row, 0).toString();
        HoaDonBUS.getIntance().thayDoiTrangThai(maHD, 0);
        new ThongBaoDialog("Xóa hóa đơn thành công", ThongBaoDialog.SUCCESS_DIALOG);
        delTableHoaDon();
        getDSHDALL();
    }

    public void xuLyBtnSearchPrice() {
        if (pnTopBotBotTime.getParent() == pnTopBot) {
            pnTopBotBotTime.setVisible(false);
            pnTopBot.remove(pnTopBotBotTime);
        }
        pnTopBot.add(pnTopBotBotPrince, BorderLayout.CENTER);
        pnTopBotBotPrince.setVisible(true);
    }

    public void xuLyBtnSearchTime() {
        if (pnTopBotBotPrince.getParent() == pnTopBot) {
            pnTopBotBotPrince.setVisible(false);
            pnTopBot.remove(pnTopBotBotPrince);
        }
        pnTopBot.add(pnTopBotBotTime, BorderLayout.CENTER);
        pnTopBotBotTime.setVisible(true);
    }

    public void layDanhSachHoaDonTheoThoiGian(Date tuNgay, Date denNgay) {
//		"Mã hóa đơn", "Tên nhân viên", "Mã CTT", "Tiền phòng", "Tiền dịch vụ", "Giảm giá(%)",
//		"Phụ thu", "Tổng tiền", "Ngày lập", "Phương thức TT", "Tên khách hàng"
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        for (HoaDonDTO hoaDon : HoaDonBUS.getIntance().layDsHoaDonTheoKhoangThoiGian(tuNgay, denNgay)) {
            Vector<String> vec = new Vector<>();
            vec.add(hoaDon.getMaHD());
            vec.add(NhanVienBUS.getIntance()
                    .layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaNV()));
            vec.add(hoaDon.getMaCTT());
            vec.add(dcf.format(hoaDon.getTienP()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTienDV()) + " VNĐ");
            vec.add(hoaDon.getGiamGia() + "%");
            vec.add(dcf.format(hoaDon.getPhuThu()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTongTien()) + " VNĐ");
            vec.add(hoaDon.getNgayThanhToan());
            vec.add(hoaDon.getPhuongThucThanhToan());
            vec.add(KhachHangBUS.getIntance()
                    .layTenBangMa(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaKH()));
            model.addRow(vec);
        }
    }

    public void layDanhSachHoaDonTheoKhoangGia(double giaTu, double denGia) {
        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        for (HoaDonDTO hoaDon : HoaDonBUS.getIntance().layDsHoaDonTheoGia(giaTu, denGia)) {
            Vector<String> vec = new Vector<>();
            vec.add(hoaDon.getMaHD());
            vec.add(NhanVienBUS.getIntance()
                    .layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaNV()));
            vec.add(hoaDon.getMaCTT());
            vec.add(dcf.format(hoaDon.getTienP()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTienDV()) + " VNĐ");
            vec.add(hoaDon.getGiamGia() + "%");
            vec.add(dcf.format(hoaDon.getPhuThu()) + " VNĐ");
            vec.add(dcf.format(hoaDon.getTongTien()) + " VNĐ");
            vec.add(hoaDon.getNgayThanhToan());
            vec.add(hoaDon.getPhuongThucThanhToan());
            vec.add(KhachHangBUS.getIntance()
                    .layTenBangMa(ChiTietThueBUS.getInstance().selectById(hoaDon.getMaCTT()).getMaKH()));
            model.addRow(vec);
        }
    }

    public void xuLySuKienTimKiemHoaDonTheoNgay() {
        Date tuNgay = (Date) spnDate.getValue();
        Date denNgay = (Date) spnDate1.getValue();
        System.out.println(sdf.format(tuNgay));
        System.out.println(sdf.format(denNgay));
//		System.out.println(sdf.format(date));
        delTableHoaDon();
        layDanhSachHoaDonTheoThoiGian(tuNgay, denNgay);

    }

    public void xuLySuKienTimKiemHoaDonTheoKhoangGia() {
        String[] values = cbbKhoangGia.getSelectedItem().toString().split(" - ");
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].replace(".", "");
            values[i] = values[i].replace(" VNĐ", "");
        }
        if (values[1] == "") {
            values[1] = Integer.MAX_VALUE + "";
        }
        double giaTu = Double.parseDouble(values[0]);
        double denGia = Double.parseDouble(values[1]);
//		System.out.println(sdf.format(date));
        delTableHoaDon();
        layDanhSachHoaDonTheoKhoangGia(giaTu, denGia);

    }

    public void xuLySuKienNutRefresh() {
        delTableHoaDon();
        getDSHDALL();
        layDsKhoangGia();
        setPlaceholderTF();

    }

//	private void btnInHoaDonActionPerformed() {
//		try {
//			if (!txtHoaDon.getText().equals("")) {
//				txtHoaDon.print();
////                this.dispose();
//			}
//		} catch (PrinterException ex) {
//		}
//	}
//	xuLyHienThiHoaDon(maHd, tenNV, maCTT, tienPhong, tienDV, giamGia, phuThu, tongTien,ngayLap,pttt,tenKH);
//	private void xuLyHienThiHoaDon(String maHD, String tenNV, String maCTT, String tienPhong, String tienDV,
//			String giamGia, String phuThu, String tongTien,String ngayLap,String pttt,String tenKH) {
//		txtHoaDon.setContentType("text/html");
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
////        LocalDateTime now = LocalDateTime.now();
////		DecimalFormat dcf = new DecimalFormat("###,### VND");
//
//		String hd = "<style> " + "table {" + "border: 1px solid;" + "border-bottom: none" + "}" + "tr {"
//				+ "border-bottom: 1px solid;" + "}" + "td {" + "padding: 8px;" + "} " + "th {" + "font-size:16pt" + "}"
//				+ "</style>";
//		hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
//		hd += "Mã hóa đơn: " + maHD + "<br/>";
////		hd += "Mã chi tiết thuê: " + maCTT + "<br/>";
//		hd += "Nhân viên: " + tenNV + "<br/>";
//		hd += "Ngày lập: " + ngayLap + "<br/>";
//		hd += "Khách hàng: " + tenKH + "<br/>";
//		hd += "<div style='text-align:center;'>==========================================</div><br/>";
//		hd += "<div style='text-align:center'>";
//		hd += "<table style='max-width:100%'>";
//		hd += "<tr>" + "<th>Mã chi tiết thuê</th>"+ "<th>Tiền phòng</th>" + "<th>Tiền dịch vụ</th>" + "<th>Giảm giá</th>" + "<th>Phụ thu</th>"
//				 + "</tr>";
////		for (CTHoaDon cthd : CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD)) {
////			String tenSP = MatHangBUS.getInstance().layTenSanPhamById(cthd.getMaMH());
////
//			hd += "<tr>";
//			hd += "<td style='text-align:center;'>" + maCTT + "</td>";
//			hd += "<td style='text-align:center;'>" + tienPhong + "</td>";
//			hd += "<td style='text-align:left;'>" + tienDV + "</td>";
//			hd += "<td style='text-align:center;'>" + giamGia + "</td>";
//			hd += "<td style='text-align:center;'>" + phuThu + "</td>";
////			hd += "<td style='text-align:center;'>" + dcf.format(cthd.getThanhTien()) + "</td>";
//			hd += "</tr>";
////		}
////		xuLyHienThiHoaDon(maHd, tenNV, maCTT, tienPhong, tienDV, giamGia, phuThu, tongTien,ngayLap,pttt,tenKH);
//			hd += "<tr>";
//	        hd += "<td style='text-align:center;'>" + "</td>";
//	        hd += "<td style='text-align:left;'>" + "</td>";
//	        hd += "<td style='text-align:center;'>" + "</td>";
//	        hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
//	        hd += "<td style='text-align:center;'>" + tongTien + "</td>";
//	        hd += "</tr>";
//	        hd += "<tr>";
//	        hd += "<td style='text-align:center;'>" + "</td>";
//	        hd += "<td style='text-align:left;'>" + "</td>";
//	        hd += "<td style='text-align:center;'>" + "</td>";
//	        hd += "<td style='text-align:center;font-weight:bold'>Phương thức thanh toán</td>";
//	        hd += "<td style='text-align:center;'>" +pttt + "</td>";
//	        hd += "</tr>";
//		
////		hd += "<tr>";
////		hd += "<td style='text-align:left;font-weight:bold'>Tiền phòng:</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:left;'>" + "</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:right;'>" + tienPhong + "</td>";
////		hd += "</tr>";
////		hd += "<tr>";
////		hd += "<td style='text-align:left;font-weight:bold'>Tiền dịch vụ:</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:left;'>" + "</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:right;'>" + tienDV + "</td>";
////		hd += "</tr>";
////		hd += "<tr>";
////		hd += "<td style='text-align:left;font-weight:bold'>Giảm giá:</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:left;'>" + "</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:right;'>" + giamGia + "</td>";
////		hd += "</tr>";
////		hd += "<tr>";
////		hd += "<td style='text-align:left;font-weight:bold'>Phụ thu:</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:left;'>" + "</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:right;'>" + phuThu + "</td>";
////		hd += "</tr>";
////		hd += "<tr>";
////		hd += "<td style='text-align:left;font-weight:bold'>Tổng tiền:</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:left;'>" + "</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:right;'>" + tongTien + "</td>";
////		hd += "</tr>";
////		hd += "<tr>";
////		hd += "<td style='text-align:left;font-weight:bold'>Phương thức thanh toán:</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:left;'>" + "</td>";
////		hd += "<td style='text-align:center;'>" + "</td>";
////		hd += "<td style='text-align:right;'>" + pttt + "</td>";
////		hd += "</tr>";
//		hd += "</table>";
//		hd += "</div>";
//		hd += "<div style='text-align:center;'>==========================================</div><br/>";
//		
//		txtHoaDon.setText(hd);
////		new FormHoaDon(txtHoaDon, sgUI18b);
//		
////        txtTongTien.setText(dcf.format(tongTien));
//	}
    public static void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    public static void setPlaceholder(JSpinner spinner, String placeholder) {
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            textField.setText(placeholder);
            textField.setForeground(Color.GRAY);

            textField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textField.getText().equals(placeholder)) {
                        textField.setText("");
                        textField.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textField.getText().isEmpty()) {
                        textField.setText(placeholder);
                        textField.setForeground(Color.GRAY);
                    }
                }
            });
        }
    }

    //hàm thêm mới 5/11/2023
    public void eventBtnSearch() {
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txttienDv = tienDV.getValue().toString();
                String txttongTien = tongCong.getValue().toString();
                long tienDv = Long.parseLong(txttienDv);
                long tongTien = Long.parseLong(txttongTien);
                if (maHD.getText().toString().equalsIgnoreCase("Mã hóa đơn")
                        && maCTT.getText().toString().equalsIgnoreCase("Mã chi tiết thuế")
                        && NV.getText().toString().equalsIgnoreCase("Tên nhân viên") && tienDv == 0 && tongTien == 0) {
                    new ThongBaoDialog("Vui lòng nhập điều kiện lọc", ThongBaoDialog.WARNING_DIALOG);
                    xuLySuKienNutRefresh();
                    return;
                } else {
                    ArrayList<HoaDonDTO> list = new ArrayList<>();
                    String txtMaHD = maHD.getText().toString();
                    String txtMaCTT = maCTT.getText().toString();
                    String tenNV = NV.getText().toString();
//					System.out.println(txtMaHD);
//					System.out.println(txtMaCTT);
//					System.out.println(tenNV);
//					System.out.println(tienDv);
//					System.out.println(tongTien);
                    // xảy ra 8 trường hợp lọc theo tiêu chí
                    if (!maHD.getText().toString().equalsIgnoreCase("Mã hóa đơn")) {
                        if (!maCTT.getText().toString().equalsIgnoreCase("Mã chi tiết thuế")) {
                            if (!NV.getText().toString().equalsIgnoreCase("Tên nhân viên")) {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    && hd.getMaCTT().contains(txtMaCTT)
                                                    ) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }

                            }
                        } else {
                            if (!NV.getText().toString().equalsIgnoreCase("Tên nhân viên")) {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                   
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }

                            } else {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                    
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaHD().contains(txtMaHD)
                                                   ) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    } else {
                        if (!maCTT.getText().toString().equalsIgnoreCase("Mã chi tiết thuế")) {
                            if (!NV.getText().toString().equalsIgnoreCase("Tên nhân viên")) {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (
                                                    hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                    && NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }

                            } else {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                  
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                    
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                    
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (hd.getMaCTT().contains(txtMaCTT)
                                                    ) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }

                            }
                        } else {
                            if (!NV.getText().toString().equalsIgnoreCase("Tên nhân viên")) {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (NhanVienBUS.getIntance()
                                                    .layTenNVtheoMA(ChiTietThueBUS.getInstance()
                                                            .selectById(hd.getMaCTT()).getMaNV()).contains(tenNV)) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                }

                            } else {
                                if (tienDv != 0) {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (tienDv == (long) hd.getTienDV()
                                                    && tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (tienDv == (long) hd.getTienDV()) {
                                                list.add(hd);
                                            }
                                        }
                                    }
                                } else {
                                    if (tongTien != 0) {
                                        for (HoaDonDTO hd : HoaDonBUS.getIntance().getList()) {
                                            if (tongTien == (long) hd.getTongTien()) {
                                                list.add(hd);
                                            }
                                        }
                                    } else {
                                        new ThongBaoDialog("Vui lòng nhập điều kiện lọc",
                                                ThongBaoDialog.WARNING_DIALOG);
                                        xuLySuKienNutRefresh();
                                        return;
                                    }
                                }

                            }
                        }
                    }
                    delTableHoaDon();
                    truyenData(list);

                }
            }
        });
    }

    public void eventTimKiem() {
        btnTimkiem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Date tuNgay = (Date) spnDate.getValue();
                Date denNgay = (Date) spnDate1.getValue();
                String mucGia = cbbKhoangGia.getSelectedItem().toString();
                int mucGiaIndex = cbbKhoangGia.getSelectedIndex();
                System.out.println(tuNgay);
                System.out.println(denNgay);
                System.out.println(mucGia);
                if (mucGiaIndex == 0) {
                    delTableHoaDon();
                    truyenData(HoaDonBUS.getIntance().layDsHoaDonTheoKhoangThoiGian(tuNgay, denNgay));
                } else {
                    String[] gia = mucGia.split(" - ");
                    String giaTu = gia[0].replace(".", "").replace(" VNĐ", "");
                    String denGia = gia[1].replace(".", "").replace(" VNĐ", "");
                    if (denGia.equalsIgnoreCase("")) {
                        denGia = "10000000";
                    }
                    double from = Double.parseDouble(giaTu);
                    double to = Double.parseDouble(denGia);
                    delTableHoaDon();
                    truyenData(HoaDonBUS.getIntance().layDsHoaDonTheoKhoangGia(HoaDonBUS.getIntance().layDsHoaDonTheoKhoangThoiGian(tuNgay, denNgay), from, to));
                }
            }
        });
    }

    //LƯU Ý CHO FILE NÀY LÀ TÌM KIẾM CÁC NÚT ĐƯỢC ADD SỰ KIỆN ĐỂ LẤY CÁC HÀM TÌM KIẾM IN HÓA ĐƠN
    public JLabel getLbTittle() {
        return lbTittle;
    }

    public void setLbTittle(JLabel lbTittle) {
        this.lbTittle = lbTittle;
    }

    public JLabel getLbMaHD() {
        return lbMaHD;
    }

    public void setLbMaHD(JLabel lbMaHD) {
        this.lbMaHD = lbMaHD;
    }

    public JLabel getLbMaKH() {
        return lbMaKH;
    }

    public void setLbMaKH(JLabel lbMaKH) {
        this.lbMaKH = lbMaKH;
    }

    public JLabel getLbNV() {
        return lbNV;
    }

    public void setLbNV(JLabel lbNV) {
        this.lbNV = lbNV;
    }

    public JLabel getLbNgLap() {
        return lbNgLap;
    }

    public void setLbNgLap(JLabel lbNgLap) {
        this.lbNgLap = lbNgLap;
    }

    public JLabel getLbTongTien() {
        return lbTongTien;
    }

    public void setLbTongTien(JLabel lbTongTien) {
        this.lbTongTien = lbTongTien;
    }

    public JLabel getLbGhiChu() {
        return lbDiemThuong;
    }

    public void setLbGhiChu(JLabel lbGhiChu) {
        this.lbDiemThuong = lbGhiChu;
    }

    public JTextField getTfmahd() {
        return tfmahd;
    }

    public void setTfmahd(JTextField tfmahd) {
        this.tfmahd = tfmahd;
    }

    public JTextField getTfmakh() {
        return tfmakh;
    }

    public void setTfmakh(JTextField tfmakh) {
        this.tfmakh = tfmakh;
    }

    public JTextField getTfnv() {
        return tfnv;
    }

    public void setTfnv(JTextField tfnv) {
        this.tfnv = tfnv;
    }

    public JTextField getTfnglap() {
        return tfnglap;
    }

    public void setTfnglap(JTextField tfnglap) {
        this.tfnglap = tfnglap;
    }

    public JTextField getTftongtien() {
        return tftongtien;
    }

    public void setTftongtien(JTextField tftongtien) {
        this.tftongtien = tftongtien;
    }

    public JTextField getTfDiemThuong() {
        return tfDiemThuong;
    }

    public void setTfDiemThuong(JTextField tfghichu) {
        this.tfDiemThuong = tfghichu;
    }

    public JLabel getBtnChange() {
        return btnRefresh;
    }

    public void setBtnChange(JLabel btnChange) {
        this.btnRefresh = btnChange;
    }

    public JScrollPane getScrHoaDon() {
        return scrHoaDon;
    }

    public void setScrHoaDon(JScrollPane scrHoaDon) {
        this.scrHoaDon = scrHoaDon;
    }

    public JTable getTbHoaDon() {
        return tbHoaDon;
    }

    public void setTbHoaDon(JTable tbHoaDon) {
        this.tbHoaDon = tbHoaDon;
    }

}
