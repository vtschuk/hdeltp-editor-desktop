package devoss.hdstep.desktop.gui.menu;

import devoss.hdstep.desktop.DevossHDSTEPDesktop;
import devoss.hdstep.desktop.gui.menu.builder.*;
import devoss.hdstep.desktop.gui.menu.director.*;

import javax.swing.*;

public class MenuCreator {
    private DevossHDSTEPDesktop desktop;

    public MenuCreator(DevossHDSTEPDesktop desktop) {
        this.desktop = desktop;
        desktop.registerMenuCreator(this);
    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        menuBar.add(createOptionMenu());
        menuBar.add(createElementMenu());
        menuBar.add(createComponentsMenu());
        menuBar.add(createToolsMenu());
        menuBar.add(createHelpMenu());
        desktop.getMainFrame().setJMenuBar(menuBar);
    }

    private JMenu createFileMenu() {
        MenuDirector menuDirector = new FileMenuDirector();
        MenuBuilder menuBuilder = new FileMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }

    private JMenu createEditMenu() {
        MenuDirector menuDirector = new EditMenuDirector();
        MenuBuilder menuBuilder = new EditMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }

    private JMenu createOptionMenu() {
        MenuDirector menuDirector = new OptionMenuDirector();
        MenuBuilder menuBuilder = new OptionMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }

    public JMenu createElementMenu() {
        MenuDirector menuDirector = new ElementMenuDirector();
        MenuBuilder menuBuilder = new ElementMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }

    private JMenu createComponentsMenu() {
        MenuDirector menuDirector = new ComponentMenuDirector();
        MenuBuilder menuBuilder = new ComponentMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }

    private JMenu createToolsMenu() {
        MenuDirector menuDirector = new ToolsMenuDirector();
        MenuBuilder menuBuilder = new ToolsMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }

    private JMenu createHelpMenu() {
        MenuDirector menuDirector = new ElementMenuDirector();
        MenuBuilder menuBuilder = new HelpMenuBuilder(desktop.getMainFrame());
        return menuDirector.build(menuBuilder);
    }
}
