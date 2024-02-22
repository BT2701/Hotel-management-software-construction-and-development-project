package GUI.GUI_FUNCTION_ACCOUNT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FormLoading extends JFrame {

    private Font sgUI18 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Times New Roman", Font.BOLD, 40);

    JLabel lb = new JLabel();
    JProgressBar pb = new JProgressBar();
    JLabel lbtop = new JLabel("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");

    public FormLoading() {
        initComponents();
    }

    public void initComponents() {
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1014, 637);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/background.jpg")).getImage().getScaledInstance(1014, 637, Image.SCALE_SMOOTH));
        lb.setIcon(imageIcon);
        add(lb, BorderLayout.CENTER);
        lb.setLayout(null);
        lbtop.setBounds(170, 50, 800, 50);
        lb.add(lbtop);
        lbtop.setFont(sgUI18b);
        lbtop.setForeground(Color.decode("#2F4F4F"));
        pb.setValue(0);
        pb.setStringPainted(true);
        pb.setForeground(Color.decode("#F4A460"));
        pb.setBackground(Color.decode("#FFEFD5"));
        lb.add(pb);
        setVisible(true);
    }

    public void run() {
        JLabel lb1 = new JLabel("Đang tải tài nguyên");
        lb1.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 13));
        lb.add(lb1);
        lb1.setBounds(32, lb.getHeight() - 50, lb.getWidth() - 60, 20);
        pb.setBounds(30, lb.getHeight() - 30, lb.getWidth() - 60, 20);
        int counter = 0;
        pb.setFont(new Font("Times New Roman", Font.BOLD, 13));
        while (counter <= 100) {
            pb.setValue(counter);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            counter += 5;
            if (pb.getValue() == 25) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/bbb.jpg")).getImage().getScaledInstance(1014, 637, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                lbtop.setForeground(Color.red);
                lb1.setForeground(Color.red);
            }
            if (pb.getValue() == 50) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/abc.jpg")).getImage().getScaledInstance(1014, 637, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                lbtop.setForeground(Color.red);
                lb1.setForeground(Color.red);
            }
            if (pb.getValue() == 75) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/aaa.jpg")).getImage().getScaledInstance(1014, 637, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                lbtop.setForeground(Color.white);
                lb1.setForeground(Color.white);
            }
            if (pb.getValue() == 100) {
                pb.setString("");
                lb1.setText("Đã tải xong");
                JLabel lb2 = new JLabel("Click chuột vào màn hình để tiếp tục");
                lb.add(lb2);
                lb2.setForeground(Color.white);
                lb2.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 18));
                lb2.setBounds(370, lb.getHeight() - 60, lb.getWidth() - 60, 18);
                addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        dispose();
                        new FormLogin();
                    }
                });
            }
        }
    }
}
