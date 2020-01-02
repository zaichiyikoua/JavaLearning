package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月31日
*	@description  { Semaphore的构造方法参数 }
*/

public class Case2 {

    // 参数的作用是设置许可的数量
    // 使同一时间内只有参数数量的线程可以执行acquire()和release()之间的代码
    // 除此之外，还可以有第二个参数，new Semaphore(permits, fair)
    // 就和ReentrantLock一样，是公平和非公平的区别
    // 公平就是获得锁的顺序和线程启动顺序一致，非公平就是线程启动顺序和获得锁的顺序无关

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(2);
//        new Semaphore(permits, fair)

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + ",beginTime="
                            + System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + ",endTime="
                            + System.currentTimeMillis());
                    semaphore.release();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

            }
        };

        Thread thread = new Thread(runnable, "线程A");
        Thread thread2 = new Thread(runnable, "线程B");
        Thread thread3 = new Thread(runnable, "线程C");

        thread.start();
        thread2.start();
        thread3.start();

//        ThreadName=线程B,beginTime=1577789466357
//        ThreadName=线程A,beginTime=1577789466358
//        ThreadName=线程A,endTime=1577789469360
//        ThreadName=线程C,beginTime=1577789469360
//        ThreadName=线程B,endTime=1577789469360
//        ThreadName=线程C,endTime=1577789472360

    }

}
