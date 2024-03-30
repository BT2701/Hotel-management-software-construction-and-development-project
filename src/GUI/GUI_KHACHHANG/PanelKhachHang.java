package GUI.GUI_KHACHHANG;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import GUI.GUI_NHANVIEN.jdialog;
import static GUI.GUI_NHANVIEN.jdialog.patternTenNV;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Desktop;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.FontCharset;

public class PanelKhachHang extends JPanel {

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
    JButton btnImportFile = new JButton("Nhập tệp");
    JButton btnExportFile = new JButton("Xuất tệp");
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
    MatteBorder borderTxtDark;

    public PanelKhachHang() {
        borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
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
        pnTopHeaderRight.add(btnImportFile);
        pnTopHeaderRight.add(btnExportFile);

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

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
        setMouse(btnExportFile);
        setMouse(btnImportFile);

        //edit label 
        lbTopHeaderLeftTop.setFont(sgUI18b);
        lbTopHeaderLeftBottom.setFont(tNR13);
        lbTopHeaderLeftBottom.setBorder(new EmptyBorder(3, 0, 0, 0));
        actionExport();
        actionImport();

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

            ArrayList<KhachHangDTO> listKH = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { //bo row 0, cac row khac -1
                    continue;
                }
                for (Cell cell : row) {
                    listKH.add(new KhachHangDTO());
                    switch (cell.getColumnIndex()) {
                        case 1: { //maKH
                            listKH.get(row.getRowNum() - 1).setMaKH(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 2: { //tenKH
                            listKH.get(row.getRowNum() - 1).setTenKH(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 3: { //CMND
                            listKH.get(row.getRowNum() - 1).setCMND(cell.getStringCellValue());
                        }
                        ;
                        case 4: { //gioiTinh
                            listKH.get(row.getRowNum() - 1).setGioiTinh(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 5: { //sDT
                            listKH.get(row.getRowNum() - 1).setSDT(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 6: { //queQuan
                            listKH.get(row.getRowNum() - 1).setQueQuan(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 7: { //quocTich
                            listKH.get(row.getRowNum() - 1).setQuocTich(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 8: { //ngaySinh
                            listKH.get(row.getRowNum() - 1).setNgaySinhString(cell.getStringCellValue());
                        }
                        ;
                        break;
                        default:
                            break;
                    }
                }
            }

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                int flag = validateKHDTO(listKH.get(i), i + 1); //neu validate=0 k them khach hang, validate=1 them khach hang, validate=2 sua khach hang
                if (flag == 1) {
                    KhachHangBUS.insertKH(listKH.get(i));
                } else if (flag == 2) {
                    KhachHangBUS.updateKH(listKH.get(i));
                }
            }
            ArrayList<KhachHangDTO> tmp = KhachHangBUS.getListKH();
            tbKH.renderTB();
            workbook.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int validateKHDTO(KhachHangDTO x, int row) {
        String regexTenNV = jdialog.regexTenNV;
        //kiem tra tenKH
        if (!patternTenNV(x.getTenKH(), regexTenNV)) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "TenNV không hợp lệ, chỉ gồm chữ và khoảng trắng");
            return 0;
        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            //kiem tra ngaySinh
            if (df.parse(x.getNgaySinhString()) == null) {
                JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                        + "Ngày sinh, ngày làm k trống");
                return 0;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "định dạng ngày: dd-MM-yyyy");
            return 0;
        }
        Date today = new Date();
        //tuoi phai lon hon 18 moi được vào làm
        String paternDate = "ddMMyyyy";
        DateFormat dfm = new SimpleDateFormat(paternDate);
        String chkNgaySinh = dfm.format(today);
        //lay nam nay tru di 18 va gop chuoi lai
        String yearToday = chkNgaySinh.toString().substring(4, 8);
        int year = Integer.parseInt(yearToday);
        year -= 18;
        //18 nam truoc
        chkNgaySinh = chkNgaySinh.substring(0, 4) + String.valueOf(year);
        try {
            today = dfm.parse(chkNgaySinh);
            if (df.parse(x.getNgaySinhString()).after(today)) {
                JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                        + "Ngày sinh không hợp lệ, phải lớn hơn 18 tuổi");
                return 0;
            }
        } catch (ParseException e) {
            //da kiem tra o tren
        }
        //kiem tra CMND
        if (x.getCMND().equals("")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập CMND");
            return 0;
        } else if (x.getCMND().length() != 12) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập CMND hợp lệ");
            return 0;
        }
        //kiem tra gioiTinh
        if (!x.getGioiTinh().equalsIgnoreCase("Nam") && !x.getGioiTinh().equalsIgnoreCase("Nữ")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Giới tính là nam hoặc nữ");
            return 0;
        }
        //kiem tra sDT
        if (x.getSDT().charAt(0) != '0' || x.getSDT().length() != 10) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập sdt hợp lệ");
            return 0;
        }
        //kiem tra queQuan
        if (x.getQueQuan().equals("")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Quê quán trống");
            return 0;
        }
        //kiem tra quocTich
        if (x.getQueQuan().equals("")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Quốc tịch trống");
            return 0;
        }
        //kiem tra maKH
        if (KhachHangBUS.checkID(x.getMaKH())) { //ton tai ma khach hang
            int result = JOptionPane.showConfirmDialog(pnContent, "Mã khách hàng " + x.getMaKH() + " đã tồn tại, bạn có muốn cập nhật thông tin khách hàng", "Thông báo update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                return 2;
            } else {
                return 0;
            }
        }

        int result = JOptionPane.showConfirmDialog(this, "row %d: \n".formatted(row)
                + "Mã khách hàng sẽ tự khởi tạo \n"
                + "Tên khách hàng: %s \n".formatted(x.getTenKH())
                + "Giới tính: %s \n".formatted(x.getGioiTinh())
                + "CMND: %s \n".formatted(x.getCMND())
                + "Ngày sinh: %s \n".formatted(x.getNgaySinhString())
                + "Số điện thoại: %s \n".formatted(x.getSDT())
                + "Quê quán: %s \n".formatted(x.getQueQuan())
                + "Quốc tịch: %s \n".formatted(x.getQuocTich()),
                "Thêm khách hàng?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return 0;
        }
        //lay gioi tinh
        String gioiTinh = "0";
        if (x.getGioiTinh().equalsIgnoreCase("nữ")) {
            gioiTinh = "1";
        }
        //lay ngay lam; da duoc check o tren
        String ngaySinh = x.getNgaySinhString();
        //df=dd-MM-yyyy; dfm=ddMMyyyy
        ngaySinh = ngaySinh.substring(0, 2) + ngaySinh.substring(3, 5) + ngaySinh.substring(8);
        //lay stt cua khach hang, tang len 1
        String stt;
        int newIndex = KhachHangBUS.countKH() + 1;
        stt = "";
        stt += String.valueOf(newIndex);
        while (stt.length() < 4) {
            stt = "0" + stt;
        }
        //gan gia tri cho ma KH
        x.setMaKH("KH" + gioiTinh + ngaySinh + stt);

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
        String[] txtHeader = new String[]{"STT", "Mã khách hàng", "Tên khách hàng", "CMND", "Giới tính", "SĐT", "Quê quán", "Quốc tịch", "Ngày sinh"};
        //lay du lieu tu bang
        int rowCount = tbKH.getModel().getRowCount();
        int columnCount = txtHeader.length;
        String[][] data = new String[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = tbKH.getModel().getValueAt(i, j).toString();
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
                    if (j == 0) { //cac cot stt thi la int
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

    public void setDefaulComboBox(JComboBox x, String list[]) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String y : list) {
            dcbm.addElement(y);
        }
        x.setModel(dcbm);
    }

    //HÀM ĐƯỢC THÊM MỚI
    //NHỚ GỌI HÀM TRÊN INITCOMPONENT
    public void eventTableKH() {
        tbKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbKH.getSelectedRow();
                String maKH = tbKH.getValueAt(row, 1).toString();
                new FormChiTietKhachHang(maKH, PanelKhachHang.this);
            }
        });
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
            this.LightDark = LightDark;
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnTopHeader.setBackground(Color.white);
            pnTopCenter.setBackground(Color.white);
            pnTopHeaderLeft.setBackground(Color.white);
            pnTopHeaderRight.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, Color.white));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
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
            tbKH.getTableHeader().setBackground(Color.decode("#dee9fc"));
            txtCMND.setBackground(Color.decode("#FFFFFF"));
            txtSDT.setBackground(Color.decode("#FFFFFF"));
            txtmaKH.setBackground(Color.decode("#FFFFFF"));
            txtqueQuan.setBackground(Color.decode("#FFFFFF"));
            txtquocTich.setBackground(Color.decode("#FFFFFF"));
            txttenKH.setBackground(Color.decode("#FFFFFF"));
            txtCMND.setForeground(Color.black);
            txtSDT.setForeground(Color.black);
            txtmaKH.setForeground(Color.black);
            txtngaySinh.setForeground(Color.black);
            txtngaySinhTo.setForeground(Color.black);
            txtqueQuan.setForeground(Color.black);
            txtquocTich.setForeground(Color.black);
            txttenKH.setForeground(Color.black);
            lbCMND.setForeground(Color.black);
            lbContentCentertop.setForeground(Color.black);
            lbSDT.setForeground(Color.black);
            lbTopHeaderLeftBottom.setForeground(Color.black);
            lbTopHeaderLeftTop.setForeground(Color.black);
            lbgioiTinh.setForeground(Color.black);
            lbmaKH.setForeground(Color.black);
            lbngaySinh.setForeground(Color.black);
            lbngaySinhTo.setForeground(Color.black);
            lbqueQuan.setForeground(Color.black);
            lbquocTich.setForeground(Color.black);
            lbtenKH.setForeground(Color.black);
            cbgioiTinh.setForeground(Color.black);
            txtngaySinh.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            txtngaySinh.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
            txtngaySinh.getCalendarButton().setFocusPainted(false);

            txtngaySinhTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            txtngaySinhTo.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
            txtngaySinhTo.getCalendarButton().setFocusPainted(false);
            
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            tbKH.getTableHeader().setForeground(Color.decode("#000000"));
        } else {
            this.LightDark = LightDark;
            Color black = Color.decode("#333333");
            setBackground(black);
            pnTop.setBackground(black);
            pnTopHeader.setBackground(black);
            pnTopCenter.setBackground(black);
            pnTopHeaderLeft.setBackground(black);
            pnTopHeaderRight.setBackground(black);
            pnContent.setBackground(black);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, black));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            for (JPanel x : listKH) {
                x.setBackground(black);
            }

