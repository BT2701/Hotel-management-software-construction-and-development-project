package GUI.GUI_DICHVU;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

// Renderer tùy chỉnh cho cột icon
public class IconDichVuRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        // Lấy component mặc định từ lớp cha
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Đặt icon cho cột icon
        setIcon((Icon) value);
        setText("");
        
        // Đặt căn lề cho cột icon
        setHorizontalAlignment(JLabel.CENTER);
        setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));

        // Đặt màu nền cho các ô được chọn
        if (isSelected) {
            setBackground(Color.decode("#F5F5F5"));
        } else {
            setBackground(Color.decode("#FFFFFF"));
        }
        return c;
    }
}
