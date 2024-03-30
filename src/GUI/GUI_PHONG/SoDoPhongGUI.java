package GUI.GUI_PHONG;

import BUS.PhongBUS;
import DTO.PhongDTO;
import GUI.GUI_BASIC.ReceptionistGUI;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.GUI_RENDER_COMPONENTS.TimeChoose;
import GUI.ThongBaoDialog;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class SoDoPhongGUI extends JPanel {

    /////////////////////////////////////////////////////////////////////////////////////////////
    LineBorder lineCB = new LineBorder(Color.white);
    ArrayList<JPanel> listPN = new ArrayList<>();
    JPanel pnLoaiP = new JPanel();
    JLabel lbLoaiP = new JLabel("Loại phòng");
    JComboBox cbLoaiP = new JComboBox();
    JPanel pnChiTietLoaiP = new JPanel();
    JLabel lbChiTietLoaiP = new JLabel("Phòng");
    JComboBox cbChiTietLoaiP = new JComboBox();
    JPanel pnGiaP = new JPanel();
    JLabel lbGiaP = new JLabel("Giá phòng");
    JComboBox cbGiaP = new JComboBox();
    JPanel pnHTP = new JPanel();
    JLabel lbHTP = new JLabel("Hiện trạng phòng");
    JComboBox cbHTP = new JComboBox();
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    JPanel pnTitle = new JPanel();
    JLabel lbDetail = new JLabel("Vui lòng chọn phòng khách muốn đặt");

    JLabel lbLoaiHinhThue = new JLabel("Loại hình thuê");
    JLabel lbNgayThue = new JLabel("Ngày thuê");
    JLabel lbGioThue = new JLabel("Giờ thuê");
    JLabel lbNgayTra = new JLabel("Ngày trả");
    JLabel lbGioTra = new JLabel("Giờ trả");
    public JRadioButton rdNgay = new JRadioButton("Theo ngày");
    public JRadioButton rdGio = new JRadioButton("Theo giờ");
    public JRadioButton rdKhac = new JRadioButton("Khác");
    public JDateChooser dateThue = new JDateChooser();
    public TimeChoose timeThue = new TimeChoose();
    public JDateChooser dateTra = new JDateChooser();
    public TimeChoose timeTra = new TimeChoose();
    public JTextFieldDateEditor editorThue = (JTextFieldDateEditor) dateThue.getDateEditor();
    public JTextFieldDateEditor editorTra = (JTextFieldDateEditor) dateTra.getDateEditor();
    JPanel pnLoaiHinhThue = new JPanel();
    JPanel pnNgayThue = new JPanel();
    JPanel pnNgayTra = new JPanel();
    JPanel pnDateChoose = new JPanel();
    JPanel pnButtonChoose = new JPanel();
    JButton btnSelectPhong = new JButton("Chọn phòng");
    ButtonGroup bg = new ButtonGroup();
    JPanel pnNgayThueInput = new JPanel();
    JPanel pnGioThueInput = new JPanel();
    JPanel pnNgayTraInput = new JPanel();
    JPanel pnGioTraInput = new JPanel();
    /////////////////////////////////////////////////////////////////////////////////////////////

    private JButton[] btnTrangThai = new JButton[5];
    private ArrayList<ItemCellRoom> ListLbPhong = new ArrayList<>();
    private ArrayList<JPanel> ListpanelCenter = new ArrayList<>();
    private JLabel title, lbTrangThai;
    private JPanel pnTop, pnTopCenter, pnTopTop, pnCenter, pnTopTopCenter;
    private JScrollPane scrTTphong;

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 20);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontTable = new Font("Tahoma", Font.BOLD, 13);
    ReceptionistGUI receptionistGUI;
    JPanel pnTopCenterTop = new JPanel();
    JPanel pnDate = new JPanel();

    public SoDoPhongGUI(ReceptionistGUI receptionistGUI) {
        this.receptionistGUI = receptionistGUI;
        initComponent(receptionistGUI);
        lightDark(0);
    }

    public void initComponent(ReceptionistGUI receptionistGUI) {
        title = new JLabel("Sơ đồ phòng");
        lbDetail.setFont(tNR13);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pnTopTopCenter = new JPanel();

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        pnTopTopCenter.setBorder(new EmptyBorder(0, 5, 0, 5));
        pnTopTopCenter.setLayout(new GridLayout(1, 4, 10, 10));
        pnTopTopCenter.setPreferredSize(new Dimension(100, 30));
        pnTopTopCenter.setMaximumSize(new Dimension(100, 30));
        listPN.add(pnLoaiP);
        listPN.add(pnChiTietLoaiP);
        listPN.add(pnGiaP);
        listPN.add(pnHTP);
        for (JPanel x : listPN) {
            pnTopTopCenter.add(x);
            x.setLayout(new BorderLayout(18, 10));
        }
        lbLoaiP.setFont(sgUI15);
        lbChiTietLoaiP.setFont(sgUI15);
        lbGiaP.setFont(sgUI15);
        lbHTP.setFont(sgUI15);
        cbChiTietLoaiP.setFont(sgUI13);
        cbGiaP.setFont(sgUI13);
        cbHTP.setFont(sgUI13);
        cbLoaiP.setFont(sgUI13);

        String chiTietLoaiP[] = {"Chi tiết loại phòng", "Phòng đơn", "Phòng đôi", "Phòng gia đình"};
        String loaiP[] = {"Loại phòng", "VIP", "Thường"};
        String tTP[] = {"Trạng thái phòng", "Trống", "Đang được thuê", "Chưa dọn phòng", "Đã được đặt", "Chưa có tiện ích"};
        String hTP[] = {"Hiện trạng", "Phòng cũ", "Phòng mới"};
        String giaP[] = {"Giá phòng", "Dưới 100000", "Từ 100000 đến 200000", "Từ 200000 đến 500000", "Từ 500000 đến 1000000", "Trên 1000000"};
        setDefaulComboBox(cbChiTietLoaiP, chiTietLoaiP);
        setDefaulComboBox(cbGiaP, giaP);
        setDefaulComboBox(cbHTP, hTP);
        setDefaulComboBox(cbLoaiP, loaiP);

        cbChiTietLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbHTP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbGiaP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        pnLoaiP.add(lbLoaiP, BorderLayout.WEST);
        pnLoaiP.add(cbLoaiP, BorderLayout.CENTER);
        pnChiTietLoaiP.add(lbChiTietLoaiP, BorderLayout.WEST);
        pnChiTietLoaiP.add(cbChiTietLoaiP, BorderLayout.CENTER);
        pnGiaP.add(lbGiaP, BorderLayout.WEST);
        pnGiaP.add(cbGiaP, BorderLayout.CENTER);
        pnHTP.add(lbHTP, BorderLayout.WEST);
        pnHTP.add(cbHTP, BorderLayout.CENTER);

        pnTopTopCenter.setBackground(Color.white);

        pnTopTop = new JPanel();
        pnTopTop.setLayout(new BorderLayout());
        pnTopTop.add(pnTitle, BorderLayout.NORTH);
        pnTopTop.add(pnTopTopCenter, BorderLayout.CENTER);
        pnTopTop.setBackground(Color.white);

        pnTitle.setLayout(new GridLayout(2, 1));
        pnTitle.add(title);
        pnTitle.add(lbDetail);
        pnTitle.setBorder(new EmptyBorder(0, 5, 0, 5));

        lbTrangThai = new JLabel("Trạng thái phòng: ", JLabel.LEFT);
        lbTrangThai.setFont(sgUI15);

        btnTrangThai[0] = new JButton("Tất cả");
        btnTrangThai[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorThue.setText("");
                editorTra.setText("");
                rdNgay.setSelected(false);
                rdGio.setSelected(false);
                rdKhac.setSelected(false);
                timeThue.setHour(7);
                timeTra.setHour(7);
                timeThue.setMinute(0);
                timeTra.setMinute(0);
                ArrayList<PhongDTO> list = search();
                renderCell(list);
            }
        });

        btnTrangThai[1] = new JButton("Phòng trống");
        btnTrangThai[3] = new JButton("Phòng chưa dọn");
        btnTrangThai[2] = new JButton("Phòng đang được thuê");
        btnTrangThai[4] = new JButton("Làm mới");
        for (int i = 1; i < 4; i++) {
            btnTrangThai[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editorThue.setText("");
                    editorTra.setText("");
                    rdNgay.setSelected(false);
                    rdGio.setSelected(false);
                    rdKhac.setSelected(false);
                    timeThue.setHour(7);
                    timeTra.setHour(7);
                    timeThue.setMinute(0);
                    timeTra.setMinute(0);
                    ArrayList<PhongDTO> list = search();
                    ArrayList<PhongDTO> listTmp = new ArrayList<>();
                    int tt = (e.getSource() == btnTrangThai[1]) ? 0 : e.getSource() == btnTrangThai[2] ? 1 : 2;
                    for (PhongDTO x : list) {
                        if (x.getTinhTrang() == tt) {
                            listTmp.add(x);
                        }
                    }
                    renderCell(listTmp);
                }
            });
        }

        btnTrangThai[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbLoaiP.setSelectedIndex(0);
                cbChiTietLoaiP.setSelectedIndex(0);
                cbGiaP.setSelectedIndex(0);
                cbHTP.setSelectedIndex(0);
                editorThue.setText("");
                editorTra.setText("");
                rdNgay.setSelected(false);
                rdGio.setSelected(false);
                rdKhac.setSelected(false);
                timeThue.setHour(7);
                timeTra.setHour(7);
                timeThue.setMinute(0);
                timeTra.setMinute(0);

                if(rdNgay.isSelected()) {
                    rdNgay.setSelected(false);
                }
                if(rdGio.isSelected()) {
                    rdGio.setSelected(false);
                }
                if(rdKhac.isSelected()) {
                    rdKhac.setSelected(false);
                }
                rdNgay.setEnabled(true);
                rdGio.setEnabled(true);
                rdKhac.setEnabled(true);
                dateThue.setEnabled(true);
                dateTra.setEnabled(true);
                timeThue.setEnable(true);
                timeTra.setEnable(true);
                
                ArrayList<PhongDTO> listP = PhongBUS.getListP();
                renderCell(listP);
            }
        });

        for (int i = 0; i < btnTrangThai.length; i++) {
            btnTrangThai[i].setFont(sgUI13);
            btnTrangThai[i].setFocusPainted(false);
            switch (i) {
                case 0:
                    btnTrangThai[i].setBackground(Color.decode("#dee9fc"));
                    break;
                case 1:
                    btnTrangThai[i].setBackground(Color.decode("#2ecc71"));
                    break;
                case 2:
                    btnTrangThai[i].setBackground(Color.decode("#e74c3c"));
                    break;
                case 3:
                    btnTrangThai[i].setBackground(Color.decode("#f1c40f"));
                    break;
                default:
                    btnTrangThai[i].setBackground(Color.decode("#ebf2fc"));
                    break;
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pnTopCenter = new JPanel();
        pnTopCenter.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnTopCenter.add(lbTrangThai);
        pnTopCenter.setBackground(Color.white);
        for (JButton jButton : btnTrangThai) {
            pnTopCenter.add(jButton);
        }

        pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.add(pnTopTop, BorderLayout.NORTH);
        pnTop.add(pnTopCenterTop, BorderLayout.CENTER);
        pnTopCenterTop.setLayout(new GridLayout(2, 1));
        pnTopCenterTop.add(pnTopCenter);
        pnTopCenterTop.add(pnDate);
        pnDate.setBorder(new EmptyBorder(5, 0, 5, 0));
        lbLoaiHinhThue.setFont(sgUI15);
        lbGioThue.setFont(sgUI15);
        lbNgayThue.setFont(sgUI15);
        lbGioTra.setFont(sgUI15);
        lbNgayTra.setFont(sgUI15);
        rdKhac.setFont(sgUI15p);
        rdGio.setFont(sgUI15p);
        rdNgay.setFont(sgUI15p);
        pnDate.setLayout(new BorderLayout(5, 5));
        pnDate.setBackground(Color.decode("#FFFFFF"));
        pnDate.add(pnLoaiHinhThue, BorderLayout.WEST);
        pnDateChoose.setLayout(new GridLayout(1, 2, 5, 5));
        pnDateChoose.setBackground(Color.decode("#FFFFFF"));
        pnDateChoose.add(pnNgayThue);
        pnDateChoose.add(pnNgayTra);
        pnDate.add(pnDateChoose, BorderLayout.CENTER);
        pnButtonChoose.setLayout(new BorderLayout());
        pnButtonChoose.setBackground(Color.decode("#FFFFFFF"));
        pnButtonChoose.add(btnSelectPhong, BorderLayout.CENTER);
        pnDate.add(pnButtonChoose, BorderLayout.EAST);
        bg.add(rdGio);
        bg.add(rdNgay);
        bg.add(rdKhac);
        pnLoaiHinhThue.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnLoaiHinhThue.add(lbLoaiHinhThue);
        pnLoaiHinhThue.add(rdNgay);
        pnLoaiHinhThue.add(rdGio);
        pnLoaiHinhThue.add(rdKhac);
        pnLoaiHinhThue.setBackground(Color.decode("#FFFFFF"));
        rdNgay.setFocusPainted(false);
        rdNgay.setBackground(Color.decode("#FFFFFF"));
        rdGio.setFocusPainted(false);
        rdGio.setBackground(Color.decode("#FFFFFF"));
        rdKhac.setFocusPainted(false);
        rdKhac.setBackground(Color.decode("#FFFFFF"));

        pnNgayThue.setLayout(new GridLayout(1, 2, 5, 5));
        pnNgayThueInput.setLayout(new BorderLayout(5, 5));
        pnNgayThueInput.add(lbNgayThue, BorderLayout.WEST);
        pnNgayThueInput.add(dateThue, BorderLayout.CENTER);
        pnNgayThueInput.setBackground(Color.white);
        pnGioThueInput.setBackground(Color.white);
        pnGioThueInput.setLayout(new BorderLayout(5, 5));
        pnGioThueInput.add(lbGioThue, BorderLayout.WEST);
        pnGioThueInput.add(timeThue, BorderLayout.CENTER);
        pnNgayThue.add(pnNgayThueInput);
        pnNgayThue.add(pnGioThueInput);
        pnNgayThue.setBackground(Color.decode("#FFFFFF"));

        pnNgayTra.setLayout(new GridLayout(1, 2, 5, 5));
        pnNgayTraInput.setLayout(new BorderLayout(5, 5));
        pnNgayTraInput.add(lbNgayTra, BorderLayout.WEST);
        pnNgayTraInput.add(dateTra, BorderLayout.CENTER);
        pnNgayTraInput.setBackground(Color.white);
        pnGioTraInput.setBackground(Color.white);
        pnGioTraInput.setLayout(new BorderLayout(5, 5));
        pnGioTraInput.add(lbGioTra, BorderLayout.WEST);
        pnGioTraInput.add(timeTra, BorderLayout.CENTER);
        pnNgayTra.add(pnNgayTraInput);
        pnNgayTra.add(pnGioTraInput);
        pnNgayTra.setBackground(Color.decode("#FFFFFF"));
        pnNgayThue.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#FFFFFF")), new EmptyBorder(5, 5, 5, 5)));
        pnNgayTra.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#FFFFFF")), new EmptyBorder(5, 5, 5, 5)));

        dateThue.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateThue.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
        dateThue.getCalendarButton().setFocusPainted(false);
        dateThue.getCalendarButton().setContentAreaFilled(false);
        dateTra.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateTra.getCalendarButton().setBackground(Color.decode("#EFEFEF"));
        dateTra.getCalendarButton().setFocusPainted(false);
        dateTra.getCalendarButton().setContentAreaFilled(false);
        editorThue.setBackground(Color.decode("#FFFFFF"));
        editorThue.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
        editorTra.setBackground(Color.decode("#FFFFFF"));
        editorTra.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
        pnButtonChoose.setBorder(new EmptyBorder(5, 10, 5, 10));
        btnSelectPhong.setBackground(Color.decode("#f1c40f"));
        btnSelectPhong.setFocusPainted(false);

        btnSelectPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rdNgay.isSelected() || rdGio.isSelected() || rdKhac.isSelected()) {
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
                                        rdNgay.setEnabled(false);
                                        rdGio.setEnabled(false);
                                        rdKhac.setEnabled(false);
                                        dateThue.setEnabled(false);
                                        dateTra.setEnabled(false);
                                        timeThue.setEnable(false);
                                        timeTra.setEnable(false);
                                        dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour() - 2, timeThue.getMinute(), 0);
                                        dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                                        String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                        String dateTimeTrastr = dateTimeTra.format(dateTimeFormatCheck);
                                        ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                                        ArrayList<PhongDTO> listSearch = search(listP);
                                        renderCell(listSearch);
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
                                            rdNgay.setEnabled(false);
                                            rdGio.setEnabled(false);
                                            rdKhac.setEnabled(false);
                                            dateThue.setEnabled(false);
                                            dateTra.setEnabled(false);
                                            timeThue.setEnable(false);
                                            timeTra.setEnable(false);
                                            dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour() - 2, timeThue.getMinute(), 0);
                                            dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), timeTra.getHour(), timeTra.getMinute(), 0);
                                            String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                            String dateTimeTrastr = dateTimeTra.format(dateTimeFormatCheck);
                                            ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                                            ArrayList<PhongDTO> listSearch = search(listP);
                                            renderCell(listSearch);
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
                                rdNgay.setEnabled(false);
                                rdGio.setEnabled(false);
                                rdKhac.setEnabled(false);
                                dateThue.setEnabled(false);
                                dateTra.setEnabled(false);
                                timeThue.setEnable(false);
                                timeTra.setEnable(false);
                                dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), timeThue.getHour() - 2, timeThue.getMinute(), 0);
                                String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, "", false);
                                ArrayList<PhongDTO> listSearch = search(listP);
                                renderCell(listSearch);
                            } else {
                                new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                            }
                        }
                    }
                } else {
                    new ThongBaoDialog("Vui lòng chọn loại hình thuê", 1);
                }
            }
        });
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

        dateThue.setDateFormatString("dd-MM-yyyy");
        dateTra.setDateFormatString("dd-MM-yyyy");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pnCenter = new JPanel();
