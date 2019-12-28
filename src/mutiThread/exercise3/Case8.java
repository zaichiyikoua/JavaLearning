package mutiThread.exercise3;

import java.util.concurrent.TimeUnit;

/*
*	多线程核心   练习题8
*	@author  zaichiyikoua
*	@time  2019年12月28日
*	@description  {	join()的使用之 join()和sleep() }
*/

public class Case8 {
	// join()是可以带参的，参数用作于设定等待时间，不管线程是否执行完毕，时间到了就会重新去尝试获得锁
	// 如果时间到了并且得到了锁，则当前线程会继续向后执行
	// 注意，join()是会释放锁的，因为它源码内部使用wait()实现的
	// sleep()是不会释放锁的
	public static void main(String[] args) {
		try {
			Thread threadA = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println("run begin time" + System.currentTimeMillis());
						TimeUnit.SECONDS.sleep(5);
						System.out.println("run end time" + System.currentTimeMillis());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			threadA.start();
			System.out.println("main begin time" + System.currentTimeMillis());
			// 此处的join带参
			threadA.join(2);
			// TimeUnit.SECONDS.sleep(2);
			System.out.println("main end time" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 从结果来看，join和sleep方法效果基本一样
	}
}
