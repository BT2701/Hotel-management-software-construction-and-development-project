package GUI.GUI_PHONG;

import BUS.ChiTietThueBUS;
import BUS.ChiTietThuePhongBUS;
import BUS.ChiTietTienIchBUS;
import BUS.KhachHangBUS;
import BUS.PhongBUS;
import BUS.TienIchBUS;
import DTO.ChiTietThuePhongDTO;
import DTO.ChiTietTienIchDTO;
import DTO.PhongDTO;
import DTO.TienIchDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import GUI.GUI_DICHVU.ButtonEditorDV;
import GUI.GUI_DICHVU.ButtonRenderer;
import GUI.GUI_FUNCTION_ACCOUNT.FormLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class FormChiTietPhong extends JDialog {

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    LineBorder lineCB = new LineBorder(Color.white);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JPanel pnTop = new JPanel();
    JPanel pnContainer = new JPanel();
    JLabel lbTop = new JLabel("Thông tin phòng");
    JLabel lbTopDetail = new JLabel("Vui lòng nhập thông tin phòng");
    JPanel pnCenter = new JPanel();
    JPanel pnCenterContent = new JPanel();
    JPanel pnCenterBottom = new JPanel();
//    JButton btnAcept = new JButton("Thêm phòng");
    JPanel pnBTN;
    JButton btnDel, btnEdit;
    JPanel pnCenterInformation = new JPanel();
    JPanel pnCenterContentRoom = new JPanel();
    JLabel lbCenter = new JLabel("Phòng");
    JPanel pnInput = new JPanel();
    JPanel pnMaP = new JPanel();
    JLabel lbMaP = new JLabel("Mã phòng");
    JTextField txtMaP = new JTextField();
    JPanel pnTenP = new JPanel();
    JLabel lbTenP = new JLabel("Tên phòng");
    JTextField txtTenP = new JTextField();
    JPanel pnLoaiP = new JPanel();
    JLabel lbLoaiP = new JLabel("Loại phòng");
    JPanel pnRadioButton = new JPanel();
    ButtonGroup btnGrpLoaiP = new ButtonGroup();
    JRadioButton rdVip = new JRadioButton("VIP");
    JRadioButton rdThuong = new JRadioButton("Thường");
    JPanel pnGiaP = new JPanel();
    JLabel lbGiaP = new JLabel("Giá phòng");
    JTextField txtGiaP = new JTextField();
    JPanel pnChiTietLoaiP = new JPanel();
    JLabel lbChiTietLoaiP = new JLabel("Chi tiết phòng");
    JPanel pnRadioButtonCT = new JPanel();
    JRadioButton rdDon = new JRadioButton("Phòng đơn");
    JRadioButton rdDoi = new JRadioButton("Phòng đôi");
    JRadioButton rdGD = new JRadioButton("Phòng gia đình");
    ButtonGroup btnGrpCT = new ButtonGroup();
    JPanel pnTinhTrang = new JPanel();
    JLabel lbTinhTrang = new JLabel("Tình trạng phòng");
    JTextField txtTT = new JTextField();
    JPanel pnHienTrang = new JPanel();
    JLabel lbHienTrang = new JLabel("Hiện trạng phòng");
//    JTextField txtHT = new JTextField();
    JComboBox<String> cbbHienTrang;
    JPanel pnContentRoomTop = new JPanel();
//    JPanel pnContentRoomButton = new JPanel();
//    JButton btnTienIch = new JButton("Tiện ích phòng");
//    JButton btnDichVu = new JButton("Dịch vụ phòng");
    TienIch tienIch;

    JLabel lbTitleThongTinThue, lbTenKH, lbLoaiHinhThue, lbNgayThue, lbNgayTra, lbGiaThue;
    JTextField tfTenKH, tfLoaiHinhThue, tfNgayThue, tfNgayTra, tfGiaThue;
    JPanel pnTinhTrangThue = new JPanel();
    JPanel pnSubTTTop, pnSubTTCenter, temp;
    JPanel pnTinhTrangThueReal = new JPanel();
    DisplayRoom dpr;

    public FormChiTietPhong(int options, String maP, DisplayRoom a) {
        dpr = a;
        tienIch = new TienIch(maP);
        // options = 1 thì cho phép chỉnh sửa, =0 thì chỉ được xem
        tienIch.eventSpinner(maP);
        initComponents(options, maP);

    }

    public FormChiTietPhong(int options, String maP) {
        tienIch = new TienIch(maP);
        // options = 1 thì cho phép chỉnh sửa, =0 thì chỉ được xem
        tienIch.eventSpinner(maP);
        initComponents(options, maP);
//        quyen(options);
//		eventDel(maP);
//		eventEdit(maP);

    }

    public void initComponents(int options, String maP) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Thông tin phòng");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setSize(new Dimension(1300, 750));
        setLocationRelativeTo(null);
        setBackground(Color.decode("#FBFBFB"));
        setModal(true);
        setResizable(false);

        PhongDTO phong = PhongBUS.getP(maP);

        cbbHienTrang = new JComboBox<>();
        cbbHienTrang.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbHienTrang.setBorder(matteBorderCB);
        hienTrang();

        setLayout(new BorderLayout());
        add(pnContainer, BorderLayout.CENTER);

        pnContainer.setLayout(new BorderLayout(5, 5));
        pnContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        pnContainer.add(pnTop, BorderLayout.NORTH);
        pnContainer.add(pnCenter, BorderLayout.CENTER);
        pnTop.setLayout(new GridLayout(2, 1));
        pnTop.add(lbTop);
        pnTop.add(lbTopDetail);
        pnTop.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbTop.setFont(sgUI18b);
        lbTopDetail.setFont(tNR13);

        btnEdit = new JButton("Sửa");
        btnEdit.setFocusPainted(false);
        btnEdit.setBorderPainted(false);
        btnEdit.setFont(sgUI13b);
        eventEdit(maP);

        btnDel = new JButton("Xóa");
        btnDel.setFocusPainted(false);
        btnDel.setBorderPainted(false);
        btnDel.setFont(sgUI13b);
//		btnDel.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("nhận sự kiện");
//			}
//		});
        eventDel(maP);

        pnBTN = new JPanel();
        pnBTN.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pnBTN.add(btnDel);
        pnBTN.add(btnEdit);

        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnCenterContent, BorderLayout.CENTER);
        pnCenter.add(pnCenterBottom, BorderLayout.SOUTH);
        pnCenterBottom.setLayout(new BorderLayout());
        pnCenterBottom.add(pnBTN, BorderLayout.EAST);

        pnCenterContent.setLayout(new BorderLayout(5, 5));
        pnCenterContent.add(pnCenterInformation, BorderLayout.WEST);
        pnCenterContent.add(pnCenterContentRoom, BorderLayout.CENTER);

        pnCenterInformation.setLayout(new BorderLayout());
        pnCenterInformation.add(lbCenter, BorderLayout.NORTH);
        pnCenterInformation.add(pnInput, BorderLayout.CENTER);

        pnInput.setLayout(new GridLayout(7, 1));
        pnInput.add(pnMaP);
        pnInput.add(pnTenP);
        pnInput.add(pnGiaP);
        pnInput.add(pnLoaiP);
        pnInput.add(pnChiTietLoaiP);
        pnInput.add(pnTinhTrang);
        pnInput.add(pnHienTrang);

        pnMaP.setLayout(new GridLayout(2, 1));
        pnMaP.add(lbMaP);
        pnMaP.add(txtMaP);

        pnTenP.setLayout(new GridLayout(2, 1));
        pnTenP.add(lbTenP);
        pnTenP.add(txtTenP);

        pnGiaP.setLayout(new GridLayout(2, 1));
        pnGiaP.add(lbGiaP);
        pnGiaP.add(txtGiaP);

        pnLoaiP.setLayout(new GridLayout(2, 1));
        pnLoaiP.add(lbLoaiP);
        pnLoaiP.add(pnRadioButton);
        pnRadioButton.setLayout(new GridLayout(1, 2));
        pnRadioButton.add(rdVip);
        pnRadioButton.add(rdThuong);
        btnGrpLoaiP.add(rdVip);
        btnGrpLoaiP.add(rdThuong);
