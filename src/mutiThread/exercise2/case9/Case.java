package mutiThread.exercise2.case9;

/*
*	多线程核心   练习题9
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	不同步导致的逻辑错误及解决办法  }
*				**基本上只要对象在项目中是实例，是单例的，要共享，就要考虑并发情况
*/

public class Case {
	public static void main(String[] args) {
		MyUtil util = new MyUtil();
		ThreadA threadA = new ThreadA(util);
		threadA.setName("A");
		ThreadB threadB = new ThreadB(util);
		threadB.setName("B");

		threadA.start();
		threadB.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("listSize =" + util.getSize());// listSize =2 加上之后变成listSize =1
		// 出现错误的原因是因为两个线程没有以同步的方式返回size()大小
		// 解决就是加上synchronized
//		try {										synchronized(MyUtil){
//		if (list.getSize() < 1) {						if (list.getSize() < 1)..........
//			// 模拟数据获取				  ==>>
//			TimeUnit.SECONDS.sleep(2);
//			list.addItem(data);
//		}
	}
}
