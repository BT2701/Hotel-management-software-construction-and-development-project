package GUI.GUI_DICHVU;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;

public class ItemServiceAdd extends JPanel {

    private String maDV;
    private String tenDV;

    int LightDark;

    public ItemServiceAdd(String maDV, String tenDV) {
        LightDark = 0;
        this.maDV = maDV;
        this.tenDV = tenDV;
        initComponents();
        lightDark(LightDark);
    }

    JPanel pnContainer = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentExit = new JPanel();
    JButton btnExit = new JButton();
    JLabel lbMaDV = new JLabel("Mã dịch vụ:");
    JLabel lbMaDVtxt = new JLabel();
    JLabel lbTenDV = new JLabel("Tên dịch vụ:");
    JLabel lbTenDVtxt = new JLabel();
    JLabel lbSoLuong = new JLabel("Số lượng");
    JSpinner spinerSoLuong = new JSpinner();
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    JPanel pnSpiner = new JPanel();

    public void initComponents() {
        lbMaDVtxt.setText(maDV);
        lbTenDVtxt.setText(tenDV);
        setLayout(new BorderLayout());
        add(pnContainer, BorderLayout.CENTER);
        pnContainer.setBorder(new EmptyBorder(0, 0, 5, 0));
        pnContainer.setLayout(new BorderLayout(5, 5));
        pnContainer.add(pnContentCenter, BorderLayout.CENTER);
        pnContainer.add(pnContentExit, BorderLayout.EAST);

        pnContentExit.add(btnExit);
        pnContentCenter.setLayout(new GridLayout(3, 3, 5, 5));
        pnContentCenter.add(lbMaDV);
        pnContentCenter.add(lbMaDVtxt);
        pnContentCenter.add(lbTenDV);
        pnContentCenter.add(lbTenDVtxt);
        pnContentCenter.add(lbSoLuong);
        pnContentCenter.add(pnSpiner);
        pnSpiner.setLayout(new BorderLayout());
        pnSpiner.add(spinerSoLuong,BorderLayout.CENTER);
        pnSpiner.setBorder(new EmptyBorder(0,0,0,50));
        pnSpiner.setBackground(Color.white);

        btnExit.setFont(sgUI13b);
        btnExit.setFocusPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setPreferredSize(new Dimension(40, 40));

        lbMaDV.setFont(sgUI13b);
        lbTenDV.setFont(sgUI13b);
        lbSoLuong.setFont(sgUI13b);
        lbMaDVtxt.setFont(sgUI13p);
        lbTenDVtxt.setFont(sgUI13p);
        spinerSoLuong.setFont(sgUI13p);
        SpinnerModel sm = new SpinnerNumberModel(1, 1, 100, 1);
        spinerSoLuong.setModel(sm);
        ImageIcon iconX = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/icons8-close-30.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnExit.setIcon(iconX);
        setMouse();
    }

    public void setMouse() {
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon iconX = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/cancel-144.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                btnExit.setIcon(iconX);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon iconX = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/icons8-close-30.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
                btnExit.setIcon(iconX);
            }
        });
    }

    public void lightDark(int LightDark) {
        if (LightDark == 0) {
            pnSpiner.setBackground(Color.white);
            setBackground(Color.white);
            btnExit.setBackground(Color.white);
            pnContentCenter.setBackground(Color.white);
            pnContainer.setBackground(Color.white);
            pnContentExit.setBackground(Color.white);
            spinerSoLuong.setBorder(new MatteBorder(1,1,1,1,Color.decode("#EEEEEE")));
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 5, 0), new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc"))), new EmptyBorder(5, 5, 5, 5)));
        } else {

        }
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public int getSoLuong() {
        return Integer.parseInt(spinerSoLuong.getValue().toString());
    }

    public void setSoLuong(int soLuong) {
        spinerSoLuong.setValue(soLuong);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemServiceAdd) {
            ItemServiceAdd other = (ItemServiceAdd) obj;
            if (other.getMaDV().equals(this.maDV)) {
                return true;
            }
        }
        return false;
    }

}
