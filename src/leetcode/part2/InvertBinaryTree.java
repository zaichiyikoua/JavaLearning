package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记15
*	@author  zaichiyikoua
*	@time  2020年2月5日
*	@title  { 翻转二叉树 }
*/

//翻转一棵二叉树。
public class InvertBinaryTree {
    // 这道题第一时间想到的就是递归
    public TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换，也就是翻转
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 递归
        solution(root.left);
        solution(root.right);
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
