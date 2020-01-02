package javaBasicExercises.part3;

import java.util.Arrays;

/*
*	javaSE专项练习25
*	@author  zaichiyikoua
*	@time  2019年12月27日
*/

public class Coding26 {
//	关于Java中的数组，下面的一些描述，哪些描述是准确的：(		)
    // A.数组是一个对象，不同类型的数组具有不同的类
    // B.数组长度是可以动态调整的
    // C.数组是一个连续的存储结构
    // D.一个固定长度的数组可类似这样定义: int array[100]
    // E.两个数组用equals方法比较时，会逐个便利其中的元素，对每个元素进行比较
    // F.可以二维数组，且可以有多维数组，都是在Java中合法的

    // 答案 A C F

    // 关于E选项的验证
    public static void main(String[] args) {
        int[] arrOne = { 1, 2, 3, 4, 5 };
        int[] arrTwo = { 1, 2, 3, 4, 5 };

        System.out.println(arrOne.equals(arrTwo));// false
        System.out.println(Arrays.equals(arrOne, arrTwo));// true

        // 这里要注意，数组是一种引用数据类型
        // 那么他肯定是继承Object类的 所以里面有equals() 方法 但是肯定没有重写过
        // 使用Arrays.equals() 是比较两个数组中的内容。
    }
}
