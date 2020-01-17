package designPattern.pattern10.case1;

//外观类
public class ShapeMaker {
    private Shape circle;
    private Shape square;

    public ShapeMaker() {
        super();
        circle = new Circle();
        square = new Square();
    }

    public void circleDraw() {
        circle.draw();
    }

    public void squareDraw() {
        square.draw();
    }
}
