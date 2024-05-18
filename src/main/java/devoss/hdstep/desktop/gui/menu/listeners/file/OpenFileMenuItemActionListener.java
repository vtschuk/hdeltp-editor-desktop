package devoss.hdstep.desktop.gui.menu.listeners.file;

import devoss.hdstep.desktop.windows.HDSTEPDesktopPane;
import devoss.hdstep.desktop.windows.HDStepInternalFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFileMenuItemActionListener implements ActionListener {
    private HDSTEPDesktopPane desktopPane;

    public OpenFileMenuItemActionListener(HDSTEPDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.getName().endsWith(".xml")) return true;
                return false;
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }
        });
        int result = fileChooser.showOpenDialog(desktopPane);
        if (result == JFileChooser.APPROVE_OPTION) {
            // user selects a file
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            HDStepInternalFrame newSheet = this.desktopPane.createNewSheet();
            newSheet.setTitle(selectedFile.getName());
        }
    }
}
