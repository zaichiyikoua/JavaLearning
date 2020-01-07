package designPattern.pattern7.case1;

//抽象实现类
public class MiddlePen extends Pen{

    public MiddlePen(Color color) {
        super(color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void draw(String name) {
        // TODO Auto-generated method stub
        String penType = "中号笔";
        this.color.bepaint(penType, name);
    }

}
