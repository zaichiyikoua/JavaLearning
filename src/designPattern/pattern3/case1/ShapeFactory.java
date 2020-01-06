package designPattern.pattern3.case1;

//实现工厂1
public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        // TODO Auto-generated method stub
        if (shape.equalsIgnoreCase("cirlce")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("square")) {
            return new Square();
        }
        return null;
    }

}
