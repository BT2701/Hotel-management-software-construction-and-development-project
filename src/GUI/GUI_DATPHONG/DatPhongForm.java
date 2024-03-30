package GUI.GUI_DATPHONG;

//import BUS.DichVuBUS;
//import BUS.KhachHangBUS;
//import BUS.PhongBUS;
//import BUS.SuDungDichVuBUS;
//import BUS.ThuePhongBUS;
//import BUS.TienIchBUS;
//import DTO.DichVuDTO;
//import DTO.KhachHangDTO;
//import DTO.PhongDTO;
//import DTO.SuDungDichVuDTO;
//import DTO.ThuePhongDTO;
//import DTO.TienIchDTO;
//import GUI.LapHoaDonGUI;
//import GUI.TimeChoose;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;
//import com.itextpdf.text.Anchor;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.FontSelector;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import javax.swing.text.Element;

public class DatPhongForm extends JFrame {

    JLabel lbTitle = new JLabel("CHI TIẾT ĐẶT PHÒNG");
    JPanel pnContent = new JPanel();
    JPanel pnContentLeft = new JPanel();
    JPanel pnCTT = new JPanel();
    JPanel pnKH = new JPanel();
    JLabel lbTopContent = new JLabel("Thông tin chi tiết thuê       ");
    JLabel lbTopKH = new JLabel("Thông tin khách hàng");
    JPanel pnKHContent = new JPanel();
    JPanel pnMaKH = new JPanel();
    JPanel pnTenKH = new JPanel();
    JPanel pnCMNDKH = new JPanel();
    JPanel pnSDTKH = new JPanel();
    JPanel pnGTKH = new JPanel();
    JPanel pnFunKH = new JPanel();
    JLabel lbMaKH = new JLabel("Mã khách hàng:");
    JLabel lbTenKH = new JLabel("Tên khách hàng:");
    JLabel lbCMNDKH = new JLabel("Chứng minh nhân dân:");
    JLabel lbSDTKH = new JLabel("Số điện thoại:");
    JLabel lbGTKH = new JLabel("Giới tính khách hàng:");
    JLabel lbFunction = new JLabel("Chức năng");

    JTextField txtMaKH = new JTextField();
    JTextField txtTenKH = new JTextField();
    JTextField txtCMNDKH = new JTextField();
    JTextField txtSDTKH = new JTextField();
    JPanel txtGTKH = new JPanel();
    JPanel pnFunction = new JPanel();
    JPanel pnBtn = new JPanel();
    JButton btnUpdate = new JButton("Sửa");
    JButton btnSave = new JButton("Lưu");
    JPanel pnTopCenter = new JPanel();
    JPanel pnMaCTT = new JPanel();
    JLabel lbMaCTT = new JLabel("Mã chi tiết thuê:");
    JTextField txtMaCTT = new JTextField();

    JPanel pnMaNV = new JPanel();
    JLabel lbMaNV = new JLabel("Mã nhân viên:");
    JTextField txtMaNV = new JTextField();

    JPanel pnTenNV = new JPanel();
    JLabel lbTenNV = new JLabel("Tên nhân viên:");
    JTextField txtTenNV = new JTextField();

    JPanel pnTienCoc = new JPanel();
    JLabel lbTienCoc = new JLabel("Tiền cọc");
    JTextField txtTienCoc = new JTextField();

    JPanel pnTinhTrangXuLy = new JPanel();
    JLabel lbTinhTrangXuLy = new JLabel("Tình trạng xử lý");
    JTextField txtTinhTrangXuLy = new JTextField();

    JRadioButton rbNam = new JRadioButton("Nam");
    JRadioButton rbNu = new JRadioButton("Nữ");
    ButtonGroup bgGT = new ButtonGroup();
    JPanel pnCenter = new JPanel();
    JPanel pnCenterTop = new JPanel();
    JPanel pnCenterTopLeft = new JPanel();
    JButton btnPhong = new JButton("Chi tiết");
    JButton btnDichVu = new JButton("Dịch vụ");
    JButton btnDatPhong = new JButton("Đặt phòng");
    JPanel pnCenterContent = new JPanel();

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);

//    public DatPhongForm(String maCTT, String maKH, String tenKH, String maNV, String tenNV, String tien, String tinhtrangxuly) {
//        initComponents(maCTT, maKH, tenKH, maNV, tenNV, tien, tinhtrangxuly);
//    }
    
    public DatPhongForm() {
        initComponents();
    }

    public void initComponents() {

        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));

        setLayout(new BorderLayout(5, 5));
        add(lbTitle, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);

        lbTitle.setFont(sgUI18b);
        lbTitle.setBackground(Color.white);
        lbTitle.setOpaque(true);
        lbTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbTitle.setHorizontalAlignment(JLabel.CENTER);

        pnContent.setLayout(new BorderLayout(5, 5));

        pnContent.add(pnContentLeft, BorderLayout.WEST);
        pnContent.add(pnCenter, BorderLayout.CENTER);

        pnCenter.setLayout(new BorderLayout());
        pnCenter.setBackground(Color.white);
        pnCenter.add(pnCenterTop, BorderLayout.NORTH);
        pnCenter.add(pnCenterContent, BorderLayout.CENTER);

        pnCenterTop.setLayout(new BorderLayout());
        pnCenterTop.setBackground(Color.white);
        pnCenterTop.add(pnCenterTopLeft, BorderLayout.WEST);
        pnCenterTopLeft.setLayout(new GridLayout(1, 3));
        pnCenterTop.setBackground(Color.white);
        pnCenterTopLeft.setBackground(Color.white);
        pnCenterTopLeft.add(btnPhong);
        pnCenterTopLeft.add(btnDatPhong);
        pnCenterTopLeft.add(btnDichVu);

        btnDatPhong.setBackground(Color.white);
        btnDatPhong.setFocusPainted(false);
        btnPhong.setFocusPainted(false);
        btnPhong.setBackground(Color.white);
        btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FF6347")), new EmptyBorder(5, 10, 5, 10)));
        btnDichVu.setFocusPainted(false);
        btnDichVu.setBackground(Color.white);
        btnDichVu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
        btnDatPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));

        pnCenterTopLeft.setBackground(Color.white);
        pnCenterTopLeft.setBorder(new EmptyBorder(0, 10, 0, 0));

        pnContentLeft.setLayout(new GridLayout(2, 1, 0, 5));
        pnContentLeft.add(pnCTT);
        pnContentLeft.add(pnKH);

        bgGT.add(rbNam);
        bgGT.add(rbNu);

        pnCTT.setLayout(new BorderLayout());
        pnCTT.setBorder(new EmptyBorder(5, 5, 50, 5));
        pnCTT.setBackground(Color.white);
        pnCTT.add(lbTopContent, BorderLayout.NORTH);
        pnCTT.add(pnTopCenter, BorderLayout.CENTER);
        lbTopContent.setFont(sgUI15);
        lbTopContent.setBackground(Color.decode("#F0FFF0"));
        lbTopContent.setOpaque(true);
        lbTopContent.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));

        pnTopCenter.setLayout(new GridLayout(5, 1));
        pnTopCenter.add(pnMaCTT);
        pnTopCenter.add(pnMaNV);
        pnTopCenter.add(pnTenNV);
        pnTopCenter.add(pnTienCoc);
        pnTopCenter.add(pnTinhTrangXuLy);

        pnMaCTT.setLayout(new BorderLayout());
        pnMaCTT.setBackground(Color.white);
        pnMaCTT.add(lbMaCTT, BorderLayout.NORTH);
        pnMaCTT.add(txtMaCTT, BorderLayout.CENTER);
//        txtMaCTT.setText(maCTT);

        pnMaNV.setLayout(new BorderLayout());
        pnMaNV.setBackground(Color.white);
        pnMaNV.add(lbMaNV, BorderLayout.NORTH);
        pnMaNV.add(txtMaNV, BorderLayout.CENTER);
//        txtMaNV.setText(maNV);

        pnTenNV.setLayout(new BorderLayout());
        pnTenNV.setBackground(Color.white);
        pnTenNV.add(lbTenNV, BorderLayout.NORTH);
        pnTenNV.add(txtTenNV, BorderLayout.CENTER);
//        txtTenNV.setText(tenNV);

        pnTienCoc.setLayout(new BorderLayout());
        pnTienCoc.setBackground(Color.white);
        pnTienCoc.add(lbTienCoc, BorderLayout.NORTH);
        pnTienCoc.add(txtTienCoc, BorderLayout.CENTER);
//        txtTienCoc.setText(tien);

        pnTinhTrangXuLy.setLayout(new BorderLayout());
        pnTinhTrangXuLy.setBackground(Color.white);
        pnTinhTrangXuLy.add(lbTinhTrangXuLy, BorderLayout.NORTH);
        pnTinhTrangXuLy.add(txtTinhTrangXuLy, BorderLayout.CENTER);
//        txtTinhTrangXuLy.setText(tinhtrangxuly);

        pnKH.setLayout(new BorderLayout());

        pnKH.add(lbTopKH, BorderLayout.NORTH);
        pnKH.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnKH.setBackground(Color.white);
        lbTopKH.setFont(sgUI15);
        lbTopKH.setBackground(Color.decode("#F0FFF0"));
        lbTopKH.setOpaque(true);
        lbTopKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
        pnKH.add(pnKHContent, BorderLayout.CENTER);

        pnKHContent.setLayout(new GridLayout(6, 1));
        pnKHContent.setBackground(Color.white);
        pnKHContent.add(pnMaKH);
        pnKHContent.add(pnTenKH);
        pnKHContent.add(pnCMNDKH);
        pnKHContent.add(pnSDTKH);
        pnKHContent.add(pnGTKH);
        pnKHContent.add(pnFunKH);

        pnMaKH.setLayout(new BorderLayout());
        pnMaKH.setBackground(Color.white);
        pnMaKH.add(lbMaKH, BorderLayout.NORTH);
        pnMaKH.add(txtMaKH, BorderLayout.CENTER);

        pnTenKH.setLayout(new BorderLayout());
        pnTenKH.setBackground(Color.white);
        pnTenKH.add(lbTenKH, BorderLayout.NORTH);
        pnTenKH.add(txtTenKH, BorderLayout.CENTER);

        pnCMNDKH.setLayout(new BorderLayout());
        pnCMNDKH.setBackground(Color.white);
        pnCMNDKH.add(lbCMNDKH, BorderLayout.NORTH);
        pnCMNDKH.add(txtCMNDKH, BorderLayout.CENTER);

        pnSDTKH.setLayout(new BorderLayout());
        pnSDTKH.setBackground(Color.white);
        pnSDTKH.add(lbSDTKH, BorderLayout.NORTH);
        pnSDTKH.add(txtSDTKH, BorderLayout.CENTER);

        pnGTKH.setLayout(new BorderLayout());
        pnGTKH.setBackground(Color.white);
        pnGTKH.add(lbGTKH, BorderLayout.NORTH);
        pnGTKH.add(txtGTKH, BorderLayout.CENTER);
        txtGTKH.setLayout(new GridLayout(1, 2));
        txtGTKH.add(rbNam);
        txtGTKH.add(rbNu);

        pnFunKH.setLayout(new BorderLayout());
        pnFunKH.setBackground(Color.white);
        pnFunKH.add(lbFunction, BorderLayout.NORTH);
        pnFunKH.add(pnFunction, BorderLayout.CENTER);

        pnFunction.setLayout(new GridLayout(1, 2, 5, 5));
        pnFunction.setBackground(Color.white);
        pnFunction.setBorder(new EmptyBorder(5, 10, 5, 10));
        pnFunction.add(btnUpdate);
        pnFunction.add(btnSave);

        lbMaCTT.setFont(sgUI13b);
        lbMaNV.setFont(sgUI13b);
        lbTenNV.setFont(sgUI13b);
        lbTienCoc.setFont(sgUI13b);
        lbTinhTrangXuLy.setFont(sgUI13b);
        lbMaKH.setFont(sgUI13b);
        lbTenKH.setFont(sgUI13b);
        lbCMNDKH.setFont(sgUI13b);
        lbSDTKH.setFont(sgUI13b);
        lbGTKH.setFont(sgUI13b);
        lbFunction.setFont(sgUI13b);

        rbNam.setFocusPainted(false);
        rbNu.setFocusPainted(false);
        txtGTKH.setBackground(Color.white);
        rbNam.setBackground(Color.white);
        rbNu.setBackground(Color.white);

//        KhachHangDTO khDTO = KhachHangBUS.getKH_MaKH(maKH);
//        if (khDTO != null) {
//            txtMaKH.setText(khDTO.getMaKH());
//            txtTenKH.setText(khDTO.getTenKH());
//            txtCMNDKH.setText(khDTO.getCmnd());
//            txtSDTKH.setText(khDTO.getSdt());
//            if (khDTO.getGioiTinh().equalsIgnoreCase("Nam")) {
//                rbNam.setSelected(true);
//            } else {
//                rbNu.setSelected(true);
//            }
//        }

        txtMaKH.setEditable(false);
        txtTenKH.setEditable(false);
        txtCMNDKH.setEditable(false);
        txtSDTKH.setEditable(false);
        rbNam.setEnabled(false);
        rbNu.setEnabled(false);

        txtMaCTT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtMaNV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtTenNV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtTienCoc.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtTinhTrangXuLy.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtMaKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtTenKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtCMNDKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
        txtSDTKH.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));

        btnUpdate.setFocusPainted(false);
        btnSave.setFocusPainted(false);
        btnUpdate.setBackground(Color.decode("#FFD700"));
        btnUpdate.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));

        btnSave.setBackground(Color.decode("#98FB98"));
        btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
        btnUpdate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnUpdate.setBackground(new Color(255, 200, 0));
                btnUpdate.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnUpdate.setBackground(Color.decode("#FFD700"));
                btnUpdate.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
            }
        });

        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSave.setBackground(new Color(152, 251, 130));
                btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSave.setBackground(Color.decode("#98FB98"));
                btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
            }
        });

        btnPhong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPhong.setForeground(Color.decode("#FF7F50"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnPhong.setForeground(Color.black);
            }
        });

        btnDatPhong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDatPhong.setForeground(Color.decode("#FF7F50"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDatPhong.setForeground(Color.black);
            }
        });

        btnDichVu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDichVu.setForeground(Color.decode("#FF7F50"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDichVu.setForeground(Color.black);
            }
        });
        btnSave.setEnabled(false);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSave.setEnabled(true);
                txtTenKH.setEditable(true);
                txtSDTKH.setEditable(true);
                txtCMNDKH.setEditable(true);
                rbNam.setEnabled(true);
                rbNu.setEnabled(true);
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTenKH.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên khách hàng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtTenKH.requestFocus();
                } else {
                    if (txtCMNDKH.getText().trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập chứng minh nhân dân khách hàng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txtCMNDKH.requestFocus();
                    } else if (txtCMNDKH.getText().trim().length() > 10) {
                        JOptionPane.showMessageDialog(null, "Chứng minh nhân dân phải dưới 10 ký tự", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txtCMNDKH.setText("");
                        txtCMNDKH.requestFocus();
                    } else {
                        if (txtSDTKH.getText().trim().length() == 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách hàng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            txtSDTKH.requestFocus();
                        } else if (txtSDTKH.getText().trim().length() != 10) {
                            JOptionPane.showMessageDialog(null, "Số điện thoại sai", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            txtSDTKH.setText("");
                            txtSDTKH.requestFocus();
                        } else {
//                            KhachHangDTO khDTO = new KhachHangDTO();
//                            khDTO.setMaKH(txtMaKH.getText());
//                            khDTO.setTenKH(txtTenKH.getText().trim());
//                            khDTO.setCmnd(txtCMNDKH.getText().trim());
//                            khDTO.setSdt(txtSDTKH.getText().trim());
//                            if (rbNam.isSelected()) {
//                                khDTO.setGioiTinh("Nam");
//                            } else {
//                                khDTO.setGioiTinh("Nữ");
//                            }
//                            KhachHangBUS khBUS = new KhachHangBUS();
//                            try {
//                                khBUS.UpdateKH(khDTO);
//                                JOptionPane.showMessageDialog(null, "Sửa thông tin " + txtMaKH.getText() + " thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                txtMaKH.setEditable(false);
//                                txtTenKH.setEditable(false);
//                                txtCMNDKH.setEditable(false);
//                                txtSDTKH.setEditable(false);
//                                rbNam.setEnabled(false);
//                                rbNu.setEnabled(false);
//                                btnSave.setEnabled(false);
//                            } catch (Exception ex) {
//                                JOptionPane.showMessageDialog(null, "Sửa thông tin " + txtMaKH.getText() + " không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                            }
                        }
                    }
                }
            }
        });