//        rdVip.setSelected(true);

        pnChiTietLoaiP.setLayout(new GridLayout(2, 1));
        pnChiTietLoaiP.add(lbChiTietLoaiP);
        pnChiTietLoaiP.add(pnRadioButtonCT);
        pnRadioButtonCT.setLayout(new GridLayout(1, 2));
        pnRadioButtonCT.add(rdDon);
        pnRadioButtonCT.add(rdDoi);
        pnRadioButtonCT.add(rdGD);
        btnGrpCT.add(rdDon);
        btnGrpCT.add(rdDoi);
        btnGrpCT.add(rdGD);
//        rdDon.setSelected(true);

        pnTinhTrang.setLayout(new GridLayout(2, 1));
        pnTinhTrang.add(lbTinhTrang);
        pnTinhTrang.add(txtTT);

        pnHienTrang.setLayout(new GridLayout(2, 1));
        pnHienTrang.add(lbHienTrang);
        pnHienTrang.add(cbbHienTrang);

        lbMaP.setFont(sgUI13b);
        lbTenP.setFont(sgUI13b);
        lbHienTrang.setFont(sgUI13b);
        lbTinhTrang.setFont(sgUI13b);
        lbLoaiP.setFont(sgUI13b);
        lbGiaP.setFont(sgUI13b);
        lbChiTietLoaiP.setFont(sgUI13b);

        txtMaP.setFont(sgUI13);
        txtMaP.setText(maP);
        txtTenP.setFont(sgUI13);
        txtTenP.setText(phong.getTenP());
        cbbHienTrang.setFont(sgUI13);
        txtTT.setFont(sgUI13);
        if (phong.getTinhTrang() == 0) {
            txtTT.setText("Phòng trống");
            txtTT.setForeground(Color.green);
        } else if (phong.getTinhTrang() == 1) {
            txtTT.setText("Đang được thuê");
            txtTT.setForeground(Color.red);
        } else {
            txtTT.setText("Phòng chưa dọn");
            txtTT.setForeground(Color.yellow);
        }

        txtGiaP.setFont(sgUI13);
        txtGiaP.setForeground(Color.orange);
        txtGiaP.setText(phong.getGiaP() + "");
        ((AbstractDocument) txtGiaP.getDocument()).setDocumentFilter(new DocumentFilter() {
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

        if (phong.getLoaiP().equalsIgnoreCase("vip")) {
            rdVip.setSelected(true);
            rdThuong.setSelected(false);
        } else {
            rdVip.setSelected(false);
            rdThuong.setSelected(true);
        }

        if (phong.getChiTietLoaiP().equalsIgnoreCase("phòng đơn")) {
            rdDon.setSelected(true);
            rdDoi.setSelected(false);
            rdGD.setSelected(false);
        } else if (phong.getChiTietLoaiP().equalsIgnoreCase("phòng đôi")) {
            rdDon.setSelected(false);
            rdDoi.setSelected(true);
            rdGD.setSelected(false);
        } else {
            rdDon.setSelected(false);
            rdDoi.setSelected(false);
            rdGD.setSelected(true);
        }

        if (phong.getHienTrang() == 0) {
            cbbHienTrang.setSelectedItem("Mới");
        } else {
            cbbHienTrang.setSelectedItem("Cũ");
        }

        rdDoi.setFont(sgUI13);
        rdDon.setFont(sgUI13b);
        rdGD.setFont(sgUI13);
        rdThuong.setFont(sgUI13);
        rdVip.setFont(sgUI13b);

        txtMaP.setEditable(false);
//        txtHT.setEditable(false);
        txtTT.setEditable(false);

        rdDoi.setFocusPainted(false);
        rdDoi.setBorderPainted(false);
        rdDon.setFocusPainted(false);
        rdDon.setBorderPainted(false);
        rdGD.setFocusPainted(false);
        rdGD.setBorderPainted(false);
        rdVip.setFocusPainted(false);
        rdVip.setBorderPainted(false);
        rdThuong.setFocusPainted(false);
        rdThuong.setBorderPainted(false);

//        txtMaP.setText("abc");
        if (options == 0) {
            tienIch.getEditor().getButton().setEnabled(false);
        } else {
            tienIch.getEditor().getButton().setEnabled(true);
        }
        pnCenterContentRoom.setLayout(new BorderLayout());
        pnCenterContentRoom.add(pnContentRoomTop, BorderLayout.NORTH);
        pnCenterContentRoom.add(tienIch, BorderLayout.CENTER);

        pnContentRoomTop.setLayout(new BorderLayout());
//        pnContentRoomTop.add(pnContentRoomButton, BorderLayout.WEST);
//        pnContentRoomButton.setLayout(new GridLayout(1, 2));
//        pnContentRoomButton.add(btnTienIch);
//        pnContentRoomButton.add(btnDichVu);

//        btnDichVu.setFocusPainted(false);
//        btnTienIch.setFocusPainted(false);
//        btnTienIch.setFont(sgUI13b);
//        btnDichVu.setFont(sgUI13);
//        btnTienIch.setBackground(Color.decode("#ebf2fc"));
//        btnDichVu.setBorder(null);
//        btnTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#dee9fc")), new EmptyBorder(5, 10, 5, 10)));
        pnCenterInformation.setBorder(new EmptyBorder(0, 5, 0, 5));
        lbCenter.setFont(sgUI13b);
        lbCenter.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#eeeeee")),
                new EmptyBorder(5, 0, 5, 5)));

        txtMaP.setBackground(Color.decode("#F8f8f8"));
        cbbHienTrang.setBackground(Color.WHITE);
        txtTT.setBackground(Color.decode("#F8f8f8"));
        pnCenterContentRoom.setBackground(Color.decode("#FBFBFB"));
        pnContentRoomTop.setBackground(Color.decode("#FBFBFB"));
