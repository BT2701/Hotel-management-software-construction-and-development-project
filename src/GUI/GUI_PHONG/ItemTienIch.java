package GUI.GUI_PHONG;

import java.awt.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;

public class ItemTienIch extends JPanel {

    private String maTI;
    private String tenTI;
    private int maximum;

    public ItemTienIch(String maTI, String tenTI, int soLuong) {
        this.maTI = maTI;
        this.tenTI = tenTI;
        this.maximum = soLuong;
        initComponents(soLuong);
    }

    JPanel pnContainer = new JPanel();
    JPanel pnContentCenter = new JPanel();
    JPanel pnContentExit = new JPanel();
    JButton btnExit = new JButton();
    JLabel lbMaDV = new JLabel("Mã tiện ích:");
    JLabel lbMaDVtxt = new JLabel();
    JLabel lbTenDV = new JLabel("Tên tiện ích:");
    JLabel lbTenDVtxt = new JLabel();
    JLabel lbSoLuong = new JLabel("Số lượng");
    JSpinner spinerSoLuong = new JSpinner();
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI13p = new Font("Segoe UI", Font.PLAIN, 13);
    JPanel pnSpiner = new JPanel();

    public void initComponents(int soLuong) {
        lbMaDVtxt.setText(maTI);
        lbTenDVtxt.setText(tenTI);
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
        pnSpiner.setBorder(new EmptyBorder(0,0,0,70));
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
        SpinnerModel sm = new SpinnerNumberModel(1, 1, soLuong, 1);
        spinerSoLuong.setModel(sm);
        spinerSoLuong.setBorder(new MatteBorder(1,1,1,1,Color.decode("#EEEEEE")));
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
        setBackground(Color.white);
        btnExit.setBackground(Color.white);
        pnContentCenter.setBackground(Color.white);
        pnContainer.setBackground(Color.white);
        pnContentExit.setBackground(Color.white);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 5, 0,Color.decode("#FAFAFA")), new MatteBorder(2, 2, 2, 2, Color.decode("#ebf2fc"))), new EmptyBorder(5, 5, 5, 5)));
    }

    public String getMaTI() {
        return maTI;
    }

    public void setMaTI(String maTI) {
        this.maTI = maTI;
    }

    public String getTenTI() {
        return tenTI;
    }

    public void setTenTI(String tenTI) {
        this.tenTI = tenTI;
    }

    public int getSoLuong() {
        return Integer.parseInt(spinerSoLuong.getValue().toString());
    }

    public void setSoLuong(int soLuong) {
        spinerSoLuong.setValue(soLuong);
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemTienIch) {
            ItemTienIch other = (ItemTienIch) obj;
            if (other.getMaTI().equals(this.maTI)) {
                return true;
            }
        }
        return false;
    }
}
