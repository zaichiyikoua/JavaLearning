package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题3
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	await()的错误使用和更正  }
*/

public class Case3 {

    // synchronized关键字配合wait/notify可以实现wait/notify模式
    // reentrantLock也具备同样的功能，但需要借助于condition对象
    // 这个condition对象是JDK1.5的技术，更加的灵活，比如可以实现多路通知，在一个lock对象中创建多个condition对象
    // 线程对象注册到condition中，可以进行选择通知，在线程的调度上更加的方便
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        // 锁
        ReentrantLock lock = new ReentrantLock();
        // 这个condition对象很重要
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    // 这个await()方法和wait()方法的作用基本一样
                    // 使当前线程在接到通知之前进入等待状态
                    condition.await();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }).start();
        // 但是要注意，如果按照上面的代码这样使用的话，会抛出异常
        // 原因使监视器出错，解决办法就是在condition.await()调用前获得锁
    }

    // 正确的用法如下
    // 这样就不会报异常
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    lock.lock();
                    System.out.println("A");
                    condition.await();
                    System.out.println("B");
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                    System.out.println("锁被释放了");
                }
            }
        }).start();
        // 输出A 然后线程进入等待状态
    }

}