//        pnContentRoomButton.setBackground(Color.decode("#FBFBFB"));
//        btnDichVu.setBackground(Color.decode("#FBFBFB"));
        txtMaP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                new EmptyBorder(0, 7, 0, 7)));
        txtTenP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                new EmptyBorder(0, 7, 0, 7)));
        txtGiaP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                new EmptyBorder(0, 7, 0, 7)));
//        cbbHienTrang.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                new EmptyBorder(0, 7, 0, 7)));
        pnCenterInformation.setBackground(Color.decode("#FDFDFD"));
        pnMaP.setBackground(Color.decode("#FDFDFD"));
        pnTenP.setBackground(Color.decode("#FDFDFD"));
        pnGiaP.setBackground(Color.decode("#FDFDFD"));
        pnLoaiP.setBackground(Color.decode("#FDFDFD"));
        pnChiTietLoaiP.setBackground(Color.decode("#FDFDFD"));
        pnHienTrang.setBackground(Color.decode("#FDFDFD"));
        pnTinhTrang.setBackground(Color.decode("#FDFDFD"));
        pnInput.setBackground(Color.decode("#FDFDFD"));
        pnRadioButton.setBackground(Color.decode("#FDFDFD"));
        pnRadioButtonCT.setBackground(Color.decode("#FDFDFD"));
        rdDoi.setBackground(Color.decode("#FDFDFD"));
        rdDon.setBackground(Color.decode("#FDFDFD"));
        rdGD.setBackground(Color.decode("#FDFDFD"));
        rdThuong.setBackground(Color.decode("#FDFDFD"));
        rdVip.setBackground(Color.decode("#FDFDFD"));
        pnTop.setBackground(Color.decode("#ebf2fc"));
        pnContainer.setBackground(Color.decode("#FBFBFB"));
        pnCenterContent.setBackground(Color.decode("#F8F8F8"));
        pnCenterBottom.setBackground(Color.decode("#FDFDFD"));
        pnCenter.setBackground(Color.decode("#FDFDFD"));
        pnBTN.setBackground(Color.white);
        btnDel.setBackground(Color.decode("#e74c3c"));
        btnEdit.setBackground(Color.decode("#f1c40f"));
        btnDel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDel.setBackground(Color.decode("#d35400"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDel.setBackground(Color.decode("#e74c3c"));
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEdit.setBackground(Color.decode("#f39c12"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEdit.setBackground(Color.decode("#f1c40f"));
            }
        });

//        btnTienIch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                btnTienIch.setFont(sgUI13b);
//                btnDichVu.setFont(sgUI13);
//                btnTienIch.setBackground(Color.decode("#ebf2fc"));
//                btnDichVu.setBorder(null);
//                btnDichVu.setBackground(Color.decode("#FBFBFB"));
//                btnTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#dee9fc")), new EmptyBorder(5, 10, 5, 10)));
//            }
//        });
//
//        btnDichVu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                btnDichVu.setFont(sgUI13b);
//                btnTienIch.setFont(sgUI13);
//                btnDichVu.setBackground(Color.decode("#ebf2fc"));
//                btnTienIch.setBorder(null);
//                btnTienIch.setBackground(Color.decode("#FBFBFB"));
//                btnDichVu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#dee9fc")), new EmptyBorder(5, 10, 5, 10)));
//            }
//        });
        pnTinhTrangThueReal.setBackground(Color.white);
        tienIch.add(pnTinhTrangThueReal, BorderLayout.SOUTH);
        duLieuTinhTrang(maP);
        quyen(options);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Thông báo",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
//                    new FormLogin();
                    try {
                        dpr.tbP.renderTB();
                    } catch (Exception e2) {
                    }
                    dispose();
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
        eventRadioBTN();
        if (rdVip.isSelected()) {
            rdVip.setFont(sgUI13b);
            rdThuong.setFont(sgUI13);
        } else {
//			loaiPhong = "Thường";
            rdVip.setFont(sgUI13);
            rdThuong.setFont(sgUI13b);
        }
//		String chiTietLoaiPhong = "";
        if (rdGD.isSelected()) {
//			chiTietLoaiPhong = "Phòng gia đình";
            rdGD.setFont(sgUI13b);
            rdDon.setFont(sgUI13);
            rdDoi.setFont(sgUI13);
        }
        if (rdDoi.isSelected()) {
//			chiTietLoaiPhong = "Phòng đôi";
            rdGD.setFont(sgUI13);
            rdDon.setFont(sgUI13);
            rdDoi.setFont(sgUI13b);
        }
        if (rdDon.isSelected()) {
//			chiTietLoaiPhong = "Phòng đơn";
            rdGD.setFont(sgUI13);
            rdDon.setFont(sgUI13b);
            rdDoi.setFont(sgUI13);
        }
        setVisible(true);
    }

    public void duLieuTinhTrang(String maP) {
        if (txtTT.getText().toString().equalsIgnoreCase("đang được thuê")) {
//    		JLabel lbTitleThongTinThue,lbTenKH,lbLoaiHinhThue,lbNgayThue,lbNgayTra,lbGiaThue;
//    	    JTextField tfTenKH,tfLoaiHinhThue,tfNgayThue,tfNgayTra,tfGiaThue;
//    	    JPanel pnTinhTrangThue=new JPanel();
            ChiTietThuePhongDTO cttphong = ChiTietThuePhongBUS.getInstance().selectByMaPhong(maP);
            String tenKH = KhachHangBUS.getIntance()
                    .layTenBangMa(ChiTietThueBUS.getInstance().selectById(cttphong.getMaCTT()).getMaKH());
            lbTitleThongTinThue = new JLabel("Thông tin thuê", JLabel.LEFT);
            lbTitleThongTinThue.setFont(sgUI15b);
            lbTitleThongTinThue.setForeground(Color.decode("#33419C"));

            lbTenKH = new JLabel("Tên khách hàng", JLabel.LEFT);
            lbTenKH.setFont(sgUI13b);

            lbLoaiHinhThue = new JLabel("Loại hình thuê", JLabel.LEFT);
            lbLoaiHinhThue.setFont(sgUI13b);

            lbNgayThue = new JLabel("Ngày thuê", JLabel.LEFT);
            lbNgayThue.setFont(sgUI13b);

            lbNgayTra = new JLabel("Ngày trả", JLabel.LEFT);
            lbNgayTra.setFont(sgUI13b);

            lbGiaThue = new JLabel("Giá thuê", JLabel.LEFT);
            lbGiaThue.setFont(sgUI13b);

            tfTenKH = new JTextField();
            tfTenKH.setFont(sgUI13);
            tfTenKH.setBackground(Color.white);
            tfTenKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                    new EmptyBorder(0, 7, 0, 7)));
            tfTenKH.setText(tenKH);

            tfLoaiHinhThue = new JTextField();
            tfLoaiHinhThue.setFont(sgUI13);
            tfLoaiHinhThue.setBackground(Color.white);
            tfLoaiHinhThue.setBorder(BorderFactory.createCompoundBorder(
                    new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
            if (cttphong.getLoaiHinhThue() == 0) {
                tfLoaiHinhThue.setText("Theo giờ");
            } else {
                tfLoaiHinhThue.setText("Theo ngày");
            }

            tfNgayThue = new JTextField();
            tfNgayThue.setFont(sgUI13);
            tfNgayThue.setBackground(Color.white);
            tfNgayThue.setBorder(BorderFactory.createCompoundBorder(
                    new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
            tfNgayThue.setForeground(Color.green);
            tfNgayThue.setText(sdf.format(cttphong.getDateThue()));

            tfNgayTra = new JTextField();
            tfNgayTra.setFont(sgUI13);
            tfNgayTra.setBackground(Color.white);
            tfNgayTra.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                    new EmptyBorder(0, 7, 0, 7)));
            tfNgayTra.setForeground(Color.yellow);
            if(cttphong.getDateTra()!=null) {
            	tfNgayTra.setText(sdf.format(cttphong.getDateTra()));	
            }
            else {
            	tfNgayTra.setText("");
            }
            

            tfGiaThue = new JTextField();
            tfGiaThue.setFont(sgUI13);
            tfGiaThue.setBackground(Color.white);
            tfGiaThue.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")),
                    new EmptyBorder(0, 7, 0, 7)));
            tfGiaThue.setForeground(Color.red);
            tfGiaThue.setText(dcf.format(cttphong.getGiaThue()) + "VND");

            pnSubTTTop = new JPanel();
            pnSubTTTop.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            pnSubTTTop.add(lbTitleThongTinThue);
            pnSubTTTop.setBackground(Color.decode("#ebf2fc"));
            pnSubTTTop.setBorder(new EmptyBorder(5, 5, 5, 5));

