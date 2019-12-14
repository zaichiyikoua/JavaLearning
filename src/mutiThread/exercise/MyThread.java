package mutiThread.exercise;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月14日
*	@description  {	使用多线程之	继承Thread类	}
*/

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("My Thread");
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("运行结束");// 输出 运行结束 My Thread

		// run方法的执行时间对比输出“运行结束”的时间晚 这是因为start()方法的执行比较耗时
		// 其耗时的原因是执行了多个步骤：
		// 1.通过jvm告诉系统创建thread
		// 2.系统开辟内存并使用window SDK中的createThread()函数创建线程对象
		// 3.系统对对象进行调度 以确定输出时机
		// 4.Thread在系统中成功执行
		// 以上四步完整执行后消耗的时间一定大于输出“运行结束”
	}
}
