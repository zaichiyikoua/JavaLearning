package leetcode.part5;

/*
*	leetCode算法刷题记录   笔记47
*	@author  zaichiyikoua
*	@time  2020年2月14日
*	@title  { 对称二叉树 }
*/

//给定一个二叉树，检查它是否是镜像对称的。
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//    1
//   / \
//  2   2
//   \   \
//   3    3
public class SymmetricTree {
    // 递归法解决
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return detail(root.left, root.right);
    }

    public boolean detail(TreeNode node1, TreeNode node2) {
        // 两个节点都是空，必定对称
        if (node1 == null && node2 == null) {
            return true;
        }
        // 只要有一个空，一个不空，必定不对称
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val) && detail(node1.left, node2.right) && detail(node1.right, node2.left);
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
