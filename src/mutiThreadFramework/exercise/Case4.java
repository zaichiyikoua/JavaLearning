package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题4
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Semaphore的常用API之 acquireUninterruptibly() }
*/

public class Case4 {

    // 成功中断
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(1);
        Runnable runnable = new Runnable() {
            @SuppressWarnings("unused")
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "begin time=" + System.currentTimeMillis());
                    for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                        String string = new String();
                        Math.random();
                    }
                    System.out.println(Thread.currentThread().getName() + "end time=" + System.currentTimeMillis());
                    semaphore.release();
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("线程" + Thread.currentThread().getName() + "进入了catch");
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        thread2.interrupt();
        System.out.println("main中断了线程2");

        // 线程2被成功的中断了
//        线程Thread-1进入了catch
//        main中断了线程2
//        java.lang.InterruptedException
    }

    // 使用acquireUninterruptibly()让线程不能被中断
    // acquireUninterruptibly()的作用就是使等待acquire()的线程不允许被中断
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Runnable runnable = new Runnable() {
            @SuppressWarnings("unused")
            @Override
            public void run() {
                semaphore.acquireUninterruptibly();
                System.out.println(Thread.currentThread().getName() + "begin time=" + System.currentTimeMillis());
                for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                    String string = new String();
                    Math.random();
                }
                System.out.println(Thread.currentThread().getName() + "end time=" + System.currentTimeMillis());
                semaphore.release();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        thread2.interrupt();
        System.out.println("main中断了线程2");

        // 没有被中断
//        Thread-0begin time=1577952920859
//        main中断了线程2
//        Thread-0end time=1577952922126
//        Thread-1begin time=1577952922126
//        Thread-1end time=1577952923318

    }
}
