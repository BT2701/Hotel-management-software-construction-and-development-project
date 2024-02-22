package GUI.GUI_DICHVU;

import BUS.PhieuNhapBUS;
import DTO.PhieuNhapDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.*;

public class DisplayImportContent extends JPanel {

    JPanel pnTop, pnMaPN, pnTenNV, pnTuNgay, pnDenNgay, pnTinhTrang, pnButton, pnTopNorth, pnTopSouth, pnCenter,
            pnMenu, pnAll, pnAllNorth, pnAllContent, pnYes, pnYesNorth, pnYesContent, pnNo, pnNoNorth, pnNoContent,
            pnContentCenter;
    JLabel lbMaPN, lbTenNV, lbTuNgay, lbDenNgay, lbTinhTrang, lbAllTitle, lbAllDetail, lbAllImg,
            lbYesTitle, lbYesDetail, lbYesImg, lbNoTitle, lbNoDetail, lbNoImg;
    JTextField txtMaPN, txtTenNV;
    JComboBox cbTinhTrang;
    JDateChooser dcTuNgay, dcDenNgay;
    JButton btnReset, btnSearch, btnAll, btnYes, btnNo;
    Font sgUI13b, sgUI18b, tNR13i, a13b;
    LineBorder lineCB;
    Border bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7, bdEmpty0_7_0_0, bdEmpty5_5_5_5, bdEmpt0_15_0_15,
            bdEmpty10_10_10_10, bdMatte2_2_2_2_dark;
    JScrollPane scp;
    ScrollBar scb;
    TablePhieuNhap tbPN;
    DisplayContentListService displayContentListService;
    JTextFieldDateEditor editorTuNgay;
    JTextFieldDateEditor editorDenNgay;
    int LightDark;

    public DisplayImportContent() {
        pnTop = new JPanel();
        pnTopNorth = new JPanel();
        pnTopSouth = new JPanel();
        pnMaPN = new JPanel();
        pnTenNV = new JPanel();
        pnTuNgay = new JPanel();
        pnDenNgay = new JPanel();
        pnTinhTrang = new JPanel();
        pnButton = new JPanel();
        lbMaPN = new JLabel("Mã phiếu nhập");
        lbTenNV = new JLabel("Tên nhân viên");
        lbTuNgay = new JLabel("Từ ngày");
        lbDenNgay = new JLabel("Đến ngày");
        lbTinhTrang = new JLabel("Tình trạng");
        txtMaPN = new JTextField();
        txtTenNV = new JTextField();
        cbTinhTrang = new JComboBox();
        dcTuNgay = new JDateChooser();
        dcDenNgay = new JDateChooser();
        btnReset = new JButton("Làm mới");
        btnSearch = new JButton("Tìm kiếm");
        sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
        sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
        tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
        a13b = new Font("Arial", Font.BOLD, 13);
        lineCB = new LineBorder(Color.white);
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdMatte2_2_2_2_dark = new MatteBorder(2, 2, 2, 2, Color.decode("#FFFFFF"));
        bdEmpty0_7_0_7 = new EmptyBorder(0, 7, 0, 7);
        bdEmpty0_7_0_0 = new EmptyBorder(0, 7, 0, 0);
        bdEmpty5_5_5_5 = new EmptyBorder(5, 5, 5, 5);
        bdEmpt0_15_0_15 = new EmptyBorder(0, 15, 0, 15);
        bdEmpty10_10_10_10 = new EmptyBorder(10, 10, 10, 10);
        pnCenter = new JPanel();
        pnMenu = new JPanel();
        pnAll = new JPanel();
        pnAllContent = new JPanel();
        pnAllNorth = new JPanel();
        pnYes = new JPanel();
        pnYesContent = new JPanel();
        pnYesNorth = new JPanel();
        pnNo = new JPanel();
        pnNoContent = new JPanel();
        pnNoNorth = new JPanel();
        lbAllTitle = new JLabel("Tất cả tình trạng");
        lbAllImg = new JLabel();
        lbAllImg.setBorder(bdEmpty5_5_5_5);
        lbAllDetail = new JLabel(PhieuNhapBUS.listCount().get(0) + "");
        btnAll = new JButton("Xem tất cả");
        lbYesTitle = new JLabel("Đã xử lý");
        lbYesImg = new JLabel();
        lbYesImg.setBorder(bdEmpty5_5_5_5);
        lbYesDetail = new JLabel(PhieuNhapBUS.listCount().get(1) + "");
        btnYes = new JButton("Xem tất cả");
        lbNoTitle = new JLabel("Chưa xử lý");
        lbNoImg = new JLabel();
        lbNoImg.setBorder(bdEmpty5_5_5_5);
        lbNoDetail = new JLabel(PhieuNhapBUS.listCount().get(2) + "");
        btnNo = new JButton("Xem tất cả");
        scp = new JScrollPane();
        pnContentCenter = new JPanel();
        scp = new JScrollPane();
        tbPN = new TablePhieuNhap();
        displayContentListService = new DisplayContentListService(DisplayImportContent.this);
        editorTuNgay = (JTextFieldDateEditor) dcTuNgay.getDateEditor();
        editorDenNgay = (JTextFieldDateEditor) dcDenNgay.getDateEditor();
        initComponents();
    }

