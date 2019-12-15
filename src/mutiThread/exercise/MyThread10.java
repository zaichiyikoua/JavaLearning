package mutiThread.exercise;

/*
*	多线程核心   练习题10
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	判断线程是否为停止状态  }
*		**在java中，提供了两个判断方法1.interrupted() 2.isInterrupted()
*		**1是判断currentThread()是否已经中断
*		**2是判断this关键字所在类的对象是否中断
*		**总结，简单来说interrupted()是当前线程，isInterrupted()是指定线程，区别就是会不会清除状态标志
*/

public class MyThread10 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 50000; i++) {
			System.out.println("i=" + (i + 1));
		}
	}

	@SuppressWarnings("static-access")
	public static void main1(String[] args) {
		try {
			MyThread10 thread = new MyThread10();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			// interrupted()
			System.out.println("是否停止1? =" + thread.interrupted());
			System.out.println("是否停止2? =" + thread.interrupted());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main match");
			e.printStackTrace();
		}
		System.out.println("end");

		// 输出 是否停止1? =false 是否停止2? =false
		// 从结果来看，线程未停止，这是因为当前线程是main，从未中断
	}

	public static void main2(String[] args) {
		// 中断main线程
		Thread.currentThread().interrupt();
		System.out.println("是否停止1? =" + Thread.interrupted());
		System.out.println("是否停止2? =" + Thread.interrupted());
		System.out.println("end");

		// 输出结果 是否停止1? =true 是否停止2? =false
		// 为什么第二个结果是false?
		// ****文档解释****
		// 因为interrupted()具有清除状态的功能
		// ****下面是书上的解释****
		// 换句话说，就是如果练习两次调用interrupted()，在第一次调用中已经清除了中断状态
		// 且第二次调用检验完中断状态前，当前线程再次中断的情况除外
	}

	public static void main(String[] args) {
		try {
			MyThread10 thread = new MyThread10();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			// isInterrupted()
			System.out.println("是否停止1? =" + thread.isInterrupted());
			System.out.println("是否停止2? =" + thread.isInterrupted());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
