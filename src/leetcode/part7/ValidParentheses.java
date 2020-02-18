package leetcode.part7;

import java.util.HashMap;
import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记68
*	@author  zaichiyikoua
*	@time  2020年2月18日
*	@title  { 有效的括号 }
*/

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//示例 1:
//输入: "()"
//输出: true
//示例 2:
//输入: "()[]{}"
//输出: true
//示例 3:
//输入: "(]"
//输出: false
//示例 4:
//输入: "([)]"
//输出: false
//示例 5:
//输入: "{[]}"
//输出: true
public class ValidParentheses {
    // 用一个栈来保存(，[,{
    // 当遍历到这三个字符的时候，就将其保存到栈中。
    public boolean solution(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        // 使用hashmap来保存这三个符号
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        // 栈
        LinkedList<Character> stack = new LinkedList<Character>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            // 如果map中存在
            if (hashMap.containsKey(charAt)) {
                // 先判断stack是不是空
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // 比较栈顶元素和map中的元素
                if (topElement != hashMap.get(charAt)) {
                    return false;
                }
            } else {
                // map中没有，就放进栈中
                stack.push(charAt);
            }
        }
        // 最后只需要看栈是否为空，因为如果有效，两两会消掉，栈中不会存在元素
        return stack.isEmpty();
    }
}
