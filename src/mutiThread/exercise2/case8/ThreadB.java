package mutiThread.exercise2.case8;

public class ThreadB extends Thread{
	private Task task;

	public ThreadB(Task task) {
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
