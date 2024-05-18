package devoss.hdstep.desktop.gui.menu.listeners.elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineElementMenuItemActionListener implements ActionListener {
    private JDesktopPane desktopPane;

    public LineElementMenuItemActionListener(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JInternalFrame selectedFrame = this.desktopPane.getSelectedFrame();
        //selectedFrame.setDropTarget(DropTarget);

    }
}
