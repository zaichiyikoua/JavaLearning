package mutiThread.exercise2.case9;

public class ThreadB extends Thread {
	private MyUtil myUtil;

	public ThreadB(MyUtil myUtil) {
		super();
		this.myUtil = myUtil;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		MyService myService = new MyService();
		myService.addServiceMethod(myUtil, "AAAA");
	}
}
