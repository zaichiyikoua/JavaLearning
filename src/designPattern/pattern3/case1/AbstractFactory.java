package designPattern.pattern3.case1;

//抽象工厂,这里是接口/抽象类都可以
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
