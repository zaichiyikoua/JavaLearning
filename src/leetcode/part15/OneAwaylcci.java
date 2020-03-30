package leetcode.part15;

/*
*	leetCode算法刷题记录   笔记145
*	@author  zaichiyikoua
*	@time  2020年3月30日
*	@title  { 一次编辑 }
*/

//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//示例 1:
//输入: 
//first = "pale"
//second = "ple"
//输出: True
//示例 2:
//输入: 
//first = "pales"
//second = "pal"
//输出: False
public class OneAwaylcci {
    //
    public boolean oneEditAway(String first, String second) {
        // 入值检测
        if (first == null || second == null) {
            return false;
        }
        // 字符数量不满足一次编辑的条件
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // len1为长字符串长度，len2为短字符串长度
        int len1 = Math.max(first.length(), second.length());
        int len2 = Math.min(first.length(), second.length());
        // mark为false指代状态1，true指代状态2
        boolean mark = false;

        // 由于len2<=len1,只需判断i2<len2即可
        for (int i1 = 0, i2 = 0; i2 < len2; i1++) {
            if (first.charAt(i1) != second.charAt(i2)) {
                if (mark) {
                    return false;
                } else {
                    mark = true;
                    // 1->2的两种转换
                    i2 += (len1 - len2 == 1) ? 0 : 1;
                }
            } else
                i2++;
        }
        return true;
    }
}
