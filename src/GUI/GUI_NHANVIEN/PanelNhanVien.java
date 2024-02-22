package GUI.GUI_NHANVIEN;

import BUS.NhanVienBUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import static GUI.GUI_NHANVIEN.jdialog.patternEmail;
import static GUI.GUI_NHANVIEN.jdialog.patternTenNV;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FontCharset;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PanelNhanVien extends JPanel {

    int LightDark;
    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();
    JPanel pnTopHeader = new JPanel();
    JPanel pnTopHeaderLeft = new JPanel();
    JPanel pnTopHeaderRight = new JPanel();
    JLabel lbTopHeaderLeftTop = new JLabel("Quản lý nhân viên");
    JLabel lbTopHeaderLeftBottom = new JLabel("Bấm vào hàng của bảng danh sách nhân viên để chỉnh sửa");
    JButton btnAdd = new JButton("Thêm Nhân viên");
    JButton btnImportFile = new JButton("Nhập tệp");
    JButton btnExportFile = new JButton("Xuất tệp");

    JPanel pnMaNV = new JPanel();
    JLabel lbMaNV = new JLabel("Mã nhân viên");
    JTextField txtMaNV = new JTextField();

    JPanel pnTenNV = new JPanel();
    JLabel lbTenNV = new JLabel("Tên nhân viên");
    JTextField txtTenNV = new JTextField();

    JPanel pnGioiTinh = new JPanel();
    JLabel lbGioiTinh = new JLabel("Giới tính");
    JPanel pnGioiTinhCkb = new JPanel();
    JCheckBox ckbNam = new JCheckBox("Nam");
    JCheckBox ckbNu = new JCheckBox("Nữ");

    JPanel pnChucVu = new JPanel();
    JLabel lbChucVu = new JLabel("Chức vụ");
    JComboBox cbChucVu = new JComboBox();

    JPanel pnNgaySinhFrom = new JPanel();
    JLabel lbNgaySinhFrom = new JLabel("Ngày sinh từ");
    JDateChooser dateNgaySinhFrom = new JDateChooser();

    JPanel pnNgaySinhTo = new JPanel();
    JLabel lbNgaySinhTo = new JLabel("đến         ");
    JDateChooser dateNgaySinhTo = new JDateChooser();

    JPanel pnNgayVaoLamFrom = new JPanel();
    JLabel lbNgayVaoLamFrom = new JLabel("Vào làm từ");
    JDateChooser dateNgayVaoLamFrom = new JDateChooser();

    JPanel pnNgayVaoLamTo = new JPanel();
    JLabel lbNgayVaoLamTo = new JLabel("đến         ");
    JDateChooser dateNgayVaoLamTo = new JDateChooser();

    JPanel pnSoNgayPhep = new JPanel();
    JLabel lbSoNgayPhep = new JLabel("Số ngày phép");
    JComboBox cbSoNgayPhep = new JComboBox();

    JPanel pnLuong1Ngay = new JPanel();
    JLabel lbLuong1Ngay = new JLabel("Lương 1 ngày");
    JComboBox cbLuong1Ngay = new JComboBox();

    JPanel pnEmail = new JPanel();
    JLabel lbEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField();

    JPanel pnBtnSearch = new JPanel();
    JButton btnReset = new JButton("Làm mới");
    JButton btnSearch = new JButton("Tìm kiếm");

    JPanel pnEmp = new JPanel();

    LineBorder lineCB = new LineBorder(Color.white);
    ArrayList<JPanel> listPN = new ArrayList<>();
    JPanel pnTopCenter = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentCenterTop = new JPanel();
    JLabel lbContentCentertop = new JLabel("Danh sách nhân viên khách sạn");
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF"));
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
    EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);
    JScrollPane scp = new JScrollPane();
    TableNhanVien tbNV = new TableNhanVien();

    JTextFieldDateEditor editorNgayVaoLamFrom = (JTextFieldDateEditor) dateNgayVaoLamFrom.getDateEditor();
    JTextFieldDateEditor editorNgayVaoLamTo = (JTextFieldDateEditor) dateNgayVaoLamTo.getDateEditor();

    JTextFieldDateEditor editorNgaySinhFrom = (JTextFieldDateEditor) dateNgaySinhFrom.getDateEditor();
    JTextFieldDateEditor editorNgaySinhTo = (JTextFieldDateEditor) dateNgaySinhTo.getDateEditor();

    public PanelNhanVien() {
        initComponents();
        lightDark(LightDark);
        setEvent();
    }

    //Duy
    public void setEvent() {
        //setEvent for btn
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionReset();
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdialog addNV = new jdialog();
                addNV.setLocationRelativeTo(null);
                addNV.setVisible(true);
                addNV.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        tbNV.setData(NhanVienBUS.getListNV());
                    }
                });
            }
        });
        btnImportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionImportFile();
            }
        });
        btnExportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionExportFile();
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSearch();
            }
        });
        tbNV.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {     // to detect doble click events
                    int row = tbNV.getSelectedRow(); // select a row\
                    String[] temp = new String[9];
                    for (int i = 1; i < 10; i++) {
                        temp[i - 1] = tbNV.getValueAt(row, i).toString();
                    }
                    jdialog capNhat = new jdialog(temp);
                    capNhat.setLocationRelativeTo(null);
                    capNhat.setVisible(true);
                    capNhat.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            tbNV.setData(NhanVienBUS.getListNV());
                        }
                    });

