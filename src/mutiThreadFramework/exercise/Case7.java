package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题7
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Semaphore的常用API之 getQueueLength()和hasQueuedThreads() }
*/

public class Case7 {

    // getQueueLength()的作用是取得等待许可的线程的数量
    // hasQueuedThreads()的作用是判断是否有线程在等待这个许可，这个返回是boolean
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("还有" + semaphore.getQueueLength() + "个线程在等待");
                    System.out.println("是否有线程正在等待信号量呢？" + semaphore.hasQueuedThreads());
                    semaphore.release();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };
    }

}
