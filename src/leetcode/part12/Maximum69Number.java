package leetcode.part12;

/*
*	leetCode算法刷题记录   笔记118
*	@author  zaichiyikoua
*	@time  2020年3月3日
*	@title  { 6和9组成的最大数字 }
*/

//给你一个仅由数字 6 和 9 组成的正整数 num。
//你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//请返回你可以得到的最大数字。
//示例 1：
//输入：num = 9669
//输出：9969
//解释：
//改变第一位数字可以得到 6669 。
//改变第二位数字可以得到 9969 。
//改变第三位数字可以得到 9699 。
//改变第四位数字可以得到 9666 。
//其中最大的数字是 9969 。
//示例 2：
//输入：num = 9996
//输出：9999
//解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
//示例 3：
//输入：num = 9999
//输出：9999
//解释：无需改变就已经是最大的数字了。
//提示：
//1 <= num <= 10^4
//num 每一位上的数字都是 6 或者 9 。
public class Maximum69Number {
    // 简单直接的，找到最高位的6，变成9
    public int solution(int num) {
        // 进行转换
        char[] array = String.valueOf(num).toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // 找到第一个6，变成9
            if (array[i] == '6') {
                array[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(array));
    }
}
