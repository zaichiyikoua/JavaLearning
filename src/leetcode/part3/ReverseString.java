package leetcode.part3;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记21
*	@author  zaichiyikoua
*	@time  2020年2月6日
*	@title  { 反转字符串 }
*/

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
//示例 1：
//输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//示例 2：
//输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
public class ReverseString {
    // 这道题思路也很多
    // 因为是字符串的反转，可以用首尾指针，也可以用栈，这里我就用栈来完成
    // 这种因为会遍历两遍，所以会慢一些
    public void solution(char[] s) {
        if (s == null || s.length <= 0) {
            return;
        }
        LinkedList<Character> stackList = new LinkedList<Character>();
        // 先遍历数组，放进栈中
        for (int i = 0; i < s.length; i++) {
            stackList.push(s[i]);
        }
        // 然后遍历数组，进行赋值
        for (int i = 0; i < s.length; i++) {
            s[i] = stackList.pop();
        }
    }

    // 这里用首尾指针来完成，只需要遍历一遍，这样会快点
    public void solution2(char[] s) {
        if (s == null || s.length <= 0) {
            return;
        }
        // 初始化指针
        int headIndex = 0;
        int tailIndex = s.length - 1;
        char temp;
        while (headIndex < tailIndex) {
            // 反转
            temp = s[headIndex];
            s[headIndex] = s[tailIndex];
            s[tailIndex] = temp;
            // 移动指针
            headIndex++;
            tailIndex--;
        }
    }
}
