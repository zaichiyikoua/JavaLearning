package mutiThread.exercise2;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	实例变量非线程安全问题和解决方案  }
*/

public class Case {
    private int count = 0;

    synchronized public void add(String name) {
        try {
            if (name.equals("a")) {
                count++;
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

    // 这种情况就是两个线程同时访问同一个对象中没有同步的方法
    // 解决方法也很简单，将该方法加上synchronized,使其变成同步方法
    public static void main(String[] args) {
        Case service = new Case();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.add("a");
            }
        }, "线程A").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                service.add("b");
            }
        }, "线程B").start();
        // 输出
//		a *** over
//		b *** over
//		bcount =200
//		acount =200
        // 加上之后输出
//		a *** over
//		acount =1
//		b *** over
//		bcount =200
    }
}
