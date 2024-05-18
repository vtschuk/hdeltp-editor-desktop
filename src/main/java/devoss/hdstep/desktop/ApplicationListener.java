package devoss.hdstep.desktop;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// implement composite
public class ApplicationListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?",
                "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
            return;
        }
        System.exit(-1);
    }

}
