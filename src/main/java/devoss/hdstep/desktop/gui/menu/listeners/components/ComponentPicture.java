package devoss.hdstep.desktop.gui.menu.listeners.components;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ComponentPicture extends JComponent implements MouseListener, FocusListener,
        Accessible {

    Image image;

    public ComponentPicture(Image image) {
        this.image = image;
        setFocusable(true);
        addMouseListener(this);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        this.repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
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


    protected void paintComponent(Graphics graphics) {
        Graphics g = graphics.create();

        //Draw in our entire space, even if isOpaque is false.
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image == null ? 125 : image.getWidth(this),
                image == null ? 125 : image.getHeight(this));

        if (image != null) {
            //Draw image at its natural size of 125x125.
            g.drawImage(image, 0, 0, this);
        }

        //Add a border, red if picture currently has focus
        if (isFocusOwner()) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawRect(0, 0, image == null ? 125 : image.getWidth(this),
                image == null ? 125 : image.getHeight(this));
        g.dispose();
    }

}
