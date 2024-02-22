package GUI.GUI_HOME;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelHome extends JPanel {

    public PanelHome(int width, int height) {
        init(width, height);
    }

    public void init(int width, int height) {
        setLayout(new BorderLayout());
        add(new ImageSliderPanel(new String[]{"/GUI/assets/ks.jpg", "/GUI/assets/ks2.jpg","/GUI/assets/abc.jpg"}, width, height),BorderLayout.CENTER);
    }
}
