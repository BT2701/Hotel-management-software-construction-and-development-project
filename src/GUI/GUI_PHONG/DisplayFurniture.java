package GUI.GUI_PHONG;

import BUS.TienIchBUS;
import DTO.TienIchDTO;
import GUI.GUI_NHANVIEN.jdialog;
import static GUI.GUI_NHANVIEN.jdialog.patternTenNV;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FontCharset;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DisplayFurniture extends JPanel {

    private int LightDark;
    boolean check = true;
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    LineBorder lineCB = new LineBorder(Color.white);
    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();
    JPanel pnTopHeader = new JPanel();
    JPanel pnTopHeaderLeft = new JPanel();
    JPanel pnTopHeaderRight = new JPanel();
    JLabel lbTopHeaderLeftTop = new JLabel("Quản lý tiện ích");
    JLabel lbTopHeaderLeftBottom = new JLabel("Bấm vào hàng của bảng danh sách tiện ích để chỉnh sửa");
    JButton btnAdd = new JButton("Thêm tiện ích");
    JButton btnImportFile = new JButton("Nhập tệp");
    JButton btnExportFile = new JButton("Xuất tệp");
    JPanel pnContentRow1Col1 = new JPanel();
    JPanel pnContentRow1Col2 = new JPanel();
    JPanel pnContentSearch = new JPanel();
    JPanel pnContentSearchContent = new JPanel();
    JPanel pnContentAction = new JPanel();
    JPanel pnContentActionContent = new JPanel();
    JLabel lbSearch = new JLabel("Tìm kiếm");
    JPanel pnMaTI = new JPanel();
    JPanel pnTenTI = new JPanel();
    JPanel pnSoLuongTI = new JPanel();
    JLabel lbMaTI = new JLabel("Mã tiện ích");
    JLabel lbTenTI = new JLabel("Tên tiện ích");
    JLabel lbSoLuongTI = new JLabel("Số lượng");
    JPanel pnButton = new JPanel();
    JButton btnReset = new JButton("Làm mới");
    JButton btnSearch = new JButton("Tìm kiếm");
    JTextField txtMaTI = new JTextField();
    JTextField txtTenTI = new JTextField();
    JComboBox cbSoLuongTI = new JComboBox();

    JLabel lbAction = new JLabel("Chức năng");
    JPanel pnRow1 = new JPanel();
    JPanel pnRow2 = new JPanel();
    JPanel pnRow3 = new JPanel();
    JPanel pnMaTIA = new JPanel();
    JPanel pnTenTIA = new JPanel();
    JPanel pnSoLuongTIA = new JPanel();
    JLabel lbMaTIA = new JLabel("Mã tiện ích");
    JLabel lbTenTIA = new JLabel("Tên tiện ích");
    JLabel lbSoLuongTIA = new JLabel("Số lượng");
    JButton btnResetA = new JButton("Làm mới");
    JButton btnEdit = new JButton("Sửa");
    JButton btnDelete = new JButton("Xóa");
    JTextField txtMaTIA = new JTextField();
    JTextField txtTenTIA = new JTextField();
    JSpinner soLuongTIA = new JSpinner();
    JPanel pnEmpty = new JPanel();
    JLabel lbTopContent = new JLabel("Danh sách tiện ích");
    JScrollPane scp = new JScrollPane();
    TableTienIch tbTI = new TableTienIch();
    JButton btnCancel = new JButton("Hủy");
    JButton btnAddTienIch = new JButton("Thêm");

    public DisplayFurniture() {
        initComponents();
        lightDark(LightDark);
    }

    public void initComponents() {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        setLayout(new BorderLayout(5, 5));
        add(pnTop, BorderLayout.NORTH);
        add(pnContent, BorderLayout.CENTER);
        pnTop.setLayout(new BorderLayout(10, 10));
        pnTop.add(pnTopHeader, BorderLayout.NORTH);

        pnTopHeader.setLayout(new BorderLayout());
        pnTopHeader.add(pnTopHeaderLeft, BorderLayout.WEST);
        pnTopHeader.add(pnTopHeaderRight, BorderLayout.CENTER);

        pnTopHeaderLeft.setLayout(new GridLayout(2, 1, 5, 5));
        pnTopHeaderLeft.add(lbTopHeaderLeftTop);
        pnTopHeaderLeft.add(lbTopHeaderLeftBottom);

        pnTopHeaderRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnTopHeaderRight.add(btnImportFile);
        pnTopHeaderRight.add(btnExportFile);
        pnTopHeaderRight.add(btnAdd);
        ImageIcon iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/them.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnAdd.setIcon(iconAdd);
        btnAdd.setFocusPainted(false);
        btnAdd.setFont(sgUI13b);
        btnAdd.setBorderPainted(false);

        ImageIcon iconImport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnImportFile.setIcon(iconImport);
        btnImportFile.setFocusPainted(false);
        btnImportFile.setFont(sgUI13b);
        btnImportFile.setBorderPainted(false);

        ImageIcon iconExport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnExportFile.setIcon(iconExport);
        btnExportFile.setFocusPainted(false);
        btnExportFile.setFont(sgUI13b);
        btnExportFile.setBorderPainted(false);
        setMouse(btnAdd);
        setMouse(btnExportFile);
        setMouse(btnImportFile);

        //edit label 
        lbTopHeaderLeftTop.setFont(sgUI18b);
        lbTopHeaderLeftBottom.setFont(tNR13);
        lbTopHeaderLeftBottom.setBorder(new EmptyBorder(3, 0, 0, 0));
        actionAdd();
        actionExport();
        actionImport();

        // edit pnContent
        pnContent.setLayout(new GridLayout(1, 2, 10, 10));
        pnContent.setBorder(new EmptyBorder(0, 10, 10, 10));
        pnContent.add(pnContentRow1Col1);
        pnContent.add(pnContentRow1Col2);

        // edit pnContentRow1Col1
        pnContentRow1Col1.setLayout(new GridLayout(2, 1, 10, 10));
        pnContentRow1Col1.add(pnContentSearch);
        pnContentRow1Col1.add(pnContentAction);

        pnContentSearch.setLayout(new BorderLayout(10, 10));
        pnContentSearch.add(lbSearch, BorderLayout.NORTH);
        pnContentSearch.add(pnContentSearchContent, BorderLayout.CENTER);
        lbSearch.setFont(sgUI15);
        lbSearch.setOpaque(true);

        pnContentSearchContent.setLayout(new GridLayout(2, 2, 25, 25));
        pnContentSearchContent.setBorder(new EmptyBorder(50, 30, 50, 30));
        pnContentSearchContent.add(pnMaTI);
        pnContentSearchContent.add(pnTenTI);
        pnContentSearchContent.add(pnSoLuongTI);
        pnContentSearchContent.add(pnButton);
        lbMaTI.setFont(sgUI13b);
        lbTenTI.setFont(sgUI13b);
        lbSoLuongTI.setFont(sgUI13b);
        setLayoutNorth_Center(pnMaTI, lbMaTI, txtMaTI);
        setLayoutNorth_Center(pnTenTI, lbTenTI, txtTenTI);
        setLayoutNorth_Center(pnSoLuongTI, lbSoLuongTI, cbSoLuongTI);
        pnButton.setLayout(new GridLayout(1, 2, 5, 5));
        pnButton.setBorder(new EmptyBorder(30, 0, 0, 0));
        pnButton.add(btnReset);
        pnButton.add(btnSearch);
        cbSoLuongTI.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        txtMaTI.setFont(sgUI13);
        txtTenTI.setFont(sgUI13);
        txtMaTIA.setFont(sgUI13);
        txtTenTIA.setFont(sgUI13);

        pnContentAction.setLayout(new BorderLayout(10, 10));
        pnContentAction.add(lbAction, BorderLayout.NORTH);
        pnContentAction.add(pnContentActionContent, BorderLayout.CENTER);
        lbAction.setFont(sgUI15);
        lbAction.setOpaque(true);

        pnContentActionContent.setLayout(new GridLayout(3, 1, 25, 25));
        pnContentActionContent.setBorder(new EmptyBorder(10, 30, 10, 30));
        pnContentActionContent.add(pnRow1);
        pnContentActionContent.add(pnRow2);
        pnContentActionContent.add(pnRow3);
        lbMaTIA.setFont(sgUI13b);
        lbTenTIA.setFont(sgUI13b);
        lbSoLuongTIA.setFont(sgUI13b);
        pnRow1.setLayout(new GridLayout(1, 2, 25, 25));
        pnRow1.add(pnMaTIA);
        pnRow1.add(pnTenTIA);
        pnRow2.setLayout(new GridLayout(1, 2, 25, 25));
        pnRow2.add(pnSoLuongTIA);
        pnRow2.add(pnEmpty);
        pnRow3.setLayout(new GridLayout(1, 3));
        setLayoutNorth_Center(pnMaTIA, lbMaTIA, txtMaTIA);
        setLayoutNorth_Center(pnTenTIA, lbTenTIA, txtTenTIA);
        setLayoutNorth_Center(pnSoLuongTIA, lbSoLuongTIA, soLuongTIA);

        pnRow3.setLayout(new GridLayout(1, 3, 5, 5));
        pnRow3.setBorder(new EmptyBorder(13, 200, 13, 0));
        pnRow3.add(btnResetA);
        pnRow3.add(btnEdit);
        pnRow3.add(btnDelete);

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnResetA.setFont(sgUI13b);
        btnResetA.setBorderPainted(false);
        btnResetA.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

        btnEdit.setFont(sgUI13b);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);

        btnDelete.setFont(sgUI13b);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);

        btnCancel.setFont(sgUI13b);
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);

        btnAddTienIch.setFont(sgUI13b);
        btnAddTienIch.setBorderPainted(false);
        btnAddTienIch.setFocusPainted(false);

        txtMaTIA.setEditable(false);

        setMouse(btnReset);
        setMouse(btnResetA);
        setMouse(btnSearch);
        setMouseEdit();
        setMouseDelete();

        ImageIcon iconDelete = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/xoa.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnDelete.setIcon(iconDelete);

        ImageIcon iconEdit = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/sua.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEdit.setIcon(iconEdit);

        ImageIcon iconReset = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/IconReset.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnReset.setIcon(iconReset);
        btnResetA.setIcon(iconReset);

        ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/IconFind.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnSearch.setIcon(iconSearch);

        ImageIcon iconAddTI = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/plus.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnAddTienIch.setIcon(iconAddTI);

        ImageIcon iconCancel = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnCancel.setIcon(iconCancel);

        // edit pnContentRow1Col2
        pnContentRow1Col2.setLayout(new BorderLayout(5, 5));
        pnContentRow1Col2.add(lbTopContent, BorderLayout.NORTH);
        pnContentRow1Col2.add(scp, BorderLayout.CENTER);
        lbTopContent.setFont(sgUI18b);
        lbTopContent.setBorder(new EmptyBorder(0, 0, 5, 0));
        lbTopContent.setOpaque(true);
        scp.setViewportView(tbTI);

        tbTI.renderTB();
        setMouseAdd();
        setMouseCancel();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnRow3.removeAll();
                pnRow3.revalidate();
                pnRow3.repaint();
                pnRow3.setLayout(new GridLayout(1, 3, 5, 5));
                pnRow3.setBorder(new EmptyBorder(13, 200, 13, 0));
                pnRow3.add(btnResetA);
                pnRow3.add(btnAddTienIch);
                pnRow3.add(btnCancel);
                int countTI = TienIchBUS.getCountTI() + 1;
                String str = String.format("%05d", countTI);
                txtMaTIA.setText("TI" + str);
