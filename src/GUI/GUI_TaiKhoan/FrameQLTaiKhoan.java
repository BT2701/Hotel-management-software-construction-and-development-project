package GUI.GUI_TaiKhoan;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.GUI_FUNCTION_ACCOUNT.FormLogin;
import GUI.GUI_NHANVIEN.TableTaiKhoan;
import GUI.GUI_NHANVIEN.jDialogTaiKhoan;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author SYN
 */
public class FrameQLTaiKhoan extends javax.swing.JFrame {

    public FrameQLTaiKhoan() {
        initComponents();
        setGUI();
        setAction();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void setGUI() {
        //set icon for label hello
        ImageIcon iconHello = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/default.jpg")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
        jLabelHello.setIcon(iconHello);
        //setTable cho jscrollPane
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane2.setViewportView(tbTK);
        jScrollPane2.setViewportBorder(null);
        tbTK.renderTB();
        tbTK.getTableHeader().setBackground(Color.decode("#dee9fc"));
        //set backGround
        Color backGroundContain = new Color(255, 255, 255);
        //set backGround DiaLog
        getContentPane().setBackground(backGroundContain);
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof JPanel) {
                //backGround for Panel
                c.setBackground(backGroundContain);
                for (Component com : ((JPanel) c).getComponents()) {
                    if (com instanceof JComboBox) {
                        //set popUp for comboBox
                        com.setBackground(backGroundContain);
                        ((JComboBox) com).setUI(new BasicComboBoxUI() {
                            @Override
                            protected ComboPopup createPopup() {
                                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                                basicComboPopup.setBorder(lineCBpop);
                                return basicComboPopup;
                            }
                        });
                        //border for ComboBox
                        ((JComboBox) com).setBorder(lineTxt);
                    }
                    if (com instanceof JTextField) {
                        //boder for jText
                        ((JTextField) com).setBorder(lineTxt);
                    }
                    //set Them Xoa Sua
                    if (com instanceof JButton) {
                        ((JButton) com).setFocusPainted(false);
                        ((JButton) com).setFont(sgUI13b);
                        ((JButton) com).setBorderPainted(false);
                        ((JButton) com).setBackground(Color.decode("#ebf2fc"));
                    }
                }
            }
        }
    }

    private void setAction() {
        jButtonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionReset();
            }
        });
        jButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSearch();
            }
        });
        tbTK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {     // to detect doble click events
                    int row = tbTK.getSelectedRow(); // select a row\
                    String[] temp = new String[4];

                    jDialogTaiKhoan capNhat = null;
                    //lay trang thai tai khoan Mở hay Chưa
                    temp[3] = tbTK.getValueAt(row, 4).toString();
                    if (!temp[3].equals("Chưa mở")) { //neu co tai khoan thi cap nhat
                        for (int i = 1; i < 5; i++) {
                            temp[i - 1] = tbTK.getValueAt(row, i).toString();
                        }
                        capNhat = new jDialogTaiKhoan(temp);
                    } else { //neu chua co thi tao tai khoan
                        temp[0] = tbTK.getValueAt(row, 1).toString();
                        capNhat = new jDialogTaiKhoan(temp[0]);
                    }
                    capNhat.setLocationRelativeTo(null);
                    capNhat.setVisible(true);
                    capNhat.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            tbTK.setData(TaiKhoanBUS.getListNV());
                        }
                    });

//              int column = tbTK.getSelectedColumn(); // select a column
//              JOptionPane.showMessageDialog(null, tbTK.getValueAt(row, column)); // get the value of a row and column.
                }
            }
        });
    }

    private void actionReset() {
        //setText
        jTextFieldMaNV.setText("");
        jTextFieldTK.setText("");
        jComboVaiTro.setSelectedIndex(0);
        jComboTinhTrang.setSelectedIndex(0);
    }

    private void actionSearch() {
        //kiem tra va luu cac thuoc tinh
        boolean[] attris = new boolean[4];
        String[] values = new String[4];
        //maNV
        if (jTextFieldMaNV.getText().equals("")) {
            attris[0] = false;
        } else {
            attris[0] = true;
            values[0] = jTextFieldMaNV.getText();
        }
        //TK
        if (jTextFieldTK.getText().equals("")) {
            attris[1] = false;
        } else {
            attris[1] = true;
            values[1] = jTextFieldTK.getText();
        }
        //vaiTro
        if (jComboVaiTro.getSelectedIndex() == 0) {
            attris[2] = false;
        } else {
            attris[2] = true;
            values[2] = jComboVaiTro.getSelectedItem().toString();
        }
        //tinhTrang
        if (jComboTinhTrang.getSelectedIndex() == 0) {
            attris[3] = false;
        } else {
            attris[3] = true;
            values[3] = String.valueOf(jComboTinhTrang.getSelectedIndex());
        }
        ArrayList<TaiKhoanDTO> tmp = TaiKhoanBUS.searchTK(attris, values, "", ""); //String for top and order "",""
        if (tmp.size() == 0) {
            actionReset();
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            tmp = TaiKhoanBUS.getListNV();
        }
        tbTK.setData(tmp);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabelMaNV = new javax.swing.JLabel();
        jTextFieldMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTK = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelVaiTro = new javax.swing.JLabel();
        jComboVaiTro = new javax.swing.JComboBox<>();
        jLabelTinhTrang = new javax.swing.JLabel();
        jComboTinhTrang = new javax.swing.JComboBox<>();
        jButtonReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabelHello = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabelMaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMaNV.setText("Mã nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel2.add(jLabelMaNV, gridBagConstraints);

        jTextFieldMaNV.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel2.add(jTextFieldMaNV, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tài khoản");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        jTextFieldTK.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel2.add(jTextFieldTK, gridBagConstraints);

        jButtonSearch.setText("Tìm kiếm");
        jButtonSearch.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel2.add(jButtonSearch, gridBagConstraints);

        jLabelVaiTro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelVaiTro.setText("Vai trò");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel2.add(jLabelVaiTro, gridBagConstraints);

        jComboVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Vai trò", "Admin", "Manager", "Receptionist"}));
        jComboVaiTro.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel2.add(jComboVaiTro, gridBagConstraints);

        jLabelTinhTrang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTinhTrang.setText("Tình trạng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        jPanel2.add(jLabelTinhTrang, gridBagConstraints);

        jComboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tình trạng", "Mở", "Đóng", "Chưa có"}));
        jComboTinhTrang.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel2.add(jComboTinhTrang, gridBagConstraints);

        jButtonReset.setText("Làm mới");
        jButtonReset.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jButtonReset, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel2, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quản lý tài khoản");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.8;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 6, 20);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabelHello.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHello.setText("Hello, ADMIN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.8;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 6, 20);
        getContentPane().add(jLabelHello, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh sách tài khoản");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jLabel4, gridBagConstraints);
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
        setTitle("Phần mềm quản lý khách sạn [ADMIN]");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        pack();
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboTinhTrang;
    private javax.swing.JComboBox<String> jComboVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHello;
    private javax.swing.JLabel jLabelMaNV;
    private javax.swing.JLabel jLabelTinhTrang;
    private javax.swing.JLabel jLabelVaiTro;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldMaNV;
    private javax.swing.JTextField jTextFieldTK;
    // End of variables declaration                

    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private LineBorder lineCBpop = new LineBorder(Color.white);
    private LineBorder lineTxt = new LineBorder(Color.BLUE, 2);
    private TableTaiKhoan tbTK = new TableTaiKhoan();
}
