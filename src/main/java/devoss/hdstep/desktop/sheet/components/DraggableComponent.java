package devoss.hdstep.desktop.sheet.components;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;

public class DraggableComponent extends JComponent implements DragGestureListener, DragSourceListener {
    DragSource dragSource;
    private String svg;
    private Boolean simulable;

    public DraggableComponent() {
        this("");
    }

    public DraggableComponent(String svg) {
        this(svg, false);
    }

    public DraggableComponent(String svg, Boolean simulable) {
        this.svg = svg;
        this.simulable = simulable;
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String getSvg() {
        return svg;
    }

    public Boolean getSimulable() {
        return simulable;
    }

    public void setSimulable(Boolean simulable) {
        this.simulable = simulable;
    }

    public void dragGestureRecognized(DragGestureEvent evt) {
        Transferable t = new StringSelection("aString");
        dragSource.startDrag(evt, DragSource.DefaultCopyDrop, t, this);
    }

    public void dragEnter(DragSourceDragEvent evt) {
        System.out.println("enters");
    }

    public void dragOver(DragSourceDragEvent evt) {
        System.out.println("over");
    }

    public void dragExit(DragSourceEvent evt) {
        System.out.println("leaves");
    }

    public void dropActionChanged(DragSourceDragEvent evt) {
        System.out.println("changes the drag action between copy or move");
    }

    public void dragDropEnd(DragSourceDropEvent evt) {
        System.out.println("finishes or cancels the drag operation");
    }


}
