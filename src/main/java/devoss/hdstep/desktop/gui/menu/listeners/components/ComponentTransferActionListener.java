package devoss.hdstep.desktop.gui.menu.listeners.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComponentTransferActionListener implements ActionListener, PropertyChangeListener {
    private JComponent focusOwner = null;

    public ComponentTransferActionListener() {
        KeyboardFocusManager manager = KeyboardFocusManager
                .getCurrentKeyboardFocusManager();
        manager.addPropertyChangeListener("permanentFocusOwner", this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (focusOwner == null)
            return;
        String action = (String) e.getActionCommand();
        Action a = focusOwner.getActionMap().get(action);
        if (a != null) {
            a.actionPerformed(new ActionEvent(focusOwner,
                    ActionEvent.ACTION_PERFORMED, null));
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object o = evt.getNewValue();
        if (o instanceof JComponent) {
            focusOwner = (JComponent) o;
        } else {
            focusOwner = null;
        }
    }
}
