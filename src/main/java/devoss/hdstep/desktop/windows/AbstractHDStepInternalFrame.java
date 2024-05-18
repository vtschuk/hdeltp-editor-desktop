package devoss.hdstep.desktop.windows;

import devoss.hdstep.desktop.sheet.panel.AbstractFrameInternalSheetPanel;

import javax.swing.*;

public class AbstractHDStepInternalFrame extends JInternalFrame {
    private AbstractFrameInternalSheetPanel panel;

    public AbstractHDStepInternalFrame(AbstractFrameInternalSheetPanel panel) {
        this.add(panel);
        this.panel = panel;
    }

    public AbstractFrameInternalSheetPanel getPanel() {
        return panel;
    }
}
