package GUI.GUI_NHANVIEN;

import GUI.mainGUI;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;

public class InformationForm extends JDialog {
    
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
    
    JPanel pnCenter = new JPanel();
    JPanel pnTop = new JPanel();
    JLabel lbTop = new JLabel("Thông tin cá nhân");
    JLabel lbDetail = new JLabel("Hãy điền thông tin nếu muốn sửa");
    JPanel pnMaNV = new JPanel();
    JLabel lbMaNV = new JLabel("Mã nhân viên");
    JTextField txtMaNV = new JTextField();
    
    JPanel pnTenNV = new JPanel();
    JLabel lbTenNV = new JLabel("Tên nhân viên");
    JTextField txtTenNV = new JTextField();
    
    JPanel pnGioiTinh = new JPanel();
    JLabel lbGioiTinh = new JLabel("Giới tính");
    JPanel pnGioiTinhRadio = new JPanel();
    JRadioButton ckbNam = new JRadioButton("Nam");
    JRadioButton ckbNu = new JRadioButton("Nữ");
    ButtonGroup bgGT = new ButtonGroup();
    
    JPanel pnNgaySinh = new JPanel();
    JLabel lbNgaySinh = new JLabel("Ngày sinh");
    JDateChooser dateNgaySinh = new JDateChooser();
    
    JPanel pnEmail = new JPanel();
    JLabel lbEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField();
    
    JPanel pnChucVu = new JPanel();
    JLabel lbChucVu = new JLabel("Chức vụ");
    JTextField txtChucVu = new JTextField();
    
    JPanel pnNgayVaoLam = new JPanel();
    JLabel lbNgayVaoLam = new JLabel("Ngày vào làm");
    JTextField txtNgayVaoLam = new JTextField();
    
    JPanel pnSoNgayPhep = new JPanel();
    JLabel lbSoNgayPhep = new JLabel("Số ngày phép");
    JTextField txtSoNgayPhep = new JTextField();
    
    JPanel pnLuong1Ngay = new JPanel();
    JLabel lbLuong1Ngay = new JLabel("Lương 1 ngày");
    JTextField txtLuong1Ngay = new JTextField();
    
    JPanel pnButton = new JPanel();
    JButton btnEdit = new JButton("Sửa thông tin");
    
    JTextFieldDateEditor editorNgaySinh = (JTextFieldDateEditor) dateNgaySinh.getDateEditor();
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EEEEEE"));
    
    public InformationForm() throws ParseException {
        initComponents();
    }
    
