package mutiThread.exercise4;

import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	ReentrantLock的基本使用  }
*/

public class Case {
	// JDK1.5之后新增的reentrantLock，功能更见强大，强烈推荐使用
	// 如果现在还用synchronized来进行同步的话，就相当于用枪的时代用弓箭
	// 基本用法：lock()和unlock()方法之间的代码会进行同步
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 锁
		ReentrantLock lock = new ReentrantLock();
		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				for (int i = 0; i < 7; i++) {
					System.out.println("ThreadName=" + Thread.currentThread().getName() + ("" + (i + 1)));
				}
				lock.unlock();
			}
		});

		threadA.start();
	}

}
