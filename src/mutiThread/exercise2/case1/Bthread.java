package mutiThread.exercise2.case1;

public class Bthread extends Thread {
	private Service service;

	public Bthread(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.add("b");
	}

}
