package codingInterviewByJava.past;

import java.util.HashMap;
import java.util.Map;

//面试题50（一）：字符串中第一个只出现一次的字符
//题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
//'b'。

public class FirstNotRepeatingChar {
    // 思路，使用hashmap key记录字符 value记录次数
    public char solution(String string) {
        if (string == null || string.equals("")) {
            return '\0';
        }
        char[] charArray = string.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // 两次遍历 第一遍记录次数
        for (char c : charArray) {
            if (!map.containsKey(c)) {
                // 初始化
                map.put(c, 1);
            }
            map.put(c, map.get(c) + 1);
        }
        // 第二次查找次数为1的字符，找到就返回
        for (char c : charArray) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }
}
