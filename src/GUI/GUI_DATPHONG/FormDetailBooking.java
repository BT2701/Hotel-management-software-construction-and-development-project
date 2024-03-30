package GUI.GUI_DATPHONG;

import BUS.ChiTietThueBUS;
import BUS.ChiTietThueDichVuBUS;
import BUS.ChiTietThuePhongBUS;
import BUS.DichVuBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.PhongBUS;
import DTO.ChiTietThueDTO;
import DTO.ChiTietThueDichVuDTO;
import DTO.ChiTietThuePhongDTO;
import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import DTO.PhongDTO;
import GUI.GUI_BASIC.ReceptionistGUI;
import GUI.GUI_HOADON.HoaDonLeTanGUI;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.GUI_RENDER_COMPONENTS.TabbedUI;
import GUI.GUI_RENDER_COMPONENTS.TimeChoose;
import GUI.ThongBaoDialog;
import GUI.mainGUI;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;

public class FormDetailBooking extends JPanel {

    ArrayList<Object[]> listPT = new ArrayList<>();

    // pnTop 
    JPanel pnTop = new JPanel();
    JLabel lbTop = new JLabel("Thông tin phiếu thuê");
    JLabel lbDetail = new JLabel("Thông tin chi tiết phiếu thuê");

    // pnContent
    JPanel pnContent = new JPanel();

    // pnContentTop 
    JPanel pnContentTop = new JPanel();
    JPanel pnMaCTT = new JPanel();
    JPanel pnTenNV = new JPanel();
    JPanel pnNgayLapPhieu = new JPanel();
    JPanel pnTienDatCoc = new JPanel();
    JPanel pnTinhTrangXuLy = new JPanel();
    JLabel lbMaCTT = new JLabel("Mã chi tiết thuê");
    JLabel lbTenNV = new JLabel("Nhân viên lập phiếu");
    JLabel lbNgayLapPhieu = new JLabel("Ngày lập phiếu");
    JLabel lbTienDatCoc = new JLabel("Tiền đặt cọc");
    JLabel lbTinhTrangXuLy = new JLabel("Tình trạng xử lý");
    JTextField txtMaCTT = new JTextField();
    JTextField txtTenNV = new JTextField(mainGUI.nv.getTenNV());
    JTextField txtNgayLapPhieu = new JTextField();
    JTextField txtTienDatCoc = new JTextField();
    JTextField txtTinhTrangXuLy = new JTextField("Đang xử lý");
    // pnContentCenter
    JPanel pnContentCenter = new JPanel();
    // pnKhachHang
    JPanel pnKhachHang = new JPanel();
    JPanel pnKhachHangTop = new JPanel();
    JLabel lbKhachHang = new JLabel("Thông tin khách hàng");
    JPanel pnKhachHangInput = new JPanel();
    JPanel pnMaKH = new JPanel();
    JPanel pnTenKH = new JPanel();
    JPanel pnCMND = new JPanel();
    JPanel pnSDT = new JPanel();
    JPanel pnNgaySinh = new JPanel();
    JPanel pnQueQuan = new JPanel();
    JPanel pnQuocTich = new JPanel();
    JPanel pnGioiTinh = new JPanel();

    JLabel lbMaKH = new JLabel("Mã khách hàng");
    JLabel lbTenKH = new JLabel("Tên khách hàng");
    JLabel lbCMND = new JLabel("Chứng minh nhân dân");
    JLabel lbSDT = new JLabel("Số điện thoại");
    JLabel lbNgaySinh = new JLabel("Ngày sinh");
    JLabel lbQueQuan = new JLabel("Quê quán");
    JLabel lbQuocTich = new JLabel("Quốc tịch");
    JLabel lbGioiTinh = new JLabel("Giới tính");

    JTextField txtMaKH = new JTextField();
    JTextField txtTenKH = new JTextField();
    JTextField txtCMND = new JTextField();
    JTextField txtSDT = new JTextField();
    JDateChooser dateNgaySinh = new JDateChooser();
    JTextField txtQueQuan = new JTextField();
    JTextField txtQuocTich = new JTextField();
    JPanel pnRadio = new JPanel();
    JRadioButton rdNam = new JRadioButton("Nam");
    JRadioButton rdNu = new JRadioButton("Nữ");
    ButtonGroup btgGT = new ButtonGroup();
    JTextFieldDateEditor editor = (JTextFieldDateEditor) dateNgaySinh.getDateEditor();

    // pnContentCenterCTT
    JPanel pnContentCenterCTT = new JPanel();
    JTabbedPane tbpCTT = new JTabbedPane();
    JPanel pnAllCTT = new JPanel();
    JPanel pnRoom = new JPanel();
    JPanel pnService = new JPanel();
    // edit pnAllCTT
    JPanel pnAllCTTContent = new JPanel();
    JPanel pnAllCTTContentRoom = new JPanel();
    JLabel lbAllCTTContentRoom = new JLabel("Danh sách phòng thuê");
    JScrollPane scpAllCTTContentRoom = new JScrollPane();
    TableCTTPhong tbCTTRoom = new TableCTTPhong();
    JPanel pnAllCTTContentService = new JPanel();
    JLabel lbAllCTTContentService = new JLabel("Danh sách dịch vụ thuê");
    JScrollPane scpAllCTTContentService = new JScrollPane();
    JPanel pnAllCTTContentButton = new JPanel();
    TableCTTDV tbCTTDV = new TableCTTDV();
    JButton btnAcept = new JButton("Thanh toán");
    JPanel pnTotal = new JPanel();
    JLabel lbTotal = new JLabel("Tổng cộng: ");

    // edit pnRoom
    JPanel pnRoomContent = new JPanel();
    JPanel pnRoomContentCenter = new JPanel();
    JPanel pnRoomContentButton = new JPanel();
    JPanel pnRoomContentButtonTotal = new JPanel();
    JLabel lbTotalRoom = new JLabel("Tổng cộng: ");
    JTextField txtTotalRoom = new JTextField("0 VNĐ");
    JButton btnSave = new JButton("Lưu");
    JPanel pnRoomContentCenterTop = new JPanel();
    JLabel lbRoomContentCenterTop = new JLabel("Thông tin thuê phòng");
    JLabel lbRoomContentCenterDetail = new JLabel("Vui lòng nhập thông tin thuê và chọn phòng thuê cho khách hàng");
    JPanel pnRoomContentCenterContent = new JPanel();
    JPanel pnRoomContentCenterInput = new JPanel();
    JPanel pnRoomContentCenterListR = new JPanel();
    JPanel pnLoaiHinhThue = new JPanel();
    JPanel pnNgayThue = new JPanel();
    JPanel pnGioThue = new JPanel();
    JPanel pnNgayTra = new JPanel();
    JPanel pnGioTra = new JPanel();
    JLabel lbLoaiHinhThue = new JLabel("Loại hình thuê");
    JLabel lbNgayThue = new JLabel("Ngày thuê");
    JLabel lbNgayTra = new JLabel("Ngày trả");
    JLabel lbGioThue = new JLabel("Giờ thuê");
    JLabel lbGioTra = new JLabel("Giờ trả");
    JPanel pnRb = new JPanel();
    JRadioButton rdNgay = new JRadioButton("Theo Ngày");
    JRadioButton rdGio = new JRadioButton("Theo Giờ");
    JRadioButton rdKhac = new JRadioButton("Khác");
    ButtonGroup btgLHT = new ButtonGroup();
    JDateChooser dateThue = new JDateChooser();
    JDateChooser dateTra = new JDateChooser();
    TimeChoose timeThue = new TimeChoose();
    TimeChoose timeTra = new TimeChoose();
    JTextFieldDateEditor editorThue = (JTextFieldDateEditor) dateThue.getDateEditor();
    JTextFieldDateEditor editorTra = (JTextFieldDateEditor) dateTra.getDateEditor();
    JButton btnSelect = new JButton("Chọn phòng");
    JLabel lbRoomTB = new JLabel("Danh sách phòng trống");
    JPanel pnRoomTBCenter = new JPanel();
    JPanel pnSearch = new JPanel();
    JScrollPane scpTB = new JScrollPane();
    JPanel pnRoomTB = new JPanel();
    JPanel pnRoomCTT = new JPanel();
    JScrollPane scrp = new JScrollPane();
    TablePhongThue tbPhongThue = new TablePhongThue();
    JTextField txtTotal = new JTextField("0 VNĐ");
    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    Font tNR13i = new Font("Segoe UI", Font.ITALIC, 13);
    DecimalFormat dcf = new DecimalFormat("###,### VNĐ");

    JComboBox cbLoaiP = new JComboBox();
    JComboBox cbGiaP = new JComboBox();
    JComboBox cbChiTietLoaiP = new JComboBox();
    JButton btnReset = new JButton("Làm mới");
    JPanel pnRoomTBBottom = new JPanel();
    JButton btnAceptRoom = new JButton("Xác nhận");
    TableRoomDatPhong tb = new TableRoomDatPhong();