//                if (countTI < 10) {
//                    txtMaTIA.setText("TI0000" + countTI);
//                } else {
//                    txtMaTIA.setText("TI000" + countTI);
//                }
                check = false;
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaTI.getText().trim().length() == 0 && txtTenTI.getText().trim().length() == 0
                        && cbSoLuongTI.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin muốn tìm", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    ArrayList<TienIchDTO> listAll = TienIchBUS.getListTI();
                    ArrayList<TienIchDTO> listTmp = new ArrayList<>();
                    if (txtMaTI.getText().trim().length() != 0) {
                        for (TienIchDTO x : listAll) {
                            if (x.getMaTI().toUpperCase().contains(txtMaTI.getText().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (TienIchDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }

                    if (txtTenTI.getText().trim().length() != 0) {
                        for (TienIchDTO x : listAll) {
                            if (x.getTenTI().toUpperCase().contains(txtTenTI.getText().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (TienIchDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }

                    if (cbSoLuongTI.getSelectedIndex() != 0) {
                        if (cbSoLuongTI.getSelectedIndex() == 1) {
                            for (TienIchDTO x : listAll) {
                                if (x.getSoLuong() <= Integer.parseInt(cbSoLuongTI.getItemAt(1).toString().split("Dưới ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else if (cbSoLuongTI.getSelectedIndex() == 4) {
                            for (TienIchDTO x : listAll) {
                                if (x.getSoLuong() >= Integer.parseInt(cbSoLuongTI.getItemAt(4).toString().split("Trên ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else {
                            for (TienIchDTO x : listAll) {
                                if (x.getSoLuong() >= Integer.parseInt(cbSoLuongTI.getItemAt(cbSoLuongTI.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                                        && x.getSoLuong() <= Integer.parseInt(cbSoLuongTI.getItemAt(cbSoLuongTI.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        }
                        listAll.clear();
                        for (TienIchDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (listAll.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy tiện ích phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txtMaTI.setText("");
                        txtTenTI.setText("");
                        cbSoLuongTI.setSelectedIndex(0);
                        tbTI.renderTB();
                    } else {
                        tbTI.renderTB(listAll);
                    }
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    pnRow3.removeAll();
                    pnRow3.revalidate();
                    pnRow3.repaint();
                    pnRow3.setLayout(new GridLayout(1, 3, 5, 5));
                    pnRow3.setBorder(new EmptyBorder(13, 200, 13, 0));
                    pnRow3.add(btnResetA);
                    pnRow3.add(btnEdit);
                    pnRow3.add(btnDelete);
                    check = true;
                    txtMaTIA.setText("");
                }
            }
        });

        btnResetA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTenTIA.setText("");
                soLuongTIA.setValue(0);
                tbTI.renderTB();
                if (check) {
                    txtMaTIA.setText("");
                }
            }
        });

        cbSoLuongTI.removeAllItems();
        cbSoLuongTI.addItem("Chọn số lượng");
        cbSoLuongTI.addItem("Dưới 10");
        cbSoLuongTI.addItem("Từ 10 đến 50");
        cbSoLuongTI.addItem("Từ 50 đến 100");
        cbSoLuongTI.addItem("Trên 100");

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaTI.setText("");
                txtTenTI.setText("");
                cbSoLuongTI.setSelectedIndex(0);
                tbTI.renderTB();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaTIA.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn tiện ích muốn sửa bên danh sách tiện ích", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (txtTenTIA.getText().trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tiện ích muốn sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        txtTenTIA.requestFocus();
                    } else {
                        TienIchDTO x = new TienIchDTO(txtMaTIA.getText().trim(), txtTenTIA.getText().trim(), (int) soLuongTIA.getValue(), 0);
                        String check = TienIchBUS.updateTI(x);
                        if (check.equals("Sửa tiện ích thành công")) {
                            JOptionPane.showMessageDialog(null, "Sửa thành công tiện ích có mã: " + txtMaTIA.getText().trim(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            tbTI.renderTB();
                            txtMaTIA.setText("");
                            txtTenTIA.setText("");
                            soLuongTIA.setValue(0);
                            txtMaTI.setText("");
                            txtTenTI.setText("");
                            cbSoLuongTI.setSelectedIndex(0);
                        } else if (check.equals("Sửa tiện ích không thành công")) {
                            JOptionPane.showMessageDialog(null, "Sửa không thành công tiện ích có mã: " + txtMaTIA.getText().trim(), "Thông báo", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Mã tiện ích này không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaTIA.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn tiện ích muốn xóa bên danh sách tiện ích");
                } else {
                    int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tiện ích có mã: " + txtMaTIA.getText(), "Cảnh báo", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        String check = TienIchBUS.deleteTI(txtMaTIA.getText().trim());
                        if (check.equals("Xóa tiện ích thành công")) {
                            JOptionPane.showMessageDialog(null, "Xóa thành công tiện ích có mã: " + txtMaTIA.getText().trim());
                            txtMaTIA.setText("");
                            txtTenTIA.setText("");
                            soLuongTIA.setValue(0);
                            tbTI.renderTB();
                            txtMaTI.setText("");
                            txtTenTI.setText("");
                            cbSoLuongTI.setSelectedIndex(0);
                        } else if (check.equals("Xóa tiện ích không thành công")) {
                            JOptionPane.showMessageDialog(null, "Xóa không thành công tiện ích có mã: " + txtMaTIA.getText().trim(), "Thông báo", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Mã tiện ích này không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        btnAddTienIch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTenTIA.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tiện ích", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    txtTenTIA.requestFocus();
                } else {
                    if ((int) soLuongTIA.getValue() < 0) {
                        JOptionPane.showMessageDialog(null, "Số lượng tiện là số nguyên dương", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        soLuongTIA.requestFocus();
                    } else {
                        TienIchDTO x = new TienIchDTO(txtMaTIA.getText().trim(), txtTenTIA.getText().trim(), (int) soLuongTIA.getValue(), 0);
                        String check = TienIchBUS.insertTI(x);
                        switch (check) {
                            case "Thêm tiện ích mới thành công":
                                JOptionPane.showMessageDialog(null, "Thêm tiện ích mới thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                int countTI = TienIchBUS.getCountTI() + 1;
                                String str = String.format("%04d", countTI);
                                txtMaTIA.setText("TI" + str);
//                                if (countTI < 10) {
//                                    txtMaTIA.setText("TI0000" + countTI);
//                                } else {
//                                    txtMaTIA.setText("TI000" + countTI);
//                                }
                                tbTI.renderTB();
                                txtTenTIA.setText("");
                                soLuongTIA.setValue(0);
                                txtMaTI.setText("");
                                txtTenTI.setText("");
                                cbSoLuongTI.setSelectedIndex(0);
                                break;
                            case "Thêm tiện ích mới không thành công":
                                JOptionPane.showMessageDialog(null, "Thêm tiện ích mới không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Mã tiện ích đã tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                }
            }
        });
        tbTI.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    txtMaTIA.setText(tbTI.getValueAt(tbTI.getSelectedRow(), tbTI.getColumnModel().getColumnIndex("Mã tiện ích")).toString());
                    txtTenTIA.setText(tbTI.getValueAt(tbTI.getSelectedRow(), tbTI.getColumnModel().getColumnIndex("Tên tiện ích")).toString());
                    soLuongTIA.setValue(Integer.parseInt(tbTI.getValueAt(tbTI.getSelectedRow(), tbTI.getColumnModel().getColumnIndex("Số lượng")).toString()));
                    pnRow3.removeAll();
                    pnRow3.revalidate();
                    pnRow3.repaint();
                    pnRow3.setLayout(new GridLayout(1, 3, 5, 5));
                    pnRow3.setBorder(new EmptyBorder(13, 200, 13, 0));
                    pnRow3.add(btnResetA);
                    pnRow3.add(btnEdit);
                    pnRow3.add(btnDelete);
                    check = true;
                } catch (Exception ex) {
                    txtMaTIA.setText("");
                    txtTenTIA.setText("");
                    soLuongTIA.setValue(0);
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

    public void setMouseAdd() {
        btnAddTienIch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    btnAddTienIch.setBackground(Color.decode("#33ff33"));
                } else {
                    btnAddTienIch.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnAddTienIch.setBackground(Color.decode("#99ff99"));
                } else {
                    btnAddTienIch.setBackground(Color.decode("#F0F0F0"));
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
                    btnEdit.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnEdit.setBackground(Color.decode("#ffffcc"));
                } else {
                    btnEdit.setBackground(Color.decode("#F0F0F0"));
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
                    btnDelete.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnDelete.setBackground(Color.decode("#ffcccc"));
                } else {
                    btnDelete.setBackground(Color.decode("#F0F0F0"));
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
                    btnCancel.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnCancel.setBackground(Color.decode("#ffcccc"));
                } else {
                    btnCancel.setBackground(Color.decode("#F0F0F0"));
                }
            }
        });
    }

    public void actionAdd() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void actionImport() {
        btnImportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionImportFile();
            }
        });
    }

    public void actionImportFile() {
        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int cancel=chooser.showSaveDialog(null);
            if (cancel == JFileChooser.CANCEL_OPTION) {
                return;
            }

            String path = chooser.getSelectedFile().getPath();
            //String filename=chooser.getSelectedFile().getName();
            FileInputStream file = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<TienIchDTO> listTI = new ArrayList<>();
            boolean[] flagSoNguyen = new boolean[sheet.getLastRowNum()]; //flag de kiem tra xem cac gia tri giaP va so ng, tinhTrang va hienTrang co phai la so nguyen Pong
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { //bo row 0, cac row Pac -1
                    continue;
                }
                for (Cell cell : row) {
                    listTI.add(new TienIchDTO());
                    switch (cell.getColumnIndex()) {
                        case 1: { //maTI
                            listTI.get(row.getRowNum() - 1).setMaTI(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 2: { //tenTI
                            listTI.get(row.getRowNum() - 1).setTenTI(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 3: { //soLuong
                            try {
                                flagSoNguyen[row.getRowNum() - 1] = true;
                                listTI.get(row.getRowNum() - 1).setSoLuong((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listTI.get(row.getRowNum() - 1).setSoLuong(-1);
                                flagSoNguyen[row.getRowNum() - 1] = false;
                            }
                        }
                        ;
                        default:
                            break;
                    }
                }
                //neu row trong soLuong k the get
                TienIchDTO temp = listTI.get(row.getRowNum() - 1);
                if (temp.getMaTI().equals("") && temp.getTenTI().equals("")) {
                    flagSoNguyen[row.getRowNum() - 1] = false;
                } else if (!flagSoNguyen[row.getRowNum() - 1]) { //loi so nguyen soLuong
                    JOptionPane.showMessageDialog(pnContent, "row %d: ".formatted(row.getRowNum())
                            + "\nSố lượng phải là số nguyên");
                }
            }

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                int flag = validateNVDTO(listTI.get(i), i + 1); //neu validate=0 k them Pach hang, validate=1 them Pach hang, validate=2 sua Pach hang
                if (flag == 1) {
                    TienIchBUS.insertTI(listTI.get(i));
                } else if (flag == 2) {
                    TienIchBUS.updateTI(listTI.get(i));
                }
            }
            ArrayList<TienIchDTO> tmp = TienIchBUS.getListTI();
            tbTI.renderTB();
            workbook.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int validateNVDTO(TienIchDTO x, int row) {
        String regexTenNV = jdialog.regexTenNV;
        //kiem tra TenTI
        if (!patternTenNV(x.getTenTI(), regexTenNV)) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Tên tiện ích không hợp lệ, chỉ gồm chữ và khoảng trắng");
            return 0;
        }
        //keim tra soLuong
        //la 1 so nguyen kiem tra ở trên
        if (x.getSoLuong() < 0) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "0<=Số lượng");
            return 0;
        }
        //kiem tra MaTI
        if (TienIchBUS.checkID(x.getMaTI())) { //ton tai ma TI
            int result = JOptionPane.showConfirmDialog(pnContent, "Mã tiện ích " + x.getMaTI() + " đã tồn tại, bạn có muốn cập nhật thông tin tiện ích", "Thông báo update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                return 2;
            } else {
                return 0;
            }
        }

        int result = JOptionPane.showConfirmDialog(this, "row %d: \n".formatted(row)
                + "Mã tiện ích sẽ tự khởi tạo \n"
                + "Tên tiện ích: %s \n".formatted(x.getTenTI())
                + "Số lượng: %d \n".formatted(x.getSoLuong()),
                "Thêm tiện ích?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return 0;
        }

        //lay stt cua tienIch, tang len 1
        String stt;
        int newIndex = TienIchBUS.getCountTI() + 1;
        stt = "";
        stt += String.valueOf(newIndex);
        while (stt.length() < 5) {
            stt = "0" + stt;
        }
        //gan gia tri cho ma TI
        x.setMaTI("TI" + stt);

        return 1;
    }

    public void actionExport() {
        btnExportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionExportFile();
            }
        });
    }

    public void actionExportFile() {
        String path = null;
        //tao chuoi header
        String[] txtHeader = new String[]{"STT", "Mã tiện ích", "Tên tiện ích", "Số lượng"};
        //lay du lieu tu bang
        int rowCount = tbTI.getModel().getRowCount();
        int columnCount = txtHeader.length;
        String[][] data = new String[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = tbTI.getModel().getValueAt(i, j).toString();
            }
        }

        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int cancel=chooser.showSaveDialog(null);
            if (cancel == JFileChooser.CANCEL_OPTION) {
                return;
            }

            path = chooser.getSelectedFile().getPath();
            //String filename=chooser.getSelectedFile().getName();
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("nhanVien");

            Row header = sheet.createRow(0);
            //tao cell style
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            //tao font style
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setCharSet(FontCharset.VIETNAMESE.getValue());
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            headerStyle.setFont(font);
            //them header  vao cell
            for (int i = 0; i < columnCount; i++) {
                Cell headerCell = header.createCell(i);
                headerCell.setCellValue(txtHeader[i]);
                headerCell.setCellStyle(headerStyle);
            }
            //headerCell = header.createCell(1);
            //headerCell.setCellValue("Age");
            //headerCell.setCellStyle(headerStyle);

            //set style cho cac rows
            CellStyle dataStyle = workbook.createCellStyle();
//        dataStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            dataStyle.setFillPattern(CellStyle.NO_FILL);
            //tao font style
            XSSFFont datafont = ((XSSFWorkbook) workbook).createFont();
            datafont.setFontName("Arial");
            datafont.setFontHeightInPoints((short) 12);
            dataStyle.setFont(datafont);
            //them gia tri row vao excel
            for (int i = 1; i <= rowCount; i++) { //tu 1->rowCount
                Row temp = sheet.createRow(i);
                for (int j = 0; j < columnCount; j++) {
                    Cell dataCell = temp.createCell(j);
                    dataCell.setCellStyle(dataStyle);
                    if (j == 0 || j == 3) { //cac cot stt, soLuong thi la int
                        dataCell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        dataCell.setCellValue(Integer.parseInt(data[i - 1][j]));
                        continue;
                    }
                    dataCell.setCellType(Cell.CELL_TYPE_STRING);
                    dataCell.setCellValue(data[i - 1][j]); //chay tu i=1 -> i-1
                }
            }
            //auto resize column
            for (int i = 0; i < columnCount; i++) {
                sheet.autoSizeColumn(i);
            }
            //ghi ra file
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "xuất file thành công");
        try {
            //constructor of file class having file as argument  
            File file = new File(path);
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) //checks file exists or not  
            {
                desktop.open(file);              //opens the specified file  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLayoutNorth_Center(JPanel panel, JLabel label, JTextField textfield) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(textfield, BorderLayout.CENTER);
    }

    public void setLayoutNorth_Center(JPanel panel, JLabel label, JComboBox comboBox) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(comboBox, BorderLayout.CENTER);
    }

    public void setLayoutNorth_Center(JPanel panel, JLabel label, JSpinner spiner) {
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(spiner, BorderLayout.CENTER);
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = 0;
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnTopHeader.setBackground(Color.white);
            pnTopHeaderLeft.setBackground(Color.white);
            pnTopHeaderRight.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, Color.white));
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            pnContent.setBackground(Color.white);
            pnContentRow1Col1.setBackground(Color.white);
            pnContentSearch.setBackground(Color.decode("#FFFFFF"));
            pnContentAction.setBackground(Color.decode("#FFFFFF"));
            lbSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
            lbSearch.setBackground(Color.decode("#ebf2fc"));
            lbSearch.setForeground(Color.decode("#33419C"));
            lbAction.setBorder(new EmptyBorder(5, 5, 5, 5));
            lbAction.setBackground(Color.decode("#ebf2fc"));
            lbAction.setForeground(Color.decode("#33419C"));
            pnContentSearchContent.setBackground(Color.decode("#FEFEFF"));
            pnContentActionContent.setBackground(Color.decode("#FEFEFF"));
            pnMaTI.setBackground(Color.decode("#FEFEFF"));
            pnTenTI.setBackground(Color.decode("#FEFEFF"));
            pnSoLuongTI.setBackground(Color.decode("#FEFEFF"));
            pnMaTIA.setBackground(Color.decode("#FEFEFF"));
            pnTenTIA.setBackground(Color.decode("#FEFEFF"));
            pnSoLuongTIA.setBackground(Color.decode("#FEFEFF"));
            pnButton.setBackground(Color.decode("#FEFEFF"));
            txtMaTI.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#F2F2F2")), new EmptyBorder(5, 5, 5, 5)));
            txtTenTI.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#F2F2F2")), new EmptyBorder(5, 5, 5, 5)));
            txtMaTIA.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#F2F2F2")), new EmptyBorder(5, 5, 5, 5)));
            txtTenTIA.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#F2F2F2")), new EmptyBorder(5, 5, 5, 5)));
            cbSoLuongTI.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#F2F2F2")), new EmptyBorder(0, 5, 0, 0)));
            soLuongTIA.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#F2F2F2")), new EmptyBorder(0, 0, 0, 0)));
            cbSoLuongTI.setBackground(Color.white);
            pnEmpty.setBackground(Color.decode("#FEFEFF"));
            pnRow1.setBackground(Color.decode("#FEFEFF"));
            pnRow2.setBackground(Color.decode("#FEFEFF"));
            pnRow3.setBackground(Color.decode("#FEFEFF"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnResetA.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            btnEdit.setBackground(Color.decode("#ffffcc"));
            btnDelete.setBackground(Color.decode("#ffcccc"));
            lbTopContent.setBackground(Color.white);
            pnContentRow1Col2.setBackground(Color.white);
            scp.setBackground(Color.white);
            scp.getViewport().setBackground(Color.white);
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.decode("#FFFFFF")));
            tbTI.getTableHeader().setBackground(Color.decode("#dee9fc"));
            btnAddTienIch.setBackground(Color.decode("#99ff99"));
            btnCancel.setBackground(Color.decode("#ff9999"));
            lbTopHeaderLeftTop.setForeground(Color.black);
            lbTopHeaderLeftBottom.setForeground(Color.black);
            lbTopContent.setForeground(Color.black);
            tbTI.getTableHeader().setForeground(Color.black);
            txtMaTI.setBackground(Color.decode("#FFFFFF"));
            txtTenTI.setBackground(Color.decode("#FFFFFF"));
            txtMaTIA.setBackground(Color.decode("#FFFFFF"));
            txtTenTIA.setBackground(Color.decode("#FFFFFF"));
            txtMaTI.setForeground(Color.black);
            txtMaTIA.setForeground(Color.black);
            txtTenTI.setForeground(Color.black);
            txtTenTIA.setForeground(Color.black);
            cbSoLuongTI.setForeground(Color.black);
            lbMaTI.setForeground(Color.black);
            lbMaTIA.setForeground(Color.black);
            lbSoLuongTI.setForeground(Color.black);
            lbSoLuongTIA.setForeground(Color.black);
            lbTenTI.setForeground(Color.black);
            lbTenTIA.setForeground(Color.black);
            soLuongTIA.setBackground(Color.decode("#FFFFFF"));
            soLuongTIA.setForeground(Color.black);
            scp.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));
        } else {
            this.LightDark = 1;
            Color black = new Color(51, 51, 51);
            setBackground(black);
            pnTop.setBackground(black);
            pnTopHeader.setBackground(black);
            pnTopHeaderLeft.setBackground(black);
            pnTopHeaderRight.setBackground(black);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, black));
            btnAdd.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            pnContent.setBackground(black);
            pnContentRow1Col1.setBackground(black);
            pnContentSearch.setBackground(Color.decode("#4B4B4B"));
            pnContentAction.setBackground(Color.decode("#4B4B4B"));
            lbSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
            lbSearch.setBackground(Color.decode("#202020"));
            lbSearch.setForeground(Color.decode("#FFFFFF"));
            lbAction.setBorder(new EmptyBorder(5, 5, 5, 5));
            lbAction.setBackground(Color.decode("#202020"));
            lbAction.setForeground(Color.decode("#FFFFFF"));
            pnContentSearchContent.setBackground(Color.decode("#4B4B4B"));
            pnContentActionContent.setBackground(Color.decode("#4B4B4B"));
            pnMaTI.setBackground(Color.decode("#4b4b4b"));
            pnTenTI.setBackground(Color.decode("#4b4b4b"));
            pnSoLuongTI.setBackground(Color.decode("#4b4b4b"));
            pnMaTIA.setBackground(Color.decode("#4b4b4b"));
            pnTenTIA.setBackground(Color.decode("#4b4b4b"));
            pnSoLuongTIA.setBackground(Color.decode("#4b4b4b"));
            pnButton.setBackground(Color.decode("#4b4b4b"));
            txtMaTI.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#919191")), new EmptyBorder(5, 5, 5, 5)));
            txtTenTI.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#919191")), new EmptyBorder(5, 5, 5, 5)));
            txtMaTIA.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#919191")), new EmptyBorder(5, 5, 5, 5)));
            txtTenTIA.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#919191")), new EmptyBorder(5, 5, 5, 5)));
            cbSoLuongTI.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#919191")), new EmptyBorder(0, 5, 0, 0)));
            soLuongTIA.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#919191")), new EmptyBorder(0, 0, 0, 0)));
            cbSoLuongTI.setBackground(Color.decode("#4747474"));
            txtMaTI.setBackground(Color.decode("#4747474"));
            txtTenTI.setBackground(Color.decode("#4747474"));
            txtMaTIA.setBackground(Color.decode("#4747474"));
            txtTenTIA.setBackground(Color.decode("#4747474"));
            txtMaTI.setForeground(Color.white);
            txtMaTIA.setForeground(Color.white);
            txtTenTI.setForeground(Color.white);
            txtTenTIA.setForeground(Color.white);
            cbSoLuongTI.setForeground(Color.white);
            lbMaTI.setForeground(Color.white);
            lbMaTIA.setForeground(Color.white);
            lbSoLuongTI.setForeground(Color.white);
            lbSoLuongTIA.setForeground(Color.white);
            lbTenTI.setForeground(Color.white);
            lbTenTIA.setForeground(Color.white);
            soLuongTIA.setBackground(Color.decode("#4B4B4B"));
            soLuongTIA.setForeground(Color.white);
            pnEmpty.setBackground(Color.decode("#4B4B4B"));
            pnRow1.setBackground(Color.decode("#4B4B4B"));
            pnRow2.setBackground(Color.decode("#4B4B4B"));
            pnRow3.setBackground(Color.decode("#4B4B4B"));
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnResetA.setBackground(Color.decode("#F0F0F0"));
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            btnEdit.setBackground(Color.decode("#F0F0F0"));
            btnDelete.setBackground(Color.decode("#F0F0F0"));
            lbTopContent.setBackground(black);
            pnContentRow1Col2.setBackground(black);
            scp.setBackground(black);
            scp.getViewport().setBackground(black);
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.decode("#FFFFFF")));
            tbTI.getTableHeader().setBackground(Color.decode("#dee9fc"));
            btnAddTienIch.setBackground(Color.decode("#F0F0F0"));
            btnCancel.setBackground(Color.decode("#F0F0F0"));
            lbTopHeaderLeftTop.setForeground(Color.white);
            lbTopHeaderLeftBottom.setForeground(Color.white);
            lbTopContent.setForeground(Color.white);
            tbTI.getTableHeader().setForeground(Color.white);
            tbTI.getTableHeader().setBackground(Color.decode("#202020"));
            scp.setBorder(new MatteBorder(0, 0, 1, 0, black));
        }
    }
}
