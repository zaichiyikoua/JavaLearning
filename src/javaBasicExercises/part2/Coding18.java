package javaBasicExercises.part2;

import java.util.TreeSet;

/*
*	javaSE专项练习18
*	2019年12月13日
*/

public class Coding18 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();

        for (int i = 606; i < 613; i++) {
            if (i % 2 == 0) {
                set.add(i);
            }
        }
        subSet = (TreeSet<Integer>) set.subSet(608, true, 611, true);
        set.add(629);
        System.out.println(set + " " + subSet);

        // 输出[606, 608, 610, 612, 629] [608, 610]
        // 没什么好说的，就是考api
        // subset方法是求set的范围内的子集，两个true是表示是否包含端点（608和611）
        // 故subSet的值为[608,610]
    }
}
