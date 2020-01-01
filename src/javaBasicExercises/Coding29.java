package javaBasicExercises;

/*
*	javaSE专项练习29
*	@author  zaichiyikoua
*	@time  2020年1月1日
*/

public class Coding29 {
    private static int j = 0;

    private static boolean methodB(int k) {
        j += k;
        return true;
    }

    @SuppressWarnings("unused")
    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        methodA(0);
        System.out.println(j);// 4
    }

    // Java允许对boolean类型的值进行按位“与”、“或”和“异或”操作，但不能进行按位“非”。
    // 对于boolean值，按位操作与逻辑操作有相同的结果，但是不会发生“短路”。

    // 这题的考点在于methodA()中的 | 和 ||
    // "|"是按位或：先判断条件1，不管条件1是否可以决定结果（这里决定结果为true)，都会执行条件2
    // "||"是逻辑或：先判断条件1，如果条件1可以决定结果（这里决定结果为true)，那么就不会执行条件2
}
