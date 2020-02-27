package leetcode.part11;

/*
*	leetCode算法刷题记录   笔记106
*	@author  zaichiyikoua
*	@time  2020年2月27日
*	@title  { Excel表列序号 }
*/

//给定一个Excel表格中的列名称，返回其相应的列序号。
//例如，
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
//示例 1:
//输入: "A"
//输出: 1
//示例 2:
//输入: "AB"
//输出: 28
//示例 3:
//输入: "ZY"
//输出: 701
public class ExcelSheetColumnNumber {
    // 这道题其实也是一道进制转换的题
    public int solution(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        // 初始化
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            // 将每个字母与A做减法
            int cur = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + cur;
        }
        return sum;
    }
}
