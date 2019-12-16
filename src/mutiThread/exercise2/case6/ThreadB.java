package mutiThread.exercise2.case6;

public class ThreadB extends Thread {
	private Service service;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.solution();
	}

	public ThreadB(Service service) {
		super();
		this.service = service;
	}
}
