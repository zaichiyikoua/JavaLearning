package mutiThread.exercise3;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题5
*	@author  zaichiyikoua
*	@time  2019年12月26日
*	@description  {  过早通知和解决办法  }
*/

public class Case5 {
    // 过早通知会导致逻辑错误
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Object lock = new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("begin notify");
                    lock.notifyAll();
                    System.out.println("end notify");
                }
            }
        }, "线程B").start();
        // 这是正常输出情况：
//		begin wait
//		begin notify
//		end notify
//		end wait
    }

    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("begin notify");
                    lock.notifyAll();
                    System.out.println("end notify");
                }
            }
        }, "线程B").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    synchronized (lock) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, "线程A").start();
        // 改成这样的话，先通知wait(),那么wait()也就没有必要执行了
        // wait()永远不会被通知
//		begin notify
//		end notify
//		begin wait

    }
}
