package GUI.GUI_PHONG;

import BUS.PhongBUS;
import DTO.PhongDTO;
import GUI.GUI_DATPHONG.DatPhongNew;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class SoDoPhongReceptionist extends JDialog {

    /////////////////////////////////////////////////////////////////////////////////////////////
    LineBorder lineCB = new LineBorder(Color.white);
    ArrayList<JPanel> listPN = new ArrayList<>();
    JPanel pnLoaiP = new JPanel();
    JLabel lbLoaiP = new JLabel("Loại phòng");
    JComboBox cbLoaiP = new JComboBox();
    JPanel pnChiTietLoaiP = new JPanel();
    JLabel lbChiTietLoaiP = new JLabel("Phòng");
    JComboBox cbChiTietLoaiP = new JComboBox();
    JPanel pnGiaP = new JPanel();
    JLabel lbGiaP = new JLabel("Giá phòng");
    JComboBox cbGiaP = new JComboBox();
    JPanel pnHTP = new JPanel();
    JLabel lbHTP = new JLabel("Hiện trạng phòng");
    JComboBox cbHTP = new JComboBox();
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    JPanel pnTitle = new JPanel();
    JLabel lbDetail = new JLabel("Vui lòng chọn phòng khách muốn đặt");

    /////////////////////////////////////////////////////////////////////////////////////////////
    private JButton[] btnTrangThai = new JButton[1];
    private ArrayList<ItemCellRoom> ListLbPhong = new ArrayList<>();
    private ArrayList<JPanel> ListpanelCenter = new ArrayList<>();
    private JLabel title;
    private JPanel pnTop, pnTopCenter, pnTopTop, pnCenter, pnTopTopCenter;
    private JScrollPane scrTTphong;

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 20);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontTable = new Font("Tahoma", Font.BOLD, 13);
    JPanel pnTopCenterTop = new JPanel();
    ArrayList<PhongDTO> listP = new ArrayList<>();
    DatPhongNew datPhongNew;
    int tt;
    LocalDateTime dateTimeThue, dateTimeTra;

    public SoDoPhongReceptionist(ArrayList<PhongDTO> listP, DatPhongNew datPhongNew, ArrayList<Object[]> listPT, int tt, LocalDateTime dateTimeThue, LocalDateTime dateTimeTra) {
        this.tt = tt;
        this.dateTimeThue = dateTimeThue;
        this.dateTimeTra = dateTimeTra;
        this.datPhongNew = datPhongNew;
        for (PhongDTO x : listP) {
            boolean check = false;
            for (Object[] data : listPT) {
                if (x.getMaP().trim().equals(data[0].toString().trim())) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                this.listP.add(x);
            }
        }
        initComponent(this.listP, datPhongNew, tt, dateTimeThue, dateTimeTra);
    }

    public void initComponent(ArrayList<PhongDTO> listP, DatPhongNew datPhongNew, int tt, LocalDateTime dateTimeThue, LocalDateTime dateTimeTra) {
        setTitle("Sơ đồ phòng");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setSize(new Dimension(1500, 750));
        setLocationRelativeTo(null);
        setBackground(Color.decode("#FBFBFB"));
        setModal(true);
        setResizable(false);
        title = new JLabel("Sơ đồ phòng");
        lbDetail.setFont(tNR13);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pnTopTopCenter = new JPanel();

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        pnTopTopCenter.setBorder(new EmptyBorder(0, 5, 0, 5));
        pnTopTopCenter.setLayout(new GridLayout(1, 4, 10, 10));
        pnTopTopCenter.setPreferredSize(new Dimension(100, 30));
        pnTopTopCenter.setMaximumSize(new Dimension(100, 30));
        listPN.add(pnLoaiP);
        listPN.add(pnChiTietLoaiP);
        listPN.add(pnGiaP);
        listPN.add(pnHTP);
        for (JPanel x : listPN) {
            pnTopTopCenter.add(x);
            x.setLayout(new BorderLayout(18, 10));
        }
        lbLoaiP.setFont(sgUI15);
        lbChiTietLoaiP.setFont(sgUI15);
        lbGiaP.setFont(sgUI15);
        lbHTP.setFont(sgUI15);
        cbChiTietLoaiP.setFont(sgUI13);
        cbGiaP.setFont(sgUI13);
        cbHTP.setFont(sgUI13);
        cbLoaiP.setFont(sgUI13);

        String chiTietLoaiP[] = {"Chi tiết loại phòng", "Phòng đơn", "Phòng đôi", "Phòng gia đình"};
        String loaiP[] = {"Loại phòng", "VIP", "Thường"};
        String tTP[] = {"Trạng thái phòng", "Trống", "Đang được thuê", "Chưa dọn phòng", "Đã được đặt", "Chưa có tiện ích"};
        String hTP[] = {"Hiện trạng", "Phòng cũ", "Phòng mới"};
        String giaP[] = {"Giá phòng", "Dưới 100000", "Từ 100000 đến 200000", "Từ 200000 đến 500000", "Từ 500000 đến 1000000", "Trên 1000000"};
        setDefaulComboBox(cbChiTietLoaiP, chiTietLoaiP);
        setDefaulComboBox(cbGiaP, giaP);
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
        pnLoaiP.add(lbLoaiP, BorderLayout.WEST);
        pnLoaiP.add(cbLoaiP, BorderLayout.CENTER);
        pnChiTietLoaiP.add(lbChiTietLoaiP, BorderLayout.WEST);
        pnChiTietLoaiP.add(cbChiTietLoaiP, BorderLayout.CENTER);
        pnGiaP.add(lbGiaP, BorderLayout.WEST);
        pnGiaP.add(cbGiaP, BorderLayout.CENTER);
        pnHTP.add(lbHTP, BorderLayout.WEST);
        pnHTP.add(cbHTP, BorderLayout.CENTER);

        pnTopTopCenter.setBackground(Color.white);

        pnTopTop = new JPanel();
        pnTopTop.setLayout(new BorderLayout());
        pnTopTop.add(pnTitle, BorderLayout.NORTH);
        pnTopTop.add(pnTopTopCenter, BorderLayout.CENTER);
        pnTopTop.setBackground(Color.white);

        pnTitle.setLayout(new GridLayout(2, 1));
        pnTitle.add(title);
        pnTitle.add(lbDetail);
        pnTitle.setBorder(new EmptyBorder(0, 5, 0, 5));

        btnTrangThai[0] = new JButton("Làm mới");

        btnTrangThai[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbLoaiP.setSelectedIndex(0);
                cbChiTietLoaiP.setSelectedIndex(0);
                cbGiaP.setSelectedIndex(0);
                cbHTP.setSelectedIndex(0);

                ArrayList<PhongDTO> listP = PhongBUS.getListP();
                renderCell(listP);
            }
        });

        btnTrangThai[0].setFont(sgUI13);
        btnTrangThai[0].setFocusPainted(false);
        btnTrangThai[0].setBackground(Color.decode("#dee9fc"));

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pnTopCenter = new JPanel();
        pnTopCenter.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pnTopCenter.setBackground(Color.white);
        for (JButton jButton : btnTrangThai) {
            pnTopCenter.add(jButton);
        }

        pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.add(pnTopTop, BorderLayout.NORTH);
        pnTop.add(pnTopCenterTop, BorderLayout.CENTER);
        pnTopCenterTop.setLayout(new GridLayout(1, 1));
        pnTopCenterTop.add(pnTopCenter);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pnCenter = new JPanel();
