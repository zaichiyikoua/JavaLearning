package leetcode.part6;

/*
*	leetCode算法刷题记录   笔记51
*	@author  zaichiyikoua
*	@time  2020年2月14日
*	@title  { 旋转数组 }
*/

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//示例 1:
//输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//说明:
//尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
//要求使用空间复杂度为 O(1) 的 原地 算法。
public class RotateArray {
    // 三次旋转，第一次全部倒转，第二次倒转0->k-1的，第三次倒转k->nums.length -1
    // 当我们旋转数组k次， k%n个尾部元素会被移动到头部，剩下的元素会被向后移动
    public void solution(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