//              int column = tbNV.getSelectedColumn(); // select a column
//              JOptionPane.showMessageDialog(null, tbNV.getValueAt(row, column)); // get the value of a row and column.
                }
            }
        });
    }

    public void actionReset() {
        //setText
        txtMaNV.setText("");
        txtEmail.setText("");
        txtTenNV.setText("");
        //setDate
        dateNgaySinhFrom.setDate(null);
        dateNgaySinhTo.setDate(null);
        dateNgayVaoLamFrom.setDate(null);
        dateNgayVaoLamTo.setDate(null);
        //setCheckbox
        ckbNam.setSelected(false);
        ckbNu.setSelected(false);
        //setCombo
        cbChucVu.setSelectedIndex(0);
        cbLuong1Ngay.setSelectedIndex(0);
        cbSoNgayPhep.setSelectedIndex(0);
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

            ArrayList<NhanVienDTO> listNV = new ArrayList<>();
            boolean[] flagSoNguyen = new boolean[sheet.getLastRowNum()]; //flag de kiem tra xem cac gia tri luong 1 ngay va so ngay phep co phai la so nguyen khong
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { //bo row 0, cac row khac -1
                    continue;
                }
                if (row == null) {
                    flagSoNguyen[row.getRowNum() - 1] = false;
                }
                for (Cell cell : row) {
                    listNV.add(new NhanVienDTO());
                    switch (cell.getColumnIndex()) {
                        case 1: { //maNV
                            listNV.get(row.getRowNum() - 1).setMaNV(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 2: { //tenNV
                            listNV.get(row.getRowNum() - 1).setTenNV(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 3: { //gioiTinh
                            listNV.get(row.getRowNum() - 1).setGioiTinh(cell.getStringCellValue());
                        }
                        ;
                        case 4: { //ngaySinh
                            listNV.get(row.getRowNum() - 1).setNgaySinh(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 5: { //ngayVaoLam
                            listNV.get(row.getRowNum() - 1).setNgayVaoLam(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 6: { //chucVu
                            listNV.get(row.getRowNum() - 1).setChucVu(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 7: { //soNgayPhep
                            try {
                                flagSoNguyen[row.getRowNum() - 1] = true;
                                listNV.get(row.getRowNum() - 1).setSoNgayPhep((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listNV.get(row.getRowNum() - 1).setSoNgayPhep(-1);
                                flagSoNguyen[row.getRowNum() - 1] = false;
                            }
                        }
                        ;
                        break;
                        case 8: { //luong1Ngay
                            try {
                                flagSoNguyen[row.getRowNum() - 1] = true;
                                listNV.get(row.getRowNum() - 1).setLuong1Ngay((int) cell.getNumericCellValue());
                            } catch (NumberFormatException e) {
                                listNV.get(row.getRowNum() - 1).setLuong1Ngay(-1);
                                flagSoNguyen[row.getRowNum() - 1] = false;
                            }
                        }
                        ;
                        break;
                        case 9: { //email
                            listNV.get(row.getRowNum() - 1).setEmail(cell.getStringCellValue());
                        }
                        ;
                        break;
                        default:
                            break;
                    }
                }
                //neu row trong
                NhanVienDTO temp = listNV.get(row.getRowNum() - 1);
                if (temp.getMaNV().equals("") && temp.getTenNV().equals("") && temp.getGioiTinh().equals("") && temp.getNgaySinh().equals("") && temp.getNgayVaoLam().equals("") && temp.getChucVu().equals("") && temp.getEmail().equals("")) {
                    flagSoNguyen[row.getRowNum() - 1] = false;
                } else if (!flagSoNguyen[row.getRowNum() - 1]) { //loi so nguyen luong va ngay phep
                    JOptionPane.showMessageDialog(pnContent, "row %d: ".formatted(row.getRowNum())
                            + "lương 1 ngày và số ngày phép la 1 so nguyen");
                }
            }

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                if (flagSoNguyen[i]) { //neu cac gia tri nguyen thoa man thi validate
                    int flag = validateNVDTO(listNV.get(i), i + 1); //neu validate=0 k them nhan vien, validate=1 them nhan vien, validate=2 sua nhan vien
                    if (flag == 1) {
                        NhanVienBUS.insertNV(listNV.get(i));
                    } else if (flag == 2) {
                        NhanVienBUS.updateNV(listNV.get(i));
                    }
                }
            }
            ArrayList<NhanVienDTO> tmp = NhanVienBUS.getListNV();
            tbNV.setData(tmp);
            workbook.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int validateNVDTO(NhanVienDTO x, int row) {
        String regexTenNV = jdialog.regexTenNV;
        String regexEmail = jdialog.regexEmail;
        //kiem tra tenNV
        if (!patternTenNV(x.getTenNV(), regexTenNV)) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "TenNV không hợp lệ, chỉ gồm chữ và khoảng trắng");
            return 0;
        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            //kiem tra ngay
            if (df.parse(x.getNgaySinh()) == null || df.parse(x.getNgayVaoLam()) == null) {
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
            if (df.parse(x.getNgaySinh()).after(today)) {
                JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                        + "Ngày sinh không hợp lệ, phải lớn hơn 18 tuổi");
                return 0;
            }
            today = df.parse(x.getNgaySinh()); //ngaySinh
            String chkNgayLam = dfm.format(today); //ngaySinh
            //lay nam nay cong them 18 moi duoc vao lam
            String yearLam = chkNgayLam.toString().substring(4, 8);
            year = Integer.parseInt(yearLam);
            year += 18;
            //18 nam sau
            chkNgayLam = chkNgayLam.substring(0, 4) + String.valueOf(year);
            if (df.parse(x.getNgayVaoLam()).before(dfm.parse(chkNgayLam))) {
                JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                        + "Được 18 tuổi kể từ ngày sinh mới được làm");
                return 0;
            }
        } catch (ParseException e) {
            //da kiem tra o tren
        }
        //keim tra soNgayPhep va Luong
        //la 1 so nguyen kiem tra ở trên
        if (x.getLuong1Ngay() < 0 || x.getSoNgayPhep() < 0 || x.getSoNgayPhep() > 30) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Lương>=0; 0<=Ngày phép<=30");
            return 0;
        }
        //kiem tra Emal
        if (x.getEmail().equals("")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập Email");
            return 0;
        } else if (!patternEmail(x.getEmail(), regexEmail)) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập Email hợp lệ");
            return 0;
        }
        //kiem tra gioiTinh
        if (!x.getGioiTinh().equalsIgnoreCase("Nam") && !x.getGioiTinh().equalsIgnoreCase("Nữ")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Giới tính là nam hoặc nữ");
            return 0;
        }
        //kiem tra chucVu
        if (!x.getChucVu().equalsIgnoreCase("quản lý") && !x.getChucVu().equalsIgnoreCase("lễ tân") && !x.getChucVu().equalsIgnoreCase("kế toán")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Chức vụ là: quản lý, lễ tân hoặc kế toán");
            return 0;
        }
        //kiem tra maNV
        if (NhanVienBUS.checkID(x.getMaNV())) { //ton tai ma nhan vien
            int result = JOptionPane.showConfirmDialog(pnContent, "Mã nhân viên " + x.getMaNV() + " đã tồn tại, bạn có muốn cập nhật thông tin nhân viên", "Thông báo update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                return 2;
            } else {
                return 0;
            }
        }

        int result = JOptionPane.showConfirmDialog(this, "row %d: \n".formatted(row)
                + "Mã nhân viên sẽ tự khởi tạo \n"
                + "Tên nhân viên: %s \n".formatted(x.getTenNV())
                + "Giới tính: %s \n".formatted(x.getGioiTinh())
                + "Chức vụ: %s \n".formatted(x.getChucVu())
                + "Ngày sinh: %s \n".formatted(x.getNgaySinh()
                        + "Ngày vào làm: %s \n".formatted(x.getNgayVaoLam())
                        + "Email: %s \n".formatted(x.getEmail())
                        + "Lương 1 ngày: %s \n".formatted(x.getLuong1Ngay())
                        + "Số ngày phép: %s \n".formatted(x.getSoNgayPhep())),
                "Thêm nhân viên?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return 0;
        }
        boolean[] attri = new boolean[11];
        attri[0] = true;
        String values[] = new String[11];
        values[0] = "NV";
        //string for top and order
        String top, order;
        top = "top 1 ";
        order = " order by SUBSTRING(maNV,10,13) desc ";
        ArrayList<NhanVienDTO> listNV = new ArrayList<>();
        listNV = NhanVienBUS.searchNV(attri, values, top, order);
        //lay gioi tinh
        String gioiTinh = "0";
        if (x.getGioiTinh().equalsIgnoreCase("nữ")) {
            gioiTinh = "1";
        }
        //lay ngay lam; da duoc check o tren
        String ngayLam = x.getNgayVaoLam();
        //df=dd-MM-yyyy; dfm=ddMMyyyy
        ngayLam = ngayLam.substring(0, 2) + ngayLam.substring(3, 5) + ngayLam.substring(8);
        if (listNV.isEmpty()) {
            x.setMaNV("NV" + gioiTinh + ngayLam + "0001");
            return 0;
        }
        //lay stt cua nhan vien, tang len 1
        String stt = listNV.get(0).getMaNV().substring(9, 13);
        int newIndex = Integer.parseInt(stt);
        newIndex += 1;
        stt = "";
        stt += String.valueOf(newIndex);
        while (stt.length() < 4) {
            stt = "0" + stt;
        }
        //gan gia tri cho ma nv
        x.setMaNV("NV" + gioiTinh + ngayLam + stt);

        return 1;
    }

    public void actionExportFile() {
        String path = null;
        //tao chuoi header
        String[] txtHeader = new String[]{"STT", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Ngày vào làm", "Chức vụ", "Số ngày phép", "Lương 1 ngày", "Email"};
        //lay du lieu tu bang
        int rowCount = tbNV.getModel().getRowCount();
        int columnCount = txtHeader.length;
        String[][] data = new String[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = tbNV.getModel().getValueAt(i, j).toString();
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
                    if (j == 0 || j == 7 || j == 8) { //cac cot stt, ngayPhep, Luong thi la int
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

    public void actionSearch() {
        //kiem tra va luu cac thuoc tinh
        boolean[] attris = new boolean[11];
        String[] values = new String[11];
        //maNV
        if (txtMaNV.getText().equals("")) {
            attris[0] = false;
        } else {
            attris[0] = true;
            values[0] = txtMaNV.getText();
        }
        //tenNV
        if (txtTenNV.getText().equals("")) {
            attris[1] = false;
        } else {
            attris[1] = true;
            values[1] = txtTenNV.getText();
        }
        //gioiTInh
        if (ckbNam.isSelected() == ckbNu.isSelected()) {
            attris[2] = false;
        } else {
            attris[2] = true;
            if (ckbNam.isSelected() == true) {
                values[2] = "Nam";
            } else {
                values[2] = "Nữ";
            }
        }
        //chucVu
        if (cbChucVu.getSelectedIndex() == 0) {
            attris[3] = false;
        } else {
            attris[3] = true;
            values[3] = cbChucVu.getSelectedItem().toString();
        }
        //soNgayPhep
        if (cbSoNgayPhep.getSelectedIndex() == 0) {
            attris[4] = false;
        } else {
            attris[4] = true;
            values[4] = cbSoNgayPhep.getSelectedItem().toString();
        }
        //ngayFormat
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        //ngaySinhFrom
        if (dateNgaySinhFrom.getDate() == null) {
            attris[5] = false;
        } else {
            attris[5] = true;
            values[5] = df.format(dateNgaySinhFrom.getDate());
        }
        //ngaySinhTo
        if (dateNgaySinhTo.getDate() == null) {
            attris[6] = false;
        } else {
            attris[6] = true;
            values[6] = df.format(dateNgaySinhTo.getDate());
        }
        //ngayVaoLamFrom
        if (dateNgayVaoLamFrom.getDate() == null) {
            attris[7] = false;
        } else {
            attris[7] = true;
            values[7] = df.format(dateNgayVaoLamFrom.getDate());
        }
        //ngayVaoLamTo
        if (dateNgayVaoLamTo.getDate() == null) {
            attris[8] = false;
        } else {
            attris[8] = true;
            values[8] = df.format(dateNgayVaoLamTo.getDate());
        }
        //luong1Ngay
        if (cbLuong1Ngay.getSelectedIndex() == 0) {
            attris[9] = false;
        } else {
            attris[9] = true;
            values[9] = cbLuong1Ngay.getSelectedItem().toString();
        }
        //email
        if (txtEmail.getText().equals("")) {
            attris[10] = false;
        } else {
            attris[10] = true;
            values[10] = txtEmail.getText();
        }
        ArrayList<NhanVienDTO> tmp = NhanVienBUS.searchNV(attris, values, "", ""); //String for top and order "",""
        if (tmp.size() == 0) {
            actionReset();
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            tmp = NhanVienBUS.getListNV();
        }
        tbNV.setData(tmp);
    }
    //Duy

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

        lbTopHeaderLeftTop.setFont(sgUI18b);
        lbTopHeaderLeftBottom.setFont(tNR13);
        lbTopHeaderLeftBottom.setBorder(new EmptyBorder(3, 0, 0, 0));

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

        ckbNam.setFocusPainted(false);
        ckbNu.setFocusPainted(false);

        pnTopCenter.setLayout(new GridLayout(3, 5, 10, 5));
        listPN.add(pnMaNV);
        listPN.add(pnTenNV);
        listPN.add(pnGioiTinh);
        listPN.add(pnChucVu);
        listPN.add(pnSoNgayPhep);
        listPN.add(pnNgaySinhFrom);
        listPN.add(pnNgaySinhTo);
        listPN.add(pnNgayVaoLamFrom);
        listPN.add(pnNgayVaoLamTo);
        listPN.add(pnLuong1Ngay);
        listPN.add(pnEmail);
        listPN.add(pnBtnSearch);
        listPN.add(pnEmp);
        for (JPanel x : listPN) {
            pnTopCenter.add(x);
            x.setLayout(new BorderLayout(18, 10));
        }
        lbMaNV.setFont(sgUI13b);
        lbTenNV.setFont(sgUI13b);
        lbGioiTinh.setFont(sgUI13b);
        lbChucVu.setFont(sgUI13b);
        lbSoNgayPhep.setFont(sgUI13b);
        lbNgaySinhFrom.setFont(sgUI13b);
        lbNgaySinhTo.setFont(sgUI13b);
        lbNgayVaoLamFrom.setFont(sgUI13b);
        lbNgayVaoLamTo.setFont(sgUI13b);
        lbLuong1Ngay.setFont(sgUI13b);
        lbEmail.setFont(sgUI13b);

        txtMaNV.setFont(sgUI13);
        txtTenNV.setFont(sgUI13);
        ckbNam.setFont(sgUI13);
        ckbNu.setFont(sgUI13);
        cbChucVu.setFont(sgUI13);
        cbSoNgayPhep.setFont(sgUI13);
        dateNgaySinhFrom.setFont(sgUI13);
        dateNgaySinhTo.setFont(sgUI13);
        dateNgayVaoLamFrom.setFont(sgUI13);
        dateNgayVaoLamTo.setFont(sgUI13);
        cbLuong1Ngay.setFont(sgUI13);
        txtEmail.setFont(sgUI13);

        String chucVu[] = {"Chức vụ", "Quản lý", "Lễ tân", "Kế toán", "Bếp"};
        //Duy
        String luong[] = {"Lương 1 ngày", "Dưới 100000", "Từ 100000 đến 200000", "Từ 200000 đến 500000", "Từ 500000 đến 1000000", "Trên 1000000"};
        //Duy
        String ngayPhep[] = {"Số ngày phép", "Dưới 2", "Từ 2 đến 4", "Trên 4"};
        setDefaulComboBox(cbChucVu, chucVu);
        setDefaulComboBox(cbLuong1Ngay, luong);
        setDefaulComboBox(cbSoNgayPhep, ngayPhep);

        cbChucVu.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbLuong1Ngay.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbSoNgayPhep.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });

        pnMaNV.add(lbMaNV, BorderLayout.WEST);
        pnMaNV.add(txtMaNV, BorderLayout.CENTER);

        pnTenNV.add(lbTenNV, BorderLayout.WEST);
        pnTenNV.add(txtTenNV, BorderLayout.CENTER);

        pnGioiTinh.add(lbGioiTinh, BorderLayout.WEST);
        pnGioiTinh.add(pnGioiTinhCkb, BorderLayout.CENTER);
        pnGioiTinhCkb.setLayout(new GridLayout(1, 2));
        pnGioiTinhCkb.add(ckbNam);
        pnGioiTinhCkb.add(ckbNu);

        pnChucVu.add(lbChucVu, BorderLayout.WEST);
        pnChucVu.add(cbChucVu, BorderLayout.CENTER);

        pnSoNgayPhep.add(lbSoNgayPhep, BorderLayout.WEST);
        pnSoNgayPhep.add(cbSoNgayPhep, BorderLayout.CENTER);

        pnNgaySinhFrom.add(lbNgaySinhFrom, BorderLayout.WEST);
        pnNgaySinhFrom.add(dateNgaySinhFrom, BorderLayout.CENTER);

        pnNgaySinhTo.add(lbNgaySinhTo, BorderLayout.WEST);
        pnNgaySinhTo.add(dateNgaySinhTo, BorderLayout.CENTER);

        pnNgayVaoLamFrom.add(lbNgayVaoLamFrom, BorderLayout.WEST);
        pnNgayVaoLamFrom.add(dateNgayVaoLamFrom, BorderLayout.CENTER);

        pnNgayVaoLamTo.add(lbNgayVaoLamTo, BorderLayout.WEST);
        pnNgayVaoLamTo.add(dateNgayVaoLamTo, BorderLayout.CENTER);

        pnLuong1Ngay.add(lbLuong1Ngay, BorderLayout.WEST);
        pnLuong1Ngay.add(cbLuong1Ngay, BorderLayout.CENTER);

        pnEmail.add(lbEmail, BorderLayout.WEST);
        pnEmail.add(txtEmail, BorderLayout.CENTER);

        pnBtnSearch.setLayout(new GridLayout(1, 2, 10, 10));
        pnBtnSearch.add(btnReset);
        pnBtnSearch.add(btnSearch);
        pnTopCenter.setBorder(new EmptyBorder(0, 5, 0, 5));
        setMouse(btnReset);
        setMouse(btnSearch);
        setMouse(btnAdd);
        setMouse(btnExportFile);
        setMouse(btnImportFile);

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
        scp.setViewportView(tbNV);
        scp.setViewportBorder(null);
        tbNV.renderTB();
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

    MatteBorder borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));

    public void lightDark(int lightDark) {
        if (lightDark == 0) {
            this.LightDark = lightDark;
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnTopHeader.setBackground(Color.white);
            pnTopCenter.setBackground(Color.white);
            pnTopHeaderLeft.setBackground(Color.white);
            pnTopHeaderRight.setBackground(Color.white);
            pnContent.setBackground(Color.white);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, Color.white));
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            for (JPanel x : listPN) {
                x.setBackground(Color.white);
            }

            cbChucVu.setBorder(matteBorderCB);
            cbLuong1Ngay.setBorder(matteBorderCB);
            cbSoNgayPhep.setBorder(matteBorderCB);
            cbChucVu.setBackground(Color.white);
            cbLuong1Ngay.setBackground(Color.white);
            cbSoNgayPhep.setBackground(Color.white);

            pnGioiTinhCkb.setBackground(Color.white);
            ckbNam.setBackground(Color.white);
            ckbNu.setBackground(Color.white);

            txtMaNV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtTenNV.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            txtEmail.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
            scp.getViewport().setBackground(Color.white);
            scp.setBackground(Color.white);
            pnContentCenterTop.setBackground(Color.white);
            tbNV.getTableHeader().setBackground(Color.decode("#dee9fc"));
            tbNV.getTableHeader().setForeground(Color.decode("#000000"));
            editorNgaySinhFrom.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            editorNgaySinhTo.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            editorNgayVaoLamFrom.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            editorNgayVaoLamTo.setBorder(BorderFactory.createCompoundBorder(borderTxt, new EmptyBorder(0, 3, 0, 3)));
            lbChucVu.setForeground(Color.black);
            lbContentCentertop.setForeground(Color.black);
            lbEmail.setForeground(Color.black);
            lbGioiTinh.setForeground(Color.black);
            lbLuong1Ngay.setForeground(Color.black);
            lbMaNV.setForeground(Color.black);
            lbNgaySinhFrom.setForeground(Color.black);
            lbNgaySinhTo.setForeground(Color.black);
            lbNgayVaoLamFrom.setForeground(Color.black);
            lbNgayVaoLamTo.setForeground(Color.black);
            lbSoNgayPhep.setForeground(Color.black);
            lbTenNV.setForeground(Color.black);
            lbTopHeaderLeftTop.setForeground(Color.black);
            lbTopHeaderLeftBottom.setForeground(Color.black);
            txtEmail.setForeground(Color.black);
            txtMaNV.setForeground(Color.black);
            txtTenNV.setForeground(Color.black);
            txtEmail.setBackground(Color.decode("#FFFFFF"));
            txtMaNV.setBackground(Color.decode("#FFFFFF"));
            txtTenNV.setBackground(Color.decode("#FFFFFF"));
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            cbSoNgayPhep.setForeground(Color.black);
            cbChucVu.setForeground(Color.black);
            cbLuong1Ngay.setForeground(Color.black);
            ckbNam.setForeground(Color.black);
            ckbNu.setForeground(Color.black);
            dateNgaySinhFrom.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgaySinhFrom.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
            dateNgaySinhFrom.getCalendarButton().setFocusPainted(false);

            dateNgaySinhTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgaySinhTo.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
            dateNgaySinhTo.getCalendarButton().setFocusPainted(false);

            dateNgayVaoLamFrom.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgayVaoLamFrom.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
            dateNgayVaoLamFrom.getCalendarButton().setFocusPainted(false);

            dateNgayVaoLamTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgayVaoLamTo.getCalendarButton().setBackground(Color.decode("#EEEEEE"));
            dateNgayVaoLamTo.getCalendarButton().setFocusPainted(false);
            editorNgaySinhFrom.setBackground(Color.decode("#FFFFFF"));
            editorNgaySinhTo.setBackground(Color.decode("#FFFFFF"));
            editorNgayVaoLamFrom.setBackground(Color.decode("#FFFFFF"));
            editorNgayVaoLamTo.setBackground(Color.decode("#FFFFFF"));
        } else {
            Color black = Color.decode("#333333");
            this.LightDark = lightDark;
            setBackground(black);
            pnTop.setBackground(black);
            pnTopHeader.setBackground(black);
            pnTopCenter.setBackground(black);
            pnTopHeaderLeft.setBackground(black);
            pnTopHeaderRight.setBackground(black);
            pnContent.setBackground(black);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, black));
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            for (JPanel x : listPN) {
                x.setBackground(black);
            }

            cbChucVu.setBorder(borderTxtDark);
            cbLuong1Ngay.setBorder(borderTxtDark);
            cbSoNgayPhep.setBorder(borderTxtDark);
            cbChucVu.setBackground(Color.decode("#474747"));
            cbLuong1Ngay.setBackground(Color.decode("#474747"));
            cbSoNgayPhep.setBackground(Color.decode("#474747"));
            cbSoNgayPhep.setForeground(Color.white);
            cbChucVu.setForeground(Color.white);
            cbLuong1Ngay.setForeground(Color.white);
            ckbNam.setForeground(Color.white);
            ckbNu.setForeground(Color.white);
            pnGioiTinhCkb.setBackground(black);
            ckbNam.setBackground(black);
            ckbNu.setBackground(black);

            txtMaNV.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtTenNV.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtEmail.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
            scp.getViewport().setBackground(black);
            scp.setBackground(black);
            pnContentCenterTop.setBackground(black);
            tbNV.getTableHeader().setBackground(Color.decode("#202020"));
            tbNV.getTableHeader().setForeground(Color.decode("#FFFFFF"));
            editorNgaySinhFrom.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            editorNgaySinhTo.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            editorNgayVaoLamFrom.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            editorNgayVaoLamTo.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));

            lbChucVu.setForeground(Color.white);
            lbContentCentertop.setForeground(Color.white);
            lbEmail.setForeground(Color.white);
            lbGioiTinh.setForeground(Color.white);
            lbLuong1Ngay.setForeground(Color.white);
            lbMaNV.setForeground(Color.white);
            lbNgaySinhFrom.setForeground(Color.white);
            lbNgaySinhTo.setForeground(Color.white);
            lbNgayVaoLamFrom.setForeground(Color.white);
            lbNgayVaoLamTo.setForeground(Color.white);
            lbSoNgayPhep.setForeground(Color.white);
            lbTenNV.setForeground(Color.white);
            lbTopHeaderLeftTop.setForeground(Color.white);
            lbTopHeaderLeftBottom.setForeground(Color.white);
            txtEmail.setForeground(Color.white);
            txtMaNV.setForeground(Color.white);
            txtTenNV.setForeground(Color.white);
            txtEmail.setBackground(Color.decode("#474747"));
            txtMaNV.setBackground(Color.decode("#474747"));
            txtTenNV.setBackground(Color.decode("#474747"));
            btnAdd.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            dateNgaySinhFrom.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgaySinhFrom.getCalendarButton().setBackground(Color.decode("#919191"));
            dateNgaySinhFrom.getCalendarButton().setFocusPainted(false);

            dateNgaySinhTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgaySinhTo.getCalendarButton().setBackground(Color.decode("#919191"));
            dateNgaySinhTo.getCalendarButton().setFocusPainted(false);

            dateNgayVaoLamFrom.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgayVaoLamFrom.getCalendarButton().setBackground(Color.decode("#919191"));
            dateNgayVaoLamFrom.getCalendarButton().setFocusPainted(false);

            dateNgayVaoLamTo.getCalendarButton().setBorder(new EmptyBorder(0, 5, 0, 5));
            dateNgayVaoLamTo.getCalendarButton().setBackground(Color.decode("#919191"));
            dateNgayVaoLamTo.getCalendarButton().setFocusPainted(false);
            
            editorNgaySinhFrom.setBackground(Color.decode("#474747"));
            editorNgaySinhTo.setBackground(Color.decode("#474747"));
            editorNgayVaoLamFrom.setBackground(Color.decode("#474747"));
            editorNgayVaoLamTo.setBackground(Color.decode("#474747"));
        }
    }

    public void setDefaulComboBox(JComboBox x, String list[]) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String y : list) {
            dcbm.addElement(y);
        }
        x.setModel(dcbm);
    }
}
