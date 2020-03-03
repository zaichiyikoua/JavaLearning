package leetcode.part12;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记119
*	@author  zaichiyikoua
*	@time  2020年3月3日
*	@title  { 二叉搜索树中第K小的元素 }
*/

//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//示例 1:
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1
//示例 2:
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3
public class KthSmallestElementInABst {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 因为是特殊的二叉搜索树 根据二叉搜索树的特点进行观察
    // 将所有的左子树全部放进栈中，然后找到第K小的节点
    public int solution(TreeNode root, int k) {
        int res = 0;
        if (root == null) {
            return res;
        }
        // DFS
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            if (--k == 0) {
                res = curNode.val;
                break;
            }
            curNode = curNode.right;
        }
        return res;
    }
}
