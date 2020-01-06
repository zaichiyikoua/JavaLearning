package designPattern.pattern3.case1;

//实现工厂2
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        // TODO Auto-generated method stub
        if (color.equalsIgnoreCase("red")) {
            return new Red();
        } else if (color.equalsIgnoreCase("blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        // TODO Auto-generated method stub
        return null;
    }

}
