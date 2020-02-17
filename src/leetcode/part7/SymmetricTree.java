package leetcode.part7;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记64
*	@author  zaichiyikoua
*	@time  2020年2月17日
*	@title  { 对称二叉树(迭代) }
*/

//给定一个二叉树，检查它是否是镜像对称的。
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//    1
//   / \
//  2   2
//   \   \
//   3    3
public class SymmetricTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 之前用的递归法，这次用迭代法
    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode1 = stack.pop();
            TreeNode currentNode2 = stack.pop();
            // 判断是否对称
            if (currentNode1 == null && currentNode2 == null) {
                // 都为空，是对称的，继续下一次遍历
                continue;
            }
            if (currentNode1 == null || currentNode2 == null) {
                return false;
            }
            if (currentNode1.val != currentNode2.val) {
                // 不对称
                return false;
            }
            // 当前左右对称，将子节点入栈
            stack.push(currentNode1.left);
            stack.push(currentNode2.right);
            stack.push(currentNode1.right);
            stack.push(currentNode2.left);
        }
        return true;
    }
}
