package designPattern.pattern9.case2;

//具体实现装饰器类
public class CircleDecorator extends ShapeDecorator {

    protected Shape shape;

    public CircleDecorator(Shape shape) {
        super(shape);
        // TODO Auto-generated constructor stub
    }    

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        super.draw();
        setColor(shape);
    }

    public void setColor(Shape shape) {
        System.out.println("red show");
    }
}
