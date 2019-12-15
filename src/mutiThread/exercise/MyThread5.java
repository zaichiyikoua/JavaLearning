package mutiThread.exercise;

/*
*	多线程核心   练习题5
*	@author  zaichiyikoua
*	@time  2019年12月15日
*	@description  {	实例变量共享造成的非线程安全问题和解决方案之	不共享数据的情况	}
*/

public class MyThread5 extends Thread {
	private int count = 5;

	public MyThread5(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (count > 0) {
			count--;
			System.out.println("由" + Thread.currentThread().getName() + "计算,count = " + count);

		}
	}

	public static void main(String[] args) {
		MyThread5 t1 = new MyThread5("A");
		MyThread5 t2 = new MyThread5("B");
		MyThread5 t3 = new MyThread5("C");

		t1.start();
		t2.start();
		t3.start();
		
//		输出如下：
//				由B计算,count = 4
//				由C计算,count = 4
//				由C计算,count = 3
//				由C计算,count = 2
//				由C计算,count = 1
//				由C计算,count = 0
//				由A计算,count = 4
//				由A计算,count = 3
//				由A计算,count = 2
//				由A计算,count = 1
//				由A计算,count = 0
//				由B计算,count = 3
//				由B计算,count = 2
//				由B计算,count = 1
//				由B计算,count = 0

		// 可以看到，每个线程有各自的count变量，自己减少自己的count的值，其他线程是不受影响的
		// 这种情况就是变量不共享，不存在多个线程访问同一个变量的情况
	}
}
