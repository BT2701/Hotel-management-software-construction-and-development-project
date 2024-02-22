package GUI.GUI_DATPHONG;

import DTO.DichVuDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ItemService extends JPanel {

    DichVuDTO dichVu = new DichVuDTO();
    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    Font tNR13i = new Font("Segoe UI", Font.ITALIC, 13);
    DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
    JPanel pnImg = new JPanel();
    JLabel lbImg = new JLabel();
    JPanel pnInfo = new JPanel();
    JPanel pnMaDV = new JPanel();
    JPanel pnTenDV = new JPanel();
    JPanel pnLoaiDV = new JPanel();
    JPanel pnGiaDV = new JPanel();
    JPanel pnSLDV = new JPanel();

    public ItemService(DichVuDTO dichVu) {
        this.dichVu = dichVu;
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        setLayout(new GridLayout(2, 1));
        setBackground(Color.decode("#FAFAFA"));
        ImageIcon icon = new ImageIcon(new ImageIcon(dichVu.getHinhAnh()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        lbImg.setIcon(icon);
        pnImg.setLayout(new BorderLayout());
        pnImg.add(lbImg, BorderLayout.CENTER);
        lbImg.setHorizontalAlignment(JLabel.CENTER);

        setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#FAFAFA")), new EmptyBorder(5, 5, 5, 5)));

        pnInfo.setLayout(new GridLayout(4, 1));
        pnInfo.add(pnTenDV);
        pnInfo.add(pnLoaiDV);
        pnInfo.add(pnGiaDV);
        if (dichVu.getLoaiDV().equals("Thức ăn đồ uống")) {
            pnInfo.add(pnSLDV);
        }

        add(pnImg);
        add(pnInfo);

        pnImg.setBackground(Color.decode("#FFFFFF"));
        pnInfo.setBackground(Color.decode("#FAFAFA"));
        pnMaDV.setBackground(Color.decode("#FAFAFA"));
        pnTenDV.setBackground(Color.decode("#FAFAFA"));
        pnLoaiDV.setBackground(Color.decode("#FAFAFA"));
        pnGiaDV.setBackground(Color.decode("#FAFAFA"));
        pnSLDV.setBackground(Color.decode("#FAFAFA"));

        pnMaDV.setLayout(new BorderLayout());
        JLabel lbMaDV = new JLabel("Mã dịch vụ:  ");
        lbMaDV.setFont(sgUI13);
        pnMaDV.add(lbMaDV, BorderLayout.WEST);
        JLabel lbMaDV_Info = new JLabel(dichVu.getMaDV());
        lbMaDV_Info.setFont(sgUI13b);
        pnMaDV.add(lbMaDV_Info, BorderLayout.CENTER);

        pnTenDV.setLayout(new BorderLayout());
        JLabel lbTenDV = new JLabel("Tên dịch vụ: ");
        lbTenDV.setFont(sgUI13);
        pnTenDV.add(lbTenDV, BorderLayout.WEST);
        JLabel lbTenDV_Info = new JLabel(dichVu.getTenDV());
        lbTenDV_Info.setFont(sgUI13b);
        pnTenDV.add(lbTenDV_Info, BorderLayout.CENTER);

        pnLoaiDV.setLayout(new BorderLayout());
        JLabel lbLoaiDV = new JLabel("Loại dịch vụ:  ");
        lbLoaiDV.setFont(sgUI13);
        pnLoaiDV.add(lbLoaiDV, BorderLayout.WEST);
        JLabel lbLoaiDV_Info = new JLabel(dichVu.getLoaiDV());
        lbLoaiDV_Info.setFont(sgUI13b);
        pnLoaiDV.add(lbLoaiDV_Info, BorderLayout.CENTER);

        pnGiaDV.setLayout(new BorderLayout());
        JLabel lbGiaDV = new JLabel("Giá dịch vụ:  ");
        lbGiaDV.setFont(sgUI13);
        pnGiaDV.add(lbGiaDV, BorderLayout.WEST);
        JLabel lbGiaDV_Info = new JLabel(dcf.format(dichVu.getGiaDV()));
        lbGiaDV_Info.setFont(sgUI13b);
        lbGiaDV_Info.setForeground(Color.red);
        pnGiaDV.add(lbGiaDV_Info, BorderLayout.CENTER);

        pnSLDV.setLayout(new BorderLayout());
        JLabel lbSLDV = new JLabel("Số lượng còn:  ");
        lbSLDV.setFont(sgUI13);
        pnSLDV.add(lbSLDV, BorderLayout.WEST);
        JLabel lbSLDV_Info = new JLabel(dichVu.getSoLuong() + "");
        lbSLDV_Info.setFont(sgUI13b);
        pnSLDV.add(lbSLDV_Info, BorderLayout.CENTER);
        setToolTipText("<html> "
                + "Mã dịch vụ: " + dichVu.getMaDV() + "<br> "
                + "Tên dich vụ: " + dichVu.getTenDV() + "<br>"
                + "Loại dịch vụ: " + dichVu.getLoaiDV() + "<br>"
                + "Giá dịch vụ: " + dcf.format(dichVu.getGiaDV()) + "<br>"
                + "Số lượng còn: " + dichVu.getSoLuong()
        );

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#138D27")), new EmptyBorder(5, 5, 5, 5)));
                setBackground(Color.decode("#ccffcc"));
                pnImg.setBackground(Color.decode("#FFFFFF"));
                pnInfo.setBackground(Color.decode("#ccffcc"));
                pnMaDV.setBackground(Color.decode("#ccffcc"));
                pnTenDV.setBackground(Color.decode("#ccffcc"));
                pnLoaiDV.setBackground(Color.decode("#ccffcc"));
                pnGiaDV.setBackground(Color.decode("#ccffcc"));
                pnSLDV.setBackground(Color.decode("#ccffcc"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createCompoundBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#FAFAFA")), new EmptyBorder(5, 5, 5, 5)));
                setBackground(Color.decode("#FAFAFA"));
                pnImg.setBackground(Color.decode("#FFFFFF"));
                pnInfo.setBackground(Color.decode("#FAFAFA"));
                pnMaDV.setBackground(Color.decode("#FAFAFA"));
                pnTenDV.setBackground(Color.decode("#FAFAFA"));
                pnLoaiDV.setBackground(Color.decode("#FAFAFA"));
                pnGiaDV.setBackground(Color.decode("#FAFAFA"));
                pnSLDV.setBackground(Color.decode("#FAFAFA"));
            }
        });
    }
}
