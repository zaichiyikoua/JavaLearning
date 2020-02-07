package leetcode.part3;

/*
*	leetCode算法刷题记录   笔记22
*	@author  zaichiyikoua
*	@time  2020年2月7日
*	@title  { 分割平衡字符串 }
*/

//在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//返回可以通过分割得到的平衡字符串的最大数量。
//示例 1：
//输入：s = "RLRRLLRLRL"
//输出：4
//解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//示例 2：
//输入：s = "RLLLLRRRLR"
//输出：3
//解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//示例 3：
//输入：s = "LLLLRRRR"
//输出：1
//解释：s 只能保持原样 "LLLLRRRR".
//提示：
//1 <= s.length <= 1000
//s[i] = 'L' 或 'R'
public class SplitAStringInBalancedStrings {
    // 因为这个字符串中只有L/R，那么遍历该串，记录L或者R的数量，遍历到不是这个值的时候数量减1
    // 当数量为0的时候，就是分割成了一个平衡字符串，然后计数即可
    public int solution(String s) {
        if (s == null || s.length() < 0) {
            return 0;
        }
        // 初始化计数
        int result = 0;
        int sumCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            // L/R这里都可以的
            if (s.charAt(i) == 'L') {
                sumCounter++;
            } else {
                sumCounter--;
            }
            if (sumCounter == 0) {
                result++;
            }
        }
        return result;
    }
}
