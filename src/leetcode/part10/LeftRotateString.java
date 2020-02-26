package leetcode.part10;

/*
*	leetCode算法刷题记录   笔记97
*	@author  zaichiyikoua
*	@time  2020年2月26日
*	@title  { 左旋转字符串 }
*/

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
//示例 1：
//输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//示例 2：
//输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//限制：
//1 <= k < s.length <= 10000
public class LeftRotateString {
    public String solution(String s, int n) {
        // 1 <= k < s.length <= 10000，所以不再入值检测
        if (s == null || "".equals(s)) {
            return s;
        }
        // 没什么好说的，substring的使用
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(s.substring(n)).append(s.substring(0, n));
        return resultBuilder.toString();
    }
}
