package GUI.GUI_DATPHONG;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import BUS.ChiTietThueBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import DTO.ChiTietThueDTO;
import DTO.HoaDonDTO;
import GUI.ThongBaoDialog;
import GUI.GUI_BASIC.ReceptionistGUI;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChiTietThuePhongGUI extends JPanel {

	private JTextField[] TFthongTinThue;
	private JCheckBox chbTinhTrang;
	private JLabel lbTittle, lbRefresh, lbTittleHeader, lbNote;
	private JTable tbDanhSach;
	private JScrollPane scrDanhSach;
	private JButton btnTimKem;

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
	private Color btnoldColor = new Color(52, 152, 219);
	private Color texfieldColor = new Color(45, 52, 54);
	private String colorTableCode = "#dee9fc";
	private String colorLabel = "ebf2fc";
	ImageIcon iconSearch = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/searchIcon.png")).getImage()
			.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	ImageIcon iconRefresh = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/Refresh-icon.png"))
			.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
	// panel thành phần
	private JPanel pnTittle, pnSearch, pnHeader;

	// panel bao quát
	private JPanel pnTop, pnCenter;
	ReceptionistGUI receptionistGUI;

	public ChiTietThuePhongGUI(ReceptionistGUI receptionistGUI) {
		this.receptionistGUI = receptionistGUI;
		initComponents();
		lightDark(0);
	}

	public void initComponents() {
		// thành phần của pnTop
		// thành phần của pnTittle
		lbTittle = new JLabel("Danh sách chi tiết đặt phòng", JLabel.CENTER);
		lbTittle.setFont(fontTittle);
		lbTittle.setSize(300, 50);
		lbTittle.setOpaque(true);
		lbTittle.setBackground(Color.WHITE);

		lbRefresh = new JLabel();
		lbRefresh.setIcon(iconRefresh);
		lbRefresh.setSize(30, 30);
		lbRefresh.setFont(sgUI13);
		lbRefresh.setOpaque(true);
		lbRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xuLySuKienNutRefresh();
			}
		});

		pnTittle = new JPanel();
		pnTittle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pnTittle.add(lbTittle);
		pnTittle.add(lbRefresh);

		// thành phần của pnSearch
		TFthongTinThue = new JTextField[5];
		String[] tenTT = { "Mã chi tiết thuê", "Mã khách hàng", "Tên khách hàng", "Mã nhân viên", "Tên nhân viên" };
		for (int i = 0; i < TFthongTinThue.length; i++) {
			TFthongTinThue[i] = new JTextField(tenTT[i]);
			TFthongTinThue[i].setFont(sgUI13);
			TFthongTinThue[i].setPreferredSize(new Dimension(200, 30));
		}
		setPlaceholderTF();
//		ImageIcon maleIcon = createRoundedImageIcon(Color.gray, 20, 20);
		ImageIcon maleIcon = createRoundedImageIcon(Color.green, 20, 20);
		chbTinhTrang = new JCheckBox("Đã xử lý");
		chbTinhTrang.setIcon(maleIcon);
		chbTinhTrang.setFont(sgUI13);
		chbTinhTrang.setPreferredSize(new Dimension(80, 30));
		chbTinhTrang.addItemListener(new ItemListener() {
			private boolean isGray = true;

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (isGray) {
						chbTinhTrang.setForeground(Color.GREEN);
						chbTinhTrang.setText("Đã xử lý");
					} else {
						chbTinhTrang.setForeground(Color.GRAY);
						chbTinhTrang.setText("Chưa xử lý");
					}
					isGray = !isGray;
				}
			}
		});

		btnTimKem = new JButton("Tìm kiếm");
//		btnTimkiem = new JButton("Tìm kiếm");
//		btnTimkiem.setBounds(820, 240, 120, 30);
		btnTimKem.setFont(sgUI13b);
		btnTimKem.setIcon(iconSearch);

//        btnExTimKiem = new JButton("Thoát tìm kiếm");
		pnSearch = new JPanel();
		pnSearch.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		for (JTextField tf : TFthongTinThue) {
			pnSearch.add(tf);
		}
		pnSearch.add(chbTinhTrang);
		pnSearch.add(btnTimKem);
