package GUI.GUI_DICHVU;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;

public class TablePhieuNhapTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        // Lấy component mặc định từ lớp cha
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Đặt icon null cho các cột khác
        setText(value.toString());
        // Đặt căn lề cho các cột
        if (column == table.getColumnModel().getColumnIndex("Mã phiếu nhập") || column == table.getColumnModel().getColumnIndex("Tên nhân viên") || column == table.getColumnModel().getColumnIndex("Tình trạng")) {
            setHorizontalAlignment(JLabel.LEFT);
            setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
        } else if (column == table.getColumnModel().getColumnIndex("Ngày lập phiếu")) {
            setHorizontalAlignment(JLabel.RIGHT);
            setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 10, 0, 10)));
        } else {
            setHorizontalAlignment(JLabel.CENTER);
            setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));
        }
        // Đặt màu nền cho các ô được chọn
        if (isSelected) {
            setBackground(Color.decode("#f5f5f5"));
        } else {
            setBackground(Color.decode("#FFFFFF"));
        }
        return c;
    }
}
