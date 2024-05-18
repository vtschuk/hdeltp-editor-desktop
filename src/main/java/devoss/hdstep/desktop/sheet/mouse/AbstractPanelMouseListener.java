package devoss.hdstep.desktop.sheet.mouse;

import devoss.hdstep.desktop.sheet.elements.Line;

import java.awt.event.MouseEvent;

public class AbstractPanelMouseListener implements IPanelMouseListener {

    private int startX;
    private int startY;

    private int tempX;
    private int tempY;

    Line line;


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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
