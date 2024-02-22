/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.GUI_NHANVIEN;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author SYN
 */
public class jDialogTaiKhoan extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    
    public void create(){
        initComponents();
        setGUI();
        
        setAction();
        setModal(true);
    }
    
    public jDialogTaiKhoan(String maNV){
        create();
        //setText cho MaNV
        jTextFieldMaNV.setText(maNV);
        jPanelUpdate.setVisible(false);
    }
    
    public jDialogTaiKhoan(String []temp){
        create();
        jLabelThemTK.setText("Cập nhật thông tin tài khoản");
        //set cac thuoc tinh 
        jTextFieldMaNV.setText(temp[0]);
        jTextFieldTK.setText(temp[1]);
        if(temp[2].equals("Admin")){
            jComboVaiTro.setSelectedIndex(0);
        }
        else if(temp[2].equals("Manager")){
            jComboVaiTro.setSelectedIndex(1);
        }
        else{
            jComboVaiTro.setSelectedIndex(2);
        }
        if(temp[3].equals("Mở")){
            jComboHieuLuc.setSelectedIndex(0);
        }
        else {
            jComboHieuLuc.setSelectedIndex(1);
        }
        //bo panel them
        remove(jPanelThem);
    }
    
    public jDialogTaiKhoan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        create();
    }
    
    public static String regexTK="^[A-Za-z0-9\\s._%+-]{1,63}$";
    public static boolean patternTK(String taiKhoan, String regexPattern) {
    return Pattern.compile(regexPattern)
      .matcher(taiKhoan)
      .matches();
    }
    
    private void setGUI(){ 
        //set backGround color TextFieldMaNV
        jTextFieldMaNV.setBackground(Color.decode("#F8f8f8"));
        
        Color backGroundContain=new Color(255,255,255);
        //set backGround DiaLog
        getContentPane().setBackground(backGroundContain);
        for(Component c : this.getContentPane().getComponents()){
            if(c instanceof JPanel){
                //backGround for Panel
                c.setBackground(backGroundContain);
                for(Component com : ((JPanel) c).getComponents()){
                    if(com instanceof JComboBox){
                        //set popUp for comboBox
                        com.setBackground(backGroundContain);
                       ((JComboBox) com) .setUI(new BasicComboBoxUI() {
                            @Override
                            protected ComboPopup createPopup() {
                                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                                basicComboPopup.setBorder(lineCBpop);
                                return basicComboPopup;
                            }
                        });
                    }
                    if(com instanceof JTextField){
                        //boder for jText
                        ((JTextField) com).setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#EFEFEF")), new EmptyBorder(0, 3, 0, 3)));
                    }
                    //set Them Xoa Sua
                    if(com instanceof JButton){
//                        ImageIcon iconImport = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/assets/ex.png")).getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
//                        ((JButton) com).setIcon(iconImport);
                        ((JButton) com).setFocusPainted(false);
                        ((JButton) com).setFont(sgUI13b);
                        ((JButton) com).setBorderPainted(false);
                        ((JButton) com).setBackground(Color.decode("#ebf2fc"));
                    }
                }
            }
        }
        //set LabelThongBao=null
        jLabelThongBao.setText("");
        jLabelThongBao.setVisible(false);
    }
    
    private void setAction(){
        jButtonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionAdd();
            }
        });
        jButtonSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionUpdate();
            }
        });
    }
    
    private boolean validateField(){
        //kiem tra TK
        if(!patternTK(jTextFieldTK.getText(), regexTK)){
            jLabelThongBao.setVisible(true);
            jLabelThongBao.setText("taiKhoan không hợp lệ, gồm chữ, số, dấu +-%. and space");
            return false;
        }
        return true;
    }
    
    private TaiKhoanDTO getInfoField(){
        TaiKhoanDTO x=new TaiKhoanDTO();
        x.setMaNV(jTextFieldMaNV.getText());
        x.setTaiKhoan(jTextFieldTK.getText());
        x.setVaiTro(jComboVaiTro.getItemAt(jComboVaiTro.getSelectedIndex()));
        x.setTinhTrang(jComboHieuLuc.getSelectedIndex());
        return x;
    }
    
    private void actionAdd(){
        if(validateField()==false){
            return;
        }
        //them nhan vien
        TaiKhoanDTO temp=getInfoField();
        JOptionPane.showMessageDialog(rootPane,TaiKhoanBUS.insertTK(temp));
    }
    
    private void actionUpdate(){ 
        validateField();
        TaiKhoanDTO temp=getInfoField();
        JOptionPane.showMessageDialog(rootPane,TaiKhoanBUS.updateTK(temp));
    }
                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelTTCT = new javax.swing.JLabel();
        jLabelThemTK = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelMaNV = new javax.swing.JLabel();
        jTextFieldMaNV = new javax.swing.JTextField();
        jLabelTK = new javax.swing.JLabel();
        jTextFieldTK = new javax.swing.JTextField();
        jLabelHieuLuc = new javax.swing.JLabel();
        jLabelVaiTro = new javax.swing.JLabel();
        jComboHieuLuc = new javax.swing.JComboBox<>();
        jComboVaiTro = new javax.swing.JComboBox<>();
        jPanelThem = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jPanelUpdate = new javax.swing.JPanel();
        jButtonSua = new javax.swing.JButton();
        jLabelThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết nhân viên");
        setIconImage(null);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelTTCT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelTTCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTCT.setText("THÔNG TIN CHI TIẾT TÀI KHOẢN");
        jLabelTTCT.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 5);
        getContentPane().add(jLabelTTCT, gridBagConstraints);

        jLabelThemTK.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelThemTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThemTK.setText("Thêm tài khoản");
        jLabelThemTK.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 14, 4);
        getContentPane().add(jLabelThemTK, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMaNV.setText("Mã nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelMaNV, gridBagConstraints);

        jTextFieldMaNV.setEditable(false);
        jTextFieldMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMaNV.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldMaNV, gridBagConstraints);

        jLabelTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTK.setText("Tài khoản");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelTK, gridBagConstraints);

        jTextFieldTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldTK.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jTextFieldTK, gridBagConstraints);

        jLabelHieuLuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHieuLuc.setText("Hiệu lực");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelHieuLuc, gridBagConstraints);

        jLabelVaiTro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelVaiTro.setText("Vai trò");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jLabelVaiTro, gridBagConstraints);

        jComboHieuLuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboHieuLuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tài khoản mở", "Tài khoản đóng" }));
        jComboHieuLuc.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jComboHieuLuc, gridBagConstraints);

        jComboVaiTro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Manager", "Receptionist" }));
        jComboVaiTro.setPreferredSize(new java.awt.Dimension(400, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanel1.add(jComboVaiTro, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanelThem.setLayout(new java.awt.GridBagLayout());

        jButtonThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelThem.add(jButtonThem, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        getContentPane().add(jPanelThem, gridBagConstraints);

        jPanelUpdate.setLayout(new java.awt.GridBagLayout());

        jButtonSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSua.setText("Sửa");
        jButtonSua.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        jPanelUpdate.add(jButtonSua, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanelUpdate, gridBagConstraints);

        jLabelThongBao.setForeground(new java.awt.Color(255, 51, 0));
        jLabelThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThongBao.setText("label để thông báo lỗi");
        jLabelThongBao.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jLabelThongBao, gridBagConstraints);

        pack();
    }// </editor-fold>                                            
    


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JComboBox<String> jComboHieuLuc;
    private javax.swing.JComboBox<String> jComboVaiTro;
    private javax.swing.JLabel jLabelHieuLuc;
    private javax.swing.JLabel jLabelMaNV;
    private javax.swing.JLabel jLabelTK;
    private javax.swing.JLabel jLabelTTCT;
    private javax.swing.JLabel jLabelThemTK;
    private javax.swing.JLabel jLabelThongBao;
    private javax.swing.JLabel jLabelVaiTro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelThem;
    private javax.swing.JPanel jPanelUpdate;
    private javax.swing.JTextField jTextFieldMaNV;
    private javax.swing.JTextField jTextFieldTK;
    // End of variables declaration                                                               
        
    
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    private  LineBorder lineCBpop = new LineBorder(Color.white);
    private LineBorder lineDate = new LineBorder(Color.red,1);
    // End of variables declaration         
}
