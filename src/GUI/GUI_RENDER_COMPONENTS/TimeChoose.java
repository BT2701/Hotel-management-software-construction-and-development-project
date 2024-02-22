package GUI.GUI_RENDER_COMPONENTS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;

public class TimeChoose extends JPanel {

    private int minute = 0;
    private int hour = 7;
    private JPanel pnMinute;
    private JPanel pnMinuteLB;
    private JTextField lbMinute;
    private JPanel pnMinuteBtn;
    private JButton btnUpMinute;
    private JButton btnDownMinute;

    private JPanel pnHour;
    private JPanel pnHourLB;
    private JTextField lbHour;
    private JPanel pnHourBtn;
    private JButton btnUpHour;
    private JButton btnDownHour;
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);

    public TimeChoose() {
        ImageIcon iconUp = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/icons8-up-96.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH));
        ImageIcon iconDo = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/icons8-down-96.png")).getImage().getScaledInstance(20, 10, Image.SCALE_SMOOTH));
        pnMinute = new JPanel();
        pnMinuteLB = new JPanel();
        lbMinute = new JTextField(minute + "");
        pnHour = new JPanel();
        pnHourLB = new JPanel();
        lbHour = new JTextField(hour + "h");
        pnMinuteBtn = new JPanel();
        pnHourBtn = new JPanel();
        btnUpMinute = new JButton();
        btnUpMinute.setIcon(iconUp);
        btnDownMinute = new JButton();
        btnDownMinute.setIcon(iconDo);
        btnUpHour = new JButton();
        btnUpHour.setIcon(iconUp);
        btnDownHour = new JButton();
        btnDownHour.setIcon(iconDo);

        btnDownHour.setBorder(null);
        btnDownMinute.setBorder(null);
        btnUpHour.setBorder(null);
        btnUpMinute.setBorder(null);

        setLayout(new GridLayout());
        add(pnHour);
        add(pnMinute);

        pnMinute.setLayout(new BorderLayout());
        pnMinute.add(pnMinuteLB, BorderLayout.CENTER);
        pnMinute.add(pnMinuteBtn, BorderLayout.EAST);

        pnMinuteLB.setLayout(new BorderLayout());
        pnMinuteLB.add(lbMinute, BorderLayout.CENTER);
        lbMinute.setMargin(new Insets(5, 5, 5, 5));
        lbMinute.setFont(sgUI13);
        lbMinute.setHorizontalAlignment(JLabel.RIGHT);
        lbHour.setMargin(new Insets(5, 5, 5, 5));
        lbHour.setFont(sgUI13);
        lbHour.setHorizontalAlignment(JLabel.RIGHT);

        pnMinuteBtn.setLayout(new GridLayout(2, 1));
        pnMinuteBtn.add(btnUpMinute);
        pnMinuteBtn.add(btnDownMinute);

        pnHour.setLayout(new BorderLayout());
        pnHour.add(pnHourLB, BorderLayout.CENTER);
        pnHour.add(pnHourBtn, BorderLayout.EAST);

        pnHourLB.setLayout(new BorderLayout());
        pnHourLB.add(lbHour, BorderLayout.CENTER);

        pnHourBtn.setLayout(new GridLayout(2, 1));
        pnHourBtn.add(btnUpHour);
        pnHourBtn.add(btnDownHour);

        btnUpHour.setFocusPainted(false);
        btnDownHour.setFocusPainted(false);
        btnUpMinute.setFocusPainted(false);
        btnUpMinute.setFocusPainted(false);

        btnDownMinute.setFocusPainted(false);

        lbMinute.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    int min = Integer.parseInt(lbMinute.getText());
                    if (min < 0 || min > 59) {
                        minute = 0;
                        lbMinute.setText("0");
                    } else {
                        minute = min;
                    }
                } catch (Exception ex) {
                    minute = 0;
                    lbMinute.setText("0");
                }
            }
        });

        lbHour.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    int h = Integer.parseInt(lbHour.getText());
                    if (h < 1 || h > 24) {
                        lbHour.setText("7h");
                        hour = 7;
                    } else {
                        hour = h;
                        lbHour.setText(lbHour.getText() + "h");
                    }
                } catch (Exception ex) {
                    hour = 7;
                    lbHour.setText("7h");
                }
            }
        });

        btnUpMinute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                    if (hour == 25) {
                        hour = 1;
                    }
                }
                lbHour.setText(hour + "h");
                lbMinute.setText(minute + "");
            }
        });
        btnDownMinute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minute--;
                if (minute == -1) {
                    minute = 59;
                    hour--;
                    if (hour == 0) {
                        hour = 24;
                    }
                }
                lbMinute.setText(minute + "");
                lbHour.setText(hour + "h");
            }
        });
        btnUpHour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hour++;
                if (hour == 25) {
                    hour = 1;
                }
                lbHour.setText(hour + "h");
            }
        });
        btnDownHour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hour--;
                if (hour == 0) {
                    hour = 24;
                }
                lbHour.setText(hour + "h");
            }
        });
        btnDownHour.setContentAreaFilled(false);
        btnDownMinute.setContentAreaFilled(false);
        btnUpHour.setContentAreaFilled(false);
        btnUpMinute.setContentAreaFilled(false);
        
        lbHour.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
        lbMinute.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
        
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
        lbHour.setText(hour + "h");
    }

    public void setMinute(int minute) {
        this.minute = minute;
        lbMinute.setText(minute + "");
    }

    public void setColorBtn(Color color) {
        btnDownHour.setBackground(color);
        btnDownMinute.setBackground(color);
        btnUpHour.setBackground(color);
        btnUpMinute.setBackground(color);
    }

    public void setEnable(boolean check) {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
        lbHour.setEditable(check);
        lbMinute.setEditable(check);
        btnDownHour.setEnabled(check);
        btnUpHour.setEnabled(check);
        btnDownMinute.setEnabled(check);
        btnUpMinute.setEnabled(check);
    }
}
