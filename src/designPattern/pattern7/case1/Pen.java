package designPattern.pattern7.case1;

//抽象类
public abstract class Pen {
    protected Color color;

    public Pen(Color color) {
        this.color = color;
    }

    public abstract void draw(String name);
}
