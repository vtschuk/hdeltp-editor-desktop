package devoss.hdstep.desktop.sheet.elements;

public abstract  class Element {
    public Integer getStartX() {
        return startX;
    }

    public Integer getStartY() {
        return startY;
    }

    public void setStartX(Integer startX) {
        this.startX = startX;
    }

    public void setStartY(Integer startY) {
        this.startY = startY;
    }

    public abstract void save();
    private Integer startX = Integer.valueOf(0);
    private Integer startY = Integer.valueOf(0);
}
