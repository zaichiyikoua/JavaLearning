package designPattern.pattern7.case1;

//扩展抽象类
public class BigPen extends Pen{

    public BigPen(Color color) {
        super(color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void draw(String name) {
        // TODO Auto-generated method stub
        String penType = "大号笔";
        this.color.bepaint(penType, name);
    }

}
