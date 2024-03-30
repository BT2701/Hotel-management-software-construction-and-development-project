package GUI.GUI_PHONG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PanelPhongReceptionist extends JPanel {

    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();

    JPanel pnTopHeader = new JPanel();
    JPanel pnTopHeaderLeft = new JPanel();
    JPanel pnTopHeaderRight = new JPanel();
    JLabel lbTopHeaderLeftTop = new JLabel("Danh sách phòng");
    JLabel lbTopHeaderLeftBottom = new JLabel("Bấm vào hàng của bảng danh sách phòng để chỉnh sửa");
    JButton btnExportFile = new JButton("Xuất tệp");

    JPanel pnMaP = new JPanel();
    JLabel lbMaP = new JLabel("Mã phòng");
    JTextField txtMaP = new JTextField();
    JPanel pnTenP = new JPanel();
    JLabel lbTenP = new JLabel("Tên phòng");
    JTextField txtTenP = new JTextField();
    JPanel pnLoaiP = new JPanel();
    JLabel lbLoaiP = new JLabel("Loại phòng");
    JComboBox cbLoaiP = new JComboBox();
    JPanel pnChiTietLoaiP = new JPanel();
    JLabel lbChiTietLoaiP = new JLabel("Phòng");
    JComboBox cbChiTietLoaiP = new JComboBox();
    JPanel pnGiaP = new JPanel();
    JLabel lbGiaP = new JLabel("Giá phòng");
    JComboBox cbGiaP = new JComboBox();
    JPanel pnTTP = new JPanel();
    JLabel lbTTP = new JLabel("Tình trạng phòng");
    JComboBox cbTTP = new JComboBox();
    JPanel pnHTP = new JPanel();
    JLabel lbHTP = new JLabel("Hiện trạng phòng");
    JComboBox cbHTP = new JComboBox();
    JPanel pnBtnSearch = new JPanel();

    JButton btnReset = new JButton("Làm mới");
    JButton btnSearch = new JButton("Tìm kiếm");
    JPanel pnEmp = new JPanel();

    ArrayList<JPanel> listPN = new ArrayList<>();

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);

    LineBorder lineCB = new LineBorder(Color.white);

    JPanel pnTopCenter = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentCenterTop = new JPanel();
    JLabel lbContentCentertop = new JLabel("Danh sách phòng khách sạn");
    JScrollPane scp = new JScrollPane();
    JTable tbP = new JTable() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    int LightDark;
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF"));
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
    EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);

    public PanelPhongReceptionist() {
        initComponent();
    }

    public void initComponent() {
        removeAll();

        pnTop.setLayout(new BorderLayout(10, 10));
        pnTop.add(pnTopHeader, BorderLayout.NORTH);
        pnTop.add(pnTopCenter, BorderLayout.CENTER);

        pnTopHeader.setLayout(new BorderLayout());
        pnTopHeader.add(pnTopHeaderLeft, BorderLayout.WEST);
        pnTopHeader.add(pnTopHeaderRight, BorderLayout.CENTER);

        pnTopHeaderLeft.setLayout(new BorderLayout());
        pnTopHeaderLeft.add(lbTopHeaderLeftTop, BorderLayout.CENTER);
        pnTopHeaderLeft.add(lbTopHeaderLeftBottom, BorderLayout.SOUTH);

        pnTopHeaderRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnTopHeaderRight.add(btnExportFile);

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

        ImageIcon iconExport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnExportFile.setIcon(iconExport);
        btnExportFile.setFocusPainted(false);
        btnExportFile.setFont(sgUI13b);
        btnExportFile.setBorderPainted(false);
        setMouse(btnExportFile);

        //edit label 
        lbTopHeaderLeftTop.setFont(sgUI18b);
        lbTopHeaderLeftBottom.setFont(tNR13);
        lbTopHeaderLeftBottom.setBorder(new EmptyBorder(3, 0, 0, 0));
        actionExport();
        actionReset();

        //edit content
        pnTopCenter.setLayout(new GridLayout(2, 5, 10, 5));
        listPN.add(pnMaP);
        listPN.add(pnTenP);
        listPN.add(pnLoaiP);
        listPN.add(pnChiTietLoaiP);
        listPN.add(pnGiaP);
        listPN.add(pnEmp);
        listPN.add(pnTTP);
        listPN.add(pnHTP);
        listPN.add(pnBtnSearch);
        for (JPanel x : listPN) {
            pnTopCenter.add(x);
            x.setLayout(new BorderLayout(18, 10));
        }
        lbMaP.setFont(sgUI13b);
        lbTenP.setFont(sgUI13b);
        lbLoaiP.setFont(sgUI13b);
        lbChiTietLoaiP.setFont(sgUI13b);
        lbGiaP.setFont(sgUI13b);
        lbTTP.setFont(sgUI13b);
        lbHTP.setFont(sgUI13b);

        txtMaP.setFont(sgUI13);
//        txtMaP.setMaximumSize(new Dimension(100, 30));
//        txtMaP.setPreferredSize(new Dimension(100,30));
        txtTenP.setFont(sgUI13);
        cbChiTietLoaiP.setFont(sgUI13);
        cbGiaP.setFont(sgUI13);
        cbTTP.setFont(sgUI13);
        cbHTP.setFont(sgUI13);
        cbLoaiP.setFont(sgUI13);

        String chiTietLoaiP[] = {"Chi tiết loại phòng", "Phòng đơn", "Phòng đôi", "Phòng gia đình"};
        String loaiP[] = {"Loại phòng", "VIP", "Thường"};
        String tTP[] = {"Trạng thái phòng", "Trống", "Đang được thuê", "Chưa dọn phòng", "Đã được đặt", "Chưa có tiện ích"};
        String hTP[] = {"Hiện trạng", "Phòng cũ", "Phòng mới"};
        String giaP[] = {"Giá phòng", "Dưới 100000", "Từ 100000 đến 200000", "Từ 200000 đến 500000", "Từ 500000 đến 1000000", "Trên 1000000"};
        setDefaulComboBox(cbChiTietLoaiP, chiTietLoaiP);
        setDefaulComboBox(cbGiaP, giaP);
        setDefaulComboBox(cbTTP, tTP);
        setDefaulComboBox(cbHTP, hTP);
        setDefaulComboBox(cbLoaiP, loaiP);

        cbChiTietLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbHTP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbTTP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbGiaP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbLoaiP.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        pnMaP.add(lbMaP, BorderLayout.WEST);
        pnMaP.add(txtMaP, BorderLayout.CENTER);
        pnTenP.add(lbTenP, BorderLayout.WEST);
        pnTenP.add(txtTenP, BorderLayout.CENTER);
        pnLoaiP.add(lbLoaiP, BorderLayout.WEST);
        pnLoaiP.add(cbLoaiP, BorderLayout.CENTER);
        pnChiTietLoaiP.add(lbChiTietLoaiP, BorderLayout.WEST);
        pnChiTietLoaiP.add(cbChiTietLoaiP, BorderLayout.CENTER);
        pnGiaP.add(lbGiaP, BorderLayout.WEST);
        pnGiaP.add(cbGiaP, BorderLayout.CENTER);
        pnTTP.add(lbTTP, BorderLayout.WEST);
        pnTTP.add(cbTTP, BorderLayout.CENTER);
        pnHTP.add(lbHTP, BorderLayout.WEST);
        pnHTP.add(cbHTP, BorderLayout.CENTER);
        pnBtnSearch.setLayout(new GridLayout(1, 2, 10, 10));
        pnBtnSearch.add(btnReset);
        pnBtnSearch.add(btnSearch);
        pnTopCenter.setBorder(new EmptyBorder(0, 5, 0, 5));
        setMouse(btnReset);
        setMouse(btnSearch);

        //edit pnContent
        pnContent.setLayout(new BorderLayout(5, 5));
        pnContent.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnContent.add(pnContentCenter, BorderLayout.CENTER);

        pnContentCenter.setLayout(new BorderLayout());
        pnContentCenter.add(pnContentCenterTop, BorderLayout.NORTH);
        pnContentCenter.add(scp, BorderLayout.CENTER);

        pnContentCenterTop.setLayout(new BorderLayout());
        pnContentCenterTop.setBorder(new EmptyBorder(0, 0, 5, 0));
        pnContentCenterTop.add(lbContentCentertop, BorderLayout.WEST);
        lbContentCentertop.setFont(sgUI18b);

        scp.setBorder(BorderFactory.createEmptyBorder());
        scp.setViewportView(tbP);
        renderTB(tbP);

        scp.setViewportBorder(null);

        //edit table
        setBackground(Color.white);
        setLayout(new BorderLayout());
        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);

        lightDark(0);
        revalidate();
        repaint();
    }

    public void renderTB(JTable tbP) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phòng");
        dtm.addColumn("Tên phòng");
        dtm.addColumn("Loại phòng");
        dtm.addColumn("CT phòng");
        dtm.addColumn("Giá phòng");
        dtm.addColumn("Tình trạng");
        dtm.addColumn("Hiện trạng");
        tbP.setModel(dtm);
        for (int i = 0; i < 20; i++) {
            Object data[] = {i + 1, "P001", "Phòng VIP 101", "Phòng VIP", "Phòng đơn", "100000", "Trống", "Mới"};
            dtm.addRow(data);
        }
        tbP.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
        tbP.setShowGrid(false);
        tbP.setIntercellSpacing(new Dimension(0, 0));
        tbP.setRowHeight(35);
        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("STT")).setPreferredWidth(5);
        tbP.getColumnModel().getColumn(tbP.getColumnModel().getColumnIndex("Mã phòng")).setPreferredWidth(20);
        tbP.getTableHeader().setPreferredSize(new Dimension(1, 25));
        tbP.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbP.getTableHeader().setBorder(null);
        tbP.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer renderBorder = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                JLabel lb = (JLabel) c;
                if (column == table.getColumnModel().getColumnIndex("Tình trạng")) {
                    if (lb.getText().equals("Trống")) {
                        lb.setForeground(Color.decode("#339900"));
                    } else if (lb.getText().equals("Đang được thuê")) {
                        lb.setForeground(Color.decode("#CC0000"));
                    } else {
                        lb.setForeground(Color.decode("#FFCC00"));
                    }
                } else {
                    lb.setForeground(Color.black);
                }
                if (column == table.getColumnModel().getColumnIndex("Tình trạng") || column == table.getColumnModel().getColumnIndex("Hiện trạng") || column == table.getColumnModel().getColumnIndex("CT phòng") || column == table.getColumnModel().getColumnIndex("Loại phòng") || column == table.getColumnModel().getColumnIndex("Mã phòng") || column == table.getColumnModel().getColumnIndex("Tên phòng")) {
                    lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
                    lb.setHorizontalAlignment(JLabel.LEFT);
                } else if (column == table.getColumnModel().getColumnIndex("Giá phòng")) {
                    lb.setHorizontalAlignment(JLabel.RIGHT);
                    lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
                } else {
                    lb.setHorizontalAlignment(JLabel.CENTER);
                    lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));
                }
                if (isSelected) {
                    lb.setBackground(Color.decode("#F5F5F5"));
                } else {
                    lb.setBackground(Color.decode("#FFFFFF"));
                }
                return lb;
            }
        };
        for (int j = 0; j < tbP.getColumnCount(); j++) {
            tbP.getColumnModel().getColumn(j).setCellRenderer(renderBorder);
        }
    }

    public void setDefaulComboBox(JComboBox x, String list[]) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String y : list) {
            dcbm.addElement(y);
        }
        x.setModel(dcbm);
    }

    public void actionReset() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run(btnReset, Color.decode("#ebf2fc"));
                cbChiTietLoaiP.setSelectedIndex(0);
                cbGiaP.setSelectedIndex(0);
                cbTTP.setSelectedIndex(0);
                cbHTP.setSelectedIndex(0);
                cbLoaiP.setSelectedIndex(0);
                txtMaP.setText("");
                txtTenP.setText("");
                renderTB(tbP);
            }
        });
    }

    public void actionExport() {
        btnExportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run(btnExportFile, Color.decode("#ebf2fc"));
            }
        });
    }

    public synchronized void run(JButton btn, Color color) {
        new Thread(() -> {
            btn.setLayout(null);
            JPanel pn = new JPanel();
            pn.setBackground(color);
            JPanel pn1 = new JPanel();
            pn1.setBackground(color);
            btn.add(pn);
            btn.add(pn1);
            for (int i = 0; i <= btn.getWidth() / 2; i++) {
                pn.setBounds(0, 0, btn.getWidth() / 2 - i, btn.getHeight());
                pn1.setBounds(btn.getWidth() / 2 + i, 0, btn.getWidth() / 2, btn.getHeight());
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
            }
            btn.remove(pn);
            btn.remove(pn1);
        }).start();
    }

    public void setMouse(JButton x) {
        x.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#98befa"));
                } else {
                    x.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    x.setBackground(Color.decode("#ebf2fc"));
                } else {
                    x.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void lightDark(int lightDark) {
        if (lightDark == 0) {
            pnTop.setBackground(Color.decode("#FAFAFA"));
            pnTopHeader.setBackground(Color.decode("#FAFAFA"));
            pnTopCenter.setBackground(Color.decode("#FAFAFA"));
            pnTopHeaderLeft.setBackground(Color.decode("#FAFAFA"));
            pnTopHeaderRight.setBackground(Color.decode("#FAFAFA"));
            pnContent.setBackground(Color.decode("#FAFAFA"));
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, Color.decode("#FAFAFA")));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            for (JPanel x : listPN) {
                x.setBackground(Color.decode("#FAFAFA"));
            }
            cbChiTietLoaiP.setBorder(matteBorderCB);
            cbHTP.setBorder(matteBorderCB);
            cbTTP.setBorder(matteBorderCB);
            cbGiaP.setBorder(matteBorderCB);
            cbLoaiP.setBorder(matteBorderCB);
            cbGiaP.setBackground(Color.white);
            cbLoaiP.setBackground(Color.white);
            cbChiTietLoaiP.setBackground(Color.white);
            cbTTP.setBackground(Color.white);
            cbHTP.setBackground(Color.white);
            txtMaP.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtTenP.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            pnContentCenter.setBackground(Color.decode("#FAFAFA"));
            pnContentCenterTop.setBackground(Color.decode("#FAFAFA"));
            tbP.getTableHeader().setBackground(Color.decode("#dee9fc"));
        } else {

        }
    }
}
