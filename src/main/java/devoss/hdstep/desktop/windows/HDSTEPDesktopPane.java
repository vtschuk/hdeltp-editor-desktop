package devoss.hdstep.desktop.windows;

import devoss.hdstep.desktop.sheet.panel.AbstractFrameInternalSheetPanel;
import devoss.hdstep.desktop.sheet.panel.DrawFrameInternalSheetPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;

// HDSTEPDesktopPane, JDesktopPane implemented as Decorator
public class HDSTEPDesktopPane extends JDesktopPane {
    private BufferedImage image;
    protected JDesktopPane desktopPane;
    private java.util.List<HDStepInternalFrame> framerList = new ArrayList<>();

    public HDSTEPDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        try {
            this.image = ImageIO.read(HDSTEPDesktopPane.class.getClassLoader().getResource("icons/background.jpg"));
        } catch (IOException e) {
            System.err.println("can not load background path");
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, null);
    }

    public HDStepInternalFrame getSelectedFrame() {
        return (HDStepInternalFrame) super.getSelectedFrame();
    }

    private void add(HDStepInternalFrame frame) {
        // todo why does it not work ?
        //this.desktopPane.add((Component) frame)
        super.add(frame);
        this.framerList.add(frame);
        System.out.println("add frame to frame list, size: " + this.framerList.size());
    }

    public HDStepInternalFrame createNewSheet() {
        AbstractFrameInternalSheetPanel panel = new DrawFrameInternalSheetPanel();
        HDStepInternalFrame internalFrame = new HDStepInternalFrame(panel);
        internalFrame.setClosable(true);
        internalFrame.setMaximizable(true);
        internalFrame.setResizable(true);
        internalFrame.setBackground(Color.WHITE);
        internalFrame.setTitle("new File.xml");
        try {
            internalFrame.setSelected(true);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        Dimension internalFrameDimension = new Dimension(400, 400);
        internalFrame.setSize(internalFrameDimension);
        internalFrame.setLocation(400, 400);
        internalFrame.show();
        this.add(internalFrame);

        return internalFrame;
    }
}
