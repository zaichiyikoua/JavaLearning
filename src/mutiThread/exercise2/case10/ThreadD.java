package mutiThread.exercise2.case10;

public class ThreadD extends Thread {
	private Service service;

	public ThreadD(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.printD();
	}

}
