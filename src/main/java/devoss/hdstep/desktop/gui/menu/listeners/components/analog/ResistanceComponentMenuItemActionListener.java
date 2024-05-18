package devoss.hdstep.desktop.gui.menu.listeners.components.analog;

import devoss.hdstep.desktop.windows.HDStepFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResistanceComponentMenuItemActionListener implements ActionListener {
    private final HDStepFrame frame;

    public ResistanceComponentMenuItemActionListener(HDStepFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Widerstand");
    }
}
