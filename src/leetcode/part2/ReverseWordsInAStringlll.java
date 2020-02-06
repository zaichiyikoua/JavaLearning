package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记20
*	@author  zaichiyikoua
*	@time  2020年2月6日
*	@title  { 翻转字符串中的单词lll }
*/

//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//示例 1:
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
//注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
public class ReverseWordsInAStringlll {
    // 这道题的思路大体都一致，就是先将字符串按空格分割，然后再翻转字符
    // 但是处理手段有很多种，这里使用我最喜欢的builder/buffer来解决
    // 虽然更喜欢这种，但是这种好像有点慢
    // 还可以用栈来实现翻转
    public String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 临时保存用
        StringBuilder builder = new StringBuilder();
        // 返回
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
            } else {
                // 按空格分割完成之后，翻转
                resultString.append(builder.reverse());
                // 再用空格隔开
                resultString.append(' ');
                // 重置builder
                builder.setLength(0);
            }
        }
        resultString.append(builder.reverse());
        return resultString.toString();
    }
}
