package designPattern.pattern2.case1;

//产品和工厂之间一一对应，想要什么产品，就去什么工厂生产
public class Demo {
    public static void main(String[] args) {
        SquareFactory squareFactory = new SquareFactory();
        CircleFactory circleFactory = new CircleFactory();

        squareFactory.getShape();
        circleFactory.getShape();
    }
}
