package leetcode.part5;

/*
*	leetCode算法刷题记录   笔记49
*	@author  zaichiyikoua
*	@time  2020年2月14日
*	@title  { 最长公共前缀 }
*/

//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
//示例 1:
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//说明:
//所有输入只包含小写字母 a-z 。
public class LongestCommonPrefix {
    // 拿第一个元素作为标记，遍历数组，去比较，比较一次减少末尾的一个字符
    public String solution(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        // 取得元素
        String prefix = strs[0];
        // 遍历数组，这里注意i从1开始
        for (int i = 1; i < strs.length; i++) {
            // 遍历数组中的元素，求出公共部分
            while (strs[i].indexOf(prefix) != 0) {
                // 每次减去末尾字符
                prefix = prefix.substring(0, prefix.length() - 1);
                // 如果没有公共前缀
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
