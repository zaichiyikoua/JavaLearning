package designPattern.pattern3.case1;

//工厂生成器
public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equalsIgnoreCase("shapeFactory")) {
            return new ShapeFactory();
        } else if (factoryName.equalsIgnoreCase("colorFactory")) {
            return new ColorFactory();
        }
        return null;
    }
}
