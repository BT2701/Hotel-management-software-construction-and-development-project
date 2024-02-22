package GUI.GUI_HOADON;

import BUS.ChiTietThueBUS;
import BUS.ChiTietThueDichVuBUS;
import BUS.ChiTietThuePhongBUS;
import BUS.DichVuBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.PhongBUS;
import DAO.HoaDonDAO;
//import BUS.SuDungDichVuBUS;
//import BUS.ThuePhongBUS;
import DTO.ChiTietThueDTO;
import DTO.ChiTietThueDichVuDTO;
import DTO.ChiTietThuePhongDTO;
import DTO.DichVuDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.PhongDTO;
import GUI.GUI_BASIC.ReceptionistGUI;
import GUI.ThongBaoDialog;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
//import DTO.SuDungDichVuDTO;
//import DTO.ThuePhongDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.AttributeSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import javax.swing.table.TableColumn;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class HoaDonLeTanGUI extends JDialog {

    private JLabel lbTitle = new JLabel("HÓA ĐƠN");
    private JPanel pnTitle = new JPanel();
    private JPanel pnContentCenter = new JPanel();

    private JPanel pnContentCenterKH = new JPanel();
    private JLabel lbTitleCenterKH = new JLabel("THÔNG TIN KHÁCH THUÊ", JLabel.CENTER);
    private JPanel pnTitleCenterKH = new JPanel();
    private JPanel pnCenterKH = new JPanel();
    private JPanel pnSouthKH = new JPanel();
    private JPanel pnWestKH = new JPanel();

    private JPanel pnContentCenterDV = new JPanel();
    private JLabel lbTitleCenterDV = new JLabel("CHI TIẾT DỊCH VỤ", JLabel.CENTER);
    private JPanel pnTitleCenterDV = new JPanel();
    private JPanel pnTablePhong = new JPanel();
    private JPanel pnGiaPhong = new JPanel();
    private JPanel pnTableDV = new JPanel();
    private JPanel pnGiaDV = new JPanel();
    private JPanel pnCenterDV = new JPanel();
    private JTable tablePhong, tableDV;
    private JScrollPane jscPhong, jscDV;

    private JPanel pnContentEast = new JPanel();
    private JLabel lbTitleEast = new JLabel("THANH TOÁN", JLabel.CENTER);
    private JPanel pnTitleEast = new JPanel();
    private JPanel pnEast = new JPanel();
    private JPanel pnInput = new JPanel();
    private JPanel pnBton = new JPanel();

    private JLabel lbtenKH, lbmaKH, lbcmnd, lbGt, lbSdt, lbLanThue, lbGiaPhongTC, lbTongGiaDv, lbCoc, lbTongCong,
            lbKhach, lbPTTT, lbThoi, lbPhuThu, txtlbCoc, txtlbTongCong, lbKhuyeMai, txtlbKhuyenMai, lbThanhTien,
            txtlbThanhTien;
    private JLabel textlbtenKH, textlbmaKH, textlbcmnd, textlbGt, textlbSdt, textlbLanThue, textlbGiaPhong,
            textlbKhuyenMai, txtlbPTTT, textlbGiaPhongTC, textlbTongGiaDv, textlbThue, textlbTongCong, textlbKhach,
            textlbThoi;
    private JButton btnThanhToan, btnThoat;
    private JComboBox<String> cbbPhuThu, cbbPTTT;
    private JTextField txtenKH, txmaKH, txcmnd, txGt, txSdt, txtKhach, txtThoi;
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
    SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor = new Color(45, 52, 54);
    private String colorTableCode = "#dee9fc";
    private String colorLabel = "ebf2fc";
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    LineBorder lineCB = new LineBorder(Color.white);
    ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/searchIcon.png")).getImage()
            .getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    DefaultTableModel model;

    ArrayList<KhachHangDTO> KhachHangList = KhachHangBUS.getIntance().getList();
