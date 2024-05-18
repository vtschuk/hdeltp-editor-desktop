package devoss.hdstep.desktop.windows;

import javax.swing.*;


public class HDStepFrame extends JFrame {

    public HDSTEPDesktopPane getDesktopPane() {
        return desktopPane;
    }

    private final HDSTEPDesktopPane desktopPane;

    public HDStepFrame() {

        HDSTEPDesktopPane desktopPane = new HDSTEPDesktopPane(new JDesktopPane());
        this.desktopPane = desktopPane;
        this.add(desktopPane);
    }

    public HDStepFrame(HDSTEPDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        this.add(desktopPane);
    }
}
