package mutiThread.exercise2.case8;

public class ThreadA extends Thread{
	private Task task;

	public ThreadA(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		task.longTime();
	}
}
