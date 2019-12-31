package javaBasicExercises;

/*
*	javaSE专项练习21
*	2019年12月13日
*/

public class Coding21 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        if ((++i > 0) || (++j > 0)) {
            System.out.println(i);
            System.out.println(j);
        }
    }

    // 输出 1 0
    // 这道题还是很简单的
    // 考点就是|| 前一个条件满足的话就不看后面的了 所以j不会++j
}
