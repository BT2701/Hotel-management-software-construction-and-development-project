package GUI.GUI_DICHVU;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#EEEEEE")), BorderFactory.createCompoundBorder(new MatteBorder(3, 30, 3, 30, Color.white), new MatteBorder(2, 2, 2, 2, Color.decode("#00cc00")))));
        setText((value == null) ? "" : value.toString());
        setForeground(Color.white);
        setBackground(Color.decode("#1FE51F"));
        return this;
    }
}
