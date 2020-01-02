package mutiThreadFramework.exercise;

import java.util.concurrent.Exchanger;

/*
*	多线程API和框架   练习题13
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Exchanger的使用之 exchange()来传递数据 }
*/

public class Case13 {

    // Exchange类的作用就是让两个线程之间可以交换数据，这比生产者/消费者模式用的await/signalAll要更加高效
    // 同时，使用也很简单
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Exchanger<String> exchanger = new Exchanger<String>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("在线程A中获得线程B的值=" + exchanger.exchange("A"));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }, "线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("在线程B中获得线程A的值=" + exchanger.exchange("B"));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }, "线程B").start();
    }

//      在线程A中获得线程B的值=B
//      在线程B中获得线程A的值=A

}
