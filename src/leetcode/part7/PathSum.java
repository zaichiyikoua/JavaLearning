package leetcode.part7;

/*
*	leetCode算法刷题记录   笔记65
*	@author  zaichiyikoua
*	@time  2020年2月17日
*	@title  { 路径总和 }
*/

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//说明: 叶子节点是指没有子节点的节点。
//示例: 
//给定如下二叉树，以及目标和 sum = 22，
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归法
    private boolean flag = false;

    public boolean solution(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 当前的和，初始化为0
        int currentValue = 0;
        detail(root, sum, currentValue);
        return flag;
    }

    public void detail(TreeNode node, int sum, int cur) {
        if (node == null) {
            return;
        }
        cur += node.val;
        if (node.left == null && node.right == null) {
            if (cur == sum) {
                flag = true;
            }
        }
        detail(node.left, sum, cur);
        detail(node.right, sum, cur);
    }
}
