package mutiThread.exercise4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	ReentrantLock的代码块同步性验证  }
*/

public class Case2 {
	// 推荐将unlock()放在finally中
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLock lock = new ReentrantLock();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					lock.lock();
					System.out.println("Thread begin Name=" + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Thread end Name=" + Thread.currentThread().getName());
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
					System.out.println("Thread begin Name=" + Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Thread end Name=" + Thread.currentThread().getName());
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
//		Thread begin Name=线程A
//		Thread end Name=线程A
//		Thread begin Name=线程B
//		Thread end Name=线程B

		// 可以从结果看见，在没有使用synchronized关键字的情况下，使用reentrantLock完成了线程同步

	}

}