            cbgioiTinh.setBorder(borderTxtDark);
            cbgioiTinh.setBackground(Color.decode("#474747"));
            cbgioiTinh.setForeground(Color.white);
            txtmaKH.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txttenKH.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtCMND.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtSDT.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtqueQuan.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtquocTich.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            editor.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            editorTo.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            scp.setBackground(black);
            scp.getViewport().setBackground(black);
            pnContentCenterTop.setBackground(black);
            tbKH.getTableHeader().setBackground(Color.decode("#202020"));
            tbKH.getTableHeader().setForeground(Color.decode("#FFFFFF"));
            txtCMND.setBackground(Color.decode("#474747"));
            txtSDT.setBackground(Color.decode("#474747"));
            txtmaKH.setBackground(Color.decode("#474747"));
            txtqueQuan.setBackground(Color.decode("#474747"));
            txtquocTich.setBackground(Color.decode("#474747"));
            txttenKH.setBackground(Color.decode("#474747"));
            txtCMND.setForeground(Color.white);
            txtSDT.setForeground(Color.white);
            txtmaKH.setForeground(Color.white);
            txtngaySinh.setForeground(Color.white);
            txtngaySinhTo.setForeground(Color.white);
            txtqueQuan.setForeground(Color.white);
            txtquocTich.setForeground(Color.white);
            txttenKH.setForeground(Color.white);
            lbCMND.setForeground(Color.white);
            lbContentCentertop.setForeground(Color.white);
            lbSDT.setForeground(Color.white);
            lbTopHeaderLeftBottom.setForeground(Color.white);
            lbTopHeaderLeftTop.setForeground(Color.white);
            lbgioiTinh.setForeground(Color.white);
            lbmaKH.setForeground(Color.white);
            lbngaySinh.setForeground(Color.white);
            lbngaySinhTo.setForeground(Color.white);
            lbqueQuan.setForeground(Color.white);
            lbquocTich.setForeground(Color.white);
            lbtenKH.setForeground(Color.white);
            txtngaySinh.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            txtngaySinh.getCalendarButton().setBackground(Color.decode("#919191"));
            txtngaySinh.getCalendarButton().setFocusPainted(false);

            txtngaySinhTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            txtngaySinhTo.getCalendarButton().setBackground(Color.decode("#919191"));
            txtngaySinhTo.getCalendarButton().setFocusPainted(false);
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
        }
    }
}
