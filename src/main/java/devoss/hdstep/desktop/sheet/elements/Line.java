package devoss.hdstep.desktop.sheet.elements;

public class Line extends Element {

    public Integer getEndX() {
        return endX;
    }

    public void setEndX(Integer endX) {
        this.endX = endX;
    }

    public Integer getEndY() {
        return endY;
    }

    public void setEndY(Integer endY) {
        this.endY = endY;
    }

    private Integer endX = Integer.valueOf(0);
    private Integer endY = Integer.valueOf(0);

    @Override
    public void save() {
        int x = this.getStartX();
        int y = this.getStartY();

    }
}
