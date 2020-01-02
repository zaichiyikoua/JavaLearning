package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题3
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { acquire()的参数作用及动态添加permit许可数量 }
*/

public class Case3 {

    // acquire()的作用就是每次调用这个方法，会消耗掉参数中数量的许可
    // 下面的例子，每次运行一个线程要消耗掉2个许可，总共10个许可，
    // 所以同一时间内只允许最大5个线程执行acquire()和release()之间的代码
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(10);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire(2);
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "begin time="
                            + System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "停止了3秒");
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "begin time="
                            + System.currentTimeMillis());
                    semaphore.release();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        };

        Thread[] arr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Thread(runnable);
            arr[i].start();
        }

        // 部分输出:
//        ThreadName=Thread-0begin time=1577950643737
//        ThreadName=Thread-1begin time=1577950643737
//        ThreadName=Thread-2begin time=1577950643737
//        ThreadName=Thread-3begin time=1577950643737
//        ThreadName=Thread-4begin time=1577950643738
//        ThreadName=Thread-4停止了3秒
//        ThreadName=Thread-0停止了3秒
//        ThreadName=Thread-2停止了3秒
    }

    // 如果多次调用release()或者release(int)方法，可以动态的增加permit的个数
    // 说明new Semaphore(5)构造器中的5不是最终的许可数量，仅仅是初始的状态值
    public static void main(String[] args) {
        try {
            Semaphore semaphore = new Semaphore(5);
            // 5个
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            // 6次
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.release(4);
            System.out.println(semaphore.availablePermits());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

//        0
//        6
//        10

    }
}
