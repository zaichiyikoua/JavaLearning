package leetcode.part13;

/*
*	leetCode算法刷题记录   笔记127
*	@author  zaichiyikoua
*	@time  2020年3月5日
*	@title  { 盛水最多的容器 }
*/

//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//说明：你不能倾斜容器，且 n 的值至少为 2。
//图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//示例:
//输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
public class ContainerWithMostWater {
    // 双指针法 自己画图就很好理解
    public int solution(int[] height) {
        // 双指针初始化 首尾
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        // 对撞
        while (left < right) {
            // 找到对应的坐标判断 容积取决于高度和长度
            if (height[left] < height[right]) {
                // 计算，比较
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }
        }
        return maxArea;
    }
}