//		pnCenter.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.setBackground(Color.decode("#FAFAFA"));
        ArrayList<PhongDTO> listP = PhongBUS.getListP();
        renderCell(listP);

        scrTTphong = new JScrollPane();
        scrTTphong.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        scrTTphong.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scrTTphong.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);/
        scrTTphong.setViewportView(pnCenter);
        scrTTphong.getVerticalScrollBar().setUnitIncrement(10);
//        scrTTphong.getHorizontalScrollBar().setUnitIncrement(10);
        scrTTphong.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.decode("#FFFFFF")));
        this.setBackground(Color.decode("#FAFAFA"));
        this.setLayout(new BorderLayout());
        this.add(pnTop, BorderLayout.NORTH);
        this.add(scrTTphong, BorderLayout.CENTER);
    }

    public void renderCell(ArrayList<PhongDTO> listP) {
        pnCenter.removeAll();
        pnCenter.revalidate();
        pnCenter.repaint();
        ListLbPhong.clear();
        ListpanelCenter.clear();
        for (int i = 0; i < listP.size(); i++) {
            ItemCellRoom itemCell = new ItemCellRoom(listP.get(i), receptionistGUI, SoDoPhongGUI.this);
            ListLbPhong.add(itemCell);
        }
        int countBtnInPanel = 0;
        JPanel pnBtn = new JPanel();
        pnBtn.setLayout(new GridLayout(1, 5, 10, 10));
        pnBtn.setBorder(new EmptyBorder(0, 0, 10, 0));
        pnBtn.setBackground(Color.decode("#FFFFFF"));
        for (int i = 0; i < ListLbPhong.size(); i++) {
            if (countBtnInPanel == 5) {
                ListpanelCenter.add(pnBtn);
                pnBtn = new JPanel();
                pnBtn.setBackground(Color.decode("#FFFFFF"));
                pnBtn.setLayout(new GridLayout(1, 5, 10, 10));
                pnBtn.setBorder(new EmptyBorder(0, 0, 10, 0));
                countBtnInPanel = 0;
            }
            pnBtn.add(ListLbPhong.get(i));
            countBtnInPanel++;
            if (i == ListLbPhong.size() - 1) {
                for (int y = countBtnInPanel; y < 5; y++) {
                    JPanel pnEmp = new JPanel();
                    pnEmp.setBackground(Color.decode("#FFFFFF"));
//                    pnEmp.setFocusPainted(false);
                    pnEmp.setEnabled(false);
//                    pnEmp.setBorderPainted(false);
                    pnBtn.add(pnEmp);
                }
                ListpanelCenter.add(pnBtn);
            }
        }
        for (JPanel pn : ListpanelCenter) {
            pnCenter.add(pn);
        }
        if (ListpanelCenter.size() < 3) {
            for (int i = ListpanelCenter.size(); i < 3; i++) {
                JPanel pn = new JPanel();
                pn.setBackground(Color.white);
                pnCenter.add(pn);
            }
        }
    }

    public void lightDark(int options) {
        if (options == 0) {
            setBackground(Color.decode("#FAFAFA"));
            pnCenter.setBackground(Color.decode("#FAFAFA"));
            cbGiaP.setBackground(Color.white);
            cbLoaiP.setBackground(Color.white);
            cbChiTietLoaiP.setBackground(Color.white);
            cbHTP.setBackground(Color.white);
            cbChiTietLoaiP.setBorder(matteBorderCB);
            cbHTP.setBorder(matteBorderCB);
            cbGiaP.setBorder(matteBorderCB);
            cbLoaiP.setBorder(matteBorderCB);
            pnGiaP.setBackground(Color.decode("#FAFAFA"));
            pnHTP.setBackground(Color.decode("#FAFAFA"));
            pnTopTopCenter.setBackground(Color.decode("#FAFAFA"));
            pnLoaiP.setBackground(Color.decode("#FAFAFA"));
            pnChiTietLoaiP.setBackground(Color.decode("#FAFAFA"));
            pnTitle.setBackground(Color.decode("#FAFAFA"));
            pnTopCenter.setBackground(Color.decode("#FAFAFA"));
            scrTTphong.setBackground(Color.decode("#FFFFFF"));
        }
    }

    public void setDefaulComboBox(JComboBox x, String list[]) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String y : list) {
            dcbm.addElement(y);
        }
        x.setModel(dcbm);
    }

    public ArrayList<PhongDTO> search(ArrayList<PhongDTO> listP) {
        ArrayList<PhongDTO> list = new ArrayList<>();
        for (PhongDTO x : listP) {
            list.add(x);
        }
        ArrayList<PhongDTO> listTmp = new ArrayList<>();
        if (cbLoaiP.getSelectedIndex() != 0) {
            for (PhongDTO x : list) {
                if (x.getLoaiP().equalsIgnoreCase(cbLoaiP.getSelectedItem().toString())) {
                    listTmp.add(x);
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }

        if (cbChiTietLoaiP.getSelectedIndex() != 0) {
            for (PhongDTO x : list) {
                if (x.getChiTietLoaiP().equalsIgnoreCase(cbChiTietLoaiP.getSelectedItem().toString())) {
                    listTmp.add(x);
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }

        if (cbHTP.getSelectedIndex() != 0) {
            for (PhongDTO x : list) {
                if (x.getHienTrang() == cbChiTietLoaiP.getSelectedIndex() - 1) {
                    listTmp.add(x);
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }
        if (cbGiaP.getSelectedIndex() != 0) {
            if (cbGiaP.getSelectedIndex() == 1) {
                for (PhongDTO x : list) {
                    if (x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(1).toString().split("Dưới ")[1])) {
                        listTmp.add(x);
                    }
                }
            } else if (cbGiaP.getSelectedIndex() == 5) {
                for (PhongDTO x : list) {
                    if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(5).toString().split("Trên ")[1])) {
                        listTmp.add(x);
                    }
                }
            } else {
                for (PhongDTO x : list) {
                    if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                            && x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                        listTmp.add(x);
                    }
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }
        return list;
    }

    public ArrayList<PhongDTO> search() {
        ArrayList<PhongDTO> list = new ArrayList<>();
        if (rdNgay.isEnabled()) {
            list = PhongBUS.getListP();
            ArrayList<PhongDTO> listTmp = new ArrayList<>();
            if (cbLoaiP.getSelectedIndex() != 0) {
                for (PhongDTO x : list) {
                    if (x.getLoaiP().equalsIgnoreCase(cbLoaiP.getSelectedItem().toString())) {
                        listTmp.add(x);
                    }
                }
                list.clear();
                for (PhongDTO x : listTmp) {
                    list.add(x);
                }
                listTmp.clear();
            }

            if (cbChiTietLoaiP.getSelectedIndex() != 0) {
                for (PhongDTO x : list) {
                    if (x.getChiTietLoaiP().equalsIgnoreCase(cbChiTietLoaiP.getSelectedItem().toString())) {
                        listTmp.add(x);
                    }
                }
                list.clear();
                for (PhongDTO x : listTmp) {
                    list.add(x);
                }
                listTmp.clear();
            }

            if (cbHTP.getSelectedIndex() != 0) {
                for (PhongDTO x : list) {
                    if (x.getHienTrang() == cbChiTietLoaiP.getSelectedIndex() - 1) {
                        listTmp.add(x);
                    }
                }
                list.clear();
                for (PhongDTO x : listTmp) {
                    list.add(x);
                }
                listTmp.clear();
            }
            if (cbGiaP.getSelectedIndex() != 0) {
                if (cbGiaP.getSelectedIndex() == 1) {
                    for (PhongDTO x : list) {
                        if (x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(1).toString().split("Dưới ")[1])) {
                            listTmp.add(x);
                        }
                    }
                } else if (cbGiaP.getSelectedIndex() == 5) {
                    for (PhongDTO x : list) {
                        if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(5).toString().split("Trên ")[1])) {
                            listTmp.add(x);
                        }
                    }
                } else {
                    for (PhongDTO x : list) {
                        if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                                && x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                            listTmp.add(x);
                        }
                    }
                }
                list.clear();
                for (PhongDTO x : listTmp) {
                    list.add(x);
                }
                listTmp.clear();
            }
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (rdKhac.isSelected()) {
                String dateTimeThuestr = sdf.format(dateThue.getDate()) + " " + timeThue.getHour() + ":" + timeThue.getMinute() + ":00";
                ArrayList< PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, "", false);
                list = search(listP);
            } else {
                String dateTimeThuestr = sdf.format(dateThue.getDate()) + " " + timeThue.getHour() + ":" + timeThue.getMinute() + ":00";
                String dateTimeTrastr = sdf.format(dateTra.getDate()) + " " + timeTra.getHour() + ":" + timeTra.getMinute() + ":00";
                ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, dateTimeTrastr, true);
                list = search(listP);
            }
        }
        return list;
    }
}
