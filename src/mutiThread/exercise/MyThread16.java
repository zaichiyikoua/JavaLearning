package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题16
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	守护线程	}
*				**守护线程部分比较简单，大部分是概念   最典型的守护线程--->>>垃圾回收线程
*				**要在start前设置为守护线程
*/

public class MyThread16 extends Thread {
	private int count = 0;

	@Override
	public void run() {
		try {
			// TODO Auto-generated method stub
			while (true) {
				count++;
				System.out.println("count =" + count);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			MyThread16 thread = new MyThread16();
			thread.setDaemon(true);
			thread.start();
			TimeUnit.SECONDS.sleep(5);
			System.out.println("main线程结束，守护线程停止打印");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
