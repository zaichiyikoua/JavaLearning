package javaBasicExercises.part2;

/*
*	javaSE专项练习15
*	2019年12月13日
*/

public class Coding15 {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Boolean flag = false;
        if (flag = true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // 输出true
        // Boolean修饰的变量为包装类型，初始化值为false
        // 进行赋值时会调用Boolean.valueOf(boolean b)方法自动拆箱为基本数据类型
        // 因此赋值后flag值为true，输出文本true。
    }
}
