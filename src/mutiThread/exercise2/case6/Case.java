package mutiThread.exercise2.case6;

/*
*	多线程核心   练习题6
*	@author  zaichiyikoua
*	@time  2019年12月16日
*	@description  {	出现异常的时候，会释放锁  }
*/

public class Case {
	public static void main(String[] args) {
		try {
			Service service = new Service();

			ThreadA threadA = new ThreadA(service);
			threadA.setName("a");
			threadA.start();

			ThreadB threadB = new ThreadB(service);
			threadB.setName("b");
			threadB.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 输出
//		ThreadName =a
//		ThreadName=a run exceptionTime=1576484100231
//		Exception in thread "a" ThreadB run Time=1576484100232

		// 可以看到a中出现了异常，并且b正常输出
		// 如果发生异常不释放锁的话b永远也不会输出，所以发生异常会释放锁
	}
}
