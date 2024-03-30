package GUI.GUI_DICHVU;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelDichVu extends JPanel {

    JPanel pnTop, pnCenter;
    JButton btnQuanLy, btnNhapHang;
    Font sgUI15b, sgUI15p;
    int LightDark;
    int menu;

    DisplayService displayService;
    DisplayImport displayImport;

    public PanelDichVu() {
        //new 
        this.menu = 1;
        this.pnTop = new JPanel();
        this.btnQuanLy = new JButton("Quản lý dịch vụ");
        this.btnNhapHang = new JButton("Nhập dịch vụ thức ăn");
        this.sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
        this.sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
        this.pnCenter = new JPanel();
        this.displayService = new DisplayService();
        this.displayImport = new DisplayImport();
        this.borderEmpty6_8_6_8 = new EmptyBorder(6, 8, 6, 8);
        this.borderMatte0_0_5_0_98befa = new MatteBorder(0, 0, 5, 0, Color.decode("#98befa"));
        //new
        this.LightDark = 0;
        initComponents();
        lightDark(this.LightDark);
    }

    public void initComponents() {
        setLayout(new BorderLayout(10, 10));
        add(pnTop, BorderLayout.NORTH);

        pnTop.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnTop.add(btnQuanLy);
        pnTop.add(btnNhapHang);

        add(pnCenter, BorderLayout.CENTER);
        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(displayService, BorderLayout.CENTER);
        pnCenter.setBorder(new EmptyBorder(5, 5, 5, 5));

        actionMenu();
        Menu(menu);
        setMouse(btnQuanLy);
        setMouse(btnNhapHang);
    }

    public void setMouse(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#ebf2fc"));
                } else {
                    x.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.white);
                } else {
                    x.setBackground(Color.decode("#333333"));
                }
            }
        });
    }

    public void setFont_setFocusPainted(JButton button, Font font) {
        button.setFont(font);
        button.setFocusPainted(false);
    }

    Border borderEmpty6_8_6_8, borderMatte0_0_5_0_98befa;

    public void Menu(int menu) {
        if (menu == 2) {
            displayImport.lightDark(LightDark);
            displayImport.displayImportAdd.tbNhapDV.renderTB();
            displayImport.displayImportContent.tbPN.renderTB();
            setFont_setFocusPainted(btnQuanLy, sgUI15p);
            setFont_setFocusPainted(btnNhapHang, sgUI15b);
            if (this.LightDark == 0) {
                btnNhapHang.setBorder(BorderFactory.createCompoundBorder(borderMatte0_0_5_0_98befa, borderEmpty6_8_6_8));
            } else {
                btnNhapHang.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0, Color.decode("#ffffff")), new EmptyBorder(6, 8, 6, 8)));
            }
            btnQuanLy.setBorder(borderEmpty6_8_6_8);
            pnCenter.removeAll();
            pnCenter.revalidate();
            pnCenter.repaint();
            pnCenter.setLayout(new BorderLayout());
            pnCenter.add(displayImport, BorderLayout.CENTER);
            displayImport.displayImportContent.tbPN.renderTB();
        } else if (menu == 1) {
            displayService.lightDark(LightDark);
            displayService.tbDV.renderTB();
            setFont_setFocusPainted(btnQuanLy, sgUI15b);
            setFont_setFocusPainted(btnNhapHang, sgUI15p);
            if (this.LightDark == 0) {
                btnQuanLy.setBorder(BorderFactory.createCompoundBorder(borderMatte0_0_5_0_98befa, borderEmpty6_8_6_8));
            } else {
                btnQuanLy.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0, Color.decode("#ffffff")), new EmptyBorder(6, 8, 6, 8)));
            }
            btnNhapHang.setBorder(borderEmpty6_8_6_8);
            pnCenter.removeAll();
            pnCenter.revalidate();
            pnCenter.repaint();
            pnCenter.setLayout(new BorderLayout());
            pnCenter.add(displayService, BorderLayout.CENTER);
            displayService.tbDV.renderTB();
        }
    }

    public void actionMenu() {
        btnQuanLy.addActionListener((ActionEvent e) -> {
            menu = 1;
            Menu(menu);
        });

        btnNhapHang.addActionListener((ActionEvent e) -> {
            menu = 2;
            Menu(menu);
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = 0;
            displayService.lightDark(this.LightDark);
            displayImport.lightDark(this.LightDark);
            setBackground(Color.decode("#F6FBFF"));
            pnTop.setBackground(Color.white);
            btnNhapHang.setBackground(Color.white);
            btnQuanLy.setBackground(Color.white);
            Menu(this.menu);
            pnCenter.setBackground(Color.white);
            btnNhapHang.setForeground(Color.black);
            btnQuanLy.setForeground(Color.black);
        } else {
            this.LightDark = 1;
            Color black = Color.decode("#333333");
            displayService.lightDark(this.LightDark);
            displayImport.lightDark(this.LightDark);
            setBackground(Color.decode("#3C3C3C"));
            pnTop.setBackground(black);
            btnNhapHang.setBackground(black);
            btnNhapHang.setForeground(Color.white);
            btnQuanLy.setForeground(Color.white);
            btnQuanLy.setBackground(black);
            Menu(this.menu);
            pnCenter.setBackground(black);
        }
    }
}
