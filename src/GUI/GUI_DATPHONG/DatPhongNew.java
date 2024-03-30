package GUI.GUI_DATPHONG;

import BUS.ChiTietThueBUS;
import BUS.ChiTietThuePhongBUS;
import BUS.KhachHangBUS;
import BUS.PhongBUS;
import DTO.ChiTietThueDTO;
import DTO.ChiTietThuePhongDTO;
import DTO.KhachHangDTO;
import DTO.PhongDTO;
import GUI.GUI_BASIC.ReceptionistGUI;
import GUI.GUI_PHONG.SoDoPhongReceptionist;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.GUI_RENDER_COMPONENTS.TimeChoose;
import GUI.ThongBaoDialog;
import GUI.mainGUI;
import com.toedter.calendar.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;

public class DatPhongNew extends JPanel {

    // panel tiêu đề
    DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
    JPanel pnTop = new JPanel();
    JLabel lbTop = new JLabel("Thông tin thuê phòng mới");
    JLabel lbDetail = new JLabel("Vui lòng điền thông tin khách hàng và chọn phòng khách muốn thuê");

    // panel khách hàng
    JPanel pnKhachHang = new JPanel();
    JPanel pnKhachHangTop = new JPanel();
    JLabel lbKhachHang = new JLabel("Thông tin khách hàng");
    JLabel lbKhachHangDetail = new JLabel("Vui lòng nhập chứng minh nhân dân để tìm khách hàng");
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

    // panel Thuê phòng
    JPanel pnThuePhong = new JPanel();
    JPanel pnThuePhongContent = new JPanel();
    JPanel pnThuePhongContentTop = new JPanel();
    JPanel pnThuePhongContentTopCTT = new JPanel();
    JPanel pnThuePhongContentTopPT = new JPanel();
    JPanel pnThuePhongContentDSPT = new JPanel();

    JLabel lbThuePhongContentTopCTT = new JLabel("Thông tin phiếu đặt phòng");
    JPanel pnThuePhongContentTopCTTCenter = new JPanel();
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
    JPanel pnEmpty = new JPanel();

    JScrollPane scrp = new JScrollPane();
    public TablePhongThue tbPhongThue = new TablePhongThue();
    public JPanel pnThuePhongContentDSPTBottom = new JPanel();
    public JPanel pnThuePhongContentDSPTBottomTotal = new JPanel();
    JLabel lbTotal = new JLabel("Tổng cộng:");
    public JTextField txtTotal = new JTextField();

    JLabel lbThuePhongContentTopPT = new JLabel("Thông tin phòng thuê");
    JPanel pnThuePhongContentTopPTCenter = new JPanel();
    JPanel pnLoaiHinhThue = new JPanel();
    JPanel pnEmp = new JPanel();
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
    JPanel pnPhong = new JPanel();
    JPanel pnPhongButton = new JPanel();
    JButton btnAceptRoom = new JButton("   Xác nhận   ");
    // panel button
    JPanel pnButton = new JPanel();
    JButton btnAcept = new JButton("Xác nhận đặt phòng");

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    Font tNR13i = new Font("Segoe UI", Font.ITALIC, 13);

    public ArrayList<Object[]> listPT = new ArrayList<>();
    public PhongDTO p = new PhongDTO();

    public DatPhongNew(PhongDTO p) {
        this.p = p;
        initComponents();
    }

    public DatPhongNew(Object[] data) {
        listPT.add(data);
        initComponents();
        tbPhongThue.renderTB(listPT);
        long total = 0;
        try {
            for (Object data1[] : listPT) {
                total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
            }
        } catch (Exception ex) {
        }
        txtTotal.setText(dcf.format(total));
        pnThuePhongContentDSPTBottomTotal.revalidate();
        pnThuePhongContentDSPTBottomTotal.repaint();

    }

