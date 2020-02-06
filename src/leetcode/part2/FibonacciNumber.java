package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记19
*	@author  zaichiyikoua
*	@time  2020年2月6日
*	@title  { 斐波那契数 }
*/

//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//给定 N，计算 F(N)。
//示例 1：
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
//示例 2：
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
//示例 3：
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
//提示：
//0 ≤ N ≤ 30
public class FibonacciNumber {
    // 见过很多次了，需要注意循环条件，N > 1
    public int solution(int n) {
        if (n < 0) {
            return -1;
        }
        int[] fib = { 0, 1 };
        if (n < 2) {
            return fib[n];
        }
        // 初始化
        int firstNumber = fib[0];
        int secondNumber = fib[1];
        int resultNumber = 0;

        for (int i = 1; i < n; i++) {
            resultNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = resultNumber;
        }
        return resultNumber;
    }
}
