package GUI.GUI_PHONG;

import BUS.ChiTietTienIchBUS;
import BUS.PhongBUS;
import BUS.TienIchBUS;
import DTO.ChiTietTienIchDTO;
import DTO.PhongDTO;
import DTO.TienIchDTO;
import GUI.GUI_DICHVU.ButtonEditorDV;
import GUI.GUI_DICHVU.ButtonRenderer;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class AddPhongNew extends JDialog {

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JPanel pnTop = new JPanel();
    JPanel pnContainer = new JPanel();
    JLabel lbTop = new JLabel("Thông tin phòng mới");
    JLabel lbTopDetail = new JLabel("Vui lòng nhập thông tin phòng");
    JPanel pnCenter = new JPanel();
    JPanel pnCenterContent = new JPanel();
    JPanel pnCenterBottom = new JPanel();
    JButton btnAcept = new JButton("Thêm phòng");
    JPanel pnCenterInformation = new JPanel();
    JPanel pnCenterContentRoom = new JPanel();
    JLabel lbCenter = new JLabel("Phòng mới                                                                                             ");
    JPanel pnInput = new JPanel();
    JPanel pnMaP = new JPanel();
    JLabel lbMaP = new JLabel("Mã phòng");
    JTextField txtMaP = new JTextField();
    JPanel pnTenP = new JPanel();
    JLabel lbTenP = new JLabel("Tên phòng");
    JTextField txtTenP = new JTextField();
    JPanel pnLoaiP = new JPanel();
    JLabel lbLoaiP = new JLabel("Loại phòng");
    JPanel pnRadioButton = new JPanel();
    ButtonGroup btnGrpLoaiP = new ButtonGroup();
    JRadioButton rdVip = new JRadioButton("VIP");
    JRadioButton rdThuong = new JRadioButton("Thường");
    JPanel pnGiaP = new JPanel();
    JLabel lbGiaP = new JLabel("Giá phòng");
    JTextField txtGiaP = new JTextField();
    JPanel pnChiTietLoaiP = new JPanel();
    JLabel lbChiTietLoaiP = new JLabel("Chi tiết phòng");
    JPanel pnRadioButtonCT = new JPanel();
    JRadioButton rdDon = new JRadioButton("Phòng đơn");
    JRadioButton rdDoi = new JRadioButton("Phòng đôi");
    JRadioButton rdGD = new JRadioButton("Phòng gia đình");
    ButtonGroup btnGrpCT = new ButtonGroup();
    JPanel pnTinhTrang = new JPanel();
    JLabel lbTinhTrang = new JLabel("Tình trạng phòng");
    JTextField txtTT = new JTextField();
    JPanel pnHienTrang = new JPanel();
    JLabel lbHienTrang = new JLabel("Hiện trạng phòng");
    JTextField txtHT = new JTextField();
    TienIch tienIch = new TienIch();

    public AddPhongNew(DisplayRoom displayRoom) {
        initComponents(displayRoom);
    }

    public void initComponents(DisplayRoom displayRoom) {
        setTitle("Thêm phòng mới");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setSize(new Dimension(1300, 750));
        setLocationRelativeTo(null);
        setBackground(Color.decode("#FBFBFB"));
        setModal(true);
        setResizable(false);

        setLayout(new BorderLayout());
        add(pnContainer, BorderLayout.CENTER);

        pnContainer.setLayout(new BorderLayout(5, 5));
        pnContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        pnContainer.add(pnTop, BorderLayout.NORTH);
        pnContainer.add(pnCenter, BorderLayout.CENTER);
        pnTop.setLayout(new GridLayout(2, 1));
        pnTop.add(lbTop);
        pnTop.add(lbTopDetail);
        pnTop.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbTop.setFont(sgUI18b);
        lbTopDetail.setFont(tNR13);

        pnCenter.setLayout(new BorderLayout());
        pnCenter.add(pnCenterContent, BorderLayout.CENTER);
        pnCenter.add(pnCenterBottom, BorderLayout.SOUTH);
        pnCenterBottom.setLayout(new BorderLayout());
        pnCenterBottom.add(btnAcept, BorderLayout.EAST);

        btnAcept.setFocusPainted(false);
        btnAcept.setBorderPainted(false);
        btnAcept.setFont(sgUI13b);

        pnCenterContent.setLayout(new BorderLayout(5, 5));
        pnCenterContent.add(pnCenterInformation, BorderLayout.WEST);
        pnCenterContent.add(pnCenterContentRoom, BorderLayout.CENTER);

        pnCenterInformation.setLayout(new BorderLayout());
        pnCenterInformation.add(lbCenter, BorderLayout.NORTH);
        pnCenterInformation.add(pnInput, BorderLayout.CENTER);

        pnInput.setLayout(new GridLayout(7, 1));
        pnInput.add(pnMaP);
        pnInput.add(pnTenP);
        pnInput.add(pnGiaP);
        pnInput.add(pnLoaiP);
        pnInput.add(pnChiTietLoaiP);
        pnInput.add(pnTinhTrang);
        pnInput.add(pnHienTrang);

        pnMaP.setLayout(new GridLayout(2, 1));
        pnMaP.add(lbMaP);
        pnMaP.add(txtMaP);

        pnTenP.setLayout(new GridLayout(2, 1));
        pnTenP.add(lbTenP);
        pnTenP.add(txtTenP);

        pnGiaP.setLayout(new GridLayout(2, 1));
        pnGiaP.add(lbGiaP);
        pnGiaP.add(txtGiaP);

        pnLoaiP.setLayout(new GridLayout(2, 1));
        pnLoaiP.add(lbLoaiP);
        pnLoaiP.add(pnRadioButton);
        pnRadioButton.setLayout(new GridLayout(1, 2));
        pnRadioButton.add(rdVip);
        pnRadioButton.add(rdThuong);
        btnGrpLoaiP.add(rdVip);
        btnGrpLoaiP.add(rdThuong);
        rdVip.setSelected(true);

        pnChiTietLoaiP.setLayout(new GridLayout(2, 1));
        pnChiTietLoaiP.add(lbChiTietLoaiP);
        pnChiTietLoaiP.add(pnRadioButtonCT);
        pnRadioButtonCT.setLayout(new GridLayout(1, 2));
        pnRadioButtonCT.add(rdDon);
        pnRadioButtonCT.add(rdDoi);
        pnRadioButtonCT.add(rdGD);
        btnGrpCT.add(rdDon);
        btnGrpCT.add(rdDoi);
        btnGrpCT.add(rdGD);
        rdDon.setSelected(true);

        pnTinhTrang.setLayout(new GridLayout(2, 1));
        pnTinhTrang.add(lbTinhTrang);
        pnTinhTrang.add(txtTT);

        pnHienTrang.setLayout(new GridLayout(2, 1));
        pnHienTrang.add(lbHienTrang);
        pnHienTrang.add(txtHT);

        lbMaP.setFont(sgUI13b);
        lbTenP.setFont(sgUI13b);
        lbHienTrang.setFont(sgUI13b);
        lbTinhTrang.setFont(sgUI13b);
        lbLoaiP.setFont(sgUI13b);
        lbGiaP.setFont(sgUI13b);
        lbChiTietLoaiP.setFont(sgUI13b);

        txtMaP.setFont(sgUI13);
        txtTenP.setFont(sgUI13);
        txtHT.setFont(sgUI13);
        txtTT.setFont(sgUI13);
        txtGiaP.setFont(sgUI13);

        rdDoi.setFont(sgUI13);
        rdDon.setFont(sgUI13b);
        rdGD.setFont(sgUI13);
        rdThuong.setFont(sgUI13);
        rdVip.setFont(sgUI13b);

        txtMaP.setEditable(false);
        txtHT.setEditable(false);
        txtTT.setEditable(false);

        rdDoi.setFocusPainted(false);
        rdDoi.setBorderPainted(false);
        rdDon.setFocusPainted(false);
        rdDon.setBorderPainted(false);
        rdGD.setFocusPainted(false);
        rdGD.setBorderPainted(false);
        rdVip.setFocusPainted(false);
        rdVip.setBorderPainted(false);
        rdThuong.setFocusPainted(false);
        rdThuong.setBorderPainted(false);

        rdVip.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdVip.setFont(sgUI13b);
                rdThuong.setFont(sgUI13);
            }
        });
        rdThuong.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdThuong.setFont(sgUI13b);
                rdVip.setFont(sgUI13);
            }
        });
        rdDoi.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdDoi.setFont(sgUI13b);
                rdGD.setFont(sgUI13);
                rdDon.setFont(sgUI13);
            }
        });
        rdDon.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdDon.setFont(sgUI13b);
                rdGD.setFont(sgUI13);
                rdDoi.setFont(sgUI13);
            }
        });
        rdGD.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rdGD.setFont(sgUI13b);
                rdDoi.setFont(sgUI13);
                rdDon.setFont(sgUI13);
            }
        });

        pnCenterContentRoom.setLayout(new BorderLayout());
        pnCenterContentRoom.add(tienIch, BorderLayout.CENTER);

        pnCenterInformation.setBorder(new EmptyBorder(0, 5, 0, 5));
        lbCenter.setFont(sgUI13b);
        lbCenter.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 3, 0, Color.decode("#eeeeee")), new EmptyBorder(5, 0, 5, 5)));

        txtMaP.setBackground(Color.decode("#F8f8f8"));
        txtHT.setBackground(Color.decode("#F8f8f8"));
        txtTT.setBackground(Color.decode("#F8f8f8"));
        pnCenterContentRoom.setBackground(Color.decode("#FAFAFA"));
        txtMaP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTenP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtGiaP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtHT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        txtTT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 7, 0, 7)));
        pnCenterInformation.setBackground(Color.decode("#FDFDFD"));
        pnMaP.setBackground(Color.decode("#FDFDFD"));
        pnTenP.setBackground(Color.decode("#FDFDFD"));
        pnGiaP.setBackground(Color.decode("#FDFDFD"));
        pnLoaiP.setBackground(Color.decode("#FDFDFD"));
        pnChiTietLoaiP.setBackground(Color.decode("#FDFDFD"));
        pnHienTrang.setBackground(Color.decode("#FDFDFD"));
        pnTinhTrang.setBackground(Color.decode("#FDFDFD"));
        pnInput.setBackground(Color.decode("#FDFDFD"));
        pnRadioButton.setBackground(Color.decode("#FDFDFD"));
        pnRadioButtonCT.setBackground(Color.decode("#FDFDFD"));
        rdDoi.setBackground(Color.decode("#FDFDFD"));
        rdDon.setBackground(Color.decode("#FDFDFD"));
        rdGD.setBackground(Color.decode("#FDFDFD"));
        rdThuong.setBackground(Color.decode("#FDFDFD"));
        rdVip.setBackground(Color.decode("#FDFDFD"));
        pnTop.setBackground(Color.decode("#ebf2fc"));
        pnContainer.setBackground(Color.decode("#FBFBFB"));
        pnCenterContent.setBackground(Color.decode("#FAFAFA"));
        pnCenterBottom.setBackground(Color.decode("#FDFDFD"));
        pnCenter.setBackground(Color.decode("#FDFDFD"));
        btnAcept.setBackground(Color.decode("#CCFFCC"));
        btnAcept.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAcept.setBackground(Color.decode("#99ff99"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAcept.setBackground(Color.decode("#CCFFCC"));
            }
        });
        txtHT.setText("Mới");
        txtTT.setText("Trống");
        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTenP.getText().trim().length() == 0) {
                    new ThongBaoDialog("Vui lòng nhập tên phòng", 1);
                    txtTenP.setText("");
                    txtTenP.requestFocus();
                } else {
                    if (txtGiaP.getText().trim().length() == 0) {
                        new ThongBaoDialog("Vui lòng nhập giá phòng", 1);
                        txtGiaP.setText("");
                        txtGiaP.requestFocus();
                    } else {
                        try {
                            int gia = Integer.parseInt(txtGiaP.getText().trim());
                            if (gia <= 0) {
                                new ThongBaoDialog("Giá phòng phải là số lớn hơn 0", 1);
                                txtGiaP.setText("");
                                txtGiaP.requestFocus();
                            } else {
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyy");
                                LocalDate now = LocalDate.now();
                                String nowString = now.format(dateTimeFormatter);
                                txtMaP.setText("P" + nowString);
                                int count = PhongBUS.getCountPhong();
                                String str = String.format("%03d", count);
                                txtMaP.setText(txtMaP.getText() + str);
//                                if (count < 10) {
//                                    txtMaP.setText(txtMaP.getText() + "000" + count);
//                                } else {
//                                    txtMaP.setText(txtMaP.getText() + "00" + count);
//                                }
                                PhongDTO phong = new PhongDTO();
                                phong.setMaP(txtMaP.getText());
                                phong.setTenP(txtTenP.getText());
                                phong.setGiaP(gia);
                                phong.setTinhTrang(0);
                                phong.setHienTrang(0);
                                phong.setChiTietLoaiP(getSelectedButtonText(btnGrpCT));
                                phong.setLoaiP(getSelectedButtonText(btnGrpLoaiP));
                                phong.setXuLy(0);
                                String check = PhongBUS.insertP(phong);
                                if (check.equals("Thêm phòng mới thành công")) {
                                    ArrayList<ChiTietTienIchDTO> listTI = new ArrayList<>();
                                    for (ItemTienIch x : tienIch.listItem) {
                                        ChiTietTienIchDTO tienIch = new ChiTietTienIchDTO();
                                        tienIch.setMaP(txtMaP.getText());
                                        tienIch.setMaTI(x.getMaTI());
                                        tienIch.setSoLuong(x.getSoLuong());
                                        listTI.add(tienIch);
                                    }
                                    int checkCount = 0;
                                    int checkCountUpdateSL = 0;
                                    for (ChiTietTienIchDTO x : listTI) {
                                        checkCount += ChiTietTienIchBUS.insertCTTI(x);
                                        checkCountUpdateSL += TienIchBUS.updateSL(x.getMaTI(), -x.getSoLuong());
                                    }
                                    if (checkCount == listTI.size() && checkCountUpdateSL == listTI.size()) {
                                        new ThongBaoDialog("Thêm thành công phòng mới có mã phòng: " + txtMaP.getText(), 2);
                                        displayRoom.tbP.renderTB();
                                        dispose();
                                    } else {
                                        new ThongBaoDialog("Thêm thành công phòng mới có mã phòng: " + txtMaP.getText() + "\nThêm tiện ích phòng không thành công", 1);
                                        displayRoom.tbP.renderTB();
                                        dispose();
                                    }
                                } else if (check.equals("Thêm phòng mới không thành công")) {
                                    new ThongBaoDialog("Thêm không thành công phòng mới có mã phòng: " + txtMaP.getText(), 1);
                                } else {
                                    new ThongBaoDialog("Phòng này đã tồn tại", 1);
                                }
                            }
                        } catch (Exception ex) {
                            new ThongBaoDialog("Giá phòng phải là số lớn hơn 0", 1);
                            txtGiaP.setText("");
                            txtGiaP.requestFocus();
                        }
                    }
                }
            }
        });

        setVisible(true);
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    class TienIch extends JPanel {

        ArrayList<ItemTienIch> listItem = new ArrayList<>();
        JPanel pnTienIchTable = new JPanel();
        JPanel pnTienIchItem = new JPanel();
        JPanel pnTienIchItemContent = new JPanel();
        JLabel lbTienIchTable = new JLabel("Danh sách tiện ích");
        JLabel lbTienIchItem = new JLabel("Danh sách tiện ích của phòng                         ");
        JPanel pnTienIchTableTop = new JPanel();
        JPanel pnTienIchTableSearch = new JPanel();
        JLabel lbImgSearch = new JLabel();
        JTextField txtSearch = new JTextField();
        JScrollPane scp = new JScrollPane();
        JScrollPane scpItem = new JScrollPane();
        ScrollBar scbarItem = new ScrollBar(Color.decode("#FFFFFF"), Color.white, 0);
        JTable tb = new JTable() {
            @Override
            public boolean isCellEditable(int row, int col) {
                if (col == 4) {
                    return true;
                }
                return false;
            }
        };

        ButtonEditorDV editor = new ButtonEditorDV(new JCheckBox());

        public TienIch() {
            txtSearch.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    txtSearch.setText("");
                    renderTB();
                }
            });
            txtSearch.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (txtSearch.getText().length() == 0) {
                        renderTB();
                    } else {
                        ArrayList<TienIchDTO> listTI = new ArrayList<>();
                        for (TienIchDTO x : TienIchBUS.getListTI()) {
                            if (x.getTenTI().toUpperCase().contains(txtSearch.getText().trim().toUpperCase())) {
                                listTI.add(x);
                            }
                        }
                        renderTB(listTI);
                    }
                }
            });
            setLayout(new BorderLayout(5, 5));
            add(pnTienIchTable, BorderLayout.CENTER);
            add(pnTienIchItem, BorderLayout.EAST);
            setBackground(Color.decode("#FAFAFA"));
            pnTienIchTable.setBackground(Color.decode("#FAFAFA"));
            pnTienIchItem.setBackground(Color.decode("#FAFAFA"));
            pnTienIchTable.setLayout(new BorderLayout());
            pnTienIchTable.add(pnTienIchTableTop, BorderLayout.NORTH);
            pnTienIchTable.add(scp, BorderLayout.CENTER);
            pnTienIchTableTop.setLayout(new GridLayout(1, 2));
            pnTienIchTableTop.add(lbTienIchTable);
            pnTienIchTableTop.add(pnTienIchTableSearch);
            pnTienIchTableSearch.setLayout(new BorderLayout());
            pnTienIchTableSearch.add(lbImgSearch, BorderLayout.WEST);
            pnTienIchTableSearch.add(txtSearch, BorderLayout.CENTER);
            txtSearch.setFont(sgUI13);
            ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/IconFind.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            lbImgSearch.setIcon(iconSearch);
            lbTienIchTable.setFont(sgUI15b);
            lbImgSearch.setOpaque(true);
            lbImgSearch.setBackground(Color.white);
            lbImgSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnTienIchItem.setLayout(new BorderLayout());
            pnTienIchItem.add(lbTienIchItem, BorderLayout.NORTH);
            pnTienIchItem.add(scpItem, BorderLayout.CENTER);
            scpItem.setViewportView(pnTienIchItemContent);

            pnTienIchItemContent.setLayout(new BoxLayout(pnTienIchItemContent, BoxLayout.Y_AXIS));
            lbTienIchItem.setFont(sgUI15b);
            lbTienIchItem.setBorder(new EmptyBorder(9, 5, 9, 5));
            lbTienIchItem.setOpaque(true);
            scp.setBorder(BorderFactory.createEmptyBorder());
            scp.setBackground(Color.decode("#dee9fc"));
            scp.getViewport().setBackground(Color.decode("#FAFAFA"));
            scp.setViewportView(tb);
            scpItem.setBorder(BorderFactory.createEmptyBorder());
            scpItem.setBackground(Color.decode("#dee9fc"));
            scpItem.getViewport().setBackground(Color.decode("#FAFAFA"));
            scpItem.setVerticalScrollBar(scbarItem);
            pnTienIchItemContent.setBorder(new EmptyBorder(5, 0, 0, 0));
            tb.getTableHeader().setBackground(Color.decode("#dee9fc"));
            lbTienIchItem.setBackground(Color.decode("#ebf2fc"));
            pnTienIchTableTop.setBackground(Color.decode("#ebf2fc"));
            pnTienIchTableTop.setBorder(new EmptyBorder(5, 5, 5, 5));
            lbTienIchTable.setForeground(Color.decode("#33419C"));
            lbTienIchItem.setForeground(Color.decode("#33419C"));
            pnTienIchItemContent.setBackground(Color.decode("#FAFAFA"));
            txtSearch.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#FFFFFF")), new EmptyBorder(5, 5, 5, 5)));
            renderTB();
            editor.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        pnTienIchItemContent.revalidate();
                        String maTI = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã tiện ích")).toString();
                        boolean check = false;
                        for (ItemTienIch item : listItem) {
                            if (item.getMaTI().equals(maTI)) {
                                if (item.getSoLuong() < item.getMaximum()) {
                                    item.setSoLuong(item.getSoLuong() + 1);
                                }
                                check = true;
                                break;
                            }
                        }
                        if (!check) {
                            String tenTI = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Tên tiện ích")).toString();
                            int soLuong = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Số lượng")).toString());
                            ItemTienIch newItem = new ItemTienIch(maTI, tenTI, soLuong);
                            pnTienIchItemContent.add(newItem);
                            newItem.setMaximumSize(new Dimension(pnTienIchItemContent.getWidth(), 100));
                            listItem.add(newItem);
                        }
                        AddEventDelete();
                    } catch (Exception ex) {

                    }
                }
            });
        }

        public void AddEventDelete() {
            for (ItemTienIch item : listItem) {
                item.btnExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < listItem.size(); i++) {
                            if (listItem.get(i).equals(item)) {
                                listItem.remove(i);
                                break;
                            }
                        }
                        pnTienIchItemContent.removeAll();
                        pnTienIchItemContent.revalidate();
                        pnTienIchItemContent.repaint();
                        for (ItemTienIch item : listItem) {
                            pnTienIchItemContent.add(item);
                            item.setMaximumSize(new Dimension(pnTienIchItemContent.getWidth(), 100));
                        }
                    }
                });
            }
        }

        public void renderTB() {
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 4) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            dtm.addColumn("STT");
            dtm.addColumn("Mã tiện ích");
            dtm.addColumn("Tên tiện ích");
            dtm.addColumn("Số lượng");
            dtm.addColumn("Chức năng");
            ArrayList<TienIchDTO> listTI = new ArrayList<>();
            for (TienIchDTO x : TienIchBUS.getListTI()) {
                listTI.add(x);
            }
            for (int i = 0; i < listTI.size(); i++) {
                Object data[] = {i + 1, listTI.get(i).getMaTI() + "", listTI.get(i).getTenTI() + "", listTI.get(i).getSoLuong() + "", "Thêm"};
                dtm.addRow(data);
            }
            tb.setModel(dtm);
            tb.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
            tb.getColumnModel().getColumn(4).setCellEditor(editor);
            tb.setDefaultRenderer(Object.class, new TableTienIchTableCellRenderer());
            tb.setRowHeight(30);
            tb.setShowGrid(false);
            tb.setIntercellSpacing(new Dimension(0, 0));
            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tb.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        public void renderTB(ArrayList<TienIchDTO> listTI) {
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 4) {
                        return Boolean.class;
                    } else {
                        return super.getColumnClass(columnIndex);
                    }
                }
            };
            dtm.addColumn("STT");
            dtm.addColumn("Mã tiện ích");
            dtm.addColumn("Tên tiện ích");
            dtm.addColumn("Số lượng");
            dtm.addColumn("Chức năng");
            for (int i = 0; i < listTI.size(); i++) {
                Object data[] = {i + 1, listTI.get(i).getMaTI() + "", listTI.get(i).getTenTI() + "", listTI.get(i).getSoLuong() + "", "Thêm"};
                dtm.addRow(data);
            }
            tb.setModel(dtm);
            tb.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
            tb.getColumnModel().getColumn(4).setCellEditor(editor);
            tb.setDefaultRenderer(Object.class, new TableTienIchTableCellRenderer());
            tb.setRowHeight(30);
            tb.setShowGrid(false);
            tb.setIntercellSpacing(new Dimension(0, 0));
            tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
            tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tb.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb.getColumnModel().getColumn(1).setPreferredWidth(120);
            tb.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb.getColumnModel().getColumn(4).setPreferredWidth(100);
        }
    }
}
