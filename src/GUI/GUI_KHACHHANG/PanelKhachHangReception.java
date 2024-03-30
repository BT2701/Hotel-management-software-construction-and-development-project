package GUI.GUI_KHACHHANG;

import GUI.ThongBaoDialog;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class PanelKhachHangReception extends JPanel {

    private int LightDark;
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();
    JPanel pnTopHeader = new JPanel();
    JPanel pnTopHeaderLeft = new JPanel();
    JPanel pnTopHeaderRight = new JPanel();
    JLabel lbTopHeaderLeftTop = new JLabel("Quản lý khách hàng");
    JLabel lbTopHeaderLeftBottom = new JLabel("Bấm vào hàng của bảng danh sách khách hàng để chỉnh sửa");
    JPanel pnmaKH = new JPanel();
    JLabel lbmaKH = new JLabel("Mã khách hàng");
    JTextField txtmaKH = new JTextField();
    JPanel pntenKH = new JPanel();
    JLabel lbtenKH = new JLabel("Tên khách hàng");
    JTextField txttenKH = new JTextField();
    JPanel pnCMND = new JPanel();
    JLabel lbCMND = new JLabel("CMND");
    JTextField txtCMND = new JTextField();
    JPanel pngioiTinh = new JPanel();
    JLabel lbgioiTinh = new JLabel("Giới tính");
    JComboBox cbgioiTinh = new JComboBox();
    JPanel pnSDT = new JPanel();
    JLabel lbSDT = new JLabel("Số điện thoại");
    JTextField txtSDT = new JTextField();
    JPanel pnqueQuan = new JPanel();
    JLabel lbqueQuan = new JLabel("Quê quán");
    JTextField txtqueQuan = new JTextField();
    JPanel pnquocTich = new JPanel();
    JLabel lbquocTich = new JLabel("Quốc tịch");
    JTextField txtquocTich = new JTextField();
    JPanel pnngaySinh = new JPanel();
    JLabel lbngaySinh = new JLabel("Ngày sinh từ");
    JDateChooser txtngaySinh = new JDateChooser();
    JPanel pnBtnSearch = new JPanel();

    JPanel pnNgaySinhTo = new JPanel();
    JLabel lbngaySinhTo = new JLabel("đến         ");
    JDateChooser txtngaySinhTo = new JDateChooser();
    JPanel pnBtnSearchTo = new JPanel();

    JButton btnReset = new JButton("Làm mới");
    JButton btnSearch = new JButton("Tìm kiếm");
    JPanel pnEmp = new JPanel();

    LineBorder lineCB = new LineBorder(Color.white);
    ArrayList<JPanel> listKH = new ArrayList<>();
    JPanel pnTopCenter = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentCenterTop = new JPanel();
    JLabel lbContentCentertop = new JLabel("Danh sách khách hàng");
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF"));
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
    EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);
    JButton btnCancel = new JButton("Hủy");
    JButton btnAddKhachHang = new JButton("Thêm");
    JButton btnEdit = new JButton("Sửa");
    JButton btnDelete = new JButton("Xóa");
    JScrollPane scp = new JScrollPane();
    TableKhachHang tbKH = new TableKhachHang();
    ScrollBar scrB = new ScrollBar(Color.decode("#ebf2fc"), Color.white);
    JTextFieldDateEditor editor = (JTextFieldDateEditor) txtngaySinh.getDateEditor();
    JTextFieldDateEditor editorTo = (JTextFieldDateEditor) txtngaySinhTo.getDateEditor();

    public PanelKhachHangReception() {
        LightDark = 0;
        initComponents();
        lightDark(LightDark);
    }

    public void initComponents() {
        setLayout(new BorderLayout(5, 5));
        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);
        pnTop.setLayout(new BorderLayout(10, 10));
        pnTop.add(pnTopHeader, BorderLayout.NORTH);
        pnTop.add(pnTopCenter, BorderLayout.CENTER);

        pnTopHeader.setLayout(new BorderLayout());
        pnTopHeader.add(pnTopHeaderLeft, BorderLayout.WEST);
        pnTopHeader.add(pnTopHeaderRight, BorderLayout.CENTER);

        pnTopHeaderLeft.setLayout(new GridLayout(2, 1, 5, 5));
        pnTopHeaderLeft.add(lbTopHeaderLeftTop);
        pnTopHeaderLeft.add(lbTopHeaderLeftBottom);

        pnTopHeaderRight.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

        //edit label 
        lbTopHeaderLeftTop.setFont(sgUI18b);
        lbTopHeaderLeftBottom.setFont(tNR13);
        lbTopHeaderLeftBottom.setBorder(new EmptyBorder(3, 0, 0, 0));

        // edit content
        pnTopCenter.setLayout(new GridLayout(2, 5, 10, 5));
        listKH.add(pnmaKH);
        listKH.add(pntenKH);
        listKH.add(pnCMND);
        listKH.add(pngioiTinh);
        listKH.add(pnSDT);
        listKH.add(pnqueQuan);
        listKH.add(pnquocTich);
        listKH.add(pnngaySinh);
        listKH.add(pnNgaySinhTo);
        listKH.add(pnBtnSearch);
        for (JPanel x : listKH) {
            pnTopCenter.add(x);
            x.setLayout(new BorderLayout(18, 10));
        }
        lbmaKH.setFont(sgUI13b);
        lbtenKH.setFont(sgUI13b);
        lbCMND.setFont(sgUI13b);
        lbgioiTinh.setFont(sgUI13b);
        lbSDT.setFont(sgUI13b);
        lbqueQuan.setFont(sgUI13b);
        lbquocTich.setFont(sgUI13b);
        lbngaySinh.setFont(sgUI13b);
        lbngaySinhTo.setFont(sgUI13b);

        txtmaKH.setFont(sgUI13);
        txttenKH.setFont(sgUI13);
        txtCMND.setFont(sgUI13);
        cbgioiTinh.setFont(sgUI13);
        txtSDT.setFont(sgUI13);
        txtqueQuan.setFont(sgUI13);
        txtquocTich.setFont(sgUI13);
        txtngaySinh.setFont(sgUI13);
        txtngaySinhTo.setFont(sgUI13);
        String gioiTinh[] = {"Giới tính", "Nam", "Nữ"};

        setDefaulComboBox(cbgioiTinh, gioiTinh);

        cbgioiTinh.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        txtngaySinh.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        txtngaySinh.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
        txtngaySinh.getCalendarButton().setFocusPainted(false);
        txtngaySinh.getCalendarButton().setContentAreaFilled(false);

        txtngaySinhTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
        txtngaySinhTo.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
        txtngaySinhTo.getCalendarButton().setFocusPainted(false);
        txtngaySinhTo.getCalendarButton().setContentAreaFilled(false);

        pnmaKH.add(lbmaKH, BorderLayout.WEST);
        pnmaKH.add(txtmaKH, BorderLayout.CENTER);
        pntenKH.add(lbtenKH, BorderLayout.WEST);
        pntenKH.add(txttenKH, BorderLayout.CENTER);
        pnCMND.add(lbCMND, BorderLayout.WEST);
        pnCMND.add(txtCMND, BorderLayout.CENTER);
        pngioiTinh.add(lbgioiTinh, BorderLayout.WEST);
        pngioiTinh.add(cbgioiTinh, BorderLayout.CENTER);
        pnSDT.add(lbSDT, BorderLayout.WEST);
        pnSDT.add(txtSDT, BorderLayout.CENTER);
        pnqueQuan.add(lbqueQuan, BorderLayout.WEST);
        pnqueQuan.add(txtqueQuan, BorderLayout.CENTER);
        pnquocTich.add(lbquocTich, BorderLayout.WEST);
        pnquocTich.add(txtquocTich, BorderLayout.CENTER);
        pnngaySinh.add(lbngaySinh, BorderLayout.WEST);
        pnngaySinh.add(txtngaySinh, BorderLayout.CENTER);
        pnNgaySinhTo.add(lbngaySinhTo, BorderLayout.WEST);
        pnNgaySinhTo.add(txtngaySinhTo, BorderLayout.CENTER);
        pnBtnSearch.setLayout(new GridLayout(1, 2, 10, 10));
        pnBtnSearch.add(btnReset);
        pnBtnSearch.add(btnSearch);
        pnTopCenter.setBorder(new EmptyBorder(0, 5, 0, 5));
        setMouse(btnReset);
        setMouse(btnSearch);

        // edit content
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
        scp.setViewportView(tbKH);
        scp.setViewportBorder(null);
        tbKH.renderTB();

        scp.setVerticalScrollBar(scrB);
        actionReset();
        eventTableKH();
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtmaKH.getText().trim().length() == 0
                        && txttenKH.getText().trim().length() == 0
                        && txtCMND.getText().trim().length() == 0
                        && txtSDT.getText().trim().length() == 0
                        && txtquocTich.getText().trim().length() == 0
                        && txtqueQuan.getText().trim().length() == 0
                        && cbgioiTinh.getSelectedIndex() == 0
                        && editor.getText().trim().length() == 0
                        && editorTo.getText().trim().length() == 0) {
                    new ThongBaoDialog("Vui lòng nhập thông tin muốn tìm", ThongBaoDialog.SUCCESS_DIALOG);
                    return;
                }
                if (txtngaySinh.getDate() != null && txtngaySinhTo.getDate() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateTuNgay = sdf.format(txtngaySinh.getDate()) + " 00:00:00";
                    String dateDenNgay = sdf.format(txtngaySinhTo.getDate()) + " 00:00:00";
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime lcdTuNgay = LocalDateTime.parse(dateTuNgay, dtf);
                    LocalDateTime lcdDenNgay = LocalDateTime.parse(dateDenNgay, dtf);
                    if (lcdTuNgay.isAfter(lcdDenNgay)) {
                        new ThongBaoDialog("Vui lòng chọn đến ngày phải sau từ ngày", 1);
                        return;
                    }
                }
                String search = "";
                if (txtmaKH.getText().trim().length() != 0) {
                    search += "maKH like '%" + txtmaKH.getText().trim() + "%'";
                }
                if (txttenKH.getText().trim().length() != 0) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "tenKH like N'%" + txttenKH.getText().trim() + "%'";
                }
                if (txtCMND.getText().trim().length() != 0) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "CMND like '%" + txtCMND.getText().trim() + "%'";
                }
                if (txtSDT.getText().trim().length() != 0) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "sDT like '%" + txtSDT.getText().trim() + "%'";
                }
                if (txtqueQuan.getText().trim().length() != 0) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "queQuan like N'%" + txtqueQuan.getText().trim() + "%'";
                }
                if (txtquocTich.getText().trim().length() != 0) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "quocTich like N'%" + txtquocTich.getText().trim() + "%'";
                }
                if (cbgioiTinh.getSelectedIndex() != 0) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "quocTich like N'%" + cbgioiTinh.getSelectedItem().toString() + "%'";
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (txtngaySinh.getDate() != null) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "cast(ngaySinh as Date) >= '" + sdf.format(txtngaySinh.getDate()) + "'";
                }
                if (txtngaySinhTo.getDate() != null) {
                    if (search != "") {
                        search += " AND ";
                    }
                    search += "cast(ngaySinh as Date) <= '" + sdf.format(txtngaySinhTo.getDate()) + "'";
                }
                if (search != "") {
                    search = "where " + search;
                }
                ArrayList<KhachHangDTO> list = KhachHangBUS.GetAllList(search);
                if (list.isEmpty()) {
                    new ThongBaoDialog("Không tìm thấy khách hàng cần tìm", ThongBaoDialog.INFO_DIALOG);
                    cbgioiTinh.setSelectedIndex(0);
                    txtmaKH.setText("");
                    txttenKH.setText("");
                    txtCMND.setText("");
                    txtSDT.setText("");
                    txtqueQuan.setText("");
                    txtquocTich.setText("");
                    txtngaySinh.setDate(null);
                    tbKH.renderTB();
                } else {
                    tbKH.renderTB(list);
                }
            }
        });
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

    public void setMouseAdd() {
        btnAddKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    btnAddKhachHang.setBackground(Color.decode("#33ff33"));
                } else {
                    btnAddKhachHang.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnAddKhachHang.setBackground(Color.decode("#99ff99"));
                } else {
                    btnAddKhachHang.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void setMouseEdit() {
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    btnEdit.setBackground(Color.decode("#ffff33"));
                } else {
                    btnEdit.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnEdit.setBackground(Color.decode("#ffffcc"));
                } else {
                    btnEdit.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void setMouseDelete() {
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    btnDelete.setBackground(Color.decode("#ff3333"));
                } else {
                    btnDelete.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnDelete.setBackground(Color.decode("#ffcccc"));
                } else {
                    btnDelete.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
    }

    public void setMouseCancel() {
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    btnCancel.setBackground(Color.decode("#ff3333"));
                } else {
                    btnCancel.setBackground(Color.decode("#4D4D4D"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnCancel.setBackground(Color.decode("#ffcccc"));
                } else {
                    btnCancel.setBackground(Color.decode("#4c4d4c"));
                }
            }
        });
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
                cbgioiTinh.setSelectedIndex(0);
                txtmaKH.setText("");
                txttenKH.setText("");
                txtCMND.setText("");
                txtSDT.setText("");
                txtqueQuan.setText("");
                txtquocTich.setText("");
                txtngaySinh.setDate(null);
                tbKH.renderTB();
            }
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnTopHeader.setBackground(Color.white);
            pnTopCenter.setBackground(Color.white);
            pnTopHeaderLeft.setBackground(Color.white);
            pnTopHeaderRight.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, Color.white));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            for (JPanel x : listKH) {
                x.setBackground(Color.white);
            }

            cbgioiTinh.setBorder(matteBorderCB);
            cbgioiTinh.setBackground(Color.white);
            txtmaKH.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txttenKH.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtCMND.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtSDT.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtqueQuan.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtquocTich.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            editor.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            editorTo.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            scp.setBackground(Color.white);
            scp.getViewport().setBackground(Color.white);
            pnContentCenterTop.setBackground(Color.white);
            tbKH.getTableHeader().setBackground(Color.decode("#D1FFE1"));
        } else {

        }
    }

    public void eventTableKH() {
        tbKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbKH.getSelectedRow();
                String maKH = tbKH.getValueAt(row, 1).toString();
                new FormChiTietKhachHang(maKH, PanelKhachHangReception.this);
            }
        });
    }

}
