package GUI.GUI_PHONG;

import BUS.PhongBUS;
import DTO.PhongDTO;
import GUI.GUI_BASIC.ReceptionistGUI;
import GUI.ThongBaoDialog;
import GUI.GUI_DATPHONG.DatPhongNew;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ItemCellRoom extends JPanel {

    JPanel pnTTleft = new JPanel();
    JPanel pnTTright = new JPanel();
    private PhongDTO phong;
    private Font fontTable = new Font("Tahoma", Font.BOLD, 13);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);

    public ItemCellRoom(PhongDTO phong, ReceptionistGUI receptionistGUI, SoDoPhongGUI soDoPhongGUI) {
        this.phong = phong;
        initComponents(phong, receptionistGUI, soDoPhongGUI);
    }

    public void initComponents(PhongDTO phong, ReceptionistGUI receptionistGUI, SoDoPhongGUI soDoPhongGUI) {
        JLabel lbP, lbL, lbCT, lbG, lbTT, lbTime, lbDate;
        setLayout(new BorderLayout());
        lbP = new JLabel(phong.getTenP(), JLabel.CENTER);
        lbP.setFont(sgUI15);
        lbP.setForeground(Color.white);
        add(lbP, BorderLayout.NORTH);

        if (phong.getTinhTrang() == 1) {
            lbTT = new JLabel("Có khách");
            lbTT.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/coKhach.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
            lbTT.setFont(fontTable);
            lbTT.setForeground(Color.black);
        } else {
            lbTT = new JLabel("Phòng trống");
            lbTT.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/khongKhach.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
            lbTT.setFont(fontTable);
            lbTT.setForeground(Color.black);
        }

        if (phong.getChiTietLoaiP().equals("Phòng đôi")) {
            lbCT = new JLabel("Phòng đôi", JLabel.LEFT);
            lbCT.setFont(fontTable);
            lbCT.setForeground(Color.decode("#FF007F"));
        } else if (phong.getChiTietLoaiP().equals("Phòng gia đình")) {
            lbCT = new JLabel("Phòng gia đình", JLabel.LEFT);
            lbCT.setFont(fontTable);
            lbCT.setForeground(Color.decode("#FF0000"));
        } else {
            lbCT = new JLabel("Phòng đơn", JLabel.LEFT);
            lbCT.setFont(fontTable);
            lbCT.setForeground(Color.decode("#7F00FF"));
        }
        if (phong.getLoaiP().equals("VIP")) {
            lbL = new JLabel("Phòng VIP", JLabel.CENTER);
            lbL.setFont(fontTable);
            lbL.setForeground(Color.white);

        } else {
            lbL = new JLabel("Phòng Thường", JLabel.CENTER);
            lbL.setFont(fontTable);
            lbL.setForeground(Color.white);
        }
        lbG = new JLabel(dcf.format(phong.getGiaP()) + " VND", JLabel.CENTER);
        lbG.setFont(fontTable);
        lbG.setForeground(Color.decode("#FFFFFF"));
        pnTTleft = new JPanel();
        pnTTleft.setLayout(new BoxLayout(pnTTleft, BoxLayout.Y_AXIS));
        pnTTleft.add(lbTT);
        pnTTleft.add(Box.createVerticalStrut(10));
        pnTTleft.add(lbCT);
        pnTTleft.add(Box.createVerticalStrut(10));
        pnTTleft.add(lbL);
        pnTTleft.add(Box.createVerticalStrut(10));
        pnTTleft.add(lbG);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbTime = new JLabel();
        lbTime.setFont(fontTable);
        lbDate = new JLabel();
        lbDate.setFont(fontTable);
        DateTimeDisplay(lbDate, lbTime);

        pnTTright = new JPanel();
        pnTTright.setLayout(new BoxLayout(pnTTright, BoxLayout.Y_AXIS));
        pnTTright.add(Box.createVerticalStrut(50));
        pnTTright.add(lbDate);
        pnTTright.add(lbTime);
        add(pnTTleft, BorderLayout.WEST);
        add(pnTTright, BorderLayout.EAST);
        setBorder(new EmptyBorder(5, 5, 5, 5));

        switch (phong.getTinhTrang()) {
            case 2:
                setBackground(Color.decode("#f1c40f"));
                break;
            case 1:
                setBackground(Color.decode("#e74c3c"));
                break;
            default:
                setBackground(Color.decode("#2ecc71"));
                break;
        }
        pnTTleft.setBackground(getBackground());
        pnTTright.setBackground(getBackground());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem menuItemXemtt = new JMenuItem("Xem thông tin phòng");
                    JMenuItem menuItemDatPhong = new JMenuItem("Đặt phòng");
                    JMenuItem menuItemDonPhong = new JMenuItem("Dọn phòng");
                    popupMenu.add(menuItemXemtt);
                    popupMenu.add(menuItemDatPhong);
                    popupMenu.add(menuItemDonPhong);
                    popupMenu.setBackground(Color.white);
                    popupMenu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));

                    menuItemXemtt.setBackground(Color.white);
                    menuItemXemtt.setFont(sgUI15p);

                    menuItemDatPhong.setBackground(Color.white);
                    menuItemDatPhong.setFont(sgUI15p);

                    menuItemDonPhong.setBackground(Color.white);
                    menuItemDonPhong.setFont(sgUI15p);
