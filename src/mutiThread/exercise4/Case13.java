package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题13
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	Lock的一些常用api之 hasQueuedThread() }
*/

public class Case13 {
    // hasQueuedThread()的作用是来查询指定的线程是否在等待获得锁
    // 简单点就是判断参数中的线程是否在等待队列中
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReentrantLock lock = new ReentrantLock();
        @SuppressWarnings("unused")
        Condition condition = lock.newCondition();

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    Thread.sleep(5000);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        // 晚一点启动线程2，加大概率让2进入等待队列
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread thread2 = new Thread(runnable);
        thread2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(lock.hasQueuedThread(thread));// false
        System.out.println(lock.hasQueuedThread(thread2));// true
    }

}