//    ArrayList<ThuePhongDTO> ThuePhongList = ThuePhongBUS.getListTP();
//    ArrayList<SuDungDichVuDTO> SuDungDichVuList = SuDungDichVuBUS.getListSuDungDichVu();
    ArrayList<DichVuDTO> DichVuList = DichVuBUS.getInstance().getList();
    ArrayList<NhanVienDTO> NhanVienList = NhanVienBUS.getIntance().getList();
    ArrayList<PhongDTO> PhongList = new PhongBUS().getListP();
    ArrayList<ChiTietThueDTO> CTTList = ChiTietThueBUS.getInstance().getList();
    ArrayList<HoaDonDTO> HDList = HoaDonBUS.getIntance().getList();
    ChiTietThueDTO chiTietThue;
    ReceptionistGUI receptionistGUI;

    public HoaDonLeTanGUI(ChiTietThueDTO CTT, ReceptionistGUI receptionistGUI) {
        this.receptionistGUI = receptionistGUI;
        chiTietThue = CTT;
        initComponents(CTT);
        lightDark(0);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(ChiTietThueDTO CTT) {
        setTitle("Thanh toán");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setSize(1500, 700);
        setLocationRelativeTo(null);
        // frBackground.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setModal(true);

        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        lbTitle.setFont(sgUI18b);
        pnTitle.setPreferredSize(new Dimension(1200, 50));
        pnTitle.setLayout(new BorderLayout());
        pnTitle.add(lbTitle, BorderLayout.CENTER);
        pnTitle.setBackground(Color.white);
        pnTitle.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
        add(pnTitle, BorderLayout.NORTH);
//Content Thông tin Khách        
        pnContentCenter.setPreferredSize(new Dimension(1100, 600));
        pnContentCenter.setBackground(Color.WHITE);
        pnContentCenter.setBorder(new MatteBorder(10, 7, 7, 7, Color.WHITE));
        pnContentCenter.setLayout(new BorderLayout());

        pnContentCenterKH.setPreferredSize(new Dimension(275, 600));
        pnContentCenterKH.setLayout(new BorderLayout());
        pnContentCenterKH.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));

        lbTitleCenterKH.setFont(sgUI18b);
        pnTitleCenterKH.setPreferredSize(new Dimension(275, 25));
        pnTitleCenterKH.setLayout(new BorderLayout());
        pnTitleCenterKH.setBackground(Color.decode("#98FB98"));
        pnTitleCenterKH.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
        pnTitleCenterKH.add(lbTitleCenterKH, BorderLayout.CENTER);

        pnCenterKH.setPreferredSize(new Dimension(275, 250));
        pnCenterKH.setLayout(new GridLayout(5, 2));
        pnCenterKH.setBackground(Color.white);

        lbmaKH = new JLabel("Mã Khách Hàng:");
        lbmaKH.setForeground(Color.black);
        lbmaKH.setFont(sgUI15p);
        lbmaKH.setPreferredSize(new Dimension(150, 50));
        pnCenterKH.add(lbmaKH);

        textlbmaKH = new JLabel("" + CTT.getMaKH());
        textlbmaKH.setForeground(Color.red);
        textlbmaKH.setFont(sgUI15p);
        textlbmaKH.setPreferredSize(new Dimension(100, 50));
        pnCenterKH.add(textlbmaKH);

        lbtenKH = new JLabel("Họ Tên:");
        lbtenKH.setForeground(Color.black);
        lbtenKH.setFont(sgUI15p);
        lbtenKH.setPreferredSize(new Dimension(150, 50));
        pnCenterKH.add(lbtenKH);

        textlbtenKH = new JLabel("" + KhachHangBUS.getIntance().selectById(CTT.getMaKH()).getTenKH());
        textlbtenKH.setForeground(Color.red);
        textlbtenKH.setFont(sgUI15p);
        textlbtenKH.setPreferredSize(new Dimension(100, 50));
        pnCenterKH.add(textlbtenKH);

        lbGt = new JLabel("Giới Tính:");
        lbGt.setForeground(Color.black);
        lbGt.setFont(sgUI15p);
        lbGt.setPreferredSize(new Dimension(150, 50));
        pnCenterKH.add(lbGt);

        textlbGt = new JLabel("" + KhachHangBUS.getIntance().selectById(CTT.getMaKH()).getGioiTinh());
        textlbGt.setForeground(Color.red);
        textlbGt.setFont(sgUI15p);
        textlbGt.setPreferredSize(new Dimension(100, 50));
        pnCenterKH.add(textlbGt);

        lbcmnd = new JLabel("CMND:");
        lbcmnd.setForeground(Color.black);
        lbcmnd.setFont(sgUI15p);
        lbcmnd.setPreferredSize(new Dimension(150, 50));
        pnCenterKH.add(lbcmnd);

        textlbcmnd = new JLabel("" + KhachHangBUS.getIntance().selectById(CTT.getMaKH()).getCMND());
        textlbcmnd.setForeground(Color.red);
        textlbcmnd.setFont(sgUI15p);
        textlbcmnd.setPreferredSize(new Dimension(100, 50));
        pnCenterKH.add(textlbcmnd);

        lbLanThue = new JLabel("Lần Thuê Trước:");
        lbLanThue.setForeground(Color.black);
        lbLanThue.setFont(sgUI15p);
        lbLanThue.setPreferredSize(new Dimension(100, 50));
        pnCenterKH.add(lbLanThue);

        textlbLanThue = new JLabel("" + solanthuetruoc(CTT.getMaKH()));
        textlbLanThue.setForeground(Color.red);
        textlbLanThue.setFont(sgUI15p);
        textlbLanThue.setPreferredSize(new Dimension(100, 50));
        pnCenterKH.add(textlbLanThue);

        pnContentCenterKH.add(pnTitleCenterKH, BorderLayout.NORTH);
        pnContentCenterKH.add(pnCenterKH, BorderLayout.CENTER);

        pnSouthKH.setPreferredSize(new Dimension(290, 325));
        pnSouthKH.setBackground(Color.white);
        pnSouthKH.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/FHDThongTinKhach.png"))
                .getImage().getScaledInstance(290, 325, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon);
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        pnSouthKH.add(imageLabel, BorderLayout.CENTER);
        pnContentCenterKH.add(pnSouthKH, BorderLayout.SOUTH);

        pnWestKH.setPreferredSize(new Dimension(10, 575));
        pnWestKH.setBackground(Color.white);
        pnContentCenterKH.add(pnWestKH, BorderLayout.WEST);

        pnContentCenter.add(pnContentCenterKH, BorderLayout.WEST);
