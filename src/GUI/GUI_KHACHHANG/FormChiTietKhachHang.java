package GUI.GUI_KHACHHANG;

import BUS.DichVuBUS;
import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import GUI.ThongBaoDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class FormChiTietKhachHang extends JDialog {

    JPanel pnContent = new JPanel();
    JPanel pnTop = new JPanel();
    JLabel lbTop = new JLabel("THÔNG TIN CHI TIẾT KHÁCH HÀNG");
    JLabel lbBottom = new JLabel();
    JPanel pnCenter = new JPanel();
    JPanel pnCenterInput = new JPanel();
    JPanel pnCenterImage = new JPanel();
    JPanel pnCenterTop = new JPanel();
    JPanel pnCenterBottom = new JPanel();
    JPanel pnEmpty = new JPanel();

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Calibri", Font.BOLD, 18);
    private Font tNR13 = new Font("Times New Roman", Font.PLAIN, 13);

    JLabel lbTenKH, lbCMND, lbSDT, lbGioiTinh, lbQueQuan, lbQuocTich, lbImg_FormRight, lbImage, lbSoLuongDV;
    JPanel pnImg, pnTenDV_formRight, pnLoaiDV_formRight, pnImgInput, pnGiaDV_formRight, pnGioiTinh, pnQueQuan,
            pnQuocTich;
    Border bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7, bdEmpty0_7_0_0;
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    LineBorder lineCB = new LineBorder(Color.white);
    JFileChooser fc = new JFileChooser("src\\GUI\\assets");
    JButton btnSelectFile;
    JTextField tfTenKH, tfSDT, txtSoLuongDV, tfQueQuan, tfQuocTich;
    JTextField tfCMND;
    JComboBox<String> cbbGioiTinh;

    JButton btnResetA = new JButton("Làm mới");
    JButton btnEdit = new JButton("Sửa");
//    JButton btnDelete = new JButton("Xóa");

    JPanel pnSoLuongDV = new JPanel();

    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
    PanelKhachHang panelKH;
    PanelKhachHangReception panelKHR;

    public FormChiTietKhachHang(String maKH, PanelKhachHang pnKH) {
        panelKH = pnKH;
        pnTenDV_formRight = new JPanel();
        pnLoaiDV_formRight = new JPanel();
        pnImgInput = new JPanel();
        pnGiaDV_formRight = new JPanel();
        pnGioiTinh = new JPanel();
        pnQueQuan = new JPanel();
        pnQuocTich = new JPanel();
        btnSelectFile = new JButton("Chọn hình");
        lbTenKH = new JLabel("Tên khách hàng");

        // tên khách hàng, chứng minh nhân dân, giới tính ,số điện thoại , quê quán,
        // quốc tịch
        lbCMND = new JLabel("Chứng minh nhân dân");
        lbSDT = new JLabel("Số điện thoại ");
        lbGioiTinh = new JLabel("Giới tính");
        lbQueQuan = new JLabel("Quê quán");
        lbQuocTich = new JLabel("Quốc Tịch");
        lbImg_FormRight = new JLabel("Hình ảnh");
        tfTenKH = new JTextField();
        tfSDT = new JTextField();
        tfCMND = new JTextField();
//		tfGioiTinh = new JTextField();
        cbbGioiTinh = new JComboBox<>();
        tfQueQuan = new JTextField();
        tfQuocTich = new JTextField();
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdEmpty0_7_0_7 = new EmptyBorder(0, 7, 0, 7);
        bdEmpty0_7_0_0 = new EmptyBorder(0, 7, 0, 0);
        lbImage = new JLabel();
        pnImg = new JPanel();
        lbSoLuongDV = new JLabel("Số lượng");
        txtSoLuongDV = new JTextField();
        initComponent(maKH);
    }

    public FormChiTietKhachHang(String maKH, PanelKhachHangReception pnKH) {
        panelKHR = pnKH;
        pnTenDV_formRight = new JPanel();
        pnLoaiDV_formRight = new JPanel();
        pnImgInput = new JPanel();
        pnGiaDV_formRight = new JPanel();
        pnGioiTinh = new JPanel();
        pnQueQuan = new JPanel();
        pnQuocTich = new JPanel();
        btnSelectFile = new JButton("Chọn hình");
        lbTenKH = new JLabel("Tên khách hàng");

        // tên khách hàng, chứng minh nhân dân, giới tính ,số điện thoại , quê quán,
        // quốc tịch
        lbCMND = new JLabel("Chứng minh nhân dân");
        lbSDT = new JLabel("Số điện thoại ");
        lbGioiTinh = new JLabel("Giới tính");
        lbQueQuan = new JLabel("Quê quán");
        lbQuocTich = new JLabel("Quốc Tịch");
        lbImg_FormRight = new JLabel("Hình ảnh");
        tfTenKH = new JTextField();
        tfSDT = new JTextField();
        tfCMND = new JTextField();
//		tfGioiTinh = new JTextField();
        cbbGioiTinh = new JComboBox<>();
        tfQueQuan = new JTextField();
        tfQuocTich = new JTextField();
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdEmpty0_7_0_7 = new EmptyBorder(0, 7, 0, 7);
        bdEmpty0_7_0_0 = new EmptyBorder(0, 7, 0, 0);
        lbImage = new JLabel();
        pnImg = new JPanel();
        lbSoLuongDV = new JLabel("Số lượng");
        txtSoLuongDV = new JTextField();
        initComponent(maKH);
    }

    public void initComponent(String maKH) {
        KhachHangDTO kh = KhachHangBUS.getIntance().selectById(maKH);
        String tenKH = kh.getTenKH();
        String cmnd = kh.getCMND();
        String gioiTinh = kh.getGioiTinh();
        String sdt = kh.getSDT();
        String queQuan = kh.getQueQuan();
        String quocTich = kh.getQuocTich();
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        setTitle("Chi tiết khách hàng");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setSize(600, 600);
        setModal(true);
        setLocationRelativeTo(null);
        setBackground(Color.decode("#FCFCFC"));
        setLayout(new BorderLayout());
        setResizable(false);
        add(pnContent, BorderLayout.CENTER);
        pnContent.setBorder(new EmptyBorder(30, 30, 30, 30));
        pnContent.setBackground(Color.decode("#FCFCFC"));
        pnTop.setBackground(Color.decode("#FCFCFC"));
        lbTop.setForeground(Color.decode("#0D3A62"));

        pnContent.setLayout(new BorderLayout(10, 10));
        pnContent.add(pnTop, BorderLayout.NORTH);
        pnContent.add(pnCenter, BorderLayout.CENTER);
        pnTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnTop.add(lbTop);
        lbTop.setFont(tNR13);
        lbBottom.setFont(sgUI18b);
        pnTop.add(lbBottom);
        lbBottom.setText("Mã khách hàng: " + maKH);

        pnCenter.setLayout(new BorderLayout(5, 5));
        pnCenter.add(pnCenterTop, BorderLayout.CENTER);
        pnCenter.add(pnCenterBottom, BorderLayout.SOUTH);

        pnCenterTop.setLayout(new GridLayout(1, 2, 5, 5));
        pnCenterTop.add(pnCenterInput);
//		pnCenterTop.add(pnCenterImage);

//		pnCenterImage.setLayout(new BorderLayout(5, 5));
//		pnCenterImage.add(pnImgInput, BorderLayout.NORTH);
//		pnCenterImage.add(pnImg, BorderLayout.CENTER);
        pnImg.setBackground(Color.decode("#FCFCFC"));
        pnImg.setLayout(new BorderLayout());
        pnImg.add(lbImage, BorderLayout.CENTER);

        pnImgInput.setLayout(new BorderLayout());
        pnImgInput.add(lbImg_FormRight, BorderLayout.WEST);
        pnImgInput.add(btnSelectFile, BorderLayout.EAST);

        pnCenterInput.setLayout(new GridLayout(6, 1, 5, 5));
        pnCenterInput.add(pnTenDV_formRight);
        pnCenterInput.add(pnLoaiDV_formRight);
        pnCenterInput.add(pnGiaDV_formRight);
        pnCenterInput.add(pnGioiTinh);
        pnCenterInput.add(pnQueQuan);
        pnCenterInput.add(pnQuocTich);

//        if (check) {
//            pnCenterInput.add(pnSoLuongDV);
//        } else {
//            pnCenterInput.add(pnEmpty);
//        }
        setMouse(btnResetA);
        setMouseEdit();
//        setMouseDelete();

        txtSoLuongDV.setEditable(false);

        setLayoutPanel_2(pnTenDV_formRight, lbTenKH, tfTenKH);
        setLayoutPanel_2(pnLoaiDV_formRight, lbCMND, tfCMND);
        setLayoutPanel_2(pnGiaDV_formRight, lbSDT, tfSDT);
        setLayoutPanel_2(pnGioiTinh, lbGioiTinh, cbbGioiTinh);
        setLayoutPanel_2(pnQueQuan, lbQueQuan, tfQueQuan);
        setLayoutPanel_2(pnQuocTich, lbQuocTich, tfQuocTich);
//        setLayoutPanel_2(pnSoLuongDV, lbSoLuongDV, txtSoLuongDV);

        tfCMND.setFont(sgUI13);
        txtSoLuongDV.setFont(sgUI13);
        tfSDT.setFont(sgUI13);
        tfTenKH.setFont(sgUI13);
        cbbGioiTinh.setFont(sgUI13);
        tfQueQuan.setFont(sgUI13);
        tfQuocTich.setFont(sgUI13);
        lbImage.setFont(sgUI13);
        tfCMND.setText("");
        ((AbstractDocument) tfCMND.getDocument()).setDocumentFilter(new DocumentFilter() {
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

        tfTenKH.setText(tenKH.trim());
        tfCMND.setText(cmnd.trim());
//		tfGioiTinh.setText(gioiTinh);

        tfSDT.setText(sdt.trim());
        tfSDT.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tfSDT.getText().trim().length() >= 10) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
        tfCMND.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tfCMND.getText().trim().length() >= 12) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
        ((AbstractDocument) tfSDT.getDocument()).setDocumentFilter(new DocumentFilter() {
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
        tfQueQuan.setText(queQuan);
        tfQuocTich.setText(quocTich);
//        fc.setSelectedFile(new File(pathImg));
//        ImageIcon icon = new ImageIcon(new ImageIcon(fc.getSelectedFile().toString()).getImage().getScaledInstance(255, 250, Image.SCALE_SMOOTH));
//        lbImage.setIcon(icon);
//        lbImage.setHorizontalAlignment(JLabel.CENTER);
//
//        try {
//            txtGiaDV_formRight.setText(dcf.parse(GiaDV) + "");
//        } catch (ParseException ex) {
//        }

        pnCenterBottom.setLayout(new GridLayout(1, 2, 10, 10));
        pnCenterBottom.add(btnResetA);
        pnCenterBottom.add(btnEdit);
//        pnCenterBottom.add(btnDelete);

        btnResetA.setFont(sgUI13b);
        btnResetA.setBorderPainted(false);
        btnResetA.setFocusPainted(false);

        btnEdit.setFont(sgUI13b);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);

        ImageIcon iconDelete = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/xoa.png")).getImage()
                .getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//        btnDelete.setIcon(iconDelete);

        ImageIcon iconEdit = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/sua.png")).getImage()
                .getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEdit.setIcon(iconEdit);

        ImageIcon iconReset = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/IconReset.png"))
                .getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnResetA.setIcon(iconReset);

//        btnDelete.setFont(sgUI13b);
//        btnDelete.setBorderPainted(false);
//        btnDelete.setFocusPainted(false);
        btnSelectFile.setFont(sgUI13b);
        btnSelectFile.setBorderPainted(false);
        btnSelectFile.setFocusPainted(false);

//		tfCMND.setEditable(false);
        tfTenKH.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        tfSDT.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        txtSoLuongDV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        tfCMND.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
//		tfGioiTinh.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        cbbGioiTinh.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbGioiTinh.setBackground(Color.white);
        cbbGioiTinh.setFont(sgUI13);
        cbbGioiTinh.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbGioiTinh.setBorder(matteBorderCB);
        layDuLieuCBB();
        if (gioiTinh.equals("Nam")) {
            cbbGioiTinh.setSelectedIndex(0);
        } else {
            cbbGioiTinh.setSelectedIndex(1);
        }
        tfQueQuan.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        tfQuocTich.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));

        tfCMND.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
        tfCMND.setBackground(Color.white);
        pnTenDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnLoaiDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnGiaDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnTenDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnGioiTinh.setBackground(Color.decode("#FCFCFC"));
        pnQueQuan.setBackground(Color.decode("#FCFCFC"));
        pnQuocTich.setBackground(Color.decode("#FCFCFC"));
        pnSoLuongDV.setBackground(Color.decode("#FCFCFC"));
        pnCenterInput.setBackground(Color.decode("#FCFCFC"));
        pnEmpty.setBackground(Color.decode("#FCFCFC"));
        pnImg.setBackground(Color.decode("#FCFCFC"));
        pnImgInput.setBackground(Color.decode("#FCFCFC"));
        pnCenterImage.setBackground(Color.decode("#FCFCFC"));
        pnCenterInput.setBackground(Color.decode("#FCFCFC"));
        pnCenterTop.setBackground(Color.decode("#FCFCFC"));
        pnCenterBottom.setBackground(Color.decode("#FCFCFC"));
        pnCenter.setBackground(Color.decode("#FCFCFC"));
        btnResetA.setBackground(Color.decode("#ebf2fc"));
        btnEdit.setBackground(Color.decode("#ffffcc"));
//        btnDelete.setBackground(Color.decode("#ffcccc"));
        btnSelectFile.setBackground(Color.decode("#ebf2fc"));
        setMouse(btnSelectFile);
        btnSelectFile.addActionListener((ActionEvent e) -> {
            fc.showDialog(null, "Open");
            if (fc.getSelectedFile() != null) {
                ImageIcon iconA = new ImageIcon(new ImageIcon(fc.getSelectedFile().toString()).getImage()
                        .getScaledInstance(pnImg.getWidth(), pnImg.getHeight(), Image.SCALE_SMOOTH));
                lbImage.setIcon(iconA);
                lbImage.setHorizontalAlignment(JLabel.CENTER);
            }
        });
        btnResetA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfSDT.setText(sdt);
                tfTenKH.setText(tenKH);
                tfQuocTich.setText(quocTich);
                tfQueQuan.setText(queQuan);

                fc.setSelectedFile(null);
                lbImage.setIcon(null);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    panelKH.tbKH.renderTB();
                } catch (Exception ex) {
                    panelKHR.tbKH.renderTB();
                }
            }
        });
