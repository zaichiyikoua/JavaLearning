package mutiThread.exercise4;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
*	多线程核心   练习题16
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { 使用ReentrantReadWriteLock类  }
*/

public class Case16 {
    // ReentrantLock类具有完全排他的效果，同一时间只能有一个线程在执行任务
    // 这样做虽然保证了同时线程的安全性，但是效率比较低
    // JDK提供了新的一种读写锁---ReentrantReadWriteLock类，使用它可以在进行读操作的时候不需要同步，提升了运行速度

    // 读写锁有两个锁：1.读操作相关的锁，也叫共享锁 2.写操作相关的锁，也叫排他锁
    // 读锁之间不互斥，读锁和写锁互斥，写锁与写锁互斥。也就是说，只要出现了写锁，就会出现同步的效果
    // 读操作是指获得实例变量的值，写操作是指向实例变量写入值

    // 读读共享
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        String userName = "nihao";
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    // 差别就在这里
                    lock.readLock().lock();
                    System.out.println("begin time" + System.currentTimeMillis());
                    System.out.println("userName=" + userName);
                    Thread.sleep(3000);
                    System.out.println("end time" + System.currentTimeMillis());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.readLock().unlock();
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread.start();
        thread2.start();

        // 可以看到，读操作的话是异步的效果
//		begin time1577699833882
//		userName=nihao
//		begin time1577699833882
//		userName=nihao
//		end time1577699836884
//		end time1577699836884
    }

    // 写写互斥
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    // 差别就在这里
                    lock.writeLock().lock();
                    System.out.println("begin time" + System.currentTimeMillis() + "ThreadName="
                            + Thread.currentThread().getName());
                    Thread.sleep(3000);
                    System.out.println(
                            "end time" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.writeLock().unlock();
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread.start();
        thread2.start();

        // 同步效果
//		begin time1577700027384ThreadName=Thread-0
//		end time1577700030384ThreadName=Thread-0
//		begin time1577700030384ThreadName=Thread-1
//		end time1577700033385ThreadName=Thread-1
    }
}
