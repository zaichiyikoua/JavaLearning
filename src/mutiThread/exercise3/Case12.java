package mutiThread.exercise3;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题12
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	ThreadLocal的使用之	线程之间的隔离性  }
*/

public class Case12 {
    // 虽然LOCAL是静态的，但是每个线程只对自己的map可见
    public static ThreadLocal<Object> LOCAL = new ThreadLocal<Object>();

    // ThreadLocal可以向每个线程存储自己的私有数据，每个线程之间互不影响，各玩各的
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    for (int i = 0; i < 10; i++) {
                        Case12.LOCAL.set("A" + (i + 1));
                        System.out.println("A get" + Case12.LOCAL.get());
                        int value = (int) (Math.random() * 1000);
                        TimeUnit.SECONDS.sleep(value);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    for (int i = 0; i < 10; i++) {
                        Case12.LOCAL.set("B" + (i + 1));
                        System.out.println("B get" + Case12.LOCAL.get());
                        int value = (int) (Math.random() * 1000);
                        TimeUnit.SECONDS.sleep(value);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        for (int i = 0; i < 10; i++) {
            Case12.LOCAL.set("main" + (i + 1));
            System.out.println("main get" + Case12.LOCAL.get());
            int value = (int) (Math.random() * 1000);
            try {
                TimeUnit.SECONDS.sleep(value);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // 输出如下：
//		A getA1
//		main getmain1
//		B getB1

        // 可以看到每个线程之间有不同的值
    }

}
