package leetcode.part8;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记75
*	@author  zaichiyikoua
*	@time  2020年2月19日
*	@title  { 翻转字符串中的元音字母 }
*/

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//示例 1:
//输入: "hello"
//输出: "holle"
//示例 2:
//输入: "leetcode"
//输出: "leotcede"
//说明:
//元音字母不包含字母"y"。
public class ReverseVowelsOfAString {
    // 首尾对撞指针
    public String solution(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        // 元音字母
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        // 转成数组
        char[] charArray = s.toCharArray();
        // 对撞指针初始化
        int headIndex = 0;
        int tailIndex = charArray.length - 1;
        while (headIndex < tailIndex) {
            // 注意，不要少了这个headIndex < tailIndex....不然会导致头指针到尾指针的后面
            while (headIndex < tailIndex && !set.contains(charArray[headIndex])) {
                headIndex++;
            }
            while (headIndex < tailIndex && !set.contains(charArray[tailIndex])) {
                tailIndex--;
            }
            // 此时找到了首尾是元音的字符，交换
            char temp = charArray[headIndex];
            charArray[headIndex] = charArray[tailIndex];
            charArray[tailIndex] = temp;
            // 移动指针
            headIndex++;
            tailIndex--;
        }
        return String.valueOf(charArray);
    }
}
