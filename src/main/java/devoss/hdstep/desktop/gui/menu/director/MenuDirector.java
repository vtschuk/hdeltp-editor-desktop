package devoss.hdstep.desktop.gui.menu.director;

import devoss.hdstep.desktop.gui.menu.builder.MenuBuilder;

import javax.swing.*;

public abstract class MenuDirector {
    public abstract JMenu build(MenuBuilder menuBuilder);
}
