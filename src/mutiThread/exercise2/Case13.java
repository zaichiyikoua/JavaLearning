package mutiThread.exercise2;

import java.util.concurrent.atomic.AtomicInteger;

/*
*	多线程核心   练习题13
*	@author  zaichiyikoua
*	@time  2019年12月24日
*	@description  {	Atomic原子类进行++操作  }
*/

public class Case13 extends Thread {
	// 默认0
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3000; i++) {
			System.out.println(count.incrementAndGet());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Case13 service = new Case13();

		// 起5个线程
		Thread thread1 = new Thread(service);
		thread1.start();
		Thread thread2 = new Thread(service);
		thread2.start();
		Thread thread3 = new Thread(service);
		thread3.start();
		Thread thread4 = new Thread(service);
		thread4.start();
		Thread thread5 = new Thread(service);
		thread5.start();
		// 期待结果15000 实际结果15000
		// Atomic原子类是java并发包提供的类，主要就是用于++,--的情况，保证了原子性
	}

}
