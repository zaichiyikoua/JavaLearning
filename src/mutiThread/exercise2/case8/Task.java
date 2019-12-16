package mutiThread.exercise2.case8;

public class Task {
	// 一个同步一个异步
	public void longTime() {
		for (int i = 0; i < 100; i++) {
			System.out.println("no synchronized ThreadName=" + Thread.currentThread().getName() + "i=" + i);

		}
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				System.out.println("synchronized ThreadName=" + Thread.currentThread().getName() + "i=" + i);

			}
		}
	}
}
