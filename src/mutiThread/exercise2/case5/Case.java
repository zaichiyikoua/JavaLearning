package mutiThread.exercise2.case5;

/*
*	多线程核心   练习题5
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	synchronized可重入锁	}
*/

public class Case extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Service service = new Service();
		service.solution1();
	}

	// 可重入锁是指自己可以再次获得自己的内部锁，当一个线程拿到一个锁之后，再次请求该对象锁是可以的
	// 简单直接一点：就是在同步方法和同步代码块中可以调用本类的其他同步方法或代码块

	public static void main(String[] args) {
		Case caseOne = new Case();
		caseOne.start();

		// 输出
//		solution1
//		solution2
//		solution3
		// 可以看到，是输出了其他同步方法中的内容，如果是不可重入的话则不会输出
	}
}