//    		JPanel []tam=new JPanel[5];
//    		for (int i=0;i<tam.length;i++) {
//				tam[i]=new JPanel();
//				tam[i].setBackground(Color.white);
//			}
            pnSubTTCenter = new JPanel();
            pnSubTTCenter.setLayout(new GridLayout(5, 3, 5, 5));
            pnSubTTCenter.add(lbTenKH);
            pnSubTTCenter.add(tfTenKH);
//    		pnSubTTCenter.add(tam[0]);
            pnSubTTCenter.add(lbLoaiHinhThue);
            pnSubTTCenter.add(tfLoaiHinhThue);
//    		pnSubTTCenter.add(tam[1]);
            pnSubTTCenter.add(lbNgayThue);
            pnSubTTCenter.add(tfNgayThue);
//    		pnSubTTCenter.add(tam[2]);
            pnSubTTCenter.add(lbNgayTra);
            pnSubTTCenter.add(tfNgayTra);
//    		pnSubTTCenter.add(tam[3]);
            pnSubTTCenter.add(lbGiaThue);
            pnSubTTCenter.add(tfGiaThue);
//    		pnSubTTCenter.add(tam[4]);
            pnSubTTCenter.setBackground(Color.white);

            pnTinhTrangThue.setLayout(new BorderLayout());
            pnTinhTrangThue.add(pnSubTTTop, BorderLayout.NORTH);
            pnTinhTrangThue.add(pnSubTTCenter, BorderLayout.CENTER);
            pnTinhTrangThue.setBackground(Color.white);

            temp = new JPanel();
            temp.setBackground(Color.white);
            temp.setPreferredSize(new Dimension(320, 1));
            pnTinhTrangThueReal.setLayout(new BorderLayout());
            pnTinhTrangThueReal.add(pnTinhTrangThue, BorderLayout.CENTER);
            pnTinhTrangThueReal.add(temp, BorderLayout.EAST);
