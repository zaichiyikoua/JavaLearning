package designPattern.pattern11.case1;

//请求类
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("stock buy show" + "name=" + name + " quantity=" + quantity);
    }

    public void sell() {
        System.out.println("stock sell show" + "name=" + name + " quantity=" + quantity);
    }
}