//        btnDelete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dịch vụ có mã: " + MaDV, "Thông báo", JOptionPane.YES_NO_OPTION);
//                if (ans == JOptionPane.YES_OPTION) {
//                    String tmp = DichVuBUS.deleteDV(MaDV);
//                    if (tmp.equals("Xóa dịch vụ thành công")) {
//                        JOptionPane.showMessageDialog(null, "Xóa thành công dịch vụ có mã: " + MaDV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                        displayService.tbDV.renderTB();
//                        displayService.reset();
//                        dispose();
//                    } else if (tmp.equals("Xóa dịch vụ không thành công")) {
//                        JOptionPane.showMessageDialog(null, "Sửa không thành công dịch vụ có mã: " + MaDV, "Thông báo", JOptionPane.ERROR_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Mã dịch vụ không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            }
//        });
//        DichVuDTO a = DichVuBUS.searchDV(MaDV);
//        txtSoLuongDV.setText(a.getSoLuong()+"");
//
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eTenKH = tfTenKH.getText();
                String eCMND = tfCMND.getText();
                String eSDT = tfSDT.getText();
                String eGioiTinh = cbbGioiTinh.getSelectedItem().toString();
                String eQueQuan = tfQueQuan.getText();
                String eQuocTich = tfQuocTich.getText();
                if (eTenKH.equalsIgnoreCase(tenKH) && eCMND.equalsIgnoreCase(cmnd) && eSDT.equalsIgnoreCase(sdt) && eGioiTinh.equalsIgnoreCase(gioiTinh) && eQueQuan.equalsIgnoreCase(queQuan) && eQuocTich.equalsIgnoreCase(quocTich)) {
                    new ThongBaoDialog("Không có sự thay đổi nào!", ThongBaoDialog.ERROR_DIALOG);
                    return;
                }
                new ThongBaoDialog("Bạn đã chắc chắn với tùy chọn này", ThongBaoDialog.WARNING_DIALOG);
                KhachHangDTO khachHang = kh;
                khachHang.setMaKH(maKH);
                khachHang.setTenKH(eTenKH);
                khachHang.setCMND(eCMND);
                khachHang.setSDT(eSDT);
                khachHang.setGioiTinh(eGioiTinh);
                khachHang.setQueQuan(eQueQuan);
                khachHang.setQuocTich(eQuocTich);
                String thongBao = KhachHangBUS.updateKH(khachHang);
                if (thongBao.equalsIgnoreCase("sửa khách hàng thành công")) {
                    new ThongBaoDialog(thongBao, ThongBaoDialog.SUCCESS_DIALOG);
                } else {
                    new ThongBaoDialog(thongBao, ThongBaoDialog.ERROR_DIALOG);
                }
                dispose();
                try {
                    panelKH.tbKH.renderTB();
                } catch (Exception ex) {
                    panelKHR.tbKH.renderTB();
                }
            }
        });
        setVisible(true);
    }

    public void setLayoutPanel_2(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(textfield, BorderLayout.CENTER);
    }

    public void setLayoutPanel_2(JPanel panel, JLabel label, JComboBox comboBox) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(comboBox, BorderLayout.CENTER);
    }

    public void setMouse(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                x.setBackground(Color.decode("#98befa"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                x.setBackground(Color.decode("#ebf2fc"));
            }
        });
    }

    public void setMouseEdit() {
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEdit.setBackground(Color.decode("#ffff33"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEdit.setBackground(Color.decode("#ffffcc"));
            }
        });
    }

    public void layDuLieuCBB() {
        Vector<String> listKhoangGia = new Vector<>();
        listKhoangGia.add("Nam");
        listKhoangGia.add("Nữ");

        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listKhoangGia);
        cbbGioiTinh.setModel(cbmodel);
    }

//    public void setMouseDelete() {
//        btnDelete.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnDelete.setBackground(Color.decode("#ff3333"));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnDelete.setBackground(Color.decode("#ffcccc"));
//            }
//        });
//    }
}
