package mutiThread.exercise3;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题4
*	@author  zaichiyikoua
*	@time  2019年12月26日
*	@description  {	interrupt()和wait() }
*/

public class Case4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object lock = new Object();
        Thread threadA = new Thread(new Runnable() {

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
        }, "线程A");
        threadA.start();

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        threadA.interrupt();
        // 输出如下：
//		begin wait
//		java.lang.InterruptedException
//			at java.lang.Object.wait(Native Method)
//			at java.lang.Object.wait(Unknown Source)
//			at mutiThread.exercise3.Case4$1.run(Case4.java:25)
//			at java.lang.Thread.run(Unknown Source)

        // 线程调用wait()之后，如果对该线程对象执行interrupt(),会抛出异常
        // 在执行同步的时候，遇到线程异常而终止的话，锁会被释放
    }

}
