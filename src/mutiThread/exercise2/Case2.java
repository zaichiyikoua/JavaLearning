package mutiThread.exercise2;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	多个对象多个锁  }
*/

public class Case2 {
    private int count = 0;

    synchronized public void add(String name) {
        try {
            if (name.equals("a")) {
                count = 100;
                System.out.println("a *** over");
                TimeUnit.SECONDS.sleep(2);
            } else {
                count = 200;
                System.out.println("b *** over");
            }
            System.out.println(name + "count =" + count);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 两个线程两个不同的锁，处于一对一的关系，各玩各的，不存在争抢关系
    // 这种情况下不存在非线程安全问题
    public static void main(String[] args) {
        Case2 service1 = new Case2();
        Case2 service2 = new Case2();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service1.add("a");
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service2.add("b");
            }
        }, "线程B").start();
        // 输出
//		a *** over
//		b *** over
//		bcount =200
//		acount =100
    }
}
