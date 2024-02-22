package GUI.GUI_HOADON;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import BUS.ChiTietThueBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import DAO.ItemDVDAO;
import DAO.ItemHoaDonDAO;
import DTO.HoaDonDTO;
import DTO.ItemDV;
import DTO.ItemHoaDon;
import GUI.ThongBaoDialog;

//import GUI.GUI_NHANVIEN.jdialog;

public class FormHoaDon extends JDialog {
	private JButton btnAcp, btnCancel;
	private JPanel pnBot;
	private JScrollPane scr;
	private JEditorPane txtHoaDon;

	private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
	private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
	private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
	private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
	private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
	private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 17);
	private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
	private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
	private Font fontTable = new Font("Segoe UI", Font.BOLD, 13);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	MatteBorder matteBorderCB = new MatteBorder(2, 2, 2, 2, Color.decode("#EFEFEF"));
	LineBorder lineCB = new LineBorder(Color.white);
	HoaDonLeTanGUI hdlt;

	public FormHoaDon(int options, HoaDonDTO hd, HoaDonLeTanGUI hdlt1) {

		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(1080, 700);
		setLocationRelativeTo(null);
		setBackground(Color.white);
		setTitle("Xuất hóa đơn");

		this.hdlt = hdlt1;

		btnAcp = new JButton();
		btnAcp.setPreferredSize(new Dimension(150, 30));
		btnAcp.setFont(sgUI18b);
		btnAcp.setBackground(Color.green);
		if (options == 1) {
			btnAcp.setText("Thanh toán");
			btnAcp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					xuLyHienThiHoaDon(hd,0);
					btnInHoaDonActionPerformed();
					hdlt.eventThanhToan(hd);
					new ThongBaoDialog("Thanh toán thành công", ThongBaoDialog.SUCCESS_DIALOG);
					dispose();
					hdlt.dispose();
				}
			});
		} else {
			btnAcp.setText("In hóa đơn");
			btnAcp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					xuLyHienThiHoaDon(maHD, tenNV, maCTT, tienPhong, tienDV, giamGia, phuThu, tongTien, ngayLap, pttt, tenKH);
//					btnInHoaDonActionPerformed();
//					new ThongBaoDialog("In hóa đơn thành công", ThongBaoDialog.SUCCESS_DIALOG);
				}
			});
		}

		btnCancel = new JButton("Hủy bỏ");
		btnCancel.setPreferredSize(new Dimension(150, 30));
		btnCancel.setFont(sgUI18b);
		btnCancel.setBackground(Color.red);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		txtHoaDon = new JEditorPane();
		xuLyHienThiHoaDon(hd,0);
		scr = new JScrollPane();
		scr.setViewportView(txtHoaDon);
		scr.setBackground(Color.white);

		pnBot = new JPanel();
		pnBot.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		pnBot.add(btnAcp);
		pnBot.add(btnCancel);
		pnBot.setBackground(Color.white);
		add(scr, BorderLayout.CENTER);
		add(pnBot, BorderLayout.SOUTH);
		setVisible(true);
	}

	public FormHoaDon(HoaDonDTO hd) {

		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(1080, 700);
		setLocationRelativeTo(null);
		setBackground(Color.white);
		setTitle("Xuất hóa đơn");

		btnAcp = new JButton();
		btnAcp.setPreferredSize(new Dimension(150, 30));
		btnAcp.setFont(sgUI18b);
		btnAcp.setBackground(Color.green);

		btnAcp.setText("In hóa đơn");
		btnAcp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyHienThiHoaDon(hd,1);
				btnInHoaDonActionPerformed();
				new ThongBaoDialog("In hóa đơn thành công", ThongBaoDialog.SUCCESS_DIALOG);
				dispose();
			}
		});

		btnCancel = new JButton("Hủy bỏ");
		btnCancel.setPreferredSize(new Dimension(150, 30));
		btnCancel.setFont(sgUI18b);
		btnCancel.setBackground(Color.red);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		txtHoaDon = new JEditorPane();
		xuLyHienThiHoaDon(hd,1);
		scr = new JScrollPane();
		scr.setViewportView(txtHoaDon);
		scr.setBackground(Color.white);

		pnBot = new JPanel();
		pnBot.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		pnBot.add(btnAcp);
		pnBot.add(btnCancel);
		pnBot.setBackground(Color.white);
		add(scr, BorderLayout.CENTER);
		add(pnBot, BorderLayout.SOUTH);
		setVisible(true);
	}

	private void xuLyHienThiHoaDon(String maHD, String tenNV, String maCTT, String tienPhong, String tienDV,
			String giamGia, String phuThu, String tongTien, String ngayLap, String pttt, String tenKH) {
		txtHoaDon.setContentType("text/html");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//		DecimalFormat dcf = new DecimalFormat("###,### VND");

		String hd = "<style> " + "table {" + "border: 1px solid;" + "border-bottom: none" + "}" + "tr {"
				+ "border-bottom: 1px solid;" + "}" + "td {" + "padding: 8px;" + "} " + "th {" + "font-size:16pt" + "}"
				+ "</style>";
		hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
		hd += "Mã hóa đơn: " + maHD + "<br/>";
//		hd += "Mã chi tiết thuê: " + maCTT + "<br/>";
		hd += "Nhân viên: " + tenNV + "<br/>";
		hd += "Ngày lập: " + ngayLap + "<br/>";
		hd += "Khách hàng: " + tenKH + "<br/>";
		hd += "<div style='text-align:center;'>==========================================</div><br/>";
		hd += "<div style='text-align:center'>";
		hd += "<table style='max-width:100%'>";
		hd += "<tr>" + "<th>Mã chi tiết thuê</th>" + "<th>Tiền phòng</th>" + "<th>Tiền dịch vụ</th>"
				+ "<th>Giảm giá</th>" + "<th>Phụ thu</th>" + "</tr>";
//		for (CTHoaDon cthd : CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD)) {
//			String tenSP = MatHangBUS.getInstance().layTenSanPhamById(cthd.getMaMH());
//
		hd += "<tr>";
		hd += "<td style='text-align:center;'>" + maCTT + "</td>";
		hd += "<td style='text-align:center;'>" + tienPhong + "</td>";
		hd += "<td style='text-align:left;'>" + tienDV + "</td>";
		hd += "<td style='text-align:center;'>" + giamGia + "</td>";
		hd += "<td style='text-align:center;'>" + phuThu + "</td>";
//			hd += "<td style='text-align:center;'>" + dcf.format(cthd.getThanhTien()) + "</td>";
		hd += "</tr>";
//		}
//		xuLyHienThiHoaDon(maHd, tenNV, maCTT, tienPhong, tienDV, giamGia, phuThu, tongTien,ngayLap,pttt,tenKH);
		hd += "<tr>";
		hd += "<td style='text-align:center;'>" + "</td>";
		hd += "<td style='text-align:left;'>" + "</td>";
		hd += "<td style='text-align:center;'>" + "</td>";
		hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
		hd += "<td style='text-align:center;'>" + tongTien + "</td>";
		hd += "</tr>";
		hd += "<tr>";
		hd += "<td style='text-align:center;'>" + "</td>";
		hd += "<td style='text-align:left;'>" + "</td>";
		hd += "<td style='text-align:center;'>" + "</td>";
		hd += "<td style='text-align:center;font-weight:bold'>Phương thức thanh toán</td>";
		hd += "<td style='text-align:center;'>" + pttt + "</td>";
		hd += "</tr>";

		hd += "</table>";
		hd += "</div>";
		hd += "<div style='text-align:center;'>==========================================</div><br/>";

		txtHoaDon.setText(hd);
//		new FormHoaDon(txtHoaDon, sgUI18b);

//        txtTongTien.setText(dcf.format(tongTien));
	}

