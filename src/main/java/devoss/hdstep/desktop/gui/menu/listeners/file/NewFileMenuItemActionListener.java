package devoss.hdstep.desktop.gui.menu.listeners.file;

import devoss.hdstep.desktop.windows.HDSTEPDesktopPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileMenuItemActionListener implements ActionListener {
    private final HDSTEPDesktopPane desktopPane;

    public NewFileMenuItemActionListener(HDSTEPDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.desktopPane.createNewSheet();
    }
}
