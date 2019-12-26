package mutiThread.exercise3;

import java.util.ArrayList;
import java.util.List;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月26日
*	@description  {	wait和notify机制之  使用wait和notify的情况  }
*/

public class Case2 {
	private List<String> list = new ArrayList<String>();

	public void add() {
		list.add("****");
	}

	public int size() {
		return list.size();
	}

	// 要注意，只有拥有相同的锁，才可以实现wait和notify机制
	// 有几点需要特别注意：
	// 1.wait和notify方法是Object类的的方法，因为需要锁，所以只能在同步方法或代码块中使用
	// 2.wait方法的作用是使当前执行wait()方法的线程进入阻塞状态(等待),并且 会释放锁！！，直到接到通知被唤醒
	// 3.notify方法使用之后，当前线程不会释放锁，会等线程执行完成之后再释放锁，作用是通知暂停状态的线程继续运行
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Case2 service = new Case2();
		// 锁
		Object lock = new Object();

		// 监视线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					synchronized (lock) {
						if (service.list.size() != 5) {
							System.out.println("监视执行,等待开始");
							lock.wait();
							System.out.println("监视执行，等待结束，为5了");
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "线程A").start();
		// 计数线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						service.add();
						System.out.println("i=" + (i + 1));
						if (service.list.size() == 5) {
							lock.notifyAll();
							System.out.println("唤醒监视线程");
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}, "线程B").start();

//		监视执行,等待开始       此时监视线程A释放锁，线程B可以拿到锁进行输出i
//		i=1
//		i=2
//		i=3
//		i=4
//		i=5
//		唤醒监视线程		notify不会释放锁，直到该任务执行完成
//		i=6
//		i=7
//		i=8
//		i=9
//		i=10
//		监视执行，等待结束，为5了		线程B任务完成，释放锁，监视线程A重新拿到锁，执行wait以后的语句
	}

}
