package mutiThread.exercise3;

/*
*	多线程核心   练习题9
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	生产者和消费者模式之	一生产和一消费(操作值) }
*/

public class Case9 {
    // Case6中曾经提到过的标志位，同样这里是操作值
    private static String VALUE = "";

    // 这是最最经典的生产者消费者模式，也是特别经典的并发面试题之一
    // ***************************************************************************************************
    // 要注意，在多生产者和多消费者(操作值)的情况下，如果使用notify()会出现“假死”状态，即全部的线程都进入waiting状态
    // 解决办法就是将notify()换成notifyAll()
    // 所以尽量的养成习惯，能使用notifyAll()就用它
    // ***************************************************************************************************
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object lock = new Object();
        // 生产者线程
        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        synchronized (lock) {
                            while (!VALUE.equals("")) {
                                lock.wait();
                            }
                            System.out.println("VALUE=" + VALUE);
                            VALUE = "123";
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }, "线程A");
        // 消费者线程
        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        synchronized (lock) {
                            while (VALUE.equals("")) {
                                lock.wait();
                            }
                            System.out.println("VALUE=" + VALUE);
                            VALUE = "";
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
        threadB.start();
        // 输出如下：
//		VALUE=123
//		VALUE=
//		VALUE=123
//		VALUE=
//		VALUE=123
//		VALUE=
//		VALUE=123
//		VALUE=
        // 可以看到两个线程交替输出
    }

}
