package leetcode.part4;

import java.util.Arrays;

/*
*	leetCode算法刷题记录   笔记33
*	@author  zaichiyikoua
*	@time  2020年2月10日
*	@title  { 最小元素各数位之和 }
*/

//给你一个正整数的数组 A。
//然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
//最后，假如 S 所得计算结果是 奇数 的请你返回 0，否则请返回 1。
//示例 1:
//输入：[34,23,1,24,75,33,54,8]
//输出：0
//解释：
//最小元素为 1，该元素各个数位上的数字之和 S = 1，是奇数所以答案为 0。
//示例 2：
//输入：[99,77,33,66,55]
//输出：1
//解释：
//最小元素为 33，该元素各个数位上的数字之和 S = 3 + 3 = 6，是偶数所以答案为 1。
//提示：
//1 <= A.length <= 100
//1 <= A[i].length <= 100
public class SumOfDigitsInTheMinimumNumber {
    // 这道题思路很明确，找到最小值，计算位数和，判断奇偶返回
    public int solution(int[] A) {
        // 找最小值，排序之后的A[0]就是最小值
        Arrays.sort(A);
        int miniValue = A[0];
        // 计算位数和
        int sum = 0;
        while (miniValue != 0) {
            sum += miniValue % 10;
            miniValue /= 10;
        }
        // 判断sum的奇偶
        return sum % 2 == 0 ? 1 : 0;
    }
}
