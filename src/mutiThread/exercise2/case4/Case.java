package mutiThread.exercise2.case4;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题4
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	脏读  }
*/

public class Case {
	// 首先什么是脏读
	// 在数据库中就是某个事务改了数据但还没提交，另外的事务去读，然后第一个事务因为某些原因回滚了，别的事务读取的数据就是有误的
	// 在java中发生的主要原因是在读取实例变量的时候，该值被别的线程改了
	// 解决方案就是读写都加锁,如果只加写的锁，那么读是非同步的，就会出现脏读现象
	public static void main(String[] args) {
		try {
			Var var = new Var();
			MyThread myThread = new MyThread(var);
			myThread.start();
			TimeUnit.SECONDS.sleep(2);
			var.getValue();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 输出
//		getValue Method   ThreadName=main userName =B password =AA
//		setValue Method   ThreadName=Thread-0 userName =B password =BB

		// 加上之后
//		setValue Method   ThreadName=Thread-0 userName =B password =BB
//		getValue Method   ThreadName=main userName =B password =BB		
	}
}
