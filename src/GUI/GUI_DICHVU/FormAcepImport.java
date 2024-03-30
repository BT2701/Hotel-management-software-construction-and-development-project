package GUI.GUI_DICHVU;

import BUS.ChiTietNhapBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietNhapDTO;
import DTO.PhieuNhapDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import GUI.mainGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class FormAcepImport extends JDialog {

    JPanel pnContainer = new JPanel();
    JPanel pnTop = new JPanel();
    JPanel pnContent = new JPanel();
    JPanel pnBottom = new JPanel();
    JPanel pnMaPN = new JPanel();
    JPanel pnTenNV = new JPanel();
    JPanel pnNgayLapPhieu = new JPanel();
    JPanel pnTinhTrang = new JPanel();

    JLabel lbMaPN = new JLabel("Mã phiếu nhập");
    JLabel lbTenNV = new JLabel("Tên nhân viên");
    JLabel lbNgayLapPhieu = new JLabel("Ngày lập phiếu");
    JLabel lbTinhTrang = new JLabel("Tình trạng phiếu");

    JLabel lbMaPNTXT = new JLabel();
    JLabel lbTenNVTXT = new JLabel();
    JLabel lbNgayLapPhieuTXT = new JLabel();
    JLabel lbTinhTrangTXT = new JLabel();

    JScrollPane scp = new JScrollPane();
    JTable tb = new JTable() {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    JPanel pnButton = new JPanel();
    JButton btnAcept = new JButton("Xác nhận");
    JButton btnExit = new JButton("Thoát");

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JLabel lbContent = new JLabel("Danh sách dịch vụ nhập");

    ArrayList<ItemServiceAdd> listItem;
    DisplayImportAdd displayImportAdd;

    public FormAcepImport(String maPN, String tenNV, String ngayNhap, String tinhTrang, ArrayList<ItemServiceAdd> listItem, DisplayImportAdd displayImportAdd) {
        this.displayImportAdd = displayImportAdd;
        this.listItem = listItem;
        initComponents(maPN, tenNV, ngayNhap, tinhTrang);
    }

    public void initComponents(String maPN, String tenNV, String ngayNhap, String tinhTrang) {
        setTitle("Thông tin phiếu nhập");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setModal(true);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        add(pnContainer, BorderLayout.CENTER);
        pnContainer.setBorder(new EmptyBorder(15, 15, 15, 15));

        pnContainer.setLayout(new BorderLayout(15, 15));
        pnContainer.add(pnTop, BorderLayout.NORTH);
        pnContainer.add(pnContent, BorderLayout.CENTER);
        pnContainer.add(pnBottom, BorderLayout.SOUTH);

        pnTop.setLayout(new GridLayout(2, 2, 5, 5));
        pnTop.add(pnMaPN);
        pnTop.add(pnTenNV);
        pnTop.add(pnNgayLapPhieu);
        pnTop.add(pnTinhTrang);

        setLayout(pnMaPN, lbMaPN, lbMaPNTXT);
        setLayout(pnTenNV, lbTenNV, lbTenNVTXT);
        setLayout(pnNgayLapPhieu, lbNgayLapPhieu, lbNgayLapPhieuTXT);
        setLayout(pnTinhTrang, lbTinhTrang, lbTinhTrangTXT);

        lbMaPNTXT.setText(maPN);
        lbTenNVTXT.setText(tenNV);
        lbNgayLapPhieuTXT.setText(ngayNhap);
        lbTinhTrangTXT.setText(tinhTrang);

        lbMaPN.setFont(sgUI13b);
        lbTenNV.setFont(sgUI13b);
        lbNgayLapPhieu.setFont(sgUI13b);
        lbTinhTrang.setFont(sgUI13b);

        lbMaPNTXT.setFont(sgUI13);
        lbTenNVTXT.setFont(sgUI13);
        lbNgayLapPhieuTXT.setFont(sgUI13);
        lbTinhTrangTXT.setFont(sgUI13);

        pnTop.setBorder(new EmptyBorder(15, 15, 15, 15));
        pnContent.setBorder(new EmptyBorder(15, 15, 15, 15));

        pnContent.setLayout(new BorderLayout(10, 10));
        pnContent.add(lbContent, BorderLayout.NORTH);
        pnContent.add(scp, BorderLayout.CENTER);
        pnBottom.setLayout(new BorderLayout());
        pnBottom.add(pnButton, BorderLayout.EAST);
        pnButton.setLayout(new GridLayout(1, 2, 5, 5));
        pnButton.add(btnAcept);
        pnButton.add(btnExit);
        scp.setViewportView(tb);
        renderTB();

        lbContent.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 2, 0, Color.decode("#eeeeee")), new EmptyBorder(0, 0, 7, 0)));
        lbContent.setFont(sgUI13b);

        setBackground(Color.decode("#FAFAFA"));
        pnContainer.setBackground(Color.decode("#FAFAFA"));
        pnTop.setBackground(Color.white);
        pnContent.setBackground(Color.white);
        pnBottom.setBackground(Color.decode("#FAFAFA"));
        pnMaPN.setBackground(Color.white);
        pnTenNV.setBackground(Color.white);
        pnNgayLapPhieu.setBackground(Color.white);
        pnTinhTrang.setBackground(Color.white);
        lbTenNVTXT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#eeeeee")), new EmptyBorder(7, 7, 7, 7)));
        lbMaPNTXT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#eeeeee")), new EmptyBorder(7, 7, 7, 7)));
        lbNgayLapPhieuTXT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#eeeeee")), new EmptyBorder(7, 7, 7, 7)));
        lbTinhTrangTXT.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#eeeeee")), new EmptyBorder(7, 7, 7, 7)));
        scp.setBackground(Color.white);
        scp.getViewport().setBackground(Color.white);
        scp.setBorder(BorderFactory.createEmptyBorder());
        scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
        tb.getTableHeader().setBackground(Color.decode("#ebf2fc"));
        btnAcept.setBackground(Color.decode("#99ff99"));
        btnExit.setBackground(Color.decode("#FDFDFD"));
        pnButton.setBackground(Color.decode("#FAFAFA"));

        btnAcept.setFont(sgUI13b);
        btnAcept.setFocusPainted(false);
        btnAcept.setBorderPainted(false);

        btnExit.setFont(sgUI13b);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.decode("#FF3333"));
                btnExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(Color.decode("#FDFDFD"));
                btnExit.setForeground(Color.black);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnAcept.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAcept.setBackground(Color.decode("#33ff33"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAcept.setBackground(Color.decode("#99ff99"));
            }
        });

        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Xác nhận nhập hàng", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    ExportFileExcelPhieuNhap export = new ExportFileExcelPhieuNhap();
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        String formatDateTime = now.format(formatter);
                        PhieuNhapDTO x = new PhieuNhapDTO();
                        x.setMaPN(maPN);
                        x.setMaNV(mainGUI.nv.getMaNV());
                        x.setNgayLapPhieu(formatDateTime);
                        x.setTinhTrangXuLy(0);
                        x.setXuLy(0);
                        String check = PhieuNhapBUS.insertPN(x);
                        if (check.equals("Thêm phiếu nhập mới thành công")) {
                            int count = 0;
                            for (ItemServiceAdd item : listItem) {
                                ChiTietNhapDTO tmp = new ChiTietNhapDTO();
                                tmp.setMaPN(maPN);
                                tmp.setMaDV(item.getMaDV());
                                tmp.setSoLuong(item.getSoLuong());
                                tmp.setGiaDVNhap(0);
                                count += ChiTietNhapBUS.insertCTN(tmp);
                            }
                            if (count == listItem.size()) {
                                String path = System.getProperty("user.dir") + "\\src\\GUI\\GUI_EXCEL\\" + maPN + ".xlsx";
                                export.ExportFileExcelPhieuNhap(path, maPN);
                                ThongBaoDialog tb = new ThongBaoDialog("Xuất file nhập hàng thành công", 2);
                                Desktop.getDesktop().open(new File(path));
                                displayImportAdd.Return();
                                dispose();
                            } else {
                                ThongBaoDialog tb = new ThongBaoDialog("Xuất file nhập hàng không thành công", 1);
                            }
                        } else {
                            ThongBaoDialog tb = new ThongBaoDialog("Tạo phiếu nhập hàng mới không thành công", 1);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Xuất file không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    public void setLayout(JPanel panel, JLabel label1, JLabel label2) {
        panel.setLayout(new GridLayout(2, 1));
        panel.add(label1);
        panel.add(label2);
    }

    public void renderTB() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn(" ");
        dtm.addColumn("Mã dịch vụ");
        dtm.addColumn("Tên dịch vụ");
        dtm.addColumn("Số lượng nhập");
        for (int i = 0; i < listItem.size(); i++) {
            Object data[] = {i + 1, listItem.get(i).getMaDV(), listItem.get(i).getTenDV(), listItem.get(i).getSoLuong()};
            dtm.addRow(data);
        }
        tb.setModel(dtm);
        // Sử dụng một renderer chung cho tất cả các cột
        tb.setDefaultRenderer(Object.class, new TableAceptDichVuCellRenderer());
        tb.setRowHeight(30);
        tb.setShowGrid(false);
        tb.setIntercellSpacing(new Dimension(0, 0));
        tb.getTableHeader().setPreferredSize(new Dimension(1, 30));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.getColumnModel().getColumn(0).setPreferredWidth(30);
        tb.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb.getColumnModel().getColumn(2).setPreferredWidth(250);
        tb.getColumnModel().getColumn(3).setPreferredWidth(100);
        tb.setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#EEEEEE")));
    }
}
