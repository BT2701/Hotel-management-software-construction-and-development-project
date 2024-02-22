package GUI.GUI_DICHVU;

import BUS.ChiTietNhapBUS;
import BUS.DichVuBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietNhapDTO;
import DTO.PhieuNhapDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import GUI.ThongBaoDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class FormDetailImportService extends JDialog {

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
    JButton btnDelete = new JButton("Xóa phiếu");

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JLabel lbContent = new JLabel("Danh sách dịch vụ nhập");
    ArrayList<ChiTietNhapDTO> list;

    DisplayContentListService displayContentListService;

    public FormDetailImportService(String maPN, DisplayContentListService displayContentListService) {
        list = ChiTietNhapBUS.getList(maPN);
        this.displayContentListService = displayContentListService;
        initComponents(maPN);
    }

    public void initComponents(String maPN) {
        PhieuNhapDTO pn = PhieuNhapBUS.searchPN(maPN);
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
        lbTenNVTXT.setText(NhanVienBUS.getTenNV(pn.getMaNV()));
        lbNgayLapPhieuTXT.setText(pn.getNgayLapPhieu());
        if (pn.getTinhTrangXuLy() == 0) {
            lbTinhTrangTXT.setText("Chưa xử lý");
        } else {
            lbTinhTrangTXT.setText("Đã xử lý");
        }

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
        pnButton.add(btnDelete);
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
        btnDelete.setBackground(Color.decode("#99ccff"));
        btnExit.setBackground(Color.decode("#FDFDFD"));
        pnButton.setBackground(Color.decode("#FAFAFA"));

        btnAcept.setFont(sgUI13b);
        btnAcept.setFocusPainted(false);
        btnAcept.setBorderPainted(false);

        btnDelete.setFont(sgUI13b);
        btnDelete.setFocusPainted(false);
        btnDelete.setBorderPainted(false);

        btnExit.setFont(sgUI13b);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phiếu nhập này", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    String check = PhieuNhapBUS.deletePN(maPN.trim());
                    if (check.equals("Xóa phiếu nhập thành công")) {
                        ThongBaoDialog tbd = new ThongBaoDialog("Xóa thành công phiếu nhập có mã: " + maPN.trim(), 2);
                        displayContentListService.Reset();
                        dispose();
                    } else {
                        ThongBaoDialog tbd = new ThongBaoDialog("Xóa không thành công phiếu nhập có mã: " + maPN.trim(), 2);
                    }
                }
            }
        });

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

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDelete.setBackground(Color.decode("#66ffff"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDelete.setBackground(Color.decode("#99ccff"));
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
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xác nhận phiếu nhập này là đã nhập","Thông báo",JOptionPane.YES_NO_OPTION);
                if(ans == JOptionPane.YES_OPTION) {
                    ImportFileExcelPhieuNhap importFile = new ImportFileExcelPhieuNhap();
                    String path = System.getProperty("user.dir") + "\\src\\GUI\\GUI_EXCEL\\" + maPN.trim() + ".xlsx";
                    try {
                        importFile.ImportFile(path, maPN.trim(),FormDetailImportService.this);
                    } catch (IOException ex) {
                    }
                }
            }       
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    displayContentListService.Reset();
                    dispose();
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                displayContentListService.Reset();
                dispose();
            }
        });

        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu pm = new JPopupMenu();
                    JMenuItem miS = new JMenuItem("Sửa");
                    JMenuItem miX = new JMenuItem("Xóa");
                    pm.add(miS);
                    pm.add(miX);
                    pm.show(tb, e.getX(), e.getY());
                    miS.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tb.getSelectedRow() != -1) {
                                String text = JOptionPane.showInputDialog(null, "Vui lòng nhập số lượng muốn thay đổi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                int num;
                                for (;;) {
                                    if (text == null) {
                                        break;
                                    }
                                    try {
                                        num = Integer.parseInt(text.trim());
                                        if (num > 0) {
                                            ChiTietNhapDTO x = new ChiTietNhapDTO();
                                            x.setMaPN(maPN);
                                            x.setMaDV(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã dịch vụ")).toString());
                                            x.setSoLuong(num);
                                            x.setGiaDVNhap(0);
                                            String check = ChiTietNhapBUS.updateCTN(x);
                                            if (check.equals("Sửa dịch vụ thành công")) {
                                                ExportFileExcelPhieuNhap export = new ExportFileExcelPhieuNhap();
                                                ThongBaoDialog tb = new ThongBaoDialog("Sửa dịch vụ thành công", 2);
                                                String path = System.getProperty("user.dir") + "\\src\\GUI\\GUI_EXCEL\\" + maPN.trim() + ".xlsx";
                                                export.ExportFileExcelPhieuNhap(path, maPN);
                                                list.clear();
                                                list = ChiTietNhapBUS.getList(maPN);
                                                renderTB();
                                            } else {
                                                ThongBaoDialog tb = new ThongBaoDialog("Sửa dịch vụ không thành công", 1);
                                            }
                                            break;
                                        }
                                        text = JOptionPane.showInputDialog(null, "Vui lòng nhập số lượng muốn thay đổi (Lớn hơn 0)", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    } catch (Exception ex) {
                                        text = JOptionPane.showInputDialog(null, "Vui lòng nhập số lượng muốn thay đổi (Là số nguyên)", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ cần sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                    miX.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tb.getSelectedRow() != -1) {
                                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dịch vụ này", "Thông báo", JOptionPane.YES_NO_OPTION);
                                if (ans == JOptionPane.YES_OPTION) {
                                    String check = ChiTietNhapBUS.deleteCTN(maPN.trim(), tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã dịch vụ")).toString());
                                    if (check.equals("Xóa dịch vụ thành công")) {
                                        ExportFileExcelPhieuNhap export = new ExportFileExcelPhieuNhap();
                                        ThongBaoDialog tb = new ThongBaoDialog("Xóa dịch vụ thành công", 2);
                                        String path = System.getProperty("user.dir") + "\\src\\GUI\\GUI_EXCEL\\" + maPN.trim() + ".xlsx";
                                        try {
                                            export.ExportFileExcelPhieuNhap(path, maPN);
                                        } catch (IOException ex) {
                                        }
                                        list.clear();
                                        list = ChiTietNhapBUS.getList(maPN);
                                        renderTB();
                                    } else {
                                        ThongBaoDialog tbd = new ThongBaoDialog("Xóa dịch vụ không thành công", 1);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
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

        for (int i = 0; i < list.size(); i++) {
            Object data[] = {i + 1, list.get(i).getMaDV(), DichVuBUS.getTenDV(list.get(i).getMaDV()), list.get(i).getSoLuong()};
            dtm.addRow(data);
        }
        tb.setModel(dtm);
        // Sử dụng một renderer chung cho tất cả các cột
        tb.setDefaultRenderer(Object.class, new TableAceptDichVuCellRendererForm2());
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
