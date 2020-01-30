package javaBasicExercises.part4;

/*
*	javaSE专项练习38
*	@author  zaichiyikoua
*	@time  2020年1月30日
*/

public class Coding38 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int m = 3, n = 4, x;
        x = -m++;
        x = x + 8 / ++n;
        System.out.println(x);

//        -2

        // 这道题考察运算优先级
        // /优先于++
    }

}
