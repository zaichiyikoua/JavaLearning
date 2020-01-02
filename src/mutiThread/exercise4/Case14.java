package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题14
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	Lock的一些常用api之 isHeldByCurrentThread() }
*/

public class Case14 {
    // isHeldByCurrentThread()的作用就是查询当前线程是否持有此锁
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReentrantLock lock = new ReentrantLock();
        @SuppressWarnings("unused")
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    System.out.println(lock.isHeldByCurrentThread());
                    lock.lock();
                    System.out.println(lock.isHeldByCurrentThread());
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    // TODO: handle finally clause
                    lock.unlock();
                }
            }
        }).start();

//		false
//		true
    }

}
