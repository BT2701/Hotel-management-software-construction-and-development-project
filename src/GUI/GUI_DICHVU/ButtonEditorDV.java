package GUI.GUI_DICHVU;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ButtonEditorDV extends DefaultCellEditor {
    
    protected JButton button;
    private String label;
    private boolean isPushed;
    
    public ButtonEditorDV(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setFocusPainted(false);
        button.setBackground(Color.decode("#1FE51F"));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setForeground(Color.white);
    }
    
    public JButton getButton() {
        return button;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#EEEEEE")), BorderFactory.createCompoundBorder(new MatteBorder(3, 30, 3, 30, Color.white), new MatteBorder(2, 2, 2, 2, Color.decode("#00cc00")))));
        } else {
            button.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 1, 1, Color.decode("#EEEEEE")), BorderFactory.createCompoundBorder(new MatteBorder(3, 30, 3, 30, Color.white), new MatteBorder(2, 2, 2, 2, Color.decode("#00cc00")))));
        }
        button.setBackground(Color.decode("#1FE51F"));
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }
    
    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return label;
    }
    
    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
