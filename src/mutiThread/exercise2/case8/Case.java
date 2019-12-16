package mutiThread.exercise2.case8;

/*
*	多线程核心   练习题
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	一半同步，一步异步  }
*/

public class Case {
	// 不在synchronized代码块中的是异步，在代码块中的是同步执行
	public static void main(String[] args) {
		Task task = new Task();
		ThreadA threadA = new ThreadA(task);
		ThreadB threadB = new ThreadB(task);

		threadA.start();
		threadB.start();
		// 输出
//		no synchronized ThreadName=Thread-0i=96
//		no synchronized ThreadName=Thread-0i=97
//		no synchronized ThreadName=Thread-0i=98
//		no synchronized ThreadName=Thread-0i=99
//		synchronized ThreadName=Thread-0i=0
//		synchronized ThreadName=Thread-0i=1
//		synchronized ThreadName=Thread-0i=2
//		synchronized ThreadName=Thread-0i=3
//		synchronized ThreadName=Thread-0i=4
//		synchronized ThreadName=Thread-0i=5
//		synchronized ThreadName=Thread-0i=6
//		synchronized ThreadName=Thread-0i=7
//		no synchronized ThreadName=Thread-1i=20
//		no synchronized ThreadName=Thread-1i=21
//		no synchronized ThreadName=Thread-1i=22
	}
}
