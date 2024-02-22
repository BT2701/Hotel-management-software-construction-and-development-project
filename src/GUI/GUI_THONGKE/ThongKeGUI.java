package GUI.GUI_THONGKE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BUS.ChiTietNhapBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.PhongBUS;

public class ThongKeGUI extends JPanel {

    // mã font, mã màu
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
    private Font fontSubTittle = new Font("Tahoma", Font.BOLD, 20);
    private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor = new Color(45, 52, 54);
    MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
    LineBorder lineCB = new LineBorder(Color.white);

    // components trong giao diện
    private JPanel pnTittle, pnTop, pnThongKeTongQuan, pnBieuDoDoanhThuThang, pnBot, pnChiTietPhong, pnChiTietLoaiPhong,
            pnCompoboxXemChiTiet, pnChiTietDoanhThuThang, pnChiTietNhapHangNam, pnctdt, pnctnh;
    private JLabel lbTittle, lbRefresh;
    private JLabel lbTXTsoLuongKhach, lbTXTtongChi, lbTXTtongDoanhThu, lbTXTloiNhuan;
    private JLabel lbSoLuongKhach, lbTongChi, lbTongDoanhThu, lbLoiNhuan;
    private JFreeChart chartDoanhThuThang;
    private JFreeChart chartChiTietPhong;
    private JFreeChart chartChiTietLoaiPhong;
    private JFreeChart chartChiTietDoanhThu;
    private JFreeChart chartChiTietNhapHang;
    private JComboBox<String> cbbXemChiTietDoanhThu;
    private JComboBox<String> cbbXemChiTietNhapHang;
    private JComboBox<String> cbbNam;
    private JLabel lbChiTietDoanhThuThang, lbChiTietNhapHangNam;
    private JButton btnBack, btnBack1;
    private JPanel[] pnTQ;
    private ChartPanel chartPnDoanhThuThang, chartPnChiTietPhong, chartPnChiTietLoaiPhong, chartPnChiTietDoanhThu,
            chartPnChiTietNhapHang;
    JPanel pnCbbNam;
    JPanel pnCbbCtdt;
    JPanel pnCbbCtnh;
    JPanel pnBtnBack;
    JPanel pnBtnback1;

    public ThongKeGUI() {
        initComponents();
        lightDark(0);
        addEvents();
    }

