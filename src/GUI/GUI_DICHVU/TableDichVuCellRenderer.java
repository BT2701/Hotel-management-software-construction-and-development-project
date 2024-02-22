package GUI.GUI_DICHVU;

// Renderer tùy chỉnh
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;

public class TableDichVuCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        // Lấy component mặc định từ lớp cha
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Đặt icon null cho các cột khác
        setIcon(null);
        setText(value.toString());
        // Đặt căn lề cho các cột
        if (column == table.getColumnModel().getColumnIndex("Mã dịch vụ") || column == table.getColumnModel().getColumnIndex("Tên dịch vụ") || column == table.getColumnModel().getColumnIndex("Loại dịch vụ")) {
            setHorizontalAlignment(JLabel.LEFT);
            setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
        } else if (column == table.getColumnModel().getColumnIndex("Giá dịch vụ")) {
            setHorizontalAlignment(JLabel.RIGHT);
            setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
        } else {
            setHorizontalAlignment(JLabel.CENTER);
            setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));
        }
        setFont((column == table.getColumnModel().getColumnIndex("STT") || 
                (column == table.getColumnModel().getColumnIndex("Mã dịch vụ")) ? (new Font("Segoe UI", Font.BOLD, 13)) : 
                (new Font("Segoe UI", Font.PLAIN, 13))));
        return c;
    }
}
