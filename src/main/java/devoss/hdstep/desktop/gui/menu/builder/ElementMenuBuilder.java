package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.gui.menu.listeners.elements.*;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ElementMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;
    private final List<ElementMenuBuilder.MenuEntry> menuEntries = new ArrayList<>();

    public ElementMenuBuilder(HDStepFrame frame) {
        ElementMenuBuilder.MenuEntry menuEntry;
        this.frame = frame;

        //Linie
        menuEntry = new ElementMenuBuilder.MenuEntry("Linie",
                new LineElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/line.16.png", "Linie");
        this.menuEntries.add(menuEntry);

        // Kreis
        menuEntry = new ElementMenuBuilder.MenuEntry("Kreis",
                new CircleElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/circle.16.png", "Kreis");
        this.menuEntries.add(menuEntry);

        //Ellipse
        menuEntry = new ElementMenuBuilder.MenuEntry("Ellipse",
                new EllipseElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/ellipse.16.png", "Ellipse");
        this.menuEntries.add(menuEntry);

        //Group
        menuEntry = new ElementMenuBuilder.MenuEntry("Group",
                new GroupElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/group.16.png", "Group");
        this.menuEntries.add(menuEntry);

        // Bild
        menuEntry = new ElementMenuBuilder.MenuEntry("Bild",
                new ImageElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/image.16.png", "Bild");
        this.menuEntries.add(menuEntry);

        // Polyline
        menuEntry = new ElementMenuBuilder.MenuEntry("Polyline",
                new PolylineElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/polyline.16.png", "Polyline");
        this.menuEntries.add(menuEntry);

        // Rechteck
        menuEntry = new ElementMenuBuilder.MenuEntry("Rechteck",
                new RectElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/rect.16.png", "Rechteck");
        this.menuEntries.add(menuEntry);

        // Text
        menuEntry = new ElementMenuBuilder.MenuEntry("Text",
                new TextElementMenuItemActionListener(frame.getDesktopPane()),
                "icons/elements/text.16.png", "Text");
        this.menuEntries.add(menuEntry);

    }

    @Override
    public JMenu createMenu() {
        JMenu elementMenuItem = new JMenu("Elemente");
        menuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.listener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> elementMenuItem.add(item));
        return elementMenuItem;
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
