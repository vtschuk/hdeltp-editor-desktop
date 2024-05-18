package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.gui.menu.MenuCreator;
import devoss.hdstep.desktop.gui.menu.listeners.options.*;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OptionMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;
    private final List<OptionMenuBuilder.MenuEntry> menuEntries = new ArrayList<>();

    public OptionMenuBuilder(HDStepFrame frame) {
        this.frame = frame;
        addLanguages();
    }

    private void addLanguages() {
        OptionMenuBuilder.MenuEntry menuEntry;

        // deutsch
        menuEntry = new OptionMenuBuilder.MenuEntry("Deutsch",
                new DeLangOptionsMenuItemActionListener(frame.getDesktopPane()),
                "icons/options/language/de.16.png", "Deutsch");
        this.menuEntries.add(menuEntry);

        // Englisch
        menuEntry = new OptionMenuBuilder.MenuEntry("Englisch",
                new EnLangOptionsMenuItemActionListener(frame.getDesktopPane()),
                "icons/options/language/en.16.png", "Englisch");
        this.menuEntries.add(menuEntry);

        // russian
        menuEntry = new OptionMenuBuilder.MenuEntry("Russian",
                new RuLangOptionsMenuItemActionListener(frame.getDesktopPane()),
                "icons/options/language/ru.16.png", "Russian");
        this.menuEntries.add(menuEntry);

        // france
        menuEntry = new OptionMenuBuilder.MenuEntry("France",
                new FrLangOptionsMenuItemActionListener(frame.getDesktopPane()),
                "icons/options/language/fr.16.png", "France");
        this.menuEntries.add(menuEntry);

        // spanisch
        menuEntry = new OptionMenuBuilder.MenuEntry("Spanisch",
                new EsLangOptionsMenuItemActionListener(frame.getDesktopPane()),
                "icons/options/language/es.16.png", "Spanisch");
        this.menuEntries.add(menuEntry);

        // chinesisch
        menuEntry = new OptionMenuBuilder.MenuEntry("Chinesisch",
                new CnLangOptionsMenuItemActionListener(frame.getDesktopPane()),
                "icons/options/language/de.16.png", "Chinesisch");
        this.menuEntries.add(menuEntry);
    }

    @Override
    public JMenu createMenu() {
        JMenu optionsMenu = new JMenu("Options");
        JMenu langMenu = new JMenu("Sprache");
        langMenu.setIcon(new ImageIcon(MenuCreator.class.getClassLoader().getResource("icons/options/language/int.16.png")));
        optionsMenu.add(langMenu);

        menuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.listener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> langMenu.add(item));

        optionsMenu.add(langMenu);
        return optionsMenu;
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
