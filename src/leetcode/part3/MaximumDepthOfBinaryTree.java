package leetcode.part3;

/*
*	leetCode算法刷题记录   笔记29
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  { 二叉树的最大深度 }
*/

//给定一个二叉树，找出其最大深度。
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//说明: 叶子节点是指没有子节点的节点。
//示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回它的最大深度 3 
public class MaximumDepthOfBinaryTree {
    // 对于树形结构，就是递归
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 得到子树的最大深度
        int leftMaxDepth = solution(root.left);
        int rightMaxDepth = solution(root.right);
        // 比较最大深度
        int max = Math.max(leftMaxDepth, rightMaxDepth);
        // 初始高度至少为1
        return max + 1;
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
