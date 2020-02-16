package leetcode.part6;

/*
*	leetCode算法刷题记录   笔记53
*	@author  zaichiyikoua
*	@time  2020年2月16日
*	@title  { 移动零 }
*/

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//示例:
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//说明:
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。
public class MoveZeroes {
    // 遍历数组，双指针，将不是零的数放在0-N-1位，然后将数组后部分全部设置位0
    public void solution(int[] nums) {
        if (nums == null || nums.length < 0) {
            return;
        }
        // 慢指针初始化
        int index = 0;
        // i就是快指针，遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // 将数组的后部分设置位0
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
