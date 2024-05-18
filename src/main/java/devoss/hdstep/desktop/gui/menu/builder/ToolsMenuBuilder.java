package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.gui.menu.MenuCreator;
import devoss.hdstep.desktop.gui.menu.listeners.tools.StartSimulatorToolsActionListener;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToolsMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;
    private final List<ToolsMenuBuilder.MenuEntry> simulatorMenuEntries = new ArrayList<>();

    public ToolsMenuBuilder(HDStepFrame frame) {
        this.frame = frame;
        addSimulatorMenuEntries();
    }

    private void addSimulatorMenuEntries() {
        ToolsMenuBuilder.MenuEntry menuEntry;

        // start
        menuEntry = new ToolsMenuBuilder.MenuEntry("Start",
                new StartSimulatorToolsActionListener(frame.getDesktopPane()),
                "icons/tools/start.16.png", "Start Simulator");
        this.simulatorMenuEntries.add(menuEntry);

        //Stop
        menuEntry = new ToolsMenuBuilder.MenuEntry("Stop",
                new StartSimulatorToolsActionListener(frame.getDesktopPane()),
                "icons/tools/stop.16.png", "Stop Simulator");
        this.simulatorMenuEntries.add(menuEntry);

        //Pause
        menuEntry = new ToolsMenuBuilder.MenuEntry("Pause",
                new StartSimulatorToolsActionListener(frame.getDesktopPane()),
                "icons/tools/pause.16.png", "Pause Simulator");
        this.simulatorMenuEntries.add(menuEntry);

        //Restart
        menuEntry = new ToolsMenuBuilder.MenuEntry("Restart",
                new StartSimulatorToolsActionListener(frame.getDesktopPane()),
                "icons/tools/restart.16.png", "Restart Simulator");
        this.simulatorMenuEntries.add(menuEntry);

    }

    @Override
    public JMenu createMenu() {
        JMenu toolsMenu = new JMenu("Tools");

        JMenu simulatorMenu = new JMenu("Simulator");
        simulatorMenu.setIcon(new ImageIcon(MenuCreator.class.getClassLoader().getResource("icons/tools/cubes.16.png")));
        toolsMenu.add(simulatorMenu);

        JMenu backendMenu = new JMenu("Backend");
        backendMenu.setIcon(new ImageIcon(MenuCreator.class.getClassLoader().getResource("icons/tools/database.16.png")));
        toolsMenu.add(backendMenu);

        simulatorMenuEntries.stream().map(menuEntry -> new HDStepMenuItem.Builder(menuEntry.title)
                .icon(menuEntry.icon)
                .actionListener(menuEntry.listener)
                .toolTip(menuEntry.toolTip)
                .build()
        ).forEach(item -> simulatorMenu.add(item));

        return toolsMenu;
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
