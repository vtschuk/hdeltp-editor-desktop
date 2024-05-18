package devoss.hdstep.desktop.gui.menu.builder;

import devoss.hdstep.desktop.ExitApplication;
import devoss.hdstep.desktop.gui.menu.MenuCreator;
import devoss.hdstep.desktop.gui.menu.listeners.file.*;
import devoss.hdstep.desktop.windows.HDStepFrame;

import javax.swing.*;

public class FileMenuBuilder extends MenuBuilder {
    private final HDStepFrame frame;

    public FileMenuBuilder(HDStepFrame frame) {
        this.frame = frame;
    }

    @Override
    public JMenu createMenu() {
        JMenu fileMenu = new JMenu("File");

        //new
        NewFileMenuItemActionListener newFileMenuItemActionListener = new NewFileMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem newMenuItem = new HDStepMenuItem.Builder("Neu")
                .actionListener(newFileMenuItemActionListener)
                .icon("icons/file/new.16.png")
                .toolTip("Neu")
                .build();
        fileMenu.add(newMenuItem);

        //open
        OpenFileMenuItemActionListener openFileMenuItemActionListener = new OpenFileMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem openMenuItem = new HDStepMenuItem.Builder("Öffnen")
                .actionListener(openFileMenuItemActionListener)
                .icon("icons/file/open.16.png")
                .toolTip("Öffnen")
                .build();
        fileMenu.add(openMenuItem);

        //Speichern
        SaveFileMenuItemActionListener saveFileMenuItemActionListener = new SaveFileMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem saveMenuItem = new HDStepMenuItem.Builder("Speichern")
                .actionListener(saveFileMenuItemActionListener)
                .icon("icons/file/save.16.png")
                .toolTip("Speichern")
                .build();
        fileMenu.add(saveMenuItem);

        //Alle Speichern
        SaveAllFileMenuItemActionListener saveAllFileMenuItemActionListener = new SaveAllFileMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem saveAllMenuItem = new HDStepMenuItem.Builder("Alle Speichern")
                .actionListener(saveAllFileMenuItemActionListener)
                .icon("icons/file/save-all.16.png")
                .toolTip("Alle Speichern")
                .build();
        fileMenu.add(saveAllMenuItem);

        //Speichern als
        SaveAsFileMenuItemActionListener saveAsFileMenuItemActionListener = new SaveAsFileMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem saveAsMenuItem = new HDStepMenuItem.Builder("Speichern Als")
                .actionListener(saveAsFileMenuItemActionListener)
                .icon("icons/file/save-as.16.png")
                .toolTip("Speichern als")
                .build();
        fileMenu.add(saveAsMenuItem);

        //Ausdrucken
        PrintFileMenuItemActionListener printFileMenuItemActionListener1 = new PrintFileMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem printMenuItem = new HDStepMenuItem.Builder("Alle Speichern")
                .actionListener(printFileMenuItemActionListener1)
                .icon("icons/file/print.16.png")
                .toolTip("Alle Speichern")
                .build();
        fileMenu.add(printMenuItem);


        JMenu exportMenu = new JMenu("Export");
        exportMenu.setIcon(new ImageIcon(MenuCreator.class.getClassLoader().getResource("icons/file/export.16.png")));

        PDFExportMenuItemActionListener pdfExportMenuItemActionListener = new PDFExportMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem pdfExportMenuItem = new HDStepMenuItem.Builder("PDF")
                .actionListener(pdfExportMenuItemActionListener)
                .icon("icons/file/pdf.16.png")
                .toolTip("test")
                .build();
        exportMenu.add(pdfExportMenuItem);

        PNGExportMenuItemActionListener pngExportMenuItemActionListener = new PNGExportMenuItemActionListener(frame.getDesktopPane());
        HDStepMenuItem imageExportMenuItem = new HDStepMenuItem.Builder("PNG")
                .actionListener(pngExportMenuItemActionListener)
                .icon("icons/file/image.16.png")
                .toolTip("test")
                .build();
        exportMenu.add(imageExportMenuItem);
        fileMenu.add(exportMenu);

        fileMenu.addSeparator();

        //beenden
        ExitApplication exitApplication = new ExitApplication();
        HDStepMenuItem exitJMenuItem = new HDStepMenuItem.Builder("Beenden")
                .actionListener(exitApplication)
                .icon("icons/file/exit.16.png")
                .toolTip("Beenden")
                .build();
        fileMenu.add(exitJMenuItem);

        return fileMenu;
    }
}
