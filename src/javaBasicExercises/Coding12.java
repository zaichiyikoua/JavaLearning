package javaBasicExercises;

/*
*	javaSE专项练习12
*	2019年12月12日
*/

public class Coding12 {
    public static void main(String[] args) {
        try {
            solution(new int[] { 0, 1, 2, 3, 4, 5 });
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("E");
        }

        // 输出 e E
        // arr[0]=0 所以进入方法时抛出异常 接着执行finally语句 输出e
        // 然后回到main方法中 因为捕获到异常 所以catch 输出E

    }

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.println(i);
                }
            } finally {
                // TODO: handle finally clause
                System.out.println("e");
            }
        }

    }
}
