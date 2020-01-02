package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题5
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	通知部分线程之  错误用法  }
*/

public class Case5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    System.out.println("await start time=" + System.currentTimeMillis());
                    System.out.println("ThreadName=" + Thread.currentThread().getName());
                    condition.await();
                    System.out.println("await end time=" + System.currentTimeMillis());
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
                    System.out.println("await start time=" + System.currentTimeMillis());
                    System.out.println("ThreadName=" + Thread.currentThread().getName());
                    condition.await();
                    System.out.println("await end time=" + System.currentTimeMillis());
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
                    System.out.println("signal time=" + System.currentTimeMillis());
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

        // 输出如下：
//		await start time=1577608896131
//		ThreadName=线程A
//		await start time=1577608896132
//		ThreadName=线程B
//		signal time=1577608896133
//		await end time=1577608896133
//		await end time=1577608896133

        // 可以看到，AB线程都被唤醒了，没有达到唤醒指定线程的效果
    }

}
