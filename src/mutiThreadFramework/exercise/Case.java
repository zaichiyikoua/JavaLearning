package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月31日
*	@description  { Semaphore的同步性 }
*/

public class Case {

    // Semaphore类完全是synchronized的超级加强版，提供的功能更加强大
    // Semaphore的意思是信号，主要的作用是能控制并发的线程数量
    // 如果不控制并发数量，CPU的资源很快会被耗尽，每个线程执行任务会变得缓慢

    // 下面是具体用法
    // 可以看到，需要同步的代码要放在acquire()和release()之间，这点和ReentrantLock很像
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(1);

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

        // 可以看到，在没有使用synchronized关键字也没有使用ReentrantLock的情况下也实现了同步
//        ThreadName=线程A,beginTime=1577784318097
//        ThreadName=线程A,endTime=1577784321097
//        ThreadName=线程B,beginTime=1577784321097
//        ThreadName=线程B,endTime=1577784324098
//        ThreadName=线程C,beginTime=1577784324098
//        ThreadName=线程C,endTime=1577784327098

    }

}
