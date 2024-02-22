/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import DTO.DichVuDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author ACER
 */
public class FormDetailServiceReception extends JDialog {

    JPanel pnContent = new JPanel();
    JPanel pnTop = new JPanel();
    JLabel lbTop = new JLabel("THÔNG TIN CHI TIẾT DỊCH VỤ");
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

    JLabel lbTenDV_formRight, lbLoaiDV_formRight, lbGiaDV_formRight, lbImg_FormRight, lbImage, lbSoLuongDV;
    JPanel pnImg, pnTenDV_formRight, pnLoaiDV_formRight, pnImgInput, pnGiaDV_formRight;
    Border bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7, bdEmpty0_7_0_0;
    JFileChooser fc = new JFileChooser("src\\GUI\\assets");
    JTextField txtTenDV_formRight, txtGiaDV_formRight, txtSoLuongDV;
    JTextField cbLoaiDV_formRight;

    JPanel pnSoLuongDV = new JPanel();

    private DecimalFormat dcf = new DecimalFormat("###,### VNĐ");

    public FormDetailServiceReception(boolean check, String MaDV, String TenDV, String GiaDV, String LoaiDV, String pathImg, DisplayServiceReception displayService) {
        pnTenDV_formRight = new JPanel();
        pnLoaiDV_formRight = new JPanel();
        pnImgInput = new JPanel();
        pnGiaDV_formRight = new JPanel();
        lbTenDV_formRight = new JLabel("Tên dịch vụ");
        lbLoaiDV_formRight = new JLabel("Loại dịch vụ");
        lbGiaDV_formRight = new JLabel("Giá dịch vụ");
        lbImg_FormRight = new JLabel("Hình ảnh");
        txtTenDV_formRight = new JTextField();
        txtGiaDV_formRight = new JTextField();
        cbLoaiDV_formRight = new JTextField();
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdEmpty0_7_0_7 = new EmptyBorder(0, 7, 0, 7);
        bdEmpty0_7_0_0 = new EmptyBorder(0, 7, 0, 0);
        lbImage = new JLabel();
        pnImg = new JPanel();
        lbSoLuongDV = new JLabel("Số lượng");
        txtSoLuongDV = new JTextField();
        initComponent(check, MaDV, TenDV, GiaDV, LoaiDV, pathImg, displayService);
    }

    public void initComponent(boolean check, String MaDV, String TenDV, String GiaDV, String LoaiDV, String pathImg, DisplayServiceReception displayService) {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        setTitle("Chi tiết dịch vụ");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setSize(600, 450);
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
        lbBottom.setText("Mã Dịch Vụ: " + MaDV);

        pnCenter.setLayout(new BorderLayout(5, 5));
        pnCenter.add(pnCenterTop, BorderLayout.CENTER);
        pnCenter.add(pnCenterBottom, BorderLayout.SOUTH);

        pnCenterTop.setLayout(new GridLayout(1, 2, 5, 5));
        pnCenterTop.add(pnCenterInput);
        pnCenterTop.add(pnCenterImage);

        pnCenterImage.setLayout(new BorderLayout(5, 5));
        pnCenterImage.add(pnImgInput, BorderLayout.NORTH);
        pnCenterImage.add(pnImg, BorderLayout.CENTER);
        pnImg.setBackground(Color.decode("#FCFCFC"));
        pnImg.setLayout(new BorderLayout());
        pnImg.add(lbImage, BorderLayout.CENTER);

        pnImgInput.setLayout(new BorderLayout());
        pnImgInput.add(lbImg_FormRight, BorderLayout.WEST);

        pnCenterInput.setLayout(new GridLayout(4, 1, 5, 5));
        pnCenterInput.add(pnTenDV_formRight);
        pnCenterInput.add(pnLoaiDV_formRight);
        pnCenterInput.add(pnGiaDV_formRight);
        if (check) {
            pnCenterInput.add(pnSoLuongDV);
        } else {
            pnCenterInput.add(pnEmpty);
        }

        txtSoLuongDV.setEditable(false);

        setLayoutPanel_2(pnTenDV_formRight, lbTenDV_formRight, txtTenDV_formRight);
        setLayoutPanel_2(pnLoaiDV_formRight, lbLoaiDV_formRight, cbLoaiDV_formRight);
        setLayoutPanel_2(pnGiaDV_formRight, lbGiaDV_formRight, txtGiaDV_formRight);
        setLayoutPanel_2(pnSoLuongDV, lbSoLuongDV, txtSoLuongDV);

        cbLoaiDV_formRight.setFont(sgUI13);
        txtSoLuongDV.setFont(sgUI13);
        txtGiaDV_formRight.setFont(sgUI13);
        txtTenDV_formRight.setFont(sgUI13);
        lbImage.setFont(sgUI13);
        cbLoaiDV_formRight.setText(LoaiDV);

        txtTenDV_formRight.setText(TenDV);
        fc.setSelectedFile(new File(pathImg));
        ImageIcon icon = new ImageIcon(new ImageIcon(fc.getSelectedFile().toString()).getImage().getScaledInstance(255, 250, Image.SCALE_SMOOTH));
        lbImage.setIcon(icon);
        lbImage.setHorizontalAlignment(JLabel.CENTER);

        try {
            txtGiaDV_formRight.setText(dcf.parse(GiaDV) + "");
        } catch (ParseException ex) {
        }

        pnCenterBottom.setLayout(new GridLayout(1, 3, 10, 10));

        cbLoaiDV_formRight.setEditable(false);

        txtTenDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        txtGiaDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        txtSoLuongDV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
        cbLoaiDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));

        cbLoaiDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
        cbLoaiDV_formRight.setBackground(Color.white);
        pnTenDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnLoaiDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnGiaDV_formRight.setBackground(Color.decode("#FCFCFC"));
        pnTenDV_formRight.setBackground(Color.decode("#FCFCFC"));
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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                displayService.tbDV.renderTB();
            }
        });

        DichVuDTO a = DichVuBUS.searchDV(MaDV);
        txtSoLuongDV.setText(a.getSoLuong() + "");

        txtTenDV_formRight.setEditable(false);
        txtGiaDV_formRight.setEditable(false);
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
}
