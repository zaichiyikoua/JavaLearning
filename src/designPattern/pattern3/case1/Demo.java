package designPattern.pattern3.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractFactory colorFactory = FactoryProducer.getFactory("colorfactory");
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shapeFactory");

        Color red = colorFactory.getColor("red");
        red.fill();
        Color blue = colorFactory.getColor("blue");
        blue.fill();

        Shape circle = shapeFactory.getShape("cirlce");
        circle.draw();
        Shape square = shapeFactory.getShape("square");
        square.draw();

//        red show
//        blue show
//        circle show
//        square show
    }

}
