package leetcode.part8;

/*
*	leetCode算法刷题记录   笔记74
*	@author  zaichiyikoua
*	@time  2020年2月19日
*	@title  { 验证回文串 }
*/

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//说明：本题中，我们将空字符串定义为有效的回文串。
//示例 1:
//输入: "A man, a plan, a canal: Panama"
//输出: true
//示例 2:
//输入: "race a car"
//输出: false
public class ValidPalindrome {
    // 回文串，首先就想到对撞指针
    public boolean solution(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        // 因为是只考虑字母和数字字符，可以忽略字母的大小写的
        StringBuilder builder = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
        // 首尾对撞指针
        int head = 0;
        int tail = builder.length() - 1;
        while (head < tail) {
            if (builder.charAt(head++) != builder.charAt(tail--)) {
                return false;
            }
        }
        return true;
    }
}