//        ChiTiet ct = new ChiTiet(maCTT);
        pnCenterContent.setLayout(new BorderLayout());
//        pnCenterContent.add(ct, BorderLayout.CENTER);

        btnPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ChiTiet ct = new ChiTiet(maCTT);
                pnCenterContent.removeAll();
                pnCenterContent.repaint();
                pnCenterContent.revalidate();
                pnCenterContent.setLayout(new BorderLayout());
//                pnCenterContent.add(ct, BorderLayout.CENTER);
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FF6347")), new EmptyBorder(5, 10, 5, 10)));
                btnDichVu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
                btnDatPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
            }
        });

        btnDichVu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenterContent.removeAll();
                pnCenterContent.repaint();
                pnCenterContent.revalidate();
//                DichVu dv = new DichVu();
                pnCenterContent.setLayout(new BorderLayout());
//                pnCenterContent.add(dv, BorderLayout.CENTER);
                btnDichVu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FF6347")), new EmptyBorder(5, 10, 5, 10)));
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
                btnDatPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
            }
        });

        btnDatPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                DatPhong dp = new DatPhong();
                btnDatPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FF6347")), new EmptyBorder(5, 10, 5, 10)));
                btnDichVu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#FFFFFF")), new EmptyBorder(5, 10, 5, 10)));
                pnCenterContent.removeAll();
                pnCenterContent.repaint();
                pnCenterContent.revalidate();
                pnCenterContent.setLayout(new BorderLayout());
//                pnCenterContent.add(dp, BorderLayout.CENTER);
            }
        });
        setVisible(true);
        setSize(1430, 780);
        setLocationRelativeTo(null);
        txtMaCTT.setEditable(false);
        txtMaNV.setEditable(false);
        txtTenNV.setEditable(false);
        txtTienCoc.setEditable(false);
        txtTinhTrangXuLy.setEditable(false);
    }

    class ChiTiet extends JPanel {

        JPanel pnTop = new JPanel();
        JPanel pnBottom = new JPanel();
        JPanel pnBtn = new JPanel();
        JButton btnXuatFile = new JButton("Xuất File");
        JButton btnThanhToan = new JButton("Thanh toán");
        JPanel pnPhong = new JPanel();
        JPanel pnDV = new JPanel();
        JLabel lbPhong = new JLabel("Danh sách phòng đã thuê");
        JLabel lbDV = new JLabel("Danh sách dịch vụ đã thuê");
        JPanel pnPhongCenter = new JPanel();
        JScrollPane scpPhong = new JScrollPane();
        JTable tbPhong = new JTable();
        JPanel pnDichVuEdit = new JPanel();
        JPanel pnDichVuEditCenter = new JPanel();
        JPanel pnMaDV = new JPanel();
        JPanel pnTenDV = new JPanel();
        JPanel pnSLDV = new JPanel();
        JPanel pnNgaySuDung = new JPanel();
        JPanel pnBtnDichVu = new JPanel();

        JLabel lbMaDV = new JLabel("Mã dịch vụ:");
        JLabel lbTenDV = new JLabel("Tên dịch vụ:");
        JLabel lbSLDV = new JLabel("Số lượng dịch vụ:");
        JLabel lbNgaySuDung = new JLabel("Ngày sử dụng:");
        JLabel lbBtnDichVu = new JLabel("Chức năng:");

        JTextField txtMaDV = new JTextField();
        JTextField txtTenDV = new JTextField();
        JTextField txtSLDV = new JTextField();
        JDateChooser dateNgaySuDung = new JDateChooser();
        JPanel pnBtnFun = new JPanel();
        JButton btnUpdateDV = new JButton("Sửa");
        JButton btnSaveDV = new JButton("Lưu");
        JLabel lbDichVuEdit = new JLabel("Chỉnh sửa dịch vụ:               ");
        JPanel pnDichVuCenter = new JPanel();
        JScrollPane scpDichVu = new JScrollPane();
        JTable tbDichVu = new JTable();

//        ArrayList<PhongDTO> listPhong = new ArrayList<>();
//        ArrayList<ThuePhongDTO> listThuePhongDTO = new ArrayList<>();

//        ArrayList<DichVuDTO> listDV = new ArrayList<>();
//        ArrayList<SuDungDichVuDTO> listSuDungDV = new ArrayList<>();

        public ChiTiet(String maCTT) {
//            listThuePhongDTO = ThuePhongBUS.getListTP_P(maCTT, listPhong);
//            listSuDungDV = SuDungDichVuBUS.getListSDDV_maDV(maCTT, listDV);
            initComponents(maCTT);
        }

        public void initComponents(String maCTT) {
            setLayout(new BorderLayout(5, 5));
            add(pnTop, BorderLayout.CENTER);
            add(pnBottom, BorderLayout.SOUTH);

            pnTop.setLayout(new GridLayout(2, 1));
            pnTop.add(pnPhong);
            pnTop.add(pnDV);

            pnDichVuEdit.setLayout(new BorderLayout());
            pnDichVuEdit.setBorder(new EmptyBorder(5, 5, 0, 0));
            pnDichVuEdit.setBackground(Color.white);
            pnDichVuEdit.add(lbDichVuEdit, BorderLayout.NORTH);
            pnDichVuEdit.add(pnDichVuEditCenter, BorderLayout.CENTER);

            lbDichVuEdit.setFont(sgUI15);
            lbDichVuEdit.setBackground(Color.decode("#F0FFF0"));
            lbDichVuEdit.setOpaque(true);
            lbDichVuEdit.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));

            pnDichVuEditCenter.setLayout(new GridLayout(5, 1));
            pnDichVuEditCenter.add(pnMaDV);
            pnDichVuEditCenter.add(pnTenDV);
            pnDichVuEditCenter.add(pnSLDV);
            pnDichVuEditCenter.add(pnNgaySuDung);
            pnDichVuEditCenter.add(pnBtnDichVu);

            pnMaDV.setLayout(new BorderLayout());
            pnMaDV.setBackground(Color.white);
            pnMaDV.add(lbMaDV, BorderLayout.NORTH);
            pnMaDV.add(txtMaDV, BorderLayout.CENTER);

            pnTenDV.setLayout(new BorderLayout());
            pnTenDV.setBackground(Color.white);
            pnTenDV.add(lbTenDV, BorderLayout.NORTH);
            pnTenDV.add(txtTenDV, BorderLayout.CENTER);

            pnSLDV.setLayout(new BorderLayout());
            pnSLDV.setBackground(Color.white);
            pnSLDV.add(lbSLDV, BorderLayout.NORTH);
            pnSLDV.add(txtSLDV, BorderLayout.CENTER);

            pnNgaySuDung.setLayout(new BorderLayout());
            pnNgaySuDung.setBackground(Color.white);
            pnNgaySuDung.add(lbNgaySuDung, BorderLayout.NORTH);
            pnNgaySuDung.add(dateNgaySuDung, BorderLayout.CENTER);

            pnBtnDichVu.setLayout(new BorderLayout());
            pnBtnDichVu.setBackground(Color.white);
            pnBtnDichVu.add(lbBtnDichVu, BorderLayout.NORTH);
            pnBtnDichVu.add(pnBtnFun, BorderLayout.CENTER);
            pnBtnDichVu.setBackground(Color.white);
            pnBtnFun.setBackground(Color.white);
            pnBtnFun.setBorder(new EmptyBorder(5, 5, 0, 5));
            pnBtnFun.setLayout(new GridLayout(1, 2, 5, 5));
            pnBtnFun.add(btnUpdateDV);
            pnBtnFun.add(btnSaveDV);

            pnPhong.setLayout(new BorderLayout());
            pnPhong.add(lbPhong, BorderLayout.NORTH);
            pnPhong.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnPhong.setBackground(Color.white);
            lbPhong.setFont(sgUI15);
            lbPhong.setBackground(Color.decode("#F0FFF0"));
            lbPhong.setOpaque(true);
            lbPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));

            pnDV.setLayout(new BorderLayout());
            pnDV.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnDV.setBackground(Color.white);
            pnDV.add(lbDV, BorderLayout.NORTH);
            lbDV.setFont(sgUI15);
            lbDV.setBackground(Color.decode("#F0FFF0"));
            lbDV.setOpaque(true);
            lbDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));

            pnPhong.add(pnPhongCenter, BorderLayout.CENTER);
            scpPhong.getViewport().setBackground(Color.white);
            pnPhongCenter.setLayout(new BorderLayout());
            pnPhongCenter.add(scpPhong, BorderLayout.CENTER);
            scpPhong.setViewportView(tbPhong);
            renderTBphong(tbPhong);
            tbPhong.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        JPopupMenu pm = new JPopupMenu();
                        JMenuItem miX = new JMenuItem("Xóa");
                        JMenuItem miT = new JMenuItem("Trả phòng");
                        JMenuItem miD = new JMenuItem("Đổi phòng");
                        JMenuItem miL = new JMenuItem("Lấy phòng");
                        pm.add(miX);
                        pm.add(miT);
                        pm.add(miD);
                        pm.add(miL);
                        miX.setFont(sgUI13);
                        miT.setFont(sgUI13);
                        miD.setFont(sgUI13);
                        miL.setFont(sgUI13);
                        pm.show(tbPhong, e.getX(), e.getY());
                        miX.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String xuLy = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Tình trạng")).toString();
                                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phòng ra khỏi danh sách thuê", "Thông báo", JOptionPane.YES_NO_OPTION);
                                    if (ans == JOptionPane.YES_OPTION) {
                                        if (xuLy.equals("Đang được thuê")) {
                                            JOptionPane.showMessageDialog(null, "Không thể xóa phòng này vì đang được thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                        } else if (xuLy.equals("Đã trả phòng")) {
                                            JOptionPane.showMessageDialog(null, "Không thể xóa phòng này vì đã trả phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            String maCTT = txtMaCTT.getText();
                                            String maP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString();
                                            String date = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày thuê")).toString();
                                            String datelist[] = date.split("-");
                                            String year[] = datelist[2].split(" ");
                                            String dateThue = year[0] + "-" + datelist[1] + "-" + datelist[0] + " " + year[1];
//                                            if (ThuePhongBUS.deleteTP(maCTT, maP, dateThue)) {
//                                                JOptionPane.showMessageDialog(null, "Xóa phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                                listThuePhongDTO.clear();
//                                                listThuePhongDTO = ThuePhongBUS.getListTP_P(maCTT, listPhong);
//                                                renderTBphong(tbPhong);
//                                            } else {
//                                                JOptionPane.showMessageDialog(null, "Xoá phòng không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                            }
                                        }
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        });
                        miT.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String xuLy = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Tình trạng")).toString();
                                    if (xuLy.equals("Đang xử lý")) {
                                        JOptionPane.showMessageDialog(null, "Không thể trả phòng này vì chưa được thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    } else if (xuLy.equals("Đã trả phòng")) {
                                        JOptionPane.showMessageDialog(null, "Không thể trả phòng này vì phòng đã trả phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        String maCTT = txtMaCTT.getText();
                                        String maP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString();
                                        String date = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày thuê")).toString();
                                        String datelist[] = date.split("-");
                                        String year[] = datelist[2].split(" ");
                                        String dateThue = year[0] + "-" + datelist[1] + "-" + datelist[0] + " " + year[1];
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                        String now = LocalDateTime.now().format(formatter);
//                                        if (ThuePhongBUS.updateCheckOut(maCTT, maP, dateThue, now)) {
//                                            JOptionPane.showMessageDialog(null, "Trả phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                            listThuePhongDTO.clear();
//                                            listThuePhongDTO = ThuePhongBUS.getListTP_P(maCTT, listPhong);
//                                            renderTBphong(tbPhong);
//                                            PhongBUS.updateTT(maP, "Chưa dọn phòng");
//                                        } else {
//                                            JOptionPane.showMessageDialog(null, "Trả phòng không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                        }
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng muốn trả", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        });
                        miL.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String xuLy = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Tình trạng")).toString();
                                    if (xuLy.equals("Đang được thuê")) {
                                        JOptionPane.showMessageDialog(null, "Không thể lấy phòng này vì đang được thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    } else if (xuLy.equals("Đã trả phòng")) {
                                        JOptionPane.showMessageDialog(null, "Không thể lấy phòng này vì phòng đã trả phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        String maCTT = txtMaCTT.getText();
                                        String maP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString();
                                        String date = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày thuê")).toString();
                                        String datelist[] = date.split("-");
                                        String year[] = datelist[2].split(" ");
                                        String dateThue = year[0] + "-" + datelist[1] + "-" + datelist[0] + " " + year[1];
//                                        if (ThuePhongBUS.updateTT(maCTT, maP, dateThue, 1)) {
//                                            JOptionPane.showMessageDialog(null, "Lấy phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                            listThuePhongDTO.clear();
//                                            listThuePhongDTO = ThuePhongBUS.getListTP_P(maCTT, listPhong);
//                                            renderTBphong(tbPhong);
//                                            PhongBUS.updateTT(maP, "Đang được thuê");
//                                        } else {
//                                            JOptionPane.showMessageDialog(null, "Trả phòng không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                        }
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng muốn trả", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        });
                        miD.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    String xuLy = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Tình trạng")).toString();
                                    if (xuLy.equals("Đã trả phòng")) {
                                        JOptionPane.showMessageDialog(null, "Không thể đổi phòng vì phòng đã trả", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        String dateThue = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày thuê")).toString();
                                        String dateTra = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Ngày trả")).toString();
                                        String dayThue = dateThue.split(" ")[0];
                                        String timeThue = dateThue.split(" ")[1];
                                        String dayTh[] = dayThue.split("-");
                                        String dateThuestr = dayTh[2] + "-" + dayTh[1] + "-" + dayTh[0] + " " + timeThue;

                                        String dayTra = dateTra.split(" ")[0];
                                        String timeTra = dateTra.split(" ")[1];
                                        String dayTr[] = dayTra.split("-");
                                        String dateTrastr = dayTr[2] + "-" + dayTr[1] + "-" + dayTr[0] + " " + timeTra;
//                                        new Phong(dateThuestr, dateTrastr, ChiTiet.this);
                                    }
                                } catch (Exception ex) {
                                }
                            }
                        });
                    }
                }
            });

            btnXuatFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    File fontFile = new File("arialuni.ttf");
//                    Document document = new Document();
//                    try {
//                        PdfWriter.getInstance(document, new FileOutputStream("pdf/" + txtMaCTT.getText() + ".pdf"));
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(DatPhongForm.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (DocumentException ex) {
//                        Logger.getLogger(DatPhongForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    document.open();
//                    com.itextpdf.text.Font font18 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, BaseColor.BLACK);
//                    com.itextpdf.text.Font font13 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, BaseColor.BLACK);
//                    Paragraph pTitle = new Paragraph("Chi tiết thuê");
//                    try {
//                        document.add(pTitle);
//                    } catch (DocumentException ex) {
//                        Logger.getLogger(DatPhongForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    document.close();
                }
            });

            btnThanhToan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh toán?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        int count = 0;
