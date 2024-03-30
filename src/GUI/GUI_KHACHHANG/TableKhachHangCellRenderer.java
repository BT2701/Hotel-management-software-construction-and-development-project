package GUI.GUI_KHACHHANG;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableKhachHangCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Gọi phương thức của lớp cha
        if (column == table.getColumnModel().getColumnIndex("Mã khách hàng") || 
              column == table.getColumnModel().getColumnIndex("STT")  ) {
            lb.setFont(new Font("Segoe UI", Font.BOLD, 13));
        } else {
            lb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        }
        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
        lb.setHorizontalAlignment(column == table.getColumnModel().getColumnIndex("STT") ? JLabel.CENTER : JLabel.LEFT);
        lb.setBackground(isSelected ? Color.decode("#F5F5F5") : Color.decode("#FFFFFF"));
        return lb;
    }
}
