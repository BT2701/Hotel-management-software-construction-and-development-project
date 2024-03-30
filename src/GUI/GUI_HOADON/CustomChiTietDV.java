package GUI.GUI_HOADON;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomChiTietDV extends DefaultTableCellRenderer {

	private Border border = new LineBorder(Color.BLACK); // Đường ngăn cách sẽ màu đen

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// Gọi phương thức gốc để lấy Component mặc định cho ô
		// STT, Mã Phòng, Giá, Loại hình, Ngày thuê, Ngày trả, Ngày check out
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, 0);
		String[] titleTableRight = { "Giá" };
		String[] titleTableCenter = { "STT", "Mã Phòng", "Loại hình", "Ngày thuê", "Ngày trả","Ngày check out" };
		String[] titleTableLeft = { };
		JLabel lb = (JLabel) c;
		lb.setBorder(new MatteBorder(0, 0, 1, 0, Color.decode("#EEEEEE")));
		if (column == table.getColumnModel().getColumnIndex("Giá")) {
			lb.setForeground(Color.decode("#FFCC00"));
		} else {
			lb.setForeground(Color.black);
		}
		for (int i = 0; i < titleTableRight.length; i++) {
			if (column == table.getColumnModel().getColumnIndex(titleTableRight[i]))
				lb.setHorizontalAlignment(JLabel.RIGHT);
		}
		for (int i = 0; i < titleTableCenter.length; i++) {
			if (column == table.getColumnModel().getColumnIndex(titleTableCenter[i]))
				lb.setHorizontalAlignment(JLabel.CENTER);
		}
		for (int i = 0; i < titleTableLeft.length; i++) {
			if (column == table.getColumnModel().getColumnIndex(titleTableLeft[i]))
				lb.setHorizontalAlignment(JLabel.LEFT);
		}
		return c;
	}

}
