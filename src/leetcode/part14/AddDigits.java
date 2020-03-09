package leetcode.part14;

/*
*	leetCode算法刷题记录   笔记131
*	@author  zaichiyikoua
*	@time  2020年3月9日
*	@title  { 各位相加 }
*/

//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
//示例:
//输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
public class AddDigits {
    // 直接的思路，拿到和，计算
    public int solution(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