//            pnTinhTrangThueReal.setBackground(Color.white);

        } else {
            return;
        }
    }

    public void hienTrang() {
        Vector<String> hienTrangP = new Vector<>();
        hienTrangP.add("Mới");
        hienTrangP.add("Cũ");
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(hienTrangP);
        cbbHienTrang.setModel(cbmodel);
    }

    public void quyen(int options) {
        if (options == 0) {
            txtTenP.setEditable(false);
            txtGiaP.setEditable(false);
            txtTT.setEditable(false);
            cbbHienTrang.setEditable(false);
            cbbHienTrang.setEnabled(false);
            lbTopDetail.setVisible(false);
            btnDel.setVisible(false);
            btnEdit.setVisible(false);
        } else {
            txtTenP.setEditable(true);
            txtGiaP.setEditable(true);
            txtTT.setEditable(true);
            cbbHienTrang.setEditable(true);
            lbTopDetail.setVisible(true);
            btnDel.setVisible(true);
            btnEdit.setVisible(true);
        }
    }

    public void eventDel(String maP) {
        btnDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
//				System.out.println("nhận sự kiện");
                new ThongBaoDialog("Bạn chắc chắn muốn xóa phòng này?", ThongBaoDialog.WARNING_DIALOG);
                PhongDTO p = PhongBUS.getP(maP);
                if (p.getTinhTrang() == 1) {
                    new ThongBaoDialog("Phòng này đang được thuê không được xóa!", ThongBaoDialog.ERROR_DIALOG);
                    return;
                }
                PhongBUS.delete(maP, 1);
                try {
                    dpr.tbP.renderTB();
                } catch (Exception e2) {
                }
                new ThongBaoDialog("Xóa thành công!", ThongBaoDialog.SUCCESS_DIALOG);
//                tienIch.renderTB();
                dispose();
            }
        });
    }

    public void eventEdit(String maP) {
        // hoàn thành event ở form thông tin phòng
        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ThongBaoDialog("Bạn chắc chắn muốn sửa thông tin phòng này", ThongBaoDialog.WARNING_DIALOG);
                // khu vực cập nhật thông tin phòng
                String maPhong = txtMaP.getText().toString();
                String tenPhong = txtTenP.getText().toString();
                String giaPhong = txtGiaP.getText().toString();
                String loaiPhong = "";
                PhongDTO p = PhongBUS.getP(maP);
                if (p.getTinhTrang() == 1) {
                    new ThongBaoDialog("Phòng này đang được thuê không được sửa!", ThongBaoDialog.ERROR_DIALOG);
                    return;
                }
                if (rdVip.isSelected()) {
                    loaiPhong = "VIP";
                    rdVip.setFont(sgUI13b);
                    rdThuong.setFont(sgUI13);
                } else {
                    loaiPhong = "Thường";
                    rdVip.setFont(sgUI13);
                    rdThuong.setFont(sgUI13b);
                }
                String chiTietLoaiPhong = "";
                if (rdGD.isSelected()) {
                    chiTietLoaiPhong = "Phòng gia đình";
                    rdGD.setFont(sgUI13b);
                    rdDon.setFont(sgUI13);
                    rdDoi.setFont(sgUI13);
                }
                if (rdDoi.isSelected()) {
                    chiTietLoaiPhong = "Phòng đôi";
                    rdGD.setFont(sgUI13);
                    rdDon.setFont(sgUI13);
                    rdDoi.setFont(sgUI13b);
                }
                if (rdDon.isSelected()) {
                    chiTietLoaiPhong = "Phòng đơn";
                    rdGD.setFont(sgUI13);
                    rdDon.setFont(sgUI13b);
                    rdDoi.setFont(sgUI13);
                }
                int hienTrang = 0;
                if (cbbHienTrang.getSelectedItem().toString().equalsIgnoreCase("Mới")) {
                    hienTrang = 0;
                } else {
                    hienTrang = 1;
                }
                PhongDTO phong = new PhongDTO();
                phong.setMaP(maPhong);
                phong.setTenP(tenPhong);
                phong.setChiTietLoaiP(chiTietLoaiPhong);
                phong.setLoaiP(loaiPhong);
                phong.setGiaP(Integer.parseInt(giaPhong));
                phong.setHienTrang(hienTrang);
                PhongBUS.getInstance().capNhap(phong);
                // kết thúc khu vực cập nhật thông tin phòng

                // khu vực cập nhật tiện ích
                for (int i = 0; i < tienIch.tb.getRowCount(); i++) {
                    String maTI = tienIch.tb.getValueAt(i, 1).toString();
                    int soLuongCapNhat = Integer.parseInt(tienIch.tb.getValueAt(i, 3).toString());
                    ;
//                    for (ItemTienIch ti : tienIch.listItem) {
//                    	if(maTI.equalsIgnoreCase(ti.getMaTI())) {
//                    		int soLuongTienIchtable = Integer.parseInt(tienIch.tb.getValueAt(i, 3).toString());
//                            int soLuongDatabase=ChiTietTienIchBUS.laySoLuongTienIchHienTai(maP, maTI);
//                            int soLuongSpiner=ti.getSoLuong();
//                            soLuongCapNhat=soLuongTienIchtable-(soLuongSpiner-soLuongDatabase);
////                            tienIch.tb.setValueAt(soLuongCapNhat, i, 3);
//                    	}
//					}
                    TienIchBUS.capNhatSL(maTI, soLuongCapNhat);
                }
                tienIch.renderTB();

                // kết thúc khu vực cập nhật tiện ích
                // khu vực cập nhật chi tiết tiện ichs
                ArrayList<String> listti1 = new ArrayList<>();
                ArrayList<String> listti2 = new ArrayList<>();
                for (ChiTietTienIchDTO ti : ChiTietTienIchBUS.getInstance().selectAll()) {
                    if (ti.getMaP().equalsIgnoreCase(maP)) {
                        listti1.add(ti.getMaTI());
                        for (ItemTienIch it : tienIch.listItem) {
                            listti2.add(it.getMaTI());
                            if (ti.getMaTI().equalsIgnoreCase(it.getMaTI())) {
                                ChiTietTienIchBUS.capNhatSL(maP, it.getMaTI(), it.getSoLuong());
                            }
                        }
                    }
                }
                listti2.removeAll(listti1);
                try {
                    for (String maTI : listti2) {
                        for (ItemTienIch tienIchIT : tienIch.listItem) {
                            if (tienIchIT.getMaTI().equalsIgnoreCase(maTI)) {
                                ChiTietTienIchDTO ctti = new ChiTietTienIchDTO(maPhong, tienIchIT.getMaTI(),
                                        tienIchIT.getSoLuong());
                                ChiTietTienIchBUS.insertCTTI(ctti);
                            }
                        }
                    }
                } catch (Exception e2) {
                    // TODO: handle exception
                }
                // kết thúc khu vực cập nhật chi tiết tiện ích
                try {
                    dpr.tbP.renderTB();
                } catch (Exception e2) {
                }
                new ThongBaoDialog("Sửa thông tin thành công", ThongBaoDialog.SUCCESS_DIALOG);
                dispose();
            }
        });
    }

    public void eventRadioBTN() {
        rdVip.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                rdVip.setFont(sgUI15);
                rdThuong.setFont(sgUI15p);

            }
        });
        rdThuong.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                rdVip.setFont(sgUI15p);
                rdThuong.setFont(sgUI15);

            }
        });
        rdDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdGD.setFont(sgUI13);
                rdDon.setFont(sgUI13b);
                rdDoi.setFont(sgUI13);
            }
        });
        rdDoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdGD.setFont(sgUI13);
                rdDon.setFont(sgUI13);
                rdDoi.setFont(sgUI13b);
            }
        });
        rdGD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdGD.setFont(sgUI13b);
                rdDon.setFont(sgUI13);
                rdDoi.setFont(sgUI13);
            }
        });
    }

