package interview;

/*
*	javaSE专项练习13
*	2019年12月13日
*/

public class Coding13 {
	// 输出 null 42 42
	// 要注意是包装类不是byte
	// 然后就是传递的是地址 修改之后会改变的
}

class Two {
	Byte x;
}

class pass {
	public static void main(String[] args) {
		pass pass = new pass();
		pass.start();
	}

	void start() {
		Two two = new Two();
		System.out.println(two.x + "");
		Two two2 = fix(two);
		System.out.println(two.x + "" + two2.x);

	}

	Two fix(Two tt) {
		tt.x = 42;
		return tt;
	}
}
