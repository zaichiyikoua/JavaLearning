package leetcode.part14;

/*
*	leetCode算法刷题记录   笔记140
*	@author  zaichiyikoua
*	@time  2020年3月26日
*	@title  { URL化 }
*/

//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
//示例1:
// 输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
//示例2:
// 输入："               ", 5
// 输出："%20%20%20%20%20"
//提示：
//字符串长度在[0, 500000]范围内。
public class StringToUrl {
    // length是S的长度 这题就是以前做过的字符替换
    public String replaceSpaces(String S, int length) {
        char[] charArray = S.toCharArray();
        // 使用builder
        StringBuilder builder = new StringBuilder();
        // 遍历数组，进行判断
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                builder.append("%20");
            } else {
                builder.append(charArray[i]);
            }
        }
        return builder.toString();
    }
}
