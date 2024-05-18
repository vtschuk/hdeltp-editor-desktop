package devoss.hdstep.desktop.sheet.mouse;

import devoss.hdstep.desktop.sheet.elements.Line;
import devoss.hdstep.desktop.sheet.panel.DrawFrameInternalSheetPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class HDStepInternalFramePanelMouseListener extends AbstractPanelMouseListener {

    private DrawFrameInternalSheetPanel panel;

    public HDStepInternalFramePanelMouseListener(DrawFrameInternalSheetPanel panel) {
        this.panel = panel;
        this.panel.addMouseListener(this);
        this.panel.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        line.setEndX(e.getX());
        line.setEndY(e.getY());
        panel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {

            line = new Line();
            line.setStartX(e.getX());
            line.setStartY(e.getY());
            this.panel.getElements().add(line);
            System.out.println("added line to elements, size:" + this.panel.getElements().size());


        } else {
            JPopupMenu popupMenu = new JPopupMenu();
            popupMenu.setLocation(e.getX(), e.getY());
            //MenuCreator creator = new MenuCreator();
            popupMenu.add(new JMenuItem("Schliessen"));

            popupMenu.show(this.panel, e.getX(), e.getY());
        }

    }
}
