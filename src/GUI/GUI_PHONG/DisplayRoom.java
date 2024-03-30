package GUI.GUI_PHONG;

import BUS.PhongBUS;
import DTO.PhongDTO;
import GUI.GUI_NHANVIEN.jdialog;
import static GUI.GUI_NHANVIEN.jdialog.patternTenNV;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

public class DisplayRoom extends JPanel {

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
    JLabel lbTopHeaderLeftTop = new JLabel("Quản lý phòng");
    JLabel lbTopHeaderLeftBottom = new JLabel("Bấm vào hàng của bảng danh sách phòng để chỉnh sửa");
    JButton btnAdd = new JButton("Thêm phòng");
    JButton btnImportFile = new JButton("Nhập tệp");
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

    LineBorder lineCB = new LineBorder(Color.white);
    ArrayList<JPanel> listPN = new ArrayList<>();
    JPanel pnTopCenter = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentCenterTop = new JPanel();
    JLabel lbContentCentertop = new JLabel("Danh sách phòng khách sạn");
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    MatteBorder matteBorderCBDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
    MatteBorder borderTxt = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    MatteBorder borderTxtDark = new MatteBorder(2, 2, 2, 2, Color.decode("#919191"));
    EmptyBorder emptyBorderTxt = new EmptyBorder(0, 7, 0, 7);
    EmptyBorder emptyBorderCB = new EmptyBorder(0, 7, 0, 0);
    JScrollPane scp = new JScrollPane();
    TablePhong tbP = new TablePhong();

    public DisplayRoom() {
        initComponents();
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
        pnTopHeaderRight.add(btnAdd);

        btnReset.setFont(sgUI13b);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);

