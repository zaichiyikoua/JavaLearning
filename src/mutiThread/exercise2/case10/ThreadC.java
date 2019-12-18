package mutiThread.exercise2.case10;

public class ThreadC extends Thread {
	private Service service;

	public ThreadC(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.printC();
	}

}
