package interview;

/*
*	javaSE专项练习20
*	2019年12月13日
*/

public class Coding20 {
    public int aMethod() {
        return 0;
//		static int i =0;
//		i++;
//		return i;
    }

    public static void main(String[] args) {
        Coding20 test = new Coding20();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
        // 会报异常
        // Illegal modifier for parameter i; only final is permitted

        // 这道题考点是static关键字
        // Java中静态变量只能在类主体中定义，不能在方法中定义。 静态变量属于类所有而不属于方法。
    }
}
