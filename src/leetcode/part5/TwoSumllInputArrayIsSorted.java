package leetcode.part5;

/*
*   leetCode算法刷题记录   笔记50
*   @author  zaichiyikoua
*   @time  2020年2月14日
*   @title  { 两数之和ll-输入有序数组 }
*/

//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//说明:
//返回的下标值（index1 和 index2）不是从零开始的。
//你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//示例:
//输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
public class TwoSumllInputArrayIsSorted {
    // 如果数组是无序的，那么可以用hashmap去解决，但是这里是有序的，那么就应该利用这个特点
    // 双指针法，首尾指针，向中间靠拢
    public int[] solution(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        // 要返回的数组
        int[] result = new int[2];
        // 首尾指针
        int headIndex = 0;
        int tailIndex = numbers.length - 1;
        // 遍历数组
        while (headIndex < tailIndex) {
            if (numbers[headIndex] == target - numbers[tailIndex]) {
                result[0] = headIndex + 1;
                result[1] = tailIndex + 1;
                return result;
            } else if (numbers[headIndex] < target - numbers[tailIndex]) {
                // 如果两个数的和比目标值小，那么调整首指针
                // 因为是排过序的数组，所以左边一定比右边小
                headIndex++;
            } else {
                // 调整尾指针
                tailIndex--;
            }
        }
        return result;
    }
}
