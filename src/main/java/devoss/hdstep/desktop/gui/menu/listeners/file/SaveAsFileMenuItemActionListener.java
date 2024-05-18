package devoss.hdstep.desktop.gui.menu.listeners.file;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsFileMenuItemActionListener implements ActionListener {
    private JDesktopPane desktopPane;

    public SaveAsFileMenuItemActionListener(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this.desktopPane);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            try (FileWriter fileWriter = new FileWriter(fileToSave);) {
                fileWriter.write("Hallo Welt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
