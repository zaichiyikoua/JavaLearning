package leetcode.part4;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记34
*	@author  zaichiyikoua
*	@time  2020年2月10日
*	@title  { 删去字符串中的元音 }
*/

//给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
//示例 1：
//输入："leetcodeisacommunityforcoders"
//输出："ltcdscmmntyfrcdrs"
//示例 2：
//输入："aeiou"
//输出：""
//提示：
//S 仅由小写英文字母组成。
//1 <= S.length <= 1000
public class RemoveVowelsFromAString {
    //利用hashset和stringbuilder来处理
    public String solution(String S) {
        //初始化set，放进元音字母
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        //初始话builder
        StringBuilder builder = new StringBuilder();
        //遍历字符串
        for (int i = 0; i < S.length(); i++) {
            //判断是不是元音
            if (!set.contains(S.charAt(i))) {
                builder.append(S.charAt(i));
            }
        }
        return builder.toString();
    }
}
