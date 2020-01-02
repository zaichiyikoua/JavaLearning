package javaBasicExercises.part1;

/*
*	javaSE专项练习7
*	2019年12月11日
*/

public class Coding7 {
    public static int getNumber(int num) {
        try {
            int result = 2 / num;
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        } finally {
            if (num == 0) {
                return -1;
            }
            if (num == 1) {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber(0));
        System.out.println(getNumber(1));
        System.out.println(getNumber(2));
        System.out.println(getNumber(3));
        System.out.println(getNumber(4));

        // 输出 -1 1 1 0 0

        // 和练习2一样 还是那句话 finally一定会在return前执行
        // 如果finally中使用了return或者throw语句，会覆盖掉其他的return语句(让其他return失效)
    }
}
