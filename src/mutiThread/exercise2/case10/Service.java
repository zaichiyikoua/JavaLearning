package mutiThread.exercise2.case10;

public class Service {
	// 都是静态方法
	synchronized public static void printA() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "启动，调用A");
			Thread.sleep(1000);
			System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用A");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public static void printB() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "启动，调用B");
			Thread.sleep(1000);
			System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用B");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printC() {
		synchronized (Service.class) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "启动，调用C");
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用C");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void printD() {
		synchronized (Service.class) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "启动，调用D");
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用D");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
