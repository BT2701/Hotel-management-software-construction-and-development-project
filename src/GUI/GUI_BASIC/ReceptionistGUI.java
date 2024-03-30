package GUI.GUI_BASIC;

import GUI.GUI_DATPHONG.ChiTietThuePhongGUI;
import GUI.GUI_DICHVU.DisplayServiceReception;
import GUI.GUI_FUNCTION_ACCOUNT.FormChangeAccount;
import GUI.GUI_FUNCTION_ACCOUNT.FormLogin;
import GUI.GUI_HOADON.HoaDonGUI;
import GUI.GUI_HOME.PanelHome;
import GUI.GUI_KHACHHANG.PanelKhachHangReception;
import GUI.GUI_NHANVIEN.InformationForm;
import GUI.GUI_PHONG.SoDoPhongGUI;
import GUI.mainGUI;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class ReceptionistGUI extends JFrame {

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuMain = new JMenu("Trang chính");
    private JMenu menuBooking = new JMenu("Đặt phòng");
    JMenuItem mItemNew = new JMenuItem("Tạo mới thuê phòng");
    JMenuItem mItemList = new JMenuItem("Danh sách thuê phòng");
    JMenuItem mItemHome = new JMenuItem("Màn hình chính");
    JMenuItem mItemLogOut = new JMenuItem("Đăng xuất");
    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    JPanel pnContent = new JPanel();
    JPanel pnMenu = new JPanel();
    JButton btnPhong = new JButton("Sơ đồ phòng");
    JButton btnDichVu = new JButton("Danh sách Dịch vụ");
    JButton btnHoaDon = new JButton("Danh sách Hóa đơn");
    public static JButton btnDatPhong = new JButton("Danh sách đặt phòng");
    JButton btnKhachHang = new JButton("Danh sách Khách hàng");
    JPanel pnCenter = new JPanel();
    JPanel pnCenterTop = new JPanel();
    public JPanel pnCenterContent = new JPanel();
    JLabel lbInfo = new JLabel();
    JButton btnSettings = new JButton();
    public JPanel pnRight = new JPanel();
    Border bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0;

    ArrayList<JButton> listMenu = new ArrayList<>();
    JCalendar cd = new JCalendar();

    public ReceptionistGUI() {
        bdMatte2_2_2_2_efefef = new MatteBorder(2, 2, 2, 2, Color.decode("#efefef"));
        bdEmpty0_7_0_0 = new EmptyBorder(0, 3, 0, 0);
        initComponents();
    }

    public void initComponents() {

        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        UIManager.put("MenuItem.selectionBackground", Color.decode("#EEEEEE"));
        lbInfo.setText("Xin chào lễ tân:  " + mainGUI.nv.getMaNV().trim() + "  -  " + mainGUI.nv.getTenNV());
        ImageIcon iconSettings = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/caidat.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnSettings.setFocusPainted(false);
        btnSettings.setPreferredSize(new Dimension(30, 30));
        btnSettings.setMaximumSize(new Dimension(30, 30));
        btnSettings.setBackground(Color.white);
        btnSettings.setContentAreaFilled(false);
        btnSettings.setBorderPainted(false);
        btnSettings.setIcon(iconSettings);
        btnSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        setSize(1400, 800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("Phần mềm quản lý khách sạn");

        add(menuBar, BorderLayout.NORTH);
        menuBar.setBackground(Color.white);
        menuMain.setFont(sgUI13);
        menuMain.setBorder(new EmptyBorder(5, 5, 5, 5));
        menuBooking.setBorder(new EmptyBorder(5, 5, 5, 5));
        menuMain.getPopupMenu().setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));
        menuMain.getPopupMenu().setBackground(Color.white);
        menuBooking.setFont(sgUI13);
        menuBooking.getPopupMenu().setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));
        menuBooking.getPopupMenu().setBackground(Color.white);
        mItemNew.setFont(sgUI13);
        mItemNew.setBackground(Color.white);
        mItemList.setFont(sgUI13);
        mItemList.setBackground(Color.white);
        mItemHome.setFont(sgUI13);
        mItemHome.setBackground(Color.white);
        mItemLogOut.setFont(sgUI13);
        mItemLogOut.setBackground(Color.white);
        menuBooking.setBackground(Color.white);

        mItemHome.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/home.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        mItemLogOut.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        mItemNew.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/datphong.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        mItemList.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/empty.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

        menuBar.add(menuMain);
        menuBar.add(menuBooking);
        menuBooking.add(mItemNew);
        menuBooking.add(mItemList);
        mItemNew.setBorder(BorderFactory.createEmptyBorder());
        mItemHome.setBorder(BorderFactory.createEmptyBorder());
        mItemList.setBorder(BorderFactory.createEmptyBorder());
        mItemLogOut.setBorder(BorderFactory.createEmptyBorder());

        menuMain.add(mItemHome);
        menuMain.addSeparator();
        menuMain.add(mItemLogOut);

        mItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        mItemHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
        add(pnContent, BorderLayout.CENTER);
        pnContent.setBackground(Color.white);
        pnContent.setLayout(new BorderLayout());
        pnContent.add(pnMenu, BorderLayout.SOUTH);

        pnMenu.setBackground(Color.white);
        pnMenu.setBorder(new EmptyBorder(0, 10, 10, 10));
        pnMenu.setLayout(new GridLayout(1, 5, 10, 10));
        pnMenu.add(btnPhong);
        pnMenu.add(btnDichVu);
        pnMenu.add(btnKhachHang);
        pnMenu.add(btnDatPhong);
        pnMenu.add(btnHoaDon);

        ImageIcon iconPhong = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/phong.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnPhong.setIcon(iconPhong);
        btnPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPhong.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPhong.setFocusPainted(false);
        btnPhong.setFont(sgUI13b);

        ImageIcon iconDichVu = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/dichvu.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnDichVu.setIcon(iconDichVu);
        btnDichVu.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDichVu.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDichVu.setFocusPainted(false);
        btnDichVu.setFont(sgUI13b);
        ImageIcon iconKhachHang = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/khachhang.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnKhachHang.setIcon(iconKhachHang);
        btnKhachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
        btnKhachHang.setFocusPainted(false);
        btnKhachHang.setFont(sgUI13b);
        ImageIcon iconDatPhong = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/datphong.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnDatPhong.setIcon(iconDatPhong);
        btnDatPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnDatPhong.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDatPhong.setFocusPainted(false);
        btnDatPhong.setFont(sgUI13b);
        ImageIcon iconHoaDon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/thanhtoan.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnHoaDon.setIcon(iconHoaDon);
        btnHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
        btnHoaDon.setFocusPainted(false);
        btnHoaDon.setFont(sgUI13b);
        btnPhong.setBackground(Color.white);
        btnDatPhong.setBackground(Color.white);
        btnKhachHang.setBackground(Color.white);
        btnDichVu.setBackground(Color.white);
        btnHoaDon.setBackground(Color.white);

        pnContent.add(pnCenter, BorderLayout.CENTER);
        pnCenter.setBackground(Color.decode("#FAFAFA"));
        pnCenter.setLayout(new BorderLayout(5, 5));
        pnCenter.setBorder(new EmptyBorder(5, 10, 5, 10));
        pnCenter.add(pnCenterTop, BorderLayout.NORTH);
        pnCenter.add(pnCenterContent, BorderLayout.CENTER);
        pnCenter.add(pnRight, BorderLayout.EAST);
        pnRight.setLayout(new GridLayout(2, 1, 5, 5));
        pnRight.add(cd);
        ((JComboBox) cd.getMonthChooser().getComboBox()).setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new LineBorder(Color.white));
                return basicComboPopup;
            }
        });
        ((JComboBox) cd.getMonthChooser().getComboBox()).setBorder(BorderFactory.createCompoundBorder(bdMatte2_2_2_2_efefef, bdEmpty0_7_0_0));
        ((JComboBox) cd.getMonthChooser().getComboBox()).setFont(sgUI15);
        cd.setBackground(Color.decode("#FAFAFA"));
        pnRight.setMaximumSize(new Dimension(300, 300));
        pnRight.setPreferredSize(new Dimension(300, 300));

        pnCenterContent.setLayout(new BorderLayout());

        pnCenterTop.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        pnCenterTop.add(lbInfo);
        pnCenterTop.add(btnSettings);
        pnCenterContent.add(new PanelHome(1536, 700), BorderLayout.CENTER);
        lbInfo.setFont(sgUI15);
        pnCenterTop.setBackground(Color.decode("#FAFAFA"));
        pnCenterContent.setBackground(Color.decode("#FAFAFA"));
        pnRight.setBackground(Color.decode("#FAFAFA"));
        mItemHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnCenterContent.removeAll();
                pnCenterContent.revalidate();
                pnCenterContent.repaint();
                ResetBackground();
                pnCenterContent.add(new PanelHome(pnCenterContent.getWidth(), pnCenterContent.getHeight()), BorderLayout.CENTER);
                pnRight.setVisible(true);
            }
        });

        btnSettings.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JPopupMenu pm = new JPopupMenu();
                    pm.setBackground(Color.white);
                    pm.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));
                    JMenuItem miInfo = new JMenuItem("Xem thông tin cá nhân");
                    miInfo.setBackground(Color.white);
                    miInfo.setFont(sgUI15p);
                    JMenuItem miLogOut = new JMenuItem("Đăng xuất");
                    miLogOut.setBackground(Color.white);
                    miLogOut.setFont(sgUI15p);
                    JMenuItem miChangePass = new JMenuItem("Đổi mật khẩu");
                    miChangePass.setBackground(Color.white);
                    miChangePass.setFont(sgUI15p);
                    miInfo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/nhanvien.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    miLogOut.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    miChangePass.setBorder(new EmptyBorder(5, 0, 5, 5));
                    miLogOut.setBorder(BorderFactory.createEmptyBorder());
                    miInfo.setBorder(BorderFactory.createEmptyBorder());
                    pm.add(miInfo);
                    pm.add(miChangePass);
                    pm.addSeparator();
                    pm.add(miLogOut);
                    pm.show(btnSettings, btnSettings.getWidth(), btnSettings.getHeight());
                    miInfo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                new InformationForm();
                            } catch (ParseException ex) {
                            }
                        }
                    });
                    miChangePass.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                            new FormChangeAccount();
                        }
                    });
                    miLogOut.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (ans == JOptionPane.YES_OPTION) {
                                new FormLogin();
                                dispose();
                            }
                        }
                    });
                }
            }
        });

        setVisible(true);

        listMenu.add(btnPhong);
        listMenu.add(btnDichVu);
        listMenu.add(btnKhachHang);
        listMenu.add(btnDatPhong);
        listMenu.add(btnHoaDon);
        ResetBackground();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
                    new FormLogin();
                    dispose();
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
        mItemLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (ans == JOptionPane.YES_OPTION) {
                    new FormLogin();
                    dispose();
                }
            }
        });
        mItemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPhong.doClick();
            }
        });
        mItemList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDatPhong.doClick();
            }
        });
        actionMenu();
    }

    public void actionMenu() {
        for (JButton x : listMenu) {
            x.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ResetBackground();
                    x.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(3, 0, 0, 0, Color.decode("#127332")), new EmptyBorder(5, 10, 5, 10)));
                    x.setBackground(Color.decode("#D1FFE1"));
                    if (e.getSource() == btnPhong) {
                        pnCenterContent.removeAll();
                        pnCenterContent.revalidate();
                        pnCenterContent.repaint();
                        pnRight.setVisible(false);
                        pnCenterContent.add(new SoDoPhongGUI(ReceptionistGUI.this), BorderLayout.CENTER);
                    } else if (e.getSource() == btnDichVu) {
                        pnCenterContent.removeAll();
                        pnCenterContent.revalidate();
                        pnCenterContent.repaint();
                        pnRight.setVisible(false);
                        DisplayServiceReception displayService = new DisplayServiceReception();
                        displayService.lightDark(0);
                        pnCenterContent.add(displayService, BorderLayout.CENTER);
                    } else if (e.getSource() == btnDatPhong) {
                        pnCenterContent.removeAll();
                        pnCenterContent.revalidate();
                        pnCenterContent.repaint();
                        pnRight.setVisible(false);
                        pnCenterContent.add(new ChiTietThuePhongGUI(ReceptionistGUI.this), BorderLayout.CENTER);
                    } else if (e.getSource() == btnHoaDon) {
                        pnCenterContent.removeAll();
                        pnCenterContent.revalidate();
                        pnCenterContent.repaint();
                        pnRight.setVisible(false);
                        HoaDonGUI hd = new HoaDonGUI();
                        hd.lightDark(0);
                        pnCenterContent.add(hd, BorderLayout.CENTER);
                    } else if (e.getSource() == btnKhachHang) {
                        pnCenterContent.removeAll();
                        pnCenterContent.revalidate();
                        pnCenterContent.repaint();
                        pnRight.setVisible(false);
                        pnCenterContent.add(new PanelKhachHangReception(), BorderLayout.CENTER);
                    }
                }
            });
        }
    }

    public void ResetBackground() {
        for (JButton x : listMenu) {
            x.setBackground(Color.white);
            x.setBorder(new EmptyBorder(5, 10, 5, 10));
        }
    }
}
