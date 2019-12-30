package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题8
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	sleep方法的使用和优化	}
*/

public class MyThread8 extends Thread {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("run ThreadName=" + Thread.currentThread().getName() + " begin");
        try {
            // 如果调用sleep()方法的类是Thread，那么 this.sleep()和Thread.sleep()效果是一样的
            // 如果不是，那么必需使用Thread.sleep()
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("run ThreadName=" + Thread.currentThread().getName() + " end");

        System.out.println("use TimeUnit");
        try {
            // 主要优化
            // 基本上Thread.sleep()都会被TimeUnit这样的工具类代替
            // Thinking in Java中也是推荐使用工具类
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("TimeUnit end");
    }

    public static void main(String[] args) {
        MyThread8 thread = new MyThread8();
        Thread t1 = new Thread(thread, "A");
        t1.start();
    }
}
