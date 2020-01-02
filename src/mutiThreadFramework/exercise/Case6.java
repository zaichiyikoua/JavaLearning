package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;

/*
*	多线程API和框架   练习题6
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Semaphore的常用API之 drainPermits() }
*/

public class Case6 {

    // drainPermits()的作用是可以获取并且返回立即可用的所有许可个数，并且将可用的许可数量设置为0
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println(semaphore.availablePermits());
                    System.out.println(semaphore.drainPermits());
                    System.out.println(semaphore.availablePermits());
                    semaphore.release();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

//    9
//    9
//    0
}
