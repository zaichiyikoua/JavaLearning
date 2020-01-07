package designPattern.pattern7.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pen redbBigPen = new BigPen(new Red());
        Pen blueBigPen = new BigPen(new Blue());
        Pen redMidPen = new MiddlePen(new Red());
        Pen blueMidPen = new MiddlePen(new Blue());

        redbBigPen.draw("hello");
        blueBigPen.draw("world");
        redMidPen.draw("java");
        blueMidPen.draw("best language");
        
//        大号笔 red hello
//        大号笔 blue world
//        中号笔 red java
//        中号笔 blue best language

    }

}
