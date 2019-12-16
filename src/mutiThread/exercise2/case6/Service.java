package mutiThread.exercise2.case6;

public class Service {
	synchronized public void solution() {
		if (Thread.currentThread().getName().equals("a")) {
			System.out.println("ThreadName =" + Thread.currentThread().getName());
			int i = 1;
			while (i == 1) {
				if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
					System.out.println("ThreadName=" + Thread.currentThread().getName() + " run exceptionTime="
							+ System.currentTimeMillis());
					Integer.parseInt("a");
				}
			}
		} else {
			System.out.println("ThreadB run Time=" + System.currentTimeMillis());
		}
	}
}