//        
//Content Thông tin Dv           
        pnContentCenterDV.setPreferredSize(new Dimension(800, 600));
        pnContentCenterDV.setBorder(new MatteBorder(1, 0, 1, 1, Color.black));
        pnContentCenterDV.setLayout(new BorderLayout(1, 1));

        lbTitleCenterDV.setFont(sgUI18b);
        pnTitleCenterDV.setPreferredSize(new Dimension(400, 25));
        pnTitleCenterDV.setLayout(new BorderLayout());
        pnTitleCenterDV.setBackground(Color.decode("#98FB98"));
        pnTitleCenterDV.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
        pnTitleCenterDV.add(lbTitleCenterDV, BorderLayout.CENTER);

        pnCenterDV.setPreferredSize(new Dimension(500, 575));
        pnCenterDV.setLayout(new GridLayout(2, 1));

        // Table Phòng
        tablePhong = new JTable();
        jscPhong = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jscPhong.setBorder(BorderFactory.createEmptyBorder());
        jscPhong.setViewportView(tablePhong);
        jscPhong.setBackground(Color.white);
        jscPhong.getViewport().setBackground(Color.white);
        renderTB(tablePhong);
        getDSHDALL(CTT);
        jscPhong.setViewportBorder(null);

        tablePhong.setShowGrid(false);
        tablePhong.setIntercellSpacing(new Dimension(0, 0));
        TableCellRenderer renderer = new CustomChiTietDV();
        for (int i = 0; i < tablePhong.getColumnCount(); i++) {
            tablePhong.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        tablePhong.setRowHeight(35);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(20);
        tablePhong.getTableHeader().setPreferredSize(new Dimension(1, 25));
        tablePhong.getTableHeader().setFont(fontTable);
        tablePhong.getTableHeader().setBorder(null);
        tablePhong.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tablePhong = new JTable();
//        model = (DefaultTableModel) tablePhong.getModel();
//        model.setColumnIdentifiers(new Object[]{
//            "STT", "Mã Phòng", "Giá(VNĐ)", "Loại Hình", "Ngày Thuê", "Ngày Trả", "Ngày CheckOut"
//        });
//        int i = 1;
//        ArrayList<ThuePhongDTO> ListTP = new ArrayList<>();
//        for (ThuePhongDTO ThuePhong : ThuePhongList) {
//            if (CTT.getMaChiTietThue().equals(ThuePhong.getMaChiTietThue())) {
//                ListTP.add(ThuePhong);
//            }
//        }
//        for (int k = 0; k < ListTP.size() - 1; k++) {
//            for (int h = k + 1; h < ListTP.size(); h++) {
//                if (ListTP.get(k).getMaP().equals(ListTP.get(h).getMaP())) {
//                    ListTP.remove(h);
//                    h--;
//                }
//            }
//        }
//        for (ThuePhongDTO ThuePhong : ListTP) {
//            model.addRow(new Object[]{
//                i++, ThuePhong.getMaP(), ThuePhong.getGia() + "", ThuePhong.getLoaiHinhThue() + "", ThuePhong.getNgayThue(), ThuePhong.getNgayTra(), ThuePhong.getNgayCheckOut()
//            });
//        }
//
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        TableColumn column1 = tablePhong.getColumnModel().getColumn(1);
//        column1.setPreferredWidth(50);
//        TableColumn column2 = tablePhong.getColumnModel().getColumn(2);
//        column2.setPreferredWidth(50);
//        TableColumn column3 = tablePhong.getColumnModel().getColumn(3);
//        column3.setPreferredWidth(50);
//        TableColumn column4 = tablePhong.getColumnModel().getColumn(4);
//        column4.setPreferredWidth(85);
//        TableColumn column5 = tablePhong.getColumnModel().getColumn(5);
//        column5.setPreferredWidth(85);
//
//        tablePhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//        tablePhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
//        tablePhong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//        tablePhong.getColumnModel().getColumn(0).setPreferredWidth(10);
//
//        tablePhong.setPreferredSize(new Dimension(400, 227));
//        jscPhong = new JScrollPane(tablePhong);
//        jscPhong.setBorder(BorderFactory.createLineBorder(Color.black, 1));
//        jscPhong.setViewportView(tablePhong);
//        tablePhong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tablePhong.setBackground(Color.white);
//        tablePhong.getTableHeader().setFont(sgUI15b);
//        tablePhong.getTableHeader().setBackground(Color.decode("#1E90FF"));
//        tablePhong.setFont(sgUI13);
//        tablePhong.getTableHeader().setForeground(Color.white);
//        tablePhong.getTableHeader().setPreferredSize(new Dimension(50, 30));
//        tablePhong.setRowHeight(30);
//
        pnTablePhong.setPreferredSize(new Dimension(500, 250));
        pnTablePhong.setLayout(new BorderLayout(1, 1));
        pnTablePhong.setBorder(new MatteBorder(7, 7, 7, 7, Color.white));
        pnTablePhong.add(jscPhong, BorderLayout.CENTER);
        pnCenterDV.add(pnTablePhong);
        // Tổng giá Phòng
        pnGiaPhong.setPreferredSize(new Dimension(500, 97));
        pnGiaPhong.setBackground(Color.white);
        pnGiaPhong.setLayout(new GridLayout(3, 1, 1, 1));

        JPanel pn1 = new JPanel();
        pn1.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn1.setBackground(Color.white);
        lbGiaPhongTC = new JLabel("Tổng Tiền Phòng:", JLabel.LEFT);
        lbGiaPhongTC.setForeground(Color.black);
        lbGiaPhongTC.setFont(sgUI15p);
        lbGiaPhongTC.setPreferredSize(new Dimension(150, 20));
        pn1.add(lbGiaPhongTC);

        JLabel TienPhong = new JLabel(0 + " VNĐ");
        TienPhong.setForeground(Color.decode("#32CD32"));
        TienPhong.setFont(sgUI15p);
        TienPhong.setPreferredSize(new Dimension(150, 20));
        pn1.add(TienPhong);
        pnGiaPhong.add(pn1);

        pnTablePhong.add(pnGiaPhong, BorderLayout.SOUTH);
        // Table dv
        tableDV = new JTable();
        jscDV = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jscDV.setBorder(BorderFactory.createEmptyBorder());
        jscDV.setBackground(Color.white);
        jscDV.getViewport().setBackground(Color.white);
        jscDV.setViewportView(tableDV);
        jscDV.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.white));
        jscPhong.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.white));
        renderTB1(tableDV);
        getDSHDALL1();
        jscDV.setViewportBorder(null);

        tableDV.setShowGrid(false);
        tableDV.setIntercellSpacing(new Dimension(0, 0));
        TableCellRenderer renderer1 = new CustomDV();
        for (int i = 0; i < tableDV.getColumnCount(); i++) {
            tableDV.getColumnModel().getColumn(i).setCellRenderer(renderer1);
        }
        tableDV.setRowHeight(35);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
//        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(20);
        tableDV.getTableHeader().setPreferredSize(new Dimension(1, 25));
        tableDV.getTableHeader().setFont(fontTable);
        tableDV.getTableHeader().setBorder(null);
        tableDV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//        tableDV = new JTable() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//        model = (DefaultTableModel) tableDV.getModel();
