package mutiThread.exercise;

/*
*	多线程核心   练习题3
*	@author  zaichiyikoua
*	@time  2019年12月14日
*	@description  {	线程随机性的展示  }
*/

public class MyThread3 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			System.out.println("run =" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		MyThread3 thread = new MyThread3();
		thread.setName("myThread");
		thread.start();

		for (int i = 0; i < 10000; i++) {
			System.out.println("main = " + Thread.currentThread().getName());
		}

		// 输出结果显示 线程被随机执行

		// 这是因为cpu将时间片分给不同的线程，线程获取资源后执行任务，所以这些线程在交替地执行输出
		// 需要注意的是，cpu在不同的线程上切换是需要耗时的，所以不是创建的线程越多，软件的执行效率就越高
		// 如果线程数量过多，还会降低软件的执行效率
	}

}
