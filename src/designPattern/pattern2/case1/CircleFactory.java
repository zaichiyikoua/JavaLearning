package designPattern.pattern2.case1;

//工厂实现类
public class CircleFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        // TODO Auto-generated method stub
        return new Circle();
    }

}
