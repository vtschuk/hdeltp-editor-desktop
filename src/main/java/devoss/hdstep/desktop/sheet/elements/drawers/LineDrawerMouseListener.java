package devoss.hdstep.desktop.sheet.elements.drawers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LineDrawerMouseListener implements MouseListener {
    private int startX;
    private int startY;

    private int tempX;
    private int tempY;

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getTempX() {
        return tempX;
    }

    public int getTempY() {
        return tempY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
