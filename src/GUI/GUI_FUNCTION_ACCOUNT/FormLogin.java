package GUI.GUI_FUNCTION_ACCOUNT;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import GUI.GUI_BASIC.ManagerGUI;
import GUI.GUI_BASIC.ReceptionistGUI;
import GUI.GUI_TaiKhoan.FrameQLTaiKhoan;
import GUI.ThongBaoDialog;
import GUI.mainGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FormLogin {

    private JFrame frBackground = new JFrame("QUẢN LÝ KHÁCH SẠN");
    private JLabel lbTitle = new JLabel("MÀN HÌNH ĐĂNG NHẬP", JLabel.CENTER);
    private JLabel lbBackground = new JLabel();
    private JPanel pnInput = new JPanel();
    private JLabel pnTitle = new JLabel("Đăng nhập", JLabel.CENTER);
    private JLabel lbUser = new JLabel("Tài khoản:");
    private JTextField txtUser = new JTextField();
    private JLabel lbPass = new JLabel("Mật khẩu:");
    private JPasswordField txtPass = new JPasswordField();
    private JButton btnLogin = new JButton("Đăng nhập");
    private JLabel lbChance = new JLabel("Đổi mật khẩu", JLabel.CENTER);
    private JButton btnAnPass = new JButton();

    private Font font20b = new Font("Times New Roman", Font.BOLD, 20);
    private Font font25b = new Font("Times New Roman", Font.BOLD, 25);
    private Font font18b = new Font("Times New Roman", Font.BOLD, 18);
    private Font font18 = new Font("Times New Roman", Font.PLAIN, 18);
    private Font font13 = new Font("Times New Roman", Font.PLAIN, 13);
    NhanVienDTO nhanVienDTO = new NhanVienDTO();

    public void initComponents() {
        // x=900, y= 600
        frBackground.setTitle("Đăng nhập hệ thống");
        frBackground.setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        frBackground.setSize(1014, 637);
        frBackground.setResizable(false);
        frBackground.setVisible(true);
        frBackground.setLocationRelativeTo(null);
        frBackground.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frBackground.setLayout(null);
        frBackground.getContentPane().setBackground(Color.white);

        frBackground.add(lbBackground);
        frBackground.add(pnInput);
        frBackground.add(lbTitle);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/new.png")).getImage().getScaledInstance(550, 400, Image.SCALE_SMOOTH));
        lbBackground.setBackground(Color.white);
        lbBackground.setBounds(50, 100, 500, 400);
        lbBackground.setOpaque(true);
        lbBackground.setIcon(imageIcon);

        pnInput.setBounds(550, 100, 400, 400);
        pnInput.setLayout(null);
        pnInput.setBackground(Color.white);

        pnInput.add(pnTitle);
        pnInput.add(lbUser);
        pnInput.add(lbPass);
        pnInput.add(txtUser);
        pnInput.add(txtPass);
        pnInput.add(btnLogin);
        pnInput.add(lbChance);
        pnInput.add(btnAnPass);

        lbTitle.setBounds(0, 30, 1000, 30);
        lbTitle.setFont(font20b);

        pnTitle.setBounds(0, 30, 400, 30);
        pnTitle.setFont(font25b);
        pnTitle.setForeground(new Color(0, 0, 153));

        lbUser.setBounds(50, 100, 100, 50);
        lbUser.setFont(font18b);
        lbUser.setBackground(Color.white);
        lbUser.setOpaque(true);

        lbPass.setBounds(50, 160, 100, 50);
        lbPass.setFont(font18b);
        lbPass.setOpaque(true);
        lbPass.setBackground(Color.white);

        txtUser.setBounds(150, 105, 200, 40);
        txtUser.setFont(font18);
        txtUser.setMargin(new Insets(10, 10, 10, 10));

        txtPass.setBounds(150, 165, 200, 40);
        txtPass.setFont(font18);
        txtPass.setMargin(new Insets(10, 10, 10, 10));

        lbChance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frBackground.dispose();
                new FormChangeAccount();
            }
        });

        btnAnPass.setBounds(352, 165, 40, 40);
        btnAnPass.setPreferredSize(new Dimension(40, 40));
        btnAnPass.setMaximumSize(new Dimension(70, 40));

        ImageIcon iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/hien.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        btnAnPass.setIcon(iconAdd);
        btnAnPass.setOpaque(false);
        btnAnPass.setContentAreaFilled(false);
        btnAnPass.setBorderPainted(false);
        btnAnPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi người dùng nhấn nút
                ImageIcon iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/hien.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                btnAnPass.setIcon(iconAdd);
                char echoChar = txtPass.getEchoChar();
                if (echoChar == 0) {
                    txtPass.setEchoChar('•');
                    iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/hien.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                    btnAnPass.setIcon(iconAdd);
                } else {
                    txtPass.setEchoChar((char) 0);
                    iconAdd = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/an.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                    btnAnPass.setIcon(iconAdd);
                }
            }
        });

        btnLogin.setBounds(50, 250, 300, 40);
        btnLogin.setBorder(null);
        btnLogin.setBackground(Color.white);
        btnLogin.setBackground(new Color(0, 0, 102));
        btnLogin.setForeground(Color.white);
        btnLogin.setFont(font18);

        lbChance.setBounds(50, 300, 300, 50);
        lbChance.setForeground(new Color(102, 102, 255));
        lbChance.setFont(font13);

        //bấm nút login để thực hiện hàm login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginFunction();
                } catch (IOException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Enter để thực hiện hàm login
        txtPass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10)
                    try {
                    LoginFunction();
                } catch (IOException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        //Enter để thực hiện hàm login
        txtUser.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10)
                    try {
                    LoginFunction();
                } catch (IOException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        //tự focus con trỏ vào khi mở loginUI
        txtUser.requestFocus();
    }

    //kiểm tra xem người dùng có bỏ không nhập hay không
    public boolean checkNull() {
        String infor = "";
        if (txtUser.getText().trim().length() == 0) {
            infor += "Tài khoản không được để trống\n";
            JOptionPane.showMessageDialog(frBackground, infor, "Báo lỗi", 0);
            return false;
        }
        String pass = new String(txtPass.getPassword());
        if (pass.trim().length() == 0) {
            infor += "Mật khẩu không được để trống";
            JOptionPane.showMessageDialog(frBackground, infor, "Báo lỗi", 0);
            return false;
        }
        return true;
    }

    //kiểm tra xem tài khoản có trong DB không
    public boolean checkTK(ArrayList<TaiKhoanDTO> list, String tk) {
        for (TaiKhoanDTO s : list) {
            if (s.getTaiKhoan().equals(tk)) {
                return true;
            }
        }
        return false;
    }

    //check Tk và Mk trong DB
    public boolean checkMK(ArrayList<TaiKhoanDTO> list, String tk, String mk) throws NoSuchAlgorithmException {
        for (TaiKhoanDTO s : list) {
            if (s.getTaiKhoan().equals(tk)) {
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                byte[] data = mk.getBytes();
                byte[] data2 = md.digest(data);
                StringBuilder sb = new StringBuilder();
                for (byte b : data2) {
                    sb.append(String.format("%02x", b));
                }
                String matKhau = sb.toString();
                if (matKhau.equals(s.getMatKhau())) {
                    return true;
                }
            }
        }
        return false;
    }

    //check chức vụ
    public String checkRole(ArrayList<TaiKhoanDTO> list, String tk) {
        String role = "";
        for (TaiKhoanDTO s : list) {
            if (s.getTaiKhoan().equals(tk)) {
                role = s.getVaiTro();
                break;
            }
        }
        return role;
    }

    //check tài khoản có bị khóa hay không
    public boolean checkLock(ArrayList<TaiKhoanDTO> list, String tk) {
        for (TaiKhoanDTO s : list) {
            if (s.getTaiKhoan().equals(tk)) {
                if (s.getTinhTrang() == 1) {
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
    //check nhân viên đã bị xóa chưa

    public boolean checkNhanVien(ArrayList<TaiKhoanDTO> list, String tk) {
        for (TaiKhoanDTO s : list) {
            if (s.getTaiKhoan().equals(tk)) {
                NhanVienDTO nhanVien = NhanVienBUS.getNV(s.getMaNV().trim());
                if (nhanVien.getXuLy() == 1) {
                    return true;
                } else {
                    nhanVienDTO = nhanVien;
                    break;
                }
            }
        }
        return false;
    }

    //Hàm đăng nhập
    public void LoginFunction() throws IOException, NoSuchAlgorithmException {
        if (checkNull()) {
            String pass = new String(txtPass.getPassword());
            ArrayList<TaiKhoanDTO> list = TaiKhoanBUS.getAllList();
            if (checkTK(list, txtUser.getText()) == false) {
                new ThongBaoDialog("Tài khoản không tồn tại", 1);
            } else if (checkMK(list, txtUser.getText(), pass)) {
                if (checkLock(list, txtUser.getText())) {
                    new ThongBaoDialog("Tài khoản này đang bị khóa vui lòng liên hệ quản trị viên để giải quyết", 1);
                } else {
                    if (checkRole(list, txtUser.getText()).equals("Admin")) {
                        frBackground.dispose();
                        FrameQLTaiKhoan admin = new FrameQLTaiKhoan();
                        admin.setVisible(true);
                    } else {
                        if (checkNhanVien(list, txtUser.getText())) {
                            new ThongBaoDialog("Nhân viên sở hữu tài khoản này đã bị xóa", 1);
                        } else {
                            if (checkRole(list, txtUser.getText()).equals("Manager")) {
                                mainGUI.nv = nhanVienDTO;
                                frBackground.dispose();
                                new ManagerGUI();
                            } else {
                                mainGUI.nv = nhanVienDTO;
                                frBackground.dispose();
                                new ReceptionistGUI();
                            }
                        }
                    }
                }
            } else {
                new ThongBaoDialog("Sai mật khẩu", 1);
            }
        }
    }

    public FormLogin() {
        initComponents();
    }
}
