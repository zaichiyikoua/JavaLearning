package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;

/*
*	多线程API和框架   练习题9
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { 多进路-多处理-多出路 }
*/

public class Case9 {

    // semaphore只会限定线程的并发量，不会去管线程的非线程安全问题
    // 所以这里会几个线程同时执行，每个线程处理自己的任务
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "准备");
                    System.out.println("begin time=" + System.currentTimeMillis());
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + "打印输出" + (i + 1));
                    }
                    System.out.println("end time=" + System.currentTimeMillis());
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
