package mutiThread.exercise2.case3;

public class ThreadA extends Thread {
	private MyLock lock;

	public ThreadA(MyLock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		lock.methodA();
	}

}