//	public void eventSpinner(String maP) {
//		for (ItemTienIch it : tienIch.listItem) {
//			int soLuongDatabase = ChiTietTienIchBUS.laySoLuongTienIchHienTai(maP, it.getMaTI());
//			
//			it.spinerSoLuong.addChangeListener(new ChangeListener() {
//
//				@Override
//				public void stateChanged(ChangeEvent e) {
//					int soLuongSpiner = it.getSoLuong();
//					// TODO Auto-generated method stub
//					int soLuongTienIchtable = 0;
//					int soLuongCapNhat = 0;
//					for (int i = 0; i < tienIch.tb.getRowCount(); i++) {
//						if (tienIch.tb.getValueAt(i, 1).toString().equalsIgnoreCase(it.getMaTI())) {
////							System.out.println("nhận event");
//							soLuongTienIchtable = TienIchBUS.getSL(it.getMaTI());
//							soLuongCapNhat = soLuongTienIchtable - (soLuongSpiner - soLuongDatabase);
//							System.out.println("Số lượng data chi tiết tiện ích "+soLuongDatabase);
//							System.out.println("Số lượng spinner "+soLuongSpiner);
//							System.out.println("Số lượng table "+soLuongTienIchtable);
//							System.out.println("Số lượng cập nhât "+soLuongCapNhat);
//							tienIch.tb.setValueAt(soLuongCapNhat, i, 3);
//						}
//					}
//
//				}
//			});
//		}
//	}
    class TienIch extends JPanel {

        ArrayList<ItemTienIch> listItem = new ArrayList<>();
        JPanel pnTienIchTable = new JPanel();
        JPanel pnTienIchItem = new JPanel();
        JPanel pnTienIchItemContent = new JPanel();
        JLabel lbTienIchTable = new JLabel("Danh sách tiện ích");
        JLabel lbTienIchItem = new JLabel("Danh sách tiện ích của phòng                         ");
        JPanel pnTienIchTableTop = new JPanel();
        JPanel pnTienIchTableSearch = new JPanel();
        JLabel lbImgSearch = new JLabel();
        JTextField txtSearch = new JTextField();
        JScrollPane scp = new JScrollPane();
        JScrollPane scpItem = new JScrollPane();
        ScrollBar scbarItem = new ScrollBar(Color.decode("#FFFFFF"), Color.white, 0);
        JTable tb = new JTable() {
            @Override
            public boolean isCellEditable(int row, int col) {
                if (col == 4) {
                    return true;
                }
                return false;
            }
        };

        ButtonEditorDV editor = new ButtonEditorDV(new JCheckBox());

        public ButtonEditorDV getEditor() {
            return editor;
        }

        public TienIch(String maP) {
            txtSearch.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    txtSearch.setText("");
                    renderTB();
                }
            });
            txtSearch.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (txtSearch.getText().length() == 0) {
                        renderTB();
                    } else {
                        ArrayList<TienIchDTO> listTI = new ArrayList<>();
                        for (TienIchDTO x : TienIchBUS.getListTI()) {
                            if (x.getTenTI().toUpperCase().contains(txtSearch.getText().trim().toUpperCase())) {
                                listTI.add(x);
                            }
                        }
                        renderTB(listTI);
                    }
                }
            });
