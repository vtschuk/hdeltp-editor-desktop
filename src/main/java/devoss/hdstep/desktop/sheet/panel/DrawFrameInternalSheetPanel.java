package devoss.hdstep.desktop.sheet.panel;

import devoss.hdstep.desktop.sheet.elements.Circle;
import devoss.hdstep.desktop.sheet.elements.Element;
import devoss.hdstep.desktop.sheet.elements.Line;
import devoss.hdstep.desktop.sheet.mouse.HDStepInternalFramePanelMouseListener;

import java.awt.*;

// DrawFrameInternalSheetPanel -> AbstractFrameInternalSheetPanel -> JPanel: Composite
// DrawFrameInternalSheetPanel -> HDStepInternalFramePanelMouseListener: Mediator
public class DrawFrameInternalSheetPanel extends AbstractFrameInternalSheetPanel {
    private final HDStepInternalFramePanelMouseListener mouseListener;

    public DrawFrameInternalSheetPanel() {
        HDStepInternalFramePanelMouseListener mouseListener = new HDStepInternalFramePanelMouseListener(this);
        this.mouseListener = mouseListener;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaintMode();
        g2.setColor(Color.BLACK);
        for (Element e : super.getElements()) {
            if (e instanceof Line) {
                Line line = (Line) e;
                g2.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
            }
            if (e instanceof Circle) {
                Circle circle = (Circle) e;
                System.out.println("draw circle");
                g2.drawOval(circle.getStartX(), circle.getStartY(), circle.getRadus(), circle.getRadus());
            }
        }

    }
}
