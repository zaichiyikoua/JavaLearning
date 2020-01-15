package leetcode.part1;

/*
*	leetCode算法刷题记录   笔记4
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 最长回文子串 }
*/

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//回文的意思是正着念和倒着念一样，如：上海自来水来自海上
//示例 1：
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//输入: "cbbd"
//输出: "bb"
public class LongestPalindromicSubstring {
    // 思路，双重遍历字符串，找到所有的子串，然后去判断是不是回文子串，再找到最长子串
    public String solution(String s) {
        if (s == null || s.length() <= 1) {
            return "";
        }
        String result = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String substring = s.substring(i, j);
                // 同时满足是回文子串，并且是最大子串
                if (isPalindromic(substring) && substring.length() > max) {
                    result = s.substring(i, j);
                    max = Math.max(max, result.length());
                }
            }
        }
        return result;
    }

    // 判断是不是回文子串
    public static boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
