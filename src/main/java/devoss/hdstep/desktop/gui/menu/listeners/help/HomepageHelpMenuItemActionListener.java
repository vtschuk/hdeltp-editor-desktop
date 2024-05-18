package devoss.hdstep.desktop.gui.menu.listeners.help;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class HomepageHelpMenuItemActionListener implements ActionListener {
    public HomepageHelpMenuItemActionListener(JDesktopPane desktopPane) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        URI uri = URI.create("https://github.com/xgarnet");
        try {
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
