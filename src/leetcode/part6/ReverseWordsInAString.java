package leetcode.part6;

/*
*	leetCode算法刷题记录   笔记54
*	@author  zaichiyikoua
*	@time  2020年2月16日
*	@title  { 翻转字符串里的单词 }
*/

//给定一个字符串，逐个翻转字符串中的每个单词。
//示例 1：
//输入: "the sky is blue"
//输出: "blue is sky the"
//示例 2：
//输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//示例 3：
//输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//说明：
//无空格字符构成一个单词。
//输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
public class ReverseWordsInAString {
    // 使用builder来完成
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        // 去除首尾空格，拆成数组
        String[] split = s.trim().split(" ");
        // 倒序遍历
        for (int i = split.length - 1; i > 0; i--) {
            // 每个单词去除首尾空格
            String trim = split[i].trim();
            // 只要每个单词不是空
            if (!"".equals(trim)) {
                builder.append(trim);
                // 手动添加空格
                builder.append(" ");
            }
        }
        // 最后去除首尾空格
        return builder.toString().trim();
    }
}
