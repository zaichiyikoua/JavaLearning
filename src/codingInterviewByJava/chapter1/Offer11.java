package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记11
*	@author  zaichiyikoua
*	@time  2020年1月28日
*	@title  { 青蛙跳台阶 }
*/

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
public class Offer11 {
    // 如果只有一级台阶，那么只有一种方法
    // 如果有两级台阶，那么可以跳一次，也可以跳两次
    // 如果有三级台阶，那么可以跳三次，也可以跳两次，还可以跳两次
    // 那么规律就是跳n级台阶，可以跳1阶，再跳n-1阶;或者跳两阶，再跳n-2阶
    // 可以发现这也是一个递归的过程
    public int solution(int value) {
        // 输入值检测
        if (value < 0) {
            return -1;
        }
        // 和斐波那契数列一样的
        int[] jump = { 1, 2 };
        if (value <= 2) {
            return jump[value];
        }
        // 初始化
        int jumpOne = jump[0];
        int jumpTwo = jump[1];
        // 返回值初始化
        int result = 0;
        for (int i = 0; i < value; i++) {
            result = jumpOne + jumpTwo;
            jumpOne = jumpTwo;
            jumpTwo = result;
        }

        return result;
    }
}
