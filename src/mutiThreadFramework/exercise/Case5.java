package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;

/*
*	多线程API和框架   练习题5
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Semaphore的常用API之 availablePermits()}
*/

public class Case5 {

    // availablePermits()的作用就是返回此时Semaphore对象中当前可用的许可的数量
    // 非常常用，基本上调试都会用它，因为经常许可的数量是会变化的
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
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

//        9
    }

}