//                    miInfo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/nhanvien.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
//                    miLogOut.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    menuItemDatPhong.setBorder(new EmptyBorder(5, 0, 5, 5));
                    menuItemDonPhong.setBorder(new EmptyBorder(5, 0, 5, 5));
                    menuItemXemtt.setBorder(new EmptyBorder(5, 0, 5, 5));

                    if (phong.getTinhTrang() == 2) {
                        menuItemDonPhong.setEnabled(true);
                        menuItemDatPhong.setEnabled(false);
                    }
                    if (phong.getTinhTrang() == 1) {
                        menuItemDatPhong.setEnabled(false);
                        menuItemDonPhong.setEnabled(false);
                    }
                    if (phong.getTinhTrang() == 0) {
                        menuItemDatPhong.setEnabled(true);
                        menuItemDonPhong.setEnabled(false);
                    }
                    popupMenu.show(ItemCellRoom.this, e.getX(), e.getY());

                    menuItemDatPhong.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                            if (soDoPhongGUI.rdNgay.isEnabled() == false) {
                                if (soDoPhongGUI.rdNgay.isSelected() || soDoPhongGUI.rdGio.isSelected() || soDoPhongGUI.rdKhac.isSelected()) {
                                    DateTimeFormatter dateTimeFormatCheck = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                    if (soDoPhongGUI.rdNgay.isSelected()) {
                                        if (soDoPhongGUI.dateThue.getDate() == null) {
                                            new ThongBaoDialog("Vui lòng nhập ngày thuê", 1);
                                            soDoPhongGUI.editorThue.requestFocus();
                                        } else {
                                            Calendar cd = Calendar.getInstance();
                                            cd.setTime(soDoPhongGUI.dateThue.getDate());
                                            LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), soDoPhongGUI.timeThue.getHour(), soDoPhongGUI.timeThue.getMinute(), 0);
                                            LocalDateTime dateNow = LocalDateTime.now();
                                            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                            if (dateTimeThue.isAfter(dateNow)) {
                                                if (soDoPhongGUI.dateTra.getDate() == null) {
                                                    new ThongBaoDialog("Vui lòng nhập ngày trả", 1);
                                                    soDoPhongGUI.editorTra.requestFocus();
                                                } else {
                                                    soDoPhongGUI.timeTra.setHour(soDoPhongGUI.timeThue.getHour());
                                                    soDoPhongGUI.timeTra.setMinute(soDoPhongGUI.timeThue.getMinute());
                                                    Calendar cdTra = Calendar.getInstance();
                                                    cdTra.setTime(soDoPhongGUI.dateTra.getDate());
                                                    LocalDateTime dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), soDoPhongGUI.timeTra.getHour(), soDoPhongGUI.timeTra.getMinute(), 0);
                                                    if (dateTimeTra.isAfter(dateTimeThue)) {
                                                        dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), soDoPhongGUI.timeThue.getHour() - 2, soDoPhongGUI.timeThue.getMinute(), 0);
                                                        dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), soDoPhongGUI.timeTra.getHour(), soDoPhongGUI.timeTra.getMinute(), 0);
                                                        String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                                        String dateTimeTrastr = dateTimeTra.format(dateTimeFormatCheck);

                                                        int subDate = (int) ChronoUnit.DAYS.between(dateTimeThue, dateTimeTra);
                                                        Object[] data = {phong.getMaP(), phong.getTenP(), "Đang xử lý", "Theo Ngày", dateTimeThue.format(dateTimeFormat), dateTimeTra.format(dateTimeFormat), dcf.format(phong.getGiaP()), dcf.format((subDate * phong.getGiaP()))};

                                                        receptionistGUI.pnCenterContent.removeAll();
                                                        receptionistGUI.pnCenterContent.revalidate();
                                                        receptionistGUI.pnCenterContent.repaint();
                                                        receptionistGUI.pnCenterContent.add(new DatPhongNew(data), BorderLayout.CENTER);

                                                    } else {
                                                        new ThongBaoDialog("Vui lòng nhập ngày giờ trả phải hơn ngày thuê", 1);
                                                    }
                                                }
                                            } else {
                                                new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                                            }
                                        }
                                    } else if (soDoPhongGUI.rdGio.isSelected()) {
                                        if (soDoPhongGUI.dateThue.getDate() == null) {
                                            new ThongBaoDialog("Vui lòng nhập ngày thuê", 1);
                                            soDoPhongGUI.editorThue.requestFocus();
                                        } else {
                                            Calendar cd = Calendar.getInstance();
                                            cd.setTime(soDoPhongGUI.dateThue.getDate());
                                            LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), soDoPhongGUI.timeThue.getHour(), soDoPhongGUI.timeThue.getMinute(), 0);
                                            LocalDateTime dateNow = LocalDateTime.now();
                                            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                            if (dateTimeThue.isAfter(dateNow)) {
                                                if (soDoPhongGUI.dateTra.getDate() == null) {
                                                    new ThongBaoDialog("Vui lòng nhập ngày trả", 1);
                                                    soDoPhongGUI.editorTra.requestFocus();
                                                } else {
                                                    Calendar cdTra = Calendar.getInstance();
                                                    cdTra.setTime(soDoPhongGUI.dateTra.getDate());
                                                    LocalDateTime dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), soDoPhongGUI.timeTra.getHour(), soDoPhongGUI.timeTra.getMinute(), 0);
                                                    if (dateTimeTra.isAfter(dateTimeThue)) {
                                                        int countHour = (int) ChronoUnit.HOURS.between(dateTimeThue, dateTimeTra);
                                                        if (countHour % 24 == 0 && countHour != 0) {
                                                            new ThongBaoDialog("Có vẻ bạn muốn thuê phòng theo ngày vui lòng cân nhắc", 1);
                                                        } else if (countHour == 0) {
                                                            new ThongBaoDialog("Không thể thuê phòng ít hơn 1 giờ", 1);
                                                        } else {
                                                            dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), soDoPhongGUI.timeThue.getHour() - 2, soDoPhongGUI.timeThue.getMinute(), 0);
                                                            dateTimeTra = LocalDateTime.of(cdTra.get(Calendar.YEAR), cdTra.get(Calendar.MONTH) + 1, cdTra.get(Calendar.DATE), soDoPhongGUI.timeTra.getHour(), soDoPhongGUI.timeTra.getMinute(), 0);
                                                            String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                                            String dateTimeTrastr = dateTimeTra.format(dateTimeFormatCheck);

                                                            int gia = 0;
                                                            if (countHour <= 24) {
                                                                if (countHour == 1) {
                                                                    gia = phong.getGiaP() * 15 / 100;
                                                                } else if (countHour == 2) {
                                                                    gia = phong.getGiaP() * 20 / 100;
                                                                } else if (countHour == 3) {
                                                                    gia = phong.getGiaP() * 30 / 100;
                                                                } else if (countHour > 3 && countHour <= 12) {
                                                                    gia = phong.getGiaP() / 2;
                                                                } else {
                                                                    gia = phong.getGiaP();
                                                                }
                                                            } else {
                                                                gia = (countHour / 24) * phong.getGiaP();
                                                                if (countHour % 24 == 1) {
                                                                    gia += phong.getGiaP() * 15 / 100;
                                                                } else if (countHour % 24 == 2) {
                                                                    gia += phong.getGiaP() * 20 / 100;
                                                                } else if (countHour % 24 == 3) {
                                                                    gia += phong.getGiaP() * 30 / 100;
                                                                } else if (countHour % 24 > 3 && countHour % 24 <= 12) {
                                                                    gia += phong.getGiaP() / 2;
                                                                } else {
                                                                    gia += phong.getGiaP();
                                                                }
                                                            }
                                                            Object[] data = {phong.getMaP(), phong.getTenP(), "Đang xử lý", "Theo Ngày", dateTimeThue.format(dateTimeFormat), dateTimeTra.format(dateTimeFormat), dcf.format(phong.getGiaP()), dcf.format(gia)};

                                                            receptionistGUI.pnCenterContent.removeAll();
                                                            receptionistGUI.pnCenterContent.revalidate();
                                                            receptionistGUI.pnCenterContent.repaint();
                                                            receptionistGUI.pnCenterContent.add(new DatPhongNew(data), BorderLayout.CENTER);

                                                        }
                                                    } else {
                                                        new ThongBaoDialog("Vui lòng nhập ngày giờ trả phải hơn ngày thuê", 1);
                                                    }
                                                }
                                            } else {
                                                new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                                            }
                                        }
                                    } else if (soDoPhongGUI.rdKhac.isSelected()) {
                                        if (soDoPhongGUI.dateThue.getDate() == null) {
                                            new ThongBaoDialog("Vui lòng nhập ngày thuê", 1);
                                            soDoPhongGUI.editorThue.requestFocus();
                                        } else {
                                            Calendar cd = Calendar.getInstance();
                                            cd.setTime(soDoPhongGUI.dateThue.getDate());
                                            LocalDateTime dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), soDoPhongGUI.timeThue.getHour(), soDoPhongGUI.timeThue.getMinute(), 0);
                                            LocalDateTime dateNow = LocalDateTime.now();
                                            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                            if (dateTimeThue.isAfter(dateNow)) {
                                                dateTimeThue = LocalDateTime.of(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH) + 1, cd.get(Calendar.DATE), soDoPhongGUI.timeThue.getHour() - 2, soDoPhongGUI.timeThue.getMinute(), 0);
                                                String dateTimeThuestr = dateTimeThue.format(dateTimeFormatCheck);
                                                ArrayList<PhongDTO> listP = PhongBUS.getListP(dateTimeThuestr, "", false);

                                                Object[] data = {phong.getMaP(), phong.getTenP(), "Đang xử lý", "Khác", dateTimeThue.format(dateTimeFormat), "Chưa xác định", dcf.format(phong.getGiaP()), "Chưa tính"};
                                                receptionistGUI.pnCenterContent.removeAll();
                                                receptionistGUI.pnCenterContent.revalidate();
                                                receptionistGUI.pnCenterContent.repaint();
                                                receptionistGUI.pnCenterContent.add(new DatPhongNew(data), BorderLayout.CENTER);

                                            } else {
                                                new ThongBaoDialog("Vui lòng nhập ngày giờ thuê phải hơn ngày hiện tại", 1);
                                            }
                                        }
                                    }
                                } else {
                                    new ThongBaoDialog("Vui lòng chọn loại hình thuê", 1);
                                }
                            } else {
                                new ThongBaoDialog("Vui lòng nhấn nút chọn phòng", 1);
                            }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                        }
                    });
                    menuItemDonPhong.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc đã dọn phòng này", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (ans == JOptionPane.YES_OPTION) {
                                if (PhongBUS.updateTT(phong.getMaP(), 0)) {
                                    new ThongBaoDialog("Đã xác nhận dọn phòng", 2);
                                    phong.setTinhTrang(0);
                                    resetBackground();
                                } else {
                                    new ThongBaoDialog("Dọn phòng không thành công", 1);
                                }
                            }
                        }
                    });
                    menuItemXemtt.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new FormChiTietPhong(0, phong.getMaP());
                        }
                    });
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                switch (phong.getTinhTrang()) {
                    case 2:
                        setBackground(Color.decode("#F7E59A"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    case 1:
                        setBackground(Color.decode("#F59489"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    default:
                        setBackground(Color.decode("#56F59B"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                switch (phong.getTinhTrang()) {
                    case 2:
                        setBackground(Color.decode("#f1c40f"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    case 1:
                        setBackground(Color.decode("#e74c3c"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    default:
                        setBackground(Color.decode("#2ecc71"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                }
            }
        });
    }

    public ItemCellRoom(PhongDTO phong, DatPhongNew datPhongNew, int tt, LocalDateTime dateTimeThue, LocalDateTime dateTimeTra, SoDoPhongReceptionist soDoPhongReceptionist) {
        this.phong = phong;
        initComponents(phong, datPhongNew, tt, dateTimeThue, dateTimeTra, soDoPhongReceptionist);
    }

    public void initComponents(PhongDTO phong, DatPhongNew datPhongNew, int tt, LocalDateTime dateTimeThue, LocalDateTime dateTimeTra, SoDoPhongReceptionist soDoPhongReceptionist) {
        JLabel lbP, lbL, lbCT, lbG, lbTT, lbTime, lbDate;
        setLayout(new BorderLayout());
        lbP = new JLabel(phong.getTenP(), JLabel.CENTER);
        lbP.setFont(sgUI15);
        lbP.setForeground(Color.white);
        add(lbP, BorderLayout.NORTH);

        if (phong.getTinhTrang() == 1) {
            lbTT = new JLabel("Có khách");
            lbTT.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/coKhach.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
            lbTT.setFont(fontTable);
            lbTT.setForeground(Color.black);
        } else {
            lbTT = new JLabel("Phòng trống");
            lbTT.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/khongKhach.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
            lbTT.setFont(fontTable);
            lbTT.setForeground(Color.black);
        }

        if (phong.getChiTietLoaiP().equals("Phòng đôi")) {
            lbCT = new JLabel("Phòng đôi", JLabel.LEFT);
            lbCT.setFont(fontTable);
            lbCT.setForeground(Color.decode("#FF007F"));
        } else if (phong.getChiTietLoaiP().equals("Phòng gia đình")) {
            lbCT = new JLabel("Phòng gia đình", JLabel.LEFT);
            lbCT.setFont(fontTable);
            lbCT.setForeground(Color.decode("#FF0000"));
        } else {
            lbCT = new JLabel("Phòng đơn", JLabel.LEFT);
            lbCT.setFont(fontTable);
            lbCT.setForeground(Color.decode("#7F00FF"));
        }
        if (phong.getLoaiP().equals("VIP")) {
            lbL = new JLabel("Phòng VIP", JLabel.CENTER);
            lbL.setFont(fontTable);
            lbL.setForeground(Color.white);

        } else {
            lbL = new JLabel("Phòng Thường", JLabel.CENTER);
            lbL.setFont(fontTable);
            lbL.setForeground(Color.white);
        }
        lbG = new JLabel(dcf.format(phong.getGiaP()) + " VND", JLabel.CENTER);
        lbG.setFont(fontTable);
        lbG.setForeground(Color.decode("#FFFFFF"));
        pnTTleft = new JPanel();
        pnTTleft.setLayout(new BoxLayout(pnTTleft, BoxLayout.Y_AXIS));
        pnTTleft.add(lbTT);
        pnTTleft.add(Box.createVerticalStrut(10));
        pnTTleft.add(lbCT);
        pnTTleft.add(Box.createVerticalStrut(10));
        pnTTleft.add(lbL);
        pnTTleft.add(Box.createVerticalStrut(10));
        pnTTleft.add(lbG);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbTime = new JLabel();
        lbTime.setFont(fontTable);
        lbDate = new JLabel();
        lbDate.setFont(fontTable);
        DateTimeDisplay(lbDate, lbTime);

        pnTTright = new JPanel();
        pnTTright.setLayout(new BoxLayout(pnTTright, BoxLayout.Y_AXIS));
        pnTTright.add(Box.createVerticalStrut(50));
        pnTTright.add(lbDate);
        pnTTright.add(lbTime);
        add(pnTTleft, BorderLayout.WEST);
        add(pnTTright, BorderLayout.EAST);
        setBorder(new EmptyBorder(5, 5, 5, 5));

        switch (phong.getTinhTrang()) {
            case 2:
                setBackground(Color.decode("#f1c40f"));
                break;
            case 1:
                setBackground(Color.decode("#e74c3c"));
                break;
            default:
                setBackground(Color.decode("#2ecc71"));
                break;
        }
        pnTTleft.setBackground(getBackground());
        pnTTright.setBackground(getBackground());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem menuItemXemtt = new JMenuItem("Xem thông tin phòng");
                    JMenuItem menuItemDatPhong = new JMenuItem("Đặt phòng");
                    popupMenu.add(menuItemXemtt);
                    popupMenu.add(menuItemDatPhong);
                    popupMenu.setBackground(Color.white);
                    popupMenu.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EEEEEE")), new EmptyBorder(5, 5, 5, 5)));

                    menuItemXemtt.setBackground(Color.white);
                    menuItemXemtt.setFont(sgUI15p);

                    menuItemDatPhong.setBackground(Color.white);
                    menuItemDatPhong.setFont(sgUI15p);

//                    miInfo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/nhanvien.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
//                    miLogOut.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    menuItemDatPhong.setBorder(new EmptyBorder(5, 0, 5, 5));
                    menuItemXemtt.setBorder(new EmptyBorder(5, 0, 5, 5));

                    if (phong.getTinhTrang() == 2) {
                        menuItemDatPhong.setEnabled(false);
                    }
                    if (phong.getTinhTrang() == 1) {
                        menuItemDatPhong.setEnabled(false);
                    }
                    if (phong.getTinhTrang() == 0) {
                        menuItemDatPhong.setEnabled(true);
                    }
                    popupMenu.show(ItemCellRoom.this, e.getX(), e.getY());

                    menuItemDatPhong.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            switch (tt) {
                                case 0: {
                                    int subDate = (int) ChronoUnit.DAYS.between(dateTimeThue, dateTimeTra);
                                    Object[] data = {phong.getMaP(), phong.getTenP(), "Đang xử lý", "Theo Ngày", dateTimeThue.format(dateTimeFormat), dateTimeTra.format(dateTimeFormat), dcf.format(phong.getGiaP()), dcf.format((subDate * phong.getGiaP()))};
                                    datPhongNew.listPT.add(data);
                                    datPhongNew.tbPhongThue.renderTB(datPhongNew.listPT);
                                    long total = 0;
                                    try {
                                        for (Object data1[] : datPhongNew.listPT) {
                                            total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
                                        }
                                    } catch (Exception ex) {
                                    }
                                    datPhongNew.txtTotal.setText(dcf.format(total));
                                    datPhongNew.pnThuePhongContentDSPTBottomTotal.revalidate();
                                    datPhongNew.pnThuePhongContentDSPTBottomTotal.repaint();
                                    soDoPhongReceptionist.dispose();
                                    break;
                                }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                case 1: {
                                    int gia = 0;
                                    int countHour = (int) ChronoUnit.HOURS.between(dateTimeThue, dateTimeTra);
                                    if (countHour <= 24) {
                                        if (countHour == 1) {
                                            gia = phong.getGiaP() * 15 / 100;
                                        } else if (countHour == 2) {
                                            gia = phong.getGiaP() * 20 / 100;
                                        } else if (countHour == 3) {
                                            gia = phong.getGiaP() * 30 / 100;
                                        } else if (countHour > 3 && countHour <= 12) {
                                            gia = phong.getGiaP() / 2;
                                        } else {
                                            gia = phong.getGiaP();
                                        }
                                    } else {
                                        gia = (countHour / 24) * phong.getGiaP();
                                        if (countHour % 24 == 1) {
                                            gia += phong.getGiaP() * 15 / 100;
                                        } else if (countHour % 24 == 2) {
                                            gia += phong.getGiaP() * 20 / 100;
                                        } else if (countHour % 24 == 3) {
                                            gia += phong.getGiaP() * 30 / 100;
                                        } else if (countHour % 24 > 3 && countHour % 24 <= 12) {
                                            gia += phong.getGiaP() / 2;
                                        } else {
                                            gia += phong.getGiaP();
                                        }
                                    }
                                    Object[] data = {phong.getMaP(), phong.getTenP(), "Đang xử lý", "Theo Ngày", dateTimeThue.format(dateTimeFormat), dateTimeTra.format(dateTimeFormat), dcf.format(phong.getGiaP()), dcf.format(gia)};
                                    datPhongNew.listPT.add(data);
                                    datPhongNew.tbPhongThue.renderTB(datPhongNew.listPT);
                                    long total = 0;
                                    try {
                                        for (Object data1[] : datPhongNew.listPT) {
                                            total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
                                        }
                                    } catch (Exception ex) {
                                    }
                                    datPhongNew.txtTotal.setText(dcf.format(total));
                                    datPhongNew.pnThuePhongContentDSPTBottomTotal.revalidate();
                                    datPhongNew.pnThuePhongContentDSPTBottomTotal.repaint();
                                    soDoPhongReceptionist.dispose();
                                    break;
                                }
                                case 2: {
                                    Object[] data = {phong.getMaP(), phong.getTenP(), "Đang xử lý", "Khác", dateTimeThue.format(dateTimeFormat), "Chưa xác định", dcf.format(phong.getGiaP()), "Chưa tính"};
                                    datPhongNew.listPT.add(data);
                                    datPhongNew.tbPhongThue.renderTB(datPhongNew.listPT);
                                    long total = 0;
                                    try {
                                        for (Object data1[] : datPhongNew.listPT) {
                                            total += (long) Integer.parseInt(((String) data1[7]).toString().split(" ")[0].replace(",", ""));
                                        }
                                    } catch (Exception ex) {
                                    }
                                    datPhongNew.txtTotal.setText(dcf.format(total));
                                    datPhongNew.pnThuePhongContentDSPTBottomTotal.revalidate();
                                    datPhongNew.pnThuePhongContentDSPTBottomTotal.repaint();    
                                    soDoPhongReceptionist.dispose();
                                    break;
                                }
                                default:
                                    break;
                            }
                        }
                    });
                    menuItemXemtt.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new FormChiTietPhong(0, phong.getMaP());
                        }
                    });
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                switch (phong.getTinhTrang()) {
                    case 2:
                        setBackground(Color.decode("#F7E59A"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    case 1:
                        setBackground(Color.decode("#F59489"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    default:
                        setBackground(Color.decode("#56F59B"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                switch (phong.getTinhTrang()) {
                    case 2:
                        setBackground(Color.decode("#f1c40f"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    case 1:
                        setBackground(Color.decode("#e74c3c"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                    default:
                        setBackground(Color.decode("#2ecc71"));
                        pnTTleft.setBackground(getBackground());
                        pnTTright.setBackground(getBackground());
                        break;
                }
            }
        });
    }

    public PhongDTO getPhong() {
        return phong;
    }

    public void setPhong(PhongDTO phong) {
        this.phong = phong;
    }

    public void DateTimeDisplay(JLabel dateLabel, JLabel timeLabel) {
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        // Tạo một Timer để cập nhật thời gian mỗi giây
        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTime(dateLabel, timeLabel);
            }
        });
        timer.start();
    }

    public void resetBackground() {
        switch (phong.getTinhTrang()) {
            case 2:
                setBackground(Color.decode("#f1c40f"));
                break;
            case 1:
                setBackground(Color.decode("#e74c3c"));
                break;
            default:
                setBackground(Color.decode("#2ecc71"));
                break;
        }
        pnTTleft.setBackground(getBackground());
        pnTTright.setBackground(getBackground());
    }

    private void updateDateTime(JLabel dateLabel, JLabel timeLabel) {
        // Lấy thời gian hiện tại
        Date now = new Date();

        // Định dạng ngày/tháng/năm
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd-MM-yyyy");
        String formattedDate = dateFormat.format(now);

        // Định dạng giờ/phút/giây
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(now);

        // Hiển thị ngày và giờ trên các JLabel tương ứng
        dateLabel.setText(formattedDate);
        timeLabel.setText(formattedTime);
    }

}