        btnSearch.setFont(sgUI13b);
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);

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

        // edit content
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
        txtTenP.setFont(sgUI13);
        cbChiTietLoaiP.setFont(sgUI13);
        cbGiaP.setFont(sgUI13);
        cbTTP.setFont(sgUI13);
        cbHTP.setFont(sgUI13);
        cbLoaiP.setFont(sgUI13);

        String chiTietLoaiP[] = {"Chi tiết loại phòng", "Phòng đơn", "Phòng đôi", "Phòng gia đình"};
        String loaiP[] = {"Loại phòng", "VIP", "Thường"};
        String tTP[] = {"Trạng thái phòng", "Trống", "Đang được thuê", "Chưa dọn phòng", "Chưa có tiện ích"};
        String hTP[] = {"Hiện trạng", "Phòng mới", "Phòng cũ"};
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
        scp.setViewportView(tbP);
        scp.setViewportBorder(null);
        tbP.renderTB();

        tbP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tbP.getSelectedRowCount() > 0) {
                    tbP.setSelectionBackground(Color.decode("#F5F5F5"));
                    new FormChiTietPhong(1, tbP.getValueAt(tbP.getSelectedRow(), tbP.getColumnModel().getColumnIndex("Mã phòng")).toString(), DisplayRoom.this);
                }
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaP.getText().trim().length() == 0
                        && txtTenP.getText().trim().length() == 0
                        && cbLoaiP.getSelectedIndex() == 0
                        && cbChiTietLoaiP.getSelectedIndex() == 0
                        && cbGiaP.getSelectedIndex() == 0
                        && cbHTP.getSelectedIndex() == 0
                        && cbTTP.getSelectedIndex() == 0) {
                    new ThongBaoDialog("Vui lòng nhập thông tin muốn tìm", 1);
                    tbP.renderTB();
                } else {
                    ArrayList<PhongDTO> listAll = PhongBUS.getListP();
                    ArrayList<PhongDTO> listTmp = new ArrayList<>();
                    if (txtMaP.getText().trim().length() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getMaP().toUpperCase().contains(txtMaP.getText().trim().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (txtTenP.getText().trim().length() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getTenP().toUpperCase().contains(txtTenP.getText().trim().toUpperCase())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbLoaiP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getLoaiP().equals(cbLoaiP.getSelectedItem().toString())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbChiTietLoaiP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getChiTietLoaiP().equals(cbChiTietLoaiP.getSelectedItem().toString())) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }

                    if (cbTTP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getTinhTrang() == cbTTP.getSelectedIndex() - 1) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbHTP.getSelectedIndex() != 0) {
                        for (PhongDTO x : listAll) {
                            if (x.getHienTrang() == cbHTP.getSelectedIndex() - 1) {
                                listTmp.add(x);
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }
                    if (cbGiaP.getSelectedIndex() != 0) {
                        if (cbGiaP.getSelectedIndex() == 1) {
                            for (PhongDTO x : listAll) {
                                if (x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(1).toString().split("Dưới ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else if (cbGiaP.getSelectedIndex() == 5) {
                            for (PhongDTO x : listAll) {
                                if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(5).toString().split("Trên ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        } else {
                            for (PhongDTO x : listAll) {
                                if (x.getGiaP() >= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[0])
                                        && x.getGiaP() <= Integer.parseInt(cbGiaP.getItemAt(cbGiaP.getSelectedIndex()).toString().split("Từ ")[1].split(" đến ")[1])) {
                                    listTmp.add(x);
                                }
                            }
                        }
                        listAll.clear();
                        for (PhongDTO x : listTmp) {
                            listAll.add(x);
                        }
                        listTmp.clear();
                    }

                    if (listAll.isEmpty()) {
                        new ThongBaoDialog("Không tìm thấy phòng phù hợp", 1);
                        tbP.renderTB();
                        txtMaP.setText("");
                        txtTenP.setText("");
                        cbLoaiP.setSelectedIndex(0);
                        cbChiTietLoaiP.setSelectedIndex(0);
                        cbGiaP.setSelectedIndex(0);
                        cbHTP.setSelectedIndex(0);
                        cbTTP.setSelectedIndex(0);
                    } else {
                        tbP.renderTB(listAll);
                    }
                }
            }
        });

        actionReset();
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

    public void actionAdd() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPhongNew(DisplayRoom.this);
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
    
    public void actionImportFile(){
        try {
            JFileChooser chooser=new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int cancel=chooser.showSaveDialog(null);

            if(cancel == JFileChooser.CANCEL_OPTION ){
                return;
            }
            String path=chooser.getSelectedFile().getPath();
            //String filename=chooser.getSelectedFile().getName();
            FileInputStream file = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            
            ArrayList<PhongDTO> listP = new ArrayList<>();
            boolean[] flagSoNguyen=new boolean[sheet.getLastRowNum()]; //flag de kiem tra xem cac gia tri giaP va so ng, tinhTrang va hienTrang co phai la so nguyen Pong
            for (Row row : sheet) {
                if (row.getRowNum()==0){ //bo row 0, cac row Pac -1
                    continue;
                }
                for (Cell cell : row) {
                    listP.add(new PhongDTO());
                    switch(cell.getColumnIndex()){
                        case 1: { //maP
                            listP.get(row.getRowNum()-1).setMaP(cell.getStringCellValue());
                        };
                        break;
                        case 2: { //tenP
                            listP.get(row.getRowNum()-1).setTenP(cell.getStringCellValue());
                        };
                        break;
                        case 3: { //LoaiP
                            listP.get(row.getRowNum()-1).setLoaiP(cell.getStringCellValue());                            
                        };
                        case 4: { //ctLoaiP
                            listP.get(row.getRowNum()-1).setChiTietLoaiP(cell.getStringCellValue());       
                        };
                        break;
                        case 5: {//giaP
                            try {
                                flagSoNguyen[row.getRowNum()-1]=true;
                                listP.get(row.getRowNum()-1).setGiaP((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listP.get(row.getRowNum()-1).setGiaP(-1);
                                flagSoNguyen[row.getRowNum()-1]=false;
                            }                     
                        };
                        break;
                        case 6: { //tinhTrang
                            try {
                                flagSoNguyen[row.getRowNum()-1]=true;
                                listP.get(row.getRowNum()-1).setTinhTrang((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listP.get(row.getRowNum()-1).setTinhTrang(-1);
                                flagSoNguyen[row.getRowNum()-1]=false;
                            }                                                 
                        };
                        break;
                        case 7: { //hienTrang
                            try {
                                flagSoNguyen[row.getRowNum()-1]=true;
                                listP.get(row.getRowNum()-1).setHienTrang((int) cell.getNumericCellValue());
                            } catch (IllegalStateException e) {
                                listP.get(row.getRowNum()-1).setHienTrang(-1);
                                flagSoNguyen[row.getRowNum()-1]=false;
                            }                        
                        };
                        break;
                        default: break;
                    }
                }
                //neu row trong
                PhongDTO temp=listP.get(row.getRowNum()-1);
                if(temp.getMaP().equals("")  && temp.getTenP().equals("") && temp.getLoaiP().equals("") && temp.getChiTietLoaiP().equals("")  ){
                    flagSoNguyen[row.getRowNum()-1]=false;
                }
                else if(!flagSoNguyen[row.getRowNum()-1]){ //loi so nguyen luong va ngay phep
                                JOptionPane.showMessageDialog(pnContent, "row %d: ".formatted(row.getRowNum())
                                        + "\nGiá phòng, tình trạng, hiện trạng phải là số nguyên");
                }
            }
            
            for(int i=0;i<sheet.getLastRowNum();i++){
                if(flagSoNguyen[i]){
                    int flag=validateNVDTO(listP.get(i),i+1); //neu validate=0 k them Pach hang, validate=1 them Pach hang, validate=2 sua Pach hang
                    if(flag==1){ 
                        listP.get(i).setXuLy(0);
                        PhongBUS.insertP(listP.get(i));
                    }
                    else if(flag==2){
                        PhongBUS.updateTT(listP.get(i).getMaP(),(listP.get(i).getTinhTrang()));
                    }
                }
                
            }
            ArrayList<PhongDTO> tmp=PhongBUS.getListP();
            tbP.renderTB();
            workbook.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private int validateNVDTO(PhongDTO x,int row){
        String regexTenNV=jdialog.regexTenNV;
        //kiem tra tenP
        if(!patternTenNV(x.getTenP(), regexTenNV)){
            JOptionPane.showMessageDialog(this,"row %d: \n".formatted(row)
                    + "Tên phòng không hợp lệ, chỉ gồm chữ và khoảng trắng");
            return 0;
        }
        //kiem tra loaiP
        if(x.getLoaiP().equals("")){
            JOptionPane.showMessageDialog(this,"row %d: \n".formatted(row)
                    + "Hãy nhập LoaiP");
            return 0;
        }
        else if(!x.getLoaiP().equalsIgnoreCase("vip") && !x.getLoaiP().equalsIgnoreCase("thường")){
          JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập LoaiP hợp lệ, vip hoặc thường");
            return 0;
        }
       //keim tra giaP va tinhTrang, hienTrang
       //la 1 so nguyen kiem tra ở trên
       if(x.getGiaP()<1000 || x.getTinhTrang()<0 || x.getTinhTrang()>2 || x.getHienTrang()<0 || x.getHienTrang()>1 ){
           JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                   + "Giá phòng>=1000; 0<=Tình trạng<=2; 0<=Hiện trạng<=1 ");
           return 0;
       } 
       //kiemTra chiTietLoaiP
       if(!x.getChiTietLoaiP().equalsIgnoreCase("Phòng đơn") && !x.getChiTietLoaiP().equalsIgnoreCase("Phòng đôi") && !x.getChiTietLoaiP().equalsIgnoreCase("Phòng gia đình")){
            JOptionPane.showMessageDialog(this, "row %d: \n".formatted(row)
                    + "Hãy nhập LoaiP hợp lệ: Phòng đơn, Phòng đôi hoặc Phòng gia đình");
            return 0;
        }
        //kiem tra maP
        if(PhongBUS.checkID(x.getMaP())){ //ton tai ma P
            int result=JOptionPane.showConfirmDialog(pnContent,"Mã phòng " + x.getMaP()+ " đã tồn tại, bạn có muốn cập nhật thông tin phòng","Thông báo update",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result==JOptionPane.YES_OPTION){
                return 2;
            }
            else{
                return 0;
            }
        }
        int result=JOptionPane.showConfirmDialog(this, "row %d: \n".formatted(row)
                + "Mã phòng sẽ tự khởi tạo \n"
                        + "Tên phòng: %s \n".formatted(x.getTenP())
                        + "Giá phòng: %d \n".formatted(x.getGiaP())
                        + "Loại phòng: %s \n".formatted(x.getLoaiP())
                        + "Giá phòng: %d \n".formatted(x.getGiaP())
                        + "Chi tiết loại phòng: %s \n".formatted(x.getChiTietLoaiP())
                        + "Tình trạng: %d \n".formatted(x.getTinhTrang())
                        + "Hiện trạng: %d \n".formatted(x.getHienTrang()),
                "Thêm phòng?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result==JOptionPane.NO_OPTION){
            return 0;
        }
        
        DateFormat df=new SimpleDateFormat("ddMMyyyy");
        Date dateThem=new Date();
        String ngayThem=df.format(dateThem);
        //df=dd-MM-yyyy; dfm=ddMMyyyy
        ngayThem=ngayThem.substring(0,4) + ngayThem.substring(6);
        //lay stt cua phòng, tang len 1
        String stt;
        int newIndex=PhongBUS.getCountPhong();
        stt="";
        stt+=String.valueOf(newIndex);
        while(stt.length()<3){
            stt="0"+stt;
        }
        //gan gia tri cho ma nv
        x.setMaP("P"+ngayThem+stt);
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
    
    public void actionExportFile(){
        String path = null;
        //tao chuoi header
        String[] txtHeader=new String[]{"STT","Mã phòng","Tên phòng","Loại Phòng","Chi tiết loại phòng","Giá phòng","Tình trạng","Hiện trạng"};
        //lay du lieu tu bang
        int rowCount=tbP.getModel().getRowCount();
        int columnCount=txtHeader.length;
        String[][] data=new String[rowCount][columnCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<columnCount;j++){
                data[i][j]=tbP.getModel().getValueAt(i, j).toString();
            }
        }
        
        try {
        JFileChooser chooser=new JFileChooser(System.getProperty("user.dir"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int cancel=chooser.showSaveDialog(null);
        if(cancel == JFileChooser.CANCEL_OPTION){
            return;
        }
        
        path=chooser.getSelectedFile().getPath();
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
        for(int i=0;i<columnCount;i++){
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
        for(int i=1;i<=rowCount;i++){ //tu 1->rowCount
            Row temp = sheet.createRow(i);
            for(int j=0;j<columnCount;j++){
                Cell dataCell =  temp.createCell(j);
                dataCell.setCellStyle(dataStyle);
                if(j==0 || j==5 || j==6 || j==7){ //cac cot stt, tinhTrang,hienTrang thi la int
                    dataCell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    int convert=-1; //convert tinhTrang va hienTrang ra NUM
                    if(j==0){
                        convert=Integer.parseInt(data[i-1][j]);
                    }
                    else if(j==5){ //giaP
                        convert=Integer.parseInt(data[i-1][j].replaceAll(",","").replaceAll(" VNĐ", ""));
                    }
                    else if(data[i-1][j].contains("Trống") || data[i-1][j].contains("Mới")){
                        convert=0;
                    }
                    else if(data[i-1][j].contains("Đang") || data[i-1][j].contains("Cũ")){
                        convert=1;
                    }
                    else{
                        convert=2;
                    }
                    dataCell.setCellValue(convert);
                    continue;
                }
                dataCell.setCellType(Cell.CELL_TYPE_STRING);
                dataCell.setCellValue(data[i-1][j]); //chay tu i=1 -> i-1
            }
        }
        //auto resize column
        for(int i=0;i<columnCount;i++){
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
        try  
        {  
            //constructor of file class having file as argument  
            File file = new File(path);   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
                System.out.println("not supported");  
                return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         //checks file exists or not  
                desktop.open(file);              //opens the specified file  
            }  
        catch(Exception e)  
        {  
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

    public void actionReset() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbChiTietLoaiP.setSelectedIndex(0);
                cbGiaP.setSelectedIndex(0);
                cbTTP.setSelectedIndex(0);
                cbHTP.setSelectedIndex(0);
                cbLoaiP.setSelectedIndex(0);
                txtMaP.setText("");
                txtTenP.setText("");
                tbP.renderTB();
            }
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            this.LightDark = 0;
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
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
            scp.getViewport().setBackground(Color.white);
            scp.setBackground(Color.white);
            pnContentCenterTop.setBackground(Color.white);
            tbP.getTableHeader().setBackground(Color.decode("#dee9fc"));
            lbTopHeaderLeftBottom.setForeground(Color.black);
            lbTopHeaderLeftTop.setForeground(Color.black);
            lbMaP.setForeground(Color.black);
            lbTenP.setForeground(Color.black);
            lbLoaiP.setForeground(Color.black);
            lbChiTietLoaiP.setForeground(Color.black);
            lbGiaP.setForeground(Color.black);
            lbTTP.setForeground(Color.black);
            lbHTP.setForeground(Color.black);
            lbContentCentertop.setForeground(Color.black);
            cbGiaP.setForeground(Color.black);
            cbLoaiP.setForeground(Color.black);
            cbChiTietLoaiP.setForeground(Color.black);
            cbTTP.setForeground(Color.black);
            cbHTP.setForeground(Color.black);
            txtMaP.setForeground(Color.black);
            txtTenP.setForeground(Color.black);
            txtMaP.setBackground(Color.decode("#FFFFFF"));
            txtTenP.setBackground(Color.decode("#FFFFFF"));
            tbP.getTableHeader().setForeground(Color.black);
        } else {
            this.LightDark = 1;
            lbTopHeaderLeftBottom.setForeground(Color.white);
            lbTopHeaderLeftTop.setForeground(Color.white);
            lbContentCentertop.setForeground(Color.white);
            Color black = Color.decode("#333333");
            setBackground(black);
            pnTop.setBackground(black);
            pnTopHeader.setBackground(black);
            pnTopCenter.setBackground(black);
            pnTopHeaderLeft.setBackground(black);
            pnTopHeaderRight.setBackground(black);
            pnContent.setBackground(black);
            pnTopHeader.setBorder(new MatteBorder(5, 5, 5, 5, black));
            btnAdd.setBackground(Color.decode("#F0F0F0"));
            btnImportFile.setBackground(Color.decode("#F0F0F0"));
            btnExportFile.setBackground(Color.decode("#F0F0F0"));
            btnReset.setBackground(Color.decode("#F0F0F0"));
            btnSearch.setBackground(Color.decode("#F0F0F0"));
            for (JPanel x : listPN) {
                x.setBackground(black);
            }
            lbMaP.setForeground(Color.white);
            lbTenP.setForeground(Color.white);
            lbLoaiP.setForeground(Color.white);
            lbChiTietLoaiP.setForeground(Color.white);
            lbGiaP.setForeground(Color.white);
            lbTTP.setForeground(Color.white);
            lbHTP.setForeground(Color.white);
            cbChiTietLoaiP.setBorder(matteBorderCBDark);
            cbHTP.setBorder(matteBorderCBDark);
            cbTTP.setBorder(matteBorderCBDark);
            cbGiaP.setBorder(matteBorderCBDark);
            cbLoaiP.setBorder(matteBorderCBDark);
            cbGiaP.setBackground(Color.decode("#474747"));
            cbLoaiP.setBackground(Color.decode("#474747"));
            cbChiTietLoaiP.setBackground(Color.decode("#474747"));
            cbTTP.setBackground(Color.decode("#474747"));
            cbHTP.setBackground(Color.decode("#474747"));
            txtMaP.setBackground(Color.decode("#474747"));
            txtTenP.setBackground(Color.decode("#474747"));
            txtMaP.setForeground(Color.white);
            txtTenP.setForeground(Color.white);
            cbGiaP.setForeground(Color.white);
            cbLoaiP.setForeground(Color.white);
            cbChiTietLoaiP.setForeground(Color.white);
            cbTTP.setForeground(Color.white);
            cbHTP.setForeground(Color.white);
            txtMaP.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            txtTenP.setBorder(BorderFactory.createCompoundBorder(borderTxtDark, new EmptyBorder(0, 3, 0, 3)));
            scp.setVerticalScrollBar(new ScrollBar(Color.decode("#202020"), black));
            scp.getViewport().setBackground(black);
            scp.setBackground(black);
            pnContentCenterTop.setBackground(black);
            tbP.getTableHeader().setBackground(Color.decode("#202020"));
            tbP.getTableHeader().setForeground(Color.white);
        }
    }

    public TablePhong getTablePhong() {
        return tbP;
    }
}
