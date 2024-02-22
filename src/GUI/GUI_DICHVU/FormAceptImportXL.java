package GUI.GUI_DICHVU;

import BUS.ChiTietNhapBUS;
import BUS.DichVuBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietNhapDTO;
import DTO.PhieuNhapDTO;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
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
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
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

public class FormAceptImportXL extends JDialog {

    private DecimalFormat dcf = new DecimalFormat("###,###");
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
    private JPanel pnThongTinTongQuat;
    private JLabel lbTXTTongSL, lbTXTTongTien, lbTongTien, lbTongSL;

    JScrollPane scp = new JScrollPane();
    JTable tb = new JTable() {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    ArrayList<ChiTietNhapDTO> list;
    JPanel pnButton = new JPanel();
    JButton btnExit = new JButton("Thoát");

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI15b = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    JLabel lbContent = new JLabel("Danh sách dịch vụ nhập");

    DisplayContentListService displayContentListService;

    public FormAceptImportXL(String maPN, DisplayContentListService displayContentListService) {
        this.displayContentListService = displayContentListService;
        list = ChiTietNhapBUS.getList(maPN);
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

        //pnThongTinTongQuat
        int tongSL = 100;	//chỗ này sau này sẽ lấy tổng số lượng trên table
        lbTXTTongSL = new JLabel("Tổng số lượng: ", JLabel.LEFT);
        lbTXTTongSL.setFont(sgUI15b);

        lbTongSL = new JLabel(tongSL + "", JLabel.LEFT);
        lbTongSL.setFont(sgUI15b);

        int tongTien = 1000; //chỗ này sau này sẽ lấy tổng tiền của table
        lbTXTTongTien = new JLabel("Tổng tiền: ", JLabel.LEFT);
        lbTXTTongTien.setFont(sgUI15b);

        lbTongTien = new JLabel(dcf.format(tongTien) + "VND", JLabel.LEFT);
        lbTongTien.setFont(sgUI15b);
        lbTongTien.setForeground(Color.red);

        pnThongTinTongQuat = new JPanel();
        pnThongTinTongQuat.setLayout(new GridLayout(2, 4, 5, 5));
        JPanel temp;
        pnThongTinTongQuat.add(lbTXTTongSL);
        pnThongTinTongQuat.add(lbTongSL);
        pnThongTinTongQuat.setBackground(Color.white);
        pnThongTinTongQuat.setBorder(new MatteBorder(1, 0, 1, 0, Color.black));
        for (int i = 0; i < 6; i++) {
            if (i == 2) {
                pnThongTinTongQuat.add(lbTXTTongTien);
            } else if (i == 3) {
                pnThongTinTongQuat.add(lbTongTien);
            } else {
                temp = new JPanel();
                temp.setBackground(Color.white);
                pnThongTinTongQuat.add(temp);
            }
        }
        //end pnThongTinTongQuat
        pnContent.setBorder(new EmptyBorder(15, 15, 15, 15));

        pnContent.setLayout(new BorderLayout(10, 10));
        pnContent.add(lbContent, BorderLayout.NORTH);
        pnContent.add(scp, BorderLayout.CENTER);
        pnContent.add(pnThongTinTongQuat, BorderLayout.SOUTH);

        pnBottom.setLayout(new BorderLayout());
        pnBottom.add(pnButton, BorderLayout.EAST);
        pnButton.setLayout(new GridLayout(1, 2, 5, 5));
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
        btnExit.setBackground(Color.decode("#FDFDFD"));
        pnButton.setBackground(Color.decode("#FAFAFA"));

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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                displayContentListService.Reset();
                dispose();
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

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        layTongSoLuongTable();
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
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Thành tiền");
        for (int i = 0; i < list.size(); i++) {
            Object data[] = {i + 1, list.get(i).getMaDV(), DichVuBUS.getTenDV(list.get(i).getMaDV()), list.get(i).getSoLuong(), dcf.format(list.get(i).getGiaDVNhap()) + " VNĐ", dcf.format((list.get(i).getSoLuong() * list.get(i).getGiaDVNhap())) + "VNĐ"};
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
        tb.getColumnModel().getColumn(1).setPreferredWidth(120);
        tb.getColumnModel().getColumn(2).setPreferredWidth(200);
        tb.getColumnModel().getColumn(3).setPreferredWidth(100);
        tb.setBorder(new MatteBorder(0, 1, 0, 1, Color.decode("#EEEEEE")));
    }

    public void layTongSoLuongTable() {
        int countSoluongTong = 0;
        long tongTien = 0;
        for (int i = 0; i < tb.getRowCount(); i++) {
            int soLuong = Integer.parseInt(tb.getValueAt(i, tb.getColumnModel().getColumnIndex("Số lượng nhập")).toString());
            String donGia = tb.getValueAt(i, tb.getColumnModel().getColumnIndex("Đơn giá")).toString();
            donGia = donGia.split(" ")[0];
            int donGiaInt = Integer.parseInt(donGia.replace(",", ""));
            tongTien += (long) (donGiaInt * soLuong);
            countSoluongTong += soLuong;
        }
        lbTongSL.setText(countSoluongTong + "");
        lbTongTien.setText(dcf.format(tongTien) + " VNĐ");
    }
}