    public void initComponents() {
        setLayout(new BorderLayout(10, 5));
        add(pnTop, BorderLayout.NORTH);
        add(pnKhachHang, BorderLayout.WEST);
        add(pnThuePhong, BorderLayout.CENTER);
//        add(pnButton, BorderLayout.SOUTH);

        // edit tiêu đề
        pnTop.setLayout(new GridLayout(2, 1));
        pnTop.add(lbTop);
        pnTop.add(lbDetail);

        lbTop.setFont(sgUI18b);
        lbDetail.setFont(tNR13i);
        // edit khách hàng
        pnKhachHang.setLayout(new BorderLayout());
        pnKhachHang.add(pnKhachHangTop, BorderLayout.NORTH);
        pnKhachHang.add(pnKhachHangInput, BorderLayout.CENTER);
        lbKhachHang.setFont(sgUI15);
        lbKhachHangDetail.setFont(tNR13i);
        pnKhachHangTop.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 5, 5, 5)));
        pnKhachHangTop.setBackground(Color.decode("#F0FFF0"));
        pnKhachHangTop.setLayout(new GridLayout(2, 1));
        pnKhachHangTop.add(lbKhachHang);
        pnKhachHangTop.add(lbKhachHangDetail);
        pnKhachHangInput.setLayout(new GridLayout(8, 1));
        pnKhachHangInput.setBorder(new EmptyBorder(5, 15, 5, 15));
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

        pnTenKH.setLayout(new GridLayout(2, 1));
        pnTenKH.add(lbTenKH);
        pnTenKH.add(txtTenKH);

        pnCMND.setLayout(new GridLayout(2, 1));
        pnCMND.add(lbCMND);
        pnCMND.add(txtCMND);

        pnNgaySinh.setLayout(new GridLayout(2, 1));
        pnNgaySinh.add(lbNgaySinh);
        pnNgaySinh.add(dateNgaySinh);

        pnSDT.setLayout(new GridLayout(2, 1));
        pnSDT.add(lbSDT);
        pnSDT.add(txtSDT);

        pnQueQuan.setLayout(new GridLayout(2, 1));
        pnQueQuan.add(lbQueQuan);
        pnQueQuan.add(txtQueQuan);

        pnQuocTich.setLayout(new GridLayout(2, 1));
        pnQuocTich.add(lbQuocTich);
        pnQuocTich.add(txtQuocTich);

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
        txtSDT.setEditable(false);
        txtTenKH.setEditable(false);
        dateNgaySinh.setEnabled(false);
        rdNam.setSelected(true);
        rdNam.setEnabled(false);
        rdNam.setFont(sgUI13b);
        rdNu.setEnabled(false);
        dateNgaySinh.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateNgaySinh.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
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

        txtMaKH.setBackground(Color.decode("#F8f8f8"));
        txtSDT.setBackground(Color.decode("#F8f8f8"));
        txtQueQuan.setBackground(Color.decode("#F8f8f8"));
        txtQuocTich.setBackground(Color.decode("#F8f8f8"));
        txtTenKH.setBackground(Color.decode("#F8f8f8"));
        dateNgaySinh.setDateFormatString("dd-MM-yyyy");

        txtSDT.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (txtSDT.getText().trim().length() >= 10) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        txtCMND.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (txtCMND.getText().trim().length() >= 12) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (txtCMND.getText().trim().length() >= 9) {
                    txtTenKH.setEditable(true);
                    txtQueQuan.setEditable(true);
                    txtQuocTich.setEditable(true);
                    txtSDT.setEditable(true);
                    dateNgaySinh.setEnabled(true);
                    rdNam.setEnabled(true);
                    rdNu.setEnabled(true);
                } else {
                    txtTenKH.setEditable(false);
                    txtQueQuan.setEditable(false);
                    txtQuocTich.setEditable(false);
                    txtSDT.setEditable(false);
                    dateNgaySinh.setEnabled(false);
                    rdNam.setEnabled(false);
                    rdNu.setEnabled(false);
                }
                if (txtCMND.getText().trim().length() >= 9) {
                    txtTenKH.setBackground(Color.white);
                    txtQueQuan.setBackground(Color.white);
                    txtQuocTich.setBackground(Color.white);
                    txtSDT.setBackground(Color.white);
                    editor.setBackground(Color.white);
                } else {
                    txtSDT.setBackground(Color.decode("#F8f8f8"));
                    txtQueQuan.setBackground(Color.decode("#F8f8f8"));
                    txtQuocTich.setBackground(Color.decode("#F8f8f8"));
                    txtTenKH.setBackground(Color.decode("#F8f8f8"));
                    editor.setBackground(Color.decode("#f8f8f8"));
                }
                for (KhachHangDTO x : KhachHangBUS.getListKH()) {
                    if (x.getCMND().trim().equals(txtCMND.getText().trim())) {
                        new FormFindCustomer(txtCMND.getText().trim(), DatPhongNew.this);
                        break;
                    } else {
                        txtMaKH.setText("");
                        txtTenKH.setText("");
                        txtQueQuan.setText("");
                        txtQuocTich.setText("");
                        txtSDT.setText("");
                        editor.setText("");
                    }
                }
            }
        });

        rdNam.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdNam.setFont(sgUI13b);
                rdNu.setFont(sgUI13);
            }
        });
        rdNu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdNu.setFont(sgUI13b);
                rdNam.setFont(sgUI13);
            }
        });

        // edit thuê phòng
        pnThuePhong.setLayout(new BorderLayout());
        pnThuePhong.add(pnThuePhongContent, BorderLayout.CENTER);
        pnThuePhong.add(pnButton, BorderLayout.SOUTH);
        pnThuePhongContent.setLayout(new GridLayout(2, 1, 10, 10));
        pnThuePhongContent.add(pnThuePhongContentTop);
        pnThuePhongContent.add(pnThuePhongContentDSPT);

        pnThuePhongContentTop.setLayout(new GridLayout(1, 2, 10, 10));
        pnThuePhongContentTop.add(pnThuePhongContentTopCTT);
        pnThuePhongContentTop.add(pnThuePhongContentTopPT);

        pnThuePhongContentTopCTT.setLayout(new BorderLayout());
        pnThuePhongContentTopCTT.add(lbThuePhongContentTopCTT, BorderLayout.NORTH);
        lbThuePhongContentTopCTT.setFont(sgUI15);
        lbThuePhongContentTopCTT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 5, 5, 5)));
        lbThuePhongContentTopCTT.setBackground(Color.decode("#F0FFF0"));
        lbThuePhongContentTopCTT.setOpaque(true);
        pnThuePhongContentTopCTT.add(pnThuePhongContentTopCTTCenter, BorderLayout.CENTER);
        pnThuePhongContentTopCTTCenter.setLayout(new GridLayout(3, 2, 10, 10));
        pnThuePhongContentTopCTTCenter.add(pnMaCTT);
        pnThuePhongContentTopCTTCenter.add(pnTenNV);
        pnThuePhongContentTopCTTCenter.add(pnNgayLapPhieu);
        pnThuePhongContentTopCTTCenter.add(pnTienDatCoc);
        pnThuePhongContentTopCTTCenter.add(pnTinhTrangXuLy);
        pnThuePhongContentTopCTTCenter.add(pnEmpty);
        pnThuePhongContentTopCTTCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnThuePhongContentTopCTTCenter.setBackground(Color.white);

        pnMaCTT.setBackground(Color.white);
        pnMaCTT.setLayout(new GridLayout(2, 1));
        pnMaCTT.add(lbMaCTT);
        pnMaCTT.add(txtMaCTT);
        lbMaCTT.setFont(sgUI13b);
        txtMaCTT.setFont(sgUI13);
        txtMaCTT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtMaCTT.setBackground(Color.decode("#F8f8f8"));
        txtMaCTT.setEditable(false);

        pnTenNV.setBackground(Color.white);
        pnTenNV.setLayout(new GridLayout(2, 1));
        pnTenNV.add(lbTenNV);
        pnTenNV.add(txtTenNV);
        lbTenNV.setFont(sgUI13b);
        txtTenNV.setFont(sgUI13);
        txtTenNV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTenNV.setBackground(Color.decode("#F8f8f8"));
        txtTenNV.setEditable(false);

        pnNgayLapPhieu.setBackground(Color.white);
        pnNgayLapPhieu.setLayout(new GridLayout(2, 1));
        pnNgayLapPhieu.add(lbNgayLapPhieu);
        pnNgayLapPhieu.add(txtNgayLapPhieu);
        lbNgayLapPhieu.setFont(sgUI13b);
        txtNgayLapPhieu.setFont(sgUI13);
        txtNgayLapPhieu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtNgayLapPhieu.setBackground(Color.decode("#F8f8f8"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate now = LocalDate.now();
        String nowString = now.format(dateTimeFormatter);
        txtNgayLapPhieu.setText(nowString);
        txtNgayLapPhieu.setEditable(false);

        pnTienDatCoc.setBackground(Color.white);
        pnTienDatCoc.setLayout(new GridLayout(2, 1));
        pnTienDatCoc.add(lbTienDatCoc);
        pnTienDatCoc.add(txtTienDatCoc);
        lbTienDatCoc.setFont(sgUI13b);
        txtTienDatCoc.setFont(sgUI13);
        txtTienDatCoc.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));

        pnTinhTrangXuLy.setBackground(Color.white);
        pnTinhTrangXuLy.setLayout(new GridLayout(2, 1));
        pnTinhTrangXuLy.add(lbTinhTrangXuLy);
        pnTinhTrangXuLy.add(txtTinhTrangXuLy);
        lbTinhTrangXuLy.setFont(sgUI13b);
        txtTinhTrangXuLy.setFont(sgUI13);
        txtTinhTrangXuLy.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTinhTrangXuLy.setBackground(Color.decode("#F8f8f8"));
        txtTinhTrangXuLy.setEditable(false);

        pnEmpty.setBackground(Color.white);

        pnThuePhongContentDSPT.setLayout(new BorderLayout());
        pnThuePhongContentDSPT.add(scrp, BorderLayout.CENTER);
        pnThuePhongContentDSPT.add(pnThuePhongContentDSPTBottom, BorderLayout.SOUTH);
        scrp.setBackground(Color.white);
        scrp.getViewport().setBackground(Color.white);
        pnThuePhongContentDSPTBottom.setBackground(Color.white);
        pnThuePhongContentDSPTBottom.setLayout(new BorderLayout());
        pnThuePhongContentDSPTBottom.add(pnThuePhongContentDSPTBottomTotal, BorderLayout.EAST);
        pnThuePhongContentDSPTBottomTotal.setLayout(new BorderLayout());
        pnThuePhongContentDSPTBottomTotal.add(lbTotal, BorderLayout.WEST);
        pnThuePhongContentDSPTBottomTotal.add(txtTotal, BorderLayout.CENTER);
        lbTotal.setFont(sgUI15);
        txtTotal.setFont(sgUI15);
        txtTotal.setForeground(Color.decode("#E83535"));
        txtTotal.setText("0 VNĐ");
        txtTotal.setBackground(Color.white);
        txtTotal.setHorizontalAlignment(JLabel.RIGHT);
        txtTotal.setEditable(false);
        txtTotal.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));

        scrp.setViewportView(tbPhongThue);
        scrp.setBorder(BorderFactory.createEmptyBorder());
        scrp.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.white));
        pnThuePhongContentDSPTBottomTotal.setBackground(Color.white);

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

        pnThuePhongContentTopPT.setLayout(new BorderLayout());
        pnThuePhongContentTopPT.add(lbThuePhongContentTopPT, BorderLayout.NORTH);
        pnThuePhongContentTopPT.add(pnThuePhongContentTopPTCenter, BorderLayout.CENTER);
        lbThuePhongContentTopPT.setFont(sgUI15);
        lbThuePhongContentTopPT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(5, 5, 5, 5)));
        lbThuePhongContentTopPT.setBackground(Color.decode("#F0FFF0"));
        lbThuePhongContentTopPT.setOpaque(true);
        pnThuePhongContentTopPTCenter.setLayout(new GridLayout(3, 2, 10, 10));
        pnThuePhongContentTopPTCenter.add(pnLoaiHinhThue);
        pnThuePhongContentTopPTCenter.add(pnEmp);
        pnThuePhongContentTopPTCenter.add(pnNgayThue);
        pnThuePhongContentTopPTCenter.add(pnGioThue);
        pnThuePhongContentTopPTCenter.add(pnNgayTra);
        pnThuePhongContentTopPTCenter.add(pnGioTra);
        pnThuePhongContentTopPTCenter.setBorder(new EmptyBorder(10, 10, 10, 10));

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

        pnEmp.setLayout(new GridLayout(2, 1));
        pnEmp.add(pnPhong);
        pnEmp.add(pnPhongButton);

        pnPhong.setLayout(new BorderLayout(10, 10));
        pnPhongButton.setLayout(new BorderLayout());
        pnPhongButton.setBorder(new EmptyBorder(5, 5, 0, 0));
        pnPhongButton.add(btnAceptRoom, BorderLayout.EAST);
        btnAceptRoom.setFocusPainted(false);
        btnAceptRoom.setBorderPainted(false);
        btnAceptRoom.setFont(sgUI13b);
        btnAceptRoom.setBackground(Color.decode("#99ff99"));
        btnAceptRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAceptRoom.setBackground(Color.decode("#33ff33"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAceptRoom.setBackground(Color.decode("#99ff99"));
            }
        });
        btnAceptRoom.addActionListener(new ActionListener() {
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
                                    ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                                    new SoDoPhongReceptionist(listP, DatPhongNew.this, listPT, 0, dateTimeThue, dateTimeTra);
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
                                        ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                                        new SoDoPhongReceptionist(listP, DatPhongNew.this, listPT, 1, dateTimeThue, dateTimeTra);
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
                            ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, "", false);                            
                            new SoDoPhongReceptionist(listP, DatPhongNew.this, listPT, 2, dateTimeThue, dateTimeThue);
                        } else {
                            new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                        }
                    }
                }
            }
        });

        // edit button
        pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnButton.add(btnAcept);
        btnAcept.setFont(sgUI15);
        btnAcept.setFocusPainted(false);
        btnAcept.setBorderPainted(false);
        btnAcept.setBackground(Color.decode("#99ff99"));
        btnAcept.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAcept.setBackground(Color.decode("#33ff33"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAcept.setBackground(Color.decode("#99ff99"));
            }
        });

        String phoneFormat = "(\\d{10})";
        try {
            MaskFormatter mask = new MaskFormatter(phoneFormat);
            mask.install((JFormattedTextField) txtSDT);
        } catch (Exception e) {
        }

        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCMND.getText().trim().length() == 0) {
                    new ThongBaoDialog("Vui lòng nhập chứng minh nhân dân", 1);
                    txtCMND.setText("");
                    txtCMND.requestFocus();
                } else {
                    if (hasNumberInText(txtCMND).equals("Character")) {
                        new ThongBaoDialog("Chứng minh nhân dân sai", 1);
                        txtCMND.setText("");
                        txtCMND.requestFocus();
                    } else {
                        if (txtTenKH.getText().trim().length() == 0) {
                            new ThongBaoDialog("Vui lòng nhập tên khách hàng", 1);
                            txtTenKH.setText("");
                            txtTenKH.requestFocus();
                        } else {
                            if (noHasNumberInText(txtTenKH).equals("Number")) {
                                new ThongBaoDialog("Tên khách hàng không chứ kí tự số", 1);
                                txtTenKH.setText("");
                                txtTenKH.requestFocus();
                            } else {
                                if (txtSDT.getText().trim().length() == 0) {
                                    new ThongBaoDialog("Vui lòng nhập số điện thoại", 1);
                                    txtSDT.setText("");
                                    txtSDT.requestFocus();
                                } else {
                                    if (hasNumberInText(txtSDT).equals("Character")) {
                                        new ThongBaoDialog("Số điện thoại sai", 1);
                                        txtSDT.setText("");
                                        txtSDT.requestFocus();
                                    } else {
                                        if (dateNgaySinh.getDate() == null) {
                                            new ThongBaoDialog("Vui lòng nhập ngày sinh", 1);
                                        } else {
                                            Calendar cd = Calendar.getInstance();
                                            cd.setTime(dateNgaySinh.getDate());
                                            LocalDate localNgaySinh = LocalDate.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE));
                                            LocalDate localNow = LocalDate.now();
                                            if (localNgaySinh.isBefore(localNow) && (int) ChronoUnit.YEARS.between(localNgaySinh, localNow) >= 18) {
                                                if (txtQueQuan.getText().trim().length() == 0) {
                                                    new ThongBaoDialog("Vui lòng nhập quê quán", 1);
                                                    txtQueQuan.setText("");
                                                    txtQueQuan.requestFocus();
                                                } else {
                                                    if (txtQuocTich.getText().trim().length() == 0) {
                                                        new ThongBaoDialog("Vui lòng nhập quốc tịch", 1);
                                                        txtQuocTich.setText("");
                                                        txtQuocTich.requestFocus();
                                                    } else {
                                                        if (txtTienDatCoc.getText().trim().length() != 0) {
                                                            try {
                                                                int tienDatCoc = Integer.parseInt(txtTienDatCoc.getText().trim().toString());
                                                                if (tienDatCoc >= 0) {
                                                                    if (listPT.size() == 0) {
                                                                        new ThongBaoDialog("Vui lòng đặt phòng muốn thuê", 1);
                                                                    } else {
                                                                        ThuePhong();
                                                                    }
                                                                } else {
                                                                    new ThongBaoDialog("Tiền đặt cọc phải là số nguyên lớn hơn 0", 1);
                                                                    txtTienDatCoc.setText("");
                                                                    txtTienDatCoc.requestFocus();
                                                                }
                                                            } catch (Exception ex) {
                                                                new ThongBaoDialog("Tiền đặt cọc phải là số nguyên lớn hơn 0", 1);
                                                                txtTienDatCoc.setText("");
                                                                txtTienDatCoc.requestFocus();
                                                            }
                                                        } else {
                                                            if (listPT.size() == 0) {
                                                                new ThongBaoDialog("Vui lòng đặt phòng muốn thuê", 1);
                                                            } else {
                                                                ThuePhong();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                new ThongBaoDialog("Ngày sinh khách hàng phải lớn hơn ngày hiện tại \nvà phải hơn 18 tuổi", 1);
                                                editor.setText("");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        // set Color
        setBackground(Color.decode("#FAFAFA"));
        pnTop.setBackground(Color.decode("#FAFAFA"));
        pnKhachHang.setBackground(Color.decode("#FAFAFA"));
        pnKhachHangInput.setBackground(Color.decode("#FFFFFF"));
        pnButton.setBackground(Color.decode("#FFFFFF"));
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

        pnThuePhong.setBackground(Color.decode("#FAFAFA"));
        pnThuePhongContent.setBackground(Color.decode("#FAFAFA"));
        pnButton.setBackground(Color.decode("#FAFAFA"));
        pnThuePhongContentDSPT.setBackground(Color.white);
        pnThuePhongContentTop.setBackground(Color.decode("#FAFAFA"));
        pnThuePhongContentTopCTT.setBackground(Color.white);
        pnThuePhongContentTopPT.setBackground(Color.white);

        tbPhongThue.getTableHeader().setBackground(Color.decode("#F0FFF0"));
        pnEmp.setBackground(Color.white);
        pnThuePhongContentTopPTCenter.setBackground(Color.decode("#FFFFFF"));
        pnPhong.setBackground(Color.white);
        pnPhongButton.setBackground(Color.white);

    }

    public static String hasNumberInText(JTextField textField) {
        String text = textField.getText();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isDigit(c)) {
                return "Character";
            }
        }
        return "Valid";
    }

    public static String noHasNumberInText(JTextField textField) {
        String text = textField.getText();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                return "Number";
            }
        }
        return "Valid";
    }

    public void ThuePhong() {
        int ans = JOptionPane.showConfirmDialog(null, "Vui lòng xác nhận lập phiếu thuê", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            LocalDateTime dateNow = LocalDateTime.now();
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("ddMMyy");
            if (ChiTietThueBUS.countCTT() < 10) {
                txtMaCTT.setText("CTT" + dateTimeFormat.format(dateNow) + "0000" + ChiTietThueBUS.countCTT());
            } else {
                txtMaCTT.setText("CTT" + dateTimeFormat.format(dateNow) + "000" + ChiTietThueBUS.countCTT());
            }
            if (txtTienDatCoc.getText().trim().length() == 0) {
                txtTienDatCoc.setText("0");
            }
            KhachHangDTO khachHang = new KhachHangDTO();

            String str = String.format("%04d", KhachHangBUS.countKH());
            if (txtMaKH.getText().trim().length() == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
                String maKH = "KH";
                if (rdNam.isSelected()) {
                    maKH += "0";
                    khachHang.setGioiTinh(rdNam.getText().toString());
                } else {
                    maKH += "1";
                    khachHang.setGioiTinh(rdNu.getText().toString());
                }
                txtMaKH.setText(maKH + sdf.format(dateNgaySinh.getDate()) + str);
//                if (KhachHangBUS.countKH() < 10) {
//                    txtMaKH.setText(maKH + sdf.format(dateNgaySinh.getDate()) + "000" + KhachHangBUS.countKH());
//                } else {
//                    txtMaKH.setText(maKH + sdf.format(dateNgaySinh.getDate()) + "00" + KhachHangBUS.countKH());
//                }
            }
            khachHang.setMaKH(txtMaKH.getText().trim());
            khachHang.setTenKH(txtTenKH.getText().trim());
            khachHang.setCMND(txtCMND.getText().trim());
            khachHang.setQueQuan(txtQueQuan.getText().trim());
            khachHang.setQuocTich(txtQuocTich.getText().trim());
            khachHang.setXuLy(0);
            khachHang.setSDT(txtSDT.getText().trim());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            khachHang.setNgaySinhString(sdf.format(dateNgaySinh.getDate()));
            String checkKH = KhachHangBUS.insertKH(khachHang);
            if (checkKH.equals("Thêm khách hàng mới không thành công")) {
                new ThongBaoDialog("Thêm khách hàng mới không thành công vui lòng kiểm tra thông tin nhập", 1);
                txtMaKH.setText("");
            } else {
                ChiTietThueDTO ctt = new ChiTietThueDTO();
                ctt.setMaCTT(txtMaCTT.getText().trim());
                ctt.setMaKH(txtMaKH.getText().trim());
                ctt.setMaNV(mainGUI.nv.getMaNV().trim());
                ctt.setTienDatCoc(Integer.parseInt(txtTienDatCoc.getText().trim()));
                ctt.setTinhTrangXuLy(0);
                DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                ctt.setNgayLapPhieu(dateTimeFormatter2.format(localDateTimeNow));
                ctt.setXuLy(0);
                String checkCTT = ChiTietThueBUS.insertCTT(ctt);
                if (checkCTT.equals("Thêm phiếu thuê mới thành công")) {
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
                        ReceptionistGUI.btnDatPhong.doClick();
                    }
                } else {
                    new ThongBaoDialog("Thêm chi tiết thuê mới không thành công vui lòng kiểm tra lại thông tin và bấm xác nhận lại", 1);
                    txtMaCTT.setText("");
                }
            }
        }
    }
}
