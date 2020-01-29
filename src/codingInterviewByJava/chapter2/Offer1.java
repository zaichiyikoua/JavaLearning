package codingInterviewByJava.chapter2;

/*
*	剑指offer面试题复习  笔记
*	@author  zaichiyikoua
*	@time  2020年1月29日
*	@title  { 数值的整数次方 }
*/

//题目：实现函数double Power(double base, int exponent)，求base的exponent次方。
//不得使用库函数，同时不需要考虑大数问题。
public class Offer1 {
    // 思路1，递归实现
    // 不能使用库函数，但是思想一样的
    // (x*x)n/2可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
    public double solution(double base, int exponent) {
        // 输入值处理
        // 任何数的0次方都是1
        if (exponent == 0) {
            return 1;
        }
        // 任何数的1次方都是本身
        if (exponent == 1) {
            return base;
        }
        // 标志位，判断指数是否为负数
        boolean flag = false;
        // 如果为负数，可以先对指数求绝对值，算出次方的结果之后再取反
        if (exponent < 0) {
            // 取绝对值
            exponent = -exponent;
            flag = true;
        }
        // 计算过程
        double pow = solution(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        // 如果为负则取反
        return flag ? 1 / pow : pow;
    }

    // 思路2，暴力法
    // 但是输入值处理是和上面一样的
    public double solution2(double base, int exponent) {
        double result = 1.0;
        // 暴力法解决
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public double Power(double base, int exponent) {
        // 标志位
        boolean flag = false;
        if (exponent < 0 && base == 0.0) {
            flag = true;
            return 0.0;
        }
        // 任何数的0次方都是1
        if (exponent == 0) {
            return 1;
        }
        // 任何数的1次方都是本身
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }
        double result = solution2(base, exponent);
        if (flag) {
            result = 1 / result;
        }
        return result;
    }
}
