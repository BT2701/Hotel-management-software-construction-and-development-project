package GUI.GUI_NHANVIEN;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;

public class TableNhanVienCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Gọi phương thức của lớp cha
        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
        lb.setHorizontalAlignment((column == table.getColumnModel().getColumnIndex("Số ngày phép") || column == table.getColumnModel().getColumnIndex("Lương 1 ngày")) ? JLabel.RIGHT
                : column == table.getColumnModel().getColumnIndex("STT") ? JLabel.CENTER : JLabel.LEFT);
        lb.setBackground(isSelected ? Color.decode("#F5F5F5") : Color.decode("#FFFFFF"));
        lb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        return lb;
    }
}
