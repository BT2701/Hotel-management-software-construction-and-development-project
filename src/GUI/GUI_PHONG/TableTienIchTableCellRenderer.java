package GUI.GUI_PHONG;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableTienIchTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Gọi phương thức của lớp cha
        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#F5F5F5")), new EmptyBorder(0, 10, 0, 10)));
        lb.setHorizontalAlignment(column == table.getColumnModel().getColumnIndex("Số lượng") ? JLabel.RIGHT
                : column == table.getColumnModel().getColumnIndex("STT") ? JLabel.CENTER : JLabel.LEFT);
        setBackground(Color.white);
        lb.setFont((column == table.getColumnModel().getColumnIndex("STT")
                || (column == table.getColumnModel().getColumnIndex("Mã tiện ích")) ? (new Font("Segoe UI", Font.BOLD, 13))
                : (new Font("Segoe UI", Font.PLAIN, 13))));
        return lb;
    }
}
