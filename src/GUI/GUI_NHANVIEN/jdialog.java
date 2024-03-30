package GUI.GUI_NHANVIEN;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import com.itextpdf.text.pdf.security.CertificateInfo;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author SYN
 */
public class jdialog extends javax.swing.JDialog {
    public void create() {
        initComponents();
        setGUI();
        setAction();
        setModal(true);
    }

    public jdialog(String[] temp) {
        create();
        jLabelThemNV.setText("Cập nhật thông tin nhân viên");
        //set cac thuoc tinh 
        jTextFieldMaNV.setText(temp[0]);
        jTextFieldTenNV.setText(temp[1]);
        if (temp[2].equals("Nam")) {
            jRadioNam.setSelected(true);
        } else {
            jRadioNu.setSelected(true);
        }
        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            jDateNgaySinh.setDate(df.parse(temp[3]));
            jDateNgayLam.setDate(df.parse(temp[4]));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        jComboBoxChucVu.setSelectedItem(temp[5]);
        jTextFieldNgayPhep.setText(temp[6]);
        jTextFieldLuongNgay.setText(temp[7]);
        jTextFieldEmail.setText(temp[8]);
        //bo panel them
        remove(jPanelThem);
    }

    public jdialog() {
        create();
        createDate();
        autoCreateMaNV();
        jPanelUpdate.setVisible(false);
    }

