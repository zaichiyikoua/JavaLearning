package mutiThread.exercise2.case1;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	实例变量非线程安全问题和解决方案  }
*/

public class Case {
	public static void main(String[] args) {
		// 这种情况就是两个线程同时访问同一个对象中没有同步的方法
		// 解决方法也很简单，将该方法加上synchronized,使其变成同步方法
		Service service = new Service();
		Athread athread = new Athread(service);
		Bthread bthread = new Bthread(service);

		athread.start();
		bthread.start();

		// 输出
//		a *** over
//		b *** over
//		bcount =200
//		acount =200
		// 加上之后输出
//		a *** over
//		acount =1
//		b *** over
//		bcount =200
	}
}
