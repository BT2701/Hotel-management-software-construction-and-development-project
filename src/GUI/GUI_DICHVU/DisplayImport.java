package GUI.GUI_DICHVU;

import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.PhieuNhapDTO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FontCharset;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DisplayImport extends JPanel {

    JPanel pnTop, pnLabel, pnButton;
    JLabel lbTitle, lbDetail;
    Font sgUI13b, sgUI18b, tNR13i;
    JButton btnAdd, btnImportFile, btnExportFile;
    int LightDark;
    DisplayImportContent displayImportContent;
    DisplayImportAdd displayImportAdd;
    JButton btnCancel = new JButton("Hủy phiếu nhập");

    public DisplayImport() {
        pnTop = new JPanel();
        lbTitle = new JLabel("Nhập dịch vụ thức ăn");
        lbDetail = new JLabel("Bấm vào nút Xem chi tiết mỗi dòng của danh sách để xem thông tin");
        sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
        sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
        tNR13i = new Font("Times New Roman", Font.ITALIC, 13);
        pnLabel = new JPanel();
        pnButton = new JPanel();
        btnAdd = new JButton("Tạo phiếu nhập");
        btnImportFile = new JButton("Nhập tệp");
        btnExportFile = new JButton("Xuất tệp");
        displayImportContent = new DisplayImportContent();
        displayImportAdd = new DisplayImportAdd(DisplayImport.this);
        initComponents();
        displayImportContent.lightDark(LightDark);
        displayImportAdd.lightDark(LightDark);
    }

    public void initComponents() {
        setLayout(new BorderLayout(5, 5));
        add(pnTop, BorderLayout.NORTH);
        add(displayImportContent, BorderLayout.CENTER);
        pnTop.setLayout(new BorderLayout());
        pnTop.add(pnLabel, BorderLayout.WEST);
        pnTop.add(pnButton, BorderLayout.CENTER);

        pnLabel.setLayout(new GridLayout(2, 1, 5, 5));
        pnLabel.add(lbTitle);
        pnLabel.add(lbDetail);
        lbTitle.setFont(sgUI18b);
        lbDetail.setFont(tNR13i);

        pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnButton.add(btnImportFile);
        pnButton.add(btnExportFile);
        pnButton.add(btnAdd);
        setMouse(btnAdd);
        setMouse(btnExportFile);
        setMouse(btnImportFile);
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

        btnCancel.setFont(sgUI13b);
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        ImageIcon iconCancel = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnCancel.setIcon(iconCancel);
        setMouseCancel();

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnButton.removeAll();
                pnButton.add(btnImportFile);
                pnButton.add(btnExportFile);
                pnButton.add(btnAdd);
                remove(displayImportAdd);
                revalidate();
                repaint();
                add(displayImportContent, BorderLayout.CENTER);
                displayImportContent.repaint();
            }
        });
        setEvent();
        actionAdd();
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

    public void setMouseCancel() {
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (LightDark == 0) {
                    btnCancel.setBackground(Color.decode("#ff3333"));
                    btnCancel.setForeground(Color.white);
                } else {
                    btnCancel.setBackground(Color.decode("#D4D4D4"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (LightDark == 0) {
                    btnCancel.setBackground(Color.decode("#ffcccc"));
                    btnCancel.setForeground(Color.black);
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
                pnButton.removeAll();
                pnButton.add(btnCancel);
                remove(displayImportContent);
                revalidate();
                repaint();
                add(displayImportAdd, BorderLayout.CENTER);
                displayImportAdd.tbNhapDV.renderTB();
            }
        });
    }

    public void setEvent() {
        btnImportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionImportFile();
            }
        });
        btnExportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //actionExportFile();
            }
        });
    }

    public void actionImportFile() {
        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showSaveDialog(null);

            if (chooser.getSelectedFile() == null) {
                return;
            }
            String path = chooser.getSelectedFile().getPath();
            //String filename=chooser.getSelectedFile().getName();
            FileInputStream file = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<PhieuNhapDTO> listPN = new ArrayList<>();
            boolean[] flagSoNguyen = new boolean[sheet.getLastRowNum()]; //flag de kiem tra xem cac gia tri giaP va so ng, tinhTrang va hienTrang co phai la so nguyen Pong
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { //bo row 0, cac row Pac -1
                    continue;
                }
                for (Cell cell : row) {
                    listPN.add(new PhieuNhapDTO());
                    switch (cell.getColumnIndex()) {
                        case 1: { //maPN
                            listPN.get(row.getRowNum() - 1).setMaPN(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 2: { //maNV
                            listPN.get(row.getRowNum() - 1).setMaNV(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 3: { //ngayLap
                            listPN.get(row.getRowNum() - 1).setNgayLapPhieu(cell.getStringCellValue());
                        }
                        ;
                        case 4: { //tinhTrang
                            try {
                                flagSoNguyen[row.getRowNum() - 1] = true;
                                listPN.get(row.getRowNum() - 1).setTinhTrangXuLy((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listPN.get(row.getRowNum() - 1).setTinhTrangXuLy(-1);
                                flagSoNguyen[row.getRowNum() - 1] = false;
                            }
                        }
                        ;
                        break;
                        default:
                            break;
                    }
                }
                //neu row trong 
                PhieuNhapDTO temp = listPN.get(row.getRowNum() - 1);
                if (temp.getMaPN().equals("") && temp.getMaNV().equals("") && temp.getNgayLapPhieu().equals("")) {
                    flagSoNguyen[row.getRowNum() - 1] = false;
                } else if (!flagSoNguyen[row.getRowNum() - 1]) { //loi so nguyen tinhTrang
                    JOptionPane.showMessageDialog(this, "row %d: ".formatted(row.getRowNum())
                            + "\nTinh Trang phải là số nguyên");
                }
            }

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                int flag = validateNVDTO(listPN.get(i), i + 1); //neu validate=0 k them Pach hang, validate=1 them Pach hang, validate=2 sua Pach hang
                if (flag == 1) {
                    listPN.get(i).setXuLy(0);
                    PhieuNhapBUS.insertPN(listPN.get(i));
                } else if (flag == 2) {
                    PhieuNhapBUS.updateXuLy(listPN.get(i).getMaPN());
                }
            }
            ArrayList<PhieuNhapDTO> tmp = PhieuNhapBUS.getListPN();
            displayImportContent.getTbPN().renderTB();
            workbook.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int validateNVDTO(PhieuNhapDTO x, int row) {
        //kiem tra maNV
        if (x.getMaNV().equals("")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập maNV");
            return 0;
        } else if (!NhanVienBUS.checkID(x.getMaNV())) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập maNV hợp lệ");
            return 0;
        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            //kiem tra ngay nhap
            if (df.parse(x.getNgayLapPhieu()) == null) {
                JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                        + "Ngày lập phiếu k trống");
                return 0;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "định dạng ngày: dd-MM-yyyy");
            return 0;
        }
        //keim tra tinhTrang
        //la 1 so nguyen kiem tra ở trên
        if (x.getTinhTrangXuLy() < 0 || x.getTinhTrangXuLy() > 1) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "TinhTrang = 0 || 1");
            return 0;
        }
        //kiem tra maPN
        PhieuNhapDTO pNTemp = PhieuNhapBUS.searchPN(x.getMaPN());
        if (pNTemp.getMaPN() != null) { //ton tai maPN
            int result = JOptionPane.showConfirmDialog(this, "Mã PN " + x.getMaPN() + " đã tồn tại, bạn có muốn cập nhật thông tin PN", "Thông báo update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                return 2;
            } else {
                return 0;
            }
        }
        int result = JOptionPane.showConfirmDialog(this, "row %d: \n".formatted(row)
                + "Mã PN sẽ tự khởi tạo \n"
                + "Mã NV: %s \n".formatted(x.getMaNV())
                + "Ngày lập: %s \n".formatted(x.getNgayLapPhieu())
                + "Tình trạng: %d \n".formatted(x.getTinhTrangXuLy()),
                "Thêm PN?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return 0;
        }

        String ngayLap = x.getNgayLapPhieu().substring(0, 2) + x.getNgayLapPhieu().substring(3, 5) + x.getNgayLapPhieu().substring(8);
        //lay so luong nhap trong ngay, tang len 1
        String stt;
        int newIndex = PhieuNhapBUS.getCountImportToday();
        stt = "";
        stt += String.valueOf(newIndex);
        while (stt.length() < 4) {
            stt = "0" + stt;
        }
        //gan gia tri cho ma PN
        x.setMaPN("PN" + ngayLap + stt);
        return 1;
    }

    public void actionExportFile() {
        String path = null;
        //tao chuoi header
        String[] txtHeader = new String[]{"STT", "Mã PN", "Mã NV", "Ngày lập phiếu", "Tình trạng"};

        //lay du lieu tu listPN
        ArrayList<PhieuNhapDTO> listPN = PhieuNhapBUS.getListPN();
        int rowCount = listPN.size();
        int columnCount = txtHeader.length;
        String[][] data = new String[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                switch (j) {
                    case 0:
                        data[i][j] = String.valueOf(i + 1);
                        break;
                    case 1:
                        data[i][j] = listPN.get(i).getMaPN();
                        break;
                    case 2:
                        data[i][j] = listPN.get(i).getMaNV();
                        break;
                    case 3:
                        data[i][j] = listPN.get(i).getNgayLapPhieu();
                        break;
                    case 4:
                        data[i][j] = String.valueOf(listPN.get(i).getTinhTrangXuLy());
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }

        try {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showSaveDialog(null);
            if (chooser.getSelectedFile() == null) {
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
                    if (j == 0 || j == 4) { //cac cot stt, tinhTrang thi la int
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

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = LightDark;            
            displayImportAdd.lightDark(LightDark);
            displayImportContent.lightDark(LightDark);
            setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnLabel.setBackground(Color.white);
            pnButton.setBackground(Color.white);
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
            btnCancel.setBackground(Color.decode("#ffcccc"));
            lbDetail.setForeground(Color.black);
            lbTitle.setForeground(Color.black);
        } else {
            this.LightDark = LightDark;
            Color black = Color.decode("#333333");
            displayImportAdd.lightDark(LightDark);
            displayImportContent.lightDark(LightDark);
            setBackground(black);
            pnTop.setBackground(black);
            pnLabel.setBackground(black);
            pnButton.setBackground(black);
            btnAdd.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            btnCancel.setBackground(Color.decode("#F0F0F0"));
            lbDetail.setForeground(Color.white);
            lbTitle.setForeground(Color.white);
        }
    }
}
