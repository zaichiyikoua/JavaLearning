package mutiThread.exercise4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题8
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	公平锁和非公平锁  }
*/

public class Case8 {
    // 公平锁：采用先到先得的策略，
    // 每次获得锁之前都会检查队列里面有没有排队等待的线程
    // 没有才会获得锁，如果有就将当前线程追加到队列中

    // 非公平锁：采用有机会就插队的策略，
    // 在线程获得锁之前会去先尝试一下获得锁而不是直接在队列中等待
    // 如果尝试获取成功，说明线程虽然是后启动的，但先获得了锁，也就是作弊的效果
    // 没有成功就加入队列等待

    // 公平锁情况
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Service service = new Service(true);
        TestThread[] arrOne = new TestThread[10];
        TestThread[] arrTwo = new TestThread[10];

        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = new TestThread(service);
            arrOne[i].setName("arrOne++++" + (i + 1));
        }
        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i].start();
        }

        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = new TestThread(service);
            arrTwo[i].setName("arrTwo----" + (i + 1));
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i].start();
        }

        // 输出如下：
//		methodOnearrOne++++1
//		methodOnearrOne++++2
//		methodOnearrOne++++3
//		methodOnearrOne++++4
//		methodOnearrOne++++5
//		methodOnearrOne++++7
//		methodOnearrOne++++6
//		methodOnearrOne++++8
//		methodOnearrOne++++9
//		methodOnearrOne++++10
//		methodOnearrTwo----1
//		methodOnearrTwo----2
//		methodOnearrTwo----3
//		methodOnearrTwo----4
//		methodOnearrTwo----5
//		methodOnearrTwo----6
//		methodOnearrTwo----7
//		methodOnearrTwo----8
//		methodOnearrTwo----9
//		methodOnearrTwo----10

        // 可以看到，在reentrantLock启用公平锁的情况下，后运行的没有任何机会抢到锁
    }

    // 非公平锁的情况
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Service service = new Service(false);
        TestThread[] arrOne = new TestThread[10];
        TestThread[] arrTwo = new TestThread[10];

        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = new TestThread(service);
            arrOne[i].setName("arrOne++++" + (i + 1));
        }
        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i].start();
        }

        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = new TestThread(service);
            arrTwo[i].setName("arrTwo----" + (i + 1));
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i].start();
        }
    }
}

//拆分出来的服务类
class Service {
    public Lock lock;

    // reentrantLock是可以带参的，true/false来实现公平和非公平的锁
    public Service(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void methodOne() {
        try {
            lock.lock();
            System.out.println("methodOne" + Thread.currentThread().getName());
            // 此处的1000ms是为了配合main中的1000ms
            // 让线程有机会在非公平情况下抢到锁
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            // TODO: handle finally clause
            lock.unlock();
        }
    }
}

//线程类
class TestThread extends Thread {
    private Service service;

    public TestThread(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        service.methodOne();
    }

}