    public void initComponents() throws ParseException {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        setResizable(false);
        setSize(new Dimension(600, 450));
        setTitle("Thông tin cá nhân");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setModal(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(pnCenter, BorderLayout.CENTER);
        add(pnTop, BorderLayout.NORTH);
        pnTop.setLayout(new GridLayout(2, 1));
        lbTop.setBorder(new EmptyBorder(0, 5, 2, 5));
        lbDetail.setBorder(new EmptyBorder(0, 5, 0, 5));
        pnTop.add(lbTop);
        pnTop.add(lbDetail);
        lbTop.setFont(sgUI15b);
        lbDetail.setFont(tNR13);
        pnCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnCenter.setLayout(new GridLayout(5, 2, 5, 5));
        pnCenter.add(pnMaNV);
        pnCenter.add(pnTenNV);
        pnCenter.add(pnGioiTinh);
        pnCenter.add(pnNgaySinh);
        pnCenter.add(pnEmail);
        pnCenter.add(pnChucVu);
        pnCenter.add(pnNgayVaoLam);
        pnCenter.add(pnSoNgayPhep);
        pnCenter.add(pnLuong1Ngay);
        pnCenter.add(pnButton);
        
        pnTop.setBorder(new EmptyBorder(5, 5, 0, 5));
        
        ckbNam.setBackground(Color.decode("#FDFDFD"));
        ckbNu.setBackground(Color.decode("#FDFDFD"));
        ckbNam.setFocusPainted(false);
        ckbNu.setFocusPainted(false);
        lbTop.setOpaque(true);
        lbDetail.setOpaque(true);
        setBackground(Color.decode("#FDFDFD"));
        pnTop.setBackground(Color.decode("#FDFDFD"));
        lbTop.setBackground(Color.decode("#E0E0E0"));
        lbDetail.setBackground(Color.decode("#E0E0E0"));
        pnCenter.setBackground(Color.decode("#FDFDFD"));
        pnMaNV.setBackground(Color.decode("#FDFDFD"));
        pnTenNV.setBackground(Color.decode("#FDFDFD"));
        pnGioiTinh.setBackground(Color.decode("#FDFDFD"));
        pnNgaySinh.setBackground(Color.decode("#FDFDFD"));
        pnEmail.setBackground(Color.decode("#FDFDFD"));
        pnChucVu.setBackground(Color.decode("#FDFDFD"));
        pnNgayVaoLam.setBackground(Color.decode("#FDFDFD"));
        pnSoNgayPhep.setBackground(Color.decode("#FDFDFD"));
        pnLuong1Ngay.setBackground(Color.decode("#FDFDFD"));
        pnButton.setBackground(Color.decode("#FDFDFD"));
        pnGioiTinhRadio.setBackground(Color.decode("#FDFDFD"));
        
        pnMaNV.setLayout(new GridLayout(2, 1));
        pnMaNV.add(lbMaNV);
        pnMaNV.add(txtMaNV);
        
        pnTenNV.setLayout(new GridLayout(2, 1));
        pnTenNV.add(lbTenNV);
        pnTenNV.add(txtTenNV);
        
        pnLuong1Ngay.setLayout(new GridLayout(2, 1));
        pnLuong1Ngay.add(lbLuong1Ngay);
        pnLuong1Ngay.add(txtLuong1Ngay);
        
        pnEmail.setLayout(new GridLayout(2, 1));
        pnEmail.add(lbEmail);
        pnEmail.add(txtEmail);
        
        pnSoNgayPhep.setLayout(new GridLayout(2, 1));
        pnSoNgayPhep.add(lbSoNgayPhep);
        pnSoNgayPhep.add(txtSoNgayPhep);
        
        pnNgayVaoLam.setLayout(new GridLayout(2, 1));
        pnNgayVaoLam.add(lbNgayVaoLam);
        pnNgayVaoLam.add(txtNgayVaoLam);
        
        pnNgaySinh.setLayout(new GridLayout(2, 1));
        pnNgaySinh.add(lbNgaySinh);
        pnNgaySinh.add(dateNgaySinh);
        
        dateNgaySinh.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        dateNgaySinh.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
        dateNgaySinh.getCalendarButton().setFocusPainted(false);
        dateNgaySinh.getCalendarButton().setContentAreaFilled(false);
        
        editorNgaySinh.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        
        pnChucVu.setLayout(new GridLayout(2, 1));
        pnChucVu.add(lbChucVu);
        pnChucVu.add(txtChucVu);
        
        pnGioiTinh.setLayout(new GridLayout(2, 1));
        pnGioiTinh.add(lbGioiTinh);
        pnGioiTinh.add(pnGioiTinhRadio);
        pnGioiTinhRadio.setLayout(new GridLayout(1, 2));
        pnGioiTinhRadio.add(ckbNam);
        pnGioiTinhRadio.add(ckbNu);
        bgGT.add(ckbNu);
        bgGT.add(ckbNam);
        
        txtMaNV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtTenNV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtChucVu.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtLuong1Ngay.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtNgayVaoLam.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        txtSoNgayPhep.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
        
        txtMaNV.setBackground(Color.decode("#F8f8f8"));
        txtChucVu.setBackground(Color.decode("#F8f8f8"));
        txtLuong1Ngay.setBackground(Color.decode("#F8f8f8"));
        txtNgayVaoLam.setBackground(Color.decode("#F8f8f8"));
        txtSoNgayPhep.setBackground(Color.decode("#F8f8f8"));
        
        txtMaNV.setEditable(false);
        txtChucVu.setEditable(false);
        txtLuong1Ngay.setEditable(false);
        txtNgayVaoLam.setEditable(false);
        txtSoNgayPhep.setEditable(false);
        editorNgaySinh.setBackground(Color.decode("#FFFFFF"));
        
        lbChucVu.setFont(sgUI13b);
        lbEmail.setFont(sgUI13b);
        lbGioiTinh.setFont(sgUI13b);
        lbLuong1Ngay.setFont(sgUI13b);
        lbMaNV.setFont(sgUI13b);
        lbNgaySinh.setFont(sgUI13b);
        lbNgayVaoLam.setFont(sgUI13b);
        lbSoNgayPhep.setFont(sgUI13b);
        lbTenNV.setFont(sgUI13b);
        
        txtMaNV.setFont(sgUI13);
        txtChucVu.setFont(sgUI13);
        txtEmail.setFont(sgUI13);
        txtLuong1Ngay.setFont(sgUI13);
        txtNgayVaoLam.setFont(sgUI13);
        txtSoNgayPhep.setFont(sgUI13);
        txtTenNV.setFont(sgUI13);
        
        txtMaNV.setText(mainGUI.nv.getMaNV());
        txtTenNV.setText(mainGUI.nv.getTenNV());
        txtChucVu.setText(mainGUI.nv.getChucVu());
        txtEmail.setText(mainGUI.nv.getEmail());
        txtLuong1Ngay.setText(dcf.format(mainGUI.nv.getLuong1Ngay()) + "");
        editorNgaySinh.setEditable(false);
        txtNgayVaoLam.setText(mainGUI.nv.getNgayVaoLam());
        txtSoNgayPhep.setText(mainGUI.nv.getSoNgayPhep() + "");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(mainGUI.nv.getNgaySinh());
        dateNgaySinh.setDate(date);
        dateNgaySinh.setDateFormatString("dd-MM-yyyy");
        
        if (mainGUI.nv.getGioiTinh().equals("Nam")) {
            ckbNam.setSelected(true);
            ckbNam.setFont(sgUI13b);
        } else {
            ckbNu.setSelected(true);
            ckbNu.setFont(sgUI13);
        }
        setVisible(true);
    }
}
