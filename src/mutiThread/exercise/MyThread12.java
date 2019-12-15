package mutiThread.exercise;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题12
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	在sleep状态下停止线程	}
*				**总结 1.在sleep状态执行interrupt()会抛异常
*					   2.调用interrupt()会给线程打上中断标记，再执行sleep()也会抛异常
*					   3.不管调用顺序，只要interrupt()和sleep()碰在一起，就会抛异常
*/

public class MyThread12 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println("run begin");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("run end");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch" + this.isInterrupted());
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			MyThread12 thread = new MyThread12();
			thread.start();
			TimeUnit.SECONDS.sleep(1);
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch in main");
			e.printStackTrace();
		}
		System.out.println("end!");

//输出结果：		
//		run begin
//		end!
//		catchfalse
//		java.lang.InterruptedException: sleep interrupted
	}
}
