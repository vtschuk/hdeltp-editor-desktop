package devoss.hdstep.desktop;

import devoss.hdstep.desktop.gui.menu.MenuCreator;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;
import java.awt.*;

public class DevossHDSTEPDesktop {

    private MenuCreator menuCreator;
    private HDStepFrame mainFrame;

    public DevossHDSTEPDesktop() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerMenuCreator(MenuCreator menuCreator) {
        this.menuCreator = menuCreator;
    }

    public HDStepFrame getMainFrame() {
        return mainFrame;
    }


    public void createDevossHDSTEPDesktop() {
        String title = "";
        Dimension dimension = new Dimension(1600, 800);
        mainFrame = new HDStepFrame();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.addWindowListener(new ApplicationListener());
        mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCreator.class.getClassLoader().getResource("icons/program.label.16.png")));

        mainFrame.getDesktopPane().createNewSheet();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuCreator menuCreator = new MenuCreator(this);
        menuCreator.createMenuBar();

        mainFrame.setTitle(title);
        mainFrame.setSize(dimension);
        mainFrame.setVisible(true);
    }

}