    public void initComponents() {
        lbTittle = new JLabel("THỐNG KÊ", JLabel.CENTER);
        lbTittle.setSize(300, 50);
        lbTittle.setFont(fontTittle);

        lbRefresh = new JLabel(new ImageIcon(getClass().getResource("/GUI/assets/Refresh-icon.png")));
        lbRefresh.setSize(30, 30);
        lbRefresh.setFont(sgUI13);

        lbTXTsoLuongKhach = new JLabel("SL khách: ", JLabel.CENTER);
        lbTXTsoLuongKhach.setFont(sgUI15);
        lbTXTsoLuongKhach.setPreferredSize(new Dimension(100, 40));

        lbSoLuongKhach = new JLabel("", JLabel.CENTER);
        lbSoLuongKhach.setFont(sgUI15);
        lbSoLuongKhach.setForeground(Color.decode("#c0392b"));
        lbSoLuongKhach.setText(dcf.format(soLuongKhach()));
        lbSoLuongKhach.setPreferredSize(new Dimension(150, 40));

        lbTXTtongChi = new JLabel("Tổng Chi: ", JLabel.CENTER);
        lbTXTtongChi.setFont(sgUI15);
        lbTXTtongChi.setPreferredSize(new Dimension(100, 40));

        lbTongChi = new JLabel("", JLabel.CENTER);
        lbTongChi.setFont(sgUI15);
        lbTongChi.setForeground(Color.decode("#c0392b"));
        lbTongChi.setText(dcf.format(tongChi()) + "VND");
        lbTongChi.setPreferredSize(new Dimension(150, 40));

        lbTXTtongDoanhThu = new JLabel("Tổng DT: ", JLabel.CENTER);
        lbTXTtongDoanhThu.setFont(sgUI15);
        lbTXTtongDoanhThu.setPreferredSize(new Dimension(100, 40));

        lbTongDoanhThu = new JLabel("", JLabel.CENTER);
        lbTongDoanhThu.setFont(sgUI15);
        lbTongDoanhThu.setForeground(Color.decode("#c0392b"));
        lbTongDoanhThu.setText(dcf.format(tongDoanhThu()) + "VND");
        lbTongDoanhThu.setPreferredSize(new Dimension(150, 40));

        lbTXTloiNhuan = new JLabel("Lợi Nhuận: ", JLabel.CENTER);
        lbTXTloiNhuan.setFont(sgUI15);
        lbTXTloiNhuan.setPreferredSize(new Dimension(100, 40));

        lbLoiNhuan = new JLabel("", JLabel.CENTER);
        lbLoiNhuan.setFont(sgUI15);
        lbLoiNhuan.setForeground(Color.decode("#c0392b"));
        lbLoiNhuan.setText(dcf.format(loiNhuan()) + "VND");
        lbLoiNhuan.setPreferredSize(new Dimension(150, 40));

        cbbXemChiTietDoanhThu = new JComboBox<String>();
        cbbXemChiTietDoanhThu.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbXemChiTietDoanhThu.setBackground(Color.white);
        cbbXemChiTietDoanhThu.setFont(sgUI13);
        cbbXemChiTietDoanhThu.setPreferredSize(new Dimension(200, 30));
        cbbXemChiTietDoanhThu.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbXemChiTietDoanhThu.setBorder(matteBorderCB);
        duLieuCBBdoanhThu();

        cbbXemChiTietNhapHang = new JComboBox<String>();
        cbbXemChiTietNhapHang.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbXemChiTietNhapHang.setBackground(Color.white);
        cbbXemChiTietNhapHang.setFont(sgUI13);
        cbbXemChiTietNhapHang.setPreferredSize(new Dimension(200, 30));
        cbbXemChiTietNhapHang.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbXemChiTietNhapHang.setBorder(matteBorderCB);
        duLieuCBBnhapHang();

        cbbNam = new JComboBox<String>();
        cbbNam.setBorder(new MatteBorder(2, 2, 2, 0, Color.decode("#EFEFEF")));
        cbbNam.setBackground(Color.white);
        cbbNam.setFont(sgUI13);
        cbbNam.setPreferredSize(new Dimension(200, 30));
        cbbNam.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(lineCB);
                return basicComboPopup;
            }
        });
        cbbNam.setBorder(matteBorderCB);
        duLieuCBBnam();

        lbChiTietDoanhThuThang = new JLabel("Chi tiết doanh thu tháng", JLabel.CENTER);
        lbChiTietDoanhThuThang.setFont(fontSubTittle);

        lbChiTietNhapHangNam = new JLabel("Chi tiết nhập hàng tháng", JLabel.CENTER);
        lbChiTietNhapHangNam.setFont(fontSubTittle);

        btnBack = new JButton("Trở lại");
        btnBack.setBackground(btnoldColor);
        btnBack.setPreferredSize(new Dimension(120, 30));

        btnBack1 = new JButton("Trở lại");
        btnBack1.setBackground(btnoldColor);
        btnBack1.setPreferredSize(new Dimension(120, 30));

        String year = cbbNam.getSelectedItem().toString();
        int nam = Integer.parseInt(year.split(" ")[1]);
        chartChiTietDoanhThu = createPieChart("Chi tiết loại phòng ", duLieuChartChiTietLoaiPhong(nam));
        chartChiTietLoaiPhong = createPieChart("Chi tiết loại phòng ", duLieuChartChiTietLoaiPhong(nam));
        chartChiTietNhapHang = createPieChart("Chi tiết loại phòng ", duLieuChartChiTietLoaiPhong(nam));
        chartChiTietPhong = createPieChart("Chi tiết phòng ", duLieuChartChiTietPhong(nam));
        chartDoanhThuThang = createBarChart("Doanh thu năm ", duLieuChartDoanhThuThangTongThu(nam),
                duLieuChartDoanhThuThangTongChi(nam), nam);
        // chartpn
        chartPnChiTietDoanhThu = new ChartPanel(chartChiTietDoanhThu);
        chartPnChiTietDoanhThu.setPreferredSize(new Dimension(1100, 220));

        chartPnChiTietLoaiPhong = new ChartPanel(chartChiTietLoaiPhong);
        chartPnChiTietLoaiPhong.setPreferredSize(new Dimension(300, 250));

        chartPnChiTietNhapHang = new ChartPanel(chartChiTietNhapHang);
        chartPnChiTietNhapHang.setPreferredSize(new Dimension(1100, 220));

        chartPnChiTietPhong = new ChartPanel(chartChiTietPhong);
        chartPnChiTietPhong.setPreferredSize(new Dimension(300, 250));

        chartPnDoanhThuThang = new ChartPanel(chartDoanhThuThang);
        chartPnDoanhThuThang.setPreferredSize(new Dimension(1100, 350));

        // các panel định hình
        pnCbbNam = new JPanel();
        pnCbbNam.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        pnCbbNam.add(cbbNam);
        pnCbbNam.add(cbbXemChiTietDoanhThu);
        pnCbbNam.add(cbbXemChiTietNhapHang);

        pnBtnBack = new JPanel();
        pnBtnBack.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnBtnBack.add(btnBack);

        pnBtnback1 = new JPanel();
        pnBtnback1.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnBtnback1.add(btnBack1);

        // thành phần của pnTittle
        pnTittle = new JPanel();
        pnTittle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnTittle.add(lbTittle);
        pnTittle.add(lbRefresh);
        // thành phần của pn[i]
        pnTQ = new JPanel[4];
        for (int i = 0; i < pnTQ.length; i++) {
            pnTQ[i] = new JPanel();
            pnTQ[i].setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        }
        pnTQ[0].add(lbTXTsoLuongKhach);
        pnTQ[0].add(lbSoLuongKhach);

        pnTQ[1].add(lbTXTtongChi);
        pnTQ[1].add(lbTongChi);

        pnTQ[2].add(lbTXTtongDoanhThu);
        pnTQ[2].add(lbTongDoanhThu);

        pnTQ[3].add(lbTXTloiNhuan);
        pnTQ[3].add(lbLoiNhuan);
        // thành phần của pnThongKeTongQuan
        pnThongKeTongQuan = new JPanel();
        pnThongKeTongQuan.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//		pnThongKeTongQuan.setBorder(new MatteBorder(1, 0, 1, 0, Color.black));
        for (JPanel jPanel : pnTQ) {
            pnThongKeTongQuan.add(jPanel);
        }

        // thành phần của pnBieuDoThongKeDoanhThuThang
        pnBieuDoDoanhThuThang = new JPanel();
        pnBieuDoDoanhThuThang.setLayout(new BorderLayout());
        pnBieuDoDoanhThuThang.add(pnCbbNam, BorderLayout.SOUTH);
        pnBieuDoDoanhThuThang.add(chartPnDoanhThuThang, BorderLayout.CENTER);

        // thành phần của pnChiTietPhong
        pnChiTietPhong = new JPanel();
        pnChiTietPhong.setLayout(new BorderLayout());
        pnChiTietPhong.add(chartPnChiTietPhong, BorderLayout.CENTER);

        // thành phần của pnChiTietLoaiPhong
        pnChiTietLoaiPhong = new JPanel();
        pnChiTietLoaiPhong.setLayout(new BorderLayout());
        pnChiTietLoaiPhong.add(chartPnChiTietLoaiPhong, BorderLayout.CENTER);

        // pnctdt là biểu đồ
        pnctdt = new JPanel();
        pnctdt.setLayout(new BorderLayout());
        pnctdt.add(chartPnChiTietDoanhThu, BorderLayout.CENTER);

        // pnctnh là biểu đồ
        pnctnh = new JPanel();
        pnctnh.setLayout(new BorderLayout());
        pnctnh.add(chartPnChiTietNhapHang, BorderLayout.CENTER);

        // thành phần của pnCompoBoxXemChiTiet