//                        for (ThuePhongDTO x : listThuePhongDTO) {
//                            if (x.getTinhTrang() == 0) {
//                                count++;
//                            }
//                        }
                        if (count == 0) {
                            int gt = 1;
                            if(rbNam.isSelected()) {
                                gt = 0;
                            }
//                            new LapHoaDonGUI(txtMaKH.getText(),txtTenKH.getText(),txtCMNDKH.getText(),txtSDTKH.getText(),gt,txtMaCTT.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "Còn phòng đang xử lý");
                        }
                    }
                }
            });

            pnDV.add(pnDichVuCenter, BorderLayout.CENTER);
            pnDV.add(pnDichVuEdit, BorderLayout.EAST);

            pnDichVuCenter.setLayout(new BorderLayout());
            pnDichVuCenter.add(scpDichVu, BorderLayout.CENTER);
            scpDichVu.getViewport().setBackground(Color.white);
            scpDichVu.setViewportView(tbDichVu);
            renderTBDichVu(tbDichVu);

            btnUpdateDV.setFocusPainted(false);
            btnSaveDV.setFocusPainted(false);
            btnUpdateDV.setBackground(Color.decode("#FFD700"));
            btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));

            btnSaveDV.setBackground(Color.decode("#98FB98"));
            btnSaveDV.setEnabled(false);
            btnSaveDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
            btnUpdateDV.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnUpdateDV.setBackground(new Color(255, 200, 0));
                    btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnUpdateDV.setBackground(Color.decode("#FFD700"));
                    btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
                }
            });

            btnSaveDV.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnSaveDV.setBackground(new Color(152, 251, 130));
                    btnSaveDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnSaveDV.setBackground(Color.decode("#98FB98"));
                    btnSaveDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
                }
            });
            btnUpdateDV.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnSaveDV.setEnabled(true);
                    txtSLDV.setEditable(true);
                }
            });

            btnSaveDV.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (txtSLDV.getText().trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txtSLDV.requestFocus();
                    } else {
                        try {
                            int sl = Integer.parseInt(txtSLDV.getText().trim());
                            if (sl <= 0) {
                                JOptionPane.showMessageDialog(null, "Số lượng là số nguyên lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                txtSLDV.setText("");
                                txtSLDV.requestFocus();
                            } else {
                                try {
                                    String ngaySuDung = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Ngày sử dụng")).toString();
                                    int gia = Integer.parseInt(tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Đơn giá")).toString());
                                    String date[] = ngaySuDung.split("-");
                                    String ngaySD = date[2] + "-" + date[1] + "-" + date[0];
//                                    if (SuDungDichVuBUS.updateSuDungDichVu(maCTT, txtMaDV.getText(), ngaySD, sl, gia * sl)) {
//                                        JOptionPane.showMessageDialog(null, "Sửa dịch vụ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                        listSuDungDV = SuDungDichVuBUS.getListSDDV_maDV(maCTT, listDV);
//                                        renderTBDichVu(tbDichVu);
//                                        txtMaDV.setText("");
//                                        txtTenDV.setText("");
//                                        txtSLDV.setText("");
//                                        dateNgaySuDung.setCalendar(null);
//                                        btnSaveDV.setEnabled(false);
//                                        txtSLDV.setEditable(false);
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "Sửa dịch vụ không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Sửa dịch vụ không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Số lượng là số nguyên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            txtSLDV.setText("");
                            txtSLDV.requestFocus();
                        }
                    }
                }
            });

            txtMaDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
            txtTenDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
            txtSLDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
            dateNgaySuDung.getCalendarButton().setBackground(Color.white);
            pnBottom.setLayout(new BorderLayout());
            pnBottom.add(pnBtn, BorderLayout.EAST);
            pnBottom.setBackground(Color.white);
            pnBtn.setLayout(new GridLayout(1, 2, 5, 5));
            pnBtn.setBorder(new EmptyBorder(5, 10, 10, 10));
            pnBtn.setBackground(Color.white);
            pnBtn.add(btnXuatFile);
            pnBtn.add(btnThanhToan);
            btnXuatFile.setPreferredSize(new Dimension(100, 30));
            btnThanhToan.setPreferredSize(new Dimension(100, 30));
            btnXuatFile.setFocusPainted(false);
            btnThanhToan.setFocusPainted(false);
            btnXuatFile.setBackground(Color.decode("#FF7F50"));
            btnXuatFile.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
            btnXuatFile.setForeground(Color.white);
            btnXuatFile.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnXuatFile.setBackground(Color.decode("#FF7F50"));
                    btnXuatFile.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(4, 4, 1, 1, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
                    btnXuatFile.setForeground(Color.black);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnXuatFile.setBackground(Color.decode("#FF7F50"));
                    btnXuatFile.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
                    btnXuatFile.setForeground(Color.white);
                }
            });

            btnThanhToan.setBackground(Color.decode("#FF7F50"));
            btnThanhToan.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
            btnThanhToan.setForeground(Color.white);
            btnThanhToan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnThanhToan.setBackground(Color.decode("#FF7F50"));
                    btnThanhToan.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(4, 4, 1, 1, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
                    btnThanhToan.setForeground(Color.black);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnThanhToan.setBackground(Color.decode("#FF7F50"));
                    btnThanhToan.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
                    btnThanhToan.setForeground(Color.white);
                }
            });
            txtMaDV.setEditable(false);
            txtTenDV.setEditable(false);
            txtSLDV.setEditable(false);
            dateNgaySuDung.setEnabled(false);
            tbDichVu.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        JPopupMenu pm = new JPopupMenu();
                        JMenuItem mitem = new JMenuItem("Xóa");
                        pm.add(mitem);
                        pm.show(tbDichVu, e.getX(), e.getY());
                        mitem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (txtMaDV.getText().length() == 0) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    String date = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Ngày sử dụng")).toString();
                                    LocalDate lcNow = LocalDate.now();
                                    LocalDate lcSD = LocalDate.of(Integer.parseInt(date.split("-")[2]), Integer.parseInt(date.split("-")[1]), Integer.parseInt(date.split("-")[0]));
                                    if (lcSD.isBefore(lcNow)) {
                                        JOptionPane.showMessageDialog(null, "Dịch vụ này đã được thuê lâu rồi không thể xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                        txtMaDV.setText("");
                                        txtTenDV.setText("");
                                        dateNgaySuDung.setCalendar(null);
                                        tbDichVu.clearSelection();
                                    } else {
//                                        String datestr = listSuDungDV.get(tbDichVu.getSelectedRow()).getNgaySuDungString();
//                                        if (SuDungDichVuBUS.deleteSuDungDichVu(txtMaCTT.getText(), txtMaDV.getText(), datestr.split("-")[2] + "-" + datestr.split("-")[1] + "-" + datestr.split("-")[0])) {
//                                            JOptionPane.showMessageDialog(null, "Xoá dịch vụ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                            listSuDungDV = SuDungDichVuBUS.getListSDDV_maDV(maCTT, listDV);
//                                            renderTBDichVu(tbDichVu);
//                                            txtMaDV.setText("");
//                                            txtTenDV.setText("");
//                                            txtSLDV.setText("");
//                                            dateNgaySuDung.setCalendar(null);
//                                            btnSaveDV.setEnabled(false);
//                                            txtSLDV.setEditable(false);
//                                        }
                                    }
                                }
                            }

                        });
                    }
                }
            });
            tbDichVu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    try {
                        String maDV = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Mã dịch vụ")).toString();
                        String tenDV = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Tên dịch vụ")).toString();
                        String slDV = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Số lượng")).toString();
                        String ngaySuDung = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Ngày sử dụng")).toString();
                        String donGia = tbDichVu.getValueAt(tbDichVu.getSelectedRow(), tbDichVu.getColumnModel().getColumnIndex("Đơn giá")).toString();
                        txtMaDV.setText(maDV);
                        txtTenDV.setText(tenDV);
                        txtSLDV.setText(slDV);
                        txtSLDV.setEditable(false);
                        btnSaveDV.setEnabled(false);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        Date date = null;
                        try {
                            date = sdf.parse(ngaySuDung);
                        } catch (ParseException ex) {
                            Logger.getLogger(DatPhongForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dateNgaySuDung.setDate(date);
                    } catch (Exception ex) {
                        txtMaDV.setText("");
                        txtTenDV.setText("");
                        txtSLDV.setText("");
                        dateNgaySuDung.setCalendar(null);
                    }
                }
            });
        }

        public void renderTBphong(JTable tb) {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("STT");
            dtm.addColumn("Mã phòng");
            dtm.addColumn("Tên phòng");
            dtm.addColumn("Tình trạng");
            dtm.addColumn("Loại hình thuê");
            dtm.addColumn("Ngày thuê");
            dtm.addColumn("Ngày trả");
            dtm.addColumn("Ngày CheckOut");
            dtm.addColumn("Giá phòng");
            dtm.addColumn("Giá thực");
            int i = 0;
//            for (ThuePhongDTO x : listThuePhongDTO) {
//                String tinhTrang = "";
//                if (x.getTinhTrang() == 0) {
//                    tinhTrang = "Đang xử lý";
//                } else if (x.getTinhTrang() == 1) {
//                    tinhTrang = "Đang được thuê";
//                } else {
//                    tinhTrang = "Đã trả phòng";
//                }
//                Object row[] = {i + 1, x.getMaP(), listPhong.get(i).getTenP(), tinhTrang, x.getLoaiHinhThue(), x.getNgayThue(), x.getNgayTra(), x.getNgayCheckOut(), listPhong.get(i).getGiaP(), x.getGia()};
//                dtm.addRow(row);
//                i++;
//            }
            tb.setModel(dtm);
            tb.setShowGrid(false);
            tb.setIntercellSpacing(new Dimension(0, 0));
            tb.setRowHeight(30);
            tb.getColumnModel().getColumn(0).setPreferredWidth(5);
            tb.getColumnModel().getColumn(1).setPreferredWidth(50);
            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    JLabel lb = (JLabel) c;
                    lb.setHorizontalAlignment(JLabel.CENTER);
                    if (isSelected) {
                        lb.setBackground(Color.decode("#F5F5F5"));
                    } else {
                        lb.setBackground(Color.decode("#FFFFFF"));
                    }
                    if (column == tb.getColumnModel().getColumnIndex("STT")) {
                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
                        lb.setBackground(Color.decode("#99FF99"));
                    } else {
                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
                    }

                    if (column == tb.getColumnModel().getColumnIndex("Tình trạng")) {
                        if (lb.getText().equals("Đang được thuê")) {
                            lb.setForeground(Color.red);
                        } else if (lb.getText().equals("Đã trả phòng")) {
                            lb.setForeground(Color.decode("#FFD700"));
                        } else {
                            lb.setForeground(Color.decode("#228B22"));
                        }
                    } else {
                        lb.setForeground(Color.black);
                    }

                    return lb;
                }
            };
            for (int j = 0; j < tb.getColumnCount(); j++) {
                tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
            }
        }

        public void renderTBDichVu(JTable tbDV) {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("STT");
            dtm.addColumn("Mã dịch vụ");
            dtm.addColumn("Tên dịch vụ");
            dtm.addColumn("Ngày sử dụng");
            dtm.addColumn("Số lượng");
            dtm.addColumn("Đơn giá");
            dtm.addColumn("Giá dịch vụ");
            int i = 0;
//            for (SuDungDichVuDTO x : listSuDungDV) {
//                Object row[] = {i + 1, x.getMaDV(), listDV.get(i).getTenDV(), x.getNgaySuDungString(), x.getSoLuong(), listDV.get(i).getGiaDV(), x.getDonGia()};
//                dtm.addRow(row);
//                i++;
//            }
            tbDV.setModel(dtm);
            tbDV.setShowGrid(false);
            tbDV.setIntercellSpacing(new Dimension(0, 0));
            tbDV.setRowHeight(30);
            tbDV.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbDV.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbDV.getTableHeader().setPreferredSize(new Dimension(1, 32));
            tbDV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tbDV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    JLabel lb = (JLabel) c;
                    lb.setHorizontalAlignment(JLabel.CENTER);
                    if (isSelected) {
                        lb.setBackground(Color.decode("#F5F5F5"));
                    } else {
                        lb.setBackground(Color.decode("#FFFFFF"));
                    }
                    if (column == tbDV.getColumnModel().getColumnIndex("STT")) {
                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
                        lb.setBackground(Color.decode("#99FF99"));
                    } else {
                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
                    }
                    return lb;
                }
            };
            for (int j = 0; j < tbDV.getColumnCount(); j++) {
                tbDV.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
            }
        }
    }
}
//    class Phong extends JFrame {
//
//        JPanel pnSelectPhong = new JPanel();
//        JLabel lbSelectPhong = new JLabel("Chọn phòng cần đổi");
//        JPanel pnSelectPhongContent = new JPanel();
//        JPanel pnSelectPhongContentTop = new JPanel();
//        JCheckBox ckbVip = new JCheckBox("VIP");
//        JCheckBox ckbThuong = new JCheckBox("Thường");
//        JComboBox cbGia = new JComboBox();
//        JPanel pnBtnReset = new JPanel();
//        JButton btnReset = new JButton("Làm mới");
//        JPanel pnSelectPhongContentBottom = new JPanel();
//        JPanel pnContentTop = new JPanel();
//        JPanel pnContentBottom = new JPanel();
//        JScrollPane scp = new JScrollPane();
//        JTable tbPhong = new JTable();
//        JPanel pnBtnSelectPhong = new JPanel();
//        JButton btnAcept = new JButton("Chọn phòng");
//        JScrollPane scpTI = new JScrollPane();
//        JTable tbTI = new JTable();
////        ArrayList<PhongDTO> listPhong = new ArrayList<>();
////        ArrayList<TienIchDTO> listTI = new ArrayList<>();
//        ArrayList<Integer> listInt = new ArrayList<>();
//        JPanel pnTienIch = new JPanel();
//        boolean check = false;
//        JLabel lbTienIch = new JLabel("Tiện ích hiện có:");
//
//        public Phong(String dateThue, String dateTra, ChiTiet ct) {
//            initComponents(dateThue, dateTra, ct);
//        }
//
//        public void initComponents(String dateThue, String dateTra, ChiTiet ct) {
//            setVisible(true);
//            setSize(1300, 600);
//            setLocationRelativeTo(null);
//            setLayout(new BorderLayout());
//            add(pnSelectPhong, BorderLayout.CENTER);
//            pnSelectPhong.setBackground(Color.white);
//            pnSelectPhong.setLayout(new BorderLayout());
//            pnSelectPhong.add(lbSelectPhong, BorderLayout.NORTH);
//            //=====================================================================
//            pnSelectPhong.add(pnSelectPhongContent, BorderLayout.CENTER);
//            pnSelectPhongContent.setLayout(new BorderLayout());
//            pnSelectPhongContent.add(pnSelectPhongContentTop, BorderLayout.NORTH);
//            pnSelectPhongContentTop.setBorder(new EmptyBorder(5, 0, 5, 0));
//            pnSelectPhongContentTop.setBackground(Color.white);
//            pnSelectPhongContentTop.setLayout(new GridLayout(1, 4));
//            pnSelectPhongContentTop.add(ckbVip);
//            pnSelectPhongContentTop.add(ckbThuong);
//            pnSelectPhongContentTop.add(cbGia);
//            pnSelectPhongContentTop.add(pnBtnReset);
//            pnBtnReset.setBackground(Color.white);
//            pnBtnReset.setLayout(new BorderLayout());
//            pnBtnReset.add(btnReset, BorderLayout.CENTER);
//            pnBtnReset.setBorder(new EmptyBorder(0, 20, 0, 0));
//            ckbThuong.setFocusPainted(false);
//            ckbVip.setFocusPainted(false);
//            btnReset.setFocusPainted(false);
//            ckbVip.setBackground(Color.white);
//            ckbThuong.setBackground(Color.white);
//            cbGia.setBackground(Color.white);
//            String item[] = {"Chọn giá", "0 đến 300000", "300000 đến 500000", "500000 đến 1500000", "1500000 đến 5000000", "Trên 5000000"};
//            for (String str : item) {
//                cbGia.addItem(str);
//            }
//            cbGia.setFont(sgUI13);
////            for (PhongDTO x : PhongBUS.getListPhong(dateThue, dateTra)) {
////                listPhong.add(x);
////            }
////            renderPhong(tbPhong, listPhong);
//
//            pnSelectPhongContent.add(pnSelectPhongContentBottom, BorderLayout.CENTER);
//            pnSelectPhongContentBottom.setLayout(new BorderLayout());
//            pnSelectPhongContentBottom.add(pnContentTop, BorderLayout.CENTER);
//            pnContentTop.setLayout(new BorderLayout());
//            pnContentTop.add(scp, BorderLayout.CENTER);
//            scp.getViewport().setBackground(Color.white);
//            scp.setViewportView(tbPhong);
//            pnSelectPhongContentBottom.add(pnContentBottom, BorderLayout.SOUTH);
//            pnContentBottom.setLayout(new BorderLayout());
//            pnContentBottom.setBackground(Color.white);
//            pnContentBottom.add(pnBtnSelectPhong, BorderLayout.EAST);
//            pnBtnSelectPhong.setBorder(new EmptyBorder(5, 0, 0, 0));
//            pnBtnSelectPhong.setBackground(Color.white);
//            pnBtnSelectPhong.setLayout(new BorderLayout());
//            pnBtnSelectPhong.add(btnAcept, BorderLayout.CENTER);
//            btnAcept.setFocusPainted(false);
//            btnAcept.setBackground(Color.decode("#98FB98"));
//            btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
//            btnAcept.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    btnAcept.setBackground(new Color(152, 251, 130));
//                    btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    btnAcept.setBackground(Color.decode("#98FB98"));
//                    btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
//                }
//            });
//            btnAcept.setPreferredSize(new Dimension(100, 30));
//            pnSelectPhong.setBorder(new EmptyBorder(5, 0, 5, 5));
//            lbSelectPhong.setFont(sgUI15);
//            lbSelectPhong.setBackground(Color.decode("#F0FFF0"));
//            lbSelectPhong.setOpaque(true);
//            lbSelectPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
//
//            add(pnTienIch, BorderLayout.EAST);
//            pnTienIch.setLayout(new BorderLayout());
//            pnTienIch.setBackground(Color.white);
//            pnTienIch.setBorder(new EmptyBorder(5, 0, 5, 5));
//            pnTienIch.add(lbTienIch, BorderLayout.NORTH);
//            pnTienIch.add(scpTI, BorderLayout.CENTER);
//            scpTI.getViewport().setBackground(Color.white);
//            scpTI.setViewportView(tbTI);
////            renderTI(tbTI);
//            lbTienIch.setFont(sgUI15);
//            lbTienIch.setBackground(Color.decode("#F0FFF0"));
//            lbTienIch.setOpaque(true);
//            lbTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
//            tbPhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//                @Override
//                public void valueChanged(ListSelectionEvent e) {
//                    try {
//                        check = true;
//                        String maP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString();
////                        listTI = TienIchBUS.getListTienIchCTTI(maP, listInt);
////                        renderTI(tbTI);
//                    } catch (Exception ex) {
//                    }
//                }
//            });
//            btnAcept.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if (listPhong.size() != 0) {
//                        ThuePhongDTO x = new ThuePhongDTO();
//                        x.setMaChiTietThue(txtMaCTT.getText());
//                        x.setMaP(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString());
//                        x.setNgayThue(dateThue);
//                        x.setNgayTra(dateTra);
//                        x.setXuLy(0);
//                        x.setLoaiHinhThue(ct.tbPhong.getValueAt(ct.tbPhong.getSelectedRow(), ct.tbPhong.getColumnModel().getColumnIndex("Loại hình thuê")).toString());
//                        x.setNgayCheckOut(dateTra);
//                        if (ct.tbPhong.getValueAt(ct.tbPhong.getSelectedRow(), ct.tbPhong.getColumnModel().getColumnIndex("Tình trạng")).toString().equals("Đang được thuê")) {
//                            x.setTinhTrang(1);
//                        } else {
//                            x.setTinhTrang(0);
//                        }
//                        int yearThue = Integer.parseInt(dateThue.split(" ")[0].split("-")[0]);
//                        int monthThue = Integer.parseInt(dateThue.split(" ")[0].split("-")[1]);
//                        int dayThue = Integer.parseInt(dateThue.split(" ")[0].split("-")[2]);
//                        int hourThue = Integer.parseInt(dateThue.split(" ")[1].split(":")[0]);
//                        int minuteThue = Integer.parseInt(dateThue.split(" ")[1].split(":")[1]);
//                        int secondThue = Integer.parseInt(dateThue.split(" ")[1].split(":")[2]);
//
//                        LocalDate ThueDate = LocalDate.of(yearThue, monthThue, dayThue);
//                        LocalTime ThueTime = LocalTime.of(hourThue, minuteThue, secondThue);
//                        LocalDateTime ldtThue = LocalDateTime.of(ThueDate, ThueTime);
//
//                        int yearTra = Integer.parseInt(dateTra.split(" ")[0].split("-")[0]);
//                        int monthTra = Integer.parseInt(dateTra.split(" ")[0].split("-")[1]);
//                        int dayTra = Integer.parseInt(dateTra.split(" ")[0].split("-")[2]);
//                        int hourTra = Integer.parseInt(dateTra.split(" ")[1].split(":")[0]);
//                        int minuteTra = Integer.parseInt(dateTra.split(" ")[1].split(":")[1]);
//                        int secondTra = Integer.parseInt(dateTra.split(" ")[1].split(":")[2]);
//
//                        LocalDate TraDate = LocalDate.of(yearTra, monthTra, dayTra);
//                        LocalTime TraTime = LocalTime.of(hourTra, minuteTra, secondTra);
//                        LocalDateTime ldtTra = LocalDateTime.of(TraDate, TraTime);
//
//                        int gia = Integer.parseInt(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Giá phòng")).toString());
//                        if (x.getLoaiHinhThue().equals("Theo ngày")) {
//                            int day = ldtTra.compareTo(ldtThue);
//                            x.setGia(day * gia);
//                        } else {
//                            long hourCount = ChronoUnit.HOURS.between(ldtThue, ldtTra);
//                            long day = hourCount / 24;
//                            long hour = hourCount % 24;
//                            if (hour == 1) {
//                                x.setGia((int) (gia * 45 / 100 + day * gia));
//                            } else if (hour == 2) {
//                                x.setGia((int) ((gia * 45 / 100 - 20000) + day * gia));
//                            } else if (hour == 3) {
//                                x.setGia((int) ((gia * 45 / 100 - 40000) + day * gia));
//                            } else if (hour >= 4 && hour <= 12) {
//                                x.setGia((int) ((gia / 2) + day * gia));
//                            } else {
//                                x.setGia((int) (day * gia + gia));
//                            }
//                        }
//                        String maCTT = txtMaCTT.getText();
//                        String maP = ct.tbPhong.getValueAt(ct.tbPhong.getSelectedRow(), ct.tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString();
//                        String date = ct.tbPhong.getValueAt(ct.tbPhong.getSelectedRow(), ct.tbPhong.getColumnModel().getColumnIndex("Ngày thuê")).toString();
//                        String datelist[] = date.split("-");
//                        String year[] = datelist[2].split(" ");
//                        String dateThue = year[0] + "-" + datelist[1] + "-" + datelist[0] + " " + year[1];
//                        if (ThuePhongBUS.deleteTP(maCTT, maP, dateThue)) {
//                            if (ThuePhongBUS.insertTP(x)) {
//                                ct.listThuePhongDTO.clear();
//                                ct.listThuePhongDTO = ThuePhongBUS.getListTP_P(maCTT, ct.listPhong);
//                                ct.renderTBphong(ct.tbPhong);
//                                dispose();
//                                JOptionPane.showMessageDialog(null, "Đổi phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Đổi phòng không thành côngs", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Đổi phòng không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    }
//                }
//            });
//        }

