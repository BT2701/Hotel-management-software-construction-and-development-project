package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import BUS.PhieuNhapBUS;
import DTO.DichVuDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.mainGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.ColorUIResource;

public class DisplayImportAdd extends JPanel {

    JPanel pnTop, pnMaPN, pnTenNV, pnNgayLapPhieu, pnTinhTrang, pnContent, pnContentLeft, pnContentRight,
            pnContentLeftTop, pnContentLeftTopSearch, pnContentLeftCenter, pnContentLeftCenterBottom,
            pnContentLeftCenterBottomTop, pnContentLeftCenterBottomBottom, pnContentRightCenter,
            pnContentRightBottom, pnContentRightBottomButton;
    JLabel lbMaPN, lbTenNV, lbNgayLapPhieu, lbTinhTrang, lbContentTop, lbImgSearch,
            lbContentRight;
    Font sgUI13b, sgUI15b, sgUI13;
    JTextField txtMaPN, txtTenNV, txtTinhTrang, txtNgayLapPhieu, txtSearch;
    JScrollPane scp, scpContentRightCenter;
    TableNhapDichVu tbNhapDV;
    ScrollBar scrB;
    int LightDark;
    ArrayList<ItemServiceAdd> listItem = new ArrayList<>();
    JButton btnReset, btnAcept;
    Border bdMatte3_3_0_0_9cf6ab, bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10,
            bdMatte3_3_0_0_e4ee5c, bdMatte0_0_3_3_e4ee5c;
    DisplayImport displayImport;

    public DisplayImportAdd(DisplayImport displayImport) {
        this.displayImport = displayImport;
        pnTop = new JPanel();
        sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
        sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
        sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
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
        pnContent = new JPanel();
        pnContentLeft = new JPanel();
        pnContentRight = new JPanel();
        pnContentLeftTop = new JPanel();
        pnContentLeftTopSearch = new JPanel();
        lbImgSearch = new JLabel();
        txtSearch = new JTextField();
        lbContentTop = new JLabel("Danh sách dịch vụ");
        pnContentLeftCenter = new JPanel();
        pnContentLeftCenterBottom = new JPanel();
        pnContentLeftCenterBottomBottom = new JPanel();
        pnContentLeftCenterBottomTop = new JPanel();
        scp = new JScrollPane();
        tbNhapDV = new TableNhapDichVu();
        scrB = new ScrollBar(Color.decode("#ebf2fc"), Color.white);
        lbContentRight = new JLabel("Danh sách dịch vụ cần nhập                 ");
        scpContentRightCenter = new JScrollPane();
        pnContentRightCenter = new JPanel();
        pnContentRightBottom = new JPanel();
        pnContentRightBottomButton = new JPanel();
        btnReset = new JButton("Làm mới");
        btnAcept = new JButton("Nhập hàng");
        bdMatte3_3_0_0_9cf6ab = new MatteBorder(3, 3, 0, 0, Color.decode("#9CF6AB"));
        bdMatte0_0_3_3_9cf6ab = new MatteBorder(0, 0, 3, 3, Color.decode("#9CF6AB"));
        bdEmpty5_10_5_10 = new EmptyBorder(5, 10, 5, 10);
        bdMatte3_3_0_0_e4ee5c = new MatteBorder(3, 3, 0, 0, Color.decode("#e4ee5c"));
        bdMatte0_0_3_3_e4ee5c = new MatteBorder(0, 0, 3, 3, Color.decode("#e4ee5c"));
        LightDark = 0;
        initComponents();
        lightDark(LightDark);
    }