//
//        model.setColumnIdentifiers(new Object[]{
//            "STT", "Mã DV", "Ngày Nhập", "Tên DV", "Loại", "Số Lượng", "Giá(VNĐ)", "Tổng(VNĐ)"
//        });
//        int j = 1;
//        ArrayList<SuDungDichVuDTO> ListDV = new ArrayList<>();
//        for (SuDungDichVuDTO sddv : SuDungDichVuList) {
//            if (CTT.getMaChiTietThue().equals(sddv.getMaChiTietThue())) {
//                ListDV.add(sddv);
//            }
//        }
//        for (int k = 0; k < ListDV.size() - 1; k++) {
//            for (int h = k + 1; h < ListDV.size(); h++) {
//                if (ListDV.get(k).getMaDV().equals(ListDV.get(h).getMaDV()) && ListDV.get(k).getNgaySuDungString().equals(ListDV.get(h).getNgaySuDungString()) && ListDV.get(k).getSoLuong() == ListDV.get(h).getSoLuong()) {
//                    ListDV.remove(h);
//                    h--;
//                }
//            }
//        }
//        for (SuDungDichVuDTO SuDungDichVu : ListDV) {
//            for (DichVuDTO DichVu : DichVuList) {
//                if (CTT.getMaChiTietThue().equals(SuDungDichVu.getMaChiTietThue()) && SuDungDichVu.getXuLy() != 1 && SuDungDichVu.getMaDV().equals(DichVu.getMaDV())) {
//                    model.addRow(new Object[]{
//                        j++, SuDungDichVu.getMaDV(), SuDungDichVu.getNgaySuDungString(), DichVu.getTenDV(), DichVu.getTenLoaiDV(), SuDungDichVu.getSoLuong(), DichVu.getGiaDV() + "", SuDungDichVu.getDonGia() + ""
//                    });
//                }
//            }
//        }
//
//        tableDV.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//        tableDV.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
//        tableDV.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//        tableDV.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
//        tableDV.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
//        tableDV.getColumnModel().getColumn(0).setPreferredWidth(10);
//        TableColumn columnDV0 = tableDV.getColumnModel().getColumn(0);
//        columnDV0.setPreferredWidth(10);
//        TableColumn columnDV1 = tableDV.getColumnModel().getColumn(1);
//        columnDV1.setPreferredWidth(20);
//        TableColumn columnDV2 = tableDV.getColumnModel().getColumn(2);
//        columnDV2.setPreferredWidth(85);
////        TableColumn columnDV3 = tableDV.getColumnModel().getColumn(3);
////        columnDV3.setPreferredWidth(25);
////        TableColumn columnDV4 = tableDV.getColumnModel().getColumn(4);
////        columnDV4.setPreferredWidth(25);
//        TableColumn columnDV5 = tableDV.getColumnModel().getColumn(5);
//        columnDV5.setPreferredWidth(35);
//        TableColumn columnDV6 = tableDV.getColumnModel().getColumn(6);
//        columnDV6.setPreferredWidth(40);
//        TableColumn columnDV7 = tableDV.getColumnModel().getColumn(7);
//        columnDV7.setPreferredWidth(50);
//
//        tableDV.setPreferredSize(new Dimension(500, 274));
//        jscDV = new JScrollPane(tableDV);
//        jscDV.setBorder(BorderFactory.createLineBorder(Color.black, 1));
//        jscDV.setViewportView(tableDV);
//        tableDV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tableDV.setBackground(Color.white);
//        tableDV.getTableHeader().setFont(sgUI15b);
//        tableDV.getTableHeader().setBackground(Color.decode("#1E90FF"));
//        tableDV.setFont(sgUI13);
//        tableDV.getTableHeader().setForeground(Color.white);
//        tableDV.getTableHeader().setPreferredSize(new Dimension(50, 30));
//        tableDV.setRowHeight(30);
//        TableColumnModel columnModel = tableDV.getColumnModel();
//        TableColumn column = columnModel.getColumn(0);
//        column.setPreferredWidth(100);
        pnTableDV.setPreferredSize(new Dimension(500, 250));
        pnTableDV.setLayout(new BorderLayout(1, 1));
        pnTableDV.setBorder(new MatteBorder(7, 7, 7, 7, Color.white));
        pnTableDV.add(jscDV, BorderLayout.CENTER);
        pnCenterDV.add(pnTableDV);

        // Tổng giá DV
        pnGiaDV.setPreferredSize(new Dimension(500, 50));
        pnGiaDV.setBackground(Color.white);
        pnGiaDV.setLayout(new GridLayout(1, 1, 1, 1));

        JPanel pn4 = new JPanel();
        pn4.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn4.setBackground(Color.white);
        lbTongGiaDv = new JLabel("Tổng Tiền Dịch Vụ:", JLabel.LEFT);
        lbTongGiaDv.setForeground(Color.black);
        lbTongGiaDv.setFont(sgUI15p);
        lbTongGiaDv.setPreferredSize(new Dimension(150, 50));
        pn4.add(lbTongGiaDv);

        JLabel lbTienDv = new JLabel(tongTienDV() + " VNĐ");
        lbTienDv.setForeground(Color.decode("#32CD32"));
        lbTienDv.setFont(sgUI15p);
        lbTienDv.setPreferredSize(new Dimension(150, 50));
        pn4.add(lbTienDv);
        pnGiaDV.add(pn4);

        pnTableDV.add(pnGiaDV, BorderLayout.SOUTH);

        pnContentCenterDV.add(pnTitleCenterDV, BorderLayout.NORTH);
        pnContentCenterDV.add(pnCenterDV);
        pnContentCenter.add(pnContentCenterDV, BorderLayout.CENTER);
        add(pnContentCenter, BorderLayout.CENTER);
