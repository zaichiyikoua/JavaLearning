package leetcode.part5;

/*
*	leetCode算法刷题记录   笔记42
*	@author  zaichiyikoua
*	@time  2020年2月13日
*	@title  { 至少是其他数字两倍的最大数 }
*/

//在一个给定的数组nums中，总是存在一个最大元素 。
//查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
//如果是，则返回最大元素的索引，否则返回-1。
//示例 1:
//输入: nums = [3, 6, 1, 0]
//输出: 1
//解释: 6是最大的整数, 对于数组中的其他整数,
//6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
//示例 2:
//输入: nums = [1, 2, 3, 4]
//输出: -1
//解释: 4没有超过3的两倍大, 所以我们返回 -1.
//提示:
//nums 的长度范围在[1, 50].
//每个 nums[i] 的整数范围在 [0, 100].
public class LargestNumberAtLeastTwiceOfOthers {
    // 先找到数组中的最大元素，然后再判断数组中的每个元素是否大于
    public int solution(int[] nums) {
        if (nums == null) {
            return -1;
        }
        // 先找到最大值和最大值下标
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        // 然后遍历数组每个元素，进行判断
        for (int i = 0; i < nums.length; i++) {
            // 除maxvalue值以外的元素
            if (i != maxIndex && nums[i] * 2 > nums[maxIndex]) {
                return -1;
            }
        }
        return maxIndex;
    }
}
