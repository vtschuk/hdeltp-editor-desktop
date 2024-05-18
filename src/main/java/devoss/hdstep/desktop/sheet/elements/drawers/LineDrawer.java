package devoss.hdstep.desktop.sheet.elements.drawers;

import javax.swing.*;
import java.awt.*;

public class LineDrawer extends JInternalFrame {

    LineDrawerMouseListener listener = new LineDrawerMouseListener();

    public LineDrawer() {
        this.addMouseListener(listener);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaintMode();
        g2.setColor(Color.BLACK);
        g2.drawLine(listener.getStartX(), listener.getStartY(), listener.getTempX(), listener.getTempY());
    }
}