//        	pnTinhTrangThue=new JPanel();
            setLayout(new BorderLayout(5, 5));
            add(pnTienIchTable, BorderLayout.CENTER);
            add(pnTienIchItem, BorderLayout.EAST);
//            add(pnTinhTrangThue,BorderLayout.SOUTH);
            setBackground(Color.decode("#FAFAFA"));
            pnTienIchTable.setBackground(Color.decode("#FAFAFA"));
            pnTienIchItem.setBackground(Color.decode("#FAFAFA"));
            pnTienIchTable.setLayout(new BorderLayout());
            pnTienIchTable.add(pnTienIchTableTop, BorderLayout.NORTH);
            pnTienIchTable.add(scp, BorderLayout.CENTER);
            pnTienIchTableTop.setLayout(new GridLayout(1, 2));
            pnTienIchTableTop.add(lbTienIchTable);
            pnTienIchTableTop.add(pnTienIchTableSearch);
            pnTienIchTableSearch.setLayout(new BorderLayout());
            pnTienIchTableSearch.add(lbImgSearch, BorderLayout.WEST);
            pnTienIchTableSearch.add(txtSearch, BorderLayout.CENTER);
            txtSearch.setFont(sgUI13);
            ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/IconFind.png"))
                    .getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            lbImgSearch.setIcon(iconSearch);
            lbTienIchTable.setFont(sgUI15b);
            lbImgSearch.setOpaque(true);
            lbImgSearch.setBackground(Color.white);
            lbImgSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnTienIchItem.setLayout(new BorderLayout());
            pnTienIchItem.add(lbTienIchItem, BorderLayout.NORTH);
            pnTienIchItem.add(scpItem, BorderLayout.CENTER);
            scpItem.setViewportView(pnTienIchItemContent);

            pnTienIchItemContent.setLayout(new BoxLayout(pnTienIchItemContent, BoxLayout.Y_AXIS));
            lbTienIchItem.setFont(sgUI15b);
            lbTienIchItem.setBorder(new EmptyBorder(9, 5, 9, 5));
            lbTienIchItem.setOpaque(true);
            scp.setBorder(BorderFactory.createEmptyBorder());
            scp.setBackground(Color.decode("#dee9fc"));
            scp.getViewport().setBackground(Color.decode("#FAFAFA"));
            scp.setViewportView(tb);
            scpItem.setBorder(BorderFactory.createEmptyBorder());
            scpItem.setBackground(Color.decode("#dee9fc"));
            scpItem.getViewport().setBackground(Color.decode("#FAFAFA"));
            scpItem.setVerticalScrollBar(scbarItem);
            pnTienIchItemContent.setBorder(new EmptyBorder(5, 0, 0, 0));
            tb.getTableHeader().setBackground(Color.decode("#dee9fc"));
            tb.setDefaultRenderer(Object.class, new TableTienIchTableCellRenderer());
            lbTienIchItem.setBackground(Color.decode("#ebf2fc"));
            pnTienIchTableTop.setBackground(Color.decode("#ebf2fc"));
            pnTienIchTableTop.setBorder(new EmptyBorder(5, 5, 5, 5));
            lbTienIchTable.setForeground(Color.decode("#33419C"));
            lbTienIchItem.setForeground(Color.decode("#33419C"));
            pnTienIchItemContent.setBackground(Color.decode("#FAFAFA"));
            txtSearch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#FFFFFF")),
                    new EmptyBorder(5, 5, 5, 5)));
            renderTB();
//            editor.getButton().setEnabled(false);
//			ArrayList<ItemTienIch> list1 = new ArrayList<>();
            for (TienIchDTO itemTienIch : ChiTietTienIchBUS.getInstance().layDStienIchBangMaPhong(maP)) {
                int soLuong = 0;
                for (int i = 0; i < tb.getRowCount(); i++) {
                    if (itemTienIch.getMaTI().equalsIgnoreCase(tb.getValueAt(i, 1).toString())) {
                        soLuong = Integer
                                .parseInt(tb.getValueAt(i, tb.getColumnModel().getColumnIndex("Số lượng")).toString());
                    }
                }
                ItemTienIch newItem = new ItemTienIch(itemTienIch.getMaTI(), itemTienIch.getTenTI(), soLuong);
                newItem.setMaximumSize(new Dimension(320, 100));
                pnTienIchItemContent.add(newItem);
                newItem.setSoLuong(itemTienIch.getSoLuong());

                listItem.add(newItem);
                if (newItem.getSoLuong() == 0) {
                    newItem.setVisible(false);
                    listItem.remove(newItem);
                }
            }
            AddEventDelete(maP);

            editor.getButton().addActionListener(new ActionListener() {
                int soLuongTB = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    soLuongTB = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), 3).toString());
                    soLuongTB--;
                    tb.setValueAt(soLuongTB, tb.getSelectedRow(), 3);
