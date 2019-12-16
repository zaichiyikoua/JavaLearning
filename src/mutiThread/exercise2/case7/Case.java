package mutiThread.exercise2.case7;

/*
*	多线程核心   练习题7
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	同步代码块的使用  }
*				**一般来说，使用代码块比使用方法要效率更高一点
*				**尽量减少代码块的内容  只在需要同步的地方使用
*/

public class Case {
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA threadA = new ThreadA(service);
		threadA.setName("A");
		ThreadB threadB = new ThreadB(service);
		threadB.setName("B");

		threadA.start();
		threadB.start();
//		begin time=1576493022969
//		end time=1576493024970
//		begin time=1576493024970
//		end time=1576493026970
	}
}
