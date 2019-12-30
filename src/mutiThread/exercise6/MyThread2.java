package mutiThread.exercise6;

/*
*	多线程核心   练习题2
*	@author  zaichiyikoua
*	@time  2019年12月30日
*	@description  { 延迟加载/懒汉模式  }
*/

public class MyThread2 {
	// 这种就是调用getInstance()的时候才会创建实例
	// 但是这种会在多线程条件下出现取出多个实例的情况，那肯定就不是单例模式了
	// 在多线程条件下不要使用这种
	private static MyThread2 mythread;

	private MyThread2() {

	}

	public MyThread2 getInstance() {
		if (mythread == null) {
			mythread = new MyThread2();
			return mythread;
		}
		// 此时的mythread没有初始化，为null
		return mythread;
	}
}
