package designPattern.pattern11.case1;

import java.util.ArrayList;
import java.util.List;

//调用者，或者说发送者/请求者
public class Broker {
    private List<Order> list = new ArrayList<Order>();

    public void takeOrder(Order order) {
        list.add(order);
    }

    public void placeOrders() {
        for (Order order : list) {
            order.execute();
        }
        list.clear();
    }
}
