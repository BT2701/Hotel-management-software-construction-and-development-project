package GUI.GUI_DICHVU;

import BUS.PhieuNhapBUS;
import GUI.ThongBaoDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class DisplayContentListService extends JPanel {

    JPanel pnTop, pnContent, pnContentNorth, pnContentCenter, pnMaPN, pnTenNV, pnNgayLapPhieu, pnTinhTrang;
    JLabel lbTopTitle, lbTopDetail, lbMaPN, lbTenNV, lbNgayLapPhieu, lbTinhTrang;
    Font sgUI13b, sgUI18b, tNR13i;
    JTextField txtMaPN, txtTenNV, txtTinhTrang, txtNgayLapPhieu;

    JPanel pnBottom = new JPanel();
    JButton btnView = new JButton("Xem chi tiết");

    int LightDark;
    DisplayImportContent displayImportContent;

    public DisplayContentListService(DisplayImportContent displayImportContent) {
        this.displayImportContent = displayImportContent;
        pnTop = new JPanel();
        pnContent = new JPanel();
        pnContentNorth = new JPanel();
        pnContentCenter = new JPanel();
        lbTopTitle = new JLabel("Thông tin phiếu nhập                  ");
        lbTopDetail = new JLabel("Vui lòng bấm vào xử lý");
        sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
        sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
        tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
        pnMaPN = new JPanel();
        pnTenNV = new JPanel();
        pnNgayLapPhieu = new JPanel();
        pnTinhTrang = new JPanel();
        lbMaPN = new JLabel("Mã phiếu nhập");
        lbTenNV = new JLabel("Tên nhân viên");
        lbNgayLapPhieu = new JLabel("Ngày lập phiếu");
        lbTinhTrang = new JLabel("Tình trạng");
        txtMaPN = new JTextField();
        txtNgayLapPhieu = new JTextField();
        txtTenNV = new JTextField();
        txtTinhTrang = new JTextField();
        LightDark = 0;
        initComponents();
        lightDark(LightDark);
    }

    public void initComponents() {
        setLayout(new BorderLayout(5, 5));
        add(pnTop, BorderLayout.NORTH);
        pnTop.setLayout(new GridLayout(2, 1));
        pnTop.add(lbTopTitle);
        pnTop.add(lbTopDetail);
        lbTopTitle.setFont(sgUI18b);
        lbTopDetail.setFont(tNR13i);

        add(pnContent, BorderLayout.CENTER);
        pnContent.setLayout(new BorderLayout());
        pnContent.add(pnContentNorth, BorderLayout.NORTH);
        pnContent.add(pnContentCenter, BorderLayout.CENTER);
        pnContent.add(pnBottom, BorderLayout.SOUTH);
        pnContentNorth.setLayout(new GridLayout(4, 1, 5, 5));
        pnContentNorth.add(pnMaPN);
        pnContentNorth.add(pnTenNV);
        pnContentNorth.add(pnNgayLapPhieu);
        pnContentNorth.add(pnTinhTrang);

        setLayoutNorth_Center(pnMaPN, lbMaPN, txtMaPN);
        setLayoutNorth_Center(pnTenNV, lbTenNV, txtTenNV);
        setLayoutNorth_Center(pnNgayLapPhieu, lbNgayLapPhieu, txtNgayLapPhieu);
        setLayoutNorth_Center(pnTinhTrang, lbTinhTrang, txtTinhTrang);

        txtMaPN.setEditable(false);
        txtTenNV.setEditable(false);
        txtNgayLapPhieu.setEditable(false);
        txtTinhTrang.setEditable(false);

        txtMaPN.setBorder(null);
        txtTenNV.setBorder(null);
        txtNgayLapPhieu.setBorder(null);
        txtTinhTrang.setBorder(null);

        txtMaPN.setFont(sgUI13b);
        txtTenNV.setFont(sgUI13b);
        txtNgayLapPhieu.setFont(sgUI13b);
        txtTinhTrang.setFont(sgUI13b);

        pnBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnBottom.add(btnView);
        btnView.setFont(sgUI13b);
        btnView.setFocusPainted(false);
        btnView.setBorderPainted(false);
        setMouse(btnView);

        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaPN.getText().trim().length() == 0) {
                    ThongBaoDialog tb = new ThongBaoDialog("Vui lòng chọn phiếu nhập muốn xem chi tiết", 3);
                } else {
                    if (txtTinhTrang.getText().equals("Chưa xử lý")) {
                        new FormDetailImportService(txtMaPN.getText(), DisplayContentListService.this);
                    } else {
                        new FormAceptImportXL(txtMaPN.getText(), DisplayContentListService.this);
                    }
                }
            }
        });
    }

    public void Reset() {
        txtMaPN.setText("");
        txtNgayLapPhieu.setText("");
        txtTenNV.setText("");
        txtTinhTrang.setText("");
        displayImportContent.tbPN.renderTB();
        displayImportContent.lbAllDetail.setText(PhieuNhapBUS.listCount().get(0) + "");
        displayImportContent.lbYesDetail.setText(PhieuNhapBUS.listCount().get(1) + "");
        displayImportContent.lbNoDetail.setText(PhieuNhapBUS.listCount().get(2) + "");
    }

    public void setMouse(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#33ff33"));
                } else {
                    x.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#99ff99"));
                } else {
                    x.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnContentNorth.setBackground(Color.white);
            pnContentCenter.setBackground(Color.white);
            pnMaPN.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnMaPN.setBackground(Color.white);
            pnTenNV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnTenNV.setBackground(Color.white);
            pnNgayLapPhieu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnNgayLapPhieu.setBackground(Color.white);
            pnTinhTrang.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnTinhTrang.setBackground(Color.white);
            lbMaPN.setForeground(Color.decode("#33419C"));
            lbTenNV.setForeground(Color.decode("#33419C"));
            lbNgayLapPhieu.setForeground(Color.decode("#33419C"));
            lbTinhTrang.setForeground(Color.decode("#33419C"));
            pnBottom.setBackground(Color.white);
            btnView.setBackground(Color.decode("#99ff99"));
            lbTopDetail.setForeground(Color.black);
            lbTopTitle.setForeground(Color.black);
            txtMaPN.setBackground(Color.white);
            txtNgayLapPhieu.setBackground(Color.white);
            txtTenNV.setBackground(Color.white);
            txtTinhTrang.setBackground(Color.white);
            txtMaPN.setForeground(Color.black);
            txtNgayLapPhieu.setForeground(Color.black);
            txtTenNV.setForeground(Color.black);
            txtTinhTrang.setForeground(Color.black);
        } else {
            Color black = Color.decode("#333333");
            setBackground(black);
            pnTop.setBackground(black);
            pnContent.setBackground(black);
            pnContentNorth.setBackground(black);
            pnContentCenter.setBackground(black);
            pnMaPN.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnMaPN.setBackground(black);
            pnTenNV.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnTenNV.setBackground(black);
            pnNgayLapPhieu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnNgayLapPhieu.setBackground(black);
            pnTinhTrang.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc")), new EmptyBorder(5, 10, 5, 10)));
            pnTinhTrang.setBackground(black);
            lbMaPN.setForeground(Color.decode("#FFFFFF"));
            lbTenNV.setForeground(Color.decode("#FFFFFF"));
            lbNgayLapPhieu.setForeground(Color.decode("#FFFFFF"));
            lbTinhTrang.setForeground(Color.decode("#FFFFFF"));
            pnBottom.setBackground(black);
            btnView.setBackground(Color.decode("#99ff99"));
            lbTopDetail.setForeground(Color.white);
            lbTopTitle.setForeground(Color.white);
            txtMaPN.setBackground(black);
            txtNgayLapPhieu.setBackground(black);
            txtTenNV.setBackground(black);
            txtTinhTrang.setBackground(black);
            txtMaPN.setForeground(Color.white);
            txtNgayLapPhieu.setForeground(Color.white);
            txtTenNV.setForeground(Color.white);
            txtTinhTrang.setForeground(Color.white);
        }
    }

    public void setLayoutNorth_Center(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(5, 5));
        panel.add(label, BorderLayout.NORTH);
        panel.add(textfield, BorderLayout.CENTER);
    }
}
