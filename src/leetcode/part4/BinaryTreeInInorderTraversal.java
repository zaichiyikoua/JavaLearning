package leetcode.part4;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记39
*	@author  zaichiyikoua
*	@time  2020年2月11日
*	@title  { 二叉树的中序遍历 }
*/

//给定一个二叉树，返回它的中序 遍历。
//示例:
//输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//输出: [1,3,2]
public class BinaryTreeInInorderTraversal {
    // 经典的 树的深度优先遍历之中序遍历
    public List<Integer> solution(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        detail(root, list);
        return list;
    }

    // 二叉树中序遍历顺序 左节点 根 右节点
    public List<Integer> detail(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                detail(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                detail(node.right, list);
            }
        }
        return list;
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
