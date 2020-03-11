package leetcode.part14;

/*
*	leetCode算法刷题记录   笔记132
*	@author  zaichiyikoua
*	@time  2020年3月11日
*	@title  { 将数组分成和相等的三个部分 }
*/

//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
//示例 1：
//输出：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//示例 2：
//输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
//示例 3：
//输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//提示：
//3 <= A.length <= 50000
//-10^4 <= A[i] <= 10^4
public class PartitionArrayIntoThreePartsWithEqualSum {
    // 首先想到的就是对撞指针
    // 首尾部分的和相同的时候，中间部分肯定一样 这个时候已经找到了等分点
    public boolean solution(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int sum = 0;
        // 得到数组总和
        for (int i : A) {
            sum += i;
        }
        // 优化
        // 不是三的倍数直接返回
        if (sum % 3 != 0) {
            return false;
        }
        // 对撞指针 初始化
        int left = 0;
        int right = A.length - 1;
        int sumLeft = A[left];
        int sumRight = A[right];
        // 优化 left + 1 < right
        while (left + 1 < right) {
            if (sumLeft == sum / 3 && sumRight == sum / 3) {
                // 两头相等 中间一定相等
                return true;
            }
            if (sumLeft != sum / 3) {
                // 已经有了初始值 所以++left
                sumLeft += A[++left];
            }
            if (sumRight != sum / 3) {
                sumRight += A[--right];
            }
        }
        return false;
    }
}
