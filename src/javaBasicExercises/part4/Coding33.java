package javaBasicExercises.part4;

import java.util.TreeSet;

/*
*	javaSE专项练习33
*	@author  zaichiyikoua
*	@time  2020年1月26日
*/

public class Coding33 {

    public static <E> void main(String[] args) {
        // TODO Auto-generated method stub
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for (int i = 606; i < 613; i++) {
            if (i % 2 == 0) {
                set.add(i);
            }
        }
        subSet = (TreeSet<Integer>) set.subSet(608, true, 611, true);
        set.add(629);
        System.out.println(set + "" + subSet);

//        [606, 608, 610, 612, 629][608, 610]
    }

    // 这道题也是没什么好说的，就是考api，平常留心几个常用的api就可以了，
    // 其他的api需要的时候再去看
}
