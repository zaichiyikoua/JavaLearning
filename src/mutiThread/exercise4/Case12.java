package mutiThread.exercise4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题12
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	Lock的一些常用api之 getWaitQueueLength() }
*/

public class Case12 {
	// getWaitQueueLength()的作用是返回等待跟此锁相关的condition的线程数量
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			condition.await();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}

	public void signalMethod() {
		try {
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程在等待");
			condition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Case12 service = new Case12();
		Runnable runnable = new Runnable() {
			public void run() {
				service.waitMethod();
			}
		};

		Thread[] threadArr = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArr[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArr[i].start();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.signalMethod();

		// 有10个线程在等待
	}

}
