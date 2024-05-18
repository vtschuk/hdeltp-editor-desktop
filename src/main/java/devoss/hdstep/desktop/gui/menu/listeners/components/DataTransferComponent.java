package devoss.hdstep.desktop.gui.menu.listeners.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DataTransferComponent extends ComponentPicture implements MouseMotionListener {
    private MouseEvent firstMouseEvent = null;

    public DataTransferComponent(Image image) {
        super(image);
        addMouseMotionListener(this);
    }

    public void setImage(Image image) {
        this.image = image;
        this.repaint();
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("DataTransferComponent: Mouse pressed");
        //Don't bother to drag if there is no image.
        if (image == null)
            return;

        firstMouseEvent = e;
        e.consume();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("DataTransferComponent: Mouse dragged");
        //Don't bother to drag if the component displays no image.
        if (image == null)
            return;

        if (firstMouseEvent != null) {
            e.consume();

            //If they are holding down the control key, COPY rather than MOVE
            int ctrlMask = InputEvent.CTRL_DOWN_MASK;
            int action = ((e.getModifiersEx() & ctrlMask) == ctrlMask) ? TransferHandler.COPY
                    : TransferHandler.MOVE;

            int dx = Math.abs(e.getX() - firstMouseEvent.getX());
            int dy = Math.abs(e.getY() - firstMouseEvent.getY());
            //Arbitrarily define a 5-pixel shift as the
            //official beginning of a drag.
            if (dx > 5 || dy > 5) {
                //This is a drag, not a click.
                JComponent c = (JComponent) e.getSource();
                TransferHandler handler = c.getTransferHandler();
                //Tell the transfer handler to initiate the drag.
                handler.exportAsDrag(c, firstMouseEvent, action);
                firstMouseEvent = null;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("DataTransferComponent: Mouse released");
        firstMouseEvent = null;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("DataTransferComponent: Mouse moved");
    }
}