//Content Thanh Toan       
        pnContentEast.setPreferredSize(new Dimension(300, 600));
        pnContentEast.setBorder(new MatteBorder(7, 7, 7, 7, Color.white));
        pnContentEast.setBackground(Color.white);
        pnContentEast.setLayout(new BorderLayout());

        lbTitleEast.setFont(sgUI18b);
        pnTitleEast.setPreferredSize(new Dimension(300, 25));
        pnTitleEast.setBorder(new MatteBorder(1, 1, 0, 1, Color.black));
        pnTitleEast.setLayout(new BorderLayout());
        pnTitleEast.setBackground(Color.decode("#98FB98"));
        pnTitleEast.add(lbTitleEast, BorderLayout.CENTER);

        pnEast.setPreferredSize(new Dimension(300, 575));
        pnEast.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        // pnEast.setBackground(Color.white);
        pnEast.setLayout(new BorderLayout());
        pnInput.setPreferredSize(new Dimension(300, 475));
        pnInput.setLayout(new GridLayout(8, 2));
        pnInput.setBackground(Color.white);
        pnInput.setBorder(new MatteBorder(0, 0, 14, 0, Color.white));

        lbTongCong = new JLabel("Tổng Cộng:");
        lbTongCong.setFont(sgUI15p);
        lbTongCong.setBorder(new MatteBorder(0, 7, 0, 0, Color.white));
        lbTongCong.setForeground(Color.black);
        lbTongCong.setPreferredSize(new Dimension(100, 40));
        pnInput.add(lbTongCong);

        txtlbTongCong = new JLabel(0 + " VNĐ");
        txtlbTongCong.setFont(sgUI15p);
        txtlbTongCong.setForeground(Color.red);
        txtlbTongCong.setPreferredSize(new Dimension(150, 40));
        txtlbTongCong.setFocusable(false);
        pnInput.add(txtlbTongCong);

        lbCoc = new JLabel("Tiền Cọc: ");
        lbCoc.setFont(sgUI15p);
        lbCoc.setBorder(new MatteBorder(0, 7, 0, 0, Color.white));
        lbCoc.setForeground(Color.black);
        lbCoc.setPreferredSize(new Dimension(100, 40));
        pnInput.add(lbCoc);

        txtlbCoc = new JLabel(CTT.getTienDatCoc() + " VNĐ");
        txtlbCoc.setFont(sgUI15p);
        txtlbCoc.setForeground(Color.red);
        txtlbCoc.setPreferredSize(new Dimension(150, 40));
        txtlbCoc.setFocusable(false);
        pnInput.add(txtlbCoc);

        lbKhuyeMai = new JLabel("Khuyến Mãi: ");
        lbKhuyeMai.setFont(sgUI15p);
        lbKhuyeMai.setBorder(new MatteBorder(0, 7, 0, 0, Color.white));
        lbKhuyeMai.setForeground(Color.black);
        lbKhuyeMai.setPreferredSize(new Dimension(100, 40));
        pnInput.add(lbKhuyeMai);

        txtlbKhuyenMai = new JLabel(0 + " VNĐ");
        txtlbKhuyenMai.setFont(sgUI15p);
        txtlbKhuyenMai.setForeground(Color.red);
        txtlbKhuyenMai.setPreferredSize(new Dimension(150, 40));
        txtlbKhuyenMai.setFocusable(false);
        pnInput.add(txtlbKhuyenMai);

        lbPhuThu = new JLabel("Phụ Thu: ");
        lbPhuThu.setFont(sgUI15p);
        lbPhuThu.setBorder(new MatteBorder(0, 7, 0, 0, Color.white));
        lbPhuThu.setForeground(Color.black);
        lbPhuThu.setPreferredSize(new Dimension(100, 40));
        pnInput.add(lbPhuThu);

        cbbPhuThu = new JComboBox<>();
        cbbPhuThu.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbPhuThu.setBackground(Color.white);
        cbbPhuThu.setFont(sgUI13);
        cbbPhuThu.setPreferredSize(new Dimension(130, 30));
        cbbPhuThu.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbPhuThu.setBorder(matteBorderCB);
        duLieuCBB();
        JPanel temp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        temp.add(cbbPhuThu);
        temp.setBackground(Color.white);
        pnInput.add(temp);

        lbPTTT = new JLabel("PT Thanh Toán");
        lbPTTT.setFont(sgUI15p);
        lbPTTT.setBorder(new MatteBorder(0, 7, 0, 0, Color.white));
        lbPTTT.setForeground(Color.black);
        lbPTTT.setPreferredSize(new Dimension(100, 40));
        pnInput.add(lbPTTT);

        cbbPTTT = new JComboBox<>();
        cbbPTTT.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbPTTT.setBackground(Color.white);
        cbbPTTT.setFont(sgUI13);
        cbbPTTT.setPreferredSize(new Dimension(130, 30));
        cbbPTTT.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbPTTT.setBorder(matteBorderCB);
        duLieuCBB1();
        JPanel temp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        temp1.add(cbbPTTT);
        temp1.setBackground(Color.white);
        pnInput.add(temp1);

        lbThanhTien = new JLabel("THÀNH TIỀN: ");
        lbThanhTien.setFont(sgUI15p);
        lbThanhTien.setBorder(new MatteBorder(0, 7, 0, 0, Color.white));
        lbThanhTien.setForeground(Color.black);
        lbThanhTien.setPreferredSize(new Dimension(100, 40));
        pnInput.add(lbThanhTien);

        txtlbThanhTien = new JLabel(0 + " VNĐ");
        txtlbThanhTien.setFont(sgUI15p);
        txtlbThanhTien.setForeground(Color.red);
        txtlbThanhTien.setPreferredSize(new Dimension(150, 40));
        txtlbThanhTien.setFocusable(false);
        pnInput.add(txtlbThanhTien);

        lbKhach = new JLabel("Khách Đưa:");
        lbKhach.setFont(sgUI15p);
        lbKhach.setBorder(new MatteBorder(0, 7, 7, 7, Color.white));
        lbKhach.setForeground(Color.black);
        lbKhach.setPreferredSize(new Dimension(100, 30));
        pnInput.add(lbKhach);

        JPanel pntxtKhach = new JPanel(new BorderLayout());
        pntxtKhach.setPreferredSize(new Dimension(150, 10));
        pntxtKhach.setBorder(new MatteBorder(0, 0, 7, 7, Color.white));
        txtKhach = new JTextField();
        txtKhach.setFont(sgUI15p);
        txtKhach.setForeground(Color.decode("#32CD32"));
        txtKhach.setPreferredSize(new Dimension(150, 10));
        pntxtKhach.add(txtKhach, BorderLayout.CENTER);
        pnInput.add(pntxtKhach);

        lbThoi = new JLabel("Tiền Thối:");
        lbThoi.setFont(sgUI15p);
        lbThoi.setForeground(Color.black);
        lbThoi.setBorder(new MatteBorder(0, 7, 0, 7, Color.white));
        lbThoi.setPreferredSize(new Dimension(100, 30));
        pnInput.add(lbThoi);

        JPanel pntxtThoi = new JPanel(new BorderLayout());
        pntxtThoi.setPreferredSize(new Dimension(150, 10));
        pntxtThoi.setBorder(new MatteBorder(7, 0, 0, 7, Color.white));
        txtThoi = new JTextField();
        txtThoi.setFont(sgUI15p);
        txtThoi.setForeground(Color.red);
        txtThoi.setPreferredSize(new Dimension(150, 20));
        txtThoi.setFocusable(false);

        pntxtThoi.add(txtThoi, BorderLayout.CENTER);
        pnInput.add(pntxtThoi);

        pnBton.setPreferredSize(new Dimension(300, 275));
        pnBton.setLayout(new BorderLayout());
        pnBton.setBackground(Color.white);

        JPanel pnThanhT_Thoat = new JPanel(new GridLayout(1, 2));
        pnThanhT_Thoat.setPreferredSize(new Dimension(150, 100));
        pnThanhT_Thoat.setBorder(new MatteBorder(2, 0, 0, 0, Color.black));

        btnThanhToan = new JButton("Xuất hóa đơn");
        btnThanhToan.setFont(sgUI13b);
        btnThanhToan.setBackground(Color.decode("#98FB98"));
        btnThanhToan.setBorder(new MatteBorder(30, 30, 30, 30, Color.white));
        btnThanhToan.setPreferredSize(new Dimension(140, 30));
        pnThanhT_Thoat.add(btnThanhToan);
