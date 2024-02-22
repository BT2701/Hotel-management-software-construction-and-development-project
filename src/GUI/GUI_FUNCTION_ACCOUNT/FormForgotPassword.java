package GUI.GUI_FUNCTION_ACCOUNT;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class FormForgotPassword extends JFrame {

    private String otp;
    JLabel lbTitle = new JLabel("Màn hình quên mật khẩu");
    private Font font20b = new Font("Times New Roman", Font.BOLD, 20);
    private Font font25b = new Font("Times New Roman", Font.BOLD, 25);
    private Font font18b = new Font("Times New Roman", Font.BOLD, 18);
    private Font font18 = new Font("Times New Roman", Font.PLAIN, 18);
    private Font font13 = new Font("Times New Roman", Font.PLAIN, 13);
    CountdownLabel cd = new CountdownLabel(5);
    JLabel lbImg = new JLabel();
    JPanel pnInput = new JPanel();
    JLabel lbTop = new JLabel("Quên mật khẩu");
    JPanel pnBottom = new JPanel();
    JPanel pnCenter = new JPanel();
    JPanel pnTk = new JPanel();
    JLabel lbTk = new JLabel("Nhập tài khoản:");
    JTextField txtTk = new JTextField();
    JPanel pnOTP = new JPanel();
    JLabel lbOTP = new JLabel("Mã xác nhận");
    JPanel pnInputOTP = new JPanel();
    JButton btnGetCode = new JButton("Gửi mã");
    JTextField txtOTP = new JTextField();
    JPanel pnAcept = new JPanel();
    JButton btnAcept = new JButton("Xác nhận");
    JPanel pnLogin = new JPanel();
    JButton btnLogin = new JButton("Đăng nhập");
    JPanel pnChange = new JPanel();
    JButton btnChange = new JButton("Đổi mật khẩu");

    public FormForgotPassword() {
        initComponents();
    }

    public void initComponents() {
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);

        lbTitle.setBounds(350, 10, 300, 30);
        lbTitle.setFont(font25b);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/forgotpassword.jpg")).getImage().getScaledInstance(450, 500, Image.SCALE_SMOOTH));
        lbImg.setBounds(90, 60, 400, 500);
        lbImg.setIcon(imageIcon);
        add(lbTitle);
        add(lbImg);
        setVisible(true);
        setSize(1014, 637);
        setLocationRelativeTo(null);

        pnInput.setBounds(510, 150, 400, 300);
        pnInput.setBackground(Color.red);
        pnInput.setLayout(new BorderLayout());
        pnInput.add(lbTop, BorderLayout.NORTH);
        pnInput.add(pnCenter, BorderLayout.CENTER);
        pnInput.add(pnBottom, BorderLayout.SOUTH);
        pnInput.setBorder(new EmptyBorder(0, 50, 0, 50));

        lbTop.setHorizontalAlignment(JLabel.CENTER);
        lbTop.setFont(font25b);
        lbTop.setForeground(new Color(0, 0, 153));

        pnCenter.setLayout(new GridLayout(4, 1, 5, 5));
        pnCenter.add(pnTk);
        pnCenter.setBackground(Color.white);
        pnTk.setBackground(Color.white);
        pnTk.setLayout(new BorderLayout());
        pnTk.add(lbTk, BorderLayout.NORTH);
        pnTk.add(txtTk, BorderLayout.CENTER);
        pnCenter.add(pnOTP);
        add(cd);
        cd.setBounds(900, 330, 20, 20);
        pnOTP.setBackground(Color.white);
        pnOTP.setLayout(new BorderLayout());
        pnOTP.add(lbOTP, BorderLayout.NORTH);
        pnOTP.add(pnInputOTP, BorderLayout.CENTER);
        pnInputOTP.setLayout(new BorderLayout());
        pnInputOTP.add(txtOTP, BorderLayout.CENTER);
        pnInputOTP.add(btnGetCode, BorderLayout.EAST);
        btnGetCode.setBackground(Color.decode("#98FB98"));
        btnGetCode.setFocusPainted(false);
        btnGetCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run(btnGetCode, Color.decode("#90EE90"));
                if (txtTk.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtTk.requestFocus();
                } else {
                    TaiKhoanDTO nvdto = new TaiKhoanDTO();
                    ArrayList<TaiKhoanDTO> list = TaiKhoanBUS.getAllList();
                    for (TaiKhoanDTO nv : list) {
                        if (nv.getTaiKhoan().equals(txtTk.getText())) {
                            nvdto = nv;
                            break;
                        }
                    }
                    try {
                        nhanmaxacthuc(nvdto);
                        txtTk.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Đã gửi mã xác thực", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        cd.start(5);
                    } catch (MessagingException | UnsupportedEncodingException ex) {
                        Logger.getLogger(FormForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        btnAcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run(btnAcept, Color.decode("#90EE90"));
                if (txtOTP.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã xác nhận", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtOTP.requestFocus();
                } else {
                    if (txtOTP.getText().equals(otp)) {
                        otp = "";
                        dispose();
                        new FormChangeAccount(txtTk.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã xác nhận không đúng, vui lòng kiếm tra lại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        pnCenter.add(pnAcept);
        pnAcept.setBackground(Color.white);
        pnAcept.setLayout(new BorderLayout());
        pnAcept.setBorder(new EmptyBorder(15, 50, 15, 50));
        pnAcept.add(btnAcept, BorderLayout.CENTER);

        btnAcept.setBackground(Color.decode("#98FB98"));
        btnAcept.setFocusPainted(false);

        btnAcept.setFont(font13);
        pnBottom.setBackground(Color.white);
        pnBottom.setLayout(new GridLayout(1, 2, 5, 5));
        pnBottom.add(pnLogin);
        pnBottom.add(pnChange);

        pnLogin.setLayout(new BorderLayout());
        pnLogin.add(btnLogin, BorderLayout.CENTER);

        pnInput.setBackground(Color.white);

        btnLogin.setBackground(Color.decode("#FFC0CB"));
        btnChange.setBackground(Color.white);
        btnLogin.setFont(font13);
        btnChange.setFont(font13);

        txtTk.setFont(font18);
        txtOTP.setFont(font18);

        txtTk.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 10, 0, 10)));

        txtOTP.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 2, 2, 1, Color.lightGray), new EmptyBorder(0, 10, 0, 10)));

        lbTk.setFont(font18);
        lbOTP.setFont(font18);

        pnChange.setLayout(new BorderLayout());
        pnChange.add(btnChange, BorderLayout.CENTER);
        btnLogin.setFocusPainted(false);
        btnChange.setFocusPainted(false);
        add(pnInput);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new FormLogin();
            }
        });
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FormChangeAccount();
            }
        });
    }

    public boolean checkTK(ArrayList<NhanVienDTO> list, String tk) {
        for (NhanVienDTO s : list) {
            if (s.getMaNV().equals(tk)) {
                return true;
            }
        }
        return false;
    }

    public void run(JButton btn, Color color) {
        new Thread(() -> {
            btn.setLayout(null);
            JPanel pn = new JPanel();
            pn.setBackground(color);
            JPanel pn1 = new JPanel();
            pn1.setBackground(color);
            btn.add(pn);
            btn.add(pn1);
            int k = 1;
            for (int i = btn.getWidth() / 2; i > 0; i--) {
                pn.setBounds(i, 1, 25, 25);
                pn1.setBounds(i + 2 * k, 1, 25, 25);
                k++;
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            btn.remove(pn);
            btn.remove(pn1);
        }).start();
    }

    public void nhanmaxacthuc(TaiKhoanDTO NV) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "khoafakesing@gmail.com";
        // Mat khai email cua ban
        final String password = "oexfprfwornlewoz";
        // dia chi email nguoi nhan
        NhanVienDTO nv = NhanVienBUS.getNV(NV.getMaNV());
        String toEmail = nv.getEmail();

        final String subject = "Mã xác thực reset mật khẩu";
        int a = 0;
        Random generator = new Random();
        for (int i = 1; i <= 6; i++) {
            int value = generator.nextInt(9) + 1;
            a = a * 10 + value;
        }
        final String body = String.valueOf(a);
        otp = String.valueOf(a);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);

    }

    public class CountdownLabel extends JLabel {

        private Timer timer;
        private int count;

        public CountdownLabel(int countNum) {
            count = countNum;
        }

        public void start(int countNum) {
            setText(Integer.toString(count));
            timer = new Timer(1000, e -> {
                btnGetCode.setEnabled(false);
                count--;
                setText(Integer.toString(count));
                if (count == 0) {
                    timer.stop();
                    btnGetCode.setEnabled(true);
                    setText("");
                }
            });
            timer.start();

            count = countNum;
        }
    }
}
