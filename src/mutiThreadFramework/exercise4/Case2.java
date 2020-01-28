package mutiThreadFramework.exercise4;

import java.util.concurrent.CountDownLatch;

/*
*	多线程API和框架   练习题
*	@author  zaichiyikoua
*	@time  2020年1月28日
*	@description  { countDownLatch的使用之 多个线程与同步点间阻塞的特性 }
*/

public class Case2 {
    // 线程之间必须达到同步点之后才能继续向下执行
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountDownLatch comingTag = new CountDownLatch(5);
        CountDownLatch waitTag = new CountDownLatch(1);
        CountDownLatch waitRunTag = new CountDownLatch(5);
        CountDownLatch beginTag = new CountDownLatch(1);
        CountDownLatch endTag = new CountDownLatch(5);

        Thread[] threadArray = new Thread[5];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        System.out.println("运动员开始比赛");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "入场了");
                        comingTag.countDown();
                        System.out.println("裁判暂停");
                        waitTag.countDown();
                        System.out.println("各就各位");
                        Thread.sleep((long) (Math.random() * 10000));
                        waitRunTag.countDown();
                        beginTag.await();
                        System.out.println("线程" + Thread.currentThread().getName() + "起跑了");
                        Thread.sleep((long) (Math.random() * 10000));
                        endTag.countDown();
                        System.out.println("线程" + Thread.currentThread().getName() + "到达终点了");
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
            });
            threadArray[i].start();
        }
        try {
            System.out.println("裁判等待选手入场");
            comingTag.await();
            System.out.println("等待3秒");
            Thread.sleep(3000);
            waitTag.countDown();
            System.out.println("就位");
            waitRunTag.await();
            Thread.sleep(2000);
            System.out.println("发令枪发令");
            beginTag.countDown();
            endTag.await();
            System.out.println("比赛结束，统计名次");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
