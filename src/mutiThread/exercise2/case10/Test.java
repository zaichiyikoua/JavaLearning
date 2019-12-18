package mutiThread.exercise2.case10;

/*
*	多线程核心   练习题 tips
*	@author  zaichiyikoua
*	@time  2019年12月17日
*	@description  {	类class的单例性  }
*/

public class Test {
	// 每一个java文件对应class类的实例都只有一个，在内存中是单例的
	public static void main(String[] args) {
		Test test = new Test();
		Test test2 = new Test();
		Test test3 = new Test();
		Test test4 = new Test();

		System.out.println("*********************************");

		System.out.println(test.getClass() == test.getClass());
		System.out.println(test.getClass() == test2.getClass());
		System.out.println(test.getClass() == test3.getClass());
		System.out.println(test.getClass() == test4.getClass());

		System.out.println("*********************************");

		// 输出
//		true
//		true
//		true
//		true
	}
}