//        public synchronized void renderTI(JTable tb) {
//            DefaultTableModel dtm = new DefaultTableModel();
//            dtm.addColumn("STT");
//            dtm.addColumn("Mã tiện ích");
//            dtm.addColumn("Tên tiện ích");
//            dtm.addColumn("Số lượng");
//            tb.setModel(dtm);
//            new Thread(() -> {
//                int i = 0;
//                for (TienIchDTO x : listTI) {
//                    try {
//                        Object row[] = {i + 1, x.getMaTienIch(), x.getTenTienIch(), listInt.get(i)};
//                        dtm.addRow(row);
//                    } catch (Exception e) {
//                    }
//                    tb.setShowGrid(false);
//                    tb.setIntercellSpacing(new Dimension(0, 0));
//                    tb.setRowHeight(30);
//                    tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
//                    tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("Mã tiện ích")).setPreferredWidth(50);
//                    tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
//                    tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
//                    tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//                    tb.getTableHeader().setBackground(Color.decode("#33CC33"));
//                    DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
//                        @Override
//                        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                            JLabel lb = (JLabel) c;
//
//                            lb.setHorizontalAlignment(JLabel.CENTER);
//                            if (isSelected) {
//                                lb.setBackground(Color.decode("#F5F5F5"));
//                            } else {
//                                lb.setBackground(Color.decode("#FFFFFF"));
//                            }
//                            if (column == 0) {
//                                lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
//                                lb.setBackground(Color.decode("#99FF99"));
//                            } else {
//                                lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
//                            }
//                            return lb;
//                        }
//                    };
//                    for (int j = 0; j < tb.getColumnCount(); j++) {
//                        tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
//                    }
//                    tb.setModel(dtm);
//                    i++;
//                    try {
//                        Thread.sleep(50);
//                    } catch (Exception e) {
//                    }
//                }
//            }).start();
//        }

//        public void renderPhong(JTable tb, ArrayList<PhongDTO> listPhong) {
//            DefaultTableModel dtm = new DefaultTableModel();
//            dtm.addColumn("STT");
//            dtm.addColumn("Mã phòng");
//            dtm.addColumn("Tên phòng");
//            dtm.addColumn("Loại phòng");
//            dtm.addColumn("Giá phòng");
//            dtm.addColumn("Hiện trạng");
//            int i = 1;
//            for (PhongDTO x : listPhong) {
//                Object data[] = {i, x.getMaP(), x.getTenP(), x.getLoaiP(), x.getGiaP(), x.getHienTrang()};
//                dtm.addRow(data);
//                i++;
//            }
//            tb.setModel(dtm);
//            tb.setShowGrid(false);
//            tb.setIntercellSpacing(new Dimension(0, 0));
//            tb.setRowHeight(30);
//            tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
//            tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(50);
//            tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("Loại phòng")).setPreferredWidth(45);
//            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
//            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
//            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
//                @Override
//                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                    JLabel lb = (JLabel) c;
//                    if (isSelected) {
//                        lb.setBackground(Color.decode("#F5F5F5"));
//                    } else {
//                        lb.setBackground(Color.decode("#FFFFFF"));
//                    }
//                    if (column == tb.getColumnModel().getColumnIndex("STT")) {
//                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
//                        lb.setBackground(Color.decode("#99FF99"));
//                    } else {
//                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
//                    }
//                    if (column == tb.getColumnModel().getColumnIndex("Tên phòng")) {
//                        lb.setHorizontalAlignment(JLabel.LEFT);
//                        lb.setBorder(new EmptyBorder(0, 5, 0, 0));
//                    } else {
//                        lb.setHorizontalAlignment(JLabel.CENTER);
//                        lb.setBorder(new EmptyBorder(0, 0, 0, 0));
//                    }
//                    return lb;
//                }
//            };
//            for (int j = 0; j < tb.getColumnCount(); j++) {
//                tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
//            }
//        }
//    }

