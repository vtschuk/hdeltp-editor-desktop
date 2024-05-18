package devoss.hdstep.desktop.gui.menu.listeners.components;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ComponentTransferHandler extends TransferHandler {
    DataFlavor pictureFlavor = DataFlavor.imageFlavor;

    DataTransferComponent sourcePic;

    boolean shouldRemove;

    public boolean importData(JComponent c, Transferable t) {
        Image image;
        if (canImport(c, t.getTransferDataFlavors())) {
            DataTransferComponent pic = (DataTransferComponent) c;
            //Don't drop on myself.
            if (sourcePic == pic) {
                shouldRemove = false;
                return true;
            }
            try {
                image = (Image) t.getTransferData(pictureFlavor);
                //Set the component to the new picture.
                pic.setImage(image);
                return true;
            } catch (UnsupportedFlavorException ufe) {
                System.out.println("importData: unsupported data flavor");
            } catch (IOException ioe) {
                System.out.println("importData: I/O exception");
            }
        }
        return false;
    }

    protected Transferable createTransferable(JComponent c) {
        sourcePic = (DataTransferComponent) c;
        shouldRemove = true;
        return new PictureTransferable(sourcePic);
    }

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    protected void exportDone(JComponent c, Transferable data, int action) {
        if (shouldRemove && (action == MOVE)) {
            sourcePic.setImage(null);
        }
        sourcePic = null;
    }

    public boolean canImport(JComponent c, DataFlavor[] flavors) {
        for (int i = 0; i < flavors.length; i++) {
            if (pictureFlavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
    }

    class PictureTransferable implements Transferable {
        private Image image;

        PictureTransferable(DataTransferComponent pic) {
            image = pic.image;
        }

        public Object getTransferData(DataFlavor flavor)
                throws UnsupportedFlavorException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return image;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{pictureFlavor};
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return pictureFlavor.equals(flavor);
        }
    }
}
