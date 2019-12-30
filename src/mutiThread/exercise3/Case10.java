package mutiThread.exercise3;

import java.util.ArrayList;
import java.util.List;

/*
*	多线程核心   练习题10
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	生产者和消费者模式之	一生产和一消费(操作栈) }
*/

public class Case10 {
    // 为了简单，设定最大容量为1
    private static List<Integer> list = new ArrayList<Integer>();

    // 可以看到，操作值和操作栈是一样的
    // ********************************************************************************
    // 要注意，在一生产者和多消费者(操作栈)的情况下，如果使用if来判断会出现“假死”状态
    // 条件发生改变时，没有及时得到响应，所以多个wait()状态的线程被唤醒，继续操作list的时候会出错
    // 解决办法就是将if换成while语句
    // 所以尽量的养成习惯，能使用while就用它
    // ********************************************************************************

    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // 经由Case9和Case10得知
    // 想要实现任意数量的几对几 生产者消费者模式 的实例，可以使用notifyAll()和while结合，
    // 这种组合具有通用性
    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object lock = new Object();
        // 生产者
        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        synchronized (lock) {
                            while (list.size() == 1) {
                                lock.wait();
                            }
                            list.add(3);
                            System.out.println("push=" + list.size());
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }, "线程A");
        // 消费者
        Thread theradB = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        synchronized (lock) {
                            while (list.size() == 0) {
                                System.out.println("pop=" + list.size());
                                lock.wait();
                            }
                            list.remove(0);
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }, "线程B");

        threadA.start();
        theradB.start();

        // 输出如下：
//		pop=0
//		push=1
//		pop=0
//		push=1
//		pop=0
//		push=1
//		pop=0
//		push=1
        // 可以看到和操作值一样，也是交替打印的，最大容量为1
    }

}
