package mutiThreadFramework.exercise;

import java.util.concurrent.Exchanger;

/*
*	多线程API和框架   练习题12
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Exchanger的使用之 exchange()的阻塞特性 }
*/

public class Case12 extends Thread {
    private Exchanger<String> exchanger;

    public Case12(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println("在线程A中获得线程B的值，值为=" + exchanger.exchange("中国A"));
            System.out.println("A end");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // exchange()方法是阻塞的，该方法被调用后，等待其他线程来取得数据
    // 如果没有其他线程来取数据，则会一直阻塞
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Exchanger<String> exchanger = new Exchanger<String>();
        Case12 Case12 = new Case12(exchanger);

        Case12.start();
        System.out.println("main end");

        // main end
    }

}
