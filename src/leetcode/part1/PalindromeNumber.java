package leetcode.part1;

/*
*	leetCode算法刷题记录   笔记5
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 回文数 }
*/

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//示例 1:
//输入: 121
//输出: true
//示例 2:
//输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//示例 3:
//输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
public class PalindromeNumber {
    // 这道题已经在第四题中解答过一次了
    // 主要思路就是将数字转换成字符串，然后进行回文判断
    // 取出字符数组一半的元素，因为是回文的，所以左右两边是对称的
    public boolean solution(int x) {
        StringBuffer stringBuffer = new StringBuffer(x);
        for (int i = 0; i < stringBuffer.length() / 2; i++) {
            // 回文是对称的
            if (stringBuffer.charAt(i) != stringBuffer.charAt(stringBuffer.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 如果要求不能转换成字符串
    // 那么可以考虑将数字本身的一半反转(思路还是和上面一样的)，然后将反转之后的数字和原始数字进行比较
    // 不同的是，因为是数字，所以需要考虑一些临界条件
    public boolean solution2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    // 上面两种都是一个思路，只是限制条件不同
    // 这种解法是数学上的思路，可以通过取整和取余，得到首项和末项然后比较
    // 然后去掉首项和末项，重复以上操作，如果是回文的数字，那么首项和末项一定是相同的
    public boolean solution3(int x) {
        // 边界判断
        if (x < 0) {
            return false;
        }
        int div = 1;
        //
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            // 找到首项和末项不相等
            if (left != right) {
                return false;
            }
            // 去掉首项和末项
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
