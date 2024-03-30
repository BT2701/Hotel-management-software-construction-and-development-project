package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import DTO.DichVuDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class DisplayServiceFormInput extends JPanel {

    JLabel lbContentRightTopTitle, lbContentRightTopDetail, lbMaDV_formRight,
            lbTenDV_formRight, lbLoaiDV_formRight, lbGiaDV_formRight, lbImg_FormRight, lbImage;
    JPanel pnImg, pnImgSelect, pnContentRightTop, pnContentRightCenter, pnContentRightTopLabel,
            pnContentRightTopButton, pnContentRightCenterTop, pnContentRightCenterBottom,
            pnContentRightCenterTopInput, pnContentRightCenterTopImg, pnMaDV_formRight,
            pnTenDV_formRight, pnLoaiDV_formRight, pnImgInput, pnGiaDV_formRight;
    Border bdEmpty7_10_7_10, bdMatte3_3_0_0_9cf6ab, bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10,
            bdMatte3_3_0_0_e4ee5c, bdMatte0_0_3_3_e4ee5c, bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7, bdEmpty0_7_0_0;
    JFileChooser fc = new JFileChooser("src\\GUI\\assets");
    Font sgUI13b, sgUI18b, tNR13i, sgUI13;
    JButton btnExit, btnAdd_FormRight, btnReset_FormRight, btnSelectFile;
    JTextField txtMaDV_formRight, txtTenDV_formRight, txtGiaDV_formRight;
    JComboBox cbLoaiDV_formRight;
    MatteBorder borderTxtDark;
    int LightDark;

    public DisplayServiceFormInput(DisplayService displayService) {
        pnImg = new JPanel();
        pnImgSelect = new JPanel();
        lbContentRightTopTitle = new JLabel("Thêm dịch vụ");
        lbContentRightTopDetail = new JLabel("Vui lòng nhập thông tin dịch vụ muốn thêm");
        bdEmpty7_10_7_10 = new EmptyBorder(7, 10, 7, 0);
        pnImg = new JPanel();
        pnImgSelect = new JPanel();
        pnContentRightTop = new JPanel();
        pnContentRightCenter = new JPanel();
        pnContentRightTopLabel = new JPanel();
        pnContentRightTopButton = new JPanel();
        pnContentRightCenterTop = new JPanel();
        pnContentRightCenterBottom = new JPanel();
        pnContentRightCenterTopInput = new JPanel();
        pnContentRightCenterTopImg = new JPanel();
        pnMaDV_formRight = new JPanel();
        pnTenDV_formRight = new JPanel();
        pnLoaiDV_formRight = new JPanel();
        pnImgInput = new JPanel();
        pnGiaDV_formRight = new JPanel();
        btnExit = new JButton("X");
        btnAdd_FormRight = new JButton("Thêm dịch vụ");
        btnReset_FormRight = new JButton("Làm mới");
        btnSelectFile = new JButton("Chọn hình");
        lbMaDV_formRight = new JLabel("Mã dịch vụ");
        lbTenDV_formRight = new JLabel("Tên dịch vụ");
        lbLoaiDV_formRight = new JLabel("Loại dịch vụ");
        lbGiaDV_formRight = new JLabel("Giá dịch vụ");
        lbImg_FormRight = new JLabel("Hình ảnh");
        txtMaDV_formRight = new JTextField();
        txtTenDV_formRight = new JTextField();
        txtGiaDV_formRight = new JTextField();
        cbLoaiDV_formRight = new JComboBox();
        bdMatte3_3_0_0_9cf6ab = new MatteBorder(3, 3, 0, 0, Color.decode("#9CF6AB"));
        bdMatte0_0_3_3_9cf6ab = new MatteBorder(0, 0, 3, 3, Color.decode("#9CF6AB"));
        bdEmpty5_10_5_10 = new EmptyBorder(5, 10, 5, 10);
        bdMatte3_3_0_0_e4ee5c = new MatteBorder(3, 3, 0, 0, Color.decode("#e4ee5c"));
        bdMatte0_0_3_3_e4ee5c = new MatteBorder(0, 0, 3, 3, Color.decode("#e4ee5c"));
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdEmpty0_7_0_7 = new EmptyBorder(0, 7, 0, 7);
        bdEmpty0_7_0_0 = new EmptyBorder(0, 7, 0, 0);
        lbImage = new JLabel();
        sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
        sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
        sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
        tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
        borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
        initComponents(displayService);
        setVisible(false);
    }

    public void initComponents(DisplayService displayService) {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        FileFilter filter = new FileNameExtensionFilter("Image file", new String[]{"jpg", "png"});
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);
        lbContentRightTopDetail.setFont(tNR13i);
        lbContentRightTopTitle.setFont(sgUI18b);
        lbMaDV_formRight.setFont(sgUI13b);
        lbTenDV_formRight.setFont(sgUI13b);
        lbGiaDV_formRight.setFont(sgUI13b);
        lbLoaiDV_formRight.setFont(sgUI13b);
        lbImg_FormRight.setFont(sgUI13b);
        txtMaDV_formRight.setEditable(false);
        txtMaDV_formRight.setBackground(Color.decode("#F8f8f8"));

        cbLoaiDV_formRight.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });

        btnReset_FormRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtGiaDV_formRight.setText("");
                txtMaDV_formRight.setText("");
                txtTenDV_formRight.setText("");
                cbLoaiDV_formRight.setSelectedIndex(0);
                fc.setSelectedFile(null);
                lbImage.setIcon(null);
                displayService.tbDV.renderTB();
            }
        });

        setLayout(new BorderLayout());
        add(pnContentRightTop, BorderLayout.NORTH);
        add(pnContentRightCenter, BorderLayout.CENTER);
        pnContentRightTop.setLayout(new BorderLayout(80, 80));
        pnContentRightTop.add(pnContentRightTopLabel, BorderLayout.CENTER);
        pnContentRightTop.add(pnContentRightTopButton, BorderLayout.EAST);

        pnContentRightTopLabel.setLayout(new GridLayout(2, 1));
        pnContentRightTopLabel.add(lbContentRightTopTitle);
        pnContentRightTopLabel.add(lbContentRightTopDetail);

        lbContentRightTopTitle.setFont(sgUI18b);
        lbContentRightTopDetail.setFont(tNR13i);

        pnContentRightTopButton.setLayout(new BorderLayout());
        pnContentRightTopButton.add(btnExit, BorderLayout.CENTER);
        pnContentRightTopButton.setBorder(bdEmpty7_10_7_10);

        setFont_setFocusPainted(btnExit, sgUI13b);
        btnExit.setBorder(null);
        btnExit.setPreferredSize(new Dimension(50, 20));
        setMouseExit(btnExit);

        pnContentRightCenter.setLayout(new BorderLayout());
        pnContentRightCenter.add(pnContentRightCenterTop, BorderLayout.CENTER);
        pnContentRightCenter.add(pnContentRightCenterBottom, BorderLayout.SOUTH);
        pnContentRightCenter.setBorder(new EmptyBorder(10, 30, 0, 30));

        pnContentRightCenterTop.setLayout(new BorderLayout(5, 5));
        pnContentRightCenterTop.add(pnContentRightCenterTopInput, BorderLayout.CENTER);
        pnContentRightCenterTop.add(pnContentRightCenterTopImg, BorderLayout.SOUTH);
        pnContentRightCenterTopInput.setLayout(new GridLayout(4, 1));
        pnContentRightCenterTopInput.add(pnMaDV_formRight);
        pnContentRightCenterTopInput.add(pnTenDV_formRight);
        pnContentRightCenterTopInput.add(pnLoaiDV_formRight);
        pnContentRightCenterTopInput.add(pnGiaDV_formRight);

        setLayoutPanel_2(pnMaDV_formRight, lbMaDV_formRight, txtMaDV_formRight);
        setLayoutPanel_2(pnTenDV_formRight, lbTenDV_formRight, txtTenDV_formRight);
        setLayoutPanel_2(pnLoaiDV_formRight, lbLoaiDV_formRight, cbLoaiDV_formRight);
        setLayoutPanel_2(pnGiaDV_formRight, lbGiaDV_formRight, txtGiaDV_formRight);

        pnContentRightCenterBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnContentRightCenterBottom.setBorder(new EmptyBorder(20, 0, 10, 0));
        pnContentRightCenterBottom.add(btnAdd_FormRight);
        pnContentRightCenterBottom.add(btnReset_FormRight);

        setFont_setFocusPainted(btnAdd_FormRight, sgUI13b);
        setFont_setFocusPainted(btnReset_FormRight, sgUI13b);

        setHover(btnAdd_FormRight);
        setHover_Reset(btnReset_FormRight);

        pnContentRightCenterTopImg.setLayout(new BorderLayout(10, 10));
        pnContentRightCenterTopImg.add(pnImgInput, BorderLayout.NORTH);
        pnContentRightCenterTopImg.add(pnImg, BorderLayout.CENTER);
        pnImg.setBackground(Color.white);
        pnImg.setLayout(new BorderLayout());
        pnImg.add(lbImage, BorderLayout.CENTER);
        pnImg.setPreferredSize(new Dimension(160, 160));

        pnImgInput.setLayout(new BorderLayout());
        pnImgInput.add(lbImg_FormRight, BorderLayout.WEST);
        pnImgInput.add(btnSelectFile, BorderLayout.EAST);

        setMouse_2(btnSelectFile);
        setFont_BorderPainted_setFocusPainted(btnSelectFile, sgUI13b);
        btnSelectFile.addActionListener((ActionEvent e) -> {
            fc.showDialog(null, "Open");
            if (fc.getSelectedFile() != null) {
                ImageIcon icon = new ImageIcon(new ImageIcon(fc.getSelectedFile().toString()).getImage().getScaledInstance(pnImg.getWidth(), pnImg.getHeight(), Image.SCALE_SMOOTH));
                lbImage.setIcon(icon);
                lbImage.setHorizontalAlignment(JLabel.CENTER);
            }
        });
        actionExit();
        cbLoaiDV_formRight.setFont(sgUI13);
        txtMaDV_formRight.setFont(sgUI13);
        txtGiaDV_formRight.setFont(sgUI13);
        txtTenDV_formRight.setFont(sgUI13);
        cbLoaiDV_formRight.removeAllItems();
        cbLoaiDV_formRight.addItem("Chọn loại dịch vụ");
        cbLoaiDV_formRight.addItem("Thức ăn đồ uống");
        cbLoaiDV_formRight.addItem("Ăn uống");
        cbLoaiDV_formRight.addItem("Chăm sóc sắc đẹp");
        cbLoaiDV_formRight.addItem("Tổ chức tiệc");
        cbLoaiDV_formRight.addItem("Giải trí");

        cbLoaiDV_formRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = DichVuBUS.getCountTI() + 1;
                String str = String.format("%05d", count);
                switch (cbLoaiDV_formRight.getSelectedIndex()) {
                    case 0:
                        txtMaDV_formRight.setText("");
                        break;
                    case 1:

                        txtMaDV_formRight.setText("DVTD" + str);
//                        if (count < 10) {
//                            txtMaDV_formRight.setText("DVTD0000" + count);
//                        } else {
//                            txtMaDV_formRight.setText("DVTD000" + count);
//                        }
                        break;
                    case 2:
                        txtMaDV_formRight.setText("DVAU" + str);
//                        if (count < 10) {
//                            txtMaDV_formRight.setText("DVAU0000" + count);
//                        } else {
//                            txtMaDV_formRight.setText("DVAU000" + count);
//                        }
                        break;
                    case 3:
                        txtMaDV_formRight.setText("DVSD" + str);
//                        if (count < 10) {
//                            txtMaDV_formRight.setText("DVSD0000" + count);
//                        } else {
//                            txtMaDV_formRight.setText("DVSD000" + count);
//                        }
                        break;
                    case 4:
                        txtMaDV_formRight.setText("DVTT" + str);
//                        if (count < 10) {
//                            txtMaDV_formRight.setText("DVTT0000" + count);
//                        } else {
//                            txtMaDV_formRight.setText("DVTT000" + count);
//                        }
                        break;
                    default:
                        txtMaDV_formRight.setText("DVGT" + str);
//                        if (count < 10) {
//                            txtMaDV_formRight.setText("DVGT0000" + count);
//                        } else {
//                            txtMaDV_formRight.setText("DVGT000" + count);
//                        }
                        break;
                }
