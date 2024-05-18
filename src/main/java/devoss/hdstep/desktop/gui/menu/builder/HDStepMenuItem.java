package devoss.hdstep.desktop.gui.menu.builder;

import javax.swing.*;
import javax.swing.event.MenuDragMouseListener;
import java.awt.event.ActionListener;

public class HDStepMenuItem extends JMenuItem {
    private final String title;
    private final ActionListener actionListener;
    private final MenuDragMouseListener menuDragMouseListener;
    private final String icon;
    private final String toolTip;

    private HDStepMenuItem(Builder builder) {
        this.title = builder.title;
        this.setText(title);
        this.actionListener = builder.actionListener;
        this.addActionListener(actionListener);
        this.menuDragMouseListener = builder.menuDragMouseListener;
        this.addMenuDragMouseListener(builder.menuDragMouseListener);
        this.icon = builder.icon;
        this.setIcon(new ImageIcon(HDStepMenuItem.class.getClassLoader().getResource(icon)));
        this.toolTip = builder.toolTip;
        this.setToolTipText(toolTip);
    }

    public static class Builder {
        private final String title;
        private ActionListener actionListener;
        private MenuDragMouseListener menuDragMouseListener;
        private String icon;
        private String toolTip;

        public Builder(String title) {
            this.title = title;
        }

        public Builder actionListener(ActionListener actionListener) {
            this.actionListener = actionListener;
            return this;
        }
        public Builder menuDragMouseListener(MenuDragMouseListener menuDragMouseListener) {
            this.menuDragMouseListener = menuDragMouseListener;
            return this;
        }

        public Builder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder toolTip(String toolTip) {
            this.toolTip = toolTip;
            return this;
        }

        public HDStepMenuItem build() {
            return new HDStepMenuItem(this);
        }

    }

}