//        pnSearch.add(btnExTimKiem);

		pnTop = new JPanel();
		pnTop.setLayout(new BorderLayout());
		pnTop.add(pnTittle, BorderLayout.NORTH);
		pnTop.add(pnSearch, BorderLayout.CENTER);

		// thành phần của pnCenter
		// thành phần của panelHeader
		lbTittleHeader = new JLabel("Bảng chi tiết thuê", JLabel.LEFT);
		lbTittleHeader.setFont(sgUI18b);

		lbNote = new JLabel("Chọn dòng bất kì để xem chi tiết đặt phòng", JLabel.LEFT);
		lbNote.setFont(sgUI18b);
		lbNote.setFont(tNR13);
		lbNote.setBorder(new EmptyBorder(3, 0, 0, 0));

		pnHeader = new JPanel();
		pnHeader.setLayout(new GridLayout(2, 4, 5, 5));
		pnHeader.add(lbTittleHeader);
		JPanel temp;
		for (int i = 0; i < 7; i++) {
			if (i == 3) {
				pnHeader.add(lbNote);
			} else {
				temp = new JPanel();
				temp.setBackground(Color.white);
				pnHeader.add(temp);
			}
		}
		// bảng chi tiết
		tbDanhSach = new JTable() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		scrDanhSach = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrDanhSach.setBorder(BorderFactory.createEmptyBorder());
		scrDanhSach.setViewportView(tbDanhSach);
		renderTB(tbDanhSach);
		getDSHDALL();
		scrDanhSach.setViewportBorder(null);

		tbDanhSach.setShowGrid(false);
		tbDanhSach.setIntercellSpacing(new Dimension(0, 0));
		TableCellRenderer renderer = new CustomTableCTT();
		for (int i = 0; i < tbDanhSach.getColumnCount(); i++) {
			tbDanhSach.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		tbDanhSach.setRowHeight(35);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("STT")).setPreferredWidth(30);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Mã chi tiết thuê"))
				.setPreferredWidth(150);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Mã khách hàng"))
				.setPreferredWidth(120);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Tên khách hàng"))
				.setPreferredWidth(200);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Mã nhân viên"))
				.setPreferredWidth(120);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Tên nhân viên"))
				.setPreferredWidth(200);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Tiền đặt cọc"))
				.setPreferredWidth(100);
		tbDanhSach.getColumnModel().getColumn(tbDanhSach.getColumnModel().getColumnIndex("Tình trạng xử lý"))
				.setPreferredWidth(100);
		tbDanhSach.getTableHeader().setPreferredSize(new Dimension(1, 30));
		tbDanhSach.getTableHeader().setFont(fontTable);
		tbDanhSach.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCenter.add(pnHeader, BorderLayout.NORTH);
		pnCenter.add(scrDanhSach, BorderLayout.CENTER);

		tbDanhSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tbDanhSach.getSelectedRow() != -1) {
					String maCTT = tbDanhSach.getValueAt(tbDanhSach.getSelectedRow(),
							tbDanhSach.getColumnModel().getColumnIndex("Mã chi tiết thuê")).toString();
					receptionistGUI.pnCenterContent.removeAll();
					receptionistGUI.pnCenterContent.revalidate();
					receptionistGUI.pnCenterContent.repaint();
					receptionistGUI.pnRight.setVisible(false);
					if (tbDanhSach
							.getValueAt(tbDanhSach.getSelectedRow(),
									tbDanhSach.getColumnModel().getColumnIndex("Tình trạng xử lý"))
							.toString().equals("Chưa xử lý"))
						receptionistGUI.pnCenterContent.add(new FormDetailBooking(maCTT, false, receptionistGUI),
								BorderLayout.CENTER);
					else {
						receptionistGUI.pnCenterContent.add(new FormDetailBooking(maCTT, true, receptionistGUI),
								BorderLayout.CENTER);
					}
				}
			}
		});
