package mutiThreadFramework.exercise;

import java.util.concurrent.Semaphore;

/*
*	多线程API和框架   练习题8
*	@author  zaichiyikoua
*	@time  2020年1月2日
*	@description  { Semaphore的方法tryAcquire()的使用 }
*/

public class Case8 {

    // 要重点掌握的技能⬇
    // tryAcquire()的作用是尝试地去获取一个许可，如果没有获得许可则返回false
    // 通常和if/else一起使用，具有无阻塞的特点，可以使线程不至于在同步处一直处于等待状态
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Semaphore semaphore = new Semaphore(1);
        Runnable runnable = new Runnable() {
            @SuppressWarnings("unused")
            @Override
            public void run() {
                if (semaphore.tryAcquire()) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "首先进入");
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {
                        String string = new String();
                        Math.random();
                    }
                    semaphore.release();
                } else {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + "没有进入");
                }
            }
        };

        Thread thread = new Thread(runnable, "A");
        thread.start();
        Thread thread2 = new Thread(runnable, "B");
        thread2.start();

//        ThreadName=A首先进入
//        ThreadName=B没有进入
    }

}