//	private void xuLyHienThiHoaDon(HoaDonDTO hdto) {
//		txtHoaDon.setContentType("text/html");
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
////        LocalDateTime now = LocalDateTime.now();
////		DecimalFormat dcf = new DecimalFormat("###,### VND");
//
//		String hd = "<style> " + "table {" + "border: 1px solid;" + "border-bottom: none" + "}" + "tr {"
//				+ "border-bottom: 1px solid;" + "}" + "td {" + "padding: 8px;" + "} " + "th {" + "font-size:16pt" + "}"
//				+ "</style>";
//		hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
//		hd += "Mã hóa đơn: " + hdto.getMaHD() + "<br/>";
////		hd += "Mã chi tiết thuê: " + maCTT + "<br/>";
//		hd += "Nhân viên: " + NhanVienBUS.getIntance()
//				.layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(hdto.getMaCTT()).getMaNV()) + "<br/>";
//		hd += "Ngày lập: " + sdf.format(hdto.getNgayThanhToan()) + "<br/>";
//		hd += "Khách hàng: " + KhachHangBUS.getIntance()
//				.layTenBangMa(ChiTietThueBUS.getInstance().selectById(hdto.getMaCTT()).getMaKH()) + "<br/>";
//		hd += "<div style='text-align:center;'>==========================================</div><br/>";
//		hd += "<div style='text-align:center'>";
//		hd += "<table style='max-width:100%'>";
//		hd += "<tr>" + "<th>Mã chi tiết thuê</th>" + "<th>Tiền phòng</th>" + "<th>Tiền dịch vụ</th>"
//				+ "<th>Giảm giá</th>" + "<th>Phụ thu</th>" + "</tr>";
////		for (CTHoaDon cthd : CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD)) {
////			String tenSP = MatHangBUS.getInstance().layTenSanPhamById(cthd.getMaMH());
////
//		hd += "<tr>";
//		hd += "<td style='text-align:center;'>" + hdto.getMaCTT() + "</td>";
//		hd += "<td style='text-align:center;'>" + dcf.format(hdto.getTienP()) + "</td>";
//		hd += "<td style='text-align:left;'>" + dcf.format(hdto.getTienDV()) + "</td>";
//		hd += "<td style='text-align:center;'>" + hdto.getGiamGia() + "%" + "</td>";
//		hd += "<td style='text-align:center;'>" + hdto.getPhuThu() + "%" + "</td>";
////			hd += "<td style='text-align:center;'>" + dcf.format(cthd.getThanhTien()) + "</td>";
//		hd += "</tr>";
////		}
////		xuLyHienThiHoaDon(maHd, tenNV, maCTT, tienPhong, tienDV, giamGia, phuThu, tongTien,ngayLap,pttt,tenKH);
//		hd += "<tr>";
//		hd += "<td style='text-align:center;'>" + "</td>";
//		hd += "<td style='text-align:left;'>" + "</td>";
//		hd += "<td style='text-align:center;'>" + "</td>";
//		hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
//		hd += "<td style='text-align:center;'>" + dcf.format(hdto.getTongTien()) + " VNĐ" + "</td>";
//		hd += "</tr>";
//		hd += "<tr>";
//		hd += "<td style='text-align:center;'>" + "</td>";
//		hd += "<td style='text-align:left;'>" + "</td>";
//		hd += "<td style='text-align:center;'>" + "</td>";
//		hd += "<td style='text-align:center;font-weight:bold'>Phương thức thanh toán</td>";
//		hd += "<td style='text-align:center;'>" + hdto.getPhuongThucThanhToan() + "</td>";
//		hd += "</tr>";
//
//		hd += "</table>";
//		hd += "</div>";
//		hd += "<div style='text-align:center;'>==========================================</div><br/>";
//
//		txtHoaDon.setText(hd);
////		new FormHoaDon(txtHoaDon, sgUI18b);
//
////        txtTongTien.setText(dcf.format(tongTien));
//	}

	private void xuLyHienThiHoaDon(HoaDonDTO hdto, int options) {
		txtHoaDon.setContentType("text/html");
		String hd = "		<!DOCTYPE html>\r\n" + "		<html lang=\"en\">\r\n" + "		<head>\r\n"
				+ "		    <meta charset=\"UTF-8\">\r\n"
				+ "		    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "		    <title>Document</title>\r\n" + "		    <style>\r\n" + "		        .form {\r\n"
				+ "		            border: 1px solid black;\r\n" + "		            width: 800px;\r\n"
				+ "		        }\r\n" + "		        .hotel {\r\n" + "		            width: 100%;\r\n"
				+ "		            border: 1px solid black;\r\n" + "		        }\r\n"
				+ "		        .hotel td {\r\n" + "		            border:  1px solid white;\r\n"
				+ "		            padding: 5px;\r\n" + "		            text-align: center;\r\n"
				+ "		        }\r\n" + "		        .info {\r\n" + "		            width: 100%;\r\n"
				+ "		            border: 1px solid black;\r\n" + "		        }\r\n"
				+ "		        .info td {\r\n" + "		            border:  1px solid white;\r\n"
				+ "		            padding: 5px;\r\n" + "		        }\r\n" + "		        .info tr {\r\n"
				+ "		            border: 1px solid black;\r\n" + "		        }\r\n"
				+ "		        .room, .service{\r\n" + "		            width: 100%;\r\n"
				+ "		            border-collapse: collapse;\r\n" + "		        }\r\n"
				+ "		        .room th, td \r\n" + "		        ,.service th, td{\r\n"
				+ "		            border: 1px solid black;\r\n" + "		            padding: 10px;\r\n"
				+ "		        }\r\n" + "		        th {\r\n" + "		            text-align: center;\r\n"
				+ "		        }\r\n" + "		    </style>\r\n" + "		</head>\r\n" + "		<body>\r\n"
				+ "		    <div class=\"form\">\r\n" + "		        <table class=\"hotel\">\r\n"
				+ "		            <tr>\r\n" + "		                <td>\r\n"
				+ "		                    <table>\r\n"
				+ "		                        <tr><td>HÓA ĐƠN THANH TOÁN</td></tr>\r\n"
				+ "		                        <tr><td></td></tr>\r\n"
				+ "		                        <tr><td>Bản thể hiện hóa đơn</td></tr>\r\n"
				+ "		                        <tr><td>HOTEL LUXURY</td></tr>\r\n"
				+ "		                    </table>\r\n" + "		                </td>\r\n"
				+ "		                <td>\r\n" + "		                    <table>\r\n"
				+ "		                        <tr><td>HÓA ĐƠN THANH TOÁN</td></tr>\r\n"
				+ "		                        <tr><td></td></tr>\r\n"
				+ "		                        <tr><td>Bản thể hiện hóa đơn</td></tr>\r\n"
				+ "		                        <tr><td>" + hdto.getNgayThanhToan() + "</td></tr>\r\n"
				+ "		                    </table>\r\n" + "		                </td>\r\n"
				+ "		                <td>\r\n" + "		                    <table>\r\n"
				+ "		                        <tr><td>HÓA ĐƠN SỐ</td></tr>\r\n"
				+ "		                        <tr><td></td></tr>\r\n" + "		                        <tr><td>"
				+ hdto.getMaHD() + "</td></tr>\r\n" + "		                        <tr><td>" + hdto.getNgayThanhToan()
				+ "</td></tr>\r\n" + "		                    </table>\r\n" + "		                </td>\r\n"
				+ "		            </tr>\r\n" + "		        </table>\r\n"
				+ "		        <table class=\"info\">\r\n"
				+ "		            <tr><td><span style=\"font-weight: 600;\">Họ tên người thuê:</span> <span>"
				+ KhachHangBUS.getIntance().layTenBangMa(
						ChiTietThueBUS.getInstance().selectById(hdto.getMaCTT()).getMaKH())
				+ "</span></td></tr>\r\n"
				+ "		            <tr><td><span style=\"font-weight: 600;\">Nhân viên lập hóa đơn:</span> <span>"
				+ NhanVienBUS.getIntance().layTenNVtheoMA(
						ChiTietThueBUS.getInstance().selectById(hdto.getMaCTT()).getMaNV())
				+ "</span></td></tr>\r\n"
				+ "		            <tr><td><span style=\"font-weight: 600;\">Ngày lập hóa đơn:</span> <span>"
				+ hdto.getNgayThanhToan() + "</span></td></tr>\r\n"
				+ "		            <tr><td><span style=\"font-weight: 600;\">Hình thức thanh toán:</span> <span>"
				+ hdto.getPhuongThucThanhToan() + "</span></td></tr>\r\n" + "		        </table>\r\n"
				+ "		        <table class=\"room\">\r\n" + "		            <tr>\r\n"
				+ "		                <th>STT</th>\r\n" + "		                <th>Tên phòng</th>\r\n"
				+ "		                <th>Loại hình thuê</th>\r\n" + "		                <th>Ngày thuê</th>\r\n"
				+ "		                <th>Ngày trả</th>\r\n" + "		                <th>Giá thuê</th>\r\n"
				+ "		            </tr>\r\n";
		int stt=0;
		for (ItemHoaDon hd1 : ItemHoaDonDAO.getInstance().selectAll(hdto.getMaCTT())) {
			String loaiHinhThue = "";
			stt++;
			if (hd1.getLoaiHinhThue() == 0) {
				loaiHinhThue = "Theo giờ";
			} else if (hd1.getLoaiHinhThue() == 1) {
				loaiHinhThue = "Theo ngày";
			} else {
				loaiHinhThue = "Khác";
			}
			hd += "		            <tr>\r\n" + "		                <td style=\"text-align: center;\">"+stt+"</td>\r\n"
					+ "		                <td>" + hd1.getTenP() + "</td>\r\n" + "		                <td>"
					+ loaiHinhThue + "</td>\r\n" + "		                <td>" + hd1.getNgayThue() + "</td>\r\n"
					+ "		                <td>" + hd1.getNgayTra() + "</td>\r\n"
					+ "		                <td style=\"text-align: right;\">" + hd1.getGiaThue() + " VNĐ</td>\r\n"
					+ "		            </tr>\r\n";
		}
		hd += "		            \r\n" + "		            <tr>\r\n"
				+ "		                <td colspan=\"4\"></td>\r\n"
				+ "		                <td style=\"font-weight: 600;\">Tổng cộng:</td>\r\n"
				+ "		                <td style=\"text-align: right; font-weight: 600;\">"
				+ dcf.format(hdto.getTienP()) + " VNĐ</td>\r\n" + "		            </tr>\r\n"
				+ "		        </table>\r\n" + "		        <div style=\"border: 1px solid black;\"><br></div>\r\n"
				+ "		        <table class=\"service\">\r\n" + "		            <tr>\r\n"
				+ "		                <th>STT</th>\r\n" + "		                <th>Tên dịch vụ</th>\r\n"
				+ "		                <th>Loại dịch vụ</th>\r\n" + "		                <th>Ngày sử dụng</th>\r\n"
				+ "		                <th>Số lượng</th>\r\n" + "		                <th>Đơn giá</th>\r\n"
				+ "		                <th>Thành tiền</th>\r\n" + "		            </tr>\r\n";
		int stt1=0;
		for (ItemDV dv : ItemDVDAO.getInstance().selectAll(hdto.getMaCTT(),options)) {
			stt1++;
			hd += "		            <tr>\r\n" + "		                <td>"+stt1+"</td>\r\n" + "		                <td>"
					+ dv.getTenDV() + "</td>\r\n" + "		                <td>" + dv.getLoaiDV() + "</td>\r\n"
					+ "		                <td>" + dv.getNgaySD() + "</td>\r\n"
					+ "		                <td style=\"text-align: right;\">" + dv.getSoLuong() + "</td>\r\n"
					+ "		                <td style=\"text-align: right;\">" + dcf.format(dv.getDonGia())
					+ " VNĐ</td>\r\n" + "		                <td style=\"text-align: right;\">"
					+ dcf.format(dv.getThanhTien()) + " VNĐ</td>\r\n" + "		            </tr>\r\n";
		}
		hd += "		            \r\n" + "		            <tr>\r\n"
				+ "		                <td colspan=\"5\"></td>\r\n"
				+ "		                <td style=\"font-weight: 600;\">Tổng cộng:</td>\r\n"
				+ "		                <td style=\"text-align: right; font-weight: 600;\">"
				+ dcf.format(hdto.getTienDV()) + " VNĐ</td>\r\n" + "		            </tr>\r\n"
				+ "		        </table>\r\n"
				+ "		        <table style=\"width: 100%;border: 1px solid black;\">\r\n" + "<tr>\r\n"
				+ "                <td style=\"border: 1px solid white;\">Phụ thu</td>\r\n"
				+ "                <td style=\"border: 1px solid white; text-align: right; font-weight: 600;\">"
				+ hdto.getPhuThu() + "%</td>\r\n" + "            </tr>\r\n" + "            <tr>\r\n"
				+ "                <td style=\"border: 1px solid white;\">Khuyến mãi</td>\r\n"
				+ "                <td style=\"border: 1px solid white; text-align: right; font-weight: 600;\">"
				+ hdto.getGiamGia() + "%</td>\r\n" + "            </tr>" + "		            <tr>\r\n"
				+ "		                <td style=\"border: 1px solid white;\">Tổng tiền thanh toán</td>\r\n"
				+ "		                <td style=\"border: 1px solid white; text-align: right; font-weight: 600;\">"
				+ dcf.format(hdto.getTongTien()) + " VNĐ</td>\r\n" + "		            </tr>\r\n"
				+ "		            <tr style=\"padding: 5px;\">\r\n"
				+ "		                <td style=\"text-align: center; border: 1px solid white; padding: 0px;\"colspan =\"2\">Password: 123456789</td>\r\n"
				+ "		            </tr>\r\n" + "		            <tr style=\"padding: 5px;\">\r\n"
				+ "		                <td style=\"text-align: center; border: 1px solid white; padding: 0dvh;\" colspan=\"2\">Xin cảm ơn quý khách!!!</td>\r\n"
				+ "		            </tr>\r\n" + "		        </table>\r\n" + "		    </div>\r\n"
				+ "		</body>\r\n" + "		</html>";
		txtHoaDon.setText(hd);
	}

	private void btnInHoaDonActionPerformed() {
		try {
			if (!txtHoaDon.getText().equals("")) {
				txtHoaDon.print();
//                this.dispose();
			}
		} catch (PrinterException ex) {
		}
	}
}
