package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题6
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	通知部分线程之  正确用法  }
*/

public class Case6 {
    // Case4中使用了Condition对象来完成wait/notify模式，其实condition对象可以创建多个
    // 使用condition对象来实现唤醒单个的，指定的线程
    // 控制线程行为的更加方便可靠的方式
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReentrantLock lock = new ReentrantLock();
        Condition conditionOne = lock.newCondition();
        Condition conditionTwo = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    System.out.println("begin A await time=" + System.currentTimeMillis());
                    System.out.println("ThreadName=" + Thread.currentThread().getName());
                    conditionOne.await();
                    System.out.println("end A await time=" + System.currentTimeMillis());
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
                    System.out.println("begin B await time=" + System.currentTimeMillis());
                    System.out.println("ThreadName=" + Thread.currentThread().getName());
                    conditionTwo.await();
                    System.out.println("end B await time=" + System.currentTimeMillis());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                }
            }
        }, "线程B").start();
        // 唤醒线程
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    System.out.println("只唤醒A线程,time=" + System.currentTimeMillis());
                    // 只唤醒A
                    conditionOne.signalAll();
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
//		begin A await time=1577610312379
//		ThreadName=线程A
//		begin B await time=1577610312380
//		ThreadName=线程B
//		只唤醒A线程,time=1577610312380
//		end A await time=1577610312380

        // 可以看到，A线程结束了，但B线程没有，因为只唤醒了A线程
    }

}
