package designPattern.pattern9.case2;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 原本的实现类
        Circle circle = new Circle();
        circle.draw();
//        circle show

        // 使用装饰模式添加功能之后的装饰类
        CircleDecorator circleDecorator = new CircleDecorator(circle);
        circleDecorator.draw();

//        circle show
//        red show
    }

}
