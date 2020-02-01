package leetcode.part1;

/*
*	leetCode算法刷题记录   笔记10
*	@author  zaichiyikoua
*	@time  2020年2月1日
*	@title  { 整数的各位积和之差 }
*/

//给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
//示例 1：
//输入：n = 234
//输出：15 
//解释：
//各位数之积 = 2 * 3 * 4 = 24 
//各位数之和 = 2 + 3 + 4 = 9 
//结果 = 24 - 9 = 15
//示例 2：
//输入：n = 4421
//输出：21
//解释： 
//各位数之积 = 4 * 4 * 2 * 1 = 32 
//各位数之和 = 4 + 4 + 2 + 1 = 11 
//结果 = 32 - 11 = 21
//提示：
//1 <= n <= 10^5
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    // 实际结果证明，第二种按照数学上的思路速度要快很多

    // 最简单的，转成字符串再操作,注意积，初始的时候是1，然后就是字符方法的调用
    public int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        // 积
        int product = 1;
        // 和
        int sum = 0;
        String num = String.valueOf(n);
        for (int i = 0; i < num.length(); i++) {
            product *= Integer.parseInt(num.substring(i, i + 1));
            sum += Integer.parseInt(num.substring(i, i + 1));
        }
        return product - sum;
    }

    // 这种就是偏数学上的方法来解决
    // 就是求出位数，然后计算
    public int solution2(int n) {
        if (n <= 0) {
            return 0;
        }
        // 积
        int product = 1;
        // 和
        int sum = 0;
        while (n != 0) {
            product *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return product - sum;
    }
}
