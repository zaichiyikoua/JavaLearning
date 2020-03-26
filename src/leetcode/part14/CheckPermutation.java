package leetcode.part14;

import java.util.Arrays;

/*
*	leetCode算法刷题记录   笔记139
*	@author  zaichiyikoua
*	@time  2020年3月26日
*	@title  { 判定是否互为字符重排 }
*/

//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//示例 1：
//输入: s1 = "abc", s2 = "bca"
//输出: true 
//示例 2：
//输入: s1 = "abc", s2 = "bad"
//输出: false
//说明：
//0 <= len(s1) <= 100
//0 <= len(s2) <= 100
public class CheckPermutation {
    // 要能重新排列，说明s1和s2的字符应该是一样的
    public boolean solution(String s1, String s2) {
        // 转成数组
        char[] arrS1 = s1.toCharArray();
        char[] arrS2 = s2.toCharArray();
        // 比较长度，不一样就直接返回false
        if (arrS1.length != arrS2.length) {
            return false;
        }
        // 排序
        Arrays.sort(arrS1);
        Arrays.sort(arrS2);
        // 排序之后 遍历数组 判断字符是否一致
        for (int i = 0; i < arrS1.length; i++) {
            if (arrS1[i] != arrS2[i]) {
                return false;
            }
        }
        return true;
    }
}
