package interview;

import java.util.concurrent.TimeUnit;

//java专项练习3

public class Coding3 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" run ");
	}

	public static void main(String[] args) {
		Coding3 code = new Coding3();
		code.run();
		System.out.println(" mian ");
	}

	// 执行结果为 run mian
	// 没有启动线程噢 只是把run方法当作了普通的方法调用

}