    public void initComponents() {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        setLayout(new BorderLayout(10, 10));
        add(pnTop, BorderLayout.NORTH);
        pnTop.setLayout(new GridLayout(1, 4, 10, 10));
        pnTop.add(pnMaPN);
        pnTop.add(pnTenNV);
        pnTop.add(pnNgayLapPhieu);
        pnTop.add(pnTinhTrang);
        pnTop.setBorder(new EmptyBorder(0, 50, 0, 50));

        setLayoutNorth_Center(pnMaPN, lbMaPN, txtMaPN);
        setLayoutNorth_Center(pnTenNV, lbTenNV, txtTenNV);
        setLayoutNorth_Center(pnNgayLapPhieu, lbNgayLapPhieu, txtNgayLapPhieu);
        setLayoutNorth_Center(pnTinhTrang, lbTinhTrang, txtTinhTrang);

        txtMaPN.setBorder(null);
        txtTenNV.setBorder(null);
        txtNgayLapPhieu.setBorder(null);
        txtTinhTrang.setBorder(null);

        txtMaPN.setFont(sgUI13b);
        txtTenNV.setFont(sgUI13b);
        txtNgayLapPhieu.setFont(sgUI13b);
        txtTinhTrang.setFont(sgUI13b);

        String[] date = LocalDate.now().toString().split("-");
        int count = PhieuNhapBUS.getCountImportToday();
        if (count < 10) {
            txtMaPN.setText("#PN" + date[2] + "" + date[1] + "" + date[0].substring(2, 4) + "000" + count);
        } else {
            txtMaPN.setText("#PN" + date[2] + "" + date[1] + "" + date[0].substring(2, 4) + "00" + count);
        }
        txtTenNV.setText(mainGUI.nv.getTenNV());
        txtNgayLapPhieu.setText(date[2] + " - " + date[1] + " - " + date[0]);
        txtTinhTrang.setText("Chưa xử lý");

        txtMaPN.setEditable(false);
        txtTenNV.setEditable(false);
        txtNgayLapPhieu.setEditable(false);
        txtTinhTrang.setEditable(false);

        add(pnContent, BorderLayout.CENTER);
        pnContent.setLayout(new BorderLayout(10, 10));
        pnContent.setBorder(new EmptyBorder(0, 50, 0, 50));
        pnContent.add(pnContentLeft, BorderLayout.CENTER);
        pnContent.add(pnContentRight, BorderLayout.EAST);
        pnContentLeft.setLayout(new BorderLayout());
        pnContentLeft.add(pnContentLeftTop, BorderLayout.NORTH);
        pnContentLeftTop.setLayout(new GridLayout(1, 2));
        pnContentLeftTop.add(lbContentTop);
        pnContentLeftTop.add(pnContentLeftTopSearch);
        pnContentLeftTopSearch.setLayout(new BorderLayout());
        pnContentLeftTopSearch.add(lbImgSearch, BorderLayout.WEST);
        pnContentLeftTopSearch.add(txtSearch, BorderLayout.CENTER);
        pnContentLeftTopSearch.setBorder(new EmptyBorder(0, 50, 0, 0));

        txtSearch.setFont(sgUI13);
        ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/IconFind.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lbImgSearch.setIcon(iconSearch);
        pnContentLeftTop.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbContentTop.setFont(sgUI15b);
        lbImgSearch.setOpaque(true);
        lbImgSearch.setBackground(Color.white);
        lbImgSearch.setBorder(new EmptyBorder(5, 5, 5, 5));

        pnContentLeft.add(pnContentLeftCenter, BorderLayout.CENTER);
        pnContentLeftCenter.setLayout(new BorderLayout());
        pnContentLeftCenter.add(scp, BorderLayout.CENTER);
        pnContentLeftCenter.add(pnContentLeftCenterBottom, BorderLayout.SOUTH);
        pnContentLeftCenterBottom.setLayout(new GridLayout(2, 1));
        pnContentLeftCenterBottom.add(pnContentLeftCenterBottomTop);
        pnContentLeftCenterBottom.add(pnContentLeftCenterBottomBottom);
        pnContentLeftCenterBottomBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        scp.setBorder(BorderFactory.createEmptyBorder());
        scp.setViewportView(tbNhapDV);
        scp.setVerticalScrollBar(scrB);

        pnContentRight.setLayout(new BorderLayout());
        pnContentRight.add(lbContentRight, BorderLayout.NORTH);
        lbContentRight.setFont(sgUI15b);
        lbContentRight.setBorder(new EmptyBorder(5, 10, 5, 10));
        lbContentRight.setOpaque(true);

        pnContentRight.add(scpContentRightCenter, BorderLayout.CENTER);
        scpContentRightCenter.setViewportView(pnContentRightCenter);
        scpContentRightCenter.setBorder(BorderFactory.createEmptyBorder());
        scpContentRightCenter.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
        pnContentRightCenter.setLayout(new BoxLayout(pnContentRightCenter, BoxLayout.Y_AXIS));
        pnContentRightCenter.setBorder(new EmptyBorder(5, 0, 0, 0));

        pnContentRight.add(pnContentRightBottom, BorderLayout.SOUTH);
        pnContentRightBottom.setLayout(new BorderLayout());
        pnContentRightBottom.add(pnContentRightBottomButton, BorderLayout.EAST);
        pnContentRightBottomButton.setLayout(new GridLayout(1, 2, 5, 5));
        pnContentRightBottomButton.add(btnReset);
        pnContentRightBottomButton.add(btnAcept);

        setFont_setFocusPainted(btnAcept, sgUI13b);
        setFont_setFocusPainted(btnReset, sgUI13b);

        setHover(btnAcept);
        setHover_Reset(btnReset);

        tbNhapDV.getColumnEdit().getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tbNhapDV.getColumnEdit().getButton()) {
                    try {
                        pnContentRightCenter.revalidate();
                        String maDV = tbNhapDV.getValueAt(tbNhapDV.getSelectedRow(), tbNhapDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString();
                        boolean check = false;
                        for (ItemServiceAdd item : listItem) {
                            if (item.getMaDV().equals(maDV)) {
                                item.setSoLuong(item.getSoLuong() + 1);
                                check = true;
                                break;
                            }
                        }
                        if (!check) {
                            String tenDV = tbNhapDV.getValueAt(tbNhapDV.getSelectedRow(), tbNhapDV.getColumnModel().getColumnIndex("Tên dịch vụ")).toString();
                            ItemServiceAdd newItem = new ItemServiceAdd(maDV, tenDV);
                            pnContentRightCenter.add(newItem);
                            newItem.setMaximumSize(new Dimension(pnContentRightCenter.getWidth(), 100));
                            listItem.add(newItem);
                        }
                        show();
                        AddEventDelete();
                    } catch (Exception ex) {

                    }
                }
            }
        });
        AddEventDelete();
        pnContentRightBottomButton.setVisible(false);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listItem.clear();
                pnContentRightCenter.removeAll();
                pnContentRightCenter.revalidate();
                pnContentRightCenter.repaint();
                pnContentRightBottomButton.setVisible(false);
            }
        });
        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormAcepImport(txtMaPN.getText(), txtTenNV.getText(), txtNgayLapPhieu.getText(), txtTinhTrang.getText(), listItem, DisplayImportAdd.this);
            }
        });
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (txtSearch.getText().trim().length() == 0) {
                    tbNhapDV.renderTB();
                } else {
                    ArrayList<DichVuDTO> list = DichVuBUS.getListDV();
                    ArrayList<DichVuDTO> listSearch = new ArrayList<>();
                    for (DichVuDTO x : list) {
                        if (x.getTenDV().toUpperCase().contains(txtSearch.getText().trim().toUpperCase())) {
                            listSearch.add(x);
                        }
                    }
                    tbNhapDV.renderTB(listSearch);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (txtSearch.getText().trim().length() == 0) {
                    tbNhapDV.renderTB();
                } else {
                    ArrayList<DichVuDTO> list = DichVuBUS.getListDV();
                    ArrayList<DichVuDTO> listSearch = new ArrayList<>();
                    for (DichVuDTO x : list) {
                        if (x.getTenDV().toUpperCase().contains(txtSearch.getText().trim().toUpperCase())) {
                            listSearch.add(x);
                        }
                    }
                    tbNhapDV.renderTB(listSearch);
                }
            }
        });
    }

    public void Return() {
        reset();
        String[] date = LocalDate.now().toString().split("-");
        int count = PhieuNhapBUS.getCountImportToday();
        if (count < 10) {
            txtMaPN.setText("#PN" + date[2] + "" + date[1] + "" + date[0].substring(2, 4) + "000" + count);
        } else {
            txtMaPN.setText("#PN" + date[2] + "" + date[1] + "" + date[0].substring(2, 4) + "00" + count);
        }
        displayImport.displayImportContent.lbAllDetail.setText(PhieuNhapBUS.listCount().get(0) + "");
        displayImport.displayImportContent.lbYesDetail.setText(PhieuNhapBUS.listCount().get(1) + "");
        displayImport.displayImportContent.lbNoDetail.setText(PhieuNhapBUS.listCount().get(2) + "");
        displayImport.pnButton.removeAll();
        displayImport.pnButton.add(displayImport.btnImportFile);
        displayImport.pnButton.add(displayImport.btnExportFile);
        displayImport.pnButton.add(displayImport.btnAdd);
        displayImport.remove(displayImport.displayImportAdd);
        displayImport.revalidate();
        displayImport.repaint();
        displayImport.add(displayImport.displayImportContent, BorderLayout.CENTER);
        displayImport.displayImportContent.tbPN.renderTB();
        displayImport.displayImportContent.repaint();
    }

    public void reset() {
        listItem.clear();
        pnContentRightCenter.removeAll();
        pnContentRightCenter.revalidate();
        pnContentRightCenter.repaint();
        pnContentRightBottomButton.setVisible(false);
    }

    public void show() {
        if (listItem.isEmpty()) {
            pnContentRightBottomButton.setVisible(false);
        } else {
            pnContentRightBottomButton.setVisible(true);
        }
    }

    public void AddEventDelete() {
        for (ItemServiceAdd item : listItem) {
            item.btnExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < listItem.size(); i++) {
                        if (listItem.get(i).equals(item)) {
                            listItem.remove(i);
                            break;
                        }
                    }
                    pnContentRightCenter.removeAll();
                    pnContentRightCenter.revalidate();
                    pnContentRightCenter.repaint();
                    for (ItemServiceAdd item : listItem) {
                        pnContentRightCenter.add(item);
                        item.setMaximumSize(new Dimension(pnContentRightCenter.getWidth(), 100));
                    }
                    show();
                }
            });
        }
    }

    public void setMouseExit(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                x.setForeground(Color.white);
                x.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                x.setForeground(Color.black);
                if (LightDark == 0) {
                    x.setBackground(Color.white);
                } else {
                    x.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            pnContentRightBottomButton.setBackground(Color.white);
            pnContentRightBottom.setBackground(Color.white);
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
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
            pnContent.setBackground(Color.white);
            pnContentLeft.setBackground(Color.white);
            pnContentLeftTop.setBackground(Color.decode("#ebf2fc"));
            lbContentTop.setForeground(Color.decode("#33419C"));
            pnContentLeftTopSearch.setBackground(Color.decode("#ebf2fc"));
            pnContentLeftCenter.setBackground(Color.white);
            scp.setBackground(Color.decode("#dee9fc"));
            scp.getViewport().setBackground(Color.decode("#FFFFFF"));
            scpContentRightCenter.setBackground(Color.white);
            scpContentRightCenter.getViewport().setBackground(Color.white);
            pnContentLeftCenterBottom.setBackground(Color.white);
            pnContentLeftCenterBottomTop.setBackground(Color.white);
            pnContentLeftCenterBottomBottom.setBackground(Color.white);
            tbNhapDV.getTableHeader().setBackground(Color.decode("#dee9fc"));
            tbNhapDV.getTableHeader().setForeground(Color.black);
            pnContentRight.setBackground(Color.white);
            lbContentRight.setBackground(Color.decode("#ebf2fc"));
            lbContentRight.setForeground(Color.decode("#33419C"));
            pnContentRightCenter.setBackground(Color.white);
            txtSearch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#FFFFFF")), new EmptyBorder(5, 5, 5, 5)));
            btnReset.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_e4ee5c, bdEmpty5_10_5_10));
            btnReset.setBackground(Color.decode("#FCFFBF"));
            btnAcept.setBackground(Color.decode("#BCFFC7"));
            btnAcept.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10));
            txtMaPN.setBackground(Color.white);
            txtNgayLapPhieu.setBackground(Color.white);
            txtTenNV.setBackground(Color.white);
            txtTinhTrang.setBackground(Color.white);
            txtMaPN.setForeground(Color.black);
            txtNgayLapPhieu.setForeground(Color.black);
            txtTenNV.setForeground(Color.black);
            txtTinhTrang.setForeground(Color.black);
            lbContentTop.setForeground(Color.white);
            lbContentRight.setForeground(Color.white);
        } else {
            Color black = Color.decode("#333333");
            pnContentRightBottomButton.setBackground(black);
            pnContentRightBottom.setBackground(black);
            setBackground(black);
            pnTop.setBackground(black);
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
            pnContent.setBackground(black);
            pnContentLeft.setBackground(black);
            pnContentLeftTop.setBackground(Color.decode("#ebf2fc"));
            lbContentTop.setForeground(Color.decode("#FFFFFF"));
            pnContentLeftTopSearch.setBackground(Color.decode("#ebf2fc"));
            pnContentLeftCenter.setBackground(black);
            scp.setBackground(black);
            scp.getViewport().setBackground(black);
            scpContentRightCenter.setBackground(black);
            scpContentRightCenter.getViewport().setBackground(black);
            pnContentLeftCenterBottom.setBackground(black);
            pnContentLeftCenterBottomTop.setBackground(black);
            pnContentLeftCenterBottomBottom.setBackground(black);
            tbNhapDV.getTableHeader().setBackground(Color.decode("#202020"));
            tbNhapDV.getTableHeader().setForeground(Color.white);
            pnContentRight.setBackground(black);
            lbContentRight.setBackground(Color.decode("#ebf2fc"));
            lbContentRight.setForeground(Color.decode("#FFFFFF"));
            pnContentRightCenter.setBackground(black);
            txtSearch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#FFFFFF")), new EmptyBorder(5, 5, 5, 5)));
            btnReset.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_e4ee5c, bdEmpty5_10_5_10));
            btnReset.setBackground(Color.decode("#FCFFBF"));
            btnAcept.setBackground(Color.decode("#BCFFC7"));
            btnAcept.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10));
            txtMaPN.setBackground(black);
            txtNgayLapPhieu.setBackground(black);
            txtTenNV.setBackground(black);
            txtTinhTrang.setBackground(black);
            txtMaPN.setForeground(Color.white);
            txtNgayLapPhieu.setForeground(Color.white);
            txtTenNV.setForeground(Color.white);
            txtTinhTrang.setForeground(Color.white);
            lbContentTop.setForeground(Color.black);
            lbContentRight.setForeground(Color.black);
        }
    }

    public void setFont_setFocusPainted(JButton button, Font font) {
        button.setFont(font);
        button.setFocusPainted(false);
    }

    public void setHover(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte3_3_0_0_9cf6ab, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#D8FFDF"));
                } else {
                    x.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#BCFFC7"));
                } else {
                    x.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void setHover_Reset(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte3_3_0_0_e4ee5c, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#FEFFDB"));
                } else {
                    x.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_e4ee5c, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#FCFFBF"));
                } else {
                    x.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void setLayoutNorth_Center(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(5, 5));
        panel.add(label, BorderLayout.NORTH);
        panel.add(textfield, BorderLayout.CENTER);
    }
}