//		pnCompoboxXemChiTiet = new JPanel();
//		pnCompoboxXemChiTiet.setLayout(new GridLayout(2, 1, 10, 10));
//		pnCompoboxXemChiTiet.add(pnCbbCtdt);
//		pnCompoboxXemChiTiet.add(pnCbbCtnh);
//		pnCompoboxXemChiTiet.setPreferredSize(new Dimension(600, 200));
//		pnCompoboxXemChiTiet.setVisible(true);
        // thành phần của pnChiTietDoanhThuThang
        pnChiTietDoanhThuThang = new JPanel();
        pnChiTietDoanhThuThang.setLayout(new BorderLayout());
        pnChiTietDoanhThuThang.add(lbChiTietDoanhThuThang, BorderLayout.NORTH);
        pnChiTietDoanhThuThang.add(pnctdt, BorderLayout.CENTER);
        pnChiTietDoanhThuThang.add(pnBtnBack, BorderLayout.SOUTH);
        pnChiTietDoanhThuThang.setVisible(false);

        // thành phần của pnChiTietNhapHangNam
        pnChiTietNhapHangNam = new JPanel();
        pnChiTietNhapHangNam.setLayout(new BorderLayout());
        pnChiTietNhapHangNam.add(lbChiTietNhapHangNam, BorderLayout.NORTH);
        pnChiTietNhapHangNam.add(pnctnh, BorderLayout.CENTER);
        pnChiTietNhapHangNam.add(pnBtnback1, BorderLayout.SOUTH);
        pnChiTietNhapHangNam.setVisible(false);
        // pnTop
        pnTop = new JPanel();
        pnTop.setLayout(new BorderLayout());
        pnTop.add(pnTittle, BorderLayout.NORTH);
        pnTop.add(pnThongKeTongQuan, BorderLayout.CENTER);
        // pnBot
        pnBot = new JPanel();
        pnBot.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnBot.add(pnChiTietPhong);
        pnBot.add(pnChiTietLoaiPhong);
