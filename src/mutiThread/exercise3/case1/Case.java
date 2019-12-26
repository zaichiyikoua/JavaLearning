package mutiThread.exercise3.case1;

/*
*	多线程核心   练习题1
*	@author  zaichiyikoua
*	@time  2019年12月26日
*	@description  {	wait和notify机制之  不使用wait和notify的情况  }
*/

public class Case {
	// 案例为A线程增加数量，B线程监听，数量到5时B提出消息通知
	// 从结果上看因为使用了volatile关键字，让线程之间可以通信，但是B线程一直在不停的轮询去检测是否达到了5
	// 这样的话很浪费cpu的资源
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA threadA = new ThreadA(service);
		ThreadB threadB = new ThreadB(service);
		threadA.start();
		threadB.start();

		// 输出结果：
//		增加4个元素
//		增加5个元素
//		集合中数量达到5了，线程退出
//		java.lang.InterruptedException
//			at mutiThread.exercise3.case1.ThreadB.run(ThreadB.java:19)
//		增加6个元素
//		增加7个元素
	}
}
