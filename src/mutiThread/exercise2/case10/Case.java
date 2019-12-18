package mutiThread.exercise2.case10;

/*
*	多线程核心   练习题10
*	@author  zaichiyikoua
*	@time  2019年12月18日
*	@description  {	静态同步	}
*				**静态同步时，使用当前静态方法所在类对应的Class类的单例对象作为锁
*				**同步代码块使用和方法差别不大，作用一样
*/

public class Case {
	public static void main1(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.setName("A");
		ThreadB threadB = new ThreadB();
		threadB.setName("B");

		threadA.start();
		threadB.start();
		// 输出
//		线程A启动，调用A
//		线程A结束，完成调用A
//		线程B启动，调用B
//		线程B结束，完成调用B

		// 可以看到 A线程执行完成之后再执行的B线程，说明是同步的
	}

	public static void main(String[] args) {
		Service service = new Service();
		ThreadC threadC = new ThreadC(service);
		threadC.setName("C");
		ThreadD threadD = new ThreadD(service);
		threadD.setName("D");

		threadC.start();
		threadD.start();
		// 输出
//		线程C启动，调用C
//		线程C结束，完成调用C
//		线程D启动，调用D
//		线程D结束，完成调用D

		// 可以看到 也是同步执行的

	}
}
