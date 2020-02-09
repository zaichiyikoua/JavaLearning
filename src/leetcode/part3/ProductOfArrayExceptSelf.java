package leetcode.part3;

/*
*	leetCode算法刷题记录   笔记30
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  { 除自身以外数组的乘积 }
*/

//给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//示例:
//输入: [1,2,3,4]
//输出: [24,12,8,6]
//说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
public class ProductOfArrayExceptSelf {
    // 这道题难在时间复杂度和数组中如果存在0的情况，题目中只要求求乘积，如果有0怎么办没说明
    // 那就当没有0处理
    // 将结果乘积分成左乘积和右乘积分别计算
    public int[] solution(int[] nums) {
        // 要返回的数组，进行初始化
        int[] result = new int[nums.length];
        // 初始化乘积
        int k = 1;
        // 从左向右遍历区间为[0,n)
        for (int i = 0; i < nums.length; i++) {
            // 返回数组每个位置保存左侧所有元素的乘积(除去了当前元素)
            result[i] = k;
            k *= nums[i];
        }
        // 重置为1
        k = 1;
        // 从右向左遍历，要注意区间
        for (int i = result.length - 1; i >= 0; i--) {
            // 当前位置的左积乘右积
            result[i] *= k;
            // 更新右积
            k *= nums[i];
        }
        return result;
    }
}
