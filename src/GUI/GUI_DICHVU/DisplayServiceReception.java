package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import DTO.DichVuDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class DisplayServiceReception extends JPanel {
    
    JPanel pnTop, pnContent, pnContentInput, pnMaDV, pnTenDV, pnLoaiDV, pnGiaDV, pnButton, pnTopHeader,
            pnTopButton, pnContentCenter, pnContentLeft;
    JLabel lbTopTitle, lbTopDetail, lbMaDV, lbTenDV, lbLoaiDV, lbGiaDV,
            lbContentLeft;
    JTextField txtMaDV, txtTenDV;
    JComboBox cbLoaiDV, cbGiaDV;
    JButton btnReset, btnSearch;
    Font sgUI13b, sgUI13, sgUI18b, tNR13i;
    JScrollPane scpDV;
    TableDichVu tbDV;
    Border bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7, bdEmpty0_7_0_0;
    ScrollBar scrB;
    int LightDark;
//    DisplayServiceFormInput formInput = new DisplayServiceFormInput();

    public DisplayServiceReception() {
        LightDark = 0;
        //new 
        pnTop = new JPanel();
        lbTopTitle = new JLabel("Quản lý dịch vụ");
        lbTopDetail = new JLabel("Bấm vào hàng của danh sách dịch vụ để chỉnh sửa");
        pnContentInput = new JPanel();
        pnContent = new JPanel();
        pnMaDV = new JPanel();
        lbMaDV = new JLabel("Mã dịch vụ");
        txtMaDV = new JTextField();
        pnTenDV = new JPanel();
        lbTenDV = new JLabel("Tên dịch vụ");
        txtTenDV = new JTextField();
        pnLoaiDV = new JPanel();
        lbLoaiDV = new JLabel("Loại dịch vụ");
        cbLoaiDV = new JComboBox();
        pnGiaDV = new JPanel();
        lbGiaDV = new JLabel("Giá dịch vụ:");
        cbGiaDV = new JComboBox();
        pnTopHeader = new JPanel();
        pnTopButton = new JPanel();
        sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
        sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
        sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
        tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
        pnContentCenter = new JPanel();
        pnContentLeft = new JPanel();
        scpDV = new JScrollPane();
        tbDV = new TableDichVu();
        
        lbContentLeft = new JLabel("Danh sách dịch vụ");
        scrB = new ScrollBar(Color.decode("#ebf2fc"), Color.white);
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdEmpty0_7_0_7 = new EmptyBorder(0, 7, 0, 7);
        bdEmpty0_7_0_0 = new EmptyBorder(0, 7, 0, 0);
        pnButton = new JPanel();
        btnReset = new JButton("Làm mới");
        btnSearch = new JButton("Tìm kiếm");
        //new 
        initComponents();
    }
    
    public void initComponents() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(pnTopHeader, BorderLayout.NORTH);
        
        pnTopHeader.setLayout(new BorderLayout());
        pnTopHeader.add(pnTop, BorderLayout.WEST);
        pnTopHeader.add(pnTopButton, BorderLayout.CENTER);
        
        pnTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnTop.add(lbTopTitle);
        pnTop.add(lbTopDetail);
        
        pnTopButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lbTopTitle.setFont(sgUI18b);
        lbTopDetail.setFont(tNR13i);
        
        add(pnContent, BorderLayout.CENTER);
        pnContent.setLayout(new BorderLayout(5, 5));
        pnContent.add(pnContentInput, BorderLayout.NORTH);
        pnContent.add(pnContentCenter, BorderLayout.CENTER);
        
        pnContentInput.setPreferredSize(new Dimension(0, 30));
        pnContentInput.setLayout(new GridLayout(1, 5, 10, 10));
        pnContentInput.add(pnMaDV);
        pnContentInput.add(pnTenDV);
        pnContentInput.add(pnLoaiDV);
        pnContentInput.add(pnGiaDV);
        pnContentInput.add(pnButton);
        
        setLayoutPanel(pnMaDV, lbMaDV, txtMaDV);
        setLayoutPanel(pnTenDV, lbTenDV, txtTenDV);
        setLayoutPanel(pnLoaiDV, lbLoaiDV, cbLoaiDV);
        setLayoutPanel(pnGiaDV, lbGiaDV, cbGiaDV);
        
        lbMaDV.setFont(sgUI13b);
        lbTenDV.setFont(sgUI13b);
        lbLoaiDV.setFont(sgUI13b);
        lbGiaDV.setFont(sgUI13b);
        
        pnButton.setLayout(new GridLayout(1, 2, 10, 10));
        pnButton.add(btnReset);
        pnButton.add(btnSearch);
        
        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);
        
        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        
        setMouse(btnReset);
        setMouse(btnSearch);
        
        cbGiaDV.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });
        cbLoaiDV.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });
        cbLoaiDV.removeAllItems();
        cbLoaiDV.addItem("Chọn loại dịch vụ");
        cbLoaiDV.addItem("Thức ăn đồ uống");
        cbLoaiDV.addItem("Ăn uống");
        cbLoaiDV.addItem("Chăm sóc sắc đẹp");
        cbLoaiDV.addItem("Tổ chức tiệc");
        cbLoaiDV.addItem("Giải trí");
        
        cbGiaDV.removeAllItems();
        cbGiaDV.addItem("Chọn giá dịch vụ");
        cbGiaDV.addItem("Dưới 100000");
        cbGiaDV.addItem("Từ 100000 đến 200000");
        cbGiaDV.addItem("Từ 200000 đến 500000");
        cbGiaDV.addItem("Từ 500000 đến 1000000");
        cbGiaDV.addItem("Từ 1000000 đến 2000000");
        cbGiaDV.addItem("Từ 2000000 đến 5000000");
        cbGiaDV.addItem("Trên 5000000");
        
        txtMaDV.setFont(sgUI13);
        txtTenDV.setFont(sgUI13);
        cbLoaiDV.setFont(sgUI13);
        cbGiaDV.setFont(sgUI13);
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaDV.setText("");
                txtTenDV.setText("");
                cbGiaDV.setSelectedIndex(0);
                cbLoaiDV.setSelectedIndex(0);
                tbDV.renderTB();
            }
        });
        
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaDV.getText().trim().length() == 0 && txtTenDV.getText().trim().length() == 0
                        && cbGiaDV.getSelectedIndex() == 0 && cbLoaiDV.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần tìm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    tbDV.renderTB();
                } else {
                    ArrayList<DichVuDTO> listAll = DichVuBUS.getListDV();
                    ArrayList<DichVuDTO> listTmp = new ArrayList<>();
                    if (txtMaDV.getText().trim().length() != 0) {
                        for (DichVuDTO x : listAll) {
                            if (x.getMaDV().toUpperCase().contains(txtMaDV.getText().trim().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (DichVuDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (txtTenDV.getText().trim().length() != 0) {
                        for (DichVuDTO x : listAll) {
                            if (x.getTenDV().toUpperCase().contains(txtTenDV.getText().trim().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (DichVuDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbLoaiDV.getSelectedIndex() != 0) {
                        for (DichVuDTO x : listAll) {
                            if (x.getLoaiDV().equals(cbLoaiDV.getSelectedItem().toString())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (DichVuDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbGiaDV.getSelectedIndex() != 0) {
                        if (cbGiaDV.getSelectedIndex() == 1) {
                            for (DichVuDTO x : listAll) {
                                if (x.getGiaDV() <= Integer.parseInt(cbGiaDV.getItemAt(1).toString().split("Dưới ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else if (cbGiaDV.getSelectedIndex() == 7) {
                            for (DichVuDTO x : listAll) {
                                if (x.getGiaDV() >= Integer.parseInt(cbGiaDV.getItemAt(7).toString().split("Trên ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else {
                            for (DichVuDTO x : listAll) {
                                if (x.getGiaDV() >= Integer.parseInt(cbGiaDV.getItemAt(cbGiaDV.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                                        && x.getGiaDV() <= Integer.parseInt(cbGiaDV.getItemAt(cbGiaDV.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        }
                        listAll.clear();
                        for (DichVuDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    for (DichVuDTO x : listAll) {
                        if (x.getGiaDV() != 0) {
                            listTmp.add(x);
                        }
                    }
                    if (listTmp.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy dịch vụ phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        tbDV.renderTB();
                        txtMaDV.setText("");
                        txtTenDV.setText("");
                        cbGiaDV.setSelectedIndex(0);
                        cbLoaiDV.setSelectedIndex(0);
                    } else {
                        tbDV.renderTB(listTmp);
                    }
                }
            }
        });
        //set layout pnContentCenter
        pnContentCenter.setLayout(new BorderLayout(5, 5));
        pnContentCenter.add(pnContentLeft, BorderLayout.CENTER);

        //set display pnContentLeft
        pnContentLeft.setLayout(new BorderLayout(7, 7));
        pnContentLeft.add(lbContentLeft, BorderLayout.NORTH);
        pnContentLeft.add(scpDV, BorderLayout.CENTER);
        
        lbContentLeft.setFont(sgUI18b);
        
        scpDV.setViewportView(tbDV);
        scpDV.setVerticalScrollBar(scrB);
        scpDV.setBorder(new EmptyBorder(5, 5, 5, 5));
        tbDV.renderTB();
        
        tbDV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (tbDV.getSelectedRow() != -1) {
                        tbDV.setSelectionBackground(Color.decode("#F5F5F5"));
                        String maDV = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Mã dịch vụ")).toString();
                        String tenDV = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Tên dịch vụ")).toString();
                        String giaDV = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Giá dịch vụ")).toString();
                        String loaiDV = tbDV.getValueAt(tbDV.getSelectedRow(), tbDV.getColumnModel().getColumnIndex("Loại dịch vụ")).toString();
                        ArrayList<DichVuDTO> list = DichVuBUS.getListDV();
                        String pathImg = "";
                        for (DichVuDTO x : list) {
                            if (x.getMaDV().equals(maDV)) {
                                pathImg = x.getHinhAnh();
                                break;
                            }
                        }
                        if (loaiDV.equals("Thức ăn đồ uống")) {
                            new FormDetailServiceReception(true, maDV, tenDV, giaDV, loaiDV, pathImg, DisplayServiceReception.this);
                        } else {
                            new FormDetailServiceReception(false, maDV, tenDV, giaDV, loaiDV, pathImg, DisplayServiceReception.this);
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
    }
    
    public void reset() {
        tbDV.renderTB();
        txtMaDV.setText("");
        txtTenDV.setText("");
        cbGiaDV.setSelectedIndex(0);
        cbLoaiDV.setSelectedIndex(0);
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
    
    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            pnTop.setBackground(Color.white);
            pnMaDV.setBackground(Color.white);
            pnTenDV.setBackground(Color.white);
            pnGiaDV.setBackground(Color.white);
            pnLoaiDV.setBackground(Color.white);
            pnContentInput.setBackground(Color.white);
            pnTopHeader.setBackground(Color.white);
            pnTopButton.setBackground(Color.white);
            setBackground(Color.white);
            txtMaDV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            txtTenDV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7));
            cbGiaDV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
            cbLoaiDV.setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
            cbGiaDV.setBackground(Color.white);
            cbLoaiDV.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnContentLeft.setBackground(Color.white);
            pnContentCenter.setBackground(Color.white);
            scpDV.setBackground(Color.white);
            scpDV.getViewport().setBackground(Color.white);
            tbDV.getTableHeader().setBackground(Color.decode("#D1FFE1"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            pnButton.setBackground(Color.white);
        } else {
            
        }
    }
    
    public void setMouse_2(JButton x) {
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
    
    public void setLayoutPanel(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.WEST);
        panel.add(textfield, BorderLayout.CENTER);
    }
    
    public void setLayoutPanel(JPanel panel, JLabel label, JComboBox combobox) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.WEST);
        panel.add(combobox, BorderLayout.CENTER);
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
}
