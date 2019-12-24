package mutiThread.exercise2.case12;

/*
*	多线程核心   练习题12
*	@author  zaichiyikoua
*	@time  2019年12月24日
*	@description  {	volatile关键字int count++非原子性验证	}
*/

public class Case extends Thread {

//	volatile public static int count;
	public static int count;

	// 加上synchronized之后，对count就可以不使用volatile关键字了
	synchronized public static void addCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		addCount();
	}

	public static void main1(String[] args) {
		Case[] list = new Case[50];
		for (int i = 0; i < 50; i++) {
			list[i] = new Case();
		}
		for (int i = 0; i < 50; i++) {
			list[i].start();
		}

		// 输出结果 4852或者4962或者4430 反正不是5000
		// 结果不是期待的5000，说明volatile不能保证++操作的原子性
		// volatile会提示线程去共享内存中读取变量，而不是从线程自己的私有内存中读取，这样保证了可见性
		// 在说明一次，++操作是分为三步的 1.从内存中读取count 2.计算count的值把它+1 3.将count的值写进内存
		// 在以上三步进行操作时，在高并发条件下，会受到其他线程的干扰，造成数据的污染
		// volatile本身不具备++操作的原子性
	}

	public static void main(String[] args) {
		Case[] list = new Case[50];
		for (int i = 0; i < 50; i++) {
			list[i] = new Case();
		}
		for (int i = 0; i < 50; i++) {
			list[i].start();
		}
		// 修改之后输出5000
		// synchronized既保证可见性，也保证原子性
	}

}
