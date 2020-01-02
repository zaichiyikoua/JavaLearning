package mutiThreadInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//经典多线程题
//实现一个容器，提供两个方法  add size
//写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数
//当元素个数到达5个时，线程2给出提示并结束

public class Classic {
    // list要可见
    volatile List<Integer> list = new ArrayList<Integer>();

    public void add(Integer element) {
        list.add(element);
    }

    public int size() {
        return list.size();
    }

    // 优化 使用countDownLatch 不涉及锁定 用await和countdown来代替wait和notify
    // 但是要注意此时只涉及线程通信 不涉及线程同步
    public static void main(String[] args) {
        Classic classic = new Classic();
        CountDownLatch latch = new CountDownLatch(1);
        // 监视线程先启动
        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程2 启动");
                while (classic.size() != 5) {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2 结束");
            }
        }, "线程2").start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程1 启动");
                for (int i = 0; i < 10; i++) {
                    classic.add(new Integer(i));
                    System.out.println(i);
                    if (classic.size() == 5) {
                        latch.countDown();
                    }
                    try {
                        // 使用工具类
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1 结束");
            }
        }, "线程1").start();
    }
    /*
     * public static void main(String[] args) { Classic threading = new Classic();
     * // 锁 Object lock = new Object();
     * 
     * new Thread(new Runnable() { public void run() { System.out.println("线程2 启动");
     * synchronized (lock) { while (threading.size() != 5) { // 线程挂起 try {
     * lock.wait(); } catch (InterruptedException e) { // TODO Auto-generated catch
     * block e.printStackTrace(); } } System.out.println("线程2 结束"); // 线程结束，让线程1
     * 继续执行 // 线程结束 释放锁 lock.notifyAll(); }
     * 
     * } }, "线程2").start();
     * 
     * new Thread(new Runnable() { public void run() { System.out.println("线程1 开始");
     * synchronized (lock) { for (int i = 0; i < 10; i++) { threading.add(new
     * Integer(i)); System.out.println(i); // 如果为 5 唤醒线程2 if (threading.size() == 5)
     * { // 这里要注意 notifyAll,notify都不会释放锁 lock.notifyAll(); // 所以这里要释放锁 才能让线程2 执行 try
     * { lock.wait(); } catch (InterruptedException e) { // TODO Auto-generated
     * catch block e.printStackTrace(); } } try { Thread.sleep(1000); } catch
     * (InterruptedException e) { // TODO Auto-generated catch block
     * e.printStackTrace(); } } } System.out.println("线程1 结束"); } }, "线程1").start();
     * 
     * }
     */
}
