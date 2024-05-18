package devoss.hdstep.desktop.gui.menu.listeners.components.analog;

import devoss.hdstep.desktop.sheet.components.DraggableComponent;
import devoss.hdstep.desktop.sheet.components.analog.Wire;
import devoss.hdstep.desktop.windows.HDStepFrame;
import devoss.hdstep.desktop.windows.HDStepInternalFrame;

import javax.swing.*;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WireComponentMenuItemActionListener implements ActionListener, MenuDragMouseListener {

    private final HDStepFrame frame;

    public WireComponentMenuItemActionListener(HDStepFrame frame) {
        this.frame = frame;
    }

    TransferHandler handler = new TransferHandler() {
        public boolean canImport(TransferHandler.TransferSupport support) {
            System.out.println("can import");
            return true;
        }

        public boolean importData(TransferHandler.TransferSupport support) {
            System.out.println("try to import");
            Transferable t = support.getTransferable();
            try {
                String data = (String) t.getTransferData(DataFlavor.stringFlavor);
                System.out.println(data);
            } catch (UnsupportedFlavorException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return true;
        }

    };

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Leitung");
    }

    @Override
    public void menuDragMouseEntered(MenuDragMouseEvent e) {
        System.out.println("entered");
    }

    @Override
    public void menuDragMouseExited(MenuDragMouseEvent e) {
        System.out.println("exited");
        HDStepInternalFrame selectedFrame = this.frame.getDesktopPane().getSelectedFrame();
        if (selectedFrame != null) {
            selectedFrame.setTransferHandler(handler);
        } else {
            JOptionPane.showMessageDialog(this.frame, "kein Fenster aktiviert");
        }
    }

    @Override
    public void menuDragMouseDragged(MenuDragMouseEvent e) {
        System.out.println("dragged");
        HDStepInternalFrame selectedFrame = this.frame.getDesktopPane().getSelectedFrame();

        if (selectedFrame != null) {
            selectedFrame.setTransferHandler(handler);
            DraggableComponent component = new Wire();
            this.frame.add(component);
            System.out.println(selectedFrame.getPanel().getElements().size());
        } else {
            System.out.println("no frame is selected");
            JOptionPane.showMessageDialog(this.frame, "kein Fenster aktiviert");
        }

    }

    @Override
    public void menuDragMouseReleased(MenuDragMouseEvent e) {
        System.out.println("released");
    }
}
