package mutiThread.exercise2.case4;

public class MyThread extends Thread {
	private Var var;

	public MyThread(Var var) {
		super();
		this.var = var;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		var.setValue("B", "BB");
	}

}
