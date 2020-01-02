package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程API和框架   练习题10
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { 多进路-单处理-多出路 }
*/

public class Case10 {

    // 解决办法很简单，加一个锁即可
    // 这样会同时限定并发的数量，也能保证线程的同步
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(3);
        ReentrantLock lock = new ReentrantLock(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "准备");
                    lock.lock();
                    System.out.println("begin time=" + System.currentTimeMillis());
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + "打印输出" + (i + 1));
                    }
                    System.out.println("end time=" + System.currentTimeMillis());
                    lock.unlock();
                    semaphore.release();
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "结束");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };

        Thread[] arr = new Thread[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(runnable);
            arr[i].start();
        }
    }

}
