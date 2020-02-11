package leetcode.part4;

/*
*	leetCode算法刷题记录   笔记38
*	@author  zaichiyikoua
*	@time  2020年2月11日
*	@title  { 翻转字符串里的单词ll }
*/

//给定一个字符串，逐个翻转字符串中的每个单词。
//示例：
//输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
//注意：
//单词的定义是不包含空格的一系列字符
//输入字符串中不会包含前置或尾随的空格
//单词与单词之间永远是以单个空格隔开的
public class ReverseWordsInAStringll {
    // 用首尾指针，向中间遍历，交换值
    // 第一次全部翻转，第二次翻转单词
    public void solution(char[] s) {
        if (s == null || s.length < 0) {
            return;
        }
        // 第一次翻转
        reverseDetail(s, 0, s.length - 1);
        // 第二次翻转
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseDetail(s, start, i - 1);
                // 移动指针
                start = i + 1;
            }
        }
        // 翻转最后一个单词
        reverseDetail(s, start, s.length - 1);
    }

    public void reverseDetail(char[] s, int start, int end) {
        char temp;
        // 遍历数组
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            // 移动指针
            start++;
            end--;
        }
    }
}
