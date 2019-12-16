package mutiThread.exercise2.case7;

import java.util.concurrent.TimeUnit;

public class Service {
	public void test() {
		synchronized (this) {
			try {
				System.out.println("begin time=" + System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(2);
				System.out.println("end time=" + System.currentTimeMillis());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
