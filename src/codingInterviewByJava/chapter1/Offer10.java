package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记10
*	@author  zaichiyikoua
*	@time  2020年1月22日
*	@title  { 斐波那契数列 }
*/

//题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
public class Offer10 {
    // 思路，可以考虑递归实现
    // 不过那样比较耗费资源，所以可以考虑用循环实现
    public int solution(int value) {
        int[] result = { 1, 2 };
        if (value <= 2) {
            return result[value];
        }
        // 初始化
        int FibonacciOne = result[0];
        int FibonacciTwo = result[1];
        int FibonacciThree = 0;

        for (int i = 0; i < value; i++) {
            FibonacciThree = FibonacciOne + FibonacciTwo;
            // 向后移动
            FibonacciOne = FibonacciTwo;
            FibonacciTwo = FibonacciThree;
        }

        return FibonacciThree;
    }
}
