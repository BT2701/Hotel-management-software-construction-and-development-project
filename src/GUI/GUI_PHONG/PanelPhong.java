package GUI.GUI_PHONG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class PanelPhong extends JPanel {

    private int LightDark;
    private JPanel pnTop, pnContent;
    private JButton btnPhong, btnTienIch;
    Font sgUI15b, sgUI15p;
    private int menu;
    Border borderEmpty6_8_6_8, borderMatte0_0_5_0_98befa, borderMatte0_0_5_0_ffffff;
    private DisplayRoom displayRoom;
    private DisplayFurniture displayFurniture;

    public PanelPhong() {
        // new 
        pnTop = new JPanel();
        pnContent = new JPanel();
        btnPhong = new JButton("Quản lý phòng");
        btnTienIch = new JButton("Quản lý tiện ích");
        sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
        sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
        menu = 1;
        borderEmpty6_8_6_8 = new EmptyBorder(6, 8, 6, 8);
        borderMatte0_0_5_0_98befa = new MatteBorder(0, 0, 5, 0, Color.decode("#98befa"));
        borderMatte0_0_5_0_ffffff = new MatteBorder(0, 0, 5, 0, Color.decode("#F5F5F5"));
        displayRoom = new DisplayRoom();
        displayFurniture = new DisplayFurniture();
        initComponents();
    }

    public void initComponents() {
        setLayout(new BorderLayout(10, 10));
        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);
        setDisplayMenu(menu);

        pnTop.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnTop.add(btnPhong);
        pnTop.add(btnTienIch);
        setMouse(btnPhong);
        setMouse(btnTienIch);
        actionMenu();
    }

    public void setDisplayMenu(int menu) {
        pnContent.removeAll();
        pnContent.revalidate();
        pnContent.repaint();
        pnContent.setLayout(new BorderLayout());
        switch (menu) {
            case 1:
                displayRoom.lightDark(LightDark);
                displayRoom.tbP.renderTB();
                setFont_setFocusPainted(btnPhong, sgUI15b);
                setFont_setFocusPainted(btnTienIch, sgUI15p);
                if (LightDark == 0) {
                    btnPhong.setBorder(BorderFactory.createCompoundBorder(borderMatte0_0_5_0_98befa, borderEmpty6_8_6_8));
                } else {
                    btnPhong.setBorder(BorderFactory.createCompoundBorder(borderMatte0_0_5_0_ffffff, borderEmpty6_8_6_8));
                }
                btnTienIch.setBorder(borderEmpty6_8_6_8);
                pnContent.add(displayRoom, BorderLayout.CENTER);
                break;
            case 2:
                displayFurniture.lightDark(LightDark);
                displayFurniture.tbTI.renderTB();
                setFont_setFocusPainted(btnTienIch, sgUI15b);
                setFont_setFocusPainted(btnPhong, sgUI15p);
                if (LightDark == 0) {
                    btnTienIch.setBorder(BorderFactory.createCompoundBorder(borderMatte0_0_5_0_98befa, borderEmpty6_8_6_8));
                } else {
                    btnTienIch.setBorder(BorderFactory.createCompoundBorder(borderMatte0_0_5_0_ffffff, borderEmpty6_8_6_8));
                }
                btnPhong.setBorder(borderEmpty6_8_6_8);
                pnContent.add(displayFurniture, BorderLayout.CENTER);
                break;
        }
    }

    public void setFont_setFocusPainted(JButton button, Font font) {
        button.setFont(font);
        button.setFocusPainted(false);
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

    public void actionMenu() {
        btnPhong.addActionListener((ActionEvent e) -> {
            menu = 1;
            setDisplayMenu(menu);
        });

        btnTienIch.addActionListener((ActionEvent e) -> {
            menu = 2;
            setDisplayMenu(menu);
        });
    }

    public void lightDark(int lightDark) {
        if (lightDark == 0) {
            LightDark = 0;
            displayRoom.lightDark(LightDark);
            displayFurniture.lightDark(LightDark);
            setBackground(Color.decode("#ebf2fc"));
            pnTop.setBackground(Color.white);
            btnPhong.setBackground(Color.white);
            btnTienIch.setBackground(Color.white);
            btnPhong.setForeground(Color.black);
            btnTienIch.setForeground(Color.black);
            if (menu == 1) {
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0, Color.decode("#98befa")), new EmptyBorder(7, 5, 7, 5)));
                btnTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 0, 0, Color.white), new EmptyBorder(7, 5, 7, 5)));
            } else {
                btnTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0, Color.decode("#98befa")), new EmptyBorder(7, 5, 7, 5)));
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 0, 0, Color.white), new EmptyBorder(7, 5, 7, 5)));
            }
            pnContent.setBackground(Color.white);
        } else {
            LightDark = 1;
            displayRoom.lightDark(LightDark);
            displayFurniture.lightDark(LightDark);
            Color black = Color.decode("#333333");
            setBackground(Color.decode("#3C3C3C"));
            pnTop.setBackground(black);
            btnPhong.setBackground(black);
            btnTienIch.setBackground(black);
            btnPhong.setForeground(Color.white);
            btnTienIch.setForeground(Color.white);
            if (menu == 1) {
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0, Color.decode("#ffffff")), new EmptyBorder(7, 5, 7, 5)));
                btnTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 0, 0, black), new EmptyBorder(7, 5, 7, 5)));
            } else {
                btnTienIch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0, Color.decode("#ffffff")), new EmptyBorder(7, 5, 7, 5)));
                btnPhong.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 0, 0, black), new EmptyBorder(7, 5, 7, 5)));
            }
            pnContent.setBackground(Color.white);
        }
    }

    public DisplayRoom getDisplay() {
        return displayRoom;
    }

}
