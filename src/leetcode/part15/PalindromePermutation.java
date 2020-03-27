package leetcode.part15;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记141
*	@author  zaichiyikoua
*	@time  2020年3月27日
*	@title  { 回文排列 }
*/

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//回文串不一定是字典当中的单词。
//示例1：
//输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
public class PalindromePermutation {
    // 显然不能先求全排列再判断是否是回文的
    // 那么找到回文的规律 有且只有一个数出现一次，其他的所有数都出现两次
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 0) {
            return false;
        }
        char[] charArray = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        // 遍历字符数组
        for (char c : charArray) {
            if (!hashSet.add(c)) {
                hashSet.remove(c);
            }
        }
        // 最后只会保留中间的只出现一次的字符
        // 特殊值比如aa 所以应该是 <=1
        return hashSet.size() <= 1 ? true : false;
    }
}
