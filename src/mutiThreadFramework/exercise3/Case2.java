package mutiThreadFramework.exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题2
*	@author  zaichiyikoua
*	@time  2020年1月14日
*	@description  { 使用executor工厂来创建线程池之 验证这个线程池 }
*/

public class Case2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(new MyRunnable("" + (i + 1)));
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("####");
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(new MyRunnable("" + (i + 1)));
        }

//      pool-1-thread-3 userName=3 beginTime1578990055801
//      pool-1-thread-5 userName=5 beginTime1578990055802
//      pool-1-thread-4 userName=4 beginTime1578990055802
//      pool-1-thread-1 userName=1 beginTime1578990055801
//      pool-1-thread-2 userName=2 beginTime1578990055801
//      pool-1-thread-1 userName=1 endTime1578990055802
//      pool-1-thread-4 userName=4 endTime1578990055802
//      pool-1-thread-5 userName=5 endTime1578990055802
//      pool-1-thread-3 userName=3 endTime1578990055802
//      pool-1-thread-2 userName=2 endTime1578990055802
//      ####
//      pool-1-thread-4 userName=1 beginTime1578990056802
//      pool-1-thread-4 userName=1 endTime1578990056802
//      pool-1-thread-2 userName=2 beginTime1578990056802
//      pool-1-thread-2 userName=2 endTime1578990056802
//      pool-1-thread-5 userName=3 beginTime1578990056802
//      pool-1-thread-3 userName=4 beginTime1578990056802
//      pool-1-thread-3 userName=4 endTime1578990056802
//      pool-1-thread-1 userName=5 beginTime1578990056802
//      pool-1-thread-5 userName=3 endTime1578990056802
//      pool-1-thread-1 userName=5 endTime1578990056802
        // 可以看到,线程进行了复用,体现了线程池的作用,避免了重复创建线程
    }

}

class MyRunnable implements Runnable {
    private String userName;

    public MyRunnable(String userName) {
        super();
        this.userName = userName;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(
                Thread.currentThread().getName() + " userName=" + userName + " beginTime" + System.currentTimeMillis());
        System.out.println(
                Thread.currentThread().getName() + " userName=" + userName + " endTime" + System.currentTimeMillis());
    }

}
