package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题15
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  {	实现按顺序执行业务 }
*/

public class Case15 {

    // 像这种要求顺序的，必须要有标志位
    // 标志位
    private static int Index = 1;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    while (Index != 1) {
                        condition.await();
                    }
                    System.out.println("A线程执行");
                    Index = 2;
                    condition.signalAll();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                }
            }
        }, "线程A").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    while (Index != 2) {
                        condition.await();
                    }
                    System.out.println("B线程执行");
                    Index = 3;
                    condition.signalAll();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                }
            }
        }, "线程B").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    while (Index != 3) {
                        condition.await();
                    }
                    System.out.println("C线程执行");
                    condition.signalAll();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                }
            }
        }, "线程C").start();

        System.out.println(Index);// 3
        // 输出如下：
//		A线程执行
//		B线程执行
//		C线程执行

        // 可以看到，按照ABC的顺序执行了每个线程
    }

}
