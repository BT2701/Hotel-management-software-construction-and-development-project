package GUI.GUI_RENDER_COMPONENTS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.plaf.metal.MetalTabbedPaneUI;

public class TabbedUI extends MetalTabbedPaneUI {

    public TabbedUI() {
    }

    @Override
    protected Insets getTabInsets(int i, int i1) {
        return new Insets(10, 10, 10, 10);
    }

    @Override
    protected void paintTabBorder(Graphics grphcs, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isSelected) {
            g2.setColor(Color.decode("#12831A"));
            g2.setStroke(new BasicStroke(3));
            g2.fillRect(x, h - 3, w, 3);
        } else {
            g2.setColor(new Color(255, 255, 255));
            g2.fillRect(x, h - 3, w, 3);
        }
        g2.dispose();
    }

    @Override
    protected void paintContentBorder(Graphics grphcs, int tabPlacement, int selectedIndex) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#12831A"));
        g2.dispose();
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        if (isSelected) {
            Color color1 = Color.WHITE;
            Color color2 = Color.decode("#D0FFD3");
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, 100, color2);
            g2.setPaint(gp);
            g2.fillRect(x, h/2, w, h);
            g2.setColor(Color.white);
            g2.fillRect(x, h, w, h);
        } else {
            g2.setColor(Color.white);
            g2.fillRect(x, 0, w, h);
        }
        g2.dispose();
    }

}
