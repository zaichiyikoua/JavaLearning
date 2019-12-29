package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题7
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {  使用LOCK来实现生产者/消费者模式  }
*/

public class Case7 {
	// 经典标志位
	private static boolean FLAG = false;

	// 以前提过，尽量使用notifyAll，同样的，使用lock的时候也是尽量的使用signalAll
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();

		// 生产者线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						lock.lock();
						while (FLAG == true) {
							condition.await();
						}
						System.out.println("******");
						FLAG = true;
						condition.signalAll();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						// TODO: handle finally clause
						lock.unlock();
					}
				}
			}
		}, "线程A").start();

		// 消费者线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						lock.lock();
						while (FLAG == false) {
							condition.await();
						}
						System.out.println("######");
						FLAG = false;
						condition.signalAll();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						// TODO: handle finally clause
						lock.unlock();
					}
				}
			}
		}, "线程B").start();

		// 输出如下：
//		######
//		******
//		######
//		******
//		######
//		******
//		######
//		******

		// 可以看到完成了经典的交替输出
	}

}
