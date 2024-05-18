package devoss.hdstep.desktop.sheet.panel;

import devoss.hdstep.desktop.sheet.elements.Element;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFrameInternalSheetPanel extends JPanel {
    private final int SHEET_STEP = 10;
    private final java.util.List<Element> elements = new ArrayList<>();

    public AbstractFrameInternalSheetPanel() {

    }

    public List<Element> getElements() {
        return elements;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = this.getHeight();
        int x = this.getWidth();

        for (int j = SHEET_STEP; j <= y; j += SHEET_STEP) {
            for (int i = SHEET_STEP; i <= x; i += SHEET_STEP) {
                g.drawLine(i, j, i + 1, j);
            }
        }
    }
}
