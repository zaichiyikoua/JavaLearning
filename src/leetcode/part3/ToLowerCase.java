package leetcode.part3;

/*
*	leetCode算法刷题记录   笔记24
*	@author  zaichiyikoua
*	@time  2020年2月7日
*	@title  { 转换成小写字母 }
*/

//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//示例 1：
//输入: "Hello"
//输出: "hello"
//示例 2：
//输入: "here"
//输出: "here"
//示例 3：
//输入: "LOVELY"
//输出: "lovely"
public class ToLowerCase {
    // 直接调用stringAPI，一行代码搞定
    public String solution(String string) {
        return string.toLowerCase();
    }
}
