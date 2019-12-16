package mutiThread.exercise2.case4;

import java.util.concurrent.TimeUnit;

public class Var {
	private String userName = "A";
	private String password = "AA";

	synchronized public void getValue() {
		System.out.println("getValue Method   ThreadName=" + Thread.currentThread().getName() + " userName =" + userName
				+ " password =" + password);
	}

	synchronized public void setValue(String userName, String password) {
		try {
			this.userName = userName;
			// 模拟实际情况
			TimeUnit.SECONDS.sleep(5);
			this.password = password;
			System.out.println("setValue Method   ThreadName=" + Thread.currentThread().getName() + " userName ="
					+ userName + " password =" + password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
