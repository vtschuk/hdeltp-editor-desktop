package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.gui.menu.listeners.help.AboutHelpMenuItemActionListener;
import devoss.hdstep.desktop.gui.menu.listeners.help.HomepageHelpMenuItemActionListener;
import devoss.hdstep.desktop.gui.menu.listeners.help.LicenceHelpMenuItemActionListener;
import devoss.hdstep.desktop.gui.menu.listeners.help.ManualHelpMenuItemActionListener;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HelpMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;
    private final List<HelpMenuBuilder.MenuEntry> menuEntries = new ArrayList<>();

    public HelpMenuBuilder(HDStepFrame frame) {
        HelpMenuBuilder.MenuEntry menuEntry;
        this.frame = frame;

        //Manual
        menuEntry = new HelpMenuBuilder.MenuEntry("Manual",
                new ManualHelpMenuItemActionListener(frame.getDesktopPane()),
                "icons/help/manual.16.png", "Manual");
        this.menuEntries.add(menuEntry);

        //Lizenz
        menuEntry = new HelpMenuBuilder.MenuEntry("Lizenz",
                new LicenceHelpMenuItemActionListener(frame.getDesktopPane()),
                "icons/help/licence.16.png", "Lizenz");
        this.menuEntries.add(menuEntry);

        //Homepage
        menuEntry = new HelpMenuBuilder.MenuEntry("Homepage",
                new HomepageHelpMenuItemActionListener(frame.getDesktopPane()),
                "icons/help/homepage.16.png", "Homepage");
        this.menuEntries.add(menuEntry);

        //About
        menuEntry = new HelpMenuBuilder.MenuEntry("Info",
                new AboutHelpMenuItemActionListener(frame),
                "icons/help/about.16.png", "Info");
        this.menuEntries.add(menuEntry);
    }

    @Override
    public JMenu createMenu() {
        JMenu helpMenu = new JMenu("Hilfe");
        menuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.listener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> helpMenu.add(item));
        return helpMenu;
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