//		pnBot.add(pnCompoboxXemChiTiet);
        pnBot.add(pnChiTietDoanhThuThang);
        pnBot.add(pnChiTietNhapHangNam);

        // pn chính
        setLayout(new BorderLayout());
        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnBieuDoDoanhThuThang, BorderLayout.CENTER);
        this.add(pnBot, BorderLayout.SOUTH);
    }

    public void lightDark(int options) {
        if (options == 0) {
            pnBieuDoDoanhThuThang.setBackground(Color.white);
            pnChiTietDoanhThuThang.setBackground(Color.white);
            pnChiTietNhapHangNam.setBackground(Color.white);
            pnChiTietPhong.setBackground(Color.white);
//			pnCompoboxXemChiTiet.setBackground(Color.white);
            pnThongKeTongQuan.setBackground(Color.white);
            pnTittle.setBackground(Color.white);
            pnTop.setBackground(Color.white);
            pnBot.setBackground(Color.white);
            pnChiTietLoaiPhong.setBackground(Color.white);
            pnTQ[0].setBackground(Color.decode("#55efc4"));
            pnTQ[1].setBackground(Color.decode("#81ecec"));
            pnTQ[2].setBackground(Color.decode("#74b9ff"));
            pnTQ[3].setBackground(Color.decode("#a29bfe"));
            pnctdt.setBackground(Color.white);
            pnctnh.setBackground(Color.white);
            pnCbbNam.setBackground(Color.white);
//			pnCbbCtdt.setBackground(Color.white);
//			pnCbbCtnh.setBackground(Color.white);
            pnBtnBack.setBackground(Color.white);
            pnBtnback1.setBackground(Color.white);
        } else {
        }
    }

    public void addEvents() {
        eventCBBdoanhThu();
        eventCBBnhapHang();
        eventBtnBack();
        eventCbbNam();
    }

    public void eventCBBdoanhThu() {
        cbbXemChiTietDoanhThu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (cbbXemChiTietDoanhThu.getSelectedIndex() == 0) {
                    return;
                }
                String year = cbbNam.getSelectedItem().toString();
                int nam = Integer.parseInt(year.split(" ")[1]);
                String month = cbbXemChiTietDoanhThu.getSelectedItem().toString();
                int thang = Integer.parseInt(month.split(" ")[1]);
                lbChiTietDoanhThuThang.setText("Chi tiết doanh thu tháng " + thang + " năm " + nam);
                lbChiTietDoanhThuThang.setVisible(false);

                chartChiTietDoanhThu = createLineChart("Chi tiết doanh thu tháng ",
                        duLieuChartChiTietDoanhThu(nam, thang), nam, thang);
                chartPnChiTietDoanhThu.setChart(chartChiTietDoanhThu);

//				pnCompoboxXemChiTiet.setVisible(false);
                pnChiTietDoanhThuThang.setVisible(true);
                pnChiTietPhong.setVisible(false);
                pnChiTietLoaiPhong.setVisible(false);
                pnChiTietNhapHangNam.setVisible(false);
//				duLieuCBBnam();
                duLieuCBBnhapHang();
            }
        });
    }

    public void eventCBBnhapHang() {
        cbbXemChiTietNhapHang.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (cbbXemChiTietNhapHang.getSelectedIndex() == 0) {
                    return;
                }
                String year = cbbNam.getSelectedItem().toString();
                int nam = Integer.parseInt(year.split(" ")[1]);
                String month = cbbXemChiTietNhapHang.getSelectedItem().toString();
                int thang = Integer.parseInt(month.split(" ")[1]);
                lbChiTietNhapHangNam.setText("Chi tiết nhập hàng tháng " + thang);
                lbChiTietNhapHangNam.setVisible(false);

                chartChiTietNhapHang = createLineChart("Chi tiết nhập hàng ", duLieuChartChiTietNhapHang(nam, thang),
                        nam, thang);
                chartPnChiTietNhapHang.setChart(chartChiTietNhapHang);

//				pnCompoboxXemChiTiet.setVisible(false);
                pnChiTietDoanhThuThang.setVisible(false);
                pnChiTietPhong.setVisible(false);
                pnChiTietLoaiPhong.setVisible(false);
                pnChiTietNhapHangNam.setVisible(true);
//				duLieuCBBnam();
                duLieuCBBdoanhThu();
            }
        });
    }

    public void eventCbbNam() {
        cbbNam.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String year = cbbNam.getSelectedItem().toString();
                int nam = Integer.parseInt(year.split(" ")[1]);
                chartDoanhThuThang = createBarChart("Doanh thu năm ", duLieuChartDoanhThuThangTongThu(nam),
                        duLieuChartDoanhThuThangTongChi(nam), nam);
                chartPnDoanhThuThang.setChart(chartDoanhThuThang);

                chartChiTietLoaiPhong = createPieChart("Chi tiết loại phòng ", duLieuChartChiTietLoaiPhong(nam));
                chartPnChiTietLoaiPhong.setChart(chartChiTietLoaiPhong);

                chartChiTietPhong = createPieChart("Chi tiết phòng ", duLieuChartChiTietPhong(nam));
                chartPnChiTietPhong.setChart(chartChiTietPhong);
                duLieuCBBdoanhThu();
                duLieuCBBnhapHang();
                pnChiTietDoanhThuThang.setVisible(false);
                pnChiTietPhong.setVisible(true);
                pnChiTietLoaiPhong.setVisible(true);
                pnChiTietNhapHangNam.setVisible(false);
            }
        });
    }

    public void eventBtnBack() {
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
//				pnCompoboxXemChiTiet.setVisible(true);
                pnChiTietDoanhThuThang.setVisible(false);
                pnChiTietPhong.setVisible(true);
                pnChiTietLoaiPhong.setVisible(true);
                pnChiTietNhapHangNam.setVisible(false);
                duLieuCBBnam();
                duLieuCBBnhapHang();
                duLieuCBBdoanhThu();
            }
        });
        btnBack1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                pnChiTietNhapHangNam.setVisible(false);
