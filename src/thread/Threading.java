package thread;

import java.util.ArrayList;
import java.util.List;

//经典多线程题
//实现一个容器，提供两个方法  add size
//写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数
//当元素个数到达5个时，线程2给出提示并结束

public class Threading {
	// list要可见
	volatile List<Integer> list = new ArrayList<Integer>();

	public void add(Integer element) {
		list.add(element);
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		Threading threading = new Threading();
		// 锁
		Object lock = new Object();

		new Thread(new Runnable() {
			public void run() {
				System.out.println("线程2 启动");
				synchronized (lock) {
					if (threading.size() != 5) {
						// 线程挂起
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("线程2 结束");
					// 线程结束，让线程1 继续执行
					// 线程结束 释放锁
					lock.notifyAll();
				}

			}
		}, "线程2").start();

		new Thread(new Runnable() {
			public void run() {
				System.out.println("线程1 开始");
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						threading.add(new Integer(i));
						System.out.println(i);
						// 如果为 5 唤醒线程2
						if (threading.size() == 5) {
							// 这里要注意 notifyAll,notify都不会释放锁
							lock.notifyAll();
							// 所以这里要释放锁 才能让线程2 执行
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				System.out.println("线程1 结束");
			}
		}, "线程1").start();

	}
}
