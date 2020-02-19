package leetcode.part8;

import java.util.HashMap;
import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记71
*	@author  zaichiyikoua
*	@time  2020年2月19日
*	@title  { 字符串中的第一个唯一字符 }
*/

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//案例:
//s = "leetcode"
//返回 0.
//s = "loveleetcode",
//返回 2.
public class FirstUniqueCharacterInAString {
    // 用map来记录字符和出现的次数
    public int solution(String s) {
        if ("".equals(s) || s == null) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // 遍历字符串，记录次数
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 然后再遍历，找到次数为1的字符，返回索引
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