//		pnCenter.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.setBackground(Color.decode("#FAFAFA"));
        renderCell(listP);

        scrTTphong = new JScrollPane();
        scrTTphong.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        scrTTphong.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scrTTphong.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);/
        scrTTphong.setViewportView(pnCenter);
        scrTTphong.getVerticalScrollBar().setUnitIncrement(10);
//        scrTTphong.getHorizontalScrollBar().setUnitIncrement(10);
        scrTTphong.setVerticalScrollBar(new ScrollBar(Color.decode("#66ff66"), Color.decode("#FFFFFF")));
        this.setBackground(Color.decode("#FAFAFA"));
        this.setLayout(new BorderLayout());
        this.add(pnTop, BorderLayout.NORTH);
        this.add(scrTTphong, BorderLayout.CENTER);
        lightDark(0);
        cbChiTietLoaiP.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                renderCell(search(listP));
            }
        });
        cbGiaP.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                renderCell(search(listP));
            }
        });
        cbHTP.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                renderCell(search(listP));
            }
        });
        cbLoaiP.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                renderCell(search(listP));
            }
        });
        setVisible(true);
    }

    public void renderCell(ArrayList<PhongDTO> listP) {
        pnCenter.removeAll();
        pnCenter.revalidate();
        pnCenter.repaint();
        ListLbPhong.clear();
        ListpanelCenter.clear();
        for (int i = 0; i < listP.size(); i++) {
            ItemCellRoom itemCell = new ItemCellRoom(listP.get(i), datPhongNew, tt, dateTimeThue, dateTimeTra , SoDoPhongReceptionist.this);
            ListLbPhong.add(itemCell);
        }
        int countBtnInPanel = 0;
        JPanel pnBtn = new JPanel();
        pnBtn.setLayout(new GridLayout(1, 5, 10, 10));
        pnBtn.setBorder(new EmptyBorder(0, 0, 10, 0));
        pnBtn.setBackground(Color.decode("#FFFFFF"));
        for (int i = 0; i < ListLbPhong.size(); i++) {
            if (countBtnInPanel == 5) {
                ListpanelCenter.add(pnBtn);
                pnBtn = new JPanel();
                pnBtn.setBackground(Color.decode("#FFFFFF"));
                pnBtn.setLayout(new GridLayout(1, 5, 10, 10));
                pnBtn.setBorder(new EmptyBorder(0, 0, 10, 0));
                countBtnInPanel = 0;
            }
            pnBtn.add(ListLbPhong.get(i));
            countBtnInPanel++;
            if (i == ListLbPhong.size() - 1) {
                for (int y = countBtnInPanel; y < 5; y++) {
                    JPanel pnEmp = new JPanel();
                    pnEmp.setBackground(Color.decode("#FFFFFF"));
//                    pnEmp.setFocusPainted(false);
                    pnEmp.setEnabled(false);
//                    pnEmp.setBorderPainted(false);
                    pnBtn.add(pnEmp);
                }
                ListpanelCenter.add(pnBtn);
            }
        }
        for (JPanel pn : ListpanelCenter) {
            pnCenter.add(pn);
        }
        if (ListpanelCenter.size() < 3) {
            for (int i = ListpanelCenter.size(); i < 3; i++) {
                JPanel pn = new JPanel();
                pn.setBackground(Color.white);
                pnCenter.add(pn);
            }
        }
    }

    public void lightDark(int options) {
        if (options == 0) {
            setBackground(Color.decode("#FAFAFA"));
            pnCenter.setBackground(Color.decode("#FAFAFA"));
            cbGiaP.setBackground(Color.white);
            cbLoaiP.setBackground(Color.white);
            cbChiTietLoaiP.setBackground(Color.white);
            cbHTP.setBackground(Color.white);
            cbChiTietLoaiP.setBorder(matteBorderCB);
            cbHTP.setBorder(matteBorderCB);
            cbGiaP.setBorder(matteBorderCB);
            cbLoaiP.setBorder(matteBorderCB);
            pnGiaP.setBackground(Color.decode("#FAFAFA"));
            pnHTP.setBackground(Color.decode("#FAFAFA"));
            pnTopTopCenter.setBackground(Color.decode("#FAFAFA"));
            pnLoaiP.setBackground(Color.decode("#FAFAFA"));
            pnChiTietLoaiP.setBackground(Color.decode("#FAFAFA"));
            pnTitle.setBackground(Color.decode("#FAFAFA"));
            pnTopCenter.setBackground(Color.decode("#FAFAFA"));
            scrTTphong.setBackground(Color.decode("#FFFFFF"));
        }
    }

    public void setDefaulComboBox(JComboBox x, String list[]) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String y : list) {
            dcbm.addElement(y);
        }
        x.setModel(dcbm);
    }

    public ArrayList<PhongDTO> search(ArrayList<PhongDTO> listP) {
        ArrayList<PhongDTO> list = new ArrayList<>();
        for (PhongDTO x : listP) {
            list.add(x);
        }
        ArrayList<PhongDTO> listTmp = new ArrayList<>();
        if (cbLoaiP.getSelectedIndex() != 0) {
            for (PhongDTO x : list) {
                if (x.getLoaiP().equalsIgnoreCase(cbLoaiP.getSelectedItem().toString())) {
                    listTmp.add(x);
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }

        if (cbChiTietLoaiP.getSelectedIndex() != 0) {
            for (PhongDTO x : list) {
                if (x.getChiTietLoaiP().equalsIgnoreCase(cbChiTietLoaiP.getSelectedItem().toString())) {
                    listTmp.add(x);
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }

        if (cbHTP.getSelectedIndex() != 0) {
            for (PhongDTO x : list) {
                if (x.getHienTrang() == cbChiTietLoaiP.getSelectedIndex() - 1) {
                    listTmp.add(x);
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }
        if (cbGiaP.getSelectedIndex() != 0) {
            if (cbGiaP.getSelectedIndex() == 1) {
                for (PhongDTO x : list) {
                    if (x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(1).toString().split("Dưới ")[1])) {
                        listTmp.add(x);
                    }
                }
            } else if (cbGiaP.getSelectedIndex() == 5) {
                for (PhongDTO x : list) {
                    if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(5).toString().split("Trên ")[1])) {
                        listTmp.add(x);
                    }
                }
            } else {
                for (PhongDTO x : list) {
                    if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                            && x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                        listTmp.add(x);
                    }
                }
            }
            list.clear();
            for (PhongDTO x : listTmp) {
                list.add(x);
            }
            listTmp.clear();
        }
        return list;
    }

}