//    class DatPhong extends JPanel {
//
//        JPanel pnCenter = new JPanel();
//        JPanel pnBottom = new JPanel();
//        JButton btnSave = new JButton("Lưu");
//        JPanel pnbtn = new JPanel();
//        JPanel pnCenterTop = new JPanel();
//        JPanel pnCenterBottom = new JPanel();
//        JScrollPane scpDatPhong = new JScrollPane();
//        JTable tbDatPhong = new JTable();
//        JLabel lbCenterBottom = new JLabel("Danh sách phòng đang xử lý");
//        JPanel pnCenterTopLeft = new JPanel();
//        JPanel pnCenterTopContent = new JPanel();
//        JPanel pnSelectPhong = new JPanel();
//        JPanel pnTienIch = new JPanel();
//        JPanel pnCenterTopLeftContent = new JPanel();
//        JPanel pnHinhThuc = new JPanel();
//        JPanel pnNgayThue = new JPanel();
//        JPanel pnTimeThue = new JPanel();
//        JPanel pnNgayTra = new JPanel();
//        JPanel pnTimeTra = new JPanel();
//        JPanel pnBtn = new JPanel();
//        JPanel pnRight = new JPanel();
//
//        JLabel lbHinhThuc = new JLabel("Hình thức thuê:");
//        JLabel lbNgayThue = new JLabel("Ngày thuê:");
//        JLabel lbTimeThue = new JLabel("Giờ thuê");
//        JLabel lbNgayTra = new JLabel("Ngày trả:");
//        JLabel lbTimeTra = new JLabel("Giờ trả:");
//        JButton btnSelectPhong = new JButton("Chọn phòng");
//
//        JPanel pnHT = new JPanel();
//        JDateChooser dateNgayThue = new JDateChooser();
////        TimeChoose timeNgayThue = new TimeChoose();
//        JDateChooser dateNgayTra = new JDateChooser();
////        TimeChoose timeNgayTra = new TimeChoose();
//
//        JRadioButton rbNgay = new JRadioButton("Ngày");
//        JRadioButton rbGio = new JRadioButton("Giờ");
//        JLabel lbCenterTopLeft = new JLabel("Nhập chi tiết thuê          ");
//        ButtonGroup bgHT = new ButtonGroup();
//        JLabel lbSelectPhong = new JLabel("Chọn phòng cần thuê");
//        JLabel lbTienIch = new JLabel("Tiện ích hiện có:");
//        JPanel pnSelectPhongContent = new JPanel();
//        JPanel pnSelectPhongContentTop = new JPanel();
//        JCheckBox ckbVip = new JCheckBox("VIP");
//        JCheckBox ckbThuong = new JCheckBox("Thường");
//        JComboBox cbGia = new JComboBox();
//        JPanel pnBtnReset = new JPanel();
//        JButton btnReset = new JButton("Làm mới");
//        JPanel pnSelectPhongContentBottom = new JPanel();
//        JPanel pnContentTop = new JPanel();
//        JPanel pnContentBottom = new JPanel();
//        JScrollPane scp = new JScrollPane();
//        JTable tbPhong = new JTable();
//        JPanel pnBtnSelectPhong = new JPanel();
//        JButton btnAcept = new JButton("Chọn phòng");
//        JScrollPane scpTI = new JScrollPane();
//        JTable tbTI = new JTable();
////        ArrayList<PhongDTO> listPhong = new ArrayList<>();
////        ArrayList<TienIchDTO> listTI = new ArrayList<>();
//        ArrayList<Integer> listInt = new ArrayList<>();
//        boolean check = false;
//
////        ArrayList<ThuePhongDTO> listTP = new ArrayList<>();
////        ArrayList<PhongDTO> listP = new ArrayList<>();
//
//        public DatPhong() {
//            initComponents();
//        }
//
//        public void initComponents() {
//            rbNgay.setSelected(true);
////            timeNgayTra.setEnable(false);
//            setLayout(new BorderLayout(5, 5));
//            add(pnCenter, BorderLayout.CENTER);
//            add(pnBottom, BorderLayout.SOUTH);
//
//            pnCenter.setLayout(new GridLayout(2, 1));
//            pnCenter.add(pnCenterTop);
//
//            pnCenterTop.setLayout(new BorderLayout());
//            pnCenterTop.add(pnCenterTopLeft, BorderLayout.WEST);
//            pnCenterTopLeft.setLayout(new BorderLayout());
//
//            lbCenterTopLeft.setFont(sgUI15);
//            lbCenterTopLeft.setBackground(Color.decode("#F0FFF0"));
//            lbCenterTopLeft.setOpaque(true);
//            lbCenterTopLeft.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
//
//            pnCenterTopLeftContent.setLayout(new GridLayout(6, 1));
//            pnCenterTopLeftContent.setBackground(Color.white);
//            pnCenterTopLeftContent.add(pnHinhThuc);
//            pnCenterTopLeftContent.add(pnNgayThue);
//            pnCenterTopLeftContent.add(pnTimeThue);
//            pnCenterTopLeftContent.add(pnNgayTra);
//            pnCenterTopLeftContent.add(pnTimeTra);
//            pnCenterTopLeftContent.add(pnBtn);
//
//            pnHinhThuc.setLayout(new BorderLayout());
//            pnHinhThuc.setBackground(Color.white);
//            pnHinhThuc.add(lbHinhThuc, BorderLayout.NORTH);
//            pnHinhThuc.add(pnHT, BorderLayout.CENTER);
//            pnHT.setLayout(new GridLayout(1, 2));
//            pnHT.add(rbNgay);
//            pnHT.add(rbGio);
//
//            bgHT.add(rbNgay);
//            bgHT.add(rbGio);
//
//            pnNgayThue.setLayout(new BorderLayout());
//            pnNgayThue.setBackground(Color.white);
//            pnNgayThue.add(lbNgayThue, BorderLayout.NORTH);
//            pnNgayThue.add(dateNgayThue, BorderLayout.CENTER);
//
//            pnNgayTra.setLayout(new BorderLayout());
//            pnNgayTra.setBackground(Color.white);
//            pnNgayTra.add(lbNgayTra, BorderLayout.NORTH);
//            pnNgayTra.add(dateNgayTra, BorderLayout.CENTER);
//
//            pnTimeThue.setLayout(new BorderLayout());
//            pnTimeThue.setBackground(Color.white);
//            pnTimeThue.add(lbTimeThue, BorderLayout.NORTH);
////            pnTimeThue.add(timeNgayThue, BorderLayout.CENTER);
//
//            pnTimeTra.setLayout(new BorderLayout());
//            pnTimeTra.setBackground(Color.white);
//            pnTimeTra.add(lbTimeTra, BorderLayout.NORTH);
////            pnTimeTra.add(timeNgayTra, BorderLayout.CENTER);
//            rbGio.setBackground(Color.white);
//            rbNgay.setBackground(Color.white);
//
//            pnBtn.setBackground(Color.white);
//            pnBtn.setLayout(new BorderLayout());
//            pnBtn.add(pnRight, BorderLayout.EAST);
//            pnRight.setLayout(new BorderLayout());
//            pnRight.add(btnSelectPhong, BorderLayout.CENTER);
//            pnRight.setBorder(new EmptyBorder(16, 8, 0, 0));
//            pnRight.setBackground(Color.white);
//
//            btnSelectPhong.setFocusPainted(false);
//            btnSelectPhong.setBackground(Color.decode("#98FB98"));
//            btnSelectPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(2, 2, 2, 2, Color.decode("#90EE90"))));
//            btnSelectPhong.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    btnSelectPhong.setBackground(new Color(152, 251, 130));
//                    btnSelectPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(4, 4, 1, 1, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    btnSelectPhong.setBackground(Color.decode("#98FB98"));
//                    btnSelectPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(2, 2, 2, 2, Color.decode("#90EE90"))));
//                }
//            });
//
//            pnCenterTopLeft.setBorder(new EmptyBorder(5, 5, 5, 5));
//            pnCenterTopLeft.setBackground(Color.white);
//            pnCenterTopLeft.add(lbCenterTopLeft, BorderLayout.NORTH);
//            pnCenterTopLeft.add(pnCenterTopLeftContent, BorderLayout.CENTER);
//            pnCenterTop.add(pnCenterTopContent, BorderLayout.CENTER);
//
//            pnCenterTopContent.setLayout(new BorderLayout());
//            pnCenterTopContent.add(pnSelectPhong, BorderLayout.CENTER);
//            pnCenterTopContent.add(pnTienIch, BorderLayout.EAST);
//
//            pnSelectPhong.setBackground(Color.white);
//            pnSelectPhong.setLayout(new BorderLayout());
//            pnSelectPhong.add(lbSelectPhong, BorderLayout.NORTH);
//            //=====================================================================
//            pnSelectPhong.add(pnSelectPhongContent, BorderLayout.CENTER);
//            pnSelectPhongContent.setLayout(new BorderLayout());
//            pnSelectPhongContent.add(pnSelectPhongContentTop, BorderLayout.NORTH);
//            pnSelectPhongContentTop.setBorder(new EmptyBorder(5, 0, 5, 0));
//            pnSelectPhongContentTop.setBackground(Color.white);
//            pnSelectPhongContentTop.setLayout(new GridLayout(1, 4));
//            pnSelectPhongContentTop.add(ckbVip);
//            pnSelectPhongContentTop.add(ckbThuong);
//            pnSelectPhongContentTop.add(cbGia);
//            pnSelectPhongContentTop.add(pnBtnReset);
//            pnBtnReset.setBackground(Color.white);
//            pnBtnReset.setLayout(new BorderLayout());
//            pnBtnReset.add(btnReset, BorderLayout.CENTER);
//            pnBtnReset.setBorder(new EmptyBorder(0, 20, 0, 0));
//            ckbThuong.setFocusPainted(false);
//            ckbVip.setFocusPainted(false);
//            btnReset.setFocusPainted(false);
//            ckbVip.setBackground(Color.white);
//            ckbThuong.setBackground(Color.white);
//            cbGia.setBackground(Color.white);
//            String item[] = {"Chọn giá", "0 đến 300000", "300000 đến 500000", "500000 đến 1500000", "1500000 đến 5000000", "Trên 5000000"};
//            for (String str : item) {
//                cbGia.addItem(str);
//            }
//            cbGia.setFont(sgUI13);
//
//            pnSelectPhongContent.add(pnSelectPhongContentBottom, BorderLayout.CENTER);
//            pnSelectPhongContentBottom.setLayout(new BorderLayout());
//            pnSelectPhongContentBottom.add(pnContentTop, BorderLayout.CENTER);
//            pnContentTop.setLayout(new BorderLayout());
//            pnContentTop.add(scp, BorderLayout.CENTER);
//            scp.getViewport().setBackground(Color.white);
//            scp.setViewportView(tbPhong);
//            pnSelectPhongContentBottom.add(pnContentBottom, BorderLayout.SOUTH);
//            pnContentBottom.setLayout(new BorderLayout());
//            pnContentBottom.setBackground(Color.white);
//            pnContentBottom.add(pnBtnSelectPhong, BorderLayout.EAST);
//            pnBtnSelectPhong.setBorder(new EmptyBorder(5, 0, 0, 0));
//            pnBtnSelectPhong.setBackground(Color.white);
//            pnBtnSelectPhong.setLayout(new BorderLayout());
//            pnBtnSelectPhong.add(btnAcept, BorderLayout.CENTER);
//            btnAcept.setFocusPainted(false);
//            btnAcept.setBackground(Color.decode("#98FB98"));
//            btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
//            btnAcept.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    btnAcept.setBackground(new Color(152, 251, 130));
//                    btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    btnAcept.setBackground(Color.decode("#98FB98"));
//                    btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
//                }
//            });
//            btnAcept.setPreferredSize(new Dimension(100, 30));
//            //=====================================================================
//            pnSelectPhong.setBorder(new EmptyBorder(5, 0, 5, 5));
//            lbSelectPhong.setFont(sgUI15);
//            lbSelectPhong.setBackground(Color.decode("#F0FFF0"));
//            lbSelectPhong.setOpaque(true);
//            lbSelectPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
//
//            pnTienIch.setLayout(new BorderLayout());
//            pnTienIch.setBackground(Color.white);
//            pnTienIch.setBorder(new EmptyBorder(5, 0, 5, 5));
//            pnTienIch.add(lbTienIch, BorderLayout.NORTH);
//            pnTienIch.add(scpTI, BorderLayout.CENTER);
//            scpTI.getViewport().setBackground(Color.white);
//            scpTI.setViewportView(tbTI);
//            renderTI(tbTI);
//            lbTienIch.setFont(sgUI15);
//            lbTienIch.setBackground(Color.decode("#F0FFF0"));
//            lbTienIch.setOpaque(true);
//            lbTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
//
//            rbGio.setFocusPainted(false);
//            rbNgay.setFocusPainted(false);
//
//            pnCenter.add(pnCenterBottom);
//            pnCenterBottom.setLayout(new BorderLayout());
//
//            pnCenterBottom.add(lbCenterBottom, BorderLayout.NORTH);
//            pnCenterBottom.setBorder(new EmptyBorder(5, 5, 5, 5));
//            pnCenterBottom.setBackground(Color.white);
//            lbCenterBottom.setFont(sgUI15);
//            lbCenterBottom.setBackground(Color.decode("#F0FFF0"));
//            lbCenterBottom.setOpaque(true);
//            lbCenterBottom.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
//            pnCenterBottom.add(scpDatPhong, BorderLayout.CENTER);
//            scpDatPhong.getViewport().setBackground(Color.white);
//            scpDatPhong.setViewportView(tbDatPhong);
////            renderDatPhong(tbDatPhong);
//
//            pnBottom.setLayout(new BorderLayout());
//            pnBottom.add(pnbtn, BorderLayout.EAST);
//            pnBottom.setBorder(new EmptyBorder(5, 5, 5, 5));
//            pnbtn.setLayout(new BorderLayout());
//            pnbtn.add(btnSave, BorderLayout.CENTER);
//            pnBottom.setBackground(Color.white);
//            pnbtn.setBackground(Color.white);
//            btnSave.setPreferredSize(new Dimension(100, 30));
//
//            btnReset.setFocusPainted(false);
//            btnReset.setBackground(Color.decode("#B2FFFF"));
//            btnReset.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#30D5C8")), new MatteBorder(1, 2, 1, 1, Color.decode("#40E0D0"))));
//            btnReset.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    btnReset.setBackground(Color.decode("#e0ffff"));
//                    btnReset.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#30D5C8")), new MatteBorder(1, 1, 1, 1, Color.decode("#40E0D0"))));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    btnReset.setBackground(Color.decode("#B2FFFF"));
//                    btnReset.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#30D5C8")), new MatteBorder(1, 2, 1, 1, Color.decode("#40E0D0"))));
//                }
//            });
//            scp.getVerticalScrollBar().setBackground(Color.lightGray);
//            ScrollBarUI yourUI = new BasicScrollBarUI() {
//                @Override
//                protected JButton createDecreaseButton(int orientation) {
//                    JButton button = super.createDecreaseButton(orientation);
//                    button.setBackground(Color.white);
//                    return button;
//                }
//
//                @Override
//                protected JButton createIncreaseButton(int orientation) {
//                    JButton button = super.createIncreaseButton(orientation);
//                    button.setBackground(Color.white);
//                    return button;
//                }
//            };
//            scp.getVerticalScrollBar().setUI(yourUI);
//
//            tbPhong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//                @Override
//                public void valueChanged(ListSelectionEvent e) {
//                    try {
//                        check = true;
//                        String maP = tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString();
////                        listTI = TienIchBUS.getListTienIchCTTI(maP, listInt);
//                        renderTI(tbTI);
//                    } catch (Exception ex) {
//                    }
//                }
//            });
//
//            btnAcept.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
////                    if (check) {
////                        int checkcount = 0;
////                        for (PhongDTO x : listP) {
////                            if (x.getMaP().equals(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString())) {
////                                checkcount++;
////                                break;
////                            }
////                        }
////                        if (checkcount == 0) {
////                            ThuePhongDTO thuePhong = new ThuePhongDTO();
////                            thuePhong.setMaChiTietThue(txtMaCTT.getText());
////                            thuePhong.setMaP(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString());
////                            if (rbNgay.isSelected()) {
////                                thuePhong.setLoaiHinhThue("Theo Ngày");
////                            } else {
////                                thuePhong.setLoaiHinhThue("Theo Giờ");
////                            }
////                            LocalDate ThueDate = LocalDate.of(dateNgayThue.getDate().getYear() + 1900, dateNgayThue.getDate().getMonth() + 1, dateNgayThue.getDate().getDate());
////                            LocalTime ThueTime = LocalTime.of(timeNgayThue.getHour(), timeNgayThue.getMinute(), 0);
////                            LocalDateTime ldtThue = LocalDateTime.of(ThueDate, ThueTime);
////
////                            LocalDate TraDate = LocalDate.of(dateNgayTra.getDate().getYear() + 1900, dateNgayTra.getDate().getMonth() + 1, dateNgayTra.getDate().getDate());
////                            LocalTime TraTime = LocalTime.of(timeNgayTra.getHour(), timeNgayTra.getMinute(), 0);
////                            LocalDateTime ldtTra = LocalDateTime.of(TraDate, TraTime);
////                            int gia = Integer.parseInt(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Giá phòng")).toString());
////                            if (rbNgay.isSelected()) {
////                                int day = ldtTra.compareTo(ldtThue);
////                                thuePhong.setGia(day * gia);
////                            } else {
////                                long hourCount = ChronoUnit.HOURS.between(ldtThue, ldtTra);
////                                long day = hourCount / 24;
////                                long hour = hourCount % 24;
////                                if (hour == 1) {
////                                    thuePhong.setGia((int) (gia * 45 / 100 + day * gia));
////                                } else if (hour == 2) {
////                                    thuePhong.setGia((int) ((gia * 45 / 100 - 20000) + day * gia));
////                                } else if (hour == 3) {
////                                    thuePhong.setGia((int) ((gia * 45 / 100 - 40000) + day * gia));
////                                } else if (hour >= 4 && hour <= 12) {
////                                    thuePhong.setGia((int) ((gia / 2) + day * gia));
////                                } else {
////                                    thuePhong.setGia((int) (day * gia + gia));
////                                }
////                            }
////                            thuePhong.setXuLy(0);
////                            thuePhong.setNgayCheckOut((ldtTra + ":00").replace("T", " "));
////                            thuePhong.setNgayThue((ldtThue + ":00").replace("T", " "));
////                            thuePhong.setNgayTra((ldtTra + ":00").replace("T", " "));
////                            thuePhong.setTinhTrang(0);
////                            listTP.add(thuePhong);
////                            PhongDTO phong = new PhongDTO();
////                            phong.setMaP(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Mã phòng")).toString());
////                            phong.setTenP(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Tên phòng")).toString());
////                            phong.setTinhTrang("Trống");
////                            phong.setXuLy(0);
////                            phong.setGiaP(gia);
////                            phong.setLoaiP(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Loại phòng")).toString());
////                            phong.setHienTrang(tbPhong.getValueAt(tbPhong.getSelectedRow(), tbPhong.getColumnModel().getColumnIndex("Hiện trạng")).toString());
////                            listP.add(phong);
////                            renderDatPhong(tbDatPhong);
////                            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                            listPhong.clear();
////                            renderPhong(tbPhong, listPhong);
////                            listTI.clear();
////                            listInt.clear();
////                            renderTI(tbTI);
////                            dateNgayThue.setCalendar(null);
////                            dateNgayTra.setCalendar(null);
////                            check = false;
////                        } else {
////                            JOptionPane.showMessageDialog(null, "Phòng này đã có trong danh sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
////                        }
////                    } else {
////                        JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng muốn đặt", "Thông báo", JOptionPane.ERROR_MESSAGE);
////                    }
//                }
//            });
//
//            tbDatPhong.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    if (e.getButton() == MouseEvent.BUTTON3) {
//                        JPopupMenu pm = new JPopupMenu();
//                        JMenuItem item = new JMenuItem("Xoá");
//                        pm.add(item);
//                        pm.show(tbDatPhong, e.getX(), e.getY());
//                        item.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                try {
//                                    int row = tbDatPhong.getSelectedRow();
////                                    listTP.remove(row);
////                                    listP.remove(row);
////                                    renderDatPhong(tbDatPhong);
//                                } catch (Exception ex) {
//                                    JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                }
//                            }
//                        });
//                    }
//                }
//            });
//
//            btnSave.setFocusPainted(false);
//            btnSave.setBackground(Color.decode("#98FB98"));
//            btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
//            btnSave.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    btnSave.setBackground(new Color(152, 251, 130));
//                    btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    btnSave.setBackground(Color.decode("#98FB98"));
//                    btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
//                }
//            });
//            btnSave.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    int count = 0;
////                    if (listTP.size() != 0) {
////                        for (ThuePhongDTO x : listTP) {
////                            LocalDate ld = LocalDate.now();
//////                            if (x.getNgayThue().contains(ld.toString())) {
//////                                if (!PhongBUS.updateTT(x.getMaP(), "Đang được thuê")) {
//////                                    count++;
//////                                }
//////                                x.setTinhTrang(1);
//////                            }
////                            if (!ThuePhongBUS.insertTP(x)) {
////                                count++;
////                            }
////                        }
////                        if (count == 0) {
////                            JOptionPane.showMessageDialog(null, "Thêm thành công phòng thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                            listTP.clear();
////                            listP.clear();
////                            renderDatPhong(tbDatPhong);
////                            listPhong.clear();
////                            listTI.clear();
////                            listInt.clear();
////                            dateNgayThue.setCalendar(null);
////                            dateNgayTra.setCalendar(null);
////                            renderPhong(tbPhong, listPhong);
////                            renderTI(tbTI);
////                        } else {
////                            JOptionPane.showMessageDialog(null, "Thêm không thành công phòng thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                        }
////                    } else {
////                        JOptionPane.showMessageDialog(null, "Vui lòng thêm phòng cần thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                    }
//                }
//            });
//            ///////////////////////////////////////////////////////////
//            btnSelectPhong.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
////                    if (dateNgayThue.getDate() == null) {
////                        JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                    } else {
////                        if (dateNgayTra.getDate() == null) {
////                            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày trả");
////                        } else {
////                            if (rbNgay.isSelected()) {
////                                timeNgayTra.setHour(timeNgayThue.getHour());
////                                timeNgayTra.setMinute(timeNgayThue.getMinute());
////                                int hour = 0;
////                                if (timeNgayThue.getHour() == 24) {
////                                    hour = 0;
////                                } else {
////                                    hour = timeNgayThue.getHour();
////                                }
////                                LocalDate ThueDate = LocalDate.of(dateNgayThue.getDate().getYear() + 1900, dateNgayThue.getDate().getMonth() + 1, dateNgayThue.getDate().getDate());
////                                LocalTime ThueTime = LocalTime.of(hour, timeNgayThue.getMinute(), 0);
////                                LocalDateTime ldtThue = LocalDateTime.of(ThueDate, ThueTime);
////
////                                int hourTra = 0;
////                                if (timeNgayTra.getHour() == 24) {
////                                    hourTra = 0;
////                                } else {
////                                    hourTra = timeNgayTra.getHour();
////                                }
////                                LocalDate TraDate = LocalDate.of(dateNgayTra.getDate().getYear() + 1900, dateNgayTra.getDate().getMonth() + 1, dateNgayTra.getDate().getDate());
////                                LocalTime TraTime = LocalTime.of(hourTra, timeNgayTra.getMinute(), 0);
////                                LocalDateTime ldtTra = LocalDateTime.of(TraDate, TraTime);
////
////                                LocalDateTime ldtNow = LocalDateTime.now();
////                                if (ldtThue.isAfter(ldtNow)) {
////                                    if (ldtTra.isAfter(ldtThue)) {
////                                        //2023-04-30T20:00
//////                                        listPhong.clear();
//////                                        String dateThue = ldtThue.toString().replace("T", " ");
//////                                        dateThue += ":00";
//////
//////                                        String dateTra = ldtTra.toString().replace("T", " ");
//////                                        dateTra += ":00";
//////                                        for (PhongDTO x : PhongBUS.getListPhong(dateThue, dateTra)) {
//////                                            listPhong.add(x);
//////                                        }
//////                                        renderPhong(tbPhong, listPhong);
////                                    } else {
////                                        JOptionPane.showMessageDialog(null, "Ngày, giờ trả phải lớn hơn ngày, giờ thuê");
////                                        dateNgayTra.setCalendar(null);
////                                    }
////                                } else {
////                                    JOptionPane.showMessageDialog(null, "Ngày, giờ thuê phải lớn hơn ngày, giờ hiện tại");
////                                    dateNgayThue.setCalendar(null);
////                                }
////                            } else {
////                                timeNgayTra.setEnable(true);
////                                LocalDate ThueDate = LocalDate.of(dateNgayThue.getDate().getYear() + 1900, dateNgayThue.getDate().getMonth() + 1, dateNgayThue.getDate().getDate());
////                                int hour = 0;
////                                if (timeNgayThue.getHour() == 24) {
////                                    hour = 0;
////                                } else {
////                                    hour = timeNgayThue.getHour();
////                                }
////                                LocalTime ThueTime = LocalTime.of(hour, timeNgayThue.getMinute(), 0);
////                                LocalDateTime ldtThue = LocalDateTime.of(ThueDate, ThueTime);
////
////                                int hourTra = 0;
////                                if (timeNgayTra.getHour() == 24) {
////                                    hourTra = 0;
////                                } else {
////                                    hourTra = timeNgayTra.getHour();
////                                }
////                                LocalDate TraDate = LocalDate.of(dateNgayTra.getDate().getYear() + 1900, dateNgayTra.getDate().getMonth() + 1, dateNgayTra.getDate().getDate());
////                                LocalTime TraTime = LocalTime.of(hourTra, timeNgayTra.getMinute(), 0);
////                                LocalDateTime ldtTra = LocalDateTime.of(TraDate, TraTime);
////
////                                LocalDateTime ldtNow = LocalDateTime.now();
////                                if (ldtThue.isAfter(ldtNow)) {
////                                    if (ldtTra.isAfter(ldtThue)) {
////                                        long hourCount = ChronoUnit.HOURS.between(ldtThue, ldtTra);
////                                        long dayCount = ChronoUnit.DAYS.between(ldtThue, ldtTra);
////                                        if (hourCount == 0) {
////                                            JOptionPane.showMessageDialog(null, "Phải thuê ít nhất 1h");
////                                        } else {
//////                                            listPhong.clear();
//////                                            String dateThue = ldtThue.toString().replace("T", " ");
//////                                            dateThue += ":00";
//////                                            String dateTra = ldtTra.toString().replace("T", " ");
//////                                            dateTra += ":00";
//////                                            for (PhongDTO x : PhongBUS.getListPhong(dateThue, dateTra)) {
//////                                                listPhong.add(x);
//////                                            }
//////                                            renderPhong(tbPhong, listPhong);
////                                        }
////                                    } else {
////                                        JOptionPane.showMessageDialog(null, "Ngày, giờ trả phải lớn hơn ngày, giờ thuê");
////                                        dateNgayTra.setCalendar(null);
////                                    }
////                                } else {
////                                    JOptionPane.showMessageDialog(null, "Ngày, giờ thuê phải lớn hơn ngày, giờ hiện tại");
////                                    dateNgayThue.setCalendar(null);
////                                }
////                            }
////                        }
////                    }
////                }
////            });
//
////            rbNgay.addItemListener(new ItemListener() {
////                @Override
////                public void itemStateChanged(ItemEvent e) {
////                    if (rbNgay.isSelected()) {
////                        timeNgayTra.setEnable(false);
////                    } else {
////                        timeNgayTra.setEnable(true);
////                    }
////                }
////            });
//            ///////////////////////////////////////////////////////////
//        }
//
//        public void renderTI(JTable tb) {
//            DefaultTableModel dtm = new DefaultTableModel();
//            dtm.addColumn("STT");
//            dtm.addColumn("Mã tiện ích");
//            dtm.addColumn("Tên tiện ích");
//            dtm.addColumn("Số lượng");
//            tb.setModel(dtm);
////            new Thread(() -> {
////                int i = 0;
////                for (TienIchDTO x : listTI) {
////                    try {
////                        Object row[] = {i + 1, x.getMaTienIch(), x.getTenTienIch(), listInt.get(i)};
////                        dtm.addRow(row);
////                    } catch (Exception e) {
////                    }
////                    tb.setShowGrid(false);
////                    tb.setIntercellSpacing(new Dimension(0, 0));
////                    tb.setRowHeight(30);
////                    tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
////                    tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("Mã tiện ích")).setPreferredWidth(50);
////                    tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
////                    tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
////                    tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////                    tb.getTableHeader().setBackground(Color.decode("#33CC33"));
////                    DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
////                        @Override
////                        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
////                            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
////                            JLabel lb = (JLabel) c;
////
////                            lb.setHorizontalAlignment(JLabel.CENTER);
////                            if (isSelected) {
////                                lb.setBackground(Color.decode("#F5F5F5"));
////                            } else {
////                                lb.setBackground(Color.decode("#FFFFFF"));
////                            }
////                            if (column == 0) {
////                                lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
////                                lb.setBackground(Color.decode("#99FF99"));
////                            } else {
////                                lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
////                            }
////                            return lb;
////                        }
////                    };
////                    for (int j = 0; j < tb.getColumnCount(); j++) {
////                        tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
////                    }
////                    tb.setModel(dtm);
////                    i++;
////                    try {
////                        Thread.sleep(50);
////                    } catch (Exception e) {
////                    }
////                }
////            }).start();
//        }
//
////        public void renderPhong(JTable tb, ArrayList<PhongDTO> listPhong) {
////            DefaultTableModel dtm = new DefaultTableModel();
////            dtm.addColumn("STT");
////            dtm.addColumn("Mã phòng");
////            dtm.addColumn("Tên phòng");
////            dtm.addColumn("Loại phòng");
////            dtm.addColumn("Giá phòng");
////            dtm.addColumn("Hiện trạng");
////            int i = 1;
////            for (PhongDTO x : listPhong) {
////                Object data[] = {i, x.getMaP(), x.getTenP(), x.getLoaiP(), x.getGiaP(), x.getHienTrang()};
////                dtm.addRow(data);
////                i++;
////            }
////            tb.setModel(dtm);
////            tb.setShowGrid(false);
////            tb.setIntercellSpacing(new Dimension(0, 0));
////            tb.setRowHeight(30);
////            tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
////            tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(50);
////            tb.getColumnModel().getColumn(tb.getColumnModel().getColumnIndex("Loại phòng")).setPreferredWidth(45);
////            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
////            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
////            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
////                @Override
////                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
////                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
////                    JLabel lb = (JLabel) c;
////                    if (isSelected) {
////                        lb.setBackground(Color.decode("#F5F5F5"));
////                    } else {
////                        lb.setBackground(Color.decode("#FFFFFF"));
////                    }
////                    if (column == tb.getColumnModel().getColumnIndex("STT")) {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
////                        lb.setBackground(Color.decode("#99FF99"));
////                    } else {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
////                    }
////                    if (column == tb.getColumnModel().getColumnIndex("Tên phòng")) {
////                        lb.setHorizontalAlignment(JLabel.LEFT);
////                        lb.setBorder(new EmptyBorder(0, 5, 0, 0));
////                    } else {
////                        lb.setHorizontalAlignment(JLabel.CENTER);
////                        lb.setBorder(new EmptyBorder(0, 0, 0, 0));
////                    }
////                    return lb;
////                }
////            };
////            for (int j = 0; j < tb.getColumnCount(); j++) {
////                tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
////            }
////        }
////
////        public String date(String date) {
////            String d1[] = date.split("-");
////            String d2[] = d1[2].split(" ");
////            String date1 = d2[0] + "-" + d1[1] + "-" + d1[0] + " " + d2[1];
////            return date1;
////        }
//
//        public void renderDatPhong(JTable tb) {
//            DefaultTableModel dtm = new DefaultTableModel();
//            dtm.addColumn("STT");
//            dtm.addColumn("Mã phòng");
//            dtm.addColumn("Tên phòng");
//            dtm.addColumn("Tình trạng");
//            dtm.addColumn("Loại hình thuê");
//            dtm.addColumn("Ngày thuê");
//            dtm.addColumn("Ngày trả");
//            dtm.addColumn("Giá phòng");
//            dtm.addColumn("Giá thực");
//            int i = 0;
////            for (ThuePhongDTO x : listTP) {
////                Object data[] = {i + 1, x.getMaP(), listP.get(i).getTenP(), "Đang xử lý", x.getLoaiHinhThue(), date(x.getNgayThue()), date(x.getNgayTra()), listP.get(i).getGiaP(), x.getGia()};
////                dtm.addRow(data);
////                i++;
////            }
//            tb.setModel(dtm);
//            tb.setShowGrid(false);
//            tb.setIntercellSpacing(new Dimension(0, 0));
//            tb.setRowHeight(30);
//            tb.getColumnModel().getColumn(0).setPreferredWidth(5);
//            tb.getColumnModel().getColumn(1).setPreferredWidth(50);
//            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
//            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
//            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
//                @Override
//                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                    JLabel lb = (JLabel) c;
//                    if (isSelected) {
//                        lb.setBackground(Color.decode("#F5F5F5"));
//                    } else {
//                        lb.setBackground(Color.decode("#FFFFFF"));
//                    }
//                    if (column == tb.getColumnModel().getColumnIndex("STT")) {
//                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
//                        lb.setBackground(Color.decode("#99FF99"));
//                    } else {
//                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
//                    }
//                    if (column == tb.getColumnModel().getColumnIndex("Tên phòng")) {
//                        lb.setHorizontalAlignment(JLabel.LEFT);
//                        lb.setBorder(new EmptyBorder(0, 5, 0, 0));
//                    } else {
//                        lb.setHorizontalAlignment(JLabel.CENTER);
//                        lb.setBorder(new EmptyBorder(0, 0, 0, 0));
//                    }
//                    return lb;
//                }
//            };
//            for (int j = 0; j < tb.getColumnCount(); j++) {
//                tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
//            }
//        }
////@@@@@@@@@@@@@ dich vu @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//
////    class DichVu extends JPanel {
////
////        JPanel pnCenter = new JPanel();
////        JPanel pnBottom = new JPanel();
////        JPanel pnBtn = new JPanel();
////        JButton btnSave = new JButton("Lưu");
////        JPanel pnCenterTop = new JPanel();
////        JPanel pnCenterBottom = new JPanel();
////        JLabel lbCenterBottom = new JLabel("Danh sách dịch vụ đang xử lý");
////        JPanel pnDichVu = new JPanel();
////        JPanel pnDichVuRight = new JPanel();
////        JScrollPane scpDV = new JScrollPane();
////        JTable tbDV = new JTable();
////        JPanel pnMaDV = new JPanel();
////        JPanel pnTenDV = new JPanel();
////        JPanel pnSLDV = new JPanel();
////        JPanel pnNgaySuDung = new JPanel();
////        JPanel pnBtnDichVu = new JPanel();
////
////        JLabel lbMaDV = new JLabel("Mã dịch vụ:");
////        JLabel lbTenDV = new JLabel("Tên dịch vụ:");
////        JLabel lbSLDV = new JLabel("Số lượng dịch vụ:");
////        JLabel lbNgaySuDung = new JLabel("Ngày sử dụng:");
////        JLabel lbBtnDichVu = new JLabel("Chức năng:");
////
////        JTextField txtMaDV = new JTextField();
////        JTextField txtTenDV = new JTextField();
////        JTextField txtSLDV = new JTextField();
////        JDateChooser dateNgaySuDung = new JDateChooser();
////        JPanel pnBtnFun = new JPanel();
////        JButton btnUpdateDV = new JButton("Sửa");
////        JButton btnDeleteDV = new JButton("Xóa");
////        JLabel lbDichVuRight = new JLabel("Chỉnh sửa dịch vụ:               ");
////        JPanel pnEdit = new JPanel();
////        JPanel pnCenterTopLeft = new JPanel();
////        JLabel lbCenterTopLeft = new JLabel("Chi tiết thuê dịch vụ                 ");
////        JPanel pnCenterTopLeftContent = new JPanel();
////        JPanel pnmadv = new JPanel();
////        JPanel pntendv = new JPanel();
////        JPanel pndongia = new JPanel();
////        JPanel pnsldv = new JPanel();
////        JPanel pndatesudung = new JPanel();
////        JPanel pnAcept = new JPanel();
////
////        JLabel lbmadv = new JLabel("Mã dịch vụ:");
////        JLabel lbtendv = new JLabel("Tên dịch vụ:");
////        JLabel lbdongia = new JLabel("Đơn giá:");
////        JLabel lbsldv = new JLabel("Số lượng:");
////        JLabel lbdatesudung = new JLabel("Ngày sử dụng:");
////        JLabel lbAcept = new JLabel("Chức năng");
////
////        JTextField txtmadv = new JTextField();
////        JTextField txttendv = new JTextField();
////        JTextField txtdongia = new JTextField();
////        JTextField txtsldv = new JTextField();
////        JDateChooser datesudung = new JDateChooser();
////        JButton btnAcept = new JButton("Thuê dịch vụ");
////        JPanel pnCenterTopCenter = new JPanel();
////        JLabel lbCenterTopCenter = new JLabel("Danh sách dịch vụ hiện có");
////        JPanel pnDichVuContent = new JPanel();
////        JPanel pnDichVuTop = new JPanel();
////        JPanel pnDichVuBottom = new JPanel();
////        JCheckBox ckbAnUong = new JCheckBox("Ăn uống");
////        JCheckBox ckbSacDep = new JCheckBox("Chăm sóc sắc đẹp");
////        JCheckBox ckbGiaiTri = new JCheckBox("Giải trí");
////        JCheckBox ckbTienIch = new JCheckBox("Tiện ích");
////        JCheckBox ckbTiec = new JCheckBox("Tổ chức tiệc");
////        JTextField txtSearch = new JTextField("Tìm kiếm dich vụ...");
////        JScrollPane scpDVAll = new JScrollPane();
////        JTable tbDVAll = new JTable();
////        JPanel pnBtnReset = new JPanel();
////        JButton btnReset = new JButton("Làm mới");
//////        ArrayList<DichVuDTO> listDV = new ArrayList<>();
//////        ArrayList<SuDungDichVuDTO> listSDDV = new ArrayList<>();
//////        ArrayList<DichVuDTO> listdv = new ArrayList<>();
////
////        public DichVu() {
////            initComponents();
////        }
////
////        public void initComponents() {
//////            listDV = DichVuBUS.getListDV();
////            setLayout(new BorderLayout(5, 5));
////            add(pnCenter, BorderLayout.CENTER);
////            add(pnBottom, BorderLayout.SOUTH);
////            pnBottom.setLayout(new BorderLayout());
////            pnBottom.add(pnBtn, BorderLayout.EAST);
////            pnBottom.setBackground(Color.white);
////            pnBtn.setLayout(new BorderLayout());
////            pnBtn.setBorder(new EmptyBorder(5, 5, 5, 5));
////            pnBtn.add(btnSave, BorderLayout.CENTER);
////            pnBtn.setBackground(Color.white);
////            btnSave.setPreferredSize(new Dimension(100, 30));
////            btnSave.setFocusPainted(false);
////            btnSave.setBackground(Color.decode("#98FB98"));
////            btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
////            btnSave.addMouseListener(new MouseAdapter() {
////                @Override
////                public void mouseEntered(MouseEvent e) {
////                    btnSave.setBackground(new Color(152, 251, 130));
////                    btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
////                }
////
////                @Override
////                public void mouseExited(MouseEvent e) {
////                    btnSave.setBackground(Color.decode("#98FB98"));
////                    btnSave.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
////                }
////            });
////            pnCenter.setLayout(new GridLayout(2, 1));
////            pnCenter.add(pnCenterTop);
////
////            lbCenterTopLeft.setFont(sgUI15);
////            lbCenterTopLeft.setBackground(Color.decode("#F0FFF0"));
////            lbCenterTopLeft.setOpaque(true);
////            lbCenterTopLeft.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
////            pnCenterTop.setLayout(new BorderLayout());
////            pnCenterTop.add(pnCenterTopLeft, BorderLayout.WEST);
////            pnCenterTopLeft.setLayout(new BorderLayout());
////            pnCenterTopLeft.setBorder(new EmptyBorder(5, 5, 5, 5));
////            pnCenterTopLeft.setBackground(Color.white);
////            pnCenterTopLeft.add(lbCenterTopLeft, BorderLayout.NORTH);
////            pnCenterTopLeft.add(pnCenterTopLeftContent, BorderLayout.CENTER);
////
////            pnCenterTopLeftContent.setLayout(new GridLayout(6, 1));
////            pnCenterTopLeftContent.setBackground(Color.white);
////            pnCenterTopLeftContent.add(pnmadv);
////            pnCenterTopLeftContent.add(pntendv);
////            pnCenterTopLeftContent.add(pndongia);
////            pnCenterTopLeftContent.add(pnsldv);
////            pnCenterTopLeftContent.add(pndatesudung);
////            pnCenterTopLeftContent.add(pnAcept);
////
////            btnReset.setFocusPainted(false);
////            btnReset.setBackground(Color.decode("#B2FFFF"));
////            btnReset.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#30D5C8")), new MatteBorder(1, 2, 1, 1, Color.decode("#40E0D0"))));
////            btnReset.addMouseListener(new MouseAdapter() {
////                @Override
////                public void mouseEntered(MouseEvent e) {
////                    btnReset.setBackground(Color.decode("#e0ffff"));
////                    btnReset.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#30D5C8")), new MatteBorder(1, 1, 1, 1, Color.decode("#40E0D0"))));
////                }
////
////                @Override
////                public void mouseExited(MouseEvent e) {
////                    btnReset.setBackground(Color.decode("#B2FFFF"));
////                    btnReset.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#30D5C8")), new MatteBorder(1, 2, 1, 1, Color.decode("#40E0D0"))));
////                }
////            });
////
////            pnmadv.setLayout(new BorderLayout());
////            pnmadv.setBackground(Color.white);
////            pnmadv.add(lbmadv, BorderLayout.NORTH);
////            pnmadv.add(txtmadv, BorderLayout.CENTER);
////
////            pntendv.setLayout(new BorderLayout());
////            pntendv.setBackground(Color.white);
////            pntendv.add(lbtendv, BorderLayout.NORTH);
////            pntendv.add(txttendv, BorderLayout.CENTER);
////
////            pnsldv.setLayout(new BorderLayout());
////            pnsldv.setBackground(Color.white);
////            pnsldv.add(lbsldv, BorderLayout.NORTH);
////            pnsldv.add(txtsldv, BorderLayout.CENTER);
////
////            pndongia.setLayout(new BorderLayout());
////            pndongia.setBackground(Color.white);
////            pndongia.add(lbdongia, BorderLayout.NORTH);
////            pndongia.add(txtdongia, BorderLayout.CENTER);
////
////            pndatesudung.setLayout(new BorderLayout());
////            pndatesudung.setBackground(Color.white);
////            pndatesudung.add(lbdatesudung, BorderLayout.NORTH);
////            pndatesudung.add(datesudung, BorderLayout.CENTER);
////
////            pnAcept.setLayout(new BorderLayout());
////            pnAcept.add(lbAcept, BorderLayout.NORTH);
////            pnAcept.add(btnAcept, BorderLayout.CENTER);
////            pnAcept.setBackground(Color.white);
////
////            btnAcept.setFocusPainted(false);
////            btnAcept.setBackground(Color.decode("#98FB98"));
////            btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
////            btnAcept.addMouseListener(new MouseAdapter() {
////                @Override
////                public void mouseEntered(MouseEvent e) {
////                    btnAcept.setBackground(new Color(152, 251, 130));
////                    btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#32CD32")), new MatteBorder(1, 1, 1, 1, Color.decode("#90EE90"))));
////                }
////
////                @Override
////                public void mouseExited(MouseEvent e) {
////                    btnAcept.setBackground(Color.decode("#98FB98"));
////                    btnAcept.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#32CD32")), new MatteBorder(1, 2, 1, 1, Color.decode("#90EE90"))));
////                }
////            });
////
////            pnCenterTop.add(pnCenterTopCenter, BorderLayout.CENTER);
////            pnCenterTopCenter.setBorder(new EmptyBorder(5, 0, 5, 5));
////            pnCenterTopCenter.setBackground(Color.white);
////            pnCenterTopCenter.setLayout(new BorderLayout());
////            pnCenterTopCenter.add(lbCenterTopCenter, BorderLayout.NORTH);
////            pnCenterTopCenter.add(pnDichVuContent, BorderLayout.CENTER);
////            pnDichVuContent.setLayout(new BorderLayout());
////            pnDichVuContent.add(pnDichVuTop, BorderLayout.NORTH);
////            pnDichVuTop.setBorder(new EmptyBorder(5, 0, 5, 0));
////            pnDichVuTop.setBackground(Color.white);
////            pnDichVuContent.add(pnDichVuBottom, BorderLayout.CENTER);
////            pnDichVuTop.setLayout(new GridLayout(1, 7));
////            pnDichVuTop.add(ckbAnUong);
////            pnDichVuTop.add(ckbSacDep);
////            pnDichVuTop.add(ckbGiaiTri);
////            pnDichVuTop.add(ckbTienIch);
////            pnDichVuTop.add(ckbTiec);
////            pnDichVuTop.add(txtSearch);
////            pnDichVuTop.add(pnBtnReset);
////            pnBtnReset.setLayout(new BorderLayout());
////            pnBtnReset.setBackground(Color.white);
////            pnBtnReset.setBorder(new EmptyBorder(0, 30, 0, 0));
////            pnBtnReset.add(btnReset, BorderLayout.CENTER);
////
////            ckbAnUong.setBackground(Color.white);
////            ckbSacDep.setBackground(Color.white);
////            ckbGiaiTri.setBackground(Color.white);
////            ckbTienIch.setBackground(Color.white);
////            ckbTiec.setBackground(Color.white);
////
////            ckbAnUong.setFocusPainted(false);
////            ckbSacDep.setFocusPainted(false);
////            ckbGiaiTri.setFocusPainted(false);
////            ckbTienIch.setFocusPainted(false);
////            ckbTiec.setFocusPainted(false);
////            txtSearch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////            txtmadv.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////            txttendv.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////            txtsldv.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////            txtdongia.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////
////            pnDichVuBottom.setLayout(new BorderLayout());
////            pnDichVuBottom.add(scpDVAll, BorderLayout.CENTER);
////            scpDVAll.getViewport().setBackground(Color.white);
////            scpDVAll.setViewportView(tbDVAll);
//////            renderDVAll(tbDVAll);
////
////            lbCenterTopCenter.setFont(sgUI15);
////            lbCenterTopCenter.setBackground(Color.decode("#F0FFF0"));
////            lbCenterTopCenter.setOpaque(true);
////            lbCenterTopCenter.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
////
////            pnCenter.add(pnCenterBottom);
////            pnCenterBottom.setBackground(Color.white);
////            pnCenterBottom.setBorder(new EmptyBorder(5, 5, 5, 5));
////            lbCenterBottom.setFont(sgUI15);
////            lbCenterBottom.setBackground(Color.decode("#F0FFF0"));
////            lbCenterBottom.setOpaque(true);
////            lbCenterBottom.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
////            pnCenterBottom.setLayout(new BorderLayout());
////            pnCenterBottom.add(lbCenterBottom, BorderLayout.NORTH);
////            pnCenterBottom.add(pnDichVu, BorderLayout.CENTER);
////            pnDichVu.setLayout(new BorderLayout());
////            pnDichVu.add(scpDV, BorderLayout.CENTER);
////            pnDichVu.add(pnDichVuRight, BorderLayout.EAST);
////            scpDV.getViewport().setBackground(Color.white);
////            scpDV.setViewportView(tbDV);
//////            renderTBDichVu(tbDV);
////
////            pnDichVuRight.setLayout(new BorderLayout());
////            pnDichVuRight.setBackground(Color.white);
////            pnDichVuRight.setBorder(new EmptyBorder(5, 5, 0, 0));
////            pnDichVuRight.add(lbDichVuRight, BorderLayout.NORTH);
////            pnDichVuRight.add(pnEdit, BorderLayout.CENTER);
////            lbDichVuRight.setFont(sgUI15);
////            lbDichVuRight.setBackground(Color.decode("#F0FFF0"));
////            lbDichVuRight.setOpaque(true);
////            lbDichVuRight.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#98FB98")), new EmptyBorder(3, 5, 3, 5)));
////            pnEdit.setLayout(new GridLayout(5, 1));
////            pnEdit.add(pnMaDV);
////            pnEdit.add(pnTenDV);
////            pnEdit.add(pnSLDV);
////            pnEdit.add(pnNgaySuDung);
////            pnEdit.add(pnBtnDichVu);
////
////            pnMaDV.setLayout(new BorderLayout());
////            pnMaDV.setBackground(Color.white);
////            pnMaDV.add(lbMaDV, BorderLayout.NORTH);
////            pnMaDV.add(txtMaDV, BorderLayout.CENTER);
////
////            pnTenDV.setLayout(new BorderLayout());
////            pnTenDV.setBackground(Color.white);
////            pnTenDV.add(lbTenDV, BorderLayout.NORTH);
////            pnTenDV.add(txtTenDV, BorderLayout.CENTER);
////
////            pnSLDV.setLayout(new BorderLayout());
////            pnSLDV.setBackground(Color.white);
////            pnSLDV.add(lbSLDV, BorderLayout.NORTH);
////            pnSLDV.add(txtSLDV, BorderLayout.CENTER);
////
////            pnNgaySuDung.setLayout(new BorderLayout());
////            pnNgaySuDung.setBackground(Color.white);
////            pnNgaySuDung.add(lbNgaySuDung, BorderLayout.NORTH);
////            pnNgaySuDung.add(dateNgaySuDung, BorderLayout.CENTER);
////
////            pnBtnDichVu.setLayout(new BorderLayout());
////            pnBtnDichVu.setBackground(Color.white);
////            pnBtnDichVu.add(lbBtnDichVu, BorderLayout.NORTH);
////            pnBtnDichVu.add(pnBtnFun, BorderLayout.CENTER);
////            pnBtnDichVu.setBackground(Color.white);
////            pnBtnFun.setBackground(Color.white);
////            pnBtnFun.setBorder(new EmptyBorder(5, 5, 0, 5));
////            pnBtnFun.setLayout(new GridLayout(1, 2, 5, 5));
////            pnBtnFun.add(btnUpdateDV);
////            pnBtnFun.add(btnDeleteDV);
////            pnEdit.setBackground(Color.white);
////
////            txtMaDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////            txtTenDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////            txtSLDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 5, 0, 5)));
////
////            btnUpdateDV.setFocusPainted(false);
////            btnUpdateDV.setBackground(Color.decode("#FFD700"));
////            btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
////            btnUpdateDV.addMouseListener(new MouseAdapter() {
////                @Override
////                public void mouseEntered(MouseEvent e) {
////                    btnUpdateDV.setBackground(new Color(255, 200, 0));
////                    btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
////                }
////
////                @Override
////                public void mouseExited(MouseEvent e) {
////                    btnUpdateDV.setBackground(Color.decode("#FFD700"));
////                    btnUpdateDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF8C00")), new MatteBorder(1, 1, 1, 1, Color.decode("#FFA500"))));
////                }
////            });
////
////            btnDeleteDV.setFocusPainted(false);
////            btnDeleteDV.setBackground(Color.decode("#FF7F50"));
////            btnDeleteDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
////            btnDeleteDV.addMouseListener(new MouseAdapter() {
////                @Override
////                public void mouseEntered(MouseEvent e) {
////                    btnDeleteDV.setBackground(Color.decode("#FF7F50"));
////                    btnDeleteDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 3, 2, 2, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
////                }
////
////                @Override
////                public void mouseExited(MouseEvent e) {
////                    btnDeleteDV.setBackground(Color.decode("#FF7F50"));
////                    btnDeleteDV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 4, 4, Color.decode("#FF0000")), new MatteBorder(1, 1, 1, 1, Color.decode("#FF6347"))));
////                }
////            });
////            tbDVAll.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
////                @Override
////                public void valueChanged(ListSelectionEvent e) {
////                    try {
////                        String maDV = tbDVAll.getValueAt(tbDVAll.getSelectedRow(), tbDVAll.getColumnModel().getColumnIndex("Mã dịch vụ")).toString();
////                        String tenDV = tbDVAll.getValueAt(tbDVAll.getSelectedRow(), tbDVAll.getColumnModel().getColumnIndex("Tên dịch vụ")).toString();
////                        String giaDV = tbDVAll.getValueAt(tbDVAll.getSelectedRow(), tbDVAll.getColumnModel().getColumnIndex("Giá")).toString();
////                        txtmadv.setText(maDV);
////                        txttendv.setText(tenDV);
////                        txtdongia.setText(giaDV);
////                    } catch (Exception ex) {
////                    }
////                }
////            });
////            txtmadv.setEditable(false);
////            txttendv.setEditable(false);
////            txtdongia.setEditable(false);
////
////            txtMaDV.setEditable(false);
////            txtTenDV.setEditable(false);
////            dateNgaySuDung.setEnabled(false);
////            tbDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
////                @Override
////                public void valueChanged(ListSelectionEvent e) {
////                    try {
////                        String maDV = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString();
////                        String tenDV = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Tên dịch vụ")).toString();
////                        String date = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Ngày sử dụng")).toString();
////                        txtMaDV.setText(maDV);
////                        txtTenDV.setText(tenDV);
////                        try {
////                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
////                            Date dateStr = sdf.parse(date);
////                            dateNgaySuDung.setDate(dateStr);
////                        } catch (Exception ex) {
////                        }
////                    } catch (Exception ex) {
////                    }
////                }
////            });
//
////            btnSave.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
//
////                    if (listSDDV.size() != 0) {
////                        ArrayList<String> name = new ArrayList<>();
////                        int count = 0;
////                        txtMaDV.setText("");
////                        txtTenDV.setText("");
////                        txtSLDV.setText("");
////                        tbDVAll.clearSelection();
////                        dateNgaySuDung.setCalendar(null);
//////                        for (SuDungDichVuDTO x : listSDDV) {
//////                            if (!SuDungDichVuBUS.insertSDDV(x)) {
//////                                name.add(x.getMaDV());
//////                                count++;
//////                            }
//////                        }
////                        if (count == 0) {
////                            JOptionPane.showMessageDialog(null, "Thêm dịch vụ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//////                            listSDDV.clear();
//////                            listdv.clear();
//////                            renderTBDichVu(tbDV);
////                        } else {
////                            String error = "";
////                            for (String x : name) {
////                                error += x;
////                            }
////                            JOptionPane.showMessageDialog(null, "Những dịch vụ này đã không thuê được" + error, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                            listSDDV.clear();
////                            listdv.clear();
////                            renderTBDichVu(tbDV);
////                        }
////                    }
////                }
////            });
//
////            btnUpdateDV.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    if (txtMaDV.getText().trim().length() != 0) {
////                        if (txtSLDV.getText().trim().length() == 0) {
////                            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng muốn thay đổi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                            txtSLDV.requestFocus();
////                        } else {
////                            try {
////                                int sl = Integer.parseInt(txtSLDV.getText().trim());
////                                if (sl <= 0) {
////                                    JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                    txtSLDV.requestFocus();
////                                    txtSLDV.setText("");
////                                } else {
//////                                    listSDDV.get(tbDV.getSelectedRow()).setSoLuong(sl);
//////                                    listSDDV.get(tbDV.getSelectedRow()).setDonGia(listdv.get(tbDV.getSelectedRow()).getGiaDV() * sl);
//////                                    renderTBDichVu(tbDV);
////                                    txtMaDV.setText("");
////                                    txtTenDV.setText("");
////                                    txtSLDV.setText("");
////                                    tbDVAll.clearSelection();
////                                    dateNgaySuDung.setCalendar(null);
////                                }
////                            } catch (Exception ex) {
////                                JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                txtSLDV.requestFocus();
////                                txtSLDV.setText("");
////                            }
////                        }
////                    } else {
////                        JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ muốn thay đổi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                    }
////                }
////            });
//            
//
////            btnDeleteDV.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    if (txtMaDV.getText().trim().length() == 0) {
////                        JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ muốn thay đổi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                    } else {
//////                        listSDDV.remove(tbDV.getSelectedRow());
//////                        listdv.remove(tbDV.getSelectedRow());
//////                        renderTBDichVu(tbDV);
////                        txtMaDV.setText("");
////                        txtTenDV.setText("");
////                        txtSLDV.setText("");
////                        tbDVAll.clearSelection();
////                        dateNgaySuDung.setCalendar(null);
////                    }
////                }
////            });
//    
//                    
//
////            btnAcept.addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent e) {
////                    if (txtmadv.getText().length() == 0) {
////                        JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ muốn thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                    } else {
////                        if (txtsldv.getText().trim().length() == 0) {
////                            txtsldv.requestFocus();
////                            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng muốn thuê", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                        } else {
////                            if (datesudung.getDate() == null) {
////                                JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sử dụng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                            } else {
////                                try {
////                                    int sl = Integer.parseInt(txtsldv.getText().trim());
////                                    if (sl <= 0) {
////                                        txtsldv.setText("");
////                                        txtsldv.requestFocus();
////                                        JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                    } else {
////                                        LocalDate now = LocalDate.now();
////                                        LocalDate lcSD = LocalDate.of(datesudung.getDate().getYear() + 1900, datesudung.getDate().getMonth() + 1, datesudung.getDate().getDate());
////                                        if (lcSD.isAfter(now) || lcSD.compareTo(now) == 0) {
////                                            int count = 0;
////                                            for (SuDungDichVuDTO x : listSDDV) {
////                                                if (x.getNgaySuDungString().equals(lcSD.toString()) && x.getMaDV().equals(txtmadv.getText())) {
////                                                    count++;
////                                                    int gia = Integer.parseInt(tbDVAll.getValueAt(tbDVAll.getSelectedRow(), tbDVAll.getColumnModel().getColumnIndex("Giá")).toString());
////                                                    x.setSoLuong(x.getSoLuong() + sl);
////                                                    x.setDonGia(x.getSoLuong() * gia);
////                                                    renderTBDichVu(tbDV);
////                                                    JOptionPane.showMessageDialog(null, "Thêm mới số lượng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                                    txtmadv.setText("");
////                                                    txttendv.setText("");
////                                                    txtsldv.setText("");
////                                                    datesudung.setCalendar(null);
////                                                    txtdongia.setText("");
////                                                    tbDVAll.clearSelection();
////                                                    break;
////                                                }
////                                            }
////                                            if (count == 0) {
////                                                SuDungDichVuDTO sudungdv = new SuDungDichVuDTO();
////                                                sudungdv.setMaChiTietThue(txtMaCTT.getText());
////                                                sudungdv.setMaDV(txtmadv.getText());
////                                                sudungdv.setSoLuong(sl);
////                                                sudungdv.setXuLy(0);
////                                                int gia = Integer.parseInt(tbDVAll.getValueAt(tbDVAll.getSelectedRow(), tbDVAll.getColumnModel().getColumnIndex("Giá")).toString());
////                                                sudungdv.setDonGia(gia * sl);
////                                                sudungdv.setNgaySuDungString(lcSD.toString());
////                                                DichVuDTO x = new DichVuDTO();
////                                                x.setXuLy(0);
////                                                x.setMaDV(txtmadv.getText());
////                                                x.setTenDV(txttendv.getText());
////                                                x.setTenLoaiDV(tbDVAll.getValueAt(tbDVAll.getSelectedRow(), tbDVAll.getColumnModel().getColumnIndex("Loại dịch vụ")).toString());
////                                                x.setGiaDV(gia);
////                                                listdv.add(x);
////                                                listSDDV.add(sudungdv);
////                                                renderTBDichVu(tbDV);
////                                                JOptionPane.showMessageDialog(null, "Thêm thành công 1 dịch vụ vào danh sách xử lý", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                                txtmadv.setText("");
////                                                txttendv.setText("");
////                                                txtsldv.setText("");
////                                                datesudung.setCalendar(null);
////                                                txtdongia.setText("");
////                                                tbDVAll.clearSelection();
////                                            }
////                                        } else {
////                                            JOptionPane.showMessageDialog(null, "Ngày sử dụng phải lớn hơn hoặc bằng ngày hiện tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                        }
////                                    }
////                                } catch (Exception ex) {
////                                    txtsldv.setText("");
////                                    txtsldv.requestFocus();
////                                    JOptionPane.showMessageDialog(null, "Số lượng là một số nguyên lớn hơn 0", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////            );
////        }
//
////        public void renderTBDichVu(JTable tbDV) {
////            DefaultTableModel dtm = new DefaultTableModel();
////            dtm.addColumn("STT");
////            dtm.addColumn("Mã dịch vụ");
////            dtm.addColumn("Tên dịch vụ");
////            dtm.addColumn("Loại dịch vụ");
////            dtm.addColumn("Ngày sử dụng");
////            dtm.addColumn("Số lượng");
////            dtm.addColumn("Đơn giá");
////            dtm.addColumn("Giá dịch vụ");
////            int i = 0;
////            for (SuDungDichVuDTO x : listSDDV) {
////                Object row[] = {i + 1, x.getMaDV(), listdv.get(i).getTenDV(), listdv.get(i).getTenLoaiDV(), date(x.getNgaySuDungString()), x.getSoLuong(), listdv.get(i).getGiaDV(), x.getDonGia()};
////                dtm.addRow(row);
////                i++;
////            }
////            tbDV.setModel(dtm);
////            tbDV.setShowGrid(false);
////            tbDV.setIntercellSpacing(new Dimension(0, 0));
////            tbDV.setRowHeight(30);
////            tbDV.getColumnModel().getColumn(0).setPreferredWidth(5);
////            tbDV.getColumnModel().getColumn(1).setPreferredWidth(50);
////            tbDV.getTableHeader().setPreferredSize(new Dimension(1, 32));
////            tbDV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
////            tbDV.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
////                @Override
////                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
////                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
////                    JLabel lb = (JLabel) c;
////                    if (isSelected) {
////                        lb.setBackground(Color.decode("#F5F5F5"));
////                    } else {
////                        lb.setBackground(Color.decode("#FFFFFF"));
////                    }
////                    if (column == tbDV.getColumnModel().getColumnIndex("STT")) {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
////                        lb.setBackground(Color.decode("#99FF99"));
////                    } else {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
////                    }
////                    if (column == tbDV.getColumnModel().getColumnIndex("Tên dịch vụ") || column == tbDV.getColumnModel().getColumnIndex("Loại dịch vụ") || column == tbDV.getColumnModel().getColumnIndex("Giá dịch vụ") || column == tbDV.getColumnModel().getColumnIndex("Đơn giá")) {
////                        lb.setHorizontalAlignment(JLabel.LEFT);
////                        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#DDDDDD")), new EmptyBorder(0, 5, 0, 0)));
////                    } else if (column == tbDV.getColumnModel().getColumnIndex("STT")) {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
////                        lb.setBackground(Color.decode("#99FF99"));
////                        lb.setHorizontalAlignment(JLabel.CENTER);
////                    } else {
////                        lb.setHorizontalAlignment(JLabel.CENTER);
////                        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#DDDDDD")), new EmptyBorder(0, 0, 0, 0)));
////                    }
////                    return lb;
////                }
////            };
////            for (int j = 0; j < tbDV.getColumnCount(); j++) {
////                tbDV.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
////            }
////        }
////
////        public void renderDVAll(JTable tb) {
////            DefaultTableModel tbModel = new DefaultTableModel();
////            tbModel.addColumn("STT");
////            tbModel.addColumn("Mã dịch vụ");
////            tbModel.addColumn("Tên dịch vụ");
////            tbModel.addColumn("Loại dịch vụ");
////            tbModel.addColumn("Giá");
////            int i = 1;
////            for (DichVuDTO x : listDV) {
////                Object row[] = {i, x.getMaDV(), x.getTenDV(), x.getTenLoaiDV(), x.getGiaDV()};
////                tbModel.addRow(row);
////                i++;
////            }
////            tb.setModel(tbModel);
////            tb.setShowGrid(false);
////            tb.setIntercellSpacing(new Dimension(0, 0));
////            tb.setRowHeight(30);
////            tb.getColumnModel().getColumn(0).setPreferredWidth(1);
////            tb.getColumnModel().getColumn(1).setPreferredWidth(50);
////            tb.getTableHeader().setPreferredSize(new Dimension(1, 32));
////            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
////            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
////            DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
////                @Override
////                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
////                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
////                    JLabel lb = (JLabel) c;
////                    if (isSelected) {
////                        lb.setBackground(Color.decode("#F5F5F5"));
////                    } else {
////                        lb.setBackground(Color.decode("#FFFFFF"));
////                    }
////                    if (column == tb.getColumnModel().getColumnIndex("STT")) {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
////                        lb.setBackground(Color.decode("#99FF99"));
////                    } else {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#DDDDDD")));
////                    }
////                    if (column == tb.getColumnModel().getColumnIndex("Tên dịch vụ") || column == tb.getColumnModel().getColumnIndex("Loại dịch vụ") || column == tb.getColumnModel().getColumnIndex("Giá")) {
////                        lb.setHorizontalAlignment(JLabel.LEFT);
////                        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#DDDDDD")), new EmptyBorder(0, 5, 0, 0)));
////                    } else if (column == tb.getColumnModel().getColumnIndex("STT")) {
////                        lb.setBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#99FF99")));
////                        lb.setBackground(Color.decode("#99FF99"));
////                        lb.setHorizontalAlignment(JLabel.CENTER);
////                    } else {
////                        lb.setHorizontalAlignment(JLabel.CENTER);
////                        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#DDDDDD")), new EmptyBorder(0, 0, 0, 0)));
////                    }
////                    return lb;
////                }
////            };
////            for (int j = 0; j < tb.getColumnCount(); j++) {
////                tb.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
////            }
////        }
//
////        public String date(String date) {
////            String d1[] = date.split("-");
////            String date1 = d1[2] + "-" + d1[1] + "-" + d1[0];
////            return date1;
//    //@@@@@@@@@@@@@ dich vu @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@