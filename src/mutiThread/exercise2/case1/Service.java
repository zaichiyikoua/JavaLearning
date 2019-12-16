package mutiThread.exercise2.case1;

import java.util.concurrent.TimeUnit;

public class Service {
	private int count = 0;

	synchronized public void add(String name) {
		try {
			if (name.equals("a")) {
				count++;
				System.out.println("a *** over");
				TimeUnit.SECONDS.sleep(2);
			} else {
				count = 200;
				System.out.println("b *** over");
			}
			System.out.println(name + "count =" + count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