    JPanel pnServiceList = new JPanel();
    JPanel pnServiceAction = new JPanel();
    JPanel pnServiceListTop = new JPanel();
    JPanel pnServiceListCenter = new JPanel();
    JScrollPane scpService = new JScrollPane();
    JPanel pnServiceListCenterShow = new JPanel();
    JLabel lbServiceListTop = new JLabel("Danh sách dịch vụ hiện có");
    JLabel lbServiceListTopDetail = new JLabel("Vui lòng chọn dịch vụ cần thuê");
    JPanel pnServiceListCenterTop = new JPanel();
    JPanel pnServiceListCenterCb = new JPanel();
    JComboBox cbLoaiDV_formRight = new JComboBox();
    JPanel pnServiceListCenterSearch = new JPanel();
    JTextField txtSearch = new JTextField("Nhập Mã/Tên dịch vụ cần tìm...");
    JLabel lbImg = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/searchIcon.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));

    JLabel lbServiceAction = new JLabel("Danh sách dịch vụ đang xử lý");
    ArrayList<ItemService> listItemService = new ArrayList<>();

    JPanel pnServiceActionCenter = new JPanel();
    JPanel pnServiceActionCenterButton = new JPanel();
    JScrollPane scrpTable = new JScrollPane();
    JButton btnDelete = new JButton("Xóa");
    JButton btnCancel = new JButton("Huỷ bỏ");
    JButton btnSaveDV = new JButton("Lưu");
    JTable tbListDV_TabDV = new JTable() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JButton btnUpdateDV = new JButton("Sửa");
    ArrayList<Object[]> data = new ArrayList<>();
    ReceptionistGUI receptionistGUI;

    public FormDetailBooking(String maCTT, boolean check, ReceptionistGUI receptionistGUI) {
        this.receptionistGUI = receptionistGUI;
        initComponents(maCTT, check);
    }

    public void initComponents(String maCTT, boolean check) {
        ChiTietThueDTO chiTietThue = ChiTietThueBUS.getCTT(maCTT);
        KhachHangDTO khachHang = KhachHangBUS.getKH(chiTietThue.getMaKH());
        btnAcept.setForeground(Color.black);
        btnAcept.setBackground(Color.decode("#95FA9C"));
        btnAcept.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAcept.setFocusPainted(false);
        btnAcept.setPreferredSize(new Dimension(100, 30));
        btnAcept.setMaximumSize(new Dimension(100, 30));
        btnSave.setForeground(Color.black);
        btnSave.setBackground(Color.decode("#95FA9C"));
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSave.setFocusPainted(false);
        btnSave.setPreferredSize(new Dimension(100, 30));
        btnSave.setMaximumSize(new Dimension(100, 30));
        btnReset.setForeground(Color.black);
        btnReset.setBackground(Color.decode("#95FA9C"));
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReset.setFocusPainted(false);
        btnAceptRoom.setForeground(Color.black);
        btnAceptRoom.setBackground(Color.decode("#95FA9C"));
        btnAceptRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAceptRoom.setFocusPainted(false);
        btnAceptRoom.setPreferredSize(new Dimension(100, 30));
        btnAceptRoom.setMaximumSize(new Dimension(100, 30));
        UIManager.put("TabbedPane.selectedForeground", Color.decode("#12831A"));
        ImageIcon icon1 = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/dichvu.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon icon2 = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/dichvu.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon icon3 = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/dichvu.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        // pnTop
        setLayout(new BorderLayout());
        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);
        pnTop.setLayout(new GridLayout(2, 1));
        pnTop.add(lbTop);
        pnTop.add(lbDetail);
        lbTop.setFont(sgUI18b);
        lbDetail.setFont(tNR13i);
        // pnContent
        pnContent.setLayout(new BorderLayout(5, 5));
        pnContent.add(pnContentTop, BorderLayout.NORTH);
        pnContent.add(pnContentCenter, BorderLayout.CENTER);
        // pnContentTop
        pnContentTop.setLayout(new GridLayout(1, 5, 10, 10));
        pnContentTop.add(pnMaCTT);
        pnContentTop.add(pnTenNV);
        pnContentTop.add(pnNgayLapPhieu);
        pnContentTop.add(pnTienDatCoc);
        pnContentTop.add(pnTinhTrangXuLy);
        pnContentTop.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnMaCTT.setBackground(Color.white);
        pnMaCTT.setLayout(new BorderLayout(7, 7));
        pnMaCTT.add(lbMaCTT, BorderLayout.WEST);
        pnMaCTT.add(txtMaCTT, BorderLayout.CENTER);
        lbMaCTT.setFont(sgUI13b);
        txtMaCTT.setFont(sgUI13);
        txtMaCTT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtMaCTT.setBackground(Color.decode("#FAFAFA"));
        txtMaCTT.setEditable(false);
        txtMaCTT.setText(chiTietThue.getMaCTT().trim());

        pnTenNV.setBackground(Color.white);
        pnTenNV.setLayout(new BorderLayout(7, 7));
        pnTenNV.add(lbTenNV, BorderLayout.WEST);
        pnTenNV.add(txtTenNV, BorderLayout.CENTER);
        lbTenNV.setFont(sgUI13b);
        txtTenNV.setFont(sgUI13);
        txtTenNV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTenNV.setBackground(Color.decode("#FAFAFA"));
        txtTenNV.setEditable(false);
        txtTenNV.setText(NhanVienBUS.getTenNV(chiTietThue.getMaNV().trim()));

        pnNgayLapPhieu.setBackground(Color.white);
        pnNgayLapPhieu.setLayout(new BorderLayout(7, 7));
        pnNgayLapPhieu.add(lbNgayLapPhieu, BorderLayout.WEST);
        pnNgayLapPhieu.add(txtNgayLapPhieu, BorderLayout.CENTER);
        lbNgayLapPhieu.setFont(sgUI13b);
        txtNgayLapPhieu.setFont(sgUI13);
        txtNgayLapPhieu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtNgayLapPhieu.setBackground(Color.decode("#FAFAFA"));
        txtNgayLapPhieu.setText(chiTietThue.getNgayLapPhieu());
        txtNgayLapPhieu.setEditable(false);

        pnTienDatCoc.setBackground(Color.white);
        pnTienDatCoc.setLayout(new BorderLayout(7, 7));
        pnTienDatCoc.add(lbTienDatCoc, BorderLayout.WEST);
        pnTienDatCoc.add(txtTienDatCoc, BorderLayout.CENTER);
        lbTienDatCoc.setFont(sgUI13b);
        txtTienDatCoc.setFont(sgUI13);
        txtTienDatCoc.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTienDatCoc.setBackground(Color.decode("#FAFAFA"));
        txtTienDatCoc.setEditable(false);
        txtTienDatCoc.setText(dcf.format(chiTietThue.getTienDatCoc()));

        pnTinhTrangXuLy.setBackground(Color.white);
        pnTinhTrangXuLy.setLayout(new BorderLayout(7, 7));
        pnTinhTrangXuLy.add(lbTinhTrangXuLy, BorderLayout.WEST);
        pnTinhTrangXuLy.add(txtTinhTrangXuLy, BorderLayout.CENTER);
        lbTinhTrangXuLy.setFont(sgUI13b);
        txtTinhTrangXuLy.setFont(sgUI13);
        txtTinhTrangXuLy.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTinhTrangXuLy.setBackground(Color.decode("#FAFAFA"));
        txtTinhTrangXuLy.setEditable(false);
        if (chiTietThue.getTinhTrangXuLy() == 0) {
            txtTinhTrangXuLy.setText("Đang xử lý");
        } else {
            txtTinhTrangXuLy.setText("Đã xử lý");
        }

        pnContentTop.setMaximumSize(new Dimension(100, 40));
        pnContentTop.setPreferredSize(new Dimension(100, 40));
        // edit pnContentCenter
        pnContentCenter.setLayout(new BorderLayout(5, 5));
        pnContentCenter.add(pnKhachHang, BorderLayout.WEST);
        // edit khách hàng
        pnKhachHang.setLayout(new BorderLayout());
        pnKhachHang.add(pnKhachHangTop, BorderLayout.NORTH);
        pnKhachHang.add(pnKhachHangInput, BorderLayout.CENTER);
        lbKhachHang.setFont(sgUI15);
        pnKhachHangTop.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 5, 5, 5)));
        pnKhachHangTop.setBackground(Color.decode("#F0FFF0"));
        pnKhachHangTop.setLayout(new BorderLayout());
        pnKhachHangTop.add(lbKhachHang, BorderLayout.CENTER);
        pnKhachHangInput.setLayout(new GridLayout(8, 1));
        pnKhachHangInput.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnKhachHangInput.add(pnMaKH);
        pnKhachHangInput.add(pnTenKH);
        pnKhachHangInput.add(pnCMND);
        pnKhachHangInput.add(pnSDT);
        pnKhachHangInput.add(pnNgaySinh);
        pnKhachHangInput.add(pnQueQuan);
        pnKhachHangInput.add(pnQuocTich);
        pnKhachHangInput.add(pnGioiTinh);

        pnMaKH.setLayout(new GridLayout(2, 1));
        pnMaKH.add(lbMaKH);
        pnMaKH.add(txtMaKH);
        txtMaKH.setText(khachHang.getMaKH().trim());

        pnTenKH.setLayout(new GridLayout(2, 1));
        pnTenKH.add(lbTenKH);
        pnTenKH.add(txtTenKH);
        txtTenKH.setText(khachHang.getTenKH().trim());

        pnCMND.setLayout(new GridLayout(2, 1));
        pnCMND.add(lbCMND);
        pnCMND.add(txtCMND);
        txtCMND.setText(khachHang.getCMND().trim());

        pnNgaySinh.setLayout(new GridLayout(2, 1));
        pnNgaySinh.add(lbNgaySinh);
        pnNgaySinh.add(dateNgaySinh);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = sdf.parse(khachHang.getNgaySinhString());
            dateNgaySinh.setDate(date);
            dateNgaySinh.setDateFormatString("dd-MM-yyyy");
        } catch (ParseException ex) {
        }

        pnSDT.setLayout(new GridLayout(2, 1));
        pnSDT.add(lbSDT);
        pnSDT.add(txtSDT);
        txtSDT.setText(khachHang.getSDT().trim());

        pnQueQuan.setLayout(new GridLayout(2, 1));
        pnQueQuan.add(lbQueQuan);
        pnQueQuan.add(txtQueQuan);
        txtQueQuan.setText(khachHang.getQueQuan().trim());

        pnQuocTich.setLayout(new GridLayout(2, 1));
        pnQuocTich.add(lbQuocTich);
        pnQuocTich.add(txtQuocTich);
        txtQuocTich.setText(khachHang.getQuocTich().trim());

        pnGioiTinh.setLayout(new GridLayout(2, 1));
        pnGioiTinh.add(lbGioiTinh);
        pnGioiTinh.add(pnRadio);
        pnRadio.setLayout(new GridLayout(1, 2));
        pnRadio.add(rdNam);
        pnRadio.add(rdNu);
        btgGT.add(rdNam);
        btgGT.add(rdNu);
        rdNam.setFocusPainted(false);
        rdNu.setFocusPainted(false);

        if (khachHang.getGioiTinh().trim().contains("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }

        lbCMND.setFont(sgUI13b);
        lbGioiTinh.setFont(sgUI13b);
        lbMaKH.setFont(sgUI13b);
        lbNgaySinh.setFont(sgUI13b);
        lbQueQuan.setFont(sgUI13b);
        lbQuocTich.setFont(sgUI13b);
        lbSDT.setFont(sgUI13b);
        lbTenKH.setFont(sgUI13b);

        txtMaKH.setFont(sgUI13);
        txtCMND.setFont(sgUI13);
        txtQueQuan.setFont(sgUI13);
        txtQuocTich.setFont(sgUI13);
        txtSDT.setFont(sgUI13);
        txtTenKH.setFont(sgUI13);

        txtMaKH.setEditable(false);
        txtQueQuan.setEditable(false);
        txtQuocTich.setEditable(false);
        txtCMND.setEditable(false);
        txtSDT.setEditable(false);
        txtTenKH.setEditable(false);
        dateNgaySinh.setEnabled(false);
        rdNam.setEnabled(false);
        rdNam.setFont(sgUI13b);
        rdNu.setEnabled(false);
        dateNgaySinh.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateNgaySinh.getCalendarButton().setBackground(Color.decode("#FAFAFA"));
        dateNgaySinh.getCalendarButton().setFocusPainted(false);
        dateNgaySinh.getCalendarButton().setContentAreaFilled(false);
        editor.setBackground(Color.decode("#F8F8F8"));
        editor.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));

        txtMaKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtCMND.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtQueQuan.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtQuocTich.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtSDT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTenKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));

        txtMaKH.setBackground(Color.decode("#FAFAFA"));
        txtSDT.setBackground(Color.decode("#FAFAFA"));
        txtQueQuan.setBackground(Color.decode("#FAFAFA"));
        txtQuocTich.setBackground(Color.decode("#FAFAFA"));
        txtTenKH.setBackground(Color.decode("#FAFAFA"));
        txtCMND.setBackground(Color.decode("#FAFAFA"));
        dateNgaySinh.setDateFormatString("dd-MM-yyyy");
        //edit pnContentCenterCTT
        pnContentCenter.add(pnContentCenterCTT, BorderLayout.CENTER);
        pnContentCenterCTT.setLayout(new BorderLayout());
        pnContentCenterCTT.add(tbpCTT, BorderLayout.CENTER);
        tbpCTT.add(pnAllCTT);
        tbpCTT.setTitleAt(0, "Chi tiết thuê");
        tbpCTT.setUI(new TabbedUI());
        if (!check) {
            tbpCTT.add(pnRoom);
            if (ChiTietThuePhongBUS.count(chiTietThue.getMaCTT().trim()) > 0) {
                tbpCTT.add(pnService);
                tbpCTT.setTitleAt(2, "Thuê dịch vụ");
            }
            tbpCTT.setTitleAt(1, "Thuê phòng");
        } else {
            pnAllCTTContentButton.remove(btnAcept);
            tbCTTRoom.setEnabled(false);
            tbCTTDV.setEnabled(false);
            btnAcept.setVisible(false);
        }
        // edit pnAllCTT
        pnAllCTT.setLayout(new BorderLayout());
        pnAllCTT.add(pnAllCTTContent, BorderLayout.CENTER);
        pnAllCTT.add(pnAllCTTContentButton, BorderLayout.SOUTH);
        pnAllCTTContentButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnAllCTTContentButton.add(pnTotal);
        pnTotal.setBackground(Color.white);
        pnTotal.setLayout(new BorderLayout());
        pnTotal.add(lbTotal, BorderLayout.WEST);
        pnTotal.add(txtTotal, BorderLayout.CENTER);
        lbTotal.setFont(sgUI15);
        txtTotal.setFont(sgUI15);
        txtTotal.setForeground(Color.red);
        txtTotal.setHorizontalAlignment(JLabel.RIGHT);
        txtTotal.setEditable(false);
        txtTotal.setBackground(Color.decode("#FAFAFA"));
        pnTotal.setPreferredSize(new Dimension(350, 30));
        pnTotal.setMaximumSize(new Dimension(350, 30));
        txtTotal.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        pnAllCTTContentButton.add(btnAcept);
        pnAllCTTContent.setLayout(new GridLayout(2, 1, 7, 7));
        pnAllCTTContent.add(pnAllCTTContentRoom);
        pnAllCTTContent.add(pnAllCTTContentService);

        pnAllCTTContentRoom.setLayout(new BorderLayout());
        pnAllCTTContentRoom.add(lbAllCTTContentRoom, BorderLayout.NORTH);
        pnAllCTTContentRoom.add(scpAllCTTContentRoom, BorderLayout.CENTER);
        lbAllCTTContentRoom.setFont(sgUI15);
        lbAllCTTContentRoom.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 5, 5, 5)));
        lbAllCTTContentRoom.setBackground(Color.decode("#F0FFF0"));
        lbAllCTTContentRoom.setOpaque(true);
        scpAllCTTContentRoom.setBackground(Color.white);
        scpAllCTTContentRoom.getViewport().setBackground(Color.white);
        scpAllCTTContentRoom.setBorder(BorderFactory.createEmptyBorder());
        scpAllCTTContentRoom.setViewportView(tbCTTRoom);
        tbCTTRoom.renderTB(ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT().trim()));
        setTextTotal();

        pnAllCTTContentService.setLayout(new BorderLayout());
        pnAllCTTContentService.add(lbAllCTTContentService, BorderLayout.NORTH);
        pnAllCTTContentService.add(scpAllCTTContentService, BorderLayout.CENTER);
        lbAllCTTContentService.setFont(sgUI15);
        lbAllCTTContentService.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 5, 5, 5)));
        lbAllCTTContentService.setBackground(Color.decode("#F0FFF0"));
        lbAllCTTContentService.setOpaque(true);
        scpAllCTTContentService.setBackground(Color.white);
        scpAllCTTContentService.getViewport().setBackground(Color.white);
        scpAllCTTContentService.setBorder(BorderFactory.createEmptyBorder());
        scpAllCTTContentService.setViewportView(tbCTTDV);
        tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(chiTietThue.getMaCTT().trim()));
        setTextTotal();
        pnAllCTTContentButton.setBackground(Color.white);

        // pnRoom
        pnRoom.setLayout(new BorderLayout());
        pnRoom.add(pnRoomContent, BorderLayout.CENTER);
        pnRoom.add(pnRoomContentButton, BorderLayout.SOUTH);
        pnRoomContentButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnRoomContentButton.add(pnRoomContentButtonTotal);
        pnRoomContentButton.add(btnSave);
        pnRoomContentButtonTotal.setBackground(Color.white);
        pnRoomContentButtonTotal.setLayout(new BorderLayout());
        pnRoomContentButtonTotal.add(lbTotalRoom, BorderLayout.WEST);
        pnRoomContentButtonTotal.add(txtTotalRoom, BorderLayout.CENTER);
        lbTotalRoom.setFont(sgUI15);
        txtTotalRoom.setFont(sgUI15);
        txtTotalRoom.setForeground(Color.red);
        txtTotalRoom.setHorizontalAlignment(JLabel.RIGHT);
        txtTotalRoom.setEditable(false);
        txtTotalRoom.setBackground(Color.decode("#FAFAFA"));
        pnRoomContentButtonTotal.setPreferredSize(new Dimension(350, 30));
        pnRoomContentButtonTotal.setMaximumSize(new Dimension(350, 30));
        txtTotalRoom.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        pnRoomContent.setLayout(new BorderLayout(5, 5));
        pnRoomContent.add(pnRoomContentCenter, BorderLayout.CENTER);
        pnRoomContent.add(pnRoomCTT, BorderLayout.SOUTH);
        pnRoomCTT.setPreferredSize(new Dimension(100, 180));
        pnRoomCTT.setMaximumSize(new Dimension(100, 180));
        pnRoomContent.setBackground(Color.white);

        pnRoomContentCenter.setLayout(new BorderLayout(5, 5));
        pnRoomContentCenter.setBackground(Color.white);
        pnRoomContentCenter.add(pnRoomContentCenterContent, BorderLayout.WEST);
        pnRoomContentCenter.add(pnRoomTB, BorderLayout.CENTER);
        pnRoomTB.setBackground(Color.white);

        pnRoomContentCenterContent.setLayout(new BorderLayout());
        pnRoomContentCenterContent.add(pnRoomContentCenterTop, BorderLayout.NORTH);
        pnRoomContentCenterContent.setBackground(Color.white);
        pnRoomContentCenterInput.setBackground(Color.white);
        pnRoomContentCenterTop.setLayout(new GridLayout(2, 1));
        pnRoomContentCenterTop.add(lbRoomContentCenterTop);
        pnRoomContentCenterTop.add(lbRoomContentCenterDetail);
        lbRoomContentCenterTop.setFont(sgUI15);
        lbRoomContentCenterDetail.setFont(tNR13i);
        pnRoomContentCenterTop.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
        pnRoomContentCenterTop.setBackground(Color.decode("#F0FFF0"));
        pnRoomContentCenterContent.add(pnRoomContentCenterInput, BorderLayout.CENTER);
        pnRoomContentCenterInput.setPreferredSize(new Dimension(600, 100));
        pnRoomContentCenterInput.setMaximumSize(new Dimension(600, 100));
        pnRoomContentCenterInput.setLayout(new GridLayout(3, 2, 10, 0));
        pnRoomContentCenterInput.setBorder(new EmptyBorder(5, 0, 0, 0));
        pnRoomContentButton.setBackground(Color.white);
        JPanel pnSelectPhong = new JPanel();
        pnRoomContentCenterInput.add(pnLoaiHinhThue);
        pnRoomContentCenterInput.add(pnSelectPhong);
        pnRoomContentCenterInput.add(pnNgayThue);
        pnRoomContentCenterInput.add(pnGioThue);
        pnRoomContentCenterInput.add(pnNgayTra);
        pnRoomContentCenterInput.add(pnGioTra);
        pnSelectPhong.setLayout(new BorderLayout());
        pnSelectPhong.add(btnSelect, BorderLayout.EAST);
        pnSelectPhong.setBorder(new EmptyBorder(15, 0, 15, 0));
        pnSelectPhong.setBackground(Color.white);

        pnLoaiHinhThue.setBackground(Color.white);
        pnLoaiHinhThue.setLayout(new GridLayout(2, 1));
        pnLoaiHinhThue.add(lbLoaiHinhThue);
        pnLoaiHinhThue.add(pnRb);
        pnRb.setBackground(Color.white);
        pnRb.setLayout(new GridLayout(1, 3));
        pnRb.add(rdNgay);
        pnRb.add(rdGio);
        pnRb.add(rdKhac);
        rdNgay.setSelected(true);
        rdNgay.setFont(sgUI13b);
        rdGio.setFont(sgUI13);
        rdKhac.setFont(sgUI13);
        btgLHT.add(rdNgay);
        btgLHT.add(rdGio);
        btgLHT.add(rdKhac);
        rdNgay.setFocusPainted(false);
        rdNgay.setBackground(Color.white);
        rdGio.setFocusPainted(false);
        rdGio.setBackground(Color.white);
        timeTra.setEnable(false);
        rdKhac.setFocusPainted(false);
        rdKhac.setBackground(Color.white);
        rdNgay.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdNgay.setFont(sgUI13b);
                rdGio.setFont(sgUI13);
                rdKhac.setFont(sgUI13);
                dateTra.setEnabled(true);
                timeTra.setEnable(false);
                dateThue.setEnabled(true);
                timeThue.setEnable(true);
                tb.clearSelection();
            }
        });
        rdGio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdGio.setFont(sgUI13b);
                rdNgay.setFont(sgUI13);
                rdKhac.setFont(sgUI13);
                dateTra.setEnabled(true);
                timeTra.setEnable(true);
                tb.clearSelection();
                dateThue.setEnabled(true);
                timeThue.setEnable(true);
            }
        });
        rdKhac.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdKhac.setFont(sgUI13b);
                rdNgay.setFont(sgUI13);
                rdGio.setFont(sgUI13);
                timeTra.setEnable(false);
                dateTra.setEnabled(false);
                tb.clearSelection();
                dateThue.setEnabled(true);
                timeThue.setEnable(true);
            }
        });

        pnNgayThue.setBackground(Color.white);
        pnNgayThue.setLayout(new GridLayout(2, 1));
        pnNgayThue.add(lbNgayThue);
        pnNgayThue.add(dateThue);
        lbNgayThue.setFont(sgUI13b);
        dateThue.setFont(sgUI13);
        dateThue.setFont(sgUI13);
        dateThue.setDateFormatString("dd-MM-yyyy");
        dateThue.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateThue.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
        dateThue.getCalendarButton().setFocusPainted(false);
        dateThue.getCalendarButton().setContentAreaFilled(false);
        editorThue.setBackground(Color.decode("#FFFFFF"));
        editorThue.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));

        pnNgayTra.setBackground(Color.white);
        pnNgayTra.setLayout(new GridLayout(2, 1));
        pnNgayTra.add(lbNgayTra);
        pnNgayTra.add(dateTra);
        lbNgayTra.setFont(sgUI13b);
        dateTra.setDateFormatString("dd-MM-yyyy");
        dateTra.setFont(sgUI13);
        dateTra.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateTra.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
        dateTra.getCalendarButton().setFocusPainted(false);
        dateTra.getCalendarButton().setContentAreaFilled(false);
        editorTra.setBackground(Color.decode("#FFFFFF"));
        editorTra.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));

        pnGioThue.setBackground(Color.white);
        pnGioThue.setLayout(new GridLayout(2, 1));
        pnGioThue.add(lbGioThue);
        pnGioThue.add(timeThue);
        lbGioThue.setFont(sgUI13b);
        timeThue.setFont(sgUI13);

        pnGioTra.setBackground(Color.white);
        pnGioTra.setLayout(new GridLayout(2, 1));
        pnGioTra.add(lbGioTra);
        pnGioTra.add(timeTra);
        lbGioTra.setFont(sgUI13b);
        timeTra.setFont(sgUI13);

        btnSelect.setFocusPainted(false);
        btnSelect.setFont(sgUI13b);
        btnSelect.setBackground(Color.decode("#ffff99"));
        btnSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSelect.setBackground(Color.decode("#ffff33"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSelect.setBackground(Color.decode("#ffff99"));
            }
        });

        pnRoomCTT.setLayout(new BorderLayout());
        pnRoomCTT.add(scrp);
        scrp.setViewportView(tbPhongThue);
        scrp.setBorder(BorderFactory.createEmptyBorder());
        scrp.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.white));
        scrp.setBackground(Color.white);
        scrp.getViewport().setBackground(Color.white);

        scpTB.setViewportView(tb);
        scpTB.setBorder(BorderFactory.createEmptyBorder());
        scpTB.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.white));
        scpTB.setBackground(Color.white);
        scpTB.getViewport().setBackground(Color.white);
        pnSearch.setBackground(Color.white);
        pnRoomTB.setLayout(new BorderLayout());
        pnRoomTBCenter.setBackground(Color.white);
        pnRoomTB.add(lbRoomTB, BorderLayout.NORTH);
        pnRoomTB.add(pnRoomTBCenter, BorderLayout.CENTER);
        pnRoomTB.add(pnRoomTBBottom, BorderLayout.SOUTH);
        pnRoomTBBottom.setBackground(Color.white);
        pnRoomTBBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnRoomTBBottom.add(btnAceptRoom);
        pnRoomTBCenter.setLayout(new BorderLayout());
        pnRoomTBCenter.add(scpTB, BorderLayout.CENTER);
        lbRoomTB.setFont(sgUI15);
        lbRoomTB.setOpaque(true);
        lbRoomTB.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
        lbRoomTB.setBackground(Color.decode("#F0FFF0"));

        pnSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnSearch.add(cbLoaiP);
        pnSearch.add(cbChiTietLoaiP);
        pnSearch.add(cbGiaP);
        pnSearch.add(btnReset);

        cbLoaiP.removeAllItems();
        cbLoaiP.addItem("Loại phòng");
        cbLoaiP.addItem("VIP");
        cbLoaiP.addItem("Thường");

        cbChiTietLoaiP.removeAllItems();
        cbChiTietLoaiP.addItem("Chi tiết loại phòng");
        cbChiTietLoaiP.addItem("Phòng đơn");
        cbChiTietLoaiP.addItem("Phòng đôi");
        cbChiTietLoaiP.addItem("Phòng gia đình");

        cbGiaP.removeAllItems();
        cbGiaP.addItem("Giá phòng");
        cbGiaP.addItem("Dưới 100000");
        cbGiaP.addItem("Từ 100000 đến 200000");
        cbGiaP.addItem("Từ 200000 đến 500000");
        cbGiaP.addItem("Từ 500000 đến 1000000");
        cbGiaP.addItem("Trên 1000000");

        cbChiTietLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
                return basicComboPopup;
            }
        });

        cbGiaP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
                return basicComboPopup;
            }
        });

        cbLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
                return basicComboPopup;
            }
        });

        cbLoaiP.setBackground(Color.white);
        cbChiTietLoaiP.setBackground(Color.white);
        cbGiaP.setBackground(Color.white);

        cbLoaiP.setFont(sgUI13);
        cbChiTietLoaiP.setFont(sgUI13);
        cbGiaP.setFont(sgUI13);

        MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));

        cbChiTietLoaiP.setBorder(matteBorderCB);
        cbLoaiP.setBorder(matteBorderCB);
        cbGiaP.setBorder(matteBorderCB);

        tbPhongThue.renderTB(listPT);
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dateTimeFormatCheck = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                if (rdNgay.isSelected()) {
                    if (dateThue.getDate() == null) {
                        new ThongBaoDialog("Vui lòng nhập ngày thuê", 1);
                        editorThue.requestFocus();
                    } else {
                        Calendar cd = Calendar.getInstance();
                        cd.setTime(dateThue.getDate());
                        LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour(), timeThue.getMinute(), 0);
                        LocalDateTime dateNow = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        if (dateTimeThue.isAfter(dateNow)) {
                            if (dateTra.getDate() == null) {
                                new ThongBaoDialog("Vui lòng nhập ngày trả", 1);
                                editorTra.requestFocus();
                            } else {
                                timeTra.setHour(timeThue.getHour());
                                timeTra.setMinute(timeThue.getMinute());
                                Calendar cdTra = Calendar.getInstance();
                                cdTra.setTime(dateTra.getDate());
                                LocalDateTime dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                                if (dateTimeTra.isAfter(dateTimeThue)) {
                                    dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour() - 2, timeThue.getMinute(), 0);
                                    dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                                    String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                    String dateTimeTrastr = dateTimeTra.format(dateTimeFormatCheck);

                                    ArrayList<PhongDTO> listPTmp = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                                    ArrayList<PhongDTO> listNew = new ArrayList<>();
                                    boolean check;
                                    for (PhongDTO x : listPTmp) {
                                        check = false;
                                        for (Object[] obj : listPT) {
                                            if (x.getMaP().equals(obj[0].toString())) {
                                                check = true;
                                                break;
                                            }
                                        }
                                        if (!check) {
                                            listNew.add(x);
                                        }
                                    }
                                    if (listNew.isEmpty()) {
                                        new ThongBaoDialog("Không còn phòng trống", ThongBaoDialog.INFO_DIALOG);
                                        tb.renderTB();
                                    } else {
                                        tb.renderTB(listNew);
                                    }
                                    dateThue.setEnabled(false);
                                    dateTra.setEnabled(false);
                                    timeThue.setEnable(false);
                                    timeTra.setEnable(false);
                                } else {
                                    new ThongBaoDialog("Vui lòng nhập ngày giờ trả phải hơn ngày thuê", 1);
                                }
                            }
                        } else {
                            new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                        }
                    }
                } else if (rdGio.isSelected()) {
                    if (dateThue.getDate() == null) {
                        new ThongBaoDialog("Vui lòng nhập ngày thuê", 1);
                        editorThue.requestFocus();
                    } else {
                        Calendar cd = Calendar.getInstance();
                        cd.setTime(dateThue.getDate());
                        LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour(), timeThue.getMinute(), 0);
                        LocalDateTime dateNow = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        if (dateTimeThue.isAfter(dateNow)) {
                            if (dateTra.getDate() == null) {
                                new ThongBaoDialog("Vui lòng nhập ngày trả", 1);
                                editorTra.requestFocus();
                            } else {
                                Calendar cdTra = Calendar.getInstance();
                                cdTra.setTime(dateTra.getDate());
                                LocalDateTime dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                                if (dateTimeTra.isAfter(dateTimeThue)) {
                                    int countHour = (int) ChronoUnit.HOURS.between(dateTimeThue, dateTimeTra);
                                    if (countHour % 24 == 0 && countHour != 0) {
                                        new ThongBaoDialog("Có vẻ bạn muốn thuê phòng theo ngày vui lòng cân nhắc", 1);
                                    } else if (countHour == 0) {
                                        new ThongBaoDialog("Không thể thuê phòng ít hơn 1 giờ", 1);
                                    } else {
                                        dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour() - 2, timeThue.getMinute(), 0);
                                        dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                                        String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                        String dateTimeTrastr = dateTimeTra.format(dateTimeFormatCheck);
                                        ArrayList<PhongDTO> listPTmp = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                                        ArrayList<PhongDTO> listNew = new ArrayList<>();
                                        boolean check;
                                        for (PhongDTO x : listPTmp) {
                                            check = false;
                                            for (Object[] obj : listPT) {
                                                if (x.getMaP().equals(obj[0].toString())) {
                                                    check = true;
                                                    break;
                                                }
                                            }
                                            if (!check) {
                                                listNew.add(x);
                                            }
                                        }
                                        if (listNew.isEmpty()) {
                                            new ThongBaoDialog("Không còn phòng trống", ThongBaoDialog.INFO_DIALOG);
                                            tb.renderTB();
                                        } else {
                                            tb.renderTB(listNew);
                                        }
                                        dateThue.setEnabled(false);
                                        dateTra.setEnabled(false);
                                        timeThue.setEnable(false);
                                        timeTra.setEnable(false);
                                    }
                                } else {
                                    new ThongBaoDialog("Vui lòng nhập ngày giờ trả phải hơn ngày thuê", 1);
                                }
                            }
                        } else {
                            new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                        }
                    }
                } else if (rdKhac.isSelected()) {
                    if (dateThue.getDate() == null) {
                        new ThongBaoDialog("Vui lòng nhập ngày thuê", 1);
                        editorThue.requestFocus();
                    } else {
                        Calendar cd = Calendar.getInstance();
                        cd.setTime(dateThue.getDate());
                        LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour(), timeThue.getMinute(), 0);
                        LocalDateTime dateNow = LocalDateTime.now();
                        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        if (dateTimeThue.isAfter(dateNow)) {
                            dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour() - 2, timeThue.getMinute(), 0);
                            String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                            ArrayList<PhongDTO> listPTmp = PhongBUS.getListP(dateTimeThuestr, "", false);
                            ArrayList<PhongDTO> listNew = new ArrayList<>();
                            boolean check;
                            for (PhongDTO x : listPTmp) {
                                check = false;
                                for (Object[] obj : listPT) {
                                    if (x.getMaP().equals(obj[0].toString())) {
                                        check = true;
                                        break;
                                    }
                                }
                                if (!check) {
                                    listNew.add(x);
                                }
                            }
                            if (listNew.isEmpty()) {
                                new ThongBaoDialog("Không còn phòng trống", ThongBaoDialog.INFO_DIALOG);
                                tb.renderTB();
                            } else {
                                tb.renderTB(listNew);
                            }
                            dateThue.setEnabled(false);
                            dateTra.setEnabled(false);
                            timeThue.setEnable(false);
                            timeTra.setEnable(false);
                        } else {
                            new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                        }
                    }
                }
            }
        });
        btnAceptRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tb.getSelectedRow() != -1) {
                    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    if (rdNgay.isSelected()) {
                        Calendar cd = Calendar.getInstance();
                        cd.setTime(dateThue.getDate());
                        LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour(), timeThue.getMinute(), 0);
                        Calendar cdTra = Calendar.getInstance();
                        cdTra.setTime(dateTra.getDate());
                        LocalDateTime dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                        int subDate = (int) ChronoUnit.DAYS.between(dateTimeThue, dateTimeTra);
                        String maP = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã phòng")).toString();
                        String tenP = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Tên phòng")).toString();
                        int giaP = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Giá phòng")).toString().replace(",", "").split(" ")[0]);
                        Object[] data = {maP, tenP, "Đang xử lý", "Theo Ngày", dateTimeThue.format(dateTimeFormat), dateTimeTra.format(dateTimeFormat), dcf.format(giaP), dcf.format((subDate * giaP))};
                        listPT.add(data);
                        tbPhongThue.renderTB(listPT);
                        long total = 0;
                        for (Object data1[] : listPT) {
                            total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
                        }
                        txtTotalRoom.setText(dcf.format(total));
                        editorThue.setText("");
                        editorTra.setText("");
                        dateThue.setEnabled(true);
                        dateTra.setEnabled(true);
                        timeThue.setEnable(true);
                        tb.renderTB();
                    } else if (rdGio.isSelected()) {
                        Calendar cd = Calendar.getInstance();
                        cd.setTime(dateThue.getDate());
                        LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour(), timeThue.getMinute(), 0);
                        Calendar cdTra = Calendar.getInstance();
                        cdTra.setTime(dateTra.getDate());
                        LocalDateTime dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                        int countHour = (int) ChronoUnit.HOURS.between(dateTimeThue, dateTimeTra);
                        String maP = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã phòng")).toString();
                        String tenP = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Tên phòng")).toString();
                        int giaP = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Giá phòng")).toString().replace(",", "").split(" ")[0]);
                        int gia = 0;
                        if (countHour <= 24) {
                            if (countHour == 1) {
                                gia = giaP * 15 / 100;
                            } else if (countHour == 2) {
                                gia = giaP * 20 / 100;
                            } else if (countHour == 3) {
                                gia = giaP * 30 / 100;
                            } else if (countHour > 3 && countHour <= 12) {
                                gia = giaP / 2;
                            } else {
                                gia = giaP;
                            }
                        } else {
                            gia = (countHour / 24) * giaP;
                            if (countHour % 24 == 1) {
                                gia += giaP * 15 / 100;
                            } else if (countHour % 24 == 2) {
                                gia += giaP * 20 / 100;
                            } else if (countHour % 24 == 3) {
                                gia += giaP * 30 / 100;
                            } else if (countHour % 24 > 3 && countHour % 24 <= 12) {
                                gia += giaP / 2;
                            } else {
                                gia += giaP;
                            }
                        }
                        Object[] data = {maP, tenP, "Đang xử lý", "Theo Ngày", dateTimeThue.format(dateTimeFormat), dateTimeTra.format(dateTimeFormat), dcf.format(giaP), dcf.format(gia)};
                        listPT.add(data);
                        tbPhongThue.renderTB(listPT);
                        long total = 0;
                        for (Object data1[] : listPT) {
                            total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
                        }
                        txtTotalRoom.setText(dcf.format(total));
                        editorThue.setText("");
                        editorTra.setText("");
                        dateThue.setEnabled(true);
                        dateTra.setEnabled(true);
                        timeThue.setEnable(true);
                        timeTra.setEnable(true);
                        tb.renderTB();
                    } else if (rdKhac.isSelected()) {
                        String maP = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã phòng")).toString();
                        String tenP = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Tên phòng")).toString();
                        int giaP = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Giá phòng")).toString().replace(",", "").split(" ")[0]);
                        Calendar cd = Calendar.getInstance();
                        cd.setTime(dateThue.getDate());
                        LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour(), timeThue.getMinute(), 0);
                        LocalDateTime dateNow = LocalDateTime.now();
                        Object[] data = {maP, tenP, "Đang xử lý", "Khác", dateTimeThue.format(dateTimeFormat), "Chưa xác định", dcf.format(giaP), "Chưa tính"};
                        listPT.add(data);
                        tbPhongThue.renderTB(listPT);
                        long total = 0;
                        for (Object data1[] : listPT) {
                            try {
                                total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
                            } catch (Exception ex) {
                            }
                        }
                        txtTotalRoom.setText(dcf.format(total));
                        editorThue.setText("");
                        editorTra.setText("");
                        dateThue.setEnabled(true);
                        timeThue.setEnabled(true);
                        tb.renderTB();
                    }
                } else {
                    new ThongBaoDialog("Vui lòng chọn phòng thuê", 1);
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listPT.isEmpty()) {
                    new ThongBaoDialog("Vui lòng chọn phòng muốn thuê", 1);
                } else {
                    ThuePhong();
                }
            }
        });

        tbCTTDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tbCTTDV.getSelectedRow() != -1 && !check) {
                    tbCTTDV.setSelectionBackground(Color.decode("#F5F5F5"));

                    new InfoDV();
                }
            }
        });

        tbPhongThue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu pm = new JPopupMenu();
                    JMenuItem miX = new JMenuItem("Xóa");
                    pm.add(miX);
                    pm.setBackground(Color.white);
                    pm.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));
                    miX.setBackground(Color.white);
                    miX.setBorder(new EmptyBorder(0, 5, 0, 20));
                    miX.setFont(sgUI13);
                    miX.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    pm.show(tbPhongThue, e.getX(), e.getY());
                    miX.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tbPhongThue.getSelectedRow() != -1) {
                                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phòng thuê này", "Thông báo", JOptionPane.YES_NO_OPTION);
                                if (ans == JOptionPane.YES_OPTION) {
                                    listPT.remove(tbPhongThue.getSelectedRow());
                                    tbPhongThue.renderTB(listPT);
                                    long total = 0;
                                    for (Object data[] : listPT) {
                                        String str = (String) data[7];
                                        try {
                                            total += (long) dcf.parse(str);
                                        } catch (ParseException ex) {
                                        }
                                    }
                                    txtTotal.setText(dcf.format(total));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng thuê cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                }
            }
        });
        tbCTTRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu pm = new JPopupMenu();
                    JMenuItem miL = new JMenuItem("Lấy phòng");
                    JMenuItem miT = new JMenuItem("Trả phòng");
                    JMenuItem miX = new JMenuItem("Xóa phòng");
                    pm.add(miL);
                    pm.add(miT);
                    pm.add(miX);
                    pm.setBackground(Color.white);
                    pm.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));
                    miX.setBackground(Color.white);
                    miX.setBorder(new EmptyBorder(0, 5, 0, 20));
                    miX.setFont(sgUI13);
                    miX.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    miL.setBackground(Color.white);
                    miL.setBorder(new EmptyBorder(0, 5, 0, 20));
                    miL.setFont(sgUI13);
                    miL.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    miT.setBackground(Color.white);
                    miT.setBorder(new EmptyBorder(0, 5, 0, 20));
                    miT.setFont(sgUI13);
                    miT.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    pm.show(tbCTTRoom, e.getX(), e.getY());
                    miX.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tbCTTRoom.getSelectedRow() != -1) {
                                String check = "Đang được thuê";
                                String check2 = "Đã trả phòng";
                                if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check)) {
                                    new ThongBaoDialog("Phòng hiện đang thuê không được xóa", 1);
                                } else if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check2)) {
                                    new ThongBaoDialog("Phòng đã trả không thể xóa phòng", 1);
                                } else {
                                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phòng thuê này", "Thông báo", JOptionPane.YES_NO_OPTION);
                                    if (ans == JOptionPane.YES_OPTION) {
                                        String maP = tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Mã phòng")).toString().trim();
                                        String dateTimeThue = tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Ngày thuê")).toString().trim();
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                        SimpleDateFormat sdfInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        Date date = null;
                                        try {
                                            date = sdf.parse(dateTimeThue);
                                        } catch (ParseException ex) {
                                        }
                                        if (ChiTietThuePhongBUS.deleteCTTPhong(txtMaCTT.getText().trim(), maP, sdfInsert.format(date))) {
                                            new ThongBaoDialog("Xóa phòng thuê này thành công", 2);
                                            tbCTTRoom.renderTB(ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT().trim()));
                                            setTextTotal();
                                        } else {
                                            new ThongBaoDialog("Xóa phòng thuê này không thành công", 1);
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng thuê cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    miL.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tbCTTRoom.getSelectedRow() != -1) {
                                String check = "Đang được thuê";
                                String check2 = "Đã trả phòng";
                                if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check)) {
                                    new ThongBaoDialog("Phòng hiện đang thuê không được lấy phòng", 1);
                                } else if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check2)) {
                                    new ThongBaoDialog("Phòng đã trả không thể lấy phòng", 1);
                                } else {
                                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn lấy phòng này", "Thông báo", JOptionPane.YES_NO_OPTION);
                                    if (ans == JOptionPane.YES_OPTION) {
                                        String maP = tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Mã phòng")).toString().trim();
                                        String dateTimeThue = tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Ngày thuê")).toString().trim();
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                        SimpleDateFormat sdfInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        Date date = null;
                                        try {
                                            date = sdf.parse(dateTimeThue);
                                        } catch (ParseException ex) {
                                        }
                                        if (ChiTietThuePhongBUS.updateTT(txtMaCTT.getText().trim(), maP, sdfInsert.format(date), 1) && PhongBUS.updateTT(maP, 1)) {
                                            new ThongBaoDialog("Lấy phòng thuê này thành công", 2);
                                            tbCTTRoom.renderTB(ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT().trim()));
                                            setTextTotal();
                                            tbpCTT.add("Dịch vụ", pnService);
                                        } else {
                                            new ThongBaoDialog("Lấy phòng thuê này không thành công", 1);
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng thuê cần lấy", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    miT.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tbCTTRoom.getSelectedRow() != -1) {
                                String check = "Đang xử lý";
                                String check2 = "Đã trả phòng";
                                if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check)) {
                                    new ThongBaoDialog("Phòng hiện chưa thuê không được trả phòng", 1);
                                } else if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check2)) {
                                    new ThongBaoDialog("Phòng đã trả không thể trả phòng", 1);
                                } else {
                                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn trả phòng này", "Thông báo", JOptionPane.YES_NO_OPTION);
                                    if (ans == JOptionPane.YES_OPTION) {
                                        String maP = tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Mã phòng")).toString().trim();
                                        String dateTimeThue = tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Ngày thuê")).toString().trim();
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                        SimpleDateFormat sdfInsert = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        Date date = null;
                                        try {
                                            date = sdf.parse(dateTimeThue);
                                        } catch (ParseException ex) {
                                        }
                                        Date dateT = null;
                                        try {
                                            dateT = sdf.parse(dateTimeThue);
                                        } catch (ParseException ex) {
                                        }
                                        if (tbCTTRoom.getValueAt(tbCTTRoom.getSelectedRow(), tbCTTRoom.getColumnModel().getColumnIndex("Ngày trả")).toString().equals("")) {
                                            LocalDateTime lcd = LocalDateTime.now();
                                            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                            if (ChiTietThuePhongBUS.updateTT(txtMaCTT.getText().trim(), maP, sdfInsert.format(date), 2) && PhongBUS.updateTT(maP, 2)
                                                    && ChiTietThuePhongBUS.updateCK(txtMaCTT.getText().trim(), maP, sdfInsert.format(date), lcd.format(dateTimeFormat))
                                                    && ChiTietThuePhongBUS.updateT(txtMaCTT.getText().trim(), maP, sdfInsert.format(date), lcd.format(dateTimeFormat))) {
                                                new ThongBaoDialog("Trả phòng thuê này thành công", 2);
                                                tbCTTRoom.renderTB(ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT().trim()));
                                                if (ChiTietThuePhongBUS.count(chiTietThue.getMaCTT().trim()) == 0) {
                                                    tbpCTT.remove(pnService);
                                                }
                                                setTextTotal();
                                            } else {
                                                new ThongBaoDialog("Trả phòng thuê này không thành công", 1);
                                            }
                                        } else {
                                            LocalDateTime lcd = LocalDateTime.now();
                                            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                            if (ChiTietThuePhongBUS.updateTT(txtMaCTT.getText().trim(), maP, sdfInsert.format(date), 2) && PhongBUS.updateTT(maP, 2)
                                                    && ChiTietThuePhongBUS.updateCK(txtMaCTT.getText().trim(), maP, sdfInsert.format(date), lcd.format(dateTimeFormat))) {
                                                new ThongBaoDialog("Trả phòng thuê này thành công", 2);
                                                tbCTTRoom.renderTB(ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT().trim()));
                                                if (ChiTietThuePhongBUS.count(chiTietThue.getMaCTT().trim()) == 0) {
                                                    tbpCTT.remove(pnService);
                                                }
                                                setTextTotal();
                                            } else {
                                                new ThongBaoDialog("Trả phòng thuê này không thành công", 1);
                                            }
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng thuê cần trả", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                }
            }
        });

        tbpCTT.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tbpCTT.getSelectedIndex() == 0) {
                    tbCTTRoom.renderTB(ChiTietThuePhongBUS.getListTPofCTT(chiTietThue.getMaCTT().trim()));
                    tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(chiTietThue.getMaCTT().trim()));
                    setTextTotal();
                } else {
                    if (tbpCTT.getSelectedIndex() == 2) {
                        setItemService();
                        renderService(listItemService);
                    }
                }
            }
        });

        tbPhongThue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu pm = new JPopupMenu();
                    JMenuItem miX = new JMenuItem("Xóa");
                    pm.add(miX);
                    pm.setBackground(Color.white);
                    pm.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));
                    miX.setBackground(Color.white);
                    miX.setBorder(new EmptyBorder(0, 5, 0, 20));
                    miX.setFont(sgUI13);
                    miX.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    pm.show(tbPhongThue, e.getX(), e.getY());
                    miX.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tbPhongThue.getSelectedRow() != -1) {
                                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phòng thuê này", "Thông báo", JOptionPane.YES_NO_OPTION);
                                if (ans == JOptionPane.YES_OPTION) {
                                    listPT.remove(tbPhongThue.getSelectedRow());
                                    tbPhongThue.renderTB(listPT);
                                    long total = 0;
                                    for (Object data[] : listPT) {
                                        String str = (String) data[7];
                                        try {
                                            total += (long) dcf.parse(str);
                                        } catch (ParseException ex) {
                                        }
                                    }
                                    txtTotal.setText(dcf.format(total));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng thuê cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                }
            }
        });

        // pnService
        pnService.setLayout(new BorderLayout(5, 5));
        pnService.add(pnServiceList, BorderLayout.CENTER);
        pnService.add(pnServiceAction, BorderLayout.EAST);
        pnService.setBackground(Color.white);
        pnServiceListTop.setBackground(Color.white);
        pnServiceList.setBackground(Color.white);
        pnServiceAction.setBackground(Color.white);
        pnServiceListCenter.setBackground(Color.white);
        pnServiceList.setLayout(new BorderLayout());
        pnServiceList.add(pnServiceListTop, BorderLayout.NORTH);
        pnServiceList.add(pnServiceListCenter, BorderLayout.CENTER);
        pnServiceListTop.setLayout(new GridLayout(2, 1));
        pnServiceListTop.add(lbServiceListTop);
        pnServiceListTop.add(lbServiceListTopDetail);
        lbServiceListTop.setFont(sgUI15);
        lbServiceListTopDetail.setFont(tNR13i);
        pnServiceListTop.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
        pnServiceListTop.setBackground(Color.decode("#F0FFF0"));
        pnServiceListCenter.setLayout(new BorderLayout());

        pnServiceListCenter.add(pnServiceListCenterTop, BorderLayout.NORTH);
        pnServiceListCenterTop.setLayout(new BorderLayout());
        pnServiceListCenterTop.add(pnServiceListCenterSearch, BorderLayout.CENTER);
        pnServiceListCenterTop.add(pnServiceListCenterCb, BorderLayout.EAST);
        pnServiceListCenterSearch.setLayout(new BorderLayout());
        pnServiceListCenterSearch.add(txtSearch, BorderLayout.CENTER);
        pnServiceListCenterSearch.add(lbImg, BorderLayout.EAST);
        pnServiceListCenterSearch.setBackground(Color.decode("#FAFAFA"));
        pnServiceListCenterSearch.setBorder(new EmptyBorder(7, 10, 7, 10));
        txtSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnServiceListCenterSearch.setPreferredSize(new Dimension(100, 45));
        pnServiceListCenterSearch.setMaximumSize(new Dimension(100, 45));
        pnServiceListCenterCb.setLayout(new BorderLayout());
        pnServiceListCenterCb.add(cbLoaiDV_formRight, BorderLayout.CENTER);
        pnServiceListCenterCb.setBorder(new EmptyBorder(7, 0, 7, 10));
        pnServiceListCenterCb.setBackground(Color.decode("#FAFAFA"));
        pnServiceListCenterCb.setPreferredSize(new Dimension(200, 45));
        pnServiceListCenterCb.setMaximumSize(new Dimension(200, 45));
        cbLoaiDV_formRight.setBackground(Color.white);
        lbImg.setBackground(Color.white);
        lbImg.setOpaque(true);
        txtSearch.setFont(sgUI13);
        cbLoaiDV_formRight.setFont(sgUI13);
        lbImg.setBorder(new EmptyBorder(5, 5, 5, 5));

        lbServiceAction.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
        lbServiceAction.setBackground(Color.decode("#F0FFF0"));
        lbServiceAction.setOpaque(true);
        pnServiceAction.setLayout(new BorderLayout());
        pnServiceAction.add(lbServiceAction, BorderLayout.NORTH);
        lbServiceAction.setFont(sgUI15);
        pnServiceAction.setPreferredSize(new Dimension(420, 100));
        pnServiceAction.setMaximumSize(new Dimension(420, 100));

        pnServiceActionCenterButton.setBackground(Color.white);

        btnCancel.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.red), new EmptyBorder(5, 10, 5, 10)));
        btnCancel.setForeground(Color.red);
        btnCancel.setBackground(Color.white);
        btnCancel.setFocusPainted(false);
        btnCancel.setFont(sgUI13b);
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCancel.setForeground(Color.white);
                btnCancel.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCancel.setForeground(Color.red);
                btnCancel.setBackground(Color.white);
            }
        });

        btnSaveDV.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUpdateDV.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnSaveDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 10, 5, 10)));
        btnSaveDV.setForeground(Color.black);
        btnSaveDV.setBackground(Color.white);
        btnSaveDV.setFocusPainted(false);
        btnSaveDV.setFont(sgUI13b);
        btnSaveDV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSaveDV.setForeground(Color.white);
                btnSaveDV.setBackground(Color.decode("#00cc00"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSaveDV.setForeground(Color.black);
                btnSaveDV.setBackground(Color.white);
            }
        });

        btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#3399ff")), new EmptyBorder(5, 10, 5, 10)));
        btnUpdateDV.setForeground(Color.black);
        btnUpdateDV.setBackground(Color.white);
        btnUpdateDV.setFocusPainted(false);
        btnUpdateDV.setFont(sgUI13b);
        btnUpdateDV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnUpdateDV.setForeground(Color.white);
                btnUpdateDV.setBackground(Color.decode("#0066cc"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnUpdateDV.setForeground(Color.black);
                btnUpdateDV.setBackground(Color.white);
            }
        });

        btnDelete.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#cccc00")), new EmptyBorder(5, 10, 5, 10)));
        btnDelete.setForeground(Color.black);
        btnDelete.setBackground(Color.white);
        btnDelete.setFocusPainted(false);
        btnDelete.setFont(sgUI13b);
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDelete.setForeground(Color.black);
                btnDelete.setBackground(Color.decode("#ffff66"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDelete.setForeground(Color.black);
                btnDelete.setBackground(Color.white);
            }
        });

        scrpTable.setBackground(Color.white);
        scrpTable.getViewport().setBackground(Color.white);
        scrpTable.setBorder(BorderFactory.createEmptyBorder());
        scrpTable.setViewportView(tbListDV_TabDV);
        renderTB(data);

        pnServiceAction.add(pnServiceActionCenter, BorderLayout.CENTER);
        pnServiceActionCenter.setLayout(new BorderLayout());
        pnServiceActionCenter.add(scrpTable, BorderLayout.CENTER);
        pnServiceActionCenter.add(pnServiceActionCenterButton, BorderLayout.SOUTH);
        pnServiceActionCenterButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnServiceActionCenterButton.add(btnCancel);
        pnServiceActionCenterButton.add(btnDelete);
        pnServiceActionCenterButton.add(btnUpdateDV);
        pnServiceActionCenterButton.add(btnSaveDV);

        cbLoaiDV_formRight.removeAllItems();
        cbLoaiDV_formRight.addItem("Tất cả dịch vụ");
        cbLoaiDV_formRight.addItem("Thức ăn đồ uống");
        cbLoaiDV_formRight.addItem("Ăn uống");
        cbLoaiDV_formRight.addItem("Chăm sóc sắc đẹp");
        cbLoaiDV_formRight.addItem("Tổ chức tiệc");
        cbLoaiDV_formRight.addItem("Giải trí");

        cbLoaiDV_formRight.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });

        txtSearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSearch.getText().equals("Nhập Mã/Tên dịch vụ cần tìm...")) {
                    txtSearch.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtSearch.getText().trim().length() == 0) {
                    txtSearch.setText("Nhập Mã/Tên dịch vụ cần tìm...");
                }
            }
        });

        pnServiceListCenter.add(scpService, BorderLayout.CENTER);
        scpService.setBorder(new EmptyBorder(5, 5, 5, 5));
        scpService.setBackground(Color.white);
        scpService.getViewport().setBackground(Color.white);
        scpService.setViewportView(pnServiceListCenterShow);
        pnServiceListCenterShow.setLayout(new BoxLayout(pnServiceListCenterShow, BoxLayout.Y_AXIS));
        scpService.getVerticalScrollBar().setUnitIncrement(10);
        scpService.setVerticalScrollBar(new ScrollBar(Color.white, Color.white, 0));
        setItemService();

        renderService(listItemService);

        cbLoaiDV_formRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search();
            }
        });
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Search();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Search();
            }
        });

        // set background
        setBackground(Color.decode("#FAFAFA"));
        pnTop.setBackground(Color.decode("#FAFAFA"));
        pnContent.setBackground(Color.decode("#FAFAFA"));
        pnContentTop.setBackground(Color.white);

        pnContentCenter.setBackground(Color.decode("#FAFAFA"));
        pnKhachHangInput.setBackground(Color.decode("#FFFFFF"));
        pnMaKH.setBackground(Color.decode("#FFFFFF"));
        pnTenKH.setBackground(Color.decode("#FFFFFF"));
        pnCMND.setBackground(Color.decode("#FFFFFF"));
        pnGioiTinh.setBackground(Color.decode("#FFFFFF"));
        pnNgaySinh.setBackground(Color.decode("#FFFFFF"));
        pnSDT.setBackground(Color.decode("#FFFFFF"));
        pnQueQuan.setBackground(Color.decode("#FFFFFF"));
        pnQuocTich.setBackground(Color.decode("#FFFFFF"));
        pnRadio.setBackground(Color.decode("#FFFFFF"));
        rdNam.setBackground(Color.decode("#FFFFFF"));
        rdNu.setBackground(Color.decode("#FFFFFF"));
        tbpCTT.setBackground(Color.white);

        pnContentCenterCTT.setBackground(Color.white);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbListDV_TabDV.getSelectedRowCount() == 0) {
                    new ThongBaoDialog("Vui lòng chọn dịch vụ muốn xóa", 1);

                } else {
                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa những dịch vụ này", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_OPTION) {
                        for (int i = tbListDV_TabDV.getSelectedRowCount() - 1; i >= 0; i--) {
                            data.remove(tbListDV_TabDV.getSelectedRows()[i]);
                        }
                        new ThongBaoDialog("Xóa thành công những dịch vụ đã yêu cầu", 2);
                        renderTB(data);
                    } else {
                        renderTB(data);
                    }
                }
            }
        });

        btnSaveDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (data.isEmpty()) {
                    new ThongBaoDialog("Vui lòng chọn dịch vụ cần thuê", 1);
                } else {
                    int count = 0;
                    for (Object[] x : data) {
                        ChiTietThueDichVuDTO cttdv = new ChiTietThueDichVuDTO();
                        cttdv.setMaCTT(txtMaCTT.getText().trim());
                        cttdv.setMaDV(x[0].toString().trim());
                        cttdv.setSoLuong(Integer.parseInt(x[2].toString()));
                        cttdv.setGiaDV(Integer.parseInt(x[3].toString()));
                        LocalDate ldn = LocalDate.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        cttdv.setNgaySuDung(dateTimeFormatter.format(ldn));
                        count += ChiTietThueDichVuBUS.insertCTT(cttdv);
                        if (x[5].equals("Thức ăn đồ uống")) {
                            DichVuBUS.updateSL(x[0].toString(), -cttdv.getSoLuong());
                        }
                    }
                    if (count == data.size()) {
                        new ThongBaoDialog("Thêm dịch vụ thành công", 2);
                        data.clear();
                        renderTB(data);
                        txtSearch.setText("Nhập Mã/Tên dịch vụ cần tìm...");
                        cbLoaiDV_formRight.setSelectedIndex(0);
                        setItemService();
                        renderService(listItemService);
                    }
                }
            }
        });

        btnUpdateDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbListDV_TabDV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                if (tbListDV_TabDV.getSelectedRowCount() == 0) {
                    new ThongBaoDialog("Vui lòng chọn dịch vụ cần thay đổi", 4);
                } else {
                    new UpdateDV(data.get(tbListDV_TabDV.getSelectedRow()));
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muôn hủy thuê những dịch vụ này", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
                    data.clear();
                    renderTB(data);
                }
            }
        });

        pnAllCTTContent.setBackground(Color.decode("#FFFFFF"));
        tbCTTRoom.getTableHeader().setBackground(Color.decode("#3E9444"));
        tbCTTRoom.getTableHeader().setForeground(Color.white);
        tbCTTDV.getTableHeader().setBackground(Color.decode("#3E9444"));
        tbCTTDV.getTableHeader().setForeground(Color.white);
        tbPhongThue.getTableHeader().setBackground(Color.decode("#3E9444"));
        tbPhongThue.getTableHeader().setForeground(Color.white);
        scpAllCTTContentRoom.setVerticalScrollBar(new ScrollBar(Color.decode("#027D0A"), Color.white));
        scpAllCTTContentService.setVerticalScrollBar(new ScrollBar(Color.decode("#027D0A"), Color.white));
        pnRoom.setBackground(Color.decode("#FAFAFA"));
        tb.getTableHeader().setBackground(Color.decode("#3E9444"));
        tb.getTableHeader().setForeground(Color.white);
        tbListDV_TabDV.getTableHeader().setBackground(Color.decode("#3E9444"));
        tbListDV_TabDV.getTableHeader().setForeground(Color.white);
        tb.renderTB();
        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thanh toán không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < tbCTTRoom.getRowCount(); i++) {
                        if(tbCTTRoom.getValueAt(i, 3).toString().equals("Đang được thuê")) {
                            new ThongBaoDialog("Còn phòng đang được thuê vui lòng trả phòng trước khi thanh toán", ThongBaoDialog.INFO_DIALOG);
                            return;
                        }
                    }
                    new HoaDonLeTanGUI(chiTietThue, receptionistGUI);
                }
            }
        });
    }

    public void renderService(ArrayList<ItemService> list) {
        int count = 0;
        pnServiceListCenterShow.removeAll();
        pnServiceListCenterShow.revalidate();
        pnServiceListCenterShow.repaint();
        JPanel pnServiceTmp = new JPanel();
        pnServiceTmp.setBackground(Color.white);
        pnServiceTmp.setLayout(new GridLayout(1, 4, 5, 5));
        pnServiceTmp.setBorder(new MatteBorder(0, 0, 5, 0, Color.white));
        int check = 0;
        for (ItemService dv : list) {
            if (count == 4) {
                pnServiceListCenterShow.add(pnServiceTmp);
                check++;
                pnServiceTmp = new JPanel();
                pnServiceTmp.setBackground(Color.white);
                pnServiceTmp.setLayout(new GridLayout(1, 4, 5, 5));
                pnServiceTmp.setBorder(new MatteBorder(0, 0, 5, 0, Color.white));
                count = 0;
            }
            pnServiceTmp.add(dv);
            count++;
        }
        for (int i = count; i < 4; i++) {
            JPanel pnEmp = new JPanel();
            pnEmp.setBackground(Color.white);
            pnServiceTmp.add(pnEmp);
        }
        pnServiceListCenterShow.add(pnServiceTmp);
        for (int i = check; i < 2; i++) {
            JPanel pnEmp = new JPanel();
            pnEmp.setBackground(Color.white);
            pnServiceListCenterShow.add(pnEmp);
        }
    }

    public void ThuePhong() {
        int ans = JOptionPane.showConfirmDialog(null, "Vui lòng xác nhận lập phiếu thuê", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            int count = 0;
            for (Object x[] : listPT) {
                ChiTietThuePhongDTO cttP = new ChiTietThuePhongDTO();
                cttP.setMaCTT(txtMaCTT.getText().trim());
                cttP.setMaP((String) x[0]);
                Date date = new Date();
                SimpleDateFormat sdfChange = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                SimpleDateFormat sdfSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    date = sdfChange.parse((String) x[4]);
                } catch (ParseException ex) {
                }
                cttP.setNgayThue(sdfSql.format(date));
                if (((String) x[3]).equals("Theo Ngày")) {
                    cttP.setLoaiHinhThue(0);
                } else if (((String) x[3]).equals("Theo Giờ")) {
                    cttP.setLoaiHinhThue(1);
                } else {
                    cttP.setLoaiHinhThue(2);
                }
                if (!((String) x[3]).equals("Khác")) {
                    try {
                        date = sdfChange.parse((String) x[5]);
                        cttP.setNgayTra(sdfSql.format(date));
                        String tmp = (String) x[7];
                        int giaThue = Integer.parseInt(tmp = tmp.split(" ")[0].replace(",", ""));
                        cttP.setGiaThue(giaThue);
                    } catch (ParseException ex) {
                    }
                } else {
                    String tmp = (String) x[6];
                    int giaThue = Integer.parseInt(tmp = tmp.split(" ")[0].replace(",", ""));
                    cttP.setGiaThue(giaThue);
                }
                cttP.setTinhTrang(0);
                String checkCTTP = ChiTietThuePhongBUS.insertCTT(cttP);
                if (checkCTTP.equals("Thêm chi tiết thuê phòng mới thành công")) {
                    count++;
                }
            }
            if (count == listPT.size()) {
                new ThongBaoDialog("Thêm chi tiết thuê mới thành công", 2);
                tb.renderTB();
                listPT.clear();
                tbPhongThue.renderTB(listPT);
                editorThue.setText("");
                editorTra.setText("");
            }
        }
    }

    public void setTextTotal() {
        int total = 0;
        for (int i = 0; i < tbCTTRoom.getRowCount(); i++) {
            String check = "Đang được thuê";
            if (tbCTTRoom.getValueAt(i, tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals(check)
                    || tbCTTRoom.getValueAt(i, tbCTTRoom.getColumnModel().getColumnIndex("Tình trạng")).toString().equals("Đã trả phòng")) {
                try {
                    total += Integer.parseInt(tbCTTRoom.getValueAt(i, tbCTTRoom.getColumnModel().getColumnIndex("Giá thực")).toString().replace(",", "").split(" ")[0]);
                } catch (Exception ex) {
                }
            }
        }
        for (int i = 0; i < tbCTTDV.getRowCount(); i++) {
            try {
                total += Integer.parseInt(tbCTTDV.getValueAt(i, tbCTTDV.getColumnModel().getColumnIndex("Thành tiền")).toString().replace(",", "").split(" ")[0]);
            } catch (Exception ex) {
            }
        }
        txtTotal.setText(dcf.format(total));
    }

    public void Search() {
        ArrayList<ItemService> listAll = new ArrayList<>();
        for (ItemService x : listItemService) {
            listAll.add(x);
        }
        ArrayList<ItemService> listTmp = new ArrayList<>();
        if (!txtSearch.getText().trim().equals("Nhập Mã/Tên dịch vụ cần tìm...") || txtSearch.getText().trim().length() == 0) {
            for (ItemService x : listAll) {
                if (x.dichVu.getMaDV().trim().toUpperCase().contains(txtSearch.getText().trim().toUpperCase())
                        || x.dichVu.getTenDV().trim().toUpperCase().contains(txtSearch.getText().trim().toUpperCase())) {
                    listTmp.add(x);
                }
            }
            listAll.clear();
            for (ItemService x : listTmp) {
                listAll.add(x);
            }
            listTmp.clear();
        }
        if (cbLoaiDV_formRight.getSelectedIndex() != 0) {
            for (ItemService x : listAll) {
                if (x.dichVu.getLoaiDV().trim().toUpperCase().contains(cbLoaiDV_formRight.getSelectedItem().toString().trim().toUpperCase())) {
                    listTmp.add(x);
                }
            }
            listAll.clear();
            for (ItemService x : listTmp) {
                listAll.add(x);
            }
            listTmp.clear();
        }
        renderService(listAll);
    }

    public void ResetSearch() {
        txtSearch.setText("Nhập Mã/Tên dịch vụ cần tìm...");
        cbLoaiDV_formRight.setSelectedIndex(0);
        renderService(listItemService);
    }

    public void renderTB(ArrayList<Object[]> data) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Thành tiền");
        for (Object[] x : data) {
            Object[] obj = {x[1], x[2], dcf.format(x[3]), dcf.format(x[4])};
            dtm.addRow(obj);
        }
        tbListDV_TabDV.setModel(dtm);
        tbListDV_TabDV.setDefaultRenderer(Object.class, new TableDichVuCellRenderer_DV());
        tbListDV_TabDV.setRowHeight(30);
        tbListDV_TabDV.setShowGrid(false);
        tbListDV_TabDV.setIntercellSpacing(new Dimension(0, 0));
        tbListDV_TabDV.getTableHeader().setPreferredSize(new Dimension(1, 30));
        tbListDV_TabDV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbListDV_TabDV.getColumnModel().getColumn(0).setPreferredWidth(180);
        tbListDV_TabDV.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbListDV_TabDV.getColumnModel().getColumn(2).setPreferredWidth(120);
        tbListDV_TabDV.getColumnModel().getColumn(3).setPreferredWidth(120);
    }

    public class UpdateDV extends JDialog {

        JPanel pnContainer = new JPanel();
        JPanel pnTenDichVu = new JPanel();
        JLabel lbTenDichVu = new JLabel("Tên dịch vụ:");
        JLabel lbTenDichVu_data = new JLabel();
        JPanel pnInputSL = new JPanel();
        JTextField txtSL = new JTextField();
        JButton btnDown = new JButton();
        JButton btnUp = new JButton();
        JPanel pnButton = new JPanel();
        JButton btnCancel = new JButton("Hủy bỏ");
        JButton btnAcept = new JButton("Thay đổi");

        public UpdateDV(Object[] data_obj) {
            setTitle("Thông tin dịch vụ");
            setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
            setModal(true);
            setSize(300, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setLayout(new BorderLayout());
            add(pnContainer, BorderLayout.CENTER);
            pnContainer.setBackground(Color.white);
            pnContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnContainer.setLayout(new GridLayout(4, 1, 5, 5));
            pnContainer.add(pnTenDichVu);
            pnContainer.add(pnInputSL);
            JPanel pnEmp = new JPanel();
            pnEmp.setBackground(Color.white);
            pnTenDichVu.setBackground(Color.white);
            pnInputSL.setBackground(Color.white);
            pnButton.setBackground(Color.white);
            pnContainer.add(pnEmp);
            pnContainer.add(pnButton);

            pnTenDichVu.setLayout(new BorderLayout(5, 5));
            pnTenDichVu.add(lbTenDichVu, BorderLayout.NORTH);
            pnTenDichVu.add(lbTenDichVu_data, BorderLayout.CENTER);

            pnInputSL.setLayout(new BorderLayout());
            pnInputSL.add(btnDown, BorderLayout.WEST);
            pnInputSL.add(txtSL, BorderLayout.CENTER);
            pnInputSL.add(btnUp, BorderLayout.EAST);

            txtSL.setText(data_obj[2].toString());
            txtSL.setHorizontalAlignment(JLabel.CENTER);

            lbTenDichVu.setFont(sgUI13);
            lbTenDichVu_data.setFont(sgUI15);
            ImageIcon iconDown = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/double-left.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
            ImageIcon iconUp = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/double-right.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
            btnDown.setIcon(iconDown);
            btnUp.setIcon(iconUp);
            btnDown.setFocusPainted(false);
            btnUp.setFocusPainted(false);
            btnDown.setBackground(Color.white);
            btnUp.setBackground(Color.white);
            txtSL.setFont(sgUI15);

            pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
            pnButton.add(btnAcept);
            pnButton.add(btnCancel);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát thay đổi", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_OPTION) {
                        tbListDV_TabDV.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        dispose();
                    }
                }
            });

            lbTenDichVu_data.setText(data_obj[1].toString());

            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy bỏ thay đổi số lượng dịch vụ", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_OPTION) {
                        tbListDV_TabDV.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        dispose();
                    }
                }
            });

            btnUp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int sl = Integer.parseInt(txtSL.getText().trim());
                        if (sl <= 0) {
                            txtSL.setText("1");
                        } else if (data_obj[5].toString().equals("Thức ăn đồ uống")) {
                            if (sl < Integer.parseInt(data_obj[6].toString())) {
                                txtSL.setText((Integer.parseInt(txtSL.getText().trim()) + 1) + "");
                            }
                        } else {
                            txtSL.setText((Integer.parseInt(txtSL.getText().trim()) + 1) + "");
                        }
                    } catch (Exception ex) {
                        txtSL.setText("1");
                    }
                }
            });

            btnDown.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int sl = Integer.parseInt(txtSL.getText().trim());
                        if (sl <= 0) {
                            txtSL.setText("1");
                        } else if (data_obj[5].toString().equals("Thức ăn đồ uống")) {
                            if (sl > 1) {
                                txtSL.setText((Integer.parseInt(txtSL.getText().trim()) - 1) + "");
                            }
                        } else {
                            txtSL.setText((Integer.parseInt(txtSL.getText().trim()) - 1) + "");
                        }
                    } catch (Exception ex) {
                        txtSL.setText("1");
                    }
                }
            });

            btnUp.setBorderPainted(false);
            btnDown.setBorderPainted(false);

            pnInputSL.setBorder(new EmptyBorder(5, 5, 5, 5));
            btnUp.setContentAreaFilled(false);
            btnDown.setContentAreaFilled(false);

            btnAcept.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_OPTION) {
                        try {
                            int sl = Integer.parseInt(txtSL.getText().trim());
                            if (sl <= 0) {
                                new ThongBaoDialog("Số lượng phải lớn hơn 0", 4);
                            } else if (data_obj[5].toString().equals("Thức ăn đồ uống")) {
                                if (sl > Integer.parseInt(data_obj[6].toString())) {
                                    new ThongBaoDialog("Số lượng phải nhỏ hơn số lượng còn lại", 4);
                                } else {
                                    data_obj[2] = sl;
                                    data_obj[4] = Integer.parseInt(data_obj[3].toString()) * sl;
                                    new ThongBaoDialog("Thay đổi thành công", 2);
                                    dispose();
                                    tbListDV_TabDV.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                                    renderTB(data);
                                }
                            } else {
                                data_obj[2] = sl;
                                data_obj[4] = Integer.parseInt(data_obj[3].toString()) * sl;
                                new ThongBaoDialog("Thay đổi thành công", 2);
                                dispose();
                                tbListDV_TabDV.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                                renderTB(data);
                            }
                        } catch (Exception ex) {
                            new ThongBaoDialog("Số lượng phải là số nguyên", 1);
                        }
                    }
                }
            });

            btnCancel.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.red), new EmptyBorder(5, 10, 5, 10)));
            btnCancel.setForeground(Color.red);
            btnCancel.setBackground(Color.white);
            btnCancel.setFocusPainted(false);
            btnCancel.setFont(sgUI13b);
            btnCancel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnCancel.setForeground(Color.white);
                    btnCancel.setBackground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnCancel.setForeground(Color.red);
                    btnCancel.setBackground(Color.white);
                }
            });

            btnAcept.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 10, 5, 10)));
            btnAcept.setForeground(Color.black);
            btnAcept.setBackground(Color.white);
            btnAcept.setFocusPainted(false);
            btnAcept.setFont(sgUI13b);
            btnAcept.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnAcept.setForeground(Color.white);
                    btnAcept.setBackground(Color.decode("#00cc00"));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnAcept.setForeground(Color.black);
                    btnAcept.setBackground(Color.white);
                }
            });
            setVisible(true);
        }
    }

    public void setItemService() {
        listItemService.clear();
        for (DichVuDTO dv : DichVuBUS.getListDV()) {
            if ((dv.getLoaiDV().equals("Thức ăn đồ uống") && dv.getSoLuong() > 0)
                    || !dv.getLoaiDV().equals("Thức ăn đồ uống")) {
                listItemService.add(new ItemService((dv)));
            }
        }
        for (ItemService item : listItemService) {
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boolean check = false;
                    for (Object[] x : data) {
                        if (x[0].toString().equals(item.dichVu.getMaDV())) {
                            if (x[5].toString().equals("Thức ăn đồ uống")) {
                                if (Integer.parseInt(x[2].toString()) < item.dichVu.getSoLuong()) {
                                    x[2] = Integer.parseInt(x[2].toString()) + 1;
                                    x[4] = Integer.parseInt(x[2].toString()) * Integer.parseInt(x[3].toString());
                                }
                            } else {
                                x[2] = Integer.parseInt(x[2].toString()) + 1;
                                x[4] = Integer.parseInt(x[2].toString()) * Integer.parseInt(x[3].toString());
                            }
                            renderTB(data);
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        Object[] obj = {item.dichVu.getMaDV(), item.dichVu.getTenDV(), 1, item.dichVu.getGiaDV(), item.dichVu.getGiaDV(), item.dichVu.getLoaiDV(), item.dichVu.getSoLuong()};
                        data.add(obj);
                        renderTB(data);
                    }
                }
            });
        }
    }

    public class InfoDV extends JDialog {

        JPanel pnContainer = new JPanel();
        JLabel lbTenDV = new JLabel();
        JPanel pnContent = new JPanel();
        JPanel pnContentTop = new JPanel();
        JPanel pnContentButton = new JPanel();
        JButton btnUpdate = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnSave = new JButton("Lưu");
        JButton btnCancel = new JButton("Hủy");
        JPanel pnNgaySuDung = new JPanel();
        JLabel lbNgaySuDung = new JLabel("Ngày sử dụng:");
        JLabel lbNgaySuDung_info = new JLabel();

        JPanel pnSoLuong = new JPanel();
        JLabel lbSoLuong = new JLabel("Số lượng hiện tại:");
        JLabel lbSoLuong_info = new JLabel();

        JPanel pnUpDown = new JPanel();
        JRadioButton rdUp = new JRadioButton("Thêm");
        JRadioButton rdDown = new JRadioButton("Giảm");
        ButtonGroup bgUD = new ButtonGroup();

        JPanel pnChooseSL = new JPanel();
        JSpinner spnSL = new JSpinner();

        public InfoDV() {
            DichVuDTO x = DichVuBUS.searchDV(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString());
            setTitle("Thông tin dịch vụ");
            setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
            setModal(true);
            setSize(300, 300);
            setLocationRelativeTo(null);
            setResizable(false);
            setLayout(new BorderLayout());
            add(pnContainer, BorderLayout.CENTER);
            pnContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnContainer.setLayout(new BorderLayout());
            pnContainer.add(lbTenDV, BorderLayout.NORTH);
            lbTenDV.setFont(sgUI15);
            lbTenDV.setHorizontalAlignment(JLabel.CENTER);
            lbTenDV.setForeground(Color.decode("#0000cc"));
            if (tbCTTDV.getSelectedRow() != -1) {
                lbTenDV.setText(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Tên dịch vụ")).toString().toUpperCase());
                lbNgaySuDung_info.setText(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Ngày sử dụng")).toString());
                lbSoLuong_info.setText(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Số lượng")).toString());
            }
            pnContainer.setBackground(Color.white);
            pnContainer.add(pnContent, BorderLayout.CENTER);
            pnContent.setBackground(Color.white);
            pnContent.setLayout(new BorderLayout());
            pnContent.add(pnContentButton, BorderLayout.SOUTH);
            pnContent.add(pnContentTop, BorderLayout.CENTER);
            pnContentButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
            pnContentButton.add(btnDelete);
            pnContentButton.add(btnUpdate);
            pnContentButton.add(btnSave);
            pnContentButton.add(btnCancel);
            pnContentButton.setBackground(Color.white);

            pnContentTop.setBackground(Color.white);
            pnContentTop.setLayout(new GridLayout(4, 1));
            pnContentTop.add(pnNgaySuDung);
            pnContentTop.add(pnSoLuong);
            pnContentTop.add(pnUpDown);
            pnContentTop.add(pnChooseSL);
            pnChooseSL.setLayout(new BorderLayout());
            pnChooseSL.add(spnSL, BorderLayout.CENTER);
            pnChooseSL.setBackground(Color.white);
            pnChooseSL.setBorder(new EmptyBorder(5, 90, 5, 90));
            spnSL.setEnabled(false);
            spnSL.setFont(sgUI15);

            pnUpDown.setLayout(new GridLayout(1, 2));
            pnUpDown.add(rdUp);
            pnUpDown.add(rdDown);
            rdUp.setFocusPainted(false);
            rdUp.setFont(sgUI15p);
            rdUp.setBackground(Color.white);
            rdDown.setFocusPainted(false);
            rdDown.setFont(sgUI15p);
            rdDown.setBackground(Color.white);
            bgUD.add(rdUp);
            bgUD.add(rdDown);

            rdUp.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    rdUp.setFont(sgUI15);
                    rdDown.setFont(sgUI15p);
                    spnSL.setEnabled(true);
                    if (x.getLoaiDV().equals("Thức ăn đồ uống")) {
                        SpinnerModel sm = new SpinnerNumberModel(0, 0, x.getSoLuong(), 1);
                        spnSL.setModel(sm);
                    } else {
                        SpinnerModel sm = new SpinnerNumberModel(0, 0, null, 1);
                        spnSL.setModel(sm);
                    }
                }
            });

            rdDown.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    rdDown.setFont(sgUI15);
                    rdUp.setFont(sgUI15p);
                    spnSL.setEnabled(true);
                    SpinnerModel sm = new SpinnerNumberModel(0, 0, Integer.parseInt(lbSoLuong_info.getText().trim()) - 1, 1);
                    spnSL.setModel(sm);
                }
            });

            btnSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (rdDown.isSelected()) {
                        int SLNow = Integer.parseInt(lbSoLuong_info.getText().trim());
                        int SLDown = (int) spnSL.getValue();
                        int total = SLNow - SLDown;
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        SimpleDateFormat sdfInsert = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;
                        try {
                            date = sdf.parse(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Ngày sử dụng")).toString());
                        } catch (Exception ex) {
                        }
                        if (ChiTietThueDichVuBUS.UpdateCTTDV(txtMaCTT.getText().trim(), tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString(), sdfInsert.format(date), total)) {
                            if (DichVuBUS.updateSL(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString().trim(), SLDown) == 1) {
                                new ThongBaoDialog("Cập nhật dịch vụ thành công", 2);
                                dispose();
                                tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                                setTextTotal();
                            }
                        } else {
                            new ThongBaoDialog("Cập nhật dịch vụ thành công", 2);
                            dispose();
                            tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                            setTextTotal();
                        }
                    } else if (rdUp.isSelected()) {
                        int SLNow = Integer.parseInt(lbSoLuong_info.getText().trim());
                        int SLDown = (int) spnSL.getValue();
                        int total = SLNow + SLDown;
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        SimpleDateFormat sdfInsert = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;
                        try {
                            date = sdf.parse(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Ngày sử dụng")).toString());
                        } catch (Exception ex) {
                        }
                        if (ChiTietThueDichVuBUS.UpdateCTTDV(txtMaCTT.getText().trim(), tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString(), sdfInsert.format(date), total)) {
                            if (DichVuBUS.updateSL(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString().trim(), -SLDown) == 1) {
                                new ThongBaoDialog("Cập nhật dịch vụ thành công", 2);
                                dispose();
                                tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                                setTextTotal();
                            }
                        } else {
                            new ThongBaoDialog("Cập nhật dịch vụ thành công", 2);
                            dispose();
                            tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                            setTextTotal();
                        }
                    } else {
                        new ThongBaoDialog("Vui lòng chọn lựa chọn sửa thêm hay giảm", 1);
                        setButton(false);
                    }
                }
            });

            pnNgaySuDung.setLayout(new BorderLayout(5, 5));
            pnNgaySuDung.setBackground(Color.white);
            pnNgaySuDung.add(lbNgaySuDung, BorderLayout.WEST);
            pnNgaySuDung.add(lbNgaySuDung_info, BorderLayout.CENTER);
            lbNgaySuDung.setFont(sgUI15p);
            lbNgaySuDung_info.setFont(sgUI15);

            pnSoLuong.setLayout(new BorderLayout(5, 5));
            pnSoLuong.setBackground(Color.white);
            pnSoLuong.add(lbSoLuong, BorderLayout.WEST);
            pnSoLuong.add(lbSoLuong_info, BorderLayout.CENTER);
            lbSoLuong.setFont(sgUI15p);
            lbSoLuong_info.setFont(sgUI15);

            setButton(true);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                    setTextTotal();
                }
            });

            btnDelete.setFocusPainted(false);
            btnDelete.setFont(sgUI13b);
            btnUpdate.setFocusPainted(false);
            btnUpdate.setFont(sgUI13b);
            btnCancel.setFocusPainted(false);
            btnCancel.setFont(sgUI13b);
            btnSave.setFocusPainted(false);
            btnSave.setFont(sgUI13b);

            btnDelete.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#ffffff")), new EmptyBorder(5, 10, 5, 10)));
            btnUpdate.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#ffffff")), new EmptyBorder(5, 10, 5, 10)));
            btnCancel.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.white), new EmptyBorder(5, 10, 5, 10)));
            btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#ffffff")), new EmptyBorder(5, 10, 5, 10)));
            btnUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setButton(false);
                }
            });
            btnCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setButton(true);
                }
            });
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tbCTTDV.getSelectedRow() != -1) {
                        int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dịch vụ này", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (ans == JOptionPane.YES_OPTION) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            SimpleDateFormat sdfInsert = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = null;
                            try {
                                date = sdf.parse(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Ngày sử dụng")).toString());
                            } catch (Exception ex) {
                            }
                            if (ChiTietThueDichVuBUS.deleteCTTDV(txtMaCTT.getText().trim(), tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString(), sdfInsert.format(date))) {
                                if (x.getLoaiDV().equals("Thức ăn đồ uống")) {
                                    if (DichVuBUS.updateSL(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString().trim(), Integer.parseInt(tbCTTDV.getValueAt(tbCTTDV.getSelectedRow(), tbCTTDV.getColumnModel().getColumnIndex("Số lượng")).toString())) == 1) {
                                        new ThongBaoDialog("Xóa dịch vụ thành công", 2);
                                        dispose();
                                        tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                                        setTextTotal();
                                    }
                                } else {
                                    new ThongBaoDialog("Xóa dịch vụ thành công", 2);
                                    dispose();
                                    tbCTTDV.renderTB(ChiTietThueDichVuBUS.getListTDVofCTT(txtMaCTT.getText().trim()));
                                    setTextTotal();
                                }
                            } else {
                                new ThongBaoDialog("Xóa dịch vụ không thành công", 1);
                                dispose();
                            }
                        }
                    }
                }
            });
            setVisible(true);
        }

        public void setButton(boolean check) {
            btnDelete.setEnabled(check);
            btnUpdate.setEnabled(check);
            btnSave.setEnabled(!check);
            btnCancel.setEnabled(!check);
            if (check) {
                btnSave.setBackground(Color.decode("#F8f8f8"));
                btnCancel.setBackground(Color.decode("#F8f8f8"));
                btnDelete.setBackground(Color.white);
                btnUpdate.setBackground(Color.white);
                btnSave.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnSave.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnSave.setBackground(Color.decode("#F8f8f8"));
                    }
                });
                btnCancel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnCancel.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnCancel.setBackground(Color.decode("#F8f8f8"));
                    }
                });
                btnDelete.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDelete.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDelete.setBackground(Color.white);
                    }
                });
                btnUpdate.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnUpdate.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnUpdate.setBackground(Color.white);
                    }
                });
            } else {
                btnDelete.setBackground(Color.decode("#F8f8f8"));
                btnUpdate.setBackground(Color.decode("#F8f8f8"));
                btnSave.setBackground(Color.white);
                btnCancel.setBackground(Color.white);
                btnSave.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnSave.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnSave.setBackground(Color.decode("#ffffff"));
                    }
                });
                btnCancel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnCancel.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnCancel.setBackground(Color.decode("#ffffff"));
                    }
                });
                btnDelete.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnDelete.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnDelete.setBackground(Color.decode("#F8f8f8"));
                    }
                });
                btnUpdate.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnUpdate.setBackground(Color.decode("#F8f8f8"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnUpdate.setBackground(Color.decode("#F8f8f8"));
                    }
                });
            }
        }
    }
}
