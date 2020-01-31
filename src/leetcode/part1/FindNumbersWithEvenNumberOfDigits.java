package leetcode.part1;

/*
*	剑指offer面试题复习  笔记9
*	@author  zaichiyikoua
*	@time  2020年1月31日
*	@title  { 统计位数为偶数的数字 }
*/

//给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
//示例 1：
//输入：nums = [12,345,2,6,7896]
//输出：2
//解释：
//12 是 2 位数字（位数为偶数） 
//345 是 3 位数字（位数为奇数）  
//2 是 1 位数字（位数为奇数） 
//6 是 1 位数字 位数为奇数） 
//7896 是 4 位数字（位数为偶数）  
//因此只有 12 和 7896 是位数为偶数的数字
//示例 2：
//输入：nums = [555,901,482,1771]
//输出：1 
//解释： 
//只有 1771 是位数为偶数的数字。
//提示：
//1 <= nums.length <= 500
//1 <= nums[i] <= 10^5
public class FindNumbersWithEvenNumberOfDigits {
    // 这个和位数有关，那么就很自然的想到去%10，求出位数，再求位数是否为偶数
    public int solution(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        // 需要返回的计数器初始化
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 计数器，记录除以10的次数
            int countTenNumber = 0;
            while (nums[i] != 0) {
                nums[i] /= 10;
                countTenNumber++;
            }
            // 记录偶数,只要位数是偶数就进行记录
            if (countTenNumber % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 方法2，转换成字符串再进行操作，这样会简单一些
    public int solution2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 位数为偶数
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
