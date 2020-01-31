package leetcode.part1;

import java.util.HashSet;

/*
*	剑指offer面试题复习  笔记8
*	@author  zaichiyikoua
*	@time  2020年1月31日
*	@title  { 宝石与石头 }
*/

//给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。 S中每个字符代表了一种你拥有的石头的类型，
//你想知道你拥有的石头中有多少是宝石。
//J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
//示例 1:
//输入: J = "aA", S = "aAAbbbb"
//输出: 3
//示例 2:
//输入: J = "z", S = "ZZ"
//输出: 0
//注意:
//S和J最多含有50个字母。
//J 中的字符不重复。
public class JewelsAndStones {
    // 这道题思路很简单，用hashset保存J中的字母，遍历S串，找到相同类型的石头
    public int solution(String J, String S) {
        if (J == null || S == null || "".equals(J) || "".equals(S)) {
            return -1;
        }
        HashSet<Character> hashSet = new HashSet<Character>();
        // 计数器
        int countNumber = 0;
        // 先遍历J，将所有J中不重复的石头放进set中
        for (int i = 0; i < J.length(); i++) {
            hashSet.add(J.charAt(i));
        }
        // 如果匹配，则计数
        for (int i = 0; i < S.length(); i++) {
            if (hashSet.contains(S.charAt(i))) {
                countNumber++;
            }
        }
        return countNumber;
    }
}
