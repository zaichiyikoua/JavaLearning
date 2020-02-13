package leetcode.part5;

/*
*	leetCode算法刷题记录   笔记45
*	@author  zaichiyikoua
*	@time  2020年2月13日
*	@title  { 实现strStr() }
*/

//实现 strStr() 函数。
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//示例 1:
//输入: haystack = "hello", needle = "ll"
//输出: 2
//示例 2:
//输入: haystack = "aaaaa", needle = "bba"
//输出: -1
//说明:
//当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
public class ImplementStrstr {
    // 使用最简单快捷的偷懒办法，indexof
    public int solution(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