    public jdialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        create();
    }

    public static String regexEmail = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,63}$";
    public static String regexTenNV = "^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ\\s]{1,50}$";

    public static boolean patternEmail(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean patternTenNV(String tenNV, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(tenNV)
                .matches();
    }

    private void setGUI() {
        //set backGound jtextfield maNV editable
        jTextFieldMaNV.setBackground(Color.decode("#F8f8f8"));

        Color backGroundContain = new Color(255, 255, 255);
        //set backGround DiaLog
        getContentPane().setBackground(backGroundContain);
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof JPanel) {
                //backGround for Panel
                c.setBackground(backGroundContain);
                for (Component com : ((JPanel) c).getComponents()) {
                    if (com instanceof JComboBox) {
                        //set popUp for comboBox
                        com.setBackground(backGroundContain);
                        ((JComboBox) com).setUI(new BasicComboBoxUI() {
                            @Override
                            protected ComboPopup createPopup() {
                                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                                basicComboPopup.setBorder(lineCBpop);
                                return basicComboPopup;
                            }
                        });
                    }
                    if (com instanceof JTextField) {
                        //boder for jText
                        ((JTextField) com).setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
                    }
                    if (com instanceof JPanel) {
                        com.setBackground(backGroundContain);
                        for (Component compo : ((JPanel) com).getComponents()) {
                            if (compo instanceof JRadioButton) {
                                compo.setBackground(backGroundContain);
                                ((JRadioButton) compo).setFocusPainted(false);
                                buttonGroupGioiTinh.add((AbstractButton) compo);
                            }
                        }
                    }
                    //set Them Xoa Sua
                    if (com instanceof JButton) {
//                        ImageIcon iconImport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
//                        ((JButton) com).setIcon(iconImport);
                        ((JButton) com).setFocusPainted(false);
                        ((JButton) com).setFont(sgUI13b);
                        ((JButton) com).setBorderPainted(false);
                        ((JButton) com).setBackground(Color.decode("#ebf2fc"));
                    }
                    //Jdate
                    if (com instanceof JDateChooser) {
                        ((JDateChooser) com).setCalendar(new JDateChooser().getCalendar());

                        ((JDateChooser) com).getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
                        ((JDateChooser) com).getCalendarButton().setBackground(Color.decode("#EEEEEE"));
                        ((JDateChooser) com).getCalendarButton().setFocusPainted(false);
                        ((JDateChooser) com).getCalendarButton().setContentAreaFilled(false);
                        ((JDateChooser) com).setFont(sgUI13b);

                        jTextFieldDateEditor = (JTextFieldDateEditor) ((JDateChooser) com).getDateEditor();
                        jTextFieldDateEditor.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
                    }
                }
            }
        }
        //set LabelThongBao=null
        jLabelThongBao.setText("");
        jLabelThongBao.setVisible(false);
    }

    public void createDate() {
        jDateNgayLam.setMinSelectableDate(new Date());
        //ngayVaoLam nho nhat la today
        Date today = new Date();
        if (jDateNgayLam.getDate() == null) {
            jDateNgayLam.setDate(today);
        }
        //tuoi phai lon hon 18 moi được vào làm
        String paternDate = "ddMMyyyy";
        DateFormat df = new SimpleDateFormat(paternDate);
        String chkNgaySinh = df.format(today);
        //lay nam nay tru di 18 va gop chuoi lai
        String yearToday = chkNgaySinh.toString().substring(4, 8);
        int year = Integer.parseInt(yearToday);
        year -= 18;
        //18 nam truoc
        chkNgaySinh = chkNgaySinh.substring(0, 4) + String.valueOf(year);
        try {
            today = df.parse(chkNgaySinh);
            jDateNgaySinh.setMaxSelectableDate(today);
            if (jDateNgaySinh.getDate() == null) {
                jDateNgaySinh.setDate(today);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        jDateNgaySinh.setMaxSelectableDate(today);
    }

    public void autoCreateMaNV() {
        boolean[] attri = new boolean[11];
        attri[0] = true;
        String values[] = new String[11];
        values[0] = "NV";
        //string for top and order
        String top, order;
        top = "top 1 ";
        order = " order by SUBSTRING(maNV,10,13) desc ";
        ArrayList<NhanVienDTO> listNV = new ArrayList<>();
        listNV = NhanVienBUS.searchNV(attri, values, top, order);
        //lay gia tri cua nhan vien last
        //maNV=NV0ddmmyyXXXX
        //lay gioi tinh
        String gioiTinh = "0";
        if (jRadioNu.isSelected()) {
            gioiTinh = "1";
        }
        //lay ngay lam
        String ngayLam;
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        ngayLam = df.format(jDateNgayLam.getDate());
        ngayLam = ngayLam.substring(0, 4) + ngayLam.substring(6);
        if (listNV.isEmpty()) {
            jTextFieldMaNV.setText("NV" + gioiTinh + ngayLam + "0001");
            return;
        }
        //lay stt cua nhan vien tang 1
        String stt = listNV.get(0).getMaNV().substring(9, 13);
        int newIndex = Integer.parseInt(stt);
        newIndex += 1;
        stt = "";
        stt += String.valueOf(newIndex);
        while (stt.length() < 4) {
            stt = "0" + stt;
        }
        //gan gia tri cho ma nv
        jTextFieldMaNV.setText("NV" + gioiTinh + ngayLam + stt);
    }

    public void setAction() {
        jButtonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionAdd();
            }
        });
        jButtonXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionXoa();
            }
        });
        jButtonSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSua();
            }
        });
    }

    private boolean validateField() {
        //kiem tra tenNV
        if (!patternTenNV(jTextFieldTenNV.getText(), regexTenNV)) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("TenNV không hợp lệ, chỉ gồm chữ và khoảng trắng");
            return false;
        }
        //kiem tra ngay
        if (jDateNgaySinh.getDate() == null) {
            jDateNgaySinh.setDate(jDateNgaySinh.getMaxSelectableDate());
            return false;
        }
        if (jDateNgayLam.getDate() == null) {
            jDateNgayLam.setDate(jDateNgayLam.getMinSelectableDate());
            return false;
        }
        if (jDateNgaySinh.getDate().after(jDateNgaySinh.getMaxSelectableDate())) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("Ngày sinh không hợp lệ, phải lớn hơn 18 tuổi");
            jDateNgaySinh.setDate(jDateNgaySinh.getMaxSelectableDate());
            return false;
        }
        if (jDateNgayLam.getMinSelectableDate().after(jDateNgayLam.getDate())) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("Ngày làm không hợp lệ, chọn ngày lớn hơn hoặc bằng hiện tại");
            jDateNgayLam.setDate(jDateNgayLam.getMinSelectableDate());
            return false;
        }
        //keim tra soNgayPhep va Luong
        try {
            int temp;
            temp = Integer.parseInt(jTextFieldLuongNgay.getText());
            if (jTextFieldLuongNgay.getText().equals("")) {
                jLabelThongBao.setVisible(true);
                jLabelThongBao.setText("Hãy nhâp lương 1 ngày");
                return false;
            }
            temp = Integer.parseInt(jTextFieldNgayPhep.getText());
            if (temp > 30) {
                jLabelThongBao.setVisible(true);
                jLabelThongBao.setText("Hãy nhâp số ngày phép < 30");
                return false;
            }
        } catch (NumberFormatException ex) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("Hãy nhâp số ngày phép và Lương 1 ngày là số nguyên");
            return false;
        }
        //kiem tra Emal
        if (jTextFieldEmail.getText().equals("")) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("Hãy nhập Email");
            return false;
        } else if (!patternEmail(jTextFieldEmail.getText(), regexEmail)) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("Hãy nhập Email hợp lệ");
            return false;
        }
        //kiem tra Luong
        if (jTextFieldLuongNgay.equals("")) {
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("Hãy nhập lương 1 ngày");
            return false;
        }
        return true;
    }

    private NhanVienDTO getInfoField() {
        NhanVienDTO x = new NhanVienDTO();
        x.setMaNV(jTextFieldMaNV.getText());
        x.setTenNV(jTextFieldTenNV.getText());
        String gioiTinh = "Nam";
        if (jRadioNu.isSelected()) {
            gioiTinh = "Nữ";
        }
        x.setGioiTinh(gioiTinh);
        String patternDate = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(patternDate);
        x.setNgaySinh(df.format(jDateNgaySinh.getDate()));
        x.setNgayVaoLam(df.format(jDateNgayLam.getDate()));
        x.setChucVu(jComboBoxChucVu.getItemAt(jComboBoxChucVu.getSelectedIndex()));
        x.setSoNgayPhep(Integer.parseInt(jTextFieldNgayPhep.getText()));
        x.setLuong1Ngay(Integer.parseInt(jTextFieldLuongNgay.getText()));
        x.setEmail(jTextFieldEmail.getText());
        x.setXuLy(0);
        return x;
    }

    private void actionAdd() {
        if (validateField() == false) {
            return;
        }
        //set lai maNV
        String patternDate = "ddMMyyyy";
        DateFormat df = new SimpleDateFormat(patternDate);
        String reDate = df.format(jDateNgayLam.getDate());
        reDate = reDate.substring(0, 4) + reDate.substring(6);
        jTextFieldMaNV.setText(jTextFieldMaNV.getText().substring(0, 3) + reDate + jTextFieldMaNV.getText().substring(9));
        jLabelThongBao.setVisible(false);
        //create maNV
        autoCreateMaNV();
        //them nhan vien
        NhanVienDTO temp = getInfoField();
        JOptionPane.showMessageDialog(rootPane, NhanVienBUS.insertNV(temp));
    }

    private void actionXoa() {
        JOptionPane.showMessageDialog(rootPane, NhanVienBUS.deletNV(jTextFieldMaNV.getText()));
        this.dispose();
    }

    private void actionSua() {
        validateField();
        NhanVienDTO temp = getInfoField();
        JOptionPane.showMessageDialog(rootPane, NhanVienBUS.updateNV(temp));
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        jLabelTTCT = new javax.swing.JLabel();
        jLabelThemNV = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelMaNV = new javax.swing.JLabel();
        jTextFieldMaNV = new javax.swing.JTextField();
        jLabelTenNV = new javax.swing.JLabel();
        jTextFieldTenNV = new javax.swing.JTextField();
        jLabelGioiTinh = new javax.swing.JLabel();
        jLabelChucVu = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelNgaySinh = new javax.swing.JLabel();
        jLabelNgayLam = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jDateNgayLam = new com.toedter.calendar.JDateChooser();
        jComboBoxChucVu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jRadioNam = new javax.swing.JRadioButton();
        jRadioNu = new javax.swing.JRadioButton();
        jLabelNgayPhep = new javax.swing.JLabel();
        jTextFieldNgayPhep = new javax.swing.JTextField();
        jLabelLuongNgay = new javax.swing.JLabel();
        jTextFieldLuongNgay = new javax.swing.JTextField();
        jPanelThem = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jPanelUpdate = new javax.swing.JPanel();
        jButtonXoa = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jLabelThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết nhân viên");
        setIconImage(null);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelTTCT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelTTCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTCT.setText("THÔNG TIN CHI TIẾT NHÂN VIÊN");
        jLabelTTCT.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        getContentPane().add(jLabelTTCT, gridBagConstraints);

        jLabelThemNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelThemNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThemNV.setText("Thêm Nhân Viên");
        jLabelThemNV.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 14, 4);
        getContentPane().add(jLabelThemNV, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMaNV.setText("Mã nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelMaNV, gridBagConstraints);

        jTextFieldMaNV.setEditable(false);
        jTextFieldMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMaNV.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldMaNV, gridBagConstraints);

        jLabelTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTenNV.setText("Tên nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelTenNV, gridBagConstraints);

        jTextFieldTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldTenNV.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldTenNV, gridBagConstraints);

        jLabelGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGioiTinh.setText("Giới tính");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelGioiTinh, gridBagConstraints);

        jLabelChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelChucVu.setText("Chức vụ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelChucVu, gridBagConstraints);

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmail.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelEmail, gridBagConstraints);

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldEmail, gridBagConstraints);

        jLabelNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNgaySinh.setText("Ngày sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelNgaySinh, gridBagConstraints);

        jLabelNgayLam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNgayLam.setText("Ngày vào làm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelNgayLam, gridBagConstraints);

        jDateNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateNgaySinh.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jDateNgaySinh, gridBagConstraints);

        jDateNgayLam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jDateNgayLam.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jDateNgayLam, gridBagConstraints);

        jComboBoxChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Quản lý", "Lễ tân", "Kế toán"}));
        jComboBoxChucVu.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jComboBoxChucVu, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jRadioNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioNam.setSelected(true);
        jRadioNam.setText("Nam");
        jRadioNam.setName("GioiTinh"); // NOI18N
        jRadioNam.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jRadioNam, gridBagConstraints);

        jRadioNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioNu.setText("Nữ");
        jRadioNu.setName("GioiTinh"); // NOI18N
        jRadioNu.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jRadioNu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jPanel3, gridBagConstraints);

        jLabelNgayPhep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNgayPhep.setText("Số ngày phép");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabelNgayPhep, gridBagConstraints);

        jTextFieldNgayPhep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNgayPhep.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldNgayPhep, gridBagConstraints);

        jLabelLuongNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLuongNgay.setText("Lương 1 ngày");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelLuongNgay, gridBagConstraints);

        jTextFieldLuongNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldLuongNgay.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldLuongNgay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanelThem.setLayout(new java.awt.GridBagLayout());

        jButtonThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelThem.add(jButtonThem, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        getContentPane().add(jPanelThem, gridBagConstraints);

        jPanelUpdate.setLayout(new java.awt.GridBagLayout());

        jButtonXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelUpdate.add(jButtonXoa, gridBagConstraints);

        jButtonSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSua.setText("Sửa");
        jButtonSua.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelUpdate.add(jButtonSua, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanelUpdate, gridBagConstraints);

        jLabelThongBao.setForeground(new java.awt.Color(255, 51, 0));
        jLabelThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThongBao.setText("label để thông báo lỗi");
        jLabelThongBao.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jLabelThongBao, gridBagConstraints);

        getAccessibleContext().setAccessibleParent(jButtonXoa);
        pack();
    }
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboBoxChucVu;
    private com.toedter.calendar.JDateChooser jDateNgayLam;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabelChucVu;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGioiTinh;
    private javax.swing.JLabel jLabelLuongNgay;
    private javax.swing.JLabel jLabelMaNV;
    private javax.swing.JLabel jLabelNgayLam;
    private javax.swing.JLabel jLabelNgayPhep;
    private javax.swing.JLabel jLabelNgaySinh;
    private javax.swing.JLabel jLabelTTCT;
    private javax.swing.JLabel jLabelTenNV;
    private javax.swing.JLabel jLabelThemNV;
    private javax.swing.JLabel jLabelThongBao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelThem;
    private javax.swing.JPanel jPanelUpdate;
    private javax.swing.JRadioButton jRadioNam;
    private javax.swing.JRadioButton jRadioNu;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLuongNgay;
    private javax.swing.JTextField jTextFieldMaNV;
    private javax.swing.JTextField jTextFieldNgayPhep;
    private javax.swing.JTextField jTextFieldTenNV;
    // End of variables declaration                

    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private LineBorder lineCBpop = new LineBorder(Color.white);
    private LineBorder lineDate = new LineBorder(Color.red, 1);
    private JTextFieldDateEditor jTextFieldDateEditor;
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    // End of variables declaration                   
}