    public void initComponents() {
        setLayout(new BorderLayout(5, 5));
        add(pnTop, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);
        pnTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnTop.add(pnTopNorth);
        pnTop.add(pnTopSouth);
        pnTopNorth.setLayout(new GridLayout(1, 5, 10, 10));
        pnTopNorth.add(pnMaPN);
        pnTopNorth.add(pnTenNV);
        pnTopNorth.add(pnTuNgay);
        pnTopNorth.add(pnDenNgay);
        pnTopNorth.add(pnTinhTrang);
        pnTopSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pnTopSouth.add(pnButton);
        setLayoutPanel(pnMaPN, lbMaPN, txtMaPN);
        setLayoutPanel(pnTenNV, lbTenNV, txtTenNV);
        setLayoutPanel(pnTinhTrang, lbTinhTrang, cbTinhTrang);
        setLayoutPanel(pnTuNgay, lbTuNgay, dcTuNgay);
        setLayoutPanel(pnDenNgay, lbDenNgay, dcDenNgay);
        lbMaPN.setFont(sgUI13b);
        lbTenNV.setFont(sgUI13b);
        lbTinhTrang.setFont(sgUI13b);
        lbTuNgay.setFont(sgUI13b);
        lbDenNgay.setFont(sgUI13b);
        pnButton.setLayout(new GridLayout(1, 2, 10, 10));
        pnButton.add(btnReset);
        pnButton.add(btnSearch);
        cbTinhTrang.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        btnReset.setFocusPainted(false);
        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        setMouse(btnReset);
        setMouse(btnSearch);

        //set display center
        pnCenter.setLayout(new BorderLayout(5, 5));
        pnCenter.add(pnMenu, BorderLayout.WEST);
        pnMenu.setLayout(new GridLayout(3, 1, 10, 10));
        pnMenu.setBorder(new EmptyBorder(0, 0, 250, 0));
        pnMenu.add(pnAll);
        pnMenu.add(pnYes);
        pnMenu.add(pnNo);
        ImageIcon iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/them.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        lbAllImg.setIcon(iconAdd);
        lbYesImg.setIcon(iconAdd);
        lbNoImg.setIcon(iconAdd);
        setLayoutMenu(pnAll, pnAllNorth, pnAllContent, lbAllImg, lbAllTitle, lbAllDetail, btnAll);
        setLayoutMenu(pnYes, pnYesNorth, pnYesContent, lbYesImg, lbYesTitle, lbYesDetail, btnYes);
        setLayoutMenu(pnNo, pnNoNorth, pnNoContent, lbNoImg, lbNoTitle, lbNoDetail, btnNo);
        lbAllTitle.setFont(a13b);
        lbAllDetail.setFont(sgUI13b);
        btnAll.setFocusPainted(false);
        btnAll.setHorizontalAlignment(JLabel.LEFT);
        btnAll.setBorderPainted(false);
        lbYesTitle.setFont(a13b);
        lbYesDetail.setFont(sgUI13b);
        btnYes.setFocusPainted(false);
        btnYes.setHorizontalAlignment(JLabel.LEFT);
        btnYes.setBorderPainted(false);
        lbNoTitle.setFont(a13b);
        lbNoDetail.setFont(sgUI13b);
        btnNo.setFocusPainted(false);
        btnNo.setHorizontalAlignment(JLabel.LEFT);
        btnNo.setBorderPainted(false);
        setMouse_View(btnAll);
        setMouse_View(btnYes);
        setMouse_View(btnNo);

        pnCenter.add(pnMenu, BorderLayout.WEST);
        pnCenter.add(pnContentCenter, BorderLayout.CENTER);

        pnContentCenter.setLayout(new BorderLayout(5, 10));
        pnContentCenter.add(scp, BorderLayout.CENTER);
        scb = new ScrollBar(Color.decode("#ebf2fc"), Color.white);
        scp.setVerticalScrollBar(scb);
        scp.setViewportView(tbPN);
        scp.setBorder(BorderFactory.createEmptyBorder());
        tbPN.renderTB();
        displayContentListService.lightDark(LightDark);
        dcDenNgay.setDateFormatString("dd-MM-yyyy");
        dcTuNgay.setDateFormatString("dd-MM-yyyy");

        pnContentCenter.add(displayContentListService, BorderLayout.EAST);
        tbPN.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String maPN = tbPN.getValueAt(tbPN.getSelectedRow(), tbPN.getColumnModel().getColumnIndex("Mã phiếu nhập")).toString();
                    String tenNV = tbPN.getValueAt(tbPN.getSelectedRow(), tbPN.getColumnModel().getColumnIndex("Tên nhân viên")).toString();
                    String ngayLapPhieu = tbPN.getValueAt(tbPN.getSelectedRow(), tbPN.getColumnModel().getColumnIndex("Ngày lập phiếu")).toString();
                    String tinhTrang = tbPN.getValueAt(tbPN.getSelectedRow(), tbPN.getColumnModel().getColumnIndex("Tình trạng")).toString();
                    displayContentListService.txtMaPN.setText(maPN);
                    displayContentListService.txtTenNV.setText(tenNV);
                    displayContentListService.txtNgayLapPhieu.setText(ngayLapPhieu);
                    displayContentListService.txtTinhTrang.setText(tinhTrang);
                } catch (Exception ex) {
                    displayContentListService.txtMaPN.setText("");
                    displayContentListService.txtTenNV.setText("");
                    displayContentListService.txtNgayLapPhieu.setText("");
                    displayContentListService.txtTinhTrang.setText("");
                }
            }
        });
        btnAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaPN.setText("");
                txtTenNV.setText("");
                editorDenNgay.setText("");
                editorTuNgay.setText("");
                cbTinhTrang.setSelectedIndex(0);
                tbPN.renderTB();
            }
        });
        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<PhieuNhapDTO> list = PhieuNhapBUS.getListPN(0);
                if (list.isEmpty()) {
                    new ThongBaoDialog("Không tim thấy phiếu nhập nào", 1);
                } else {
                    txtMaPN.setText("");
                    txtTenNV.setText("");
                    editorDenNgay.setText("");
                    editorTuNgay.setText("");
                    cbTinhTrang.setSelectedIndex(0);
                    tbPN.renderTB(list);
                }
            }
        });
        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<PhieuNhapDTO> list = PhieuNhapBUS.getListPN(1);
                if (list.isEmpty()) {
                    new ThongBaoDialog("Không tim thấy phiếu nhập nào", 1);
                } else {
                    txtMaPN.setText("");
                    txtTenNV.setText("");
                    editorDenNgay.setText("");
                    editorTuNgay.setText("");
                    cbTinhTrang.setSelectedIndex(0);
                    tbPN.renderTB(list);
                }
            }
        });
        cbTinhTrang.removeAllItems();
        cbTinhTrang.addItem("Tình trạng");
        cbTinhTrang.addItem("Chưa xử lý");
        cbTinhTrang.addItem("Đã xử lý");

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaPN.setText("");
                txtTenNV.setText("");
                editorTuNgay.setText("");
                editorDenNgay.setText("");
                cbTinhTrang.setSelectedIndex(0);
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaPN.getText().trim().length() == 0
                        && txtTenNV.getText().trim().length() == 0
                        && dcTuNgay.getDate() == null && dcDenNgay.getDate() == null && cbTinhTrang.getSelectedIndex() == 0) {
                    new ThongBaoDialog("Vui lòng nhập thông tin tìm kiếm", 1);
                } else {
                    if (dcTuNgay.getDate() != null && dcDenNgay.getDate() != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateTuNgay = sdf.format(dcTuNgay.getDate()) + " 00:00:00";
                        String dateDenNgay = sdf.format(dcDenNgay.getDate()) + " 00:00:00";
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime lcdTuNgay = LocalDateTime.parse(dateTuNgay, dtf);
                        LocalDateTime lcdDenNgay = LocalDateTime.parse(dateDenNgay, dtf);
                        if (lcdTuNgay.isAfter(lcdDenNgay)) {
                            new ThongBaoDialog("Vui lòng chọn đến ngày phải sau từ ngày", 1);
                            return;
                        }
                    }
                    String[] fields = new String[5];
                    if (txtMaPN.getText().trim().length() != 0) {
                        fields[0] = txtMaPN.getText().trim();
                    }
                    if (txtTenNV.getText().trim().length() != 0) {
                        fields[1] = txtTenNV.getText().trim();
                    }
                    if (dcTuNgay.getDate() != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateTuNgay = sdf.format(dcTuNgay.getDate()) + " 00:00:00";
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime lcdTuNgay = LocalDateTime.parse(dateTuNgay, dtf);
                        fields[2] = lcdTuNgay.format(dtf);
                    }
                    if (dcDenNgay.getDate() != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String dateDenNgay = sdf.format(dcDenNgay.getDate()) + " 00:00:00";
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime lcdDenNgay = LocalDateTime.parse(dateDenNgay, dtf);
                        fields[3] = lcdDenNgay.format(dtf);
                    }
                    if (cbTinhTrang.getSelectedIndex() != 0) {
                        fields[4] = cbTinhTrang.getSelectedIndex() - 1 + "";
                    }
                    ArrayList<PhieuNhapDTO> listPhieuNhap = PhieuNhapBUS.getListPN(fields);
                    if (listPhieuNhap.isEmpty()) {
                        new ThongBaoDialog("Không tìm thấy phiếu nhập nào", 1);
                        tbPN.renderTB();
                        txtMaPN.setText("");
                        txtTenNV.setText("");
                        editorDenNgay.setText("");
                        editorTuNgay.setText("");
                        cbTinhTrang.setSelectedIndex(0);
                    } else {
                        tbPN.renderTB(listPhieuNhap);
                    }
                }
            }
        });

    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = LightDark;
            displayContentListService.lightDark(LightDark);
            setBackground(Color.white);
            txtMaPN.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            txtTenNV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            cbTinhTrang.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
            pnMaPN.setBackground(Color.white);
            pnTenNV.setBackground(Color.white);
            pnTuNgay.setBackground(Color.white);
            pnDenNgay.setBackground(Color.white);
            pnTinhTrang.setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnTopNorth.setBackground(Color.white);
            pnTopSouth.setBackground(Color.white);
            cbTinhTrang.setBackground(Color.white);
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            pnButton.setBackground(Color.white);
            pnCenter.setBackground(Color.white);
            pnMenu.setBackground(Color.decode("#FFFFFF"));
            pnAllNorth.setBackground(Color.decode("#EBF5FF"));
            pnAllContent.setBackground(Color.decode("#EBF5FF"));
            btnAll.setBackground(Color.decode("#B3D5F6"));
            lbAllTitle.setForeground(Color.decode("#a0a0a0"));
            pnYesNorth.setBackground(Color.decode("#EBF5FF"));
            pnYesContent.setBackground(Color.decode("#EBF5FF"));
            btnYes.setBackground(Color.decode("#B3D5F6"));
            lbYesTitle.setForeground(Color.decode("#a0a0a0"));
            pnNoNorth.setBackground(Color.decode("#EBF5FF"));
            pnNoContent.setBackground(Color.decode("#EBF5FF"));
            btnNo.setBackground(Color.decode("#B3D5F6"));
            lbNoTitle.setForeground(Color.decode("#a0a0a0"));
            scp.setBackground(Color.white);
            scp.getViewport().setBackground(Color.white);
            tbPN.getTableHeader().setBackground(Color.decode("#dee9fc"));
            tbPN.getTableHeader().setForeground(Color.decode("#000000"));
            pnContentCenter.setBackground(Color.white);
            dcTuNgay.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dcTuNgay.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
            dcTuNgay.getCalendarButton().setFocusPainted(false);
            dcDenNgay.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dcDenNgay.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
            dcDenNgay.getCalendarButton().setFocusPainted(false);
            editorTuNgay.setBackground(Color.decode("#FFFFFF"));
            editorTuNgay.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
            editorDenNgay.setBackground(Color.decode("#FFFFFF"));
            editorDenNgay.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
            lbDenNgay.setForeground(Color.black);
            lbMaPN.setForeground(Color.black);
            lbTenNV.setForeground(Color.black);
            lbTinhTrang.setForeground(Color.black);
            lbTuNgay.setForeground(Color.black);
            btnAll.setBackground(Color.decode("#B3D5F6"));
            btnAll.setForeground(Color.black);
            btnYes.setBackground(Color.decode("#B3D5F6"));
            btnYes.setForeground(Color.black);
            btnNo.setBackground(Color.decode("#B3D5F6"));
            btnNo.setForeground(Color.black);
        } else {
            this.LightDark = LightDark;
            displayContentListService.lightDark(LightDark);
            Color black = Color.decode("#333333");
            setBackground(black);
            txtMaPN.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_dark, bdEmpty0_7_0_7));
            txtTenNV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_dark, bdEmpty0_7_0_7));
            cbTinhTrang.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_dark, bdEmpty0_7_0_0));
            
            pnMaPN.setBackground(black);
            pnTenNV.setBackground(black);
            pnTuNgay.setBackground(black);
            pnDenNgay.setBackground(black);
            pnTinhTrang.setBackground(black);
            pnTop.setBackground(black);
            pnTopNorth.setBackground(black);
            pnTopSouth.setBackground(black);
            pnButton.setBackground(black);
            pnCenter.setBackground(black);
            pnMenu.setBackground(Color.decode("#333333"));
            pnAllNorth.setBackground(Color.decode("#FAFAFA"));
            pnAllContent.setBackground(Color.decode("#FAFAFA"));
            lbAllTitle.setForeground(Color.decode("#a0a0a0"));
            pnYesNorth.setBackground(Color.decode("#FAFAFA"));
            pnYesContent.setBackground(Color.decode("#FAFAFA"));
            lbYesTitle.setForeground(Color.decode("#a0a0a0"));
            pnNoNorth.setBackground(Color.decode("#FAFAFA"));
            pnNoContent.setBackground(Color.decode("#FAFAFA"));
            lbNoTitle.setForeground(Color.decode("#a0a0a0"));
            scp.setBackground(black);
            scp.getViewport().setBackground(black);
            tbPN.getTableHeader().setBackground(Color.decode("#202020"));
            tbPN.getTableHeader().setForeground(Color.decode("#FFFFFF"));
            pnContentCenter.setBackground(black);
            dcTuNgay.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dcTuNgay.getCalendarButton().setBackground(Color.decode("#919191"));
            dcTuNgay.getCalendarButton().setFocusPainted(false);
            dcDenNgay.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dcDenNgay.getCalendarButton().setBackground(Color.decode("#919191"));
            dcDenNgay.getCalendarButton().setFocusPainted(false);
            editorTuNgay.setBackground(Color.decode("#FFFFFF"));
            editorTuNgay.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
            editorDenNgay.setBackground(Color.decode("#FFFFFF"));
            editorDenNgay.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));

            lbDenNgay.setForeground(Color.white);
            lbMaPN.setForeground(Color.white);
            lbTenNV.setForeground(Color.white);
            lbTinhTrang.setForeground(Color.white);
            lbTuNgay.setForeground(Color.white);
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            btnAll.setBackground(Color.decode("#4c4d4c"));
            btnAll.setForeground(Color.white);
            btnYes.setBackground(Color.decode("#4c4d4c"));
            btnYes.setForeground(Color.white);
            btnNo.setBackground(Color.decode("#4c4d4c"));
            btnNo.setForeground(Color.white);
        }
    }

    public void setLayoutPanel(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.WEST);
        panel.add(textfield, BorderLayout.CENTER);
    }

    public void setLayoutPanel(JPanel panel, JLabel label, JDateChooser dateChooser) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.WEST);
        panel.add(dateChooser, BorderLayout.CENTER);
    }

    public void setMouse(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#98befa"));
                } else {
                    x.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#ebf2fc"));
                } else {
                    x.setBackground(Color.decode("#F0F0F0"));
                }
            }
        });
    }

    public TablePhieuNhap getTbPN() {
        return tbPN;
    }

    public void setMouse_View(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#98befa"));
                    x.setForeground(Color.white);
                } else {
                    x.setBackground(Color.decode("#4D4D4D"));
                    x.setForeground(Color.black);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#B3D5F6"));
                    x.setForeground(Color.black);
                } else {
                    x.setBackground(Color.decode("#4c4d4c"));
                    x.setForeground(Color.white);
                }
            }
        });
    }

    public void setLayoutPanel(JPanel panel, JLabel label, JComboBox combobox) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.WEST);
        panel.add(combobox, BorderLayout.CENTER);
    }

    public void setLayoutMenu(JPanel panel, JPanel pnNorth, JPanel pnContent, JLabel img, JLabel title, JLabel detail, JButton btn) {
        panel.setLayout(new BorderLayout());
        panel.add(pnNorth, BorderLayout.CENTER);
        panel.add(btn, BorderLayout.SOUTH);

        pnNorth.setLayout(new BorderLayout());
        pnNorth.add(img, BorderLayout.WEST);
        pnNorth.add(pnContent, BorderLayout.CENTER);
        pnNorth.setBorder(bdEmpt0_15_0_15);
        pnContent.setLayout(new GridLayout(2, 1));
        pnContent.setBorder(bdEmpty10_10_10_10);
        pnContent.add(title);
        pnContent.add(detail);
    }
}