//        btnThanhToan.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnThanhToan.setBackground(Color.decode("#48F431"));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnThanhToan.setBackground(Color.decode("#98FB98"));
//            }
//        });
//
//        btnThanhToan.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ev) {
//                if (txtKhach.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Chưa Nhập Số Tiền Khách Đưa", "Thông Báo", JOptionPane.PLAIN_MESSAGE);
//                } else if (txtKhach.getText().length() > 9) {
//                    JOptionPane.showMessageDialog(null, "Số Quá Lớn", "Thông Báo", JOptionPane.PLAIN_MESSAGE);
//                } else if (Integer.parseInt(txtKhach.getText()) < ThanhTien(CTT)) {
//                    JOptionPane.showMessageDialog(null, "Số Tiền Khách Đưa Không Đủ", "Thông Báo", JOptionPane.PLAIN_MESSAGE);
//                } else if (!isNumber(Integer.parseInt(txtKhach.getText()))) {
//                    JOptionPane.showMessageDialog(null, "Phải Nhập Đúng Định Dạng Chữ Số", "Thông Báo", JOptionPane.PLAIN_MESSAGE);
//                } else {
//                    txtThoi.setText("" + TienThoi(Integer.parseInt(txtKhach.getText()), CTT));
//
//                    HoaDonDTO hd = new HoaDonDTO();
//                    if (count() < 10) {
//                        hd.setMaHD("HD0" + count());
//                    } else {
//                        hd.setMaHD("HD" + count());
//                    }
//
//                    hd.setGiamGia(TienKhuyenMai(CTT));
//                    hd.setMaChiTietThue(CTT.getMaChiTietThue());
//
//                    LocalDate now = LocalDate.now();
//                    String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//                    hd.setNgayThanhToan(formattedDate);
//                    hd.setTienDichVu(TongTienDichVu(CTT));
//                    hd.setTongTien(ThanhTien(CTT));
//                    hd.setGiamGia(TienKhuyenMai(CTT));
//                    hd.setTienPhong(TongTienPhong(CTT));
//                    hd.setMaNV(mainGUI.taiKhoan);
//
//                    try {
//                        HoaDonBUS.insertHoaDon(hd);
//                    } catch (ParseException | SQLException ex) {
//                        Logger.getLogger(HoaDonLeTanGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    JOptionPane.showMessageDialog(null, "Thanh Toán Thành Công", "Thông Báo", JOptionPane.PLAIN_MESSAGE);
//                    ExportHoaDonExcel(CTT, hd.getMaHD());
//
//                    //set lại tình trạng phòng sau khi trả
//                    //////////////////////////////8361111111111111111111111111111111111
//                    for (ThuePhongDTO ThuePhong : ListTP) {
//                        for (PhongDTO p : PhongList) {
//                            if (ThuePhong.getMaP().equals(p.getMaP())) {
//                                p.setTinhTrang("Chưa dọn phòng");
//                                PhongBUS.updatePhong(p);
//                            }
//                        }
//                    }
//                    if (ChiTietThueBUS.changeTT(CTT.getMaChiTietThue(), 1)) {
//                    }
//                    if (ThuePhongBUS.updateTTAll(CTT.getMaChiTietThue())) {
//                    }
//                    //////////////////////////////8361111111111111111111111111111111111
//                    btnThanhToan.setEnabled(false);
//                }
//
//            }
//
//        });

        btnThoat = new JButton("Thoát");
        btnThoat.setFont(sgUI13b);
        btnThoat.setBackground(Color.decode("#D3D3D3"));
        btnThoat.setBorder(new MatteBorder(30, 30, 30, 30, Color.white));
        btnThoat.setPreferredSize(new Dimension(75, 30));
        pnThanhT_Thoat.add(btnThoat);

