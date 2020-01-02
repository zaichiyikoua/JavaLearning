package javaBasicExercises.part3;

/*
*	javaSE专项练习30
*	@author  zaichiyikoua
*	@time  2020年1月1日
*/

public class Coding30 {
    public static boolean foo(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
    }

    // ABDCBDCB
    // 这道题的考点在for循环中
    // for循环三条语句的执行顺序 for(第一条语句；第二条语句；第三条语句；)
    // 首次循环时先执行前两句。以后的每次循环结束，都是执行最后一条语句
    // 然后执行判断语句（也就是第二条语句）条件成立进入下一次循环。
    // 第一条语句只会被执行一次

}
