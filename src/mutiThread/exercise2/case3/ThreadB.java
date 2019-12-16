package mutiThread.exercise2.case3;

public class ThreadB extends Thread {
	private MyLock lock;

	public ThreadB(MyLock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		lock.methodB();
	}

}
