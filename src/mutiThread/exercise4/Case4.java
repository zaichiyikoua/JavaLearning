package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题4
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	使用await()和signal()来实现wait/notify模式  }
*/

public class Case4 {
    // 基本上Object类中wait()和Condition类中的await()的使用是一样的
    // notifyAll和signalAll()也是一样的用
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
                    System.out.println("await time=" + System.currentTimeMillis());
                    condition.await();
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
        }, "线程B").start();

        // 输出如下：
//		await time=1577607949221
//		signal time=1577607949221

    }

}
