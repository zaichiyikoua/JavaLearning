package leetcode.part4;

/*
*	leetCode算法刷题记录   笔记
*	@author  zaichiyikoua
*	@time  2020年2月10日
*	@title  { 阿姆斯特朗数 }
*/

//假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
//给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
//示例 1：
//输入：153
//输出：true
//示例： 
//153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
//示例 2：
//输入：123
//输出：false
//解释： 
//123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
//提示：
//1 <= N <= 10^8
public class ArmstrongNumber {
    // 首先得到它的位数，然后得到它的各位数，调用Math.pow()方法来计算指数
    public boolean solution(int N) {
        // 得到它的位数
        int length = String.valueOf(N).length();
        // 这里要注意，不要使用原值，不然之后判断相等会出错
        int n = N;
        int sum = 0;
        while (n != 0) {
            sum += (int) Math.pow(n % 10, length);
            n /= 10;
        }
        if (N == sum) {
            return true;
        }
        return false;
    }
}
