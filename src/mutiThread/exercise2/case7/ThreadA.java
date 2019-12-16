package mutiThread.exercise2.case7;

public class ThreadA extends Thread {
	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.test();
	}

}
