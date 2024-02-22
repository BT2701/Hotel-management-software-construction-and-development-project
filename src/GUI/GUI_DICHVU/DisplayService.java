package GUI.GUI_DICHVU;

import BUS.DichVuBUS;
import DTO.DichVuDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.*;
import GUI.GUI_NHANVIEN.jdialog;
import static GUI.GUI_NHANVIEN.jdialog.patternTenNV;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.activation.MimetypesFileTypeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FontCharset;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DisplayService extends JPanel {

    JPanel pnTop, pnContent, pnContentInput, pnMaDV, pnTenDV, pnLoaiDV, pnGiaDV, pnButton, pnTopHeader,
            pnTopButton, pnContentCenter, pnContentLeft;
    JLabel lbTopTitle, lbTopDetail, lbMaDV, lbTenDV, lbLoaiDV, lbGiaDV,
            lbContentLeft;
    JTextField txtMaDV, txtTenDV;
    JComboBox cbLoaiDV, cbGiaDV;
    JButton btnAdd, btnImportFile, btnExportFile, btnReset, btnSearch;
    Font sgUI13b, sgUI13, sgUI18b, tNR13i;
    JScrollPane scpDV;
    TableDichVu tbDV;
    Border bdMatte2_2_2_2_efefef, bdEmpty0_7_0_7, bdEmpty0_7_0_0;
    MatteBorder borderTxtDark;
    ScrollBar scrB;
    int LightDark;
    DisplayServiceFormInput formInput = new DisplayServiceFormInput(this);

    public DisplayService() {
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
        btnAdd = new JButton("Thêm dịch vụ");
        btnImportFile = new JButton("Nhập tệp");
        btnExportFile = new JButton("Xuất tệp");
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
        borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
        //new 
        initComponents();
    }

    public void initComponents() {
        setLayout(new BorderLayout(5, 5));
        add(pnTopHeader, BorderLayout.NORTH);

        pnTopHeader.setLayout(new BorderLayout());
        pnTopHeader.add(pnTop, BorderLayout.WEST);
        pnTopHeader.add(pnTopButton, BorderLayout.CENTER);

        pnTop.setLayout(new GridLayout(2, 1, 5, 5));
        pnTop.add(lbTopTitle);
        pnTop.add(lbTopDetail);

        pnTopButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnTopButton.add(btnImportFile);
        pnTopButton.add(btnExportFile);
        pnTopButton.add(btnAdd);

        setFont_BorderPainted_setFocusPainted(btnImportFile, sgUI13b);
        setFont_BorderPainted_setFocusPainted(btnExportFile, sgUI13b);
        setFont_BorderPainted_setFocusPainted(btnAdd, sgUI13b);

        ImageIcon iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/them.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnAdd.setIcon(iconAdd);

        ImageIcon iconImport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnImportFile.setIcon(iconImport);

        ImageIcon iconExport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        btnExportFile.setIcon(iconExport);

        setMouse(btnAdd);
        setMouse(btnExportFile);
        setMouse(btnImportFile);
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
                    new ThongBaoDialog("Vui lòng nhập thông tin cần tìm", 1);
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
                        new ThongBaoDialog("Không tìm thấy dịch vụ phù hợp", 1);
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
        pnContentCenter.add(formInput, BorderLayout.EAST);

        //set display pnContentLeft
        pnContentLeft.setLayout(new BorderLayout(7, 7));
        pnContentLeft.add(lbContentLeft, BorderLayout.NORTH);
        pnContentLeft.add(scpDV, BorderLayout.CENTER);

        lbContentLeft.setFont(sgUI18b);

        scpDV.setViewportView(tbDV);
        scpDV.setBorder(new EmptyBorder(5, 5, 5, 5));
        tbDV.renderTB();
        actionShowContentRight();

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
                            new FormDetailService(true, maDV, tenDV, giaDV, loaiDV, pathImg, DisplayService.this);
                        } else {
                            new FormDetailService(false, maDV, tenDV, giaDV, loaiDV, pathImg, DisplayService.this);
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        setEvent();
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
                actionExportFile();
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

            if (chooser.getSelectedFile() == null) {
                return;
            }
            String path = chooser.getSelectedFile().getPath();
            //String filename=chooser.getSelectedFile().getName();
            FileInputStream file = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<DichVuDTO> listDV = new ArrayList<>();
            boolean[] flagSoNguyen = new boolean[sheet.getLastRowNum()]; //flag de kiem tra xem cac gia tri giaP va so ng, tinhTrang va hienTrang co phai la so nguyen Pong
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { //bo row 0, cac row Pac -1
                    continue;
                }
                for (Cell cell : row) {
                    listDV.add(new DichVuDTO());
                    switch (cell.getColumnIndex()) {
                        case 1: { //ma DV
                            listDV.get(row.getRowNum() - 1).setMaDV(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 2: { //maNV
                            listDV.get(row.getRowNum() - 1).setTenDV(cell.getStringCellValue());
                        }
                        ;
                        break;
                        case 3: { //hinhDV
                            listDV.get(row.getRowNum() - 1).setHinhAnh(cell.getStringCellValue());
                        }
                        ;
                        case 4: { //loaiDV
                            listDV.get(row.getRowNum() - 1).setLoaiDV(cell.getStringCellValue());
                        }
                        ;
                        case 5: { //giaDV
                            try {
                                flagSoNguyen[row.getRowNum() - 1] = true;
                                listDV.get(row.getRowNum() - 1).setGiaDV((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listDV.get(row.getRowNum() - 1).setGiaDV(-1);
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
                DichVuDTO temp = listDV.get(row.getRowNum() - 1);
                if (temp.getMaDV().equals("") && temp.getTenDV().equals("") && temp.getHinhAnh().equals("") && temp.getLoaiDV().equals("")) {
                    flagSoNguyen[row.getRowNum() - 1] = false;
                } else if (!flagSoNguyen[row.getRowNum() - 1]) { //loi so nguyen giaDV
                    JOptionPane.showMessageDialog(this, "row %d: ".formatted(row.getRowNum())
                            + "\nGiá dịch vụ phải là số nguyên");
                }
                
            
            }
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                if (flagSoNguyen[i]) { //neu cac gia tri nguyen thoa man thi validate
                    int flag = validateNVDTO(listDV.get(i), i + 1); //neu validate=0 k them Pach hang, validate=1 them Pach hang, validate=2 sua Pach hang
                    if (flag == 1) {
                        listDV.get(i).setXuLy(0);
                        DichVuBUS.insertDV(listDV.get(i));
                    } else if (flag == 2) {
                        DichVuBUS.updateDV(listDV.get(i));
                    }
                }
            }
            ArrayList<DichVuDTO> tmp = DichVuBUS.getListDV();
            tbDV.renderTB();
            workbook.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int validateNVDTO(DichVuDTO x, int row) {
        String regexTenDV = jdialog.regexTenNV;
        //kiem tra tenNV
        if (!patternTenNV(x.getTenDV(), regexTenDV)) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "TenDV không hợp lệ, chỉ gồm chữ và khoảng trắng");
            return 0;
        }
        //kiem tra hinhDichVu
        if (x.getHinhAnh().equals("")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập hinhDichVu");
            return 0;
        }
        String path =  x.getHinhAnh();
        Path filePath = Paths.get(path);
        // Kiểm tra xem đường dẫn có tồn tại hay không
        if (!filePath.toFile().exists()) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Đường dẫn không tồn tại");
            return 0;
        }
        // Kiểm tra xem đường dẫn có phải là một file không
        if (!filePath.toFile().isFile()) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Đường dẫn không phải là một file");
            return 0;
        }
        //kiem tra xem co phai File hinh k
        File f = new File(path);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        //type tra ve gia tri image de so sanh
        if (!type.equals("image")) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Đường dẫn không phải là một file hình ảnh");
            return 0;
        }

        //kiem tra loaiDV
        String convertDV = null;

        if (x.getLoaiDV().equalsIgnoreCase("Thức ăn đồ uống")) {
            convertDV = "TD";
        } else if (x.getLoaiDV().equalsIgnoreCase("Ăn uống")) {
            convertDV = "AU";
        } else if (x.getLoaiDV().equalsIgnoreCase("Chăm sóc sắc đẹp")) {
            convertDV = "SD";
        } else if (x.getLoaiDV().equalsIgnoreCase("Tổ chức tiệc")) {
            convertDV = "TT";
        } else if (x.getLoaiDV().equalsIgnoreCase("Giải trí")) {
            convertDV = "GT";
        } else {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập LoaiDV hợp lệ: Thức ăn đồ uống, Ăn uống, Chăm sóc sắc đẹp, Tổ chức tiệc  hoặc Giải trí");
            return 0;
        }
        //keim tra giaDV
        if (x.getGiaDV() < 1000) {
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "giaDV >= 1000");
            return 0;
        }
        //kiem tra maDV
        DichVuDTO pNTemp = DichVuBUS.searchDV(x.getMaDV());
        if (pNTemp.getMaDV() != null) { //ton tai maDV
            int result = JOptionPane.showConfirmDialog(this, "Mã DV " + x.getMaDV() + " đã tồn tại, bạn có muốn cập nhật thông tin DV", "Thông báo update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                return 2;
            } else {
                return 0;
            }
        }
        int result = JOptionPane.showConfirmDialog(this, "row %d: \n".formatted(row)
                + "Mã DV sẽ tự khởi tạo \n"
                + "Tên DV: %s \n".formatted(x.getTenDV())
                + "Hình DV: %s \n".formatted(x.getHinhAnh())
                + "Loại DV: %s \n".formatted(x.getLoaiDV())
                + "Giá DV: %d \n".formatted(x.getGiaDV()),
                "Thêm DV?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return 0;
        }

        //lay stt, tang len 1
        String stt;
        int newIndex = DichVuBUS.getCountTI() + 1;
        stt = "";
        stt += String.valueOf(newIndex);
        while (stt.length() < 4) {
            stt = "0" + stt;
        }
        //gan gia tri cho ma PN
        x.setMaDV("DV" + convertDV + stt);
        return 1;
    }

    public void actionExportFile() {
        String path = null;
        //tao chuoi header
        String[] txtHeader = new String[]{"STT", "Mã dịch vụ", "Tên dịch vụ", "Hình dịch vụ", "Loại dịch vụ", "Giá dịch vụ"};
        //lay du lieu tu bang
        ArrayList<DichVuDTO> listDV= DichVuBUS.getListDV();
        int rowCount=listDV.size();
//        int rowCount = tbDV.getModel().getRowCount();
        int columnCount = txtHeader.length;
        String[][] data = new String[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                switch(j){
                    case 0: data[i][j]=String.valueOf(i+1);
                    break;
                    case 1: data[i][j]=listDV.get(i).getMaDV();
                    break;
                    case 2: data[i][j]=listDV.get(i).getTenDV();
                    break;
                    case 3: data[i][j]=listDV.get(i).getHinhAnh();
                    break;
                    case 4: data[i][j]=listDV.get(i).getLoaiDV();
                    break;
                    case 5: data[i][j]=String.valueOf(listDV.get(i).getGiaDV());
                    break;
                }
//                data[i][j] = tbDV.getModel().getValueAt(i, j).toString();
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
                    if (j == 0 || j == 5) { //cac cot stt, giaDV thi la int
                        dataCell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        if(j==0)
                            dataCell.setCellValue(Integer.parseInt(data[i - 1][j]));
                        else if(j==5)
                            dataCell.setCellValue(Integer.parseInt(data[i - 1][j].replaceAll(",", "").replaceAll(" VNĐ", "")));
                        continue;
                    }
                    else{
                        dataCell.setCellType(Cell.CELL_TYPE_STRING);
                        dataCell.setCellValue(data[i - 1][j]); //chay tu i=1 -> i-1
                    }
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
            this.LightDark = 0;
            formInput.lightDark(this.LightDark);
            pnTop.setBackground(Color.white);
            pnMaDV.setBackground(Color.white);
            pnTenDV.setBackground(Color.white);
            pnGiaDV.setBackground(Color.white);
            pnLoaiDV.setBackground(Color.white);
            pnContentInput.setBackground(Color.white);
            btnAdd.setBackground(Color.decode("#ebf2fc"));
            btnImportFile.setBackground(Color.decode("#ebf2fc"));
            btnExportFile.setBackground(Color.decode("#ebf2fc"));
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
            scpDV.setVerticalScrollBar(scrB);
            scpDV.setBackground(Color.white);
            scpDV.getViewport().setBackground(Color.white);
            tbDV.getTableHeader().setBackground(Color.decode("#dee9fc"));
            tbDV.getTableHeader().setForeground(Color.black);
            formInput.lightDark(LightDark);
            btnReset.setBackground(Color.decode("#ebf2fc"));
            btnSearch.setBackground(Color.decode("#ebf2fc"));
            pnButton.setBackground(Color.white);
            lbContentLeft.setForeground(Color.black);
            lbGiaDV.setForeground(Color.black);
            lbLoaiDV.setForeground(Color.black);
            lbMaDV.setForeground(Color.black);
            lbTenDV.setForeground(Color.black);
            lbTopDetail.setForeground(Color.black);
            lbTopTitle.setForeground(Color.black);
            txtMaDV.setBackground(Color.decode("#FFFFFF"));
            txtTenDV.setBackground(Color.decode("#FFFFFF"));
            txtMaDV.setForeground(Color.black);
            txtTenDV.setForeground(Color.black);
            cbGiaDV.setForeground(Color.black);
            cbLoaiDV.setForeground(Color.black);
        } else {
            this.LightDark = 1;
            Color black = Color.decode("#333333");
            formInput.lightDark(this.LightDark);
            pnTop.setBackground(black);
            pnMaDV.setBackground(black);
            pnTenDV.setBackground(black);
            pnGiaDV.setBackground(black);
            pnLoaiDV.setBackground(black);
            pnContentInput.setBackground(black);
            btnAdd.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            pnTopHeader.setBackground(black);
            pnTopButton.setBackground(black);
            setBackground(black);
            txtMaDV.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_7));
            txtTenDV.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_7));
            cbGiaDV.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_0));
            cbLoaiDV.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, bdEmpty0_7_0_0));
            pnContent.setBackground(black);
            pnContentLeft.setBackground(black);
            pnContentCenter.setBackground(black);
            scpDV.setVerticalScrollBar(new ScrollBar(Color.decode("#202020"), black));
            scpDV.getViewport().setBackground(black);
            scpDV.setBackground(black);
            tbDV.getTableHeader().setBackground(Color.decode("#202020"));
            tbDV.getTableHeader().setForeground(Color.white);
            formInput.lightDark(LightDark);
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            pnButton.setBackground(black);
            lbContentLeft.setForeground(Color.white);
            lbGiaDV.setForeground(Color.white);
            lbLoaiDV.setForeground(Color.white);
            lbMaDV.setForeground(Color.white);
            lbTenDV.setForeground(Color.white);
            lbTopDetail.setForeground(Color.white);
            lbTopTitle.setForeground(Color.white);
            txtMaDV.setBackground(Color.decode("#474747"));
            txtTenDV.setBackground(Color.decode("#474747"));
            cbGiaDV.setBackground(Color.decode("#474747"));
            cbLoaiDV.setBackground(Color.decode("#474747"));
            txtMaDV.setForeground(Color.white);
            txtTenDV.setForeground(Color.white);
            cbGiaDV.setForeground(Color.white);
            cbLoaiDV.setForeground(Color.white);
        }
    }

    public void actionShowContentRight() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formInput.setVisible(true);
                tbDV.renderTB();
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
