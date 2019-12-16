package mutiThread.exercise2.case2;

public class Athread extends Thread {
	private Service service;

	public Athread(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.add("a");
	}

}
