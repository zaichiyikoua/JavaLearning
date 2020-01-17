package designPattern.pattern11.case1;

//具体命令实现类
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        super();
        this.stock = stock;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        stock.sell();
    }

}
