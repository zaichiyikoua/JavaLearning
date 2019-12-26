package mutiThread.exercise3.case1;

public class ThreadB extends Thread {
	private Service service;

	public ThreadB(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// 这里死循环，让线程一直执行
			while (true) {
				if (service.size() == 5) {
					System.err.println("集合中数量达到5了，线程退出");
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