//        btnThoat.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnThoat.setBackground(Color.decode("#B9B8B8"));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnThoat.setBackground(Color.decode("#D3D3D3"));
//            }
//        });
//
//        btnThoat.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int choice = JOptionPane.showConfirmDialog(null, "Bạn Muốn Thoát", "Thông Báo", JOptionPane.YES_NO_OPTION);
//                if (choice == JOptionPane.YES_OPTION) {
//                    frBackground.setVisible(false);
//                }
//            }
//        });
        pnBton.add(pnThanhT_Thoat, BorderLayout.NORTH);

        ImageIcon iconTT = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ImgThanhToan.png"))
                .getImage().getScaledInstance(300, 275, Image.SCALE_SMOOTH));
        JLabel imageLabelTT = new JLabel(iconTT);
        JPanel imagePanelTT = new JPanel();
        imagePanelTT.setBackground(Color.white);
        imagePanelTT.setLayout(new BorderLayout());
        imagePanelTT.add(imageLabelTT, BorderLayout.CENTER);
        pnBton.add(imagePanelTT, BorderLayout.CENTER);

        pnEast.add(pnInput, BorderLayout.CENTER);
        pnEast.add(pnBton, BorderLayout.SOUTH);
        pnContentEast.add(pnTitleEast, BorderLayout.NORTH);
        pnContentEast.add(pnEast, BorderLayout.CENTER);
        add(pnContentEast, BorderLayout.EAST);

        TienPhong.setText(dcf.format(tongTienPhong()) + " VNĐ");
        lbTienDv.setText(dcf.format(tongTienDV()) + " VNĐ");
        setDataThanhToan(CTT);
        setVisible(true);

    }

    public void lightDark(int option) {
        if (option == 0) {
            tablePhong.getTableHeader().setBackground(Color.decode("#2ecc71"));
            tableDV.getTableHeader().setBackground(Color.decode("#2ecc71"));

//			btnTimKem.setBackground(Color.decode("#2ecc71"));
            jscPhong.getViewport().setBackground(Color.white);
            jscDV.getViewport().setBackground(Color.white);
//			btnT.setBackground(Color.decode(colorTableCode));
//			pnCenter.setBackground(Color.WHITE);
//			pnSearch.setBackground(Color.WHITE);
//			pnTittle.setBackground(Color.WHITE);
//			pnTop.setBackground(Color.WHITE);
//			pnTopBotBotPrince.setBackground(Color.WHITE);
//			pnTopBotBotTime.setBackground(Color.WHITE);
//			pnTopBotTop.setBackground(Color.WHITE);
//			pnTopCenter.setBackground(Color.WHITE);
//			pnTopTop.setBackground(Color.WHITE);
//			lbRefresh.setBackground(Color.white);
//			chbTinhTrang.setBackground(Color.white);
//			pnHeader.setBackground(Color.white);
        } else {

        }
    }

    public void renderTB(JTable tbP) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã Phòng");
        dtm.addColumn("Giá");
        dtm.addColumn("Loại hình");
        dtm.addColumn("Ngày thuê");
        dtm.addColumn("Ngày trả");
        dtm.addColumn("Ngày check out");

        tbP.setModel(dtm);
        tbP.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
    }

    public void renderTB1(JTable tbP) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Tên DV");
        dtm.addColumn("Loại DV");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Ngày sử dụng");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Thành tiền");

        tbP.setModel(dtm);
        tbP.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
    }

    public void getDSHDALL(ChiTietThueDTO CTT) {
        // stt, mã phòng, giá, loại hình, Ngày thuê, ngày trả, ngày check out
        DefaultTableModel model = (DefaultTableModel) tablePhong.getModel();
        int dem = 0;
        for (ChiTietThuePhongDTO ctt : ChiTietThuePhongBUS.getInstance().getList()) {
            if (ctt.getMaCTT().equalsIgnoreCase(CTT.getMaCTT())
                    && (ctt.getTinhTrang() == 1 || ctt.getTinhTrang() == 2)) {
                dem++;
                Vector<String> vec = new Vector<>();
                vec.add(dem + "");
                vec.add(ctt.getMaP());
                vec.add(dcf.format(ctt.getGiaThue()) + " VNĐ");
                if (ctt.getLoaiHinhThue() == 0) {
                    vec.add("Theo giờ");
                } else {
                    vec.add("Theo ngày");
                }
                vec.add(sdf.format(ctt.getDateThue()));
                vec.add(sdf.format(ctt.getDateTra()));
                vec.add(sdf.format(ctt.getDateCheckOut()));
                model.addRow(vec);
//			}
            }
        }
    }

    public void getDSHDALL1() {
        // madv, tendv, loaidv, soluong, giadv, xuly
        DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
        int k = 0;
        ArrayList<ChiTietThueDichVuDTO> list = ChiTietThueDichVuBUS.getListTDVofCTT(chiTietThue.getMaCTT().trim());
        if (chiTietThue.getTinhTrangXuLy() == 0) {
            for (ChiTietThueDichVuDTO x : list) {
                DichVuDTO dv = DichVuBUS.searchDV(x.getMaDV().trim());
                Object data[] = {++k, dv.getTenDV(), dv.getLoaiDV(), x.getSoLuong(), x.getNgaySuDung(),
                    dcf.format(dv.getGiaDV() * 10) + " VNĐ", dcf.format(x.getSoLuong() * x.getGiaDV()) + " VNĐ"};
                model.addRow(data);
            }
        }
    }

    public int solanthuetruoc(String makhachhang) {
        ArrayList<ChiTietThueDTO> cttList = new ArrayList<ChiTietThueDTO>();
        cttList.addAll(ChiTietThueBUS.getInstance().getList());
        int solanthue = 0;
        for (ChiTietThueDTO ctt : cttList) {
            if (makhachhang.equals(ctt.getMaKH()) && ctt.getTinhTrangXuLy() == 1) {
                solanthue++;
            }
        }
        return solanthue;
    }

    public double GiamGia(int n) {
        if (n >= 5 && n < 10) {
            return 0.05;
        }
        if (n >= 10 && n < 15) {
            return 0.1;
        }
        if (n >= 15) {
            return 0.15;
        }
        return 0;
    }

    public boolean isNumber(int num) {
        return num > 0 && Integer.toString(num) != null && Integer.toString(num).matches("[-+]?\\d*\\.?\\d+");
    }

    public double tongTienPhong() {
        double tongTien = 0;
        for (int i = 0; i < tablePhong.getRowCount(); i++) {
            tongTien += Integer.parseInt(tablePhong.getValueAt(i, 2).toString().replace(",", "").split(" ")[0]);
        }
        return tongTien;
    }

    public double tongTienDV() {
        double tongtien = 0;
        for (int i = 0; i < tableDV.getRowCount(); i++) {
            tongtien += Integer.parseInt(tableDV.getValueAt(i, 6).toString().replace(",", "").split(" ")[0]);
        }
        return tongtien;

    }

    // hàm thêm mới
    public void setDataThanhToan(ChiTietThueDTO ctt) {
        double tong = tongTienPhong() + tongTienDV();
        double tienDatCoc = ctt.getTienDatCoc();
        double thanhTien = tong - tienDatCoc;
        int soLanThue = ChiTietThueBUS.soLanKhachThue(ctt.getMaKH());
        int giamGia = 0;
        if (soLanThue >= 5 && soLanThue < 10) {
            txtlbKhuyenMai.setText("5%");
            thanhTien -= (tong * 5 / 100);
            giamGia = 5;
        } else if (soLanThue >= 10 && soLanThue < 15) {
            txtlbKhuyenMai.setText("10%");
            thanhTien -= (tong * 10 / 100);
            giamGia = 10;
        } else if (soLanThue >= 15) {
            txtlbKhuyenMai.setText("15%");
            thanhTien -= (tong * 15 / 100);
            giamGia = 15;
        } else {
            txtlbKhuyenMai.setText("0%");
        }
        txtlbTongCong.setText(dcf.format(tong) + " VNĐ");
        txtlbCoc.setText(dcf.format(tienDatCoc) + " VNĐ");
        txtlbThanhTien.setText(dcf.format(thanhTien) + " VNĐ");
        textlbLanThue.setText(soLanThue + " lần");
        int maHDmoi = HoaDonBUS.getIntance().getMaHDmoiNhat();
        Date date = new Date();
        String maHD = "HD" + sdf1.format(date);
        switch (((maHDmoi + 1) + "").length()) {
            case 1:
                maHD += "000" + (maHDmoi + 1);
                break;
            case 2:
                maHD += "00" + (maHDmoi + 1);
                break;
            case 3:
                maHD += "0" + (maHDmoi + 1);
                break;
            default:
                maHD += (maHDmoi + 1);
                break;
        }
        HoaDonDTO hd = new HoaDonDTO(maHD, ctt.getMaCTT(), (int) tongTienPhong(), (int) tongTienDV(), giamGia, 0,
                (int) (thanhTien + tienDatCoc), sdf2.format(date), "Tiền mặt", 0);
        xuLyTraTien();
        suKienThanhToan(hd);
        suKienThoat();
        xuLyPhuThu(thanhTien, hd);
        xuLyPTTT(hd);
        if (tablePhong.getRowCount() == 0) {
            setEmpty(jscPhong);
        }
        if (tableDV.getRowCount() == 0) {
            setEmpty(jscDV);
        }
        if (tablePhong.getRowCount() != 0 || tableDV.getRowCount() != 0) {
            btnThanhToan.setEnabled(true);
        }

    }

    public void xuLyPhuThu(double tt, HoaDonDTO hd) {
        cbbPhuThu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int phuThu = Integer.parseInt(cbbPhuThu.getSelectedItem().toString().replace("%", ""));
                double tongTien = tt + (tt * phuThu / 100);
                txtlbThanhTien.setText(dcf.format(tongTien) + " VNĐ");
                hd.setTongTien((int) tongTien);
                hd.setPhuThu(phuThu);

            }
        });
    }

    public void xuLyPTTT(HoaDonDTO hd) {
        cbbPTTT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String pttt = cbbPTTT.getSelectedItem().toString();
                hd.setPhuongThucThanhToan(pttt);
            }
        });
    }

    public void xuLyTraTien() {
        ((AbstractDocument) txtKhach.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text,
                    javax.swing.text.AttributeSet attrs) throws BadLocationException {
                // Chỉ cho phép thay thế khi là số
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    new ThongBaoDialog("Chỉ cho phép nhập số!", ThongBaoDialog.ERROR_DIALOG);

                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
                    throws BadLocationException {
                // Chỉ cho phép chèn khi là số
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    new ThongBaoDialog("Chỉ cho phép nhập số!", ThongBaoDialog.ERROR_DIALOG);
                }
            }
        });
        txtKhach.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                int tt = Integer.parseInt(txtlbThanhTien.getText().replace(" VNĐ", "").replace(",", ""));
                if (txtKhach.getText().equalsIgnoreCase("")) {
//					new ThongBaoDialog("Thông báo khách hàng trả tiền", ThongBaoDialog.WARNING_DIALOG);
//					txtKhach.setText("0");
                    txtThoi.setText("0" + " VNĐ");
                    return;
                }
                double khachDua = 0;
                khachDua = Double.parseDouble(txtKhach.getText());
                double tienThoi = 0;
                tienThoi = khachDua - tt;
                txtThoi.setText(dcf.format(tienThoi) + " VNĐ");
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                int tt = Integer.parseInt(txtlbThanhTien.getText().replace(" VNĐ", "").replace(",", ""));
                if (txtKhach.getText().equalsIgnoreCase("")) {
                    new ThongBaoDialog("Thông báo khách hàng trả tiền", ThongBaoDialog.WARNING_DIALOG);
                    return;
                }
                double khachDua = 0;
                khachDua = Double.parseDouble(txtKhach.getText());
                double tienThoi = 0;
                tienThoi = khachDua - tt;
                txtThoi.setText(dcf.format(tienThoi) + " VNĐ");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                int tt = Integer.parseInt(txtlbThanhTien.getText().replace(" VNĐ", "").replace(",", ""));
                if (txtKhach.getText().equalsIgnoreCase("")) {
                    new ThongBaoDialog("Thông báo khách hàng trả tiền", ThongBaoDialog.WARNING_DIALOG);
                    return;
                }
                double khachDua = 0;
                khachDua = Double.parseDouble(txtKhach.getText());
                double tienThoi = 0;
                tienThoi = khachDua - tt;
                txtThoi.setText(dcf.format(tienThoi) + " VNĐ");
            }
        });

    }

    public void setEmpty(JScrollPane scr) {
        JLabel tfa = new JLabel("Không có dữ liệu thanh toán.");
        tfa.setFont(sgUI15I);
        JPanel pna = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pna.add(tfa);
        pna.setBackground(Color.white);
        scr.setViewportView(pna);
        btnThanhToan.setEnabled(false);
//		txtlbCoc.setText("0 VNĐ");
//		txtlbThanhTien.setText("0 VNĐ");
    }

    public void suKienThanhToan(HoaDonDTO hd) {
        btnThanhToan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (txtKhach.getText().trim().equals("")) {
                    new ThongBaoDialog("Nhập số tiền cần thanh toán", ThongBaoDialog.ERROR_DIALOG);
                    return;
                }
                if (Integer.parseInt(txtThoi.getText().replace(" VNĐ", "").replace(",", "")) < 0) {
                    new ThongBaoDialog("Cần trả thêm " + txtThoi.getText().replace("-", ""),
                            ThongBaoDialog.ERROR_DIALOG);
                    return;
                }
                new ThongBaoDialog("Xuất hóa đơn?", ThongBaoDialog.WARNING_DIALOG);
                if (ThongBaoDialog.action == ThongBaoDialog.CANCEL_OPTION) {
                    return;
                }
                new FormHoaDon(1, hd, HoaDonLeTanGUI.this);
            }
        });
    }

    public void eventThanhToan(HoaDonDTO hd) {

        HoaDonBUS.getIntance().inSert(hd);
        ChiTietThueBUS.capNhatTinhTrangXL(hd.getMaCTT(), 1, 0);

        new ThongBaoDialog("Trả lại khách " + txtThoi.getText(), ThongBaoDialog.INFO_DIALOG);
//		new ThongBaoDialog("Thanh toán thành công", ThongBaoDialog.SUCCESS_DIALOG);
        for (ChiTietThuePhongDTO ctt : ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT())) {
            if (ctt.getMaCTT().equalsIgnoreCase(chiTietThue.getMaCTT()) && ctt.getTinhTrang() == 0) {
                String date = ctt.getNgayThue().split(" ")[0].split("-")[2] + "-" + ctt.getNgayThue().split(" ")[0].split("-")[1] + "-" + ctt.getNgayThue().split(" ")[0].split("-")[0] + " " + ctt.getNgayThue().split(" ")[1];
                ChiTietThuePhongBUS.deleteCTTPhong(ctt.getMaCTT(), ctt.getMaP(), date);
            } else {
                ChiTietThuePhongBUS.capNhatTinhTrang(hd.getMaCTT(), 2);
            }
        }
//		dispose();
        this.receptionistGUI.btnDatPhong.doClick();
    }

    public void suKienThoat() {
        btnThoat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ThongBaoDialog("Bạn muốn thoát?", ThongBaoDialog.WARNING_DIALOG);
                if (ThongBaoDialog.action == ThongBaoDialog.CANCEL_OPTION) {
                    return;
                }
                dispose();
            }
        });
    }

    public void duLieuCBB() {
        Vector<String> data = new Vector<>();
        for (int i = 0; i < 30; i += 5) {
            data.add(i + "%");
        }
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(data);
        cbbPhuThu.setModel(cbmodel);
    }

    public void duLieuCBB1() {
        Vector<String> data = new Vector<>();
        data.add("Tiền Mặt");
        data.add("Credit Card");
        data.add("Thẻ Tín Dụng");
        data.add("Momo");
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(data);
        cbbPTTT.setModel(cbmodel);
    }
}
