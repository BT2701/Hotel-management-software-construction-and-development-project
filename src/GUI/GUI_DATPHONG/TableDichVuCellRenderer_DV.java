package GUI.GUI_DATPHONG;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableDichVuCellRenderer_DV extends DefaultTableCellRenderer {

    Font sgUI15 = new Font("Segoe UI", Font.BOLD, 15);
    Font sgUI15p = new Font("Segoe UI", Font.PLAIN, 15);
    Font sgUI13 = new Font("Segoe UI", Font.PLAIN, 13);
    Font sgUI13b = new Font("Segoe UI", Font.BOLD, 13);
    Font sgUI18b = new Font("Segoe UI", Font.BOLD, 18);
    Font tNR13i = new Font("Segoe UI", Font.ITALIC, 13);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Gọi phương thức của lớp cha
        if (column == table.getColumnModel().getColumnIndex("Tên dịch vụ")) {
            lb.setFont(sgUI13b);
            lb.setHorizontalAlignment(JLabel.LEFT);
        } else {
            lb.setFont(sgUI13);
            lb.setHorizontalAlignment(JLabel.RIGHT);
        }
        if (isSelected) {
            lb.setBackground(Color.decode("#CCFFCC"));
        } else if (row % 2 == 0) {
            lb.setBackground(Color.decode("#FAFAFA"));
        } else {
            lb.setBackground(Color.white);
        }
        lb.setBorder(null);
        return lb;
    }
}
