package mutiThread.exercise2.case3;

import java.util.concurrent.TimeUnit;

public class MyLock {
	// 一个同步
	synchronized public void methodA() {
		System.out.println("begin methodA threadName =" + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end methodA");
	}

	// 一个不同步
	public void methodB() {
		System.out.println("begin methodB threadName =" + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end methodB");
	}
}
