package leetcode.part13;

/*
*	leetCode算法刷题记录   笔记121
*	@author  zaichiyikoua
*	@time  2020年3月4日
*	@title  { 相同的树 }
*/

//给定两个二叉树，编写一个函数来检验它们是否相同。
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//示例 1:
//输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//示例 2:
//输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//示例 3:
//输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
public class SameTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 直觉上肯定就是用递归了，两个树同时迭代还要判断值不太方便
    public boolean solution(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // 值是否相同，以及后继节点
        return p.val == q.val && solution(p.left, q.left) && solution(p.right, q.right);
    }
}
