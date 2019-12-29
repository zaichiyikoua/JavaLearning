package mutiThread.exercise4;

import java.util.concurrent.locks.ReentrantLock;

/*
*	多线程核心   练习题11
*	@author  zaichiyikoua
*	@time  2019年12月29日
*	@description  {	Lock的一些常用api之 isFair() }
*/

public class Case11 {
	// 这个方法的作用是来判断是不是公平锁
	// 默认缺省状态是false，也就是说默认状态是非公平的
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLock lock = new ReentrantLock();
		System.out.println(lock.isFair());// false

		ReentrantLock lock2 = new ReentrantLock(true);
		System.out.println(lock2.isFair());// true

		ReentrantLock lock3 = new ReentrantLock(false);
		System.out.println(lock3.isFair());// false
	}

}
