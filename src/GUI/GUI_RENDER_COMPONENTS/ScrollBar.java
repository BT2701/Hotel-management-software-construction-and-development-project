package GUI.GUI_RENDER_COMPONENTS;

import java.awt.*;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {

    public ScrollBar(Color c, Color bg) {
        setUI(new ScrollBarUI(c));
        setPreferredSize(new Dimension(5, 5));
        setBackground(bg);
        setUnitIncrement(20);
    }
    public ScrollBar(Color c, Color bg, int size) {
        setUI(new ScrollBarUI(c));
        setPreferredSize(new Dimension(size, size));
        setBackground(bg);
        setUnitIncrement(20);
    }
}
