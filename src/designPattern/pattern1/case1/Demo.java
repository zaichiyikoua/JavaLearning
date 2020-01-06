package designPattern.pattern1.case1;

public class Demo {
    public static void main(String[] args) {
        // 通过调用工厂的静态方法来创建实例对象
        TV tv = TVFactory.getTV("haier");
        System.out.println(tv.toString());
    }
}
