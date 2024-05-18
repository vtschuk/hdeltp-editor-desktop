package devoss.hdstep.desktop.sheet.components.analog;

import devoss.hdstep.desktop.sheet.components.DraggableComponent;

public class Wire extends DraggableComponent {
    private int startx;

    public void setStartx(int startx) {
        this.startx = startx;
    }

    public void setStarty(int starty) {
        this.starty = starty;
    }

    public void setEndx(int endx) {
        this.endx = endx;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }

    public int getStartx() {
        return startx;
    }

    public int getStarty() {
        return starty;
    }

    public int getEndx() {
        return endx;
    }

    public int getEndy() {
        return endy;
    }

    private int starty;
    private int endx;
    private int endy;
}
