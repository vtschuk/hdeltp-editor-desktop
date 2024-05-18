package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.gui.menu.listeners.edit.*;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;
    private final List<MenuEntry> menuEntries = new ArrayList<>();

    public EditMenuBuilder(HDStepFrame frame) {
        MenuEntry menuEntry;
        this.frame = frame;
        menuEntry = new MenuEntry("Kopieren",
                new CopyEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/copy.16.png", "Kopieren");
        this.menuEntries.add(menuEntry);

        menuEntry = new MenuEntry("Ausschneiden",
                new CutEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/cut.16.png", "Kopieren");
        this.menuEntries.add(menuEntry);

        // Einfügen
        menuEntry = new MenuEntry("Einfügen",
                new PasteEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/paste.16.png", "Einfügen");
        this.menuEntries.add(menuEntry);

        //Rückgängig
        menuEntry = new MenuEntry("Rückgängig",
                new UndoEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/undo.16.png", "Rückgängig");
        this.menuEntries.add(menuEntry);

        //Wiederholen
        menuEntry = new MenuEntry("Wiederholen",
                new RedoEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/redo.16.png", "Wiederholen");
        this.menuEntries.add(menuEntry);

        //Ausschneiden
        menuEntry = new MenuEntry("Ausschneiden",
                new CutEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/cut.16.png", "Kopieren");
        this.menuEntries.add(menuEntry);

        //Vergrößern
        menuEntry = new MenuEntry("Vergrößern",
                new ZoomInEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/zoom-in.16.png", "Vergrößern");
        this.menuEntries.add(menuEntry);

        //Verkleinern
        menuEntry = new MenuEntry("Verkleinern",
                new ZoomOutEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/zoom-out.16.png", "Verkleinern");
        this.menuEntries.add(menuEntry);

        //suchen
        menuEntry = new MenuEntry("Finden",
                new FindEditMenuItemActionListener(frame.getDesktopPane()),
                "icons/edit/find.16.png", "Finden");
        this.menuEntries.add(menuEntry);

    }

    @Override
    public JMenu createMenu() {
        JMenu editMenu = new JMenu("Bearbeiten");
        menuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.listener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> editMenu.add(item));
        return editMenu;
    }

    private class MenuEntry {
        private final String title;
        private final ActionListener listener;
        private final String icon;
        private final String toolTip;

        private MenuEntry(String title, ActionListener listener, String icon, String toolTip) {
            this.title = title;
            this.listener = listener;
            this.icon = icon;
            this.toolTip = toolTip;
        }
    }
}
