package leetcode.part15;

/*
*	leetCode算法刷题记录   笔记148
*	@author  zaichiyikoua
*	@time  2020年4月6日
*	@title  { 不用加减乘除做加法 }
*/

//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//示例:
//输入: a = 1, b = 1
//输出: 2
//提示：
//a, b 均可能是负数或 0
//结果不会溢出 32 位整数
public class AddTwoNumberWithoutFourArithmetic {
    // 偷懒法 直接调api
    public int add(int a, int b) {
        return Math.addExact(a, b);
    }
}
