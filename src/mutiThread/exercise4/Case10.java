package mutiThread.exercise4;

import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题10
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	Lock的一些常用api之 getQueueLength() }
*/

public class Case10 {
    // getQueueLength()方法的作用是返回正在等待获取此锁的线程数量
    public ReentrantLock lock = new ReentrantLock();

    public void methodOne() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "进入方法");
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            // TODO: handle finally clause
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Case10 service = new Case10();
        Runnable runnable = new Runnable() {
            public void run() {
                service.methodOne();
            }
        };

        Thread[] ThreadArr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            ThreadArr[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            ThreadArr[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("有线程数：" + service.lock.getQueueLength() + "在等待获取锁");

//		ThreadName=Thread-1进入方法
//		ThreadName=Thread-0进入方法
//		有线程数：8在等待获取锁
    }

}
