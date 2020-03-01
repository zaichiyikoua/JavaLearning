package leetcode.part11;

/*
*	leetCode算法刷题记录   笔记110
*	@author  zaichiyikoua
*	@time  2020年3月1日
*	@title  { 最后一个单词的长度 }
*/

//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
//如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//如果不存在最后一个单词，请返回 0 。
//说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
//示例:
//输入: "Hello World"
//输出: 5
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        // 从后向前遍历，找到空格即可
        // 计数
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                // 从第一个不是空格的字符开始计数
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
