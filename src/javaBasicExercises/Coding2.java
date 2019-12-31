package javaBasicExercises;

/*
*	javaSE专项练习2
*	2019年12月11日
*/

public class Coding2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));
    }

    @SuppressWarnings("finally") // 去掉警告⚠
    public static int test(int b) {
        try {
            b += 10;
            return b;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            b += 10;
            return b;
        }
    }

    // 如果finally中有return的话，会覆盖掉函数中其他的return语句 所以运行到try，b=20，
    // 没有异常 不执行catch 运行到b
    // finally无论怎样都要执行 所以b=30，返回结果

}
