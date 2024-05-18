package devoss.hdstep.desktop.sheet.elements;

public class Circle extends Element {
    public Integer getRadus() {
        return radus;
    }

    public void setRadus(Integer radus) {
        this.radus = radus;
    }

    private Integer radus = Integer.valueOf(0);

    @Override
    public void save() {

    }
}
