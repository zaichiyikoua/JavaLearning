package mutiThread.exercise;

/*
*	多线程核心   练习题11
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	线程停止的方法之 interrupted()完整版  }
*					线程停止的主要方法interrupted()配合异常,即异常法  (推荐使用这种)
*/

public class MyThread11 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			// 这里数量要很大 不然计算太快不会暴露
			for (int i = 0; i < 500000; i++) {
				// this.interrupted()和Thread.interrupted()作用基本相同
				if (Thread.interrupted()) {
					System.out.println("停止线程了");
					throw new InterruptedException();
				}
				System.out.println("i = " + i);
			}
			System.out.println("for之后的测试");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch run中的异常");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			MyThread11 thread = new MyThread11();
			thread.start();
			Thread.sleep(500);
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch main");
			e.printStackTrace();
		}
		System.out.println("end");

//	输出如下：
//		停止线程了
//		catch run中的异常
//		java.lang.InterruptedException
//			at mutiThread.exercise.MyThread11.run(MyThread11.java:23)
	}
}
