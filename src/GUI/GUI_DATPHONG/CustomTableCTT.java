package GUI.GUI_DATPHONG;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCTT extends DefaultTableCellRenderer {
    
    private Border border = new LineBorder(Color.BLACK); // Đường ngăn cách sẽ màu đen

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int col) {
        // Gọi phương thức gốc để lấy Component mặc định cho ô
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        String[] titleTableRight = {"Tiền đặt cọc"};
        String[] titleTableCenter = {"STT"};
        String[] titleTableLeft = {"Mã chi tiết thuê", "Mã nhân viên", "Mã khách hàng", "Tên khách hàng", "Tên nhân viên", "Tình trạng xử lý"};
        JLabel lb = (JLabel) c;
        lb.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")), new EmptyBorder(0, 7, 0, 7)));
        if (col == table.getColumnModel().getColumnIndex("Tiền đặt cọc")) {
            lb.setForeground(Color.decode("#FFCC00"));
        } else {
            lb.setForeground(Color.black);
        }
        for (int i = 0; i < titleTableRight.length; i++) {
            if (col == table.getColumnModel().getColumnIndex(titleTableRight[i])) {
                lb.setHorizontalAlignment(JLabel.RIGHT);
            }
        }
        for (int i = 0; i < titleTableCenter.length; i++) {
            if (col == table.getColumnModel().getColumnIndex(titleTableCenter[i])) {
                lb.setHorizontalAlignment(JLabel.CENTER);
            }
        }
        for (int i = 0; i < titleTableLeft.length; i++) {
            if (col == table.getColumnModel().getColumnIndex(titleTableLeft[i])) {
                lb.setHorizontalAlignment(JLabel.LEFT);
            }
        }
        lb.setBackground(Color.white);
        return c;
    }
    
}
