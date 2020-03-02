package leetcode.part12;

/*
*   leetCode算法刷题记录   笔记115
*   @author  zaichiyikoua
*   @time  2020年3月2日
*   @title  { 按奇偶排序数组 }
*/

//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//你可以返回满足此条件的任何数组作为答案。
//示例：
//输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//提示：
//1 <= A.length <= 5000
//0 <= A[i] <= 5000
public class SortArrayByParity {
    // 对撞指针 直接在原数组上修改
    public int[] solution(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            // 找到左边为奇数的
            while (left < right && A[left] % 2 == 0) {
                left++;
            }
            // 找到右边为偶数的
            while (left < right && A[right] % 2 != 0) {
                right--;
            }
            // 交换
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            // 移动指针
            left++;
            right--;
        }
        return A;
    }
}
