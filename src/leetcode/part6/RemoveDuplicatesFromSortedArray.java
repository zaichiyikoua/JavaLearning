package leetcode.part6;

/*
*	leetCode算法刷题记录   笔记52
*	@author  zaichiyikoua
*	@time  2020年2月14日
*	@title  { 删除排序数组中的重复项}
*/

//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//示例 1:
//给定数组 nums = [1,1,2], 
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//你不需要考虑数组中超出新长度后面的元素。
//示例 2:
//给定 nums = [0,0,1,1,1,2,2,3,3,4],
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//你不需要考虑数组中超出新长度后面的元素
public class RemoveDuplicatesFromSortedArray {
    // 这道题我都理解错了，以为还要删除之后移动元素
    // 官方题解的意思是快慢指针，直接覆盖掉就ok了
    public int solution(int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        // 初始化快慢指针
        int index = 0;// 慢指针
        for (int i = 1; i < nums.length; i++) {
            // 相等时会直接跳过，不相等时覆盖
            if (nums[index] != nums[i]) {
                // 移动index
                index++;
                // 覆盖掉
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
