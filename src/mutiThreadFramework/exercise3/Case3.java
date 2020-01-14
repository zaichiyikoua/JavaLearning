package mutiThreadFramework.exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题3
*	@author  zaichiyikoua
*	@time  2020年1月14日
*	@description  { 使用executor工厂来创建线程池之 使用newFixedThreadPool来创建线程池 }
*/

public class Case3 {
    // newFixedThreadPool和cached的区别就是有无界
    // 简单点来说,fixed是有界的,能指定线程池的最大容量
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(new MyThread("" + (i + 1)));
        }
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(new MyThread("" + (i + 1)));
        }
    }

}

class MyThread implements Runnable {
    private String userName;

    public MyThread(String userName) {
        super();
        this.userName = userName;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println(Thread.currentThread().getName() + " userName=" + userName + " beginTime"
                    + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + " userName=" + userName + " endTime"
                    + System.currentTimeMillis());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
