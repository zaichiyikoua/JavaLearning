package mutiThreadFramework.exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*	多线程API和框架   练习题1
*	@author  zaichiyikoua
*	@time  2020年1月14日
*	@description  { 使用executor工厂来创建线程池之 newCachedThreadPool来创建无界线程池 }
*/

public class Case1 {
    // 无界线程池就是指的是线程池中存放的线程的数量是理论上的Integer.MAX_VALUE的
    // 具体实现还需要Executors这个工具类来进行创建
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    System.out.println("runnableA begin" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("A");
                    System.out.println("runnableA end" + System.currentTimeMillis());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
        cachedThreadPool.execute(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    System.out.println("runnableB begin" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("B");
                    System.out.println("runnableB end" + System.currentTimeMillis());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

//        runnableA begin1578989294611
//        runnableB begin1578989294612
        // 可以看到,两个线程几乎是同时创建,同时执行的
        // 两个线程是异步执行的
    }

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.err.println("run");
                }
            });
        }
    }
}
