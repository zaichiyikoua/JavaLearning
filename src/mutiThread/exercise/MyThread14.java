package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题14
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	使用return来终止线程	}
*				**这种方式也还可以，但是更建议使用异常法，因为可以在catch中对异常信息进行处理
*/

public class MyThread14 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (Thread.interrupted()) {
				System.out.println("停止");
				return;
			}
			System.out.println("*");
		}
	}

	public static void main(String[] args) {
		MyThread14 thread = new MyThread14();
		thread.start();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread.interrupt();
	}
}
