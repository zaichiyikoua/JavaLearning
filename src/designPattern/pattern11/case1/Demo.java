package designPattern.pattern11.case1;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stock stock = new Stock();

        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        Broker broker = new Broker();

        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        broker.placeOrders();
    }

}