//                if (cbLoaiDV_formRight.getSelectedIndex() != 1) {
//                    txtGiaDV_formRight.setEditable(true);
//                } else {
//                    txtGiaDV_formRight.setText("");
//                    txtGiaDV_formRight.setEditable(false);
//                }
            }
        });

        btnAdd_FormRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTenDV_formRight.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên dịch vụ muốn thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtTenDV_formRight.requestFocus();
                    txtTenDV_formRight.setText("");
                } else {
                    if (cbLoaiDV_formRight.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn loại dịch vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        cbLoaiDV_formRight.requestFocus();
                    } else {
//                        if (cbLoaiDV_formRight.getSelectedIndex() != 1) {
                        if (txtGiaDV_formRight.getText().trim().length() == 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá dịch vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            txtGiaDV_formRight.requestFocus();
                            txtGiaDV_formRight.setText("");
                        } else {
                            try {
                                int giaDV = Integer.parseInt(txtGiaDV_formRight.getText().trim());
                                if (giaDV < 0) {
                                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giá dịch vụ là số nguyên dương", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    txtGiaDV_formRight.setText("");
                                    txtGiaDV_formRight.requestFocus();
                                } else {
                                    if (fc.getSelectedFile() == null) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng chọn hình ảnh dịch vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                        btnSelectFile.requestFocus();
                                    } else {
                                        DichVuDTO x = new DichVuDTO();
                                        x.setMaDV(txtMaDV_formRight.getText().trim());
                                        x.setTenDV(txtTenDV_formRight.getText().trim());
                                        x.setSoLuong(0);
                                        x.setLoaiDV(cbLoaiDV_formRight.getSelectedItem().toString());
                                        x.setGiaDV(Integer.parseInt(txtGiaDV_formRight.getText().trim()));
                                        x.setHinhAnh(fc.getSelectedFile().toString());
                                        x.setXuLy(0);
                                        String check = DichVuBUS.insertDV(x);
                                        if (check.equals("Thêm dịch vụ mới thành công")) {
                                            JOptionPane.showMessageDialog(null, "Thêm thành công dịch vụ mới có mã: " + txtMaDV_formRight.getText().trim(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                            txtGiaDV_formRight.setText("");
                                            txtMaDV_formRight.setText("");
                                            txtTenDV_formRight.setText("");
                                            cbLoaiDV_formRight.setSelectedIndex(0);
                                            fc.setSelectedFile(null);
                                            lbImage.setIcon(null);
                                            displayService.tbDV.renderTB();
                                        } else if (check.equals("Thêm dịch vụ mới không thành công")) {
                                            JOptionPane.showMessageDialog(null, "Thêm không thành công dịch vụ mới có mã: " + txtMaDV_formRight.getText().trim(), "Thông báo", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Mã dịch vụ này đã tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập giá dịch vụ là số", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                txtGiaDV_formRight.setText("");
                                txtGiaDV_formRight.requestFocus();
                            }
                        }
//                        } else {
//                            if (fc.getSelectedFile() == null) {
//                                JOptionPane.showMessageDialog(null, "Vui lòng chọn hình ảnh dịch vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                btnSelectFile.requestFocus();
//                            } else {
//                                DichVuDTO x = new DichVuDTO();
//                                x.setMaDV(txtMaDV_formRight.getText().trim());
//                                x.setTenDV(txtTenDV_formRight.getText().trim());
//                                x.setSoLuong(0);
//                                x.setLoaiDV(cbLoaiDV_formRight.getSelectedItem().toString());
//                                x.setGiaDV(0);
//                                x.setHinhAnh(fc.getSelectedFile().toString());
//                                x.setXuLy(0);
//                                String check = DichVuBUS.insertDV(x);
//                                if (check.equals("Thêm dịch vụ mới thành công")) {
//                                    JOptionPane.showMessageDialog(null, "Thêm thành công dịch vụ mới có mã: " + txtMaDV_formRight.getText().trim() +"\nĐây là dịch vụ cần nhập hàng mới cập nhập giá \nNên hiện tại đang ẩn vui lòng nhập hàng để hoạt động", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                                    txtGiaDV_formRight.setText("");
//                                    txtMaDV_formRight.setText("");
//                                    txtTenDV_formRight.setText("");
//                                    cbLoaiDV_formRight.setSelectedIndex(0);
//                                    fc.setSelectedFile(null);
//                                    lbImage.setIcon(null);
//                                    displayService.tbDV.renderTB();
//                                    displayService.reset();
//                                } else if (check.equals("Thêm dịch vụ mới không thành công")) {
//                                    JOptionPane.showMessageDialog(null, "Thêm không thành công dịch vụ mới có mã: " + txtMaDV_formRight.getText().trim(), "Thông báo", JOptionPane.ERROR_MESSAGE);
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Mã dịch vụ này đã tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                                }
//                            }
//                        }
                    }
                }
            }
        });
    }

    public void setMouse_2(JButton x) {
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

    public void setFont_BorderPainted_setFocusPainted(JButton button, Font font) {
        button.setFont(font);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    public void setFont_setFocusPainted(JButton button, Font font) {
        button.setFont(font);
        button.setFocusPainted(false);
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
                    x.setBackground(Color.decode("#333333"));
                }
            }
        });
    }

    public void actionExit() {
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void setHover(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte3_3_0_0_9cf6ab, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#D8FFDF"));
                } else {
                    x.setBackground(Color.decode("#D8FFDF"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#BCFFC7"));
                } else {
                    x.setBackground(Color.decode("#BCFFC7"));
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
                    x.setBackground(Color.decode("#FEFFDB"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_e4ee5c, bdEmpty5_10_5_10));
                    x.setBackground(Color.decode("#FCFFBF"));
                } else {
                    x.setBackground(Color.decode("#FCFFBF"));
                }
            }
        });
    }

    public void setLayoutPanel_2(JPanel panel, JLabel label, JComboBox combobox) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(combobox, BorderLayout.CENTER);
    }

    public void setLayoutPanel_2(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(textfield, BorderLayout.CENTER);
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = LightDark;
            setBackground(Color.white);
            btnSelectFile.setBackground(Color.decode("#ebf2fc"));
            btnAdd_FormRight.setBackground(Color.decode("#BCFFC7"));
            btnAdd_FormRight.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10));
            btnReset_FormRight.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_e4ee5c, bdEmpty5_10_5_10));
            btnReset_FormRight.setBackground(Color.decode("#FCFFBF"));
            txtMaDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            txtTenDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            txtGiaDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            pnContentRightTop.setBackground(Color.white);
            pnContentRightCenterTopInput.setBackground(Color.white);
            pnContentRightTopLabel.setBackground(Color.white);
            btnExit.setBackground(Color.white);
            pnContentRightTopButton.setBackground(Color.white);
            pnContentRightCenter.setBackground(Color.white);
            pnContentRightCenterBottom.setBackground(Color.white);
            pnMaDV_formRight.setBackground(Color.white);
            pnTenDV_formRight.setBackground(Color.white);
            pnLoaiDV_formRight.setBackground(Color.white);
            pnGiaDV_formRight.setBackground(Color.white);
            pnImgInput.setBackground(Color.white);
            pnContentRightCenterTopImg.setBackground(Color.white);
            pnContentRightCenterTop.setBackground(Color.white);
            cbLoaiDV_formRight.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
            cbLoaiDV_formRight.setBackground(Color.decode("#FFFFFF"));
            txtGiaDV_formRight.setBackground(Color.decode("#FFFFFF"));
            txtMaDV_formRight.setBackground(Color.decode("#FFFFFF"));
            txtGiaDV_formRight.setBackground(Color.decode("#FFFFFF"));
            txtGiaDV_formRight.setForeground(Color.black);
            txtMaDV_formRight.setForeground(Color.black);
            txtTenDV_formRight.setForeground(Color.black);
            cbLoaiDV_formRight.setForeground(Color.black);
            lbContentRightTopDetail.setForeground(Color.black);
            lbContentRightTopTitle.setForeground(Color.black);
            lbGiaDV_formRight.setForeground(Color.black);
            lbImage.setForeground(Color.black);
            lbImg_FormRight.setForeground(Color.black);
            lbLoaiDV_formRight.setForeground(Color.black);
            lbMaDV_formRight.setForeground(Color.black);
            lbTenDV_formRight.setForeground(Color.black);
            txtTenDV_formRight.setBackground(Color.decode("#FFFFFF"));
            btnExit.setForeground(Color.black);
        } else {
            Color black = Color.decode("#333333");
            this.LightDark = LightDark;
            setBackground(black);
            btnSelectFile.setBackground(Color.decode("#ebf2fc"));
            btnAdd_FormRight.setBackground(Color.decode("#BCFFC7"));
            btnAdd_FormRight.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_9cf6ab, bdEmpty5_10_5_10));
            btnReset_FormRight.setBorder(BorderFactory.createCompoundBorder(bdMatte0_0_3_3_e4ee5c, bdEmpty5_10_5_10));
            btnReset_FormRight.setBackground(Color.decode("#FCFFBF"));
            txtMaDV_formRight.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_7));
            txtTenDV_formRight.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_7));
            txtGiaDV_formRight.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_7));
            pnContentRightTop.setBackground(black);
            pnContentRightCenterTopInput.setBackground(black);
            pnContentRightTopLabel.setBackground(black);
            btnExit.setBackground(black);
            pnContentRightTopButton.setBackground(black);
            pnContentRightCenter.setBackground(black);
            pnContentRightCenterBottom.setBackground(black);
            pnMaDV_formRight.setBackground(black);
            pnTenDV_formRight.setBackground(black);
            pnLoaiDV_formRight.setBackground(black);
            pnGiaDV_formRight.setBackground(black);
            pnImgInput.setBackground(black);
            pnContentRightCenterTopImg.setBackground(black);
            pnContentRightCenterTop.setBackground(black);
            cbLoaiDV_formRight.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_0));
            cbLoaiDV_formRight.setBackground(Color.decode("#474747"));
            txtGiaDV_formRight.setBackground(Color.decode("#474747"));
            txtMaDV_formRight.setBackground(Color.decode("#474747"));
            txtGiaDV_formRight.setBackground(Color.decode("#474747"));
            txtGiaDV_formRight.setForeground(Color.white);
            txtMaDV_formRight.setForeground(Color.white);
            txtTenDV_formRight.setForeground(Color.white);
            cbLoaiDV_formRight.setForeground(Color.white);
            lbContentRightTopDetail.setForeground(Color.white);
            lbContentRightTopTitle.setForeground(Color.white);
            lbGiaDV_formRight.setForeground(Color.white);
            lbImage.setForeground(Color.white);
            lbImg_FormRight.setForeground(Color.white);
            lbLoaiDV_formRight.setForeground(Color.white);
            lbMaDV_formRight.setForeground(Color.white);
            lbTenDV_formRight.setForeground(Color.white);
            txtTenDV_formRight.setBackground(Color.decode("#474747"));
            btnExit.setForeground(Color.white);
        }
    }
}
