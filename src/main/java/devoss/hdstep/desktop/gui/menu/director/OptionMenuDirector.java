package devoss.hdstep.desktop.gui.menu.director;

import devoss.hdstep.desktop.gui.menu.builder.MenuBuilder;

import javax.swing.*;

public class OptionMenuDirector extends MenuDirector {
    @Override
    public JMenu build(MenuBuilder menuBuilder) {
        return menuBuilder.createMenu();
    }
}
