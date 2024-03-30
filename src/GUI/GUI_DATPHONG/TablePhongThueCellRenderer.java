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

public class TablePhongThueCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Gọi phương thức của lớp cha
        if (column == table.getColumnModel().getColumnIndex("Tình trạng")) {
            lb.setForeground(lb.getText().equals("Đang xử lý") ? Color.decode("#339900") : lb.getText().equals("Đang được thuê") ? Color.decode("#CC0000") : Color.decode("#FFCC00"));
        } else {
            lb.setForeground(Color.black);
        }
        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 5, 0, 5)));
        lb.setHorizontalAlignment((column == table.getColumnModel().getColumnIndex("Giá phòng") || 
                column == table.getColumnModel().getColumnIndex("Giá thực")) ? JLabel.RIGHT
                : column == table.getColumnModel().getColumnIndex(" ") ? JLabel.CENTER : JLabel.LEFT);
        lb.setBackground(isSelected ? Color.decode("#F5F5F5") : Color.decode("#FFFFFF"));
        lb.setFont((column == table.getColumnModel().getColumnIndex(" ") || column == table.getColumnModel().getColumnIndex("Mã phòng")) ? new Font("Segoe UI", Font.BOLD, 13) : new Font("Segoe UI", Font.PLAIN, 13));
        return lb;
    }
}