//panel lớn
		this.setLayout(new BorderLayout());
		this.add(pnTop, BorderLayout.NORTH);
		this.add(pnCenter, BorderLayout.CENTER);
		eventBtnSearch();
	}

	private static ImageIcon createRoundedImageIcon(Color color, int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = image.createGraphics();

		g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.fillOval(0, 0, width, height);
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(2));
		g2.drawOval(0, 0, width, height);
		g2.dispose();

		return new ImageIcon(image);
	}

	public static void setPlaceholder(JTextField textField, String placeholder) {
		textField.setText(placeholder);
		textField.setForeground(Color.GRAY);

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(placeholder)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setText(placeholder);
					textField.setForeground(Color.GRAY);
				}
			}
		});
	}

	public void setPlaceholderTF() {
		String[] tenTT = { "Mã chi tiết thuê", "Mã khách hàng", "Tên khách hàng", "Mã nhân viên", "Tên nhân viên" };
		for (int i = 0; i < TFthongTinThue.length; i++) {
			setPlaceholder(TFthongTinThue[i], tenTT[i]);
		}
	}

	public void xuLySuKienNutRefresh() {
		delTableHoaDon();
		getDSHDALL();
//		layDsKhoangGia();
		setPlaceholderTF();

	}

	public void lightDark(int option) {
		if (option == 0) {
			tbDanhSach.getTableHeader().setBackground(Color.decode("#D1FFE1"));
			btnTimKem.setBackground(Color.decode("#2ecc71"));
			scrDanhSach.getViewport().setBackground(Color.white);
//			btnT.setBackground(Color.decode(colorTableCode));
			pnCenter.setBackground(Color.WHITE);
			pnSearch.setBackground(Color.WHITE);
			pnTittle.setBackground(Color.WHITE);
			pnTop.setBackground(Color.WHITE);
//			pnTopBotBotPrince.setBackground(Color.WHITE);
//			pnTopBotBotTime.setBackground(Color.WHITE);
//			pnTopBotTop.setBackground(Color.WHITE);
//			pnTopCenter.setBackground(Color.WHITE);
//			pnTopTop.setBackground(Color.WHITE);
			lbRefresh.setBackground(Color.white);
			chbTinhTrang.setBackground(Color.white);
			pnHeader.setBackground(Color.white);
		} else {

		}
	}

	public void delTableHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tbDanhSach.getModel();
		model.setRowCount(0);
	}

	public void renderTB(JTable tbP) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("STT");
		dtm.addColumn("Mã chi tiết thuê");
		dtm.addColumn("Mã khách hàng");
		dtm.addColumn("Tên khách hàng");
		dtm.addColumn("Mã nhân viên");
		dtm.addColumn("Tên nhân viên");
		dtm.addColumn("Tiền đặt cọc");
		dtm.addColumn("Tình trạng xử lý");
		tbP.setModel(dtm);
		tbP.setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
	}

	public void getDSHDALL() {
		// stt, mã ctt, mã kh, tên kh, mã nv, tên nv, tiền đc, xử lý
		DefaultTableModel model = (DefaultTableModel) tbDanhSach.getModel();
		int dem = 0;
		for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
			dem++;
			Vector<String> vec = new Vector<>();
			vec.add(dem + "");
			vec.add(ctt.getMaCTT());
			vec.add(ctt.getMaKH());
			vec.add(KhachHangBUS.getIntance()
					.layTenBangMa(ChiTietThueBUS.getInstance().selectById(ctt.getMaCTT()).getMaKH()));
			vec.add(ctt.getMaNV());
			vec.add(NhanVienBUS.getIntance()
					.layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(ctt.getMaCTT()).getMaNV()));
			vec.add(dcf.format(ctt.getTienDatCoc()) + "VND");
			if (ctt.getTinhTrangXuLy() == 1) {
				vec.add("Đã xử lý");
			} else {
				vec.add("Chưa xử lý");
			}
			model.addRow(vec);
		}
	}

	public void truyenDataSearch(ArrayList<ChiTietThueDTO> list) {
		DefaultTableModel model = (DefaultTableModel) tbDanhSach.getModel();
		int dem = 0;
		for (ChiTietThueDTO ctt : list) {
			dem++;
			Vector<String> vec = new Vector<>();
			vec.add(dem + "");
			vec.add(ctt.getMaCTT());
			vec.add(ctt.getMaKH());
			vec.add(KhachHangBUS.getIntance()
					.layTenBangMa(ChiTietThueBUS.getInstance().selectById(ctt.getMaCTT()).getMaKH()));
			vec.add(ctt.getMaNV());
			vec.add(NhanVienBUS.getIntance()
					.layTenNVtheoMA(ChiTietThueBUS.getInstance().selectById(ctt.getMaCTT()).getMaNV()));
			vec.add(dcf.format(ctt.getTienDatCoc()) + "VND");
			if (ctt.getTinhTrangXuLy() == 1) {
				vec.add("Đã xử lý");
			} else {
				vec.add("Chưa xử lý");
			}
			model.addRow(vec);
		}

	}

	public void eventBtnSearch() {
		btnTimKem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maCTT = TFthongTinThue[0].getText();
				String maKH = TFthongTinThue[1].getText();
				String tenKH = TFthongTinThue[2].getText();
				String maNV = TFthongTinThue[3].getText();
				String tenNV = TFthongTinThue[4].getText();
				ArrayList<ChiTietThueDTO> list = new ArrayList<>();
				if (maCTT.equalsIgnoreCase("Mã chi tiết thuê") && maKH.equalsIgnoreCase("Mã khách hàng")
						&& tenKH.equalsIgnoreCase("Tên khách hàng") && maNV.equalsIgnoreCase("Mã nhân viên")
						&& tenNV.equalsIgnoreCase("Tên nhân viên")) {
					new ThongBaoDialog("Vui lòng nhập điều kiện lọc", ThongBaoDialog.WARNING_DIALOG);
					xuLySuKienNutRefresh();
					return;
				} else {
					if (!maCTT.equalsIgnoreCase("Mã chi tiết thuê")) {
						if (!maKH.equalsIgnoreCase("Mã khách hàng")) {
							if (!tenKH.equalsIgnoreCase("Tên khách hàng")) {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)
													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}

									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)
													&& ctt.getMaKH().contains(maKH) && KhachHangBUS.getIntance()
															.layTenBangMa(ctt.getMaKH()).contains(tenKH)
													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)
													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
															.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)
													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)) {
												list.add(ctt);
											}
										}
									}
								}
							} else {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)

													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)

													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)
													&& NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
															.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT) && ctt.getMaKH().contains(maKH)) {
												list.add(ctt);
											}
										}
									}
								}

							}
						} else {
							if (!tenKH.equalsIgnoreCase("Tên khách hàng")) {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
															.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)) {
												list.add(ctt);
											}
										}
									}
								}

							} else {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)

													&& NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
															.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaCTT().contains(maCTT)) {
												list.add(ctt);
											}
										}
									}
								}
							}
						}
					} else {
						if (!maKH.equalsIgnoreCase("Mã khách hàng")) {
							if (!tenKH.equalsIgnoreCase("Tên khách hàng")) {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH)
													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}

									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH) && KhachHangBUS.getIntance()
													.layTenBangMa(ctt.getMaKH()).contains(tenKH)
													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH)
													&& KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH())
															.contains(tenKH)
													&& NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
															.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH) && KhachHangBUS.getIntance()
													.layTenBangMa(ctt.getMaKH()).contains(tenKH)) {
												list.add(ctt);
											}
										}
									}
								}
							} else {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH)

													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH)

													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH) && NhanVienBUS.getIntance()
													.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaKH().contains(maKH)) {
												list.add(ctt);
											}
										}
									}
								}

							}
						} else {
							if (!tenKH.equalsIgnoreCase("Tên khách hàng")) {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH()).contains(tenKH)
													&& ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
															.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH()).contains(tenKH)
													&& ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH()).contains(tenKH)
													&& NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
															.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (KhachHangBUS.getIntance().layTenBangMa(ctt.getMaKH()).contains(tenKH)) {
												list.add(ctt);
											}
										}
									}
								}

							} else {
								if (!maNV.equalsIgnoreCase("Mã nhân viên")) {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaNV().contains(maNV) && NhanVienBUS.getIntance()
													.layTenNVtheoMA(ctt.getMaNV()).contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (ctt.getMaNV().contains(maNV)) {
												list.add(ctt);
											}
										}
									}
								} else {
									if (!tenNV.equalsIgnoreCase("Tên nhân viên")) {
										for (ChiTietThueDTO ctt : ChiTietThueBUS.getInstance().getList()) {
											if (NhanVienBUS.getIntance().layTenNVtheoMA(ctt.getMaNV())
													.contains(tenNV)) {
												list.add(ctt);
											}
										}
									} else {
										xuLySuKienNutRefresh();
									}
								}
							}
						}
					}

				}
				delTableHoaDon();
				truyenDataSearch(list);
			}

		});
	}
}