//                	System.out.println("nhận sự kiện");
                    try {
                        pnTienIchItemContent.revalidate();
                        String maTI = tb
                                .getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã tiện ích"))
                                .toString();
                        boolean check = false;
                        for (ItemTienIch item : listItem) {
                            if (item.getMaTI().equals(maTI)) {
                                if (item.getSoLuong() < item.getMaximum()) {
                                    item.setSoLuong(item.getSoLuong() + 1);
                                }
                                check = true;
                                break;
                            }
                        }
                        if (!check) {
                            String tenTI = tb
                                    .getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Tên tiện ích"))
                                    .toString();
                            int soLuong = Integer.parseInt(
                                    tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Số lượng"))
                                            .toString());
                            ItemTienIch newItem = new ItemTienIch(maTI, tenTI, soLuong);
                            pnTienIchItemContent.add(newItem);
                            newItem.setMaximumSize(new Dimension(320, 100));
//							newItem.setVisible(true);
                            listItem.add(newItem);
                        }
                        AddEventDelete(maP);
                        eventSpinner(maP);
                    } catch (Exception ex) {

                    }
                }
            });
        }

        void eventSpinner(String maP) {
            for (ItemTienIch it : listItem) {
                int soLuongDatabase = ChiTietTienIchBUS.laySoLuongTienIchHienTai(maP, it.getMaTI());

                it.spinerSoLuong.addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        int soLuongSpiner = it.getSoLuong();
                        // TODO Auto-generated method stub
                        int soLuongTienIchtable = 0;
                        int soLuongCapNhat = 0;
                        for (int i = 0; i < tb.getRowCount(); i++) {
                            if (tb.getValueAt(i, 1).toString().equalsIgnoreCase(it.getMaTI())) {
//								System.out.println("nhận event");
                                soLuongTienIchtable = TienIchBUS.getSL(it.getMaTI());
                                soLuongCapNhat = soLuongTienIchtable - (soLuongSpiner - soLuongDatabase);
                                System.out.println("Số lượng data chi tiết tiện ích " + soLuongDatabase);
                                System.out.println("Số lượng spinner " + soLuongSpiner);
                                System.out.println("Số lượng table " + soLuongTienIchtable);
                                System.out.println("Số lượng cập nhât " + soLuongCapNhat);
                                tb.setValueAt(soLuongCapNhat, i, 3);
                            }
                        }

                    }
                });
            }
        }

        public void AddEventDelete(String maP) {
            for (ItemTienIch item : listItem) {
                item.btnExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ChiTietTienIchBUS.capNhatSL(maP, item.getMaTI(), 0);
                        int soLuongHienTai = TienIchBUS.getSL(item.getMaTI());
                        int soLuongCapNhat = soLuongHienTai + item.getSoLuong();
                        TienIchBUS.capNhatSL(item.getMaTI(), soLuongCapNhat);
                        renderTB();

                        for (int i = 0; i < listItem.size(); i++) {
                            if (listItem.get(i).equals(item)) {
                                listItem.remove(i);

                                break;
                            }

                        }
                        pnTienIchItemContent.removeAll();
                        pnTienIchItemContent.revalidate();
                        pnTienIchItemContent.repaint();
                        for (ItemTienIch item : listItem) {
                            pnTienIchItemContent.add(item);
                            item.setMaximumSize(new Dimension(pnTienIchItemContent.getWidth(), 100));
                        }
                    }
                });
            }
        }

        public void renderTB() {
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 4) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            dtm.addColumn("STT");
            dtm.addColumn("Mã tiện ích");
            dtm.addColumn("Tên tiện ích");
            dtm.addColumn("Số lượng");
            dtm.addColumn("Chức năng");
            ArrayList<TienIchDTO> listTI = new ArrayList<>();
            for (TienIchDTO x : TienIchBUS.getListTI()) {
                listTI.add(x);
            }
            for (int i = 0; i < listTI.size(); i++) {
                Object data[] = {i + 1, listTI.get(i).getMaTI() + "", listTI.get(i).getTenTI() + "",
                    listTI.get(i).getSoLuong() + "", "Thêm"};
                dtm.addRow(data);
            }
            tb.setModel(dtm);
            tb.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
            tb.getColumnModel().getColumn(4).setCellEditor(editor);
//            tb.setDefaultRenderer(Object.class, new TableTienIchTableCellRenderer());
            tb.setRowHeight(30);
            tb.setShowGrid(false);
            tb.setIntercellSpacing(new Dimension(0, 0));
            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tb.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        public void renderTB(ArrayList<TienIchDTO> listTI) {
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 4) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            dtm.addColumn("STT");
            dtm.addColumn("Mã tiện ích");
            dtm.addColumn("Tên tiện ích");
            dtm.addColumn("Số lượng");
            dtm.addColumn("Chức năng");
            for (int i = 0; i < listTI.size(); i++) {
                Object data[] = {i + 1, listTI.get(i).getMaTI() + "", listTI.get(i).getTenTI() + "",
                    listTI.get(i).getSoLuong() + "", "Thêm"};
                dtm.addRow(data);
            }
            tb.setModel(dtm);
            tb.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
            tb.getColumnModel().getColumn(4).setCellEditor(editor);
//            tb.setDefaultRenderer(Object.class, new TableTienIchTableCellRenderer());
            tb.setRowHeight(30);
            tb.setShowGrid(false);
            tb.setIntercellSpacing(new Dimension(0, 0));
            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tb.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb.getColumnModel().getColumn(4).setPreferredWidth(100);
        }
    }
}
