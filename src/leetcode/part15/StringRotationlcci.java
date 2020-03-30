package leetcode.part15;

/*
*	leetCode算法刷题记录   笔记143
*	@author  zaichiyikoua
*	@time  2020年3月30日
*	@title  { 字符串轮转lcci }
*/

//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//示例1:
// 输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//示例2:
// 输入：s1 = "aa", "aba"
// 输出：False
//提示：
//字符串长度在[0, 100000]范围内。
public class StringRotationlcci {
    // 如果s2是s1的子串，那么s2必定在s1+s1的字符串中存在
    public boolean isFlipedString(String s1, String s2) {
        // 长度不一样直接返回false
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        // 有翻转
        StringBuilder stringBuilder = new StringBuilder(s1);
        stringBuilder.append(s1);
        // 或者 s1+=s1
        return stringBuilder.toString().contains(s2);
    }
}
