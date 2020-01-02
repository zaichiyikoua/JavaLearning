package mutiThread.exercise;

/*
*	多线程核心   练习题6
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	实例变量共享造成的非线程安全问题和解决方案之	共享数据的情况  }
*/

public class MyThread6 extends Thread {
    private int count = 5;

    // 解决方案 最简单直接的 加上synchronized关键字
    @Override
    synchronized public void run() {
        // TODO Auto-generated method stub
        super.run();
        // 这里不要用while，其他线程会得不到运行的机会，因为第一个运行执行while的线程会把count减到0
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算，count = " + count);
    }

    public static void main(String[] args) {
        MyThread6 thread = new MyThread6();

        Thread t1 = new Thread(thread, "A");
        Thread t2 = new Thread(thread, "B");
        Thread t3 = new Thread(thread, "C");
        Thread t4 = new Thread(thread, "D");
        Thread t5 = new Thread(thread, "E");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
//		输出如下
//		由A计算，count = 3
//		由B计算，count = 3
//		由C计算，count = 2
//		由D计算，count = 0
//		由E计算，count = 0

        // 由此可见产生了线程安全问题
        // 这是因为count--的操作 1.取得原有的count值 2.计算count-1 3.对count重新赋值
        // 在这三个步骤中，如果有多个线程同时访问，三个步骤的执行过程中会被其他线程打断(也就是不具备原子性)
    }
}
