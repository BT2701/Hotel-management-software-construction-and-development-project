package GUI.GUI_HOADON;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableDialog extends DefaultTableCellRenderer {

    private Border border = new LineBorder(Color.BLACK); // Đường ngăn cách sẽ màu đen

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        // Gọi phương thức gốc để lấy Component mặc định cho ô
//		dtm.addColumn("Mã phòng");
//		dtm.addColumn("Tên phòng");
//		dtm.addColumn("Loại phòng");
//		dtm.addColumn("Giá phòng");
//		dtm.addColumn("CT loại phòng");
//		dtm.addColumn("Tình trạng");
//		dtm.addColumn("Hiện trạng");
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, 0);
        String[] titleTableRight = {"Giá phòng"};
        String[] titleTableCenter = {"Mã phòng", "Loại phòng", "CT loại phòng", "Tình trạng", "Hiện trạng"};
        String[] titleTableLeft = {"Tên phòng"};
        JLabel lb = (JLabel) c;
        lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));
        if (column == table.getColumnModel().getColumnIndex("Giá phòng")) {
            lb.setForeground(Color.decode("#FFCC00"));
        } else {
            lb.setForeground(Color.black);
        }
        for (int i = 0; i < titleTableRight.length; i++) {
            if (column == table.getColumnModel().getColumnIndex(titleTableRight[i])) {
                lb.setHorizontalAlignment(JLabel.RIGHT);
            }
        }
        for (int i = 0; i < titleTableCenter.length; i++) {
            if (column == table.getColumnModel().getColumnIndex(titleTableCenter[i])) {
                lb.setHorizontalAlignment(JLabel.CENTER);
            }
        }
        for (int i = 0; i < titleTableLeft.length; i++) {
            if (column == table.getColumnModel().getColumnIndex(titleTableLeft[i])) {
                lb.setHorizontalAlignment(JLabel.LEFT);
            }
        }
        return c;
    }

}
