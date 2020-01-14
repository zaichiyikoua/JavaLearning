package leetcode.part1;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记3
*	@author  zaichiyikoua
*	@time  2020年1月14日
*	@title  { 无重复字符的最长子串 }
*/

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//示例 1:
//输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

public class LongestSubstring {
    // 思路
    // 可以考虑使用快慢指针，遍历字符串，然后放进hashSet,快慢指针之间的距离就是最大长度
    // 快指针遇到重复项的时候，就将慢指针指向的项从set中删掉,然后移动慢指针
    public int solution(String s) {
        // 输入值检测
        if (s == null || s.length() <= 0 || s.equalsIgnoreCase("")) {
            // 官网输入值检测不满足条件希望返回0
            return 0;
        }

        HashSet<Character> set = new HashSet<Character>();
        int maxValue = 0;
        // 快慢指针
        int quickCursor = 0;
        int slowCursor = 0;

        // 遍历字符串
        while (quickCursor < s.length() && slowCursor < s.length()) {
            if (!set.contains(s.charAt(quickCursor))) {
                set.add(s.charAt(quickCursor));
                quickCursor++;
                maxValue = Math.max(maxValue, quickCursor - slowCursor);
            } else {
                set.remove(s.charAt(slowCursor));
                slowCursor++;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String string = "qrsvbspk";
        LongestSubstring longestSubstring = new LongestSubstring();
        int solution = longestSubstring.solution(string);
        System.out.println(solution);
    }
}
