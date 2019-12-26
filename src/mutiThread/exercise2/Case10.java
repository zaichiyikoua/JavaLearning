package mutiThread.exercise2;

/*
*	多线程核心   练习题10
*	@author  zaichiyikoua
*	@time  2019年12月18日
*	@description  {	静态同步	}
*				**静态同步时，使用当前静态方法所在类对应的Class类的单例对象作为锁
*				**同步代码块使用和方法差别不大，作用一样
*/

public class Case10 {
	// 都是静态方法
	synchronized public static void printA() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "启动，调用A");
			Thread.sleep(1000);
			System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用A");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public static void printB() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "启动，调用B");
			Thread.sleep(1000);
			System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用B");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 同步块
	public void printC() {
		synchronized (Case10.class) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "启动，调用C");
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用C");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void printD() {
		synchronized (Case10.class) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "启动，调用D");
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + "结束，完成调用D");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Case10.printA();
			}
		}, "线程A").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Case10.printB();
			}
		}, "线程B").start();
		// 输出
//		线程A启动，调用A
//		线程A结束，完成调用A
//		线程B启动，调用B
//		线程B结束，完成调用B

		// 可以看到 A线程执行完成之后再执行的B线程，说明是同步的
	}

	public static void main(String[] args) {
		Case10 service = new Case10();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				service.printC();
			}
		}, "线程C").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				service.printD();
			}
		}, "线程D").start();
		// 输出
//		线程C启动，调用C
//		线程C结束，完成调用C
//		线程D启动，调用D
//		线程D结束，完成调用D

		// 可以看到 也是同步执行的
	}

}

/*
 * 多线程核心 练习题 tips
 * @author zaichiyikoua
 * @time 2019年12月17日
 * @description { 类class的单例性 }
 */

class Test {
	// 每一个java文件对应class类的实例都只有一个，在内存中是单例的
	public static void main(String[] args) {
		Test test = new Test();
		Test test2 = new Test();
		Test test3 = new Test();
		Test test4 = new Test();

		System.out.println("*********************************");

		System.out.println(test.getClass() == test.getClass());
		System.out.println(test.getClass() == test2.getClass());
		System.out.println(test.getClass() == test3.getClass());
		System.out.println(test.getClass() == test4.getClass());

		System.out.println("*********************************");

		// 输出
//		true
//		true
//		true
//		true
	}
}
