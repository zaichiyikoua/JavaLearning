package designPattern.pattern9.case2;

//抽象装饰类
public abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        super();
        this.shape = shape;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        shape.draw();
    }

}
