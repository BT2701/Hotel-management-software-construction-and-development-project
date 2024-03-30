package GUI.GUI_DATPHONG;

import DTO.KhachHangDTO;
import GUI.GUI_KHACHHANG.TableKhachHang;
import GUI.GUI_RENDER_COMPONENTS.ScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FormFindCustomer extends JDialog {

    private Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    private Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI15I = new Font("Segoe UI", Font.ITALIC, 15);
    private Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 15);
    private Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    private Font sgUI18b = new Font("Segoe UI", Font.BOLD, 20);
    private Font tNR13 = new Font("Times New Roman", Font.ITALIC, 13);
    TableKhachHang tb = new TableKhachHang();

    public FormFindCustomer(String CMND, DatPhongNew datPhongNew) {
        initComponents(CMND, datPhongNew);
    }

    public void initComponents(String CMND, DatPhongNew datPhongNew) {
        setTitle("Tìm kiếm khách hàng");
        setIconImage(new ImageIcon(getClass().getResource("/GUI/assets/hotel.png")).getImage());
        setModal(true);
        setSize(1300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());
        JPanel pnContainer = new JPanel();
        pnContainer.setLayout(new BorderLayout());
        pnContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel pnTop = new JPanel();
        JLabel lbTop = new JLabel("Danh sách khách hàng");
        JLabel lbDetail = new JLabel("Vui lòng chọn khách hàng cần tìm nhấn đúp chuột phải");
        lbTop.setFont(sgUI15);
        lbDetail.setFont(tNR13);
        pnTop.setLayout(new GridLayout(2, 1));
        pnTop.add(lbTop);
        pnTop.add(lbDetail);

        pnContainer.add(pnTop, BorderLayout.NORTH);

        pnContainer.setBackground(Color.white);
        pnTop.setBackground(Color.white);
        JScrollPane scp = new JScrollPane();
        scp.setBackground(Color.white);
        scp.getViewport().setBackground(Color.white);
        scp.setVerticalScrollBar(new ScrollBar(Color.decode("#ebf2fc"), Color.white));
        scp.setViewportView(tb);
        pnContainer.add(scp, BorderLayout.CENTER);
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    try {
                        datPhongNew.txtMaKH.setText(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Mã khách hàng")).toString());
                        String gioiTinh = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Giới tính")).toString();
                        if (gioiTinh.trim().equals("Nam")) {
                            datPhongNew.rdNam.setSelected(true);
                        } else {
                            datPhongNew.rdNu.setSelected(true);
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String dateStr = tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Ngày sinh")).toString().trim();
                        Date date = sdf.parse(dateStr);
                        datPhongNew.dateNgaySinh.setDate(date);
                        datPhongNew.txtQueQuan.setText(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Quê quán")).toString().trim());
                        datPhongNew.txtQuocTich.setText(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Quốc tịch")).toString().trim());
                        datPhongNew.txtSDT.setText(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Số điện thoại")).toString().trim());
                        datPhongNew.txtTenKH.setText(tb.getValueAt(tb.getSelectedRow(), tb.getColumnModel().getColumnIndex("Tên khách hàng")).toString().trim());
                        datPhongNew.txtTenKH.setEditable(false);
                        datPhongNew.txtQueQuan.setEditable(false);
                        datPhongNew.txtQuocTich.setEditable(false);
                        datPhongNew.txtSDT.setEditable(false);
                        datPhongNew.dateNgaySinh.setEnabled(false);
                        datPhongNew.rdNam.setEnabled(false);
                        datPhongNew.rdNu.setEnabled(false);
                        datPhongNew.txtSDT.setBackground(Color.decode("#F8f8f8"));
                        datPhongNew.txtQueQuan.setBackground(Color.decode("#F8f8f8"));
                        datPhongNew.txtQuocTich.setBackground(Color.decode("#F8f8f8"));
                        datPhongNew.txtTenKH.setBackground(Color.decode("#F8f8f8"));
                        datPhongNew.editor.setBackground(Color.decode("#f8f8f8"));
                        datPhongNew.txtMaKH.requestFocus();
                        dispose();
                    } catch (Exception ex) {
                    }
                }
            }
        });
        scp.setBorder(new EmptyBorder(0, 0, 0, 0));
        tb.renderTB(CMND);
        setLayout(new BorderLayout());
        add(pnContainer, BorderLayout.CENTER);
        setVisible(true);
    }
}
