package mutiThread.exercise6;

/*
*	多线程核心   练习题3
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { 懒汉模式的解决办法之 同步方法和同步代码块  }
*/

public class MyThread3 {
	// 既然多个线程会同时调用getInstance(),那么将其同步即可

	private static MyThread3 mythread;

	private MyThread3() {

	}

	// 使用同步方法，但是这样整个方法都同步了，效率比较低
	synchronized public MyThread3 getInstance() {
		try {
			if (mythread == null) {
				mythread = new MyThread3();
			}
			// 此时的mythread没有初始化，为null
			return mythread;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mythread;
	}

	// 使用同步代码块，但是这样和上面使用同步方法没有什么区别
	public MyThread3 getInstance2() {
		try {
			synchronized (MyThread3.class) {
				if (mythread == null) {
					mythread = new MyThread3();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mythread;
	}

	// 使用同步代码块，只在重要的代码部分进行同步
	// 这样同步的部分比较少，运行效率可以提高
	public MyThread3 getInstance3() {
		try {
			if (mythread == null) {
				synchronized (MyThread3.class) {
					mythread = new MyThread3();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mythread;
	}
}
