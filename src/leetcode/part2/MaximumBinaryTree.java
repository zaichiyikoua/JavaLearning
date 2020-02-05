package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记13
*	@author  zaichiyikoua
*	@time  2020年2月5日
*	@title  { 最大二叉树 }
*/

//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//二叉树的根是数组中的最大元素。
//左子树是通过数组中最大值左边部分构造出的最大二叉树。
//右子树是通过数组中最大值右边部分构造出的最大二叉树。
//通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//提示：
//给定的数组的大小在 [1, 1000] 之间。
public class MaximumBinaryTree {
    // 基本上处理树形结构，都是用递归更合适
    // 这道题的关键就是在数组中找到最大值，然后左右子树递归再找最大值，生成二叉树
    public TreeNode solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    // 处理
    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        // 输入检测
        if (left > right) {
            return null;
        }
        // 最大值和对应的坐标，初始为数组的最左值
        int MaxValue = nums[left];
        int MaxValueIndex = left;
        // 找出数组中的最大值，记录它的值和坐标
        for (int i = left; i < right; i++) {
            if (nums[i] > MaxValue) {
                MaxValue = nums[i];
                MaxValueIndex = i;
            }
        }
        // 生成节点
        TreeNode root = new TreeNode(MaxValue);
        // 生成子节点，递归调用
        root.left = constructMaximumBinaryTree(nums, left, MaxValueIndex);
        root.right = constructMaximumBinaryTree(nums, MaxValueIndex + 1, right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
