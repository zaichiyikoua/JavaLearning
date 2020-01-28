package mutiThreadFramework.exercise4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
*	多线程API和框架   练习题
*	@author  zaichiyikoua
*	@time  2020年1月28日
*	@description  { countDownLatch的使用之 初步使用 }
*/

public class Case {
    // countDownLatch类是一个辅助类，使用效果是给定一个计数，当使用这个给countDownLatch的线程判断是不是0
    // 如果是0，那么继续运行，如果不是0，那么呈现等待状态

    // 基本使用需要使用await和countDown方法来进行。调用await的时候判断计数是否为0，如果不为0则等待，其他线程可以调用countDown方法将计数减一
    // 当计数减到0的时候，呈现等待的线程继续运行
    // 需要注意的是，计数是无法重置的，这也是countDownLatch的缺点
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    System.out.println("A");
                    countDownLatch.await();
                    System.out.println("AB");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    System.out.println("C");
                    countDownLatch.getCount();
                    countDownLatch.countDown();
                    System.out.println("CD");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        threadB.start();
    }

//    A
//    C
//    CD
//    AB

}
