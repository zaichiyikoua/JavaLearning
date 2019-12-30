package mutiThread.exercise4;

import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题9
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	Lock的一些常用api之 getHoldCount() }
*/

public class Case9 {
    // 该方法的作用很简单，是查询当前线程保持锁的个数，即调用lock()的次数
    // 执行lock()进行锁的重入

    private ReentrantLock lock = new ReentrantLock();

    public void methodOne() {
        System.out.println("A " + lock.getHoldCount());
        lock.lock();
        System.out.println("B " + lock.getHoldCount());
        methodTwo();
        System.out.println("F " + lock.getHoldCount());
        lock.unlock();
        System.out.println("G " + lock.getHoldCount());
    }

    public void methodTwo() {
        System.out.println("C " + lock.getHoldCount());
        lock.lock();
        System.out.println("D " + lock.getHoldCount());
        lock.unlock();
        System.out.println("E " + lock.getHoldCount());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Case9 service = new Case9();
        service.methodOne();

        // 输出如下：
//		A 0
//		B 1
//		C 1
//		D 2
//		E 1
//		F 1
//		G 0
    }

}
