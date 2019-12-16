package mutiThread.exercise2.case5;

public class Service {
	synchronized public void solution1() {
		System.out.println("solution1");
		solution2();
	}

	synchronized public void solution2() {
		System.out.println("solution2");
		solution3();
	}

	synchronized public void solution3() {
		System.out.println("solution3");
	}
}
