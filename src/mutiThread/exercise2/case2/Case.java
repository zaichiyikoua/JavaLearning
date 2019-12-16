package mutiThread.exercise2.case2;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	多个对象多个锁  }
*/

public class Case {
	public static void main(String[] args) {
		//两个线程两个不同的锁，处于一对一的关系，各玩各的，不存在争抢关系
		//这种情况下不存在非线程安全问题
		
		Service service1 = new Service();
		Service service2 = new Service();

		Athread athread = new Athread(service1);
		Bthread bthread = new Bthread(service2);

		athread.start();
		bthread.start();
		
		//输出
//		a *** over
//		b *** over
//		bcount =200
//		acount =100
		
	}
}
