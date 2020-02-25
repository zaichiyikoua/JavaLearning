package leetcode.part10;

import java.util.ArrayList;

/*
*	leetCode算法刷题记录   笔记94
*	@author  zaichiyikoua
*	@time  2020年2月25日
*	@title  { 解压缩编码列表 }
*/

//给你一个以行程长度编码压缩的整数列表 nums 。
//考虑每对相邻的两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
//请你返回解压后的列表。
//示例：
//输入：nums = [1,2,3,4]
//输出：[2,4,4,4]
//解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
//第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
//最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
//提示：
//2 <= nums.length <= 100
//nums.length % 2 == 0
//1 <= nums[i] <= 100
public class DecompressRunLengthEncodedList {
    public int[] solution(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        // 每两个数为一组就行，也就是每次+2
        for (int i = 0; i < nums.length; i += 2) {
            // 取决于nums[i]的值
            for (int j = 0; j < nums[i]; j++) {
                resultList.add(nums[i + 1]);
            }
        }
        // 生成数组
        int[] res = new int[resultList.size()];
        int index = 0;
        for (Integer integer : resultList) {
            res[index++] = integer;
        }
        return res;
    }
}