//				pnCompoboxXemChiTiet.setVisible(true);
                pnChiTietDoanhThuThang.setVisible(false);
                pnChiTietPhong.setVisible(true);
                pnChiTietLoaiPhong.setVisible(true);
                pnChiTietNhapHangNam.setVisible(false);
                duLieuCBBnam();
                duLieuCBBnhapHang();
                duLieuCBBdoanhThu();
            }
        });
    }

    // đẩy dữ liệu bảng khách hàng
    public int soLuongKhach() {
        return KhachHangBUS.getIntance().laySoLuongKH();
    }

    // lấy dữ liệu từ thông tin nhập hàng để tính tổng chi
    public long tongChi() {
        return ChiTietNhapBUS.getInstance().layTongChi();
    }

    // lấy dữ liệu từ việc tính tổng tiền trong hóa đơn
    public long tongDoanhThu() {
        return (long) HoaDonBUS.getIntance().getTongDoanhThu();
    }

    // lấy tổng thu trừ tổng chi
    public long loiNhuan() {
        return (long) (tongDoanhThu() - tongChi());
    }

    // lấy dữ liệu từ bảng hóa hóa đơn
    public void duLieuCBBdoanhThu() {
        Vector<String> data = new Vector<>();
        data.add("Xem chi tiết doanh thu");
        String month = "";
        for (int i = 1; i < 13; i++) {
            month = "Tháng " + i;
            data.add(month);
        }
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(data);
        cbbXemChiTietDoanhThu.setModel(cbmodel);
    }

    // tính tổng tiền bên bảng nhập hàng
    public void duLieuCBBnhapHang() {
        Vector<String> data = new Vector<>();
        data.add("Xem chi tiết nhập hàng");
        String month = "";
        for (int i = 1; i < 13; i++) {
            month = "Tháng " + i;
            data.add(month);
        }
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(data);
        cbbXemChiTietNhapHang.setModel(cbmodel);
    }

    public void duLieuCBBnam() {
        Vector<String> data = new Vector<>();
        String year = "";
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        for (int i = currentYear; i > 2019; i--) {
            year = "Năm " + i;
            data.add(year);
        }
        DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(data);
        cbbNam.setModel(cbmodel);
    }

    //NHỮNG HÀM TỪ VỊ TRÍ NÀY TRỞ XUỐNG ĐÃ CÓ TRONG FILE CŨ NHƯNG DỮ LIỆU ĐÃ ĐƯỢC CẬP NHẬP
    //COPY XONG NHỚ CẬP NHẬT LẠI CÁC HÀM EVENT Ở TRÊN
    private JFreeChart createLineChart(String tittle, ArrayList<Double> data, int nam, int thang) {
        JFreeChart lineChart = ChartFactory.createLineChart(tittle + thang + " năm " + nam, "Ngày", "VND",
                createLineDataset(data, nam, thang), PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        plot.setBackgroundPaint(Color.white);
        return lineChart;
    }

    private CategoryDataset createLineDataset(ArrayList<Double> data, int nam, int thang) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // lấy chính xác số ngày trong tháng của 1 năm nào đó
        int soNgay = LocalDate.of(nam, thang, 1).lengthOfMonth();
        for (int i = 0; i < soNgay; i++) {
            double value = data.get(i);
//            đặt tạm giá trị
            dataset.addValue(value, "Tổng tiền ", (i + 1) + "");
        }
        return dataset;
    }

    private DefaultPieDataset createPieDataset(ArrayList<Integer> data, int options) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (options == 0) {
            dataset.setValue("Phòng thường", data.get(0));
            dataset.setValue("Phòng vip", data.get(1));
        } else {
            dataset.setValue("Phòng đơn", data.get(0));
            dataset.setValue("Phòng đôi", data.get(1));
            dataset.setValue("Phòng gia đình", data.get(2));
        }
        return dataset;
    }

    private JFreeChart createPieChart(String tittle, ArrayList<Integer> data) {
        int option = 0;
        if (tittle.equalsIgnoreCase("Chi tiết phòng ")) {
            option = 0;
        } else {
            option = 1;
        }
        JFreeChart chart = ChartFactory.createRingChart(tittle, // Tiêu đề của biểu đồ
                createPieDataset(data, option), // Dữ liệu
                true, // Hiển thị chú thích
                true, false);
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        return chart;
    }

    private CategoryDataset createBarDataset(ArrayList<Double> dataTongThu, ArrayList<Double> dataTongChi) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
            dataset.addValue(dataTongChi.get(i), "Tổng chi", "Tháng " + (i + 1));
            dataset.addValue(dataTongThu.get(i), "Tổng thu", "Tháng " + (i + 1));
        }

        return dataset;
    }

    private JFreeChart createBarChart(String tittle, ArrayList<Double> dataTongThu, ArrayList<Double> dataTongChi,
            int nam) {
        JFreeChart chart = ChartFactory.createBarChart(tittle + nam, // Tiêu đề của biểu đồ
                "Tháng", // Nhãn trục x
                "VND", // Nhãn trục y
                createBarDataset(dataTongThu, dataTongChi), // Dữ liệu
                PlotOrientation.VERTICAL, // Hướng biểu đồ
                true, // Hiển thị chú thích
                true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
        BarRenderer renderer1 = new BarRenderer();
        plot.setRenderer(0, renderer1);
        plot.setBackgroundPaint(Color.white);

        return chart;
    }

    // dùng hàm của bus lấy thông tin thống kê theo tháng
    public ArrayList<Double> duLieuChartDoanhThuThangTongThu(int nam) {
        ArrayList<Double> datas = new ArrayList<>();

        // lấy tạm dữ liệu để test
        for (int i = 0; i < 12; i++) {
            datas.add(HoaDonBUS.getIntance().layDuLieuTongThuTheoThang(nam, i + 1));
        }
        return datas;
    }

    // lấy dữ liệu bảng nhập hàng
    public ArrayList<Double> duLieuChartDoanhThuThangTongChi(int nam) {
        ArrayList<Double> datas = new ArrayList<>();

        // lấy tạm dữ liệu để test
        for (int i = 0; i < 12; i++) {
            datas.add(HoaDonBUS.getIntance().layDuLieuTongChiTheoThang(nam, i + 1));
        }
        return datas;
    }

    public ArrayList<Integer> duLieuChartChiTietPhong(int nam) {
        ArrayList<Integer> datas = new ArrayList<>();

        // lấy tạm dữ liệu để test
        for (int i = 0; i < 2; i++) {
            int duLieu = 0;
            if (PhongBUS.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, 0) == null) {
                datas.add(0);
            } else {
                if (PhongBUS.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, 0).size() > i) {
                    duLieu = PhongBUS.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, 0).get(i);
                } else {
                    duLieu = 0;
                }
                datas.add(duLieu);
            }
        }
        return datas;
    }

    public ArrayList<Integer> duLieuChartChiTietLoaiPhong(int nam) {
        ArrayList<Integer> datas = new ArrayList<>();

        // lấy tạm dữ liệu để test
        for (int i = 0; i < 3; i++) {
            int duLieu = 0;
            if (PhongBUS.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, 1) == null) {
                datas.add(0);
            } else {
                if (PhongBUS.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, 1).size() > i) {
                    duLieu = PhongBUS.getInstance().layDuLieuSoLuongPhongTheoLoai(nam, 1).get(i);
                } else {
                    duLieu = 0;
                }
                datas.add(duLieu);
            }
        }
        return datas;
    }

    public ArrayList<Double> duLieuChartChiTietDoanhThu(int nam, int thang) {
        ArrayList<Double> datas = new ArrayList<>();

        // lấy tạm dữ liệu để test
        int soNgay = LocalDate.of(nam, thang, 1).lengthOfMonth();
        for (int i = 0; i < soNgay; i++) {
            datas.add(HoaDonBUS.getIntance().layDoanhThuTheoNgayChart(nam, thang, i + 1));
        }
        return datas;
    }

    public ArrayList<Double> duLieuChartChiTietNhapHang(int nam, int thang) {
        ArrayList<Double> datas = new ArrayList<>();

        // lấy tạm dữ liệu để test
        int soNgay = LocalDate.of(nam, thang, 1).lengthOfMonth();
        for (int i = 0; i < soNgay; i++) {
            datas.add(ChiTietNhapBUS.getInstance().layTongChiTheoNgay(i + 1, thang, nam));
        }
        return datas;
    }
}
