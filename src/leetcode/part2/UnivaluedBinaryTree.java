package leetcode.part2;

/*
*	leetCode算法刷题记录   笔记16
*	@author  zaichiyikoua
*	@time  2020年2月5日
*	@title  { 单值二叉树 }
*/

//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//示例 1：
//输入：[1,1,1,1,1,null,1]
//输出：true
//示例 2：
//输入：[2,2,2,5,2]
//输出：false
//提示：
//给定树的节点数范围是 [1, 100]。
//每个节点的值都是整数，范围为 [0, 99] 。
public class UnivaluedBinaryTree<E> {
    // 思路就是记录根节点的值，然后遍历该树，只要子树的值不等于根节点的值
    // 修改标志位，然后返回
    int value;
    boolean flag = true;

    public boolean solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        value = root.val;
        detail(root);
        return flag;
    }

    public void detail(TreeNode node) {
        // 空节点直接返回
        if (node == null) {
            return;
        }
        // 只要与根节点的值不一样，修改标志
        if (node.val != value) {
            flag = false;
            return;
        }
        detail(node.left);
        detail(node.right);
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